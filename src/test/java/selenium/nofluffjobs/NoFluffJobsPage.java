package selenium.nofluffjobs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

import java.util.ArrayList;
import java.util.List;

import static selenium.WebElementUtils.*;

public class NoFluffJobsPage extends BaseSeleniumPage {

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

        for (WebElement element : jobLinks) {
            String url = element.getAttribute("href");
            openInNewANewTab(url);
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
        scrollToElementWithValue(400, moreJobsButton);
        moreJobsButton.click();
        return this;
    }

    public NoFluffJobsPage clickAcceptCookieButton() {
        acceptCookieButton.click();
        return this;
    }

}
