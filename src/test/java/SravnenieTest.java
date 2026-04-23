import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import shinu.Sravnenie;

public class SravnenieTest {
        @DataProvider(name = "sravData")
            public Object[][] createSravData() {
                return new Object[][] {
                        { 2, 3, false },
                        { -2, -2, true },
                        { 1, 1, true }
                };
        }

        @Test(dataProvider = "sravData")
            public void testSrav(int a, int b, boolean expected) {
            boolean result = Sravnenie.sravnenie(a, b);
            Assert.assertEquals(result, expected);
        }

        @Test
            public void testNegativeSravnenie() {
            int a = Integer.MIN_VALUE;
            int b = Integer.MAX_VALUE;
            boolean result = Sravnenie.sravnenie(a, b);
            Assert.assertEquals(result, false);
    }
}
