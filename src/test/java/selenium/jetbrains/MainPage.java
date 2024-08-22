package selenium.jetbrains;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.BaseSeleniumPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends BaseSeleniumPage {
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));

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
        openMainPage();
    }

    public MainPage openMainPage() {
        driver.get("https://www.jetbrains.com/");
        driver.manage().addCookie(new Cookie("jb_cookies_consent_closed", "true"));
        driver.manage().addCookie(new Cookie("languageSuggestShowedCookie", "closed"));
        driver.navigate().refresh();
        return this;
    }

    public MainPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public MainPage clickSearchInput() {
        searchInput.click();
        return this;
    }

    public MainPage sendTextSearchInput(String text) {
        searchInput.sendKeys(text);
        return this;
    }

    public AdvancedSearchPage clickAdvancedSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(advancedSearchButton)).click();
        return new AdvancedSearchPage();
    }

    public String getMainTitle() {
        return mainTitle.getText();
    }

    public MainMenuPage clickDeveloperToolsButton() {
        developerToolsButton.click();
        return new MainMenuPage();
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
