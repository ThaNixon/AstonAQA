import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import shinu.Factorial;

public class FactorialTest {
    @DataProvider(name = "factData")
    public Object[][] data() {
        return new Object[][] {
                { 5, 120 },
                { 0, 1 }
        };
    }

    @Test(dataProvider = "factData")
    public void testFact(int n, int expected) {
        Assert.assertEquals(Factorial.getFactorial(n), expected);
    }
}