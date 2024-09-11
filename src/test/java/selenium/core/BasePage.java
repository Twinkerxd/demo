package selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.utils.WebAlertUtils;
import selenium.utils.WebElementUtils;
import selenium.utils.WebWaitUtils;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebElementUtils webElementUtils;
    protected WebWaitUtils webWaitUtils;
    protected WebAlertUtils webAlertUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.webElementUtils = new WebElementUtils(driver);
        this.webWaitUtils = new WebWaitUtils(driver);
        this.webAlertUtils = new WebAlertUtils(driver);
        PageFactory.initElements(this.driver, this);
    }

}
