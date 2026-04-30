package Page;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By blockName = By.xpath("//*[@id='pay-section']//h2");
    private final By paymentLogos = By.xpath("//div[@class='pay__partners']//img");
    private final By selectHeader = By.className("select__header");
    private final By phoneField = By.id("connection-phone");
    private final By sumField = By.id("connection-sum");
    private final By continueBtn = By.xpath("//form[@id='pay-connection']//button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("ПРоверка названия блока")
    public boolean isBlockNameDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockName)).isDisplayed();
    }

    @Step("Получение логотипов платёжных систем")
    public List<WebElement> getPaymentLogos() {
        return driver.findElements(paymentLogos);
    }

    private final By aboutServiceLink = By.xpath("//a[contains(text(), 'Подробнее о сервисе')]");
    @Step("Нажать на ссылку 'Подробнее о сервисе'")
    public void clickAboutService() {
        wait.until(ExpectedConditions.elementToBeClickable(aboutServiceLink)).click();
    }

    @Step("Выбрать услугу: {0}")
    public void selectService(String serviceName) {
        WebElement header = wait.until(ExpectedConditions.elementToBeClickable(selectHeader));
        if (!header.getText().trim().equalsIgnoreCase(serviceName)) {
            header.click();
            By option = By.xpath("//ul[@class='select__list']/li[contains(., '" + serviceName + "')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(option)).click();
        }
    }

    @Step("Прочитать текст плейсхолдера из элемента")
    public String getPlaceholderText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getDomAttribute("placeholder");
    }

    @Step("Заполнить форму: телефон {0}, сумма {1}")
    public void fillServiceForm(String phone, String sum) {
        WebElement pField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField));
        pField.clear();
        pField.sendKeys(phone + Keys.TAB);

        WebElement sField = driver.findElement(sumField);
        sField.clear();
        sField.sendKeys(sum + Keys.TAB);
    }

    @Step("Нажать кнопку 'Продолжить'")
    public void clickContinue() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    @Step("Заполнить форму данными ({0}, {1}) и перейти к оплате")
    public void fillFormAndContinue(String phone, String sum) {
        fillServiceForm(phone, sum);
        clickContinue();
    }

    @Step("Найти поле ввода для услуги: {0}")
    public WebElement getPhoneField(String serviceName) {
        By locator;
        switch (serviceName) {
            case "Услуги связи":
                locator = By.id("connection-phone");
                break;
            case "Домашний интернет":
                locator = By.id("internet-phone");
                break;
            case "Рассрочка":
                locator = By.id("score-instalment");
                break;
            case "Задолженность":
                locator = By.id("score-arrears");
                break;
            default:
                throw new IllegalArgumentException("Неизвестная услуга: " + serviceName);
        }
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}