package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppointmentsPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentsPage.class);
    //Constructor
    public AppointmentsPage(WebDriver driver) {
        super();
    }

    By textAppointmentHeader_Locator = By.cssSelector("div.sqsrte-scaled-text-container h2");
    By appointmentBookButton_Locator =By.xpath("(//li[contains(@class,'select-item select-item-box')]//button)[1]");
    By checkCodeBalanceButton_Locator = By.cssSelector("footer button");
    By selectCalendarText_Locator = By.xpath("//h2[text()='Select Calendar']");
    By buttonCalendarArrowButton_Locator = By.cssSelector("//nav[@id='pylon-nav']//button");
    By appointmentTextHeader_Locator = By.cssSelector("(//div[h3])[1]");
    By anyAvailableText_Locator = By.cssSelector("(//div//p)[4]");
    By joaquimText_Locator = By.cssSelector("(//div//p)[5]");
    //When I click on select Button, I need to check:



    //1. Appointment text isDisplayed
    //2.

}
