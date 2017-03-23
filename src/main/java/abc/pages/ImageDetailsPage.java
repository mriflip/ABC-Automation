package abc.pages;

import abc.core.PageObject;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by mrinalirao on 16/03/17.
 */
public class ImageDetailsPage extends PageObject {

    public ImageDetailsPage() {
        super(conf);
    }

    By images = By.xpath(".//*[@id='main_content']/div[1]/div/div/div/ul/li[*]/a/img");


    public void WaitForImageLoad(){

        // opening the abc URL
        driver.get(conf.getConfig("abcBaseUrl") + "/news/2017-02-10/abc-open-pic-of-the-week/8256256");
        waitForLoad(driver);

    }

    public void checkImageLoad() throws InterruptedException {

        List<WebElement> lis = driver.findElements(images);
       // System.out.println(lis.size());

        //check all the images
        for(int i = 1; i<=lis.size(); i++) {

            Thread.sleep(1000);
            WebElement i1 = driver.findElement(By.xpath("//*[@id='main_content']/div[1]/div/div/div/ul/li[" + i + "]/a/img"));
            String smallImg = (String) i1.getAttribute("src");
            smallImg = smallImg.substring(0,smallImg.indexOf('-'));
            click(i1);
            WebElement i2 = driver.findElement(By.xpath("//*[@id='main_content']/div[1]/div/div/div/div/ul/li[" + i + "]/img"));
            String bigImage = (String) i2.getAttribute("src");
            bigImage = bigImage.substring(0,bigImage.indexOf('-'));
            Assert.assertEquals(smallImg, bigImage);
        }

    }
}
