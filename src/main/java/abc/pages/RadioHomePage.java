package abc.pages;

import abc.core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.List;

/**
 * Created by mrinalirao on 16/03/17.
 */
public class RadioHomePage extends PageObject {

    By programList = By.xpath("//div[@id='rn-navigation']/ul/li[2]/a");
    By lastItem = By.xpath(".//*[@id='content']/div[1]/div/div/div[2]/ul/li[22]/a/div");
    By searchInput = By.xpath("//input[@id='search-simple-input-query']");


    public RadioHomePage() {
        super(conf);
    }

    public void WaitForRadioHomePageLoad() {

        // opening the abc URL
        driver.get(conf.getConfig("abcBaseUrl") + "/radionational");
        waitForLoad(driver);
    }

    public BigIdeaPage navigateToBigIdeaPage() {

        WebElement program = driver.findElement(programList);

        Actions action = new Actions(driver);

        action.moveToElement(program).perform();

        WebElement subElement = driver.findElement(By.linkText("Big Ideas"));

        action.moveToElement(subElement);

        action.click();

        action.perform();

        return new BigIdeaPage();
    }

    // horizontal scrolling in the program guide
    public void scrollToLastItem() {
        int size = 1;
        while (!(driver.findElement(lastItem).isDisplayed())) {
            WebElement arrow = driver.findElement(By.cssSelector("#right-arrow"));
                    arrow.click();
                }

         List<WebElement> lis = driver.findElements(By.xpath(".//*[@id='content']/div[1]/div/div/div[2]/ul/li"));
        int s = lis.size()-1;

        //selecting the last element
        WebElement lastButOne= driver.findElement(By.xpath(".//*[@id='content']/div[1]/div/div/div[2]/ul/li[" + s + "]/a/div"));
        lastButOne.click();
    }


    public void searchItem(){

        By searchResult = By.xpath("//p[starts-with(text(),'Your search for')]");

        driver.findElement(searchInput).sendKeys("sydney" + "\n");
        String searchPara = driver.findElement(searchResult).getText();
        String res = searchPara.substring(searchPara.indexOf("matched") + 8, searchPara.indexOf("items")-1);
        Assert.assertNotSame(0,res);

    }



}

