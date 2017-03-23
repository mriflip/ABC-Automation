package abc;

import abc.core.BaseSetup;
import abc.pages.*;
import org.testng.annotations.Test;

/**
 * Created by mrinalirao on 15/03/17.
 */
@Test
public class UITest extends BaseSetup {

    NewsPage newsPage = new NewsPage();
    JustInPage justInPage;
    NewsDetailsPage newsDetailsPage = new NewsDetailsPage();
    ImageDetailsPage imageDetailsPage = new ImageDetailsPage();
    RadioHomePage radioHomePage = new RadioHomePage();
    BigIdeaPage bigIdeaPage = new BigIdeaPage();
    FortunateUniversePage fortunateUniversePage = new FortunateUniversePage();

    public void abcNewsTest() throws InterruptedException {


        // Check if the page is completely loaded
        newsPage.loginAndWaitForLoad();

        // Check for presence of News Banner
        newsPage.verifyNewsBanner();

        // click on the Just In Tab
        justInPage = newsPage.navigateToJustInPage();

        // Assert that we have navigated to the right page
        justInPage.checkJustInPageHeader();

        //check if all the articles have title, author, timestamp and text
        //justInPage.checkArticleLoad();

        //Wait for video to load
        newsDetailsPage.WaitForVideoLoad();

        //test if video plays
        newsDetailsPage.testVideoPlay();

        //Wait for Image page to load
        //imageDetailsPage.WaitForImageLoad();

        //Check if the correct image is loaded on click
        //imageDetailsPage.checkImageLoad();

        // Tests to check the radio page
        //radioHomePage.WaitForRadioHomePageLoad();

      // bigIdeaPage= radioHomePage.navigateToBigIdeaPage();
       //bigIdeaPage.CheckIfBigIdeaHomePage();

       //radioHomePage.WaitForRadioHomePageLoad();
       //radioHomePage.scrollToLastItem();

        //radioHomePage.searchItem();

        fortunateUniversePage.WaitForFortunateUnivPageLoad();
        //fortunateUniversePage.clickOnTwitterButton();
        //fortunateUniversePage.clickOnFacebookButton();
        fortunateUniversePage.downloadMP3();




    }

}
