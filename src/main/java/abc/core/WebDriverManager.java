package abc.core;

import abc.configuration.Configuration;
import abc.configuration.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

/**
 * Created by mrinalirao on 15/03/17.
 *
 * The WebDriverManager class internally calls the
 * WebDriverConfig class to fetch the browser profiles.
 *
 */

public class WebDriverManager {

    public enum Browser {
        FIREFOX, CHROME
    }
    public static WebDriver getWebDriver(Configuration conf) {

        WebDriver webDriver = null;
        Browser browser = Browser.valueOf(conf.getConfig("browser").toUpperCase(Locale.ENGLISH));
        switch (browser) {
            case FIREFOX: {
                webDriver = new FirefoxDriver(WebDriverConfig.getFirefoxProfile(conf));
                break;
            }
            case CHROME: {
                webDriver = new ChromeDriver(WebDriverConfig.getChromeConfig(conf));
                break;
            }
            default:
                return null;
        }

        return webDriver;
    }
}