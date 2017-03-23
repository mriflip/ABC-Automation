package abc.pages;

import abc.core.PageObject;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by mrinalirao on 15/03/17.
 */
public class JustInPage extends PageObject {

    public JustInPage() {
        super(conf);
    }

    By justInHeader = By.xpath("//h1[text()='Just In']");
    By topStoryText = By.xpath("//p[contains(text(), 'The most recent')]");
    By articleUl = By.xpath("//ul[@class='article-index']");
    String xpath1 = "//ul[@class='article-index']/li";
    By articleLI = By.xpath(xpath1);

    public void checkJustInPageHeader(){
        Assert.assertTrue(driver.findElement(justInHeader).isDisplayed());
        Assert.assertTrue(driver.findElement(topStoryText).isDisplayed());
    }

    public void checkArticleLoad(){

        List<WebElement> lis = driver.findElements(articleLI);

        for (int i=1; i<=lis.size(); i++) {


            WebElement title = driver.findElement(By.xpath(xpath1 + "["+i+"]/h3"));
            Assert.assertNotNull(title.getAttribute("innerText"));

            WebElement author = driver.findElement(By.xpath(xpath1 + "["+i+"]/div"));
            Assert.assertNotNull(author.getAttribute("innerText"));

            WebElement time = driver.findElement(By.xpath(xpath1 + "["+i+"]/p[1]"));
            Assert.assertNotNull(time.getAttribute("innerText"));

            WebElement tex = driver.findElement(By.xpath(xpath1 + "["+i+"]/p[2]"));
            Assert.assertNotNull(tex.getAttribute("innerText"));

            }

        }


}
