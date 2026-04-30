package Page;

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

    public void switchToFrame() {
        By frameLocator = By.xpath("//iframe[contains(@src, 'bepaid') or contains(@src, 'checkout')]");
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public void leaveFrame() {
        driver.switchTo().defaultContent();
    }

    public String getAmountFromButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(payButton)).getText().trim();
    }

    public String getAmountFromHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'BYN')]"))).getText().trim();
    }

    public String getPhoneNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'Номер') or contains(text(), '37529')]"))).getText().trim();
    }

    public boolean areIconsDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class, 'cards-brands')] | //img[contains(@src, 'visa')] | //img[contains(@src, 'mastercard')]")
        )).isDisplayed();
    }

    public String getCardFieldPlaceholder(String field) {
        By locator = switch (field.toLowerCase()) {
            case "number" -> ccNumberField;
            case "expiry" -> expiryField;
            case "cvc" -> cvcField;
            default -> throw new IllegalArgumentException("Unknown field: " + field);
        };

        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String placeholder = input.getDomAttribute("placeholder");

        if (placeholder == null || placeholder.isEmpty()) {
            placeholder = input.getDomAttribute("aria-label");
        }
        if (placeholder == null || placeholder.isEmpty()) {
            placeholder = input.findElement(By.xpath("./preceding-sibling::label | ./parent::div//label")).getText();
        }

        return placeholder.replace(" ", "").trim();
    }

    public boolean isCcInputFieldDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ccNumberField)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}