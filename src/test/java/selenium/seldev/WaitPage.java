package selenium.seldev;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

import java.util.List;

import static selenium.WebElementUtils.clickElement;

public class WaitPage extends BaseSeleniumPage {
    //https://www.selenium.dev/selenium/web/dynamic.html

    @FindBy(className = "redbox")
    List<WebElement> elementsList;

    @FindBy(id = "adder")
    WebElement addButton;

    @FindBy(id = "box0")
    WebElement box0;

    public WaitPage() {
        PageFactory.initElements(driver, this);
        isAt();
    }

    public void isAt() {
        addButton.isDisplayed();
    }

    public WaitPage clickAddButton() {
        clickElement(addButton);
        return this;
    }

    public WebElement getRedBox0() {
        return box0;
    }

    public List<WebElement> getRedBoxElementsList() {
        return elementsList;
    }

}
