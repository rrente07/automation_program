package clase1;

import org.junit.jupiter.api.BeforeAll;
import pages.HomePage;
import test.BaseTest;

public class RelativeLocatorsTest extends BaseTest {

    static HomePage homePage;

    @BeforeAll
    static void InitPage(){
homePage = new HomePage(driver);
homePage.ClickOnWebElementTestLink();
    }



}
