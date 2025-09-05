package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Page Object class for the QS Credit Cards page
public class QSCreditCardsPage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(QSCreditCardsPage.class);

    // Constructor initializes the page with WebDriver
    public QSCreditCardsPage(WebDriver driver){
        super();
    }

    // Locators for password input and credit card images
    By InputPassword_Locator = By.name("password");

    //Credit Card Locators
    By diamondCC_Locator = By.xpath("//img[contains(@src,'QStream+Diamond+Credit+Card1.png')]");
    By goldenCC_Locator = By.xpath("//img[contains(@src, 'QStream+Golden+Credit+Card1.png')]");
    By platinumCC_Locator = By.xpath("//img[contains(@src, 'QStream+Platinum+Credit+Card1.png')]");


    // Form Locators
    By selectCreditCardType_Locator = By.id("cardType");
    By creditCardDetailsLabel_Locator = By.id("cardDetails");


    // Enters password and submits the form if input is present

    public void enterPassword(){
       waitForElementToBeClickable(InputPassword_Locator);
       if(IsDisplayed (InputPassword_Locator)){
        String password = "qa123";
        type(InputPassword_Locator, password);
           // Submit the password input
           Submit(InputPassword_Locator);
       }else
           System.out.println("Password input was not present");
    }

    // Checks if all credit card images are present on the page
    public boolean areCreditsCardsPresent(){
        boolean diamondCC = IsDisplayed(diamondCC_Locator);
        System.out.println("Is Diamond credit card present:" + diamondCC);

        boolean goldenCC = IsDisplayed(goldenCC_Locator);
        System.out.println("Is golden credit card present:" + goldenCC);

        boolean platinumCC = IsDisplayed(platinumCC_Locator);
        System.out.println("Is platinum credit card present:" + platinumCC );

        return diamondCC && goldenCC && platinumCC;
    }

    // Selects a credit card type from the dropdown by value
public void selectCreditCardMethod(String creditCardType){
    // Scroll to the select element
        scrollIntoView(selectCreditCardType_Locator);
    // Find the select element and choose the option
        WebElement selectElement = findElement(selectCreditCardType_Locator);
        Select select = new Select(selectElement);
        //Selecting credit card by value
        select.selectByValue(creditCardType);
}

    // Gets the details text for the selected credit card
public String getCreditCardsDetails(){
        String details = getText(creditCardDetailsLabel_Locator);
        System.out.println("Credit card details:" + details);
        return details;
}


   }
