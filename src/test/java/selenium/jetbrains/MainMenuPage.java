package selenium.jetbrains;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

import static selenium.WebElementUtils.clickOnElement;

public class MainMenuPage extends BaseSeleniumPage {

    @FindBy(xpath = "(//div[@data-test='main-submenu'])[1]")
    public WebElement mainSubMenu;

    @FindBy(xpath = "//a[@data-test='main-submenu-item-link']//span//span[text()='Aqua']")
    public WebElement aquaSpan;


    public MainMenuPage() {
        PageFactory.initElements(driver, this);
    }

    public MainMenuPage isAt() {
        mainSubMenu.isDisplayed();
        return this;
    }


    public AquaPage clickAquaSpan() {
        clickOnElement(aquaSpan);
        return new AquaPage().isAt();
    }
}
