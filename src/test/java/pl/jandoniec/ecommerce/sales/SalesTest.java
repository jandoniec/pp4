package pl.jandoniec.ecommerce.sales;
import org.junit.jupiter.api.Test;
import pl.jandoniec.ecommerce.catalog.sales.offering.Offer;
import pl.jandoniec.ecommerce.catalog.sales.ui.SalesFacade;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class SalesTest {
    @Test
    void itShowsOffers(){
        SalesFacade sales = thereIsSaleFacade();
        String customerId = thereIsExampleCustomer("Anastejsza");

        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(0, offer.getItemsCount());
        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }
    @Test
    void idAllowsAddProductToCart(){
        String productId = thereIsProduct("Example",BigDecimal.valueOf(10));
        String customerId=thereIsExampleCustomer("Anastejsza");
        SalesFacade sales=thereIsSaleFacade();
        sales.addToCart(customerId,productId);

        Offer offer=sales.getCurrentOffer(customerId);
        assertEquals(1,offer.getItemsCount());
        assertEquals(BigDecimal.valueOf(10),offer.getTotal());



    }
    @Test
    void itDistinguishCartsByCustomer(){
        String productA = thereIsProduct("Example a",BigDecimal.valueOf(10));
        String productB = thereIsProduct("Example b",BigDecimal.valueOf(20));

        String customerA=thereIsExampleCustomer("Anastejsza");
        String customerB=thereIsExampleCustomer("Paweł");

        SalesFacade sales=thereIsSaleFacade();
        sales.addToCart(customerA,productA);
        sales.addToCart(customerB,productB);


        Offer offerA=sales.getCurrentOffer(customerA);
        Offer offerB=sales.getCurrentOffer(customerB);

        assertEquals(1,offerA.getItemsCount());
        assertEquals(BigDecimal.valueOf(10),offerA.getTotal());

        assertEquals(1,offerB.getItemsCount());
        assertEquals(BigDecimal.valueOf(20),offerB.getTotal());



    }
    @Test
    void itAllowsAcceptOffer(){


    }
    private String thereIsProduct(String name, BigDecimal price) {
        return name;
    }
    private String thereIsExampleCustomer(String id) {
        return id;
    }


    private SalesFacade thereIsSaleFacade() {
        return new SalesFacade();
    }





}