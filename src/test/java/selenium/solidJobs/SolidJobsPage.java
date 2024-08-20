package selenium.solidJobs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

import java.util.ArrayList;
import java.util.List;

public class SolidJobsPage extends BaseSeleniumPage {

    @FindBy(xpath = "//solidjobs-skill-display/a")
    private List<WebElement> tags;

    public SolidJobsPage() {
        PageFactory.initElements(driver, this);
    }

    public List<String> getAllTags() {
        List<String> list = new ArrayList<>();

        for (WebElement element : tags) {
            list.add(element.getAttribute("innerText"));
        }

        return list;
    }
}
