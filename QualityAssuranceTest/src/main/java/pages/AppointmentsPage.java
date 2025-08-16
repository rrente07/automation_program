package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentsPage extends BasePage {

    //Constructor
    public AppointmentsPage(WebDriver driver) {
        super(driver);
    }

    By textAppointmentHeader_Locator = By.cssSelector("div.sqsrte-scaled-text-container.loaded h2");
    By appointmentBookButton_Locator =By.cssSelector("div>button.btn.css-1edjh51");
    By checkCodeBalanceLinkText_Locator = By.cssSelector(".css-19p0dx4[@href='Check Code Balance']");
    By selectCalendarText_Locator = By.cssSelector(".css-14ff62y[@href='Select Calendar']");
    By buttonCalendarArrowButton_Locator = By.className("button.css-7sub3h");
    By appointmentText_Locator = By.cssSelector("div > h3 > a[href='Appointment']");
    By anyAvailableText_Locator = By.cssSelector("div>p.css-roynbj.p");

    //When I click on select Button, I need to check:



    //1. Appointment text isDisplayed
    //2.

}
