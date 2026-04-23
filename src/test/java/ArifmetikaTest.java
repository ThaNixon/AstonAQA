import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import shinu.Arifmetika;

public class ArifmetikaTest {
    @DataProvider(name = "sumData")
    public Object[][] createSumData() {
        return new Object[][] {
                { 2, 3, 5 },
                { -2, -2, -4 },
                { 1, 1, 2 }
        };
    }

    @Test(dataProvider = "sumData")
    public void testSum(int a, int b, int expected) {
        Assert.assertEquals(Arifmetika.sum(a, b), expected);
    }

    @Test
    public void testNegativeSum() {
        Assert.assertNotEquals(Arifmetika.sum(2, 1), 5);
    }
}