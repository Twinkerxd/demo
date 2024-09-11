package selenium.pages.nofluffjobs.seldev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.core.BasePage;

import java.util.List;


public class WaitPage extends BasePage {
    //https://www.selenium.dev/selenium/web/dynamic.html

    @FindBy(className = "redbox")
    List<WebElement> elementsList;

    @FindBy(id = "adder")
    WebElement addButton;

    @FindBy(id = "box0")
    WebElement box0;

    public WaitPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WaitPage isAt() {
        addButton.isDisplayed();
        return this;
    }

    public WaitPage clickAddButton() {
        webElementUtils.clickOnElement(addButton);
        return this;
    }

    public WebElement getRedBox0() {
        return box0;
    }

    public List<WebElement> getRedBoxElementsList() {
        return elementsList;
    }

}
