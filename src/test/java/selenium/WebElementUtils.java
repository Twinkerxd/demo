package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebElementUtils {

    protected WebDriver driver;
    protected Actions actions = new Actions(driver);
    protected JavascriptExecutor js = (JavascriptExecutor) driver;

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    public void openInNewANewTab(String url) {
        js.executeScript("window.open(arguments[0], '_blank');", url);
    }

    public void scrollToElementWithValue(int value, WebElement webElement) {
        js.executeScript(String.format("window.scrollBy(0, arguments[0].getBoundingClientRect().top - %d);", value), webElement);
    }

    public void clickOnElement(WebElement webElement) {
        webElement.click();
    }
}
