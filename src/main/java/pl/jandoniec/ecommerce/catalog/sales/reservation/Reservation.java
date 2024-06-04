package pl.jandoniec.ecommerce.catalog.sales.reservation;

import pl.jandoniec.ecommerce.catalog.sales.offering.Offer;
import pl.jandoniec.ecommerce.catalog.sales.payment.PaymentDetails;

import java.math.BigDecimal;
import java.time.Instant;

public class Reservation {
    private final BigDecimal total;
    private Instant paidAt;
    private final String reservationId;
    private final CustomerDetails customerDetails;


    public Reservation(String reservationId,CustomerDetails customerDetails,BigDecimal total){
        this.reservationId=reservationId;
        this.customerDetails = customerDetails;
        this.total=total;
    }
    public static  Reservation of(String reservationId, String customerId, AcceptOfferRequest acceptOfferRequest, Offer offer, PaymentDetails paymentDetails){
        return new Reservation(reservationId,
                new CustomerDetails(customerId,acceptOfferRequest.getFirstName(),acceptOfferRequest.getLastName(),acceptOfferRequest.getEmail()),
                offer.getTotal());
    }
    public boolean isPending() {

        return paidAt==null;
    }

    public CustomerDetails getCustomerDetails() {

        return null;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getId() {
        return  reservationId;
    }
}