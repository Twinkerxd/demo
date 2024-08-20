package selenium.jetbrains;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.BaseSeleniumPage;

import java.time.Duration;

public class AdvancedSearchPage extends BaseSeleniumPage {
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    @FindBy(css = "div .full-search__item h3")
    private WebElement resultPreview;

    @FindBy(css = "button[data-test=close-search]")
    private WebElement closeSearchButton;


    public AdvancedSearchPage() {
        PageFactory.initElements(driver,this);
    }

    public String getResult() {
        return wait.until(ExpectedConditions.visibilityOf(resultPreview)).getText();
    }

    public MainPage clickCloseSearchButton() {
        closeSearchButton.click();
        return new MainPage();
    }
}
