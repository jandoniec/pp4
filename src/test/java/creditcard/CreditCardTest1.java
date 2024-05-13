package creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CreditCardTest1 {
    @Test
    void itAllowsToAssignCredit(){
        //Arrange
        CreditCard card = new CreditCard();

        //Act
      //  card.assigCreditLimit(BigDecimal.valueOf(1000));
        //Assert
        assert BigDecimal.valueOf(1000).equals(card.getBalance());
    }
}
