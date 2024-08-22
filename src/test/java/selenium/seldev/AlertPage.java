package selenium.seldev;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

public class AlertPage extends BaseSeleniumPage {
    //https://the-internet.herokuapp.com/javascript_alerts

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
    }

    public AlertPage clickJsAlertButton() {
        jsAlertButton.click();
        return this;
    }

    public AlertPage clickJsConfirmButton() {
        jsConfirmButton.click();
        return this;
    }

    public AlertPage clickJsPromptButton() {
        jsPromptButton.click();
        return this;
    }

    public WebElement getResultField() {
        return resultField;
    }

}

