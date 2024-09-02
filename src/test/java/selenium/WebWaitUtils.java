package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WebWaitUtils {

    private static final WebDriver driver = new ChromeDriver();

    static Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    public static void waitElementById(String id) {
        wait.until(presenceOfElementLocated(By.id(id)));
    }

    public static void waitVisibilityOfElement(WebElement webElement) {
        wait.until(visibilityOf(webElement));
    }

    public static Boolean isDisplayed(WebElement webElement) {
        return wait.until(d -> webElement.isDisplayed());
    }

    public static Alert waitAlertIsPresent() {
        return wait.until(alertIsPresent());
    }
}
