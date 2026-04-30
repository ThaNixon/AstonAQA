import Page.MainPage;
import Page.PaymentPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class MtsTests {
    private WebDriver driver;
    private MainPage mainPage;
    private PaymentPage paymentPage;

    @BeforeEach
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        mainPage = new MainPage(driver);
        paymentPage = new PaymentPage(driver);

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree"))).click();
        } catch (Exception ignored) {}
    }

    @AfterEach
    public void teardown() {
        if (driver != null) driver.quit();
    }

    @Test
    void checkBlockName() {
        assertTrue(mainPage.isBlockNameDisplayed());
    }

    @Test
    void checkPaymentLogos() {
        List<WebElement> logos = mainPage.getPaymentLogos();
        assertEquals(5, logos.size());
        logos.forEach(logo -> assertTrue(logo.isDisplayed()));
    }

    @Test
    void checkContinue() {
        mainPage.fillFormAndContinue("297777777", "10");
        paymentPage.switchToFrame();
        assertTrue(paymentPage.isCcInputFieldDisplayed());
        paymentPage.leaveFrame();
    }

    @Test
    void testPlaceholdersForAllServices() {
        mainPage.selectService("Услуги связи");
        assertEquals("Номер телефона", mainPage.getPlaceholderText(mainPage.getPhoneField("Услуги связи")));

        mainPage.selectService("Домашний интернет");
        assertEquals("Номер абонента", mainPage.getPlaceholderText(mainPage.getPhoneField("Домашний интернет")));

        mainPage.selectService("Рассрочка");
        assertEquals("Номер счета на 44", mainPage.getPlaceholderText(mainPage.getPhoneField("Рассрочка")));

        mainPage.selectService("Задолженность");
        assertEquals("Номер счета на 2073", mainPage.getPlaceholderText(mainPage.getPhoneField("Задолженность")));
    }

    @Test
    void testMtsPaymentFlow() {
        mainPage.fillFormAndContinue("297777777", "130.00");
        paymentPage.switchToFrame();

        assertTrue(paymentPage.getAmountFromHeader().contains("130.00"));
        assertTrue(paymentPage.getAmountFromButton().contains("130.00"));
        assertTrue(paymentPage.getPhoneNumber().contains("297777777"));

        assertEquals("Номеркарты", paymentPage.getCardFieldPlaceholder("number"));
        assertTrue(paymentPage.getCardFieldPlaceholder("expiry").contains("ММ/ГГ"));
        assertEquals("CVC", paymentPage.getCardFieldPlaceholder("cvc"));
        assertTrue(paymentPage.areIconsDisplayed());

        paymentPage.leaveFrame();
    }
}