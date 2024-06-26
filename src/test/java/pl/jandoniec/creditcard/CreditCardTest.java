package pl.jandoniec.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    void itAssignCredit(){
        //arrange
        var card=new CreditCard();
        //act
        card.assignCredit(BigDecimal.valueOf(1000));
        //assert
        assertEquals(BigDecimal.valueOf(1000),
                card.getBalance());
    }
    @Test
    void itAssignCreditV2(){
        //arrange
        var card=new CreditCard();
        //act
        card.assignCredit(BigDecimal.valueOf(1500));
        //assert
        assert BigDecimal.valueOf(1500).equals(card.getBalance());
    }
    @Test
    void itDenyCreditBelowThreshold(){
        var card=new CreditCard();
        try{
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Should throw exception");

        }catch(CreditBelowThresholdException e) {
            assertTrue(true) ;

        }
    }
    @Test
    void itDenyCreditBelowThresholdV2(){
        var card=new CreditCard();
        //PYTHON//lambda x:x+2
        //java (x)->x+2
        assertThrows(
                CreditBelowThresholdException.class,
                ()->card.assignCredit(BigDecimal.valueOf(10))
        );
        try{
            card.assignCredit(BigDecimal.valueOf(50));
            fail("Should throw exception");
        }catch(CreditBelowThresholdException e){
            assertTrue(true);
        }
    }
    @Test
    void itDenyCreditReassignment(){
        CreditCard card=new CreditCard();
        card.assignCredit(BigDecimal.valueOf(1000));
        assertThrows(
                CreditAlreadyAssignedException.class,
                ()->card.assignCredit(BigDecimal.valueOf(1200))
        );
    }
    @Test
    void itAllowsToPayForSomething() {
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(2000));

        card.pay(BigDecimal.valueOf(900));

        assertEquals(
                BigDecimal.valueOf(100),
                card.getBalance()
        );
    }
    @Test
    void itDenyWhenNotSufficientFounds() {
        CreditCard card = new CreditCard();
        card.assignCredit(BigDecimal.valueOf(2000));
        card.pay(BigDecimal.valueOf(900));

        assertThrows(
                NotEnoughMoneyException.class,
                () -> card.pay(BigDecimal.valueOf(200))
        );
    }


}