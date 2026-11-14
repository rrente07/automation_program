package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utility;

import java.time.Duration;
import java.util.List;

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
    By productPrice_Locator = By.cssSelector("div.product-price-value");
    // Locator for the size selection dropdown
    //Modificado hoy 09-05-25
    By selectSize_Locator = By.name("variant-option-Size-select");
    // Locator for the size selection dropdown
    By inputQuantity_Locator = By.className("product-quantity-input");
    // Locator for the button of quantity input field
    By addToCartBtn_Locator = By.className("sqs-add-to-cart-button-inner");
    // Locator for the "Add To Cart" button
    By addingElementMessage_Locator = By.cssSelector("div.status-text");
    //Locator for Cart quantity product version 2:: I would like to verify is both locator are the same
    //By cartQuantity_Locator = By.cssSelector("div[class='showOnDesktop'] span.sqs-cart-quantity");
    By cartQuantity_Locator = By.cssSelector("div.showOnDesktop div.icon-cart-quantity span.sqs-cart-quantity");
    //Locator for pop up with the error
    By errorMessageSize_Locator = By.xpath("//div[normalize-space()='Please select size option.']");
    By errorMessageQuantity_Locator = By.className("message");
    By buttonCloseErrorMessage_Locator = By.xpath("//div[@role='button' and contains(@class,'confirmation-button') and @tabindex='0' and normalize-space(text())='Okay']");
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
    public boolean VerifySizeErrorMsgIsPresent2() {
        boolean errorIsPresent = IsDisplayed(errorMessageSize_Locator);
        logger.info("Size error is Present1:" + errorIsPresent);
        // Close the message
        clickVisibleOkayButton();
        return errorIsPresent;
    }
    public boolean VerifyQuantityErrorMsgIsPresent2() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageQuantity_Locator));
        boolean errorIsPresent = IsDisplayed(errorMessageQuantity_Locator);
        logger.info("Quantity error is Present1:" + errorIsPresent);
        //Close the message
        if (errorIsPresent) {
            clickVisibleOkayButton();
        } else {
            logger.warn("No error message present, skipping modal close.");
        }
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
        WebElement qtyField = findElement(inputQuantity_Locator);
        qtyField.clear();
        qtyField.sendKeys(String.valueOf(qty));
        qtyField.sendKeys(Keys.TAB);
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
        try {
            wait.until(driver -> {
                String qtyText = getText(cartQuantity_Locator).trim();
                System.out.println("Cart quantity visible: " + qtyText);
                if (!qtyText.isEmpty()) {
                    int currentQty = Integer.parseInt(qtyText);
                    System.out.println("Comparing: expected=" + quantityToBuy + ", actual=" + currentQty);
                    return currentQty == quantityToBuy;
                }
                return false;
            });
        } catch (TimeoutException e) {
            throw new TimeoutException("Cart quantity did not update to expected value: " + quantityToBuy);
        }
    }
    public By getSelectSizeLocator() {
        return selectSize_Locator;
    }
       // Method visible and return message
    public String checkElementVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed() ? "Element is visible on the page." : "Element is not visible on the page.";
        } catch (TimeoutException e) {
            return "Element is not visible after waiting 10 seconds.";
        }
      }
    public void clickVisibleOkayButton() {
        try {
            // Wait for element to be present and clickable
            wait.until(ExpectedConditions.presenceOfElementLocated(buttonCloseErrorMessage_Locator));
            wait.until(ExpectedConditions.visibilityOfElementLocated(buttonCloseErrorMessage_Locator));
            List<WebElement> buttons = findElements(buttonCloseErrorMessage_Locator);
            for (WebElement button : buttons) {
                if (button.isDisplayed() && button.isEnabled()) {
                    scrollIntoView(button);
                    waitForElementToBeClickable(button);
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", button);
                    logger.info("Clicked visible 'Okay' button via JavaScript.");
                    return;
                }
            }
        } catch (TimeoutException e) {
            logger.warn("Timeout waiting for 'Okay' button.");
        }
        throw new NoSuchElementException("No visible and clickable 'Okay' button found.");
    }
}