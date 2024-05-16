package pl.jandoniec.creditcard;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

public class AssertJTest {


    @Test
    void testSomeListExpression(){
        var names = Collections.singleton("Jakub");

        assertThat(names)
                .isUnmodifiable()
                .hasSize(3)
                .containsAll(Arrays.asList("Jakub", "Michal"));

    }
}
