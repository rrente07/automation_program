package pages;

import data.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


// define the locator that we see in the view and the method who help to validate all of this
public class HomePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);
    /**
     * Represents the Home Page and provides methods to interact with its elements.
     */
    public HomePage(WebDriver driver) {
        super();
    }


    // Header locators
    /** Locator for the "QualityStream Credit card" link in the header */
    By qsCreditCardLink_Locator = By.cssSelector("div.header-nav-wrapper a[href='/qualitystream-credit-cards']");
    /** Locator for the "YouTube" icon in the header */
    By headerYoutubeIcon_Locator = By.cssSelector("div.header-actions.header-actions--right a[aria-label='YouTube']");
    /** Locator for the "Courses" page link in the header */
    By coursePageLink_Locator = By.cssSelector("div.header-nav-wrapper a[href='/formpage']");
    /** Locator for the "WebElement Test" link in the header */
    By webElementTestLink_Locator = By.cssSelector("div.header-nav-wrapper a[href='/webelements-test']");

    //Filter
    /** Locator for the bottoms filter link */
    By bottomsLink_Locator = By.xpath("//a[@href='/shop/bottoms']");
    /** Locator for the tops filter link */
    By topsLink_Locator = By.xpath("//a[@href='/shop/tops']");
    /** Locator for the all products filter link */
    By allLinks_Locator = By.xpath("//a[@href='/shop']");


     //Footer
    /** Locator for the footer logo */
    By footerLogo_Locator = By.xpath("//footer//img[contains(@src='website_logo_transparent_background.png'] ");

    //Products
    /** Locator for the list of product links Changed 09-05-25 */
    By productsLinksList_Locator = By.cssSelector("a.product-list-item-link");
    /** Locator for the list of product titles */
    By productTitleList_Locator = By.cssSelector("div.grid-title");
    /** Locator for the list of product prices */
    By productPriceList_Locator = By.cssSelector("div.grid-prices");




    /** Clicks the course page link in the header */
    public void ClickOnCoursePageLink(){ click(coursePageLink_Locator);}

    /** Clicks the "Web Element Test" link in the header */
    public void ClickOnWebElementLink(){ click(webElementTestLink_Locator);
    }

    /** Clicks the credit cards link in the header */
     public void ClickOnCreditCardsLink(){click(qsCreditCardLink_Locator);
    }
    /**
     * Clicks the product link at the specified index in the product list
     * @param index Index of the product to click
     */
    public void ClickOnProductLink(int index){
        List<WebElement> productLinks = findElements(productsLinksList_Locator);
        scrollIntoViewAndClick(productLinks.get(index));
    }
    /**
     * Checks if the YouTube icon in the header is displayed
     * @return true if displayed, false otherwise
     */
    public boolean IsHeaderYtbIconDisplayed(){
       boolean isDisplayed = IsDisplayed(headerYoutubeIcon_Locator);
       System.out.println("Is YtbIcon present?" + isDisplayed);
       return isDisplayed;
    }
    /**
     * Checks if both the tops and bottoms filter links are present
     * @return true if both are present, false otherwise
     */
public boolean AreFilterPresent(){
        boolean TopLinkIspresent = IsDisplayed(topsLink_Locator);
        boolean bottomLinkIsPresent = IsDisplayed(bottomsLink_Locator);
        System.out.println("Is the Top Link Present?" + TopLinkIspresent);
        System.out.println("Is the Link Present?" + bottomLinkIsPresent);
        return  TopLinkIspresent && bottomLinkIsPresent;
}
    /**
     * Checks if the footer logo is present
     * @return true if present, false otherwise
     */
public boolean IsLogoPresent(){
        boolean Footerlogo_IsPresent = IsDisplayed(footerLogo_Locator);
        System.out.println("The button link is Displayed" + Footerlogo_IsPresent);
        return Footerlogo_IsPresent;
}
    /**
     * Retrieves the list of products with their titles and prices
     * @return List of Product objects
     */


    public List<Product> getProducts() {
        List<WebElement> titlesList = findElements(productTitleList_Locator);
        List<WebElement> pricesList = findElements(productPriceList_Locator);
        List<Product> productsList = new ArrayList<>();

        for (int i = 0; i < titlesList.size(); i++) {

            scrollIntoView(titlesList.get(i));
            String title = getText(titlesList.get(i)).trim();
            System.out.println("title: " + title);

            String rawPrice = getText(pricesList.get(i)).trim();

            //Keeping only numbers and dots. Replacing the rest with space
            String cleanedPrice = rawPrice.replaceAll("[^0-9.]", " ").trim();

            //Taking the first number
            String firstNumber = cleanedPrice.split("\\s+")[0];
            System.out.println("firstNumber: " + firstNumber);
            double price = Double.valueOf(firstNumber);

            productsList.add(new Product(i, title, price));

        }

        return productsList;

    }

}