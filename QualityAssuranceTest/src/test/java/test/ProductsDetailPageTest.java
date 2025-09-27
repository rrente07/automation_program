package test;

import listeners.ExtentReportExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.ProductsDetailPage;

@ExtendWith(ExtentReportExtension.class)
@Tag("Products_Regression")

public class ProductsDetailPageTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ProductsDetailPageTest.class);
    static HomePage homePage;
    static ProductsDetailPage productsDetailPage;


  @BeforeAll
   static void initPageObjects(){
        homePage = new HomePage(driver);
        productsDetailPage = new ProductsDetailPage(driver);
        homePage.ClickOnProductLink(3);

    }
        //Test 1 - Verify title of product
        // Is present, text not null

    @Test
    public void verifyTitleIsPresent() {
        String currentTitle = productsDetailPage.getProductTitle();
        System.out.println("Product Title: " + currentTitle);
        Assertions.assertFalse(currentTitle.isEmpty(),"Product title is not present");
    }


    @Test
    public void verifyProductPriceIsPresent() {
        String currentPrice = productsDetailPage.getProductPrice();
        System.out.println("Product Price: " + currentPrice);
        Assertions.assertFalse(currentPrice.isEmpty(),"Product Price is not present");
    }

        // Add product Cart
        @Test
        public void AddProductToCart(){
        // setup test data
        int quantityToBuy = 3;
        String sizeToSelect = "4";
        //Store initial car quantity to verify increment
        int initialCartQty = productsDetailPage.getCarItemsQuantity();
        System.out.println("initialCarQty: " + initialCartQty);
        //Select size
         productsDetailPage.selectSize( sizeToSelect);
            System.out.println("Size selected:" + sizeToSelect);
        //Type quantity
        productsDetailPage.typeQuantity(quantityToBuy);
            System.out.println("Quantity to buy:" + quantityToBuy);
        //Add to Cart
        productsDetailPage.clickAddToCart();
            System.out.println("Clicked Add to Cart");
        //Wait for Added Message to go away
        productsDetailPage.waitForElementToDisappear();
        System.out.println("Waiting for confirmation to disappear");

            //Expected quantity
        int expectedQuantity = initialCartQty + quantityToBuy;
        System.out.println("Expected Quantity:" + expectedQuantity);
        //Waiting
            productsDetailPage.waitForCartQuantityToBeUpdated(expectedQuantity);
        //Retrieve the Real Quantity
        int currentCartItemQty = productsDetailPage.getCarItemsQuantity();
        System.out.println("currentCarItemQty:" + currentCartItemQty);
        Assertions.assertEquals(expectedQuantity, currentCartItemQty, "current Cart items qty is incorrect");
    }

    //Negative Test for the Size

   @Test
   @Disabled
   @DisplayName("Story#86ab4r2f1 - Negative Scenario for Size")
   public void verifyProductCantBeAddedIfSizeNotSelected() {

        //setup test data
        int quantityToBuy = 2;
        //Type the quantity we want to add
        productsDetailPage.typeQuantity(quantityToBuy);
       //Print the quantity we want to add
        System.out.println("Quantity to buy: " + quantityToBuy);
        productsDetailPage.clickAddToCart();
        //Verify the error message
        Assertions.assertTrue(productsDetailPage.VerifySizeErrorMsgIsPresent(),
                "Failed: Size error message is not present:");
        //Verify Cart Items Qty is 0
       int currentCartItemQty = productsDetailPage.getCarItemsQuantity();
       System.out.println("currentCarItemQty: " + currentCartItemQty);
       Assertions.assertEquals(0, currentCartItemQty, "Failed: element was added to cart: ");
     }

    //Test Negative for the quantity
    @Test
    @DisplayName("Story#86ab4r2f1 - Negative Scenario for Quantity")
    public void verifyProductCantBeAddedIfQtyIsWrong() {
        //setup test data
        int quantityToBuy = 0;
        String sizeToSelect = "2";
        //Select size
        productsDetailPage.selectSize(sizeToSelect);
        //Enter qty
        productsDetailPage.typeQuantity(quantityToBuy);
        //Add To Cart
        productsDetailPage.clickAddToCart();
        //Verify Qty error Message
        Assertions.assertTrue(productsDetailPage.VerifyQuantityErrorMsgIsPresent2(),
                "Failed: Qty Error message is not present: ");
                //Verify Cart Items Qty is 0
        int currentCartItemQty = productsDetailPage.getCarItemsQuantity();
        System.out.println("currentCarItemQty:" + currentCartItemQty);
        Assertions.assertTrue(currentCartItemQty == 0,
                "Failed: element was added to cart: ");
    }

    @Test
    void validateSizeDropdownPresence() {
        boolean isDisplayed = productsDetailPage.IsDisplayed(productsDetailPage.getSelectSizeLocator());
        Assertions.assertTrue(isDisplayed, "Dropdown the size is not visible");
        System.out.println("Is displayed: " + isDisplayed);
    }



}






