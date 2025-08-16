package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.QSCreditCardsPage;
import pages.HomePage;

public class CreditCardTest extends BaseTest{

    static QSCreditCardsPage creditCardPage;
    static HomePage homePage;

    @BeforeAll
    static void InitPageObjects() {
        homePage = new HomePage(driver);
        creditCardPage = new QSCreditCardsPage(driver);

        homePage.ClickOnCreditCardsLink();
        creditCardPage.enterPassword();
    }

    @Test
    public void AreCreditCardImagePresent(){
     assertTrue(creditCardPage.areCreditsCardsPresent(),
                "Failed: The Credit Cards Image are not present");
    }

    @Test
    public void VerifyDiamondTextUpdated() {
        String type = "diamond";
       creditCardPage.selectCreditCardMethod(type);
        String CardDetails;
        CardDetails = creditCardPage.getCreditCardsDetails();
        assertEquals(CardDetails, "Interés: 18.81% Anual Fee: $550");

    }
    }

