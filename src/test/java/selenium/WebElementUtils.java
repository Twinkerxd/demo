package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebElementUtils extends BaseSeleniumTest {

    static Actions actions = new Actions(driver);
    static JavascriptExecutor js = (JavascriptExecutor) driver;

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

    public static void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    public static void openInNewANewTab(String url) {
        js.executeScript("window.open(arguments[0], '_blank');", url);
    }

    public static void scrollToElementWithValue(int value, WebElement webElement) {
        js.executeScript(String.format("window.scrollBy(0, arguments[0].getBoundingClientRect().top - %d);", value), webElement);
    }

    public static void clickElement(WebElement webElement) {
        webElement.click();
    }
}
