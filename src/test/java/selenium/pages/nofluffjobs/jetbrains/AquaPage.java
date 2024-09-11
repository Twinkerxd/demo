package selenium.pages.nofluffjobs.jetbrains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.core.BasePage;


public class AquaPage extends BasePage {
    //https://www.jetbrains.com/aqua/

    @FindBy(xpath = "//h1[text()='The IDE for test automation']")
    private WebElement mainTitle;

    @FindBy(xpath = "//a[@data-test='button' and text()='Get Aqua']")
    private WebElement getAquaButton;

    public AquaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AquaPage isAt() {
        mainTitle.isDisplayed();
        return this;
    }

    public String getTitle() {
        return mainTitle.getText();
    }

    public BuyPage clickGetAquaButton() {
        webElementUtils.clickOnElement(getAquaButton);
        return new BuyPage(driver).isAt();
    }
}
