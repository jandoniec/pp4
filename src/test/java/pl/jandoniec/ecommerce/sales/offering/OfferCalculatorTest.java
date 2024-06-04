package pl.jandoniec.ecommerce.sales.offering;

import org.junit.jupiter.api.Test;
import pl.jandoniec.ecommerce.catalog.sales.offering.Offer;
import pl.jandoniec.ecommerce.catalog.sales.offering.OfferCalculator;
import static org.assertj.core.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Collections;

public class OfferCalculatorTest {
    @Test
    void zeroOfferForEmptyItems(){
        OfferCalculator calculator=new OfferCalculator();
        Offer offer =calculator.calculate(Collections.emptyList());
        assertThat(offer.getTotal()).isEqualTo(BigDecimal.ZERO);
    }
}