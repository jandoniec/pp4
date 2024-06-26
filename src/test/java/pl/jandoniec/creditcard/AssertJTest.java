package pl.jandoniec.creditcard;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;
public class AssertJTest {
    @Test
    void helloAssertJ(){
        var hello="Hello world!";
        assertThat(hello).containsOnlyDigits();

    }
    @Test
    void testSomeExpression(){
        var names= Collections.singleton("Beata");
        assertThat(names)
                .isUnmodifiable()
                .hasSize(3)
                .containsAll(Arrays.asList("Beata","Robert"));
    }
}