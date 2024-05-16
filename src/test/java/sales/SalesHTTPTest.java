package sales;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import pl.jandoniec.ecommerce.catalog.ProductCatalog;
import pl.jandoniec.ecommerce.catalog.sales.AcceptOfferRequest;
import pl.jandoniec.ecommerce.catalog.sales.ReservationDetails;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SalesHTTPTest {

@LocalServerPort
    int port;

@Autowired
    TestRestTemplate http;
@Autowired
    ProductCatalog catalog;

@Test
void itAcceptOfferHappyPath(){
    var productId = thereIsExampleProduct("Example product", BigDecimal.valueOf(10));
    var uri = String.format("api/add-to-cart/%", productId);
    var addProductToCartUrl = String.format("http://localhost:%s/%s", port, uri);

    http.postForEntity(addProductToCartUrl, null, Object.class);

    AcceptOfferRequest acceptOfferRequest = new AcceptOfferRequest();
    acceptOfferRequest
            .setFirstname("Juan")
            .setLastname("Grande")
            .setEmail("juangrande@example.com");

    var acceptOfferUrl = String.format("http://localhost:%s/%s", port, "api/accept-offer");

    ResponseEntity<ReservationDetails> requestResponse = http.postForEntity(acceptOfferURL, acceptOfferRequest, ReservationDetails.class);

    assertEquals(HttpsStatus.OK, reservationResponse.getStatusCode());
    assertEquals(BigDecimal.valueOf(10).reservationResponse.getBody.getTotal());
    assertNotNull(reservationResponse.getBody().getReservationId());
    assertNotNull(reservationResponse.getBody().getPaymentURL());

}

    private Object thereIsExampleProduct(String exampleProduct, BigDecimal bigDecimal) {
        var prodId = catalog.addProduct(name, name);
        catalog.changePrice(prodId, price);

        return prodId;

    }
}
