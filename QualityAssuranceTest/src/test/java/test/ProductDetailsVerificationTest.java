package test;

import data.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.ProductsDetailPage;

import java.util.List;

public class ProductDetailsVerificationTest extends BaseTest {

        static HomePage homePage;
        static ProductsDetailPage productsDetailPage;

    public ProductDetailsVerificationTest() {
    }

    @BeforeAll
        static void initPage(){
            homePage = new HomePage(driver);
            productsDetailPage = new ProductsDetailPage(driver);
        }

    // Test that verifies the selected product's title and price match the expected values from the product list.
        @Test
    void VerifyTitleAndPriceForSelectedProduct(){
            // Retrieve the list of products displayed on the home page.
        List<Product> products_List = homePage.getProducts();
             // Cuando implementemos Data Driven Testing
            // vamos a iterar por los indices
            int index = 2;
            // Get the expected title and price of the product at the specified index from the product list.
            String expectedTitle = products_List.get(index).getTitle();
            double expectedPrice = products_List.get(index).getPrice();

            // Navigate to the product detail page
            homePage.ClickOnProductLink(index);

            // Retrieve the actual product title from the detail page
            String currentTitle = productsDetailPage.getProductTitle();

            // Print the expected and actual product titles for debugging
            System.out.println(" ----------> expectedTitle" + currentTitle + "\n ----------> currentTitle" + currentTitle );

            // Assert that the actual title matches the expected title
            Assertions.assertEquals(expectedTitle, currentTitle, "Selected Product Title is not the expected");

            // Retrieve the actual product price from the detail page
            double currentPrice = productsDetailPage.getProducPriceAsDouble();

            // Print the expected and actual product prices for debugging
            System.out.println("----------> expectedPrice:" + expectedPrice + "\n -->current Price:" + currentPrice);

            // Assert that the actual price matches the expected price
            Assertions.assertEquals(expectedPrice, currentPrice, "Selected Product Price is not the expected");




        }
}
