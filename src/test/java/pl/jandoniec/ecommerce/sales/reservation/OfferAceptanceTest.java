package pl.jandoniec.ecommerce.sales.reservation;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jandoniec.ecommerce.catalog.sales.cart.CartStorage;
import pl.jandoniec.ecommerce.catalog.sales.reservation.*;
import pl.jandoniec.ecommerce.catalog.sales.offering.OfferCalculator;
import pl.jandoniec.ecommerce.catalog.sales.SalesFacade;

import java.math.BigDecimal;

public class OfferAcceptanceTest {
    private SpyPaymentGateway spyPaymentGateway;
    private ReservationRepository reservationRepository;
    @BeforeEach
    void setUp(){
        spyPaymentGateway=new SpyPaymentGateway();
        reservationRepository=new ReservationRepository();
    }

    @Test
    void itAllowsToAcceptOffer(){
        SalesFacade sales=thereIsSales();
        String customerId=thereIsCustomer("juangrande");
        String productId=thereIsProduct("x", BigDecimal.valueOf(10));
        sales.addProduct(customerId,productId);
        sales.addProduct(customerId,productId);
        var acceptOfferRequest = new AcceptOfferRequest();
        acceptOfferRequest
                .setFirstName("jan")
                .setLastName("kowalski")
                .setEmail("je@example.com");
        ReservationDetails reservationDetails=sales.acceptOffer(customerId,acceptOfferRequest);
        assertThat(reservationDetails.getPaymentUrl()).isNotBlank();
        assertThat(reservationDetails.getReservationId()).isNotBlank();
        assertPaymentHaBeenRegistered();
        assertThereIsReservationWithId(reservationDetails.getReservationId());
        assertReservationIsPending(reservationDetails.getReservationId());
        assertReservationIsDoneForCustomer(reservationDetails.getReservationId(),"jan","kowalski","je@example.com");
        assertReservationTotalMatchOffer(reservationDetails.getReservationId(),BigDecimal.valueOf(20));



    }
    private void assertReservationTotalMatchOffer(String reservationId,BigDecimal expectedTotal){
        Reservation loaded=reservationRepository.load(reservationId)
                .get();
        assertThat(loaded.getTotal()).isEqualTo(expectedTotal);

    }
    private void assertReservationIsDoneForCustomer(String reservationId,String fname,String lname,String email){
        Reservation loaded=reservationRepository.load(reservationId)
                .get();
        CustomerDetails clientData=loaded.getCustomerDetails();
        assertThat(clientData.getFirstName()).isEqualTo(fname);
        assertThat(clientData.getLastName()).isEqualTo(lname);

        assertThat(clientData.getEmail()).isEqualTo(email);



    }


    private void assertReservationIsPending(String reservationId){
        Reservation loaded=reservationRepository.load(reservationId)
                .get();
        assertThat(loaded.isPending()).isTrue();
    }
    private void assertPaymentHaBeenRegistered(){

        assertThat(spyPaymentGateway.getRequestCount()).isEqualTo(1);
    }
    private void assertThereIsReservationWithId(String reservationId){
        Optional<Reservation> loaded=reservationRepository.load(reservationId);
        assertThat(loaded).isPresent();


    }

    private String thereIsProduct(String productId, BigDecimal price) {
        return productId;

    }

    private String thereIsCustomer(String id) {
        return id;
    }

    private SalesFacade thereIsSales() {
        return new SalesFacade(
                new CartStorage(),
                new OfferCalculator(),
                spyPaymentGateway,
                reservationRepository

        );
    }


}