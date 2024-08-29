package selenium.jetbrains;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

import java.util.ArrayList;
import java.util.List;

import static selenium.WebElementUtils.clickOnElement;

public class MainPage extends BaseSeleniumPage {
    // https://www.jetbrains.com/

    @FindBy(css = "button[data-test='site-header-search-action']")
    private WebElement searchButton;

    @FindBy(css = "input[data-test-id='search-input']")
    private WebElement searchInput;

    @FindBy(css = "button[data-test='full-search-button']")
    private WebElement advancedSearchButton;

    @FindBy(css = "p.rs-middle-hero")
    private WebElement mainTitle;

    @FindBy(xpath = "//button[text()='Developer Tools' and @data-test = 'main-menu-item-action']")
    private WebElement developerToolsButton;

    @FindBy(css = "[data-test='main-menu-item']")
    private List<WebElement> mainMenuItems;

    @FindBy(css = "a[href='#for-teams']")
    private WebElement teamsLink;

    public MainPage() {
        PageFactory.initElements(driver, this);
        openMainPage().isAt();
    }

    public MainPage openMainPage() {
        driver.get("https://www.jetbrains.com/");
        driver.manage().addCookie(new Cookie("jb_cookies_consent_closed", "true"));
        driver.manage().addCookie(new Cookie("languageSuggestShowedCookie", "closed"));
        driver.navigate().refresh();
        return this;
    }

    public void isAt() {
        mainTitle.isDisplayed();
    }

    public MainPage clickSearchButton() {
        clickOnElement(searchButton);
        return this;
    }

    public MainPage clickSearchInput() {
        clickOnElement(searchInput);
        return this;
    }

    public MainPage sendTextSearchInput(String text) {
        searchInput.sendKeys(text);
        return this;
    }

    public AdvancedSearchPage clickAdvancedSearchButton() {
        clickOnElement(advancedSearchButton);
        return new AdvancedSearchPage().isAt();
    }

    public String getMainTitle() {
        return mainTitle.getText();
    }

    public MainMenuPage clickDeveloperToolsButton() {
        clickOnElement(developerToolsButton);
        return new MainMenuPage().isAt();
    }

    public List<String> getMainMenuItems() {
        List<String> mainMenuItems = new ArrayList<>();
        for (WebElement element : this.mainMenuItems) {
            mainMenuItems.add(element.getText());
        }
        return mainMenuItems;
    }

    public String getForTeamsLink() {
        return teamsLink.getAttribute("href");
    }

    public String getForTeamsCSSValue(String value) {
        return teamsLink.getCssValue(value);
    }

    public WebElement getTeamsLink() {
        return teamsLink;
    }

}
