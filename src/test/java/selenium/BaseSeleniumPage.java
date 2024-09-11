package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.Utils.WebAlertUtils;
import selenium.Utils.WebElementUtils;
import selenium.Utils.WebWaitUtils;

public abstract class BaseSeleniumPage {
    protected WebDriver driver;
    protected WebElementUtils webElementUtils;
    protected WebWaitUtils webWaitUtils;
    protected WebAlertUtils webAlertUtils;

    public BaseSeleniumPage(WebDriver driver) {
        this.driver = driver;
        this.webElementUtils = new WebElementUtils(driver);
        this.webWaitUtils = new WebWaitUtils(driver);
        this.webAlertUtils = new WebAlertUtils(driver);
        PageFactory.initElements(this.driver, this);
    }

}
