package selenium.seldev;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

import static selenium.WebElementUtils.clickElement;

public class AlertPage extends BaseSeleniumPage {
    //https://the-internet.herokuapp.com/javascript_alerts

    @FindBy(xpath = "//h3[text()='JavaScript Alerts']")
    private WebElement mainTitle;

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    private WebElement jsAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement jsConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement jsPromptButton;

    @FindBy(id = "result")
    private WebElement resultField;

    public AlertPage() {
        PageFactory.initElements(driver, this);
        isAt();
    }

    public void isAt() {
        mainTitle.isDisplayed();
    }

    public AlertPage clickJsAlertButton() {
        clickElement(jsAlertButton);
        return this;
    }

    public AlertPage clickJsConfirmButton() {
        clickElement(jsConfirmButton);
        return this;
    }

    public AlertPage clickJsPromptButton() {
        clickElement(jsPromptButton);
        return this;
    }

    public WebElement getResultField() {
        return resultField;
    }

}

