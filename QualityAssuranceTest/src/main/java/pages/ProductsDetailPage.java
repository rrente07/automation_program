package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utility;

public class ProductsDetailPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(ProductsDetailPage.class);
    //Constructor
    public ProductsDetailPage(WebDriver driver) {
        super();
    }

    //________________________________________________________________________________________________________
    // Locator for the product element
    By productTitle_Locator = By.cssSelector("h1.product-title");
    // Locator for the product price element
    By productPrice_Locator = By.className("product-price-value");
    // Locator for the size selection dropdown
    //Modificado hoy 09-05-25
    By selectSize_Locator = By.cssSelector("//select[.//option[normalize-space(.)='Select Size']");
    // Locator for the size selection dropdown
    By inputQuantity_Locator = By.className("product-quantity-input");
    // Locator for the button of quantity input field
    By addToCartBtn_Locator = By.className("sqs-add-to-cart-button-inner");
    // Locator for the "Add To Cart" button
    By addingElementMessage_Locator = By.cssSelector("div.status-text");


    //Locator for Cart quantity product version 2:: I would like to verify is both locator are the same
    By cartQuantity_Locator = By.cssSelector("div[class='showOnDesktop'] span.sqs-cart-quantity");
    //Locator for pop up with the error
    By errorMessageSize_Locator = By.xpath("//div[normalize-space()='Please select size option.']");
    By errorMessageQuantity_Locator = By.cssSelector("div.message");
    By buttonCloseErrorMessage_Locator = By.xpath("//div[@role='button'][text()='Okay']");
    //________________________________________________________________________________________________________

    //Verify size error message is Present
    public boolean VerifySizeErrorMsgIsPresent(){
boolean errorIsPresent = IsDisplayed(errorMessageSize_Locator);
        logger.info("Size error is Present:" + errorIsPresent);
        //Closing the error message
        click(buttonCloseErrorMessage_Locator);
        return errorIsPresent;
    }

    public boolean VerifyQuantityErrorMsgIsPresent(){
        boolean errorIsPresent = IsDisplayed(errorMessageQuantity_Locator);
        logger.info("Quantity error is Present:" + errorIsPresent);
        //Closing the error message
        click(buttonCloseErrorMessage_Locator);
        return errorIsPresent;
    }


    // Returns the product title text from the product details page
    public String getProductTitle() {
        return getText(productTitle_Locator);
    }

    // Return type of price as Double
    public double getProducPriceAsDouble() {
        String rawPrice = getText(productPrice_Locator);
        return Utility.extractPriceFromText(rawPrice);
    }

    // Returns the product price text from the product details page
    public String getProductPrice() {
        return getText(productPrice_Locator);
    }

    //Return product size options from the product details page
    public void selectSize(String size) {
        WebElement sizeElement = findElement(selectSize_Locator);
        Select select = new Select(sizeElement);
        select.selectByVisibleText(size);
    }

    // Returns the product quantity input value from the product details page
    public void typeQuantity(int qty) {
        type(inputQuantity_Locator, String.valueOf(qty));
    }

    //Complete the method to adding to the cart
    public void clickAddToCart() {
        scrollIntoViewAndClick(addToCartBtn_Locator);
    }

    //Wait for massage to Disappear
    public void waitForElementToDisappear() {
        waitForElementGoAway(addingElementMessage_Locator);
    }

    public int getCarItemsQuantity() {
        waitForElementToBePresent(cartQuantity_Locator);
        scrollIntoView(cartQuantity_Locator);
        int itmensQty = Integer.parseInt(getText(cartQuantity_Locator));
        return itmensQty;
    }

    public void waitForCartQuantityToBeUpdated(int quantityToBuy) {

        wait.until(driver -> {
            String qtyText = getText(cartQuantity_Locator).trim();
            return !qtyText.isEmpty() && Integer.parseInt(qtyText) == quantityToBuy;
        });
    }

}