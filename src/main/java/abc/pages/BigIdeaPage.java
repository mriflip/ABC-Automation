package abc.pages;

import abc.core.PageObject;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by mrinalirao on 16/03/17.
 */
public class BigIdeaPage extends PageObject {

    public BigIdeaPage(){
        super(conf);
    }

    By header = By.xpath("//div[@id='header']//h2/a[text()='Big Ideas']");

    public void CheckIfBigIdeaHomePage() throws InterruptedException {

        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(header).isDisplayed());

        driver.quit();
    }
}

