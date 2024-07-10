package driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptException js;
    public static Actions action;

    public static WebDriver getDriver() {

        if (driver == null) {
            WebDriverManager.chromedriver().clearDriverCache();
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.get("https://www.hepsiburada.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            action = new Actions(Driver.getDriver());
            wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

