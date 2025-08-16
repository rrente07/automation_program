package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


// define the locator that we see in the view and the method who help to validate all of this
public class HomePage extends BasePage {
    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Header links locator
    By qsCreditCardLink_Locator = By.cssSelector("div.header-nav-wrapper a[href='/qualitystream-credit-cards']");
    By headerYoutube_Locator = By.cssSelector("div.header-actions.header-actions--right a[aria-label='YouTube']");
    By coursePageLink_Locator = By.cssSelector("div.header-nav-wrapper a[href='/formpage']");
    By webElementTestLink_Locator = By.cssSelector("div.header-nav-wrapper a[href='/webelements-test']");
    By qsFooterlogo_Locator = By.xpath("//footer//img[contains(@src='website_logo_transparent_background.png'] ");
    By AppointmentLink_Locator = By.cssSelector("");
    //Filter
    By bottomsLink_Locator = By.xpath("//a[@href='/shop/bottoms']");
    By topsLink_Locator = By.xpath("//a[@href='/shop/tops']");
    By allLinks_Locator = By.xpath("//a[@href='/shop']");

    public void ClickOnCoursePageLink(){
    click(coursePageLink_Locator);

}

    public void ClickOnCreditCardsLink(){
        click(qsCreditCardLink_Locator);
    }

    public void ClickOnWebElementTestLink(){
        click(webElementTestLink_Locator);
    }


public void ClickOnCreditCardsLink(){
        click(qsCreditCardLink_Locator);
    }

    public boolean IsHeaderYtbIconDisplayed(){
       boolean isDisplayed = IsDisplayed(headerYoutube_Locator);
       System.out.println("Is YtbIcon present?" + isDisplayed);
       return isDisplayed;
    }
public boolean AreFilterPresent(){
        boolean TopLinkIspresent = IsDisplayed(topsLink_Locator);
        boolean bottomLinkIsPresent = IsDisplayed(bottomsLink_Locator);
        System.out.println("Is the Top Link Present?" + TopLinkIspresent);
        System.out.println("Is the Link Present?" + bottomLinkIsPresent);
        return  TopLinkIspresent && bottomLinkIsPresent;
}

public boolean IsLogoPresent(){
        boolean Footerlogo_IsPresent = IsDisplayed(qsFooterlogo_Locator);
        System.out.println("The button link is Displayed" + Footerlogo_IsPresent);
        return Footerlogo_IsPresent;
}






}