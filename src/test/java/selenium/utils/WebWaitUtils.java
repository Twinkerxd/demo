package selenium.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class WebWaitUtils {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public WebWaitUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public void waitElementById(String id) {
        wait.until(presenceOfElementLocated(By.id(id)));
    }

    public void waitVisibilityOfElement(WebElement webElement) {
        wait.until(visibilityOf(webElement));
    }

    public Boolean isDisplayed(WebElement webElement) {
        return wait.until(d -> webElement.isDisplayed());
    }

    public Alert waitAlertIsPresent() {
        return wait.until(alertIsPresent());
    }
}
