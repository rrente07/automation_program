package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class QSCreditCardsPage extends BasePage{

    //Locators
    By InputPassword_Locator = By.name("password");
    By diamond_Locator = By.xpath("//img[contains(@src,'QStream+Diamond+Credit+Card1.png')]");
    By goldenCC_Locator = By.xpath("//img[contains(@src, 'QStream+Golden+Credit+Card1.png')]");
    By platinumCC_Locator = By.xpath("//img[contains(@src, 'QStream+Platinum+Credit+Card1.png')]");


    //Form locator
    By selectCreditCardType_Locator = By.id("cardType");
    By creditCardDetailsLabel_Locator = By.id("cardDetails");

    public QSCreditCardsPage(WebDriver driver){
        super(driver);
    }
    //Input Password
    public void enterPassword(){
       waitforElementToBeClickable(InputPassword_Locator);
       if(IsDisplayed (InputPassword_Locator)){
        String password = "qa123";
        type(InputPassword_Locator, password);
            //we need to submit

           Submit(InputPassword_Locator);
       }else
           System.out.println("Password input was not present");
    }

    public boolean areCreditsCardsPresent(){
        boolean diamondCC = IsDisplayed(diamond_Locator);
        System.out.println("Is Diamond credit card present:" + diamondCC);

        boolean goldenCC = IsDisplayed(goldenCC_Locator);
        System.out.println("Is golden credit card present:" + goldenCC);

        boolean platinumCC = IsDisplayed(platinumCC_Locator);
        System.out.println("Is platinum credit card present:" + platinumCC );

        return diamondCC && goldenCC && platinumCC;
    }

public boolean selectCreditCardMethod(String creditCardType){
      //We need to scroll to the select first
        scrollIntoView(selectCreditCardType_Locator);
        //Finding select web element
        WebElement selectElement = findElement(selectCreditCardType_Locator);
        Select select = new Select(selectElement);
        //Selecting credit card by value
        select.selectByValue(creditCardType);
    return false;
}

public String getCreditCardsDetails(){
        String details = getText(creditCardDetailsLabel_Locator);
        System.out.println("Credit card details:" + details);
        return details;
}


   }
