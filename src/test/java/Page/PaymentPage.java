package Page;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By payButton = By.xpath("//button[@type='submit'][contains(., 'Оплатить')]");
    private final By ccNumberField = By.xpath("//app-card-input[contains(@class, 'number')]//input | //input[contains(@autocomplete, 'cc-number')]");
    private final By expiryField = By.xpath("//app-card-input[contains(@class, 'expiration')]//input | //input[contains(@autocomplete, 'cc-exp')]");
    private final By cvcField = By.xpath("//app-card-input[contains(@class, 'cvc')]//input | //input[contains(@autocomplete, 'cc-csc')]");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Step("Переключиться во фрейм платежной системы")
    public void switchToFrame() {
        By frameLocator = By.xpath("//iframe[contains(@src, 'bepaid') or contains(@src, 'checkout')]");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }
    @Step("Вернуться из фрейма в основной контент")
    public void leaveFrame() {
        driver.switchTo().defaultContent();
    }
    @Step("Получить сумму оплаты с кнопки")
    public String getAmountFromButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payButton)).getText().trim();
    }
    @Step("Получить сумму оплаты из заголовка")
    public String getAmountFromHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'BYN')]"))).getText().trim();
    }
    @Step("Получить номер телефона со страницы оплаты")
    public String getPhoneNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'Номер') or contains(text(), '37529')]"))).getText().trim();
    }
    @Step("Проверить отображение иконок платежных систем")
    public boolean areIconsDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'cards-brands')] | //img[contains(@src, 'visa')] | //img[contains(@src, 'mastercard')]")
        )).isDisplayed();
    }
    @Step("Получить плейсхолдер для поля: {0}")
    public String getCardFieldPlaceholder(String field) {
        By locator;
        switch (field.toLowerCase()) {
            case "number":
                locator = ccNumberField;
                break;
            case "expiry":
                locator = expiryField;
                break;
            case "cvc":
                locator = cvcField;
                break;
            default:
                throw new IllegalArgumentException("Unknown field: " + field);
        }

        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String placeholder = input.getDomAttribute("placeholder");

        if (placeholder == null || placeholder.isEmpty()) {
            placeholder = input.getDomAttribute("aria-label");
        }
        if (placeholder == null || placeholder.isEmpty()) {
            placeholder = input.findElement(By.xpath("./preceding-sibling::label | ./parent::div//label")).getText();
        }

        return placeholder != null ? placeholder.replace(" ", "").trim() : "";
    }
    @Step("Проверить видимость поля ввода карты")
    public boolean isCcInputFieldDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ccNumberField)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}