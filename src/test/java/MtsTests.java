import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTests {
    private static WebDriverWait wait;
    private WebDriver driver;

    @BeforeEach
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");

        try {
            WebElement cookies = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
            cookies.click();
        }  catch (Exception ignored) {}
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void checkBlockName() {
        WebElement blockName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")
        ));
        assertTrue(blockName.isDisplayed());
    }

    @Test
    void checkPaymantLogos() {
        List<WebElement> paymantLogos = driver.findElements(By.xpath("//div[@class='pay__partners']//img"));
        assertEquals(5, paymantLogos.size());
        for (WebElement logo : paymantLogos) {
            assertTrue(logo.isDisplayed());
        }
    }

    @Test
    void checkAboutService() {
        WebElement serviceButton = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        serviceButton.click();
    }

    @Test
    void checkContinue() {
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("130");
        driver.findElement(By.xpath("//*[@id='pay-connection']/button")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe[src*='bepaid']")
        ));
        WebElement ccInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cc-number")));
        assertTrue(ccInput.isDisplayed());
        driver.switchTo().defaultContent();
    }
}
