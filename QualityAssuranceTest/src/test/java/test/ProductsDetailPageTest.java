package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProductsDetailPage;

public class ProductsDetailPageTest extends BaseTest {

    static HomePage homePage;
    static ProductsDetailPage productsDetailPage;

    public ProductsDetailPageTest() {
    }

    @BeforeAll
   static void initPage(){
        homePage = new HomePage(driver);
        productsDetailPage = new ProductsDetailPage(driver);
        homePage.ClickOnProductLink(2);

    }
        //Test 1 - Verify title of product
        // Is present, text not null
    @Test
        void VerifyTitleIsPresent() {
        String current_title = productsDetailPage.getProductTitle();
        System.out.println("product title: " + current_title);
        Assertions.assertFalse(current_title.isEmpty(), "Product title is not present");
    }
        // Test 1.2 - Verify price of product
        // Is present, text not null
        @Test
        void VerifyProductPriceIsPresent(){
            String current_price = productsDetailPage.getProductPrice();
            System.out.println("product price:" + current_price);
            Assertions.assertFalse(current_price.isEmpty(), "Product price is not present");
        }

        // Add product Cart
        @Test
    void AddProductToCart(){
        // setup test data
        int quantityToBy = 2;
        String sizeToSelect = "4";

        //Store initial car quantity to verify increment
        int initialCartQty = productsDetailPage.getCarItemsQuantity();
        System.out.println("initialCarQty: " + initialCartQty);

        //Select size
        productsDetailPage.selectSize( sizeToSelect);

        //Type quantity
        productsDetailPage.typeQuantity(quantityToBy);

        //Add to Cart
        productsDetailPage.clickAddToCart();

        //Wait for Added Message to go away
        productsDetailPage.waitForElementToDisappear();

        //Expected quantity
        int expectedQuantity = initialCartQty + quantityToBy;
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
   @DisplayName("Story#86ab4r2f1 - Negative Scenario for Size")
    void verifyProductCantBeAddedIfSizeNotSelected() {

        //setup test data
        int quantityToBuy = 2;
        //Type the quantity we want to add
        productsDetailPage.typeQuantity(quantityToBuy);
       //Print the quantity we want to add
        System.out.println("Quantity to buy: " + quantityToBuy);

        productsDetailPage.clickAddToCart();

        //Verificar el mensaje de error
        Assertions.assertTrue(productsDetailPage.VerifySizeErrorMsgIsPresent(),
                "Failed: Size error message is not present:");

        //Verify Cart Items Qty is 0
       int currentCartItemQty = productsDetailPage.getCarItemsQuantity();
       System.out.println("currentCarItemQty: " + currentCartItemQty);

       Assertions.assertTrue(currentCartItemQty == 0,
               "Failed: element was added to cart: ");

     }
    //Test Negativo para la cantidad
    @Test
    @DisplayName("Story#86ab4r2f1 - Negative Scenario for Quantity")
    void verifyProductCantBeAddedIfQtyIsWrong() {
        //setup test data
        int quantityToBuy = 0;
        String sizeToSelect = "4";

        //Select size
        productsDetailPage.selectSize(sizeToSelect);

        //Enter qty
        productsDetailPage.typeQuantity(quantityToBuy);

        //Add To Cart
        productsDetailPage.clickAddToCart();

        //Verify Qty error Message
        Assertions.assertTrue(productsDetailPage.VerifyQuantityErrorMsgIsPresent(),
                "Failed: Qty Error message is not present: ");

        //Verify Cart Items Qty is 0
        int currentCartItemQty = productsDetailPage.getCarItemsQuantity();
        System.out.println("currentCarItemQty:" + currentCartItemQty);

        Assertions.assertTrue(currentCartItemQty == 0,
                "Failed: element was added to cart: ");



    }

}






