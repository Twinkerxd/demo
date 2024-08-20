package selenium.jetbrains;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.BaseSeleniumPage;

import java.util.ArrayList;
import java.util.List;

public class BuyPage extends BaseSeleniumPage {

    @FindBy(xpath = "//h3[@class='rs-h3 rs-h3_theme_light']")
    private List<WebElement> titlesPlan;

    public BuyPage() {
        PageFactory.initElements(driver, this);
    }

    public List<String> getTitlesPlans() {
        List<String> tit = new ArrayList<>();

        for (WebElement element : titlesPlan) {
            tit.add(element.getText());
        }

        return tit;
    }
}
