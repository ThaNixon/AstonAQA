import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shinu.Ploshad;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PloshadTest {
    @ParameterizedTest
    @CsvSource({
            "2, 3, 3.0",
            "10, 5, 25.0",
            "7, 3, 10.5",
    })
    void  TestPloshad(double a, double b, double expected)
    {
        assertEquals(expected, Ploshad.ploshad(a, b), 0.0001);
    }

    void   TestPloshadNegative(double a, double b, double expected)
    {
        Assertions.assertNotEquals(-1.0, Ploshad.ploshad(2, 2));
    }


}
