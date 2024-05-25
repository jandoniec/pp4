package pl.jandoniec.ecommerce.sales;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.jandoniec.ecommerce.catalog.ProductCatalog;
import pl.jandoniec.ecommerce.catalog.sales.offering.AcceptOfferRequest;
import pl.jandoniec.ecommerce.catalog.sales.order.ReservationDetails;

import java.math.BigDecimal;
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SalesHTTPTest {
    @LocalServerPort
    int port;
    @Autowired
    TestRestTemplate http;
    @Autowired
    ProductCatalog catalog;
    @Test
    void itAcceptOfferHappyPath(){
        //adding to cart
        var productId=thereIsExampleProduct("Example product", BigDecimal.valueOf(10));
        var uri=String.format("api/add-to-cart/%s",productId);
        var addProductToCartUrl=String.format("http://localhost:%s/%s",port,uri);
        http.postForEntity(addProductToCartUrl,null, Object.class);
        //accepting
        AcceptOfferRequest acceptOfferRequest=new AcceptOfferRequest();

        acceptOfferRequest
                .setFirstName("Nastia")
                .setLastName("Chorna")
                .setEmail("a@example.com");
        var acceptOfferURL=String.format("http://localhost:%s/%s",port,"api/accept-offer" );
        ResponseEntity<ReservationDetails> reservationResponse=http.postForEntity(
                acceptOfferURL,acceptOfferRequest,ReservationDetails.class);

        assertEquals(HttpStatus.OK,reservationResponse.getStatusCode());
        assertEquals(BigDecimal.valueOf(10),reservationResponse.getBody().getTotal());
        assertNotNull(reservationResponse.getBody().getReservationId());
        assertNotNull(reservationResponse.getBody().getPaymentURL());



    }
    private String thereIsExampleProduct(String name, BigDecimal price ){
        var prodId=catalog.addProduct(name,name);
        catalog.changePrice(prodId,price);
        return "";

    }




}