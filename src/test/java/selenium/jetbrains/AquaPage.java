package selenium.jetbrains;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

import static selenium.WebElementUtils.clickElement;

public class AquaPage extends BaseSeleniumPage {
    //https://www.jetbrains.com/aqua/

    @FindBy(xpath = "//h1[text()='The IDE for test automation']")
    private WebElement mainTitle;

    @FindBy(xpath = "//a[@data-test='button' and text()='Get Aqua']")
    private WebElement getAquaButton;

    public AquaPage() {
        PageFactory.initElements(driver, this);
        isAt();
    }

    public void isAt() {
        mainTitle.isDisplayed();
    }

    public String getTitle() {
        return mainTitle.getText();
    }

    public BuyPage clickGetAquaButton() {
        clickElement(getAquaButton);
        return new BuyPage();
    }
}
