package selenium.jetbrains;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

public class AdvancedSearchPage extends BaseSeleniumPage {

    @FindBy(css = "div .full-search__item h3")
    private WebElement resultPreview;

    @FindBy(css = "button[data-test=close-search]")
    private WebElement closeSearchButton;

    public AdvancedSearchPage() {
        PageFactory.initElements(driver,this);
    }

    public WebElement getResult() {
        return resultPreview;
    }

    public MainPage clickCloseSearchButton() {
        closeSearchButton.click();
        return new MainPage();
    }
}
