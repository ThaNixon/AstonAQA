
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import shinu.Ploshad;

public class PloshadTest {
    @DataProvider(name = "triangleData")
    public Object[][] createTriangleData() {
        return new Object[][] {
                { 2.0, 3.0, 3.0 },
                { 10.0, 5.0, 25.0 },
                { 7.0, 3.0, 10.5 }
        };
    }

    @Test(dataProvider = "triangleData", description = "Тест вычисления площади треугольника")
    public void testPloshad(double a, double b, double expected) {
        Assert.assertEquals(Ploshad.ploshad(a, b), expected, 0.0001);
    }

    @Test(description = "Негативный тест: проверка, что площадь не равна заведомо ложному значению")
    public void testPloshadNegative() {
        Assert.assertNotEquals(Ploshad.ploshad(2.0, 2.0), -1.0);
    }
}