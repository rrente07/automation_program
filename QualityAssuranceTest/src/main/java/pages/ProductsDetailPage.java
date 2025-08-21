package pages;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsDetailPage extends BasePage{

    //Constructor
    public ProductsDetailPage(WebDriver driver) {super(driver);}

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
    By productTitle_Locator = By.cssSelector("h1.ProductItem-details-title");
    By productPrice_Locator = By.cssSelector("div.product-price");
    By selectSize_Locator = By.cssSelector("select[aria-label='Select Size']");
    By inputQuantity_Locator = By.cssSelector("input[aria-label='Quantity']");
    By addToCartBtn_Locator = By.cssSelector("div[role='button'][data-original-label='Add To Cart']");
    By addingElementMessage_Locator = By.cssSelector("div.status-text");
//________________________________________________________________________________________________________





}
