package selenium.jetbrains;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

import static selenium.WebElementUtils.clickElement;

public class MainMenuPage extends BaseSeleniumPage {

    @FindBy(xpath = "(//div[@data-test='main-submenu'])[1]")
    public WebElement mainSubMenu;

    @FindBy(xpath = "//a[@data-test='main-submenu-item-link']//span//span[text()='Aqua']")
    public WebElement aquaSpan;


    public MainMenuPage() {
        PageFactory.initElements(driver, this);
        isAt();
    }

    public void isAt() {
        mainSubMenu.isDisplayed();
    }


    public AquaPage clickAquaSpan() {
        clickElement(aquaSpan);
        return new AquaPage();
    }
}
