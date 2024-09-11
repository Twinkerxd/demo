package selenium.pages.nofluffjobs.jetbrains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.core.BasePage;


public class MainMenuPage extends BasePage {

    @FindBy(xpath = "(//div[@data-test='main-submenu'])[1]")
    public WebElement mainSubMenu;

    @FindBy(xpath = "//a[@data-test='main-submenu-item-link']//span//span[text()='Aqua']")
    public WebElement aquaSpan;


    public MainMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainMenuPage isAt() {
        mainSubMenu.isDisplayed();
        return this;
    }


    public AquaPage clickAquaSpan() {
        webElementUtils.clickOnElement(aquaSpan);
        return new AquaPage(driver).isAt();
    }
}
