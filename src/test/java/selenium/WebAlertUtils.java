package selenium;

import org.openqa.selenium.Alert;

public class WebAlertUtils extends BaseSeleniumTest{

    public static Alert sendKeysToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        return alert;
    }
}
