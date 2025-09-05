package test;

import data.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.ProductsDetailPage;

import java.util.List;

public class ProductDetailsVerificationTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(ProductDetailsVerificationTest.class);
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
    public void verifyTitleAndPriceForSelectedProduct() {

        List<Product> products_List = homePage.getProducts();

        //Cuando implementemos Data Driven Testing
        //vamos a iterar por los indices
        int index = 4;
        String expectedTitle = products_List.get(index).getTitle();
        double expectedPrice = products_List.get(index).getPrice();

        homePage.ClickOnProductLink(index);

        String currentTitle = productsDetailPage.getProductTitle();

        System.out.println("--> expectedTitle: "+expectedTitle +
                "\n --> currentTitle: "+currentTitle);
        Assertions.assertEquals(expectedTitle,currentTitle,"Selected Product Title is not the expected");

        double currentPrice = productsDetailPage.getProducPriceAsDouble();

        System.out.println("--> expectedPrice: "+expectedPrice +
                "\n --> currentPrice: "+currentPrice);
        Assertions.assertEquals(expectedPrice,currentPrice,"Selected Product Price is not the expected");

    }
}
