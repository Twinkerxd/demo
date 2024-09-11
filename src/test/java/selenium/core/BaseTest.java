package selenium.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import selenium.pages.nofluffjobs.jetbrains.MainPage;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
    public static void setUpAll() {
        Logger logger = Logger.getLogger("org.openqa.selenium");
        logger.setLevel(Level.SEVERE);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--no-first-run");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-search-engine-choice-screen");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    public static void tearDownAll() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void open(String url) {
        driver.get(url);
    }

    public MainPage openMainPage() {
        return new MainPage(driver);
    }
}
