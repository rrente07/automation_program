package test;

import listeners.ExtentReportExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AlertsPages;
import pages.HomePage;
import pages.WebElementPage;

import static org.junit.jupiter.api.Assertions.fail;
import static test.BaseTest.driver;
@ExtendWith(ExtentReportExtension.class)
public class AlertTest extends BaseTest{

    private static final Logger logger = LoggerFactory.getLogger(AlertTest.class);
    static HomePage homePage;
    static WebElementPage webElementTestPage;
    static AlertsPages alertsPages;

    @BeforeAll
    static void initPage() {
        homePage = new HomePage(driver);
        alertsPages = new AlertsPages(driver);
        webElementTestPage = new WebElementPage(driver);
        homePage.ClickOnWebElementLink();
        webElementTestPage.clickOnAlertsLink();
    }
    //Click on the alert box and verify the current text
    @Test
    void alertBoxTest() {
    alertsPages.clickOnAlertBox();
    String expectedTest = "Hola! I am an alert box!";
    String currentText = alertsPages.getAlertText();
    alertsPages.acceptAlert();
    //fail("Failing on porpose");
        Assertions.assertTrue(expectedTest.equals(currentText),
                "Current alert text is not the expected one");
    }

    @Test
    //Click on the alert confirm and select the option Cancel
    void cancelConfirmAlert() {
        //Click on the button Alert
        alertsPages.clickOnConfirmAlert();
        //Click on the option cancel the alert
        alertsPages.dismissAlert();
        //Get the expected text
        String expectedText = "Cancelaste la Alerta!";
        //Get the current text that obtain the label text
        String currentText = alertsPages.getConfirmAlertText();
//Verify the both text
        Assertions.assertTrue(expectedText.equals(currentText),
                "Failed: current text is not the expected one.");

    }

    //Open the alert and click on the option Confirm and verify the text
    @Test
    void acceptConfirmAlert() {
//Click on the alert ConfirmAlert
        alertsPages.clickOnConfirmAlert();
        //Click on the button Accept
        alertsPages.acceptAlert();
//The text appear after we click on the button alert
        String expectedText = "Aceptaste la Alerta!";
        //Get the currently text when we confirm the alert
        String currentText = alertsPages.getConfirmAlertText();
//Verify the both are the same text
        Assertions.assertTrue(expectedText.equals(currentText),
                "Failed: current text is not the expected one.");

    }

    @Test
    void promptAlertTest() {
        //Click on the button alert
        alertsPages.clickOnPromptAlert();
        //Type a message alert
        alertsPages.sendKeysToAlert("QualityStream");
        //Get the expected text
        String expectedText = "Hola QualityStream! Cómo estás hoy?";
        //Get the current text
        String currentText = alertsPages.getPromptAlertText();
        //Verify if both text are the same
        Assertions.assertTrue(expectedText.equals(currentText),
                "Failed: Prompt Label text is incorrect");

    }


    }

