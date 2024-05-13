package creditcard;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class hellotest {
    @Test
    void helloTest(){
        var name  ="Jakub";
        var message = String.format("Hello %s", name);
        System.out.println(message);
    }

    @Test
    void equationTest(){
        //A /Arrange
        int a= 2;
        int b=3;
        //A / Act
        var result=a+b;
        //A / Assert
        assert (5==result);

    }

    @Test
    void equationTestV2(){
        //A /Arrange
        int a= 2;
        int b=3;
        //A / Act
        var result=a+b;
        //A / Assert
        assert (10==result);

    }

    @Test
    void itGreetUsername(){
        //Arrange
        String name = "Jakub";
        //Act
        String message = String.format("Hello %s,name");
        //Assert
        assertEquals("Hello Jakub", message);
    }


}
