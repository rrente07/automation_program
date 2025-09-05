package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.ActionPages;
import pages.HomePage;
import pages.WebElementPage;

public class ActionTest extends BaseTest{

private static final Logger logger = LoggerFactory.getLogger(ActionTest.class);

    static HomePage homePage;
    static WebElementPage webElementTestPage;
    static ActionPages actionPage;

    @BeforeAll
    static void initPage() {
        homePage = new HomePage(driver);
        webElementTestPage = new WebElementPage(driver);
        actionPage = new ActionPages(driver);
        homePage.ClickOnWebElementLink();
        webElementTestPage.clickOnOverOverMenuLink();
    }


    @Test
    void testKeysChord() {

        String text = actionPage.verifyKeysChord("qualitystream");
        logger.info("Text: "+text);
        Assertions.assertTrue(text.equals("QUALITYSTREAM"),
                "Failed: keys chord method failed.");
    }

    @Test
    void testActionCopyPaste() {

        String value = actionPage.verifyActionCopyPaste("test automation");
        logger.info("Value: "+value);
        Assertions.assertTrue(value.equals("TEST AUTOMATION"),
                "Failed: keys chord method failed.");
    }

    @Test
    void testHoverOver(){
        String text = actionPage.selectMenuOption1B();
        System.out.println("text: " + text);
        Assertions.assertTrue(text.equals("You clicked: Option 1B"),
                "Failed: option 1B was not selected");

    }





}
