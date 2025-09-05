package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionPages extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(ActionPages.class);
    public ActionPages(WebDriver driver) {
        super();
    }


    //Locator
    By textArea1_Locator = By.id("inputText");
    By textArea2_Locator = By.id("inputText2");
    By menu1Button_Locator = By.xpath("//button[normalize-space()='Menu 1']");
    By option1B_Button_Locator = By.xpath("//button[normalize-space()='Option 1B']");
    By menuSelectedOption_Locator = By.id("output");

    public String verifyKeysChord(String text){
        WebElement textArea1 = findElement(textArea1_Locator);
        textArea1.clear();
        textArea1.sendKeys(Keys.chord(Keys.SHIFT,text));
        return textArea1.getAttribute("value");

    }

    public String verifyActionCopyPaste(String text){
        WebElement textArea1 = findElement(textArea1_Locator);
        WebElement textArea2 = findElement(textArea2_Locator);
        textArea1.clear();
        textArea2.clear();
        Actions action = new Actions(driver);
        //Type in UpperCase with SHIFT key press
        action.keyDown(Keys.SHIFT).sendKeys(textArea1, text).keyUp(Keys.SHIFT).perform();
        //Copy the text from the Area1
        //Select all text with CTRL+A and
        action.click(textArea1)
                .keyDown(Keys.CONTROL)
                .sendKeys("A").sendKeys("C")
                .keyUp(Keys.CONTROL).perform();
        //Paste in the Area 2
        action.click(textArea2).keyDown(Keys.CONTROL).sendKeys(textArea2,"V").keyUp(Keys.CONTROL).perform();
        return textArea2.getAttribute("value");
    }


    public String selectMenuOption1B(){
        WebElement menu1 = findElement(menu1Button_Locator);
        WebElement option1B = findElement(option1B_Button_Locator);
        Actions action = new Actions(driver);
        action.moveToElement(menu1).moveToElement(option1B).click(option1B).perform();
        return getText(menuSelectedOption_Locator);

    }

}
