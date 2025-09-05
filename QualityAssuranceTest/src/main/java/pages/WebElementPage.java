package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebElementPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(WebElementPage.class);
    public WebElementPage(WebDriver driver) {
        super();
    }
    By openNewWindowBtn_Locator = By.xpath("//button[normalize-space()='Open New Window']");
    By openTabLink_Locator = By.xpath("//a[normalize-space()='Open Tab']");
    By alertsLink_Locator = By.cssSelector("a[href='/alerts']");
    By hoverOverLink_Locator = By.cssSelector("a[href='https://qualitystream-demo.netlify.app/hover_menu']");
    By framesLink_Locator = By.cssSelector("a[href='https://qualitystream-demo.netlify.app/frames']");


    public void clickOnNewWindow(){
        click(openNewWindowBtn_Locator);
    }
    public void clickOnNewTab(){
        click(openTabLink_Locator);
    }
    public void clickOnAlertsLink(){
        click(alertsLink_Locator);
    }
    public void clickOnOverOverMenuLink(){
        click(hoverOverLink_Locator);
    }
    public void clickOnFramesLink(){click(framesLink_Locator);
    }



}
