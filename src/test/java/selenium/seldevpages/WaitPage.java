package selenium.seldevpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.BaseSeleniumPage;

import java.time.Duration;
import java.util.List;

public class WaitPage extends BaseSeleniumPage {
    //https://www.selenium.dev/selenium/web/dynamic.html

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    @FindBy(className = "redbox")
    WebElement element;

    @FindBy(className = "redbox")
    List<WebElement> elementsList;

    @FindBy(id = "adder")
    WebElement addButton;

    @FindBy(id = "box0")
    WebElement box0;

    public WaitPage() {
        PageFactory.initElements(driver, this);
    }

    public WaitPage clickAddButton() {
        addButton.click();
        return this;
    }

    public WebElement getRedBox0() {
        return box0;
    }

    public List<WebElement> getRedBoxElementsList() {
        return elementsList;
    }

    public void waitRedBoxElementById(int id) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("box" + id)));
    }

    public void waitVisibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }


}
