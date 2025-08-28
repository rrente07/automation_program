package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * BasePage provides common Selenium WebDriver actions and utilities
 */
public class BasePage {

    WebDriver driver; //declare objet the type Webdriver
    WebDriverWait wait; //declare objet the type wait

    private static final int TIMEOUT = 20;


    /**
     * Constructor initializes WebDriver and WebDriverWait.
     *
     * @param driver WebDriver instance
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    /**
     * Finds a web element by locator, waiting for its presence.
     *
     * @param locator By locator
     * @return WebElement found
     */
    public WebElement findElement(By locator) {
        //Waiting for the element to be present
        waitForElementToBePresent(locator);
        return driver.findElement(locator);
    }

    /**
     * Finds a list of web elements by locator, waiting for their presence.
     *
     * @param locator By locator
     * @return List of WebElements found
     */
    public List<WebElement> findElements(By locator) {
        waitForElementToBePresent(locator);
        return driver.findElements(locator);
    }

    /**
     * Clicks on a web element found by locator, waiting for its presence.
     *
     * @param locator By locator
     */
    public void click(By locator) {
        waitForElementToBePresent(locator);
        driver.findElement(locator).click();
    }

    /**
     * Scrolls to a web element by locator and clicks it using JavaScript.
     *
     * @param locator By locator
     */
    public void ScrollIntoViewAndClick(By locator) {
        waitForElementToBePresent(locator);
        WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
        js.executeScript("arguments[0].click()", element);
    }

    /**
     * Scrolls to a web element and clicks it using JavaScript.
     *
     * @param element WebElement to interact with
     */
    public void ScrollIntoViewAndClick(WebElement element) {
        //wait
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
        js.executeScript("arguments[0].click()", element);
    }

    /**
     * Types text into a web element found by locator, clearing it first.
     *
     * @param locator By locator
     * @param text    Text to type
     */
    public void type(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Gets the text of a web element found by locator.
     *
     * @param locator By locator
     * @return Text of the element
     */
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    /**
     * Gets the text of a given web element.
     *
     * @param element WebElement
     * @return Text of the element
     */
    public String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Checks if a web element found by locator is displayed.
     *
     * @param locator By locator
     * @return true if displayed, false otherwise
     */
    public boolean IsDisplayed(By locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Waits for a web element to be present in the DOM.
     *
     * @param locator By locator
     */
    public void waitForElementToBePresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }


    /**
     * Waits for a web element found by locator to be clickable.
     *
     * @param locator By locator
     */
    public void waitforElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits for a given web element to be clickable.
     *
     * @param element WebElement
     */
    public void waitforElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Submits a form using a web element found by locator.
     *
     * @param locator By locator
     */
    public void Submit(By locator) {
        WebElement element = findElement(locator);
        element.submit();
    }

    /**
     * Scrolls to a web element found by locator.
     *
     * @param locator By locator
     */
    public void scrollIntoView(By locator) {
        waitforElementToBeClickable(locator);
        WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }
    /**
     * Scrolls to a given web element.
     *
     * @param element WebElement
     */
    public void scrollIntoView(WebElement element) {
        waitforElementToBeClickable(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }
    //Wait for the element go away
    public void waitForElementGoAway(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e){
           if( IsDisplayed(locator))
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        }
    }

// Test the JavaScript
//Scroll to the bottom of the page
public void scrollToBottom(){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
}

//Scroll to the bottom of the page

public void scrollToTop(){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0,0");
}

    public void uploadFile(By locator, String filePath){
        WebElement uploadElement = findElement(locator);
        uploadElement.sendKeys(filePath);
    }






}
