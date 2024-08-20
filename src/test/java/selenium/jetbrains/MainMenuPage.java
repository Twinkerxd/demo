package selenium.jetbrains;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

public class MainMenuPage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@data-test='main-submenu-item-link']//span//span[text()='Aqua']")
    public WebElement aquaSpan;

    public MainMenuPage() {
        PageFactory.initElements(driver, this);
    }

    public AquaPage clickAquaSpan() {
        aquaSpan.click();
        return new AquaPage();
    }
}
