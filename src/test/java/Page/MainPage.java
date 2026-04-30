package Page;

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

    public boolean isBlockNameDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockName)).isDisplayed();
    }

    public List<WebElement> getPaymentLogos() {
        return driver.findElements(paymentLogos);
    }


    public void selectService(String serviceName) {
        WebElement header = wait.until(ExpectedConditions.elementToBeClickable(selectHeader));
        if (!header.getText().trim().equalsIgnoreCase(serviceName)) {
            header.click();
            By option = By.xpath("//ul[@class='select__list']/li[contains(., '" + serviceName + "')]");
            wait.until(ExpectedConditions.visibilityOfElementLocated(option)).click();
        }
    }

    public String getPlaceholderText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getDomAttribute("placeholder");
    }

    public void fillServiceForm(String phone, String sum) {
        WebElement pField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField));
        pField.clear();
        pField.sendKeys(phone + Keys.TAB);

        WebElement sField = driver.findElement(sumField);
        sField.clear();
        sField.sendKeys(sum + Keys.TAB);
    }

    public void clickContinue() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public void fillFormAndContinue(String phone, String sum) {
        fillServiceForm(phone, sum);
        clickContinue();
    }

    public WebElement getPhoneField(String serviceName) {
        By locator = switch (serviceName) {
            case "Услуги связи" -> By.id("connection-phone");
            case "Домашний интернет" -> By.id("internet-phone");
            case "Рассрочка" -> By.id("score-instalment");
            case "Задолженность" -> By.id("score-arrears");
            default -> throw new IllegalArgumentException("Неизвестная услуга: " + serviceName);
        };
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}