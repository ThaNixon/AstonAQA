import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.provider.CsvSource;
import shinu.Arifmetika;

public class ArifmetikaTest
{
    @DisplayName("Положительная проверка сложения")
    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "-2, -2, -4",
            "1, 1, 2",
    })
    void  TestSum(int a, int b, int expected)
    {
        assertEquals(expected, Arifmetika.sum(a, b));
    }

    @Test
    void  TestSum2()
    {
        int result = Arifmetika.sum(Integer.MAX_VALUE, 1);
        assertEquals(result, Arifmetika.sum(Integer.MIN_VALUE, result));
    }

    @DisplayName("Негативная проверка сложения")
    @Test
    void TestNegativeSum()
    {
        Assertions.assertNotEquals(5, Arifmetika.sum(2, 1));
    }

    @DisplayName("Положительная проверка вычитания")
    @ParameterizedTest
    @CsvSource({
            "10, 5, 5",
            "-5, -5, 0",
            "0, 5, -5",
    })
    void  TestSub(int a, int b, int expected)
    {
        assertEquals(expected, Arifmetika.sub(a, b));
    }

    @DisplayName("Негативная проверка вычитания")
    @Test
    void TestNegativeSub()
    {
        Assertions.assertNotEquals(5, Arifmetika.sub(2, 1));
    }

    @DisplayName("Положительная проверка умножения")
    @ParameterizedTest
    @CsvSource({
            "3, 1, 3",
            "10, 0, 0",
            "-5, 2, -10",
    })
    void  TestMul(int a, int b, int expected)
    {
        assertEquals(expected, Arifmetika.mul(a, b));
    }

    @DisplayName("Негативная проверка умножения")
    @Test
    void TestNegativeMul()
    {
        Assertions.assertNotEquals(10, Arifmetika.mul(10, 2));
    }

    @DisplayName("Положительная проверка деления")
    @ParameterizedTest
    @CsvSource({
            "9, 3, 3",
            "10, 2, 5",
            "5, 2, 2",
    })
    void  TestDiv(int a, int b, int expected)
    {
        assertEquals(expected, Arifmetika.div(a, b));
    }

    @DisplayName("Негативная проверка деления: деление на ноль")
    @Test
    void TestNegativeDiv()
    {
        Assertions.assertThrows(ArithmeticException.class, () -> {Arifmetika.div(10, 0);
        }, "Ожидалось ArithmeticException при делении на ноль");
    }
}
