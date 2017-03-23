package abc.pages;

import abc.core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by mrinalirao on 15/03/17.
 */
public class NewsPage extends PageObject {

    public NewsPage() {
        super(conf);
    }

    By newsBanner = By.xpath("//img[@alt='ABC News'][@class='noprint']");
    By justInTab = By.xpath("//div[@id='container_nav']//a[text()='Just In']");

    public void loginAndWaitForLoad(){

        // opening the abc URL
        driver.get(conf.getConfig("abcBaseUrl") + "/news");
        waitForLoad(driver);

    }

    public void verifyNewsBanner(){
        Assert.assertTrue(driver.findElement(newsBanner).isDisplayed());
    }

    public JustInPage navigateToJustInPage() {
        click(driver.findElement(justInTab));
        return new JustInPage();
    }

}
