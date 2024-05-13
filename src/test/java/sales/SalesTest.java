package sales;

import org.junit.jupiter.api.Test;
import pl.jandoniec.ecommerce.catalog.Offer;
import pl.jandoniec.ecommerce.catalog.SalesFacede;
import  java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

public class SalesTest {
    @Test
    void itShowsOffer(){
        SalesFacade sales = thereIsSalesFacade();
        String customerId = thereIsExampleCustomer("Kuba");

        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(0, offer.getItemsCount());
        assertEquals(BigDecimal.ZERO, offer.getTotal());
    }

    private SalesFacade thereIsSalesFacade() {
        return new SalesFacade();
    }

    private String thereIsExampleCustomer(String id){
        return id;
    }

    @Test
    void i(){
        SalesFacade sales = thereIsSalesFacade();

    }
}