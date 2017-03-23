package abc.core;

import abc.configuration.Configuration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by mrinalirao on 15/03/17.
 *
 * The PageObject class is extended by every Page class
 * It contains wrapper functions for the webdriver actions
 * It also initializes the jsExecutor, default timeouts etc.
 *
 */
public class PageObject extends BaseSetup{

    protected WebDriver driver;
    JavascriptExecutor jsExecutor;
    public long defaultWaitTime = 60;

    public PageObject(Configuration conf) {
        this.driver = webDriver;
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(this.defaultWaitTime, TimeUnit.SECONDS);
        driver.manage().timeouts()
                .implicitlyWait(this.defaultWaitTime, TimeUnit.SECONDS);

    }

    public void openUrl(String url) { driver.get(url); }

    public void click(WebElement element) { element.click(); }

    public void type(WebElement element, String text) { element.sendKeys(new CharSequence[]{text}); }

    public void clear(WebElement element) { element.clear(); }

    public Object executeJavascript(String script) {
        return jsExecutor.executeScript(script);
    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"); } };
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(pageLoadCondition); }



}
