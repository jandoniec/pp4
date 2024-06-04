package pl.jandoniec.ecommerce.catalog.sales;

import pl.jandoniec.ecommerce.catalog.sales.cart.Cart;
import pl.jandoniec.ecommerce.catalog.sales.cart.CartStorage;
import pl.jandoniec.ecommerce.catalog.sales.offering.Offer;
import pl.jandoniec.ecommerce.catalog.sales.offering.OfferCalculator;
import pl.jandoniec.ecommerce.catalog.sales.payment.PaymentDetails;
import pl.jandoniec.ecommerce.catalog.sales.payment.PaymentGateway;
import pl.jandoniec.ecommerce.catalog.sales.payment.RegisterPaymentRequest;
import pl.jandoniec.ecommerce.catalog.sales.reservation.AcceptOfferRequest;
import pl.jandoniec.ecommerce.catalog.sales.reservation.Reservation;
import pl.jandoniec.ecommerce.catalog.sales.reservation.ReservationDetails;
import pl.jandoniec.ecommerce.catalog.sales.reservation.ReservationRepository;

import java.util.UUID;

public class SalesFacade {
    private CartStorage cartStorage;
    private OfferCalculator offerCalculator;
    private PaymentGateway paymentGateway;
    private ReservationRepository reservationRepository;

    public SalesFacade(CartStorage cartStorage, OfferCalculator offerCalculator, PaymentGateway paymentGateway, ReservationRepository reservationRepository) {
        this.cartStorage = cartStorage;
        this.offerCalculator=offerCalculator;
        this.reservationRepository=reservationRepository;
        this.paymentGateway=paymentGateway;

    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart=cartStorage.getForCustomer(customerId)
                .orElse(Cart.empty());
        Offer offer=offerCalculator.calculate(cart.getItems());
        return offer;
    }

    public void addProduct(String customerId, String productId) {
        Cart cart = getCartForCustomer(customerId);

        cart.addProduct(productId);

    }
    private Cart getCartForCustomer(String customerId) {
        return cartStorage.getForCustomer(customerId)
                .orElse(Cart.empty());
    }




    public ReservationDetails acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        String reservationId=UUID.randomUUID().toString();
        Offer offer =this.getCurrentOffer(customerId);
        PaymentDetails paymentDetails=paymentGateway.registerPayment(RegisterPaymentRequest.of(reservationId,acceptOfferRequest,offer.getTotal()));
        Reservation reservation=Reservation.of(reservationId,customerId,acceptOfferRequest,offer,paymentDetails);
        reservationRepository.add(reservation);
        return new ReservationDetails(reservationId,paymentDetails.getPaymentUrl());
    }

}