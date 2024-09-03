package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class WebAlertUtils {
    protected WebDriver driver;

    public Alert sendKeysToAlert(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        return alert;
    }
}
