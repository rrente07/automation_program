package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver; //declare objet the type Webdriver
    WebDriverWait wait; //declare objet the type wait

    private static final int TIMEOUT = 10;

    //Constructor
        public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

//Define the FindElement method adding waiting for the element
    public WebElement findElement (By locator){
        //Waiting for the element to be present
        waitForElementToBePresent(locator);
        return driver.findElement(locator);
    }

//Define the Click method adding the option wait for locator until be present
    public void click(By locator){
    waitForElementToBePresent(locator);
    driver.findElement(locator).click();
    }

//Define a new method type where we put the String in the locator and adding a text.
    public void type (By locator, String text){
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    //Obtain the text from an element
    public String getText (By locator){
        return driver.findElement(locator).getText();
    }

    //Obtain if the element is displayed. Try any exception to catch and manage any error
public boolean IsDisplayed( By locator){
        try {
return findElement(locator).isDisplayed();
        }catch (Exception e){
return false;
        }
}
    public void waitForElementToBePresent(By locator){
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public void waitforElementToBeClickable(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void Submit(By locator){
    WebElement element = findElement(locator);
    element.submit();
    }

    public void scrollIntoView (By locator){
    waitforElementToBeClickable(locator);
    WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);

    }
}
