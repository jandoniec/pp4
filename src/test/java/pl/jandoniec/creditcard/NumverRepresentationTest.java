package pl.jandoniec.creditcard;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class NumverRepresentationTest {

@Test
void bigDecimalTest(){
    BigDecimal a=new BigDecimal("0.002");
    BigDecimal b=new BigDecimal("0.003");

    System.out.println("Big Decimal");
    System.out.println(a.subtract(b));
}
}
