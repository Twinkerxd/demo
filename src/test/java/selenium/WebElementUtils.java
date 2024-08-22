package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WebElementUtils extends BaseSeleniumTest {

    static Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    static Actions actions = new Actions(driver);

    public static void open(String url) {
        driver.get(url);
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitElementById(String id) {
        wait.until(presenceOfElementLocated(By.id(id)));
    }

    public static void waitVisibilityOfElement(WebElement webElement) {
        wait.until(visibilityOf(webElement));
    }

    public static void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    public static Boolean isDisplayed(WebElement webElement) {
        return wait.until(d -> webElement.isDisplayed());
    }

    public static Alert waitAlertIsPresent() {
        return wait.until(alertIsPresent());
    }

    public static Alert sendKeysToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        return alert;
    }
}
