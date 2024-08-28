package selenium.jetbrains;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

import java.util.ArrayList;
import java.util.List;

public class BuyPage extends BaseSeleniumPage {
    // https://www.jetbrains.com/aqua/buy/

    @FindBy(xpath = "//h1[text()='Subscription Plans']")
    private WebElement subscriptionPlansTitle;

    @FindBy(xpath = "//h3[@class='rs-h3 rs-h3_theme_light']")
    private List<WebElement> titlesPlan;


    public BuyPage() {
        PageFactory.initElements(driver, this);
        isAt();
    }

    public void isAt() {
        subscriptionPlansTitle.isDisplayed();
    }

    public List<String> getTitlesPlans() {
        List<String> titles = new ArrayList<>();

        for (WebElement element : titlesPlan) {
            titles.add(element.getText());
        }

        return titles;
    }
}
