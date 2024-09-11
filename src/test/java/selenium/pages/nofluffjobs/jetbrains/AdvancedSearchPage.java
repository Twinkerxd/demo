package selenium.pages.nofluffjobs.jetbrains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.core.BasePage;

public class AdvancedSearchPage extends BasePage {

    @FindBy(xpath = "//div[@data-test='search-results']")
    private WebElement firstSearchResults;

    @FindBy(css = "div .full-search__item h3")
    private WebElement firstResultTitle;

    @FindBy(css = "button[data-test=close-search]")
    private WebElement closeSearchButton;

    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AdvancedSearchPage isAt() {
        firstSearchResults.isDisplayed();
        return this;
    }

    public WebElement getFirstResultTitle() {
        return firstResultTitle;
    }

    public MainPage clickCloseSearchButton() {
        webElementUtils.clickOnElement(closeSearchButton);
        return new MainPage(driver);
    }
}
