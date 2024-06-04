package pl.jandoniec.ecommerce.catalog.sales.reservation;
import java.math.BigDecimal;


public class ReservationDetails {
    private final String reservationId;
    private final String paymentUrl;
    public ReservationDetails(String reservationId,String paymentUrl){
        this.reservationId=reservationId;
        this.paymentUrl=paymentUrl;

    }



    public BigDecimal getTotal() {
        return BigDecimal.ZERO;

    }

    public Object getReservationId() {
        return reservationId;
    }



    public String getPaymentUrl() {
        return paymentUrl;
    }

}