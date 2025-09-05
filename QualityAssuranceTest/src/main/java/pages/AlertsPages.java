package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlertsPages extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(AlertsPages.class);
    /**
     * Constructor initializes WebDriver and WebDriverWait.
     *
     * @param driver WebDriver instance
     */
    public AlertsPages(WebDriver driver) {
        super();
    }

    //Locators
    By alertBox_Locator = By.id("simple");
    By confirmAlert_Locator = By.id("confirm");
    By confirmLabel_Locator = By.id("demo");
    By promptAlert_Locator = By.id("prompt");
    By promptLabel_Locator = By.id("prompt_demo");



    public void clickOnAlertBox(){
        click(alertBox_Locator);
    }

    public void clickOnConfirmAlert(){
        click(confirmAlert_Locator);
    }

    public void clickOnPromptAlert(){
        click(promptAlert_Locator);
    }

    public String getConfirmAlertText(){
        return getText(confirmLabel_Locator);
    }

    public String getPromptAlertText(){
        return getText(promptLabel_Locator);
    }


}
