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
        Cart cart=loadCartForCustomer(customerId);
        return OfferCalculator.calculate(cart.getItems());
    }

    public ReservationDetails acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        String reservationId=UUID.randomUUID().toString();
        Offer offer =this.getCurrentOffer(customerId);
        PaymentDetails paymentDetails=paymentGateway.registerPayment(RegisterPaymentRequest.of(reservationId,acceptOfferRequest,offer.getTotal()));
        Reservation reservation=Reservation.of(reservationId,customerId,acceptOfferRequest,offer,paymentDetails);
        reservationRepository.add(reservation);
        return new ReservationDetails(reservationId,paymentDetails.getPaymentUrl());
    }
    public void addProduct(String customerId, String productId) {
        Cart cart = loadCartForCustomer(customerId);

        cart.addProduct(productId);

    }
    private Cart loadCartForCustomer(String customerId) {
        return cartStorage.findByCustomer(customerId)
                .orElse(Cart.empty());
    }







}