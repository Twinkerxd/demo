package selenium.seldevpages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.BaseSeleniumPage;

import java.time.Duration;

public class AlertPage extends BaseSeleniumPage {
    //https://the-internet.herokuapp.com/javascript_alerts

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));


    public void waitElementByXpath(String xpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public WebElement waitVisibilityOfElementById(String id) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public Alert waitAlertIsPresent() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public WebElement getAlertElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

}

