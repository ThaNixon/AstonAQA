import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import shinu.Sravnenie;

public class SravnenieTest {
    @ParameterizedTest
    @CsvSource({
            "5, 5, true",
            "0, 0, true",
            "-1, 1, false"
    })
    void testSravnenie(int a, int b, boolean expected) {
        boolean result = Sravnenie.sravnenie(a, b);

        assertEquals(expected, result);
    }

    @Test
    void testSravnenie2() {
        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        boolean result = Sravnenie.sravnenie(a, b);

        Assertions.assertFalse(result);
    }
}
