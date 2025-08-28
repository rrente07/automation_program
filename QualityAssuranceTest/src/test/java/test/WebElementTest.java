package test;

import org.junit.jupiter.api.BeforeAll;
import pages.HomePage;
import pages.WebElementPage;

public class WebElementTest extends BaseTest{
    static HomePage homePage;
    static WebElementTest webElementTestPage;
    @BeforeAll
    static void initPage() {
        homePage = new HomePage(driver);
        homePage.ClickOnWebElementTestLink();
    }




}
