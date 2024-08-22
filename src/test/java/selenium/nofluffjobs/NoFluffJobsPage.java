package selenium.nofluffjobs;

import org.openqa.selenium.JavascriptExecutor;
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

public class NoFluffJobsPage extends BaseSeleniumPage {
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    List<String> listOfTags = new ArrayList<>();

    @FindBy(xpath = "//button[text()='Akceptuj']")
    private WebElement acceptCookieButton;

    @FindBy(xpath = "//div[contains(@class, 'list-container')]/a")
    private List<WebElement> jobLinks;

    @FindBy(xpath = "//*[text()='Obowiązkowe']/following-sibling::ul/li")
    private List<WebElement> tags;

    @FindBy(xpath = "//*[text()=' Pokaż kolejne oferty ']")
    private WebElement moreJobsButton;

    public NoFluffJobsPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickJobLinkAndGetAllTags() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (WebElement element : jobLinks) {
            String url = element.getAttribute("href");
            js.executeScript("window.open(arguments[0], '_blank');", url);
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            getTags();
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }

        System.out.println("JobLinks size: " + jobLinks.size());

    }

    public void getTags() {
        for (WebElement element : tags) {
            listOfTags.add(element.getText());
        }
    }
    public List<String> getAllTags() {
        return listOfTags;
    }

    public NoFluffJobsPage clickMoreJobsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(moreJobsButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0].getBoundingClientRect().top - 400);", moreJobsButton);
        moreJobsButton.click();
        return this;
    }

    public NoFluffJobsPage clickAcceptCookieButton() {
        acceptCookieButton.click();
        return this;
    }

}
