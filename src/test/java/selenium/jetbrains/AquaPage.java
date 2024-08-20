package selenium.jetbrains;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

public class AquaPage extends BaseSeleniumPage {

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//a[@data-test='button' and text()='Get Aqua']")
    private WebElement aquaButton;

    public AquaPage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    public BuyPage clickAquaButton() {
        aquaButton.click();
        return new BuyPage();
    }
}
