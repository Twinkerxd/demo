package selenium.pages.nofluffjobs.seldev;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.core.BasePage;


public class AlertPage extends BasePage {
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

    public AlertPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AlertPage isAt() {
        mainTitle.isDisplayed();
        return this;
    }

    public AlertPage clickJsAlertButton() {
        webElementUtils.clickOnElement(jsAlertButton);
        return this;
    }

    public AlertPage clickJsConfirmButton() {
        webElementUtils.clickOnElement(jsConfirmButton);
        return this;
    }

    public AlertPage clickJsPromptButton() {
        webElementUtils.clickOnElement(jsPromptButton);
        return this;
    }

    public WebElement getResultField() {
        return resultField;
    }

    public Alert sendKeysToAlert(String text) {
        return webAlertUtils.sendKeysToAlert(text);
    }

}

