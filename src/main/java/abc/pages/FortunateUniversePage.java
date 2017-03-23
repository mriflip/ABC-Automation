package abc.pages;

import abc.core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrinalirao on 16/03/17.
 */
public class FortunateUniversePage extends PageObject{

    public FortunateUniversePage(){
        super(conf);
    }

    By facebookButton = By.xpath("");
    By twitterButton = By.xpath("//span[@id='l']");
    By downloadButton = By.xpath("//div[@id='content']//ul/li/a[text()='Download audio']");

    public void WaitForFortunateUnivPageLoad(){

        // opening the abc URL
        driver.get(conf.getConfig("abcBaseUrl") + "/radionational/programs/bigideas/a-fortunate-universe/8076406");
        waitForLoad(driver);

    }

    public void clickOnTwitterButton() throws InterruptedException {
        String master = driver.getWindowHandle();

        driver.switchTo().defaultContent();
        driver.switchTo().frame("twitter-widget-0");
        driver.findElement(By.xpath("//*[@id='l'][text()='Tweet']")).click();

        //check if twitter pop-up has appeared
        int timecount =1;
        do {
            driver.getWindowHandles();
            Thread.sleep(2000);
            timecount++;
            if (timecount > 40)
                break;
        }
        while(driver.getWindowHandles().size()==1);
        Set<String> handles = driver.getWindowHandles();
        for(String s: handles){
            if(!s.equals(master)){
                driver.switchTo().window(s);
                Assert.assertTrue(driver.findElement(By.xpath("//div[@id='header']/div/h1/a")).isDisplayed());
                driver.close();
            }

        }
    }

    public void clickOnFacebookButton() throws InterruptedException {

        String master = driver.getWindowHandle();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//button[@id='u_0_2']/div/span[text()='Share']")).click();

        // check if facebook pop-up has appeared
        int timecount =1;
        do {
            driver.getWindowHandles();
            Thread.sleep(2000);
            timecount++;
            if (timecount > 40)
                break;
        }
        while(driver.getWindowHandles().size()==1);
        Set<String> handles = driver.getWindowHandles();
        for(String s: handles){
            if(!s.equals(master)){
                driver.switchTo().window(s);
                Assert.assertTrue(driver.findElement(By.xpath("//h2[@id='homelink'][text()='Facebook']")).isDisplayed());
                driver.close();
            }

        }

    }


    public void downloadMP3() throws InterruptedException {

        driver.findElement(downloadButton).click();
        Thread.sleep(2000);
//        String currentUrl = driver.getCurrentUrl();
//        System.out.println(currentUrl);

    }



}
