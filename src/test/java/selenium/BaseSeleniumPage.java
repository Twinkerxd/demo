package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseSeleniumPage {
    protected WebDriver driver;
    protected WebElementUtils webElementUtils;
    protected WebWaitUtils webWaitUtils;
    protected WebAlertUtils webAlertUtils;

    public BaseSeleniumPage(WebDriver driver) {
        this.driver = driver;
        this.webElementUtils = new WebElementUtils();
        this.webWaitUtils = new WebWaitUtils();
        this.webAlertUtils = new WebAlertUtils();
        PageFactory.initElements(this.driver, this);
    }


}
