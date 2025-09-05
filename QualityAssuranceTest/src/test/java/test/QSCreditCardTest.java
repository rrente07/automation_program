package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.QSCreditCardsPage;
import pages.HomePage;

    public class QSCreditCardTest extends BaseTest{
    private static final Logger logger = LoggerFactory.getLogger(QSCreditCardTest.class);
    private final String creditCardsCSVFile = "/files/creditCards.csv";
    static HomePage homePage;
    static QSCreditCardsPage qsCreditCardsPage;

    @BeforeAll
    static void initPageObjects() {
        homePage = new HomePage(driver);
        qsCreditCardsPage = new QSCreditCardsPage(driver);
        homePage.ClickOnCreditCardsLink();
        qsCreditCardsPage.enterPassword();
    }

    @Test
    void areCreditCardsImagesPresent() {
        Assertions.assertTrue(qsCreditCardsPage.areCreditsCardsPresent(),
                "Failed: Credit Cards images are not present.");
    }

    @Test
    void areCreditCardsDetailsCorrect(){

        //En otra clase veremos cómo parametrizar este Test
        String type = "diamond";
        String expectedText = "Interés: 18.81% Anual Fee: $550";


        qsCreditCardsPage.selectCreditCardMethod(type);


        String ccDetails = qsCreditCardsPage.getCreditCardsDetails();

        logger.info("Expected: " + expectedText +"\n Current: "+ccDetails);

        Assertions.assertEquals(expectedText,ccDetails,"CC details are incorrect");

    }
    @ParameterizedTest
    @CsvFileSource (resources = creditCardsCSVFile, numLinesToSkip = 1)
    void areCreditCardsDetailsCorrect_DDT( String type,  String expectedText){

        qsCreditCardsPage.selectCreditCardMethod(type);
        String ccDetails = qsCreditCardsPage.getCreditCardsDetails();
        logger.info("Expected: " + expectedText +"\n Current: "+ccDetails);
        Assertions.assertEquals(expectedText,ccDetails,"CC details are incorrect");

    }


}


