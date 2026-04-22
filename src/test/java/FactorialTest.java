import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shinu.Factorial;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactorialTest {
    @ParameterizedTest
    @CsvSource({
            "5, 120",
            "0, 1",
            "1, 1",
            "3, 6",
    })
    void  TestFactorialPos(int a, int expected)
    {
        assertEquals(expected, Factorial.getFactorial(a));
    }
    void  TestFactorialNeg(int a, int expected)
    {
        assertEquals(100, Factorial.getFactorial(4));
    }

    @Test
    void  TestFactorial()
    {
        int expectedValue = 738197504;
        int actualValue = Factorial.getFactorial(31);
        System.out.println(actualValue);
        assertEquals(expectedValue, actualValue, "Переполнение типа int");
    }
}
