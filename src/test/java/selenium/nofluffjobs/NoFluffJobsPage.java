package selenium.nofluffjobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

import java.util.ArrayList;
import java.util.List;

public class NoFluffJobsPage extends BaseSeleniumPage {
    //https://nofluffjobs.com/pl/Java?criteria=jobPosition%3D%27qa%20engineer%27

    List<String> listOfTags = new ArrayList<>();

    @FindBy(xpath = "//h1[text()='Szanujemy Twój czas. Widełki dopasowane do Ciebie.']")
    private WebElement mainTitle;

    @FindBy(xpath = "//button[text()='Akceptuj']")
    private WebElement acceptCookieButton;

    @FindBy(xpath = "//div[contains(@class, 'list-container')]/a")
    private List<WebElement> jobLinks;

    @FindBy(xpath = "//*[text()='Obowiązkowe']/following-sibling::ul/li")
    private List<WebElement> tags;

    @FindBy(xpath = "//*[text()=' Pokaż kolejne oferty ']")
    private WebElement moreJobsButton;

    public NoFluffJobsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public NoFluffJobsPage isAt() {
        mainTitle.isDisplayed();
        return this;
    }

    public void clickJobLinkAndGetAllTags() {

        for (WebElement element : jobLinks) {
            String url = element.getAttribute("href");
            webElementUtils.openInNewANewTab(url);
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
        webElementUtils.scrollToElementWithValue(400, moreJobsButton);
        webElementUtils.clickOnElement(moreJobsButton);
        return this;
    }

    public NoFluffJobsPage clickAcceptCookieButton() {
        webElementUtils.clickOnElement(acceptCookieButton);
        return this;
    }

}
