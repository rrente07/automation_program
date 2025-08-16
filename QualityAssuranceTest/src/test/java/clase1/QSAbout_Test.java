package clase1;

import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class QSAbout_Test {
    @Test
    void VerifyAboutPage() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.qualitystream-practice.com/");
        driver.manage().window().maximize();
        By aboutLink_Locator = By.xpath("//div[@class='header-nav']//a[@href='/about']");
        By aboutImg_locator = By.xpath("//img[contains(@src,'IMG_0481.JPG')]");
        driver.findElement(aboutLink_Locator).click();
        String expectedURL = "https://www.qualitystream-practice.com/about";
        String currentURL = driver.getCurrentUrl();
        System.out.println("The expected URL is:" + expectedURL);
        System.out.println("The current URL is:" + currentURL);
        assertEquals(expectedURL,currentURL,"This method fail because the URL are different");
        boolean isImagePresent = driver.findElement(aboutImg_locator).isDisplayed();
        System.out.println("the img is present" + isImagePresent );
        assertTrue(isImagePresent, "the image failed");
        driver.navigate().back();
        driver.quit();
    }
    @Test
    void verifyAppointmentPage(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.qualitystream-practice.com/appointments");
        driver.manage().window().maximize();
        By appointmentsLinks_Locator = By.xpath("//div[@class='header-nav']//a[@href='/appointments']");
        driver.findElement(appointmentsLinks_Locator).click();
        String expectedURL = "https://www.qualitystream-practice.com/appointments";
        String currentURL = driver.getCurrentUrl();
        assertEquals(expectedURL, currentURL, "appointment URL is not correct");
        By title_Locator = By.xpath("//h2");
        boolean isTitlePresent = driver.findElement(title_Locator).isDisplayed();
        assertTrue(isTitlePresent,"Failed: Appointment title is not present");
        driver.quit();
    }

    @Test
    void verifyBottomsPage() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.qualitystream-practice.com/");
        By bottLinksLocator = By.xpath("//a[contains(@href, '/shop/bottoms')]");
        driver.findElement(bottLinksLocator).click();
        String expectedBott_Locator = "https://www.qualitystream-practice.com/shop/bottoms";
        String currentBott_Locator = driver.getCurrentUrl();
        System.out.println("the expected URL is:" + expectedBott_Locator);
        System.out.println("the current URL is:" + currentBott_Locator);
        assertEquals(expectedBott_Locator, currentBott_Locator, "Fail:The link is not correct");
        driver.navigate().back();
        driver.quit();
    }
    @Test
    void verifyTopsPage() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.qualitystream-practice.com/");
        By topLinksLocator = By.xpath("//a[contains(@href, '/shop/tops')]");
        driver.findElement(topLinksLocator).click();
        String expectLink_locator = "https://www.qualitystream-practice.com/shop/tops";
        driver.navigate().back();
        driver.quit();
    }

    @Test
    void verifyAllPage() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.qualitystream-practice.com/");
        By allLinksLocator = By.xpath("//a[contains(@href, '/shop')]");
        driver.findElement(allLinksLocator).click();
        String expectLink_Locator = "https://www.qualitystream-practice.com/shop/tops";
        String currentLink_Locator= driver.getCurrentUrl();
        System.out.println("the expected path is:" + expectLink_Locator);
        System.out.println("the current path is:" + currentLink_Locator);
        driver.navigate().back();
        driver.quit();


    }
}
