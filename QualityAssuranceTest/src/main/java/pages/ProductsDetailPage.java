package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Utility;

public class ProductsDetailPage extends BasePage {

    //Constructor
    public ProductsDetailPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    By ProductDetailsTitleText_Locator = By.className("ProductItem-details-title");
    By ProductsDetailsPriceText_Locator = By.className("product-price");
    By ProductDetailsDescriptionTextTitleCode_Locator = By.xpath("pre>code");
    By ProductDetailsDescriptionTextDescription_Locator = By.xpath("//pre/following-sibling::p");
    By ProductDetailsDescriptionText_Locator = By.xpath("//pre//code[contains(. , 'DETAILS')]");
    By ProductDetailsListText_Locator = By.xpath("//ul//p[@class = white-space:pre-wrap//li[1]]");
    By ProductSizeSelector_Loccator = By.cssSelector("select[aria-label='Select Size']");
    By ProductQuantityInput_Locator = By.cssSelector("input[aria-label='Quantity']");
    By ProductAddtoCartBttn_Locator = By.className("sqs-add-to-cart-button-inner");
    By ProductoImage_Locator = By.xpath("//div//img[@class = ('ProductItem-gallery-slides-item-image')]");
    //________________________________________________________________________________________________________
    // Locator for the product title element
    By productTitle_Locator = By.cssSelector("h1.ProductItem-details-title");
    // Locator for the product price element
    By productPrice_Locator = By.cssSelector("div.product-price");
    // Locator for the size selection dropdown
    By selectSize_Locator = By.cssSelector("select[aria-label='Select Size']");
    // Locator for the size selection dropdown
    By inputQuantity_Locator = By.cssSelector("input[aria-label='Quantity']");
    // Locator for the button of quantity input field
    By addToCartBtn_Locator = By.cssSelector("div[role='button'][data-original-label='Add To Cart']");
    // Locator for the "Add To Cart" button
    By addingElementMessage_Locator = By.cssSelector("div.status-text");
    //Locator for Cart quantity product
    //By addingCartTextNumberSpan_Locator = By.xpath("(//span[@class='sqs-cart-quantity'])[2]");
    //Locator for Cart quantity product version 2:: I would like to verify is both locator are the same
    By carQuantity_Locator = By.xpath("(//div[@class='showOnDesktop']//span[@class='sqs-cart-quantity'])[1]");
    //Locator for pop up with the error
    By errorMessageSize_Locator = By.xpath("//div[normalize-space()='Please select size option.']");
    By errorMessageQuantity_Locator = By.xpath("//div[normalize-space()='You must add a quantity greater than zero.']");
    By buttonCloseErrorMessage_Locator = By.xpath("//div[@role='button'][text()='Okay']");
    //________________________________________________________________________________________________________

    //Verify size error message is Present
    public boolean VerifySizeErrorMsgIsPresent(){
boolean errorIsPresent = IsDisplayed(errorMessageSize_Locator);
        System.out.println("Size error is Present:" + errorIsPresent);
        //Closing the error message
        click(buttonCloseErrorMessage_Locator);
        return errorIsPresent;
    }

    public boolean VerifyQuantityErrorMsgIsPresent(){
        boolean errorIsPresent = IsDisplayed(errorMessageQuantity_Locator);
        System.out.println("Quantity error is Present:" + errorIsPresent);
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
        ScrollIntoViewAndClick(addToCartBtn_Locator);
    }

    //Wait for massage to Disappear
    public void waitForElementToDisappear() {
        waitForElementGoAway(addingElementMessage_Locator);
    }

    public int getCarItemsQuantity() {
        waitForElementToBePresent(carQuantity_Locator);
        scrollIntoView(carQuantity_Locator);
        int itmensQty = Integer.parseInt(getText(carQuantity_Locator));
        return itmensQty;
    }

    public void waitForCartQuantityToBeUpdated(int quantityToBuy) {

        wait.until(driver -> {
            String qtyText = getText(carQuantity_Locator).trim();
            return !qtyText.isEmpty() && Integer.parseInt(qtyText) == quantityToBuy;
        });
    }

}