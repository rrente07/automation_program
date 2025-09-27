package test;

import listeners.ExtentReportExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.WebElementPage;

import java.net.URL;

@ExtendWith(ExtentReportExtension.class)
@Tag("AlertTest_Regression")
public class WebElementTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(WebElementTest.class);
    static HomePage homePage;
    static WebElementPage webElementTestPage;

    @BeforeAll
    static void initPage() {
        homePage = new HomePage(driver);
        webElementTestPage = new WebElementPage(driver);
        homePage.ClickOnWebElementLink();
    }
@Test
    void openNewWindow(){

        String originalHandle = driver.getWindowHandle();
        System.out.println("Original window handle:" + originalHandle);
        Assertions.assertNotNull(originalHandle, "Failed: original window handle is null");
        webElementTestPage.clickOnNewWindow();
        webElementTestPage.switchToNewWindow(originalHandle);
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.quality-stream.com/productos";
        System.out.println("CurrentURL" + currentURL);
        Assertions.assertTrue(currentURL.equals(expectedURL),
            "New window URL is not the expected one");

        String newWindowHandle = driver.getWindowHandle();
        System.out.println("New window hable" + newWindowHandle);
        driver.close();
        driver.switchTo().window(originalHandle);
    String originalURL = driver.getCurrentUrl();
    Assertions.assertTrue(originalURL.equals("https://www.qualitystream-practice.com/webelements-test"),
            "Failed: original window URL is not the expected one");
    }

    @Test
    void openNewTab(){
        String originalHandle = driver.getWindowHandle();
        System.out.println("originalHandle" + originalHandle);
        Assertions.assertNotNull(originalHandle, "Failed: original window handle is null");

        webElementTestPage.clickOnNewTab();
        webElementTestPage.switchToNewWindow(originalHandle);
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL" + currentURL);
        Assertions.assertTrue(currentURL.contains("/QualityStream"));
//close Tab and return to the main page
        driver.close();
        driver.switchTo().window(originalHandle);
        String originalURL = driver.getCurrentUrl();
        Assertions.assertTrue(originalURL.equals("https://www.qualitystream-practice.com/webelements-test"),
                "Failed: original window URL is not the expected one");
    }

}
