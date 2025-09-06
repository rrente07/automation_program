package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import static org.junit.jupiter.api.Assertions.*;

public class HomeTest extends BaseTest {

     static HomePage homePage;
    @BeforeAll
    static void initPage() {
homePage = new HomePage(driver);
    }

    @Test
    @Tag("AlertTest_Regression")
    void verifyYtbIconHeader() {
        boolean isYoutubeIconPresent = homePage.IsHeaderYtbIconDisplayed();
        assertTrue(isYoutubeIconPresent, "The Youtube Icon is not Present in the Header:");
    }

    @Test
    void verifyLinkBottom() {
        boolean isLinkBottom = homePage.AreFilterPresent();
        assertTrue(isLinkBottom, "the filter is not present:" );
    }

    //Test to verify is the QS logo is present
    @Test
    void VerifyFooterLogo() {
        boolean isLogoPresent = homePage.IsLogoPresent();
        System.out.println("the logo is present:" + isLogoPresent );
        assertTrue(isLogoPresent, "the logo is no present:");
    }
}
