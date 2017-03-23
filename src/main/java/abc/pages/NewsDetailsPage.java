package abc.pages;

import abc.core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by mrinalirao on 15/03/17.
 */
public class NewsDetailsPage extends PageObject{

    By playButton = By.xpath("//div[@id='jwplayer-video-0_display_button_play'][@class='jwicon']");
    By pause = By.xpath("//*[@id='jwplayer-video-0_display_button_play");

    By time = By.xpath("//span[@id='jwplayer-video-0_controlbar_elapsed'");
    By videoEle = By.xpath(".//*[@id='jwplayer-video-0_media']/video");

    public NewsDetailsPage(){
        super(conf);
    }

    public void WaitForVideoLoad(){

        // opening the abc URL
        driver.get(conf.getConfig("abcBaseUrl") + "/news/2017-02-09/weatherill-promises-to-intervene-dramatically/8254908");
        waitForLoad(driver);

    }

    public void testVideoPlay() throws InterruptedException {


        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("jwplayer().play()");
        Thread.sleep(2000);
        js.executeScript("jwplayer().pause()");
        js.executeScript("jwplayer().onTime(function(){ jwplayer().getDuration()})");

    }
}
