package selenium.pages.nofluffjobs.solidJobs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.core.BasePage;

import java.util.ArrayList;
import java.util.List;

public class SolidJobsPage extends BasePage {
    //https://solid.jobs/offers/it;experiences=Regular;categories=Tester;subcategories=In%C5%BCynier%20test%C3%B3w%20automatycznych

    @FindBy(xpath = "//span[text()='Oferty Inżynier testów automatycznych']")
    private WebElement mainTitle;

    @FindBy(xpath = "//solidjobs-skill-display/a")
    private List<WebElement> tags;

    public SolidJobsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public SolidJobsPage isAt() {
        mainTitle.isDisplayed();
        return this;
    }

    public List<String> getAllTags() {
        List<String> list = new ArrayList<>();

        for (WebElement element : tags) {
            list.add(element.getAttribute("innerText"));
        }

        return list;
    }
}
