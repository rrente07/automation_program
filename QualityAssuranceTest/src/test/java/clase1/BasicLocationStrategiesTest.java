package clase1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import test.BaseTest;
import utils.Utility;

public class BasicLocationStrategiesTest extends BaseTest {
static HomePage homepage;

@BeforeAll
    static void initPage(){
    homepage = new HomePage(driver);
    homepage.ClickOnCoursePageLink();
}

@Test
    public void testID(){
By InputName_Locator = By.id("name");
// guardando en elemento el resultado
    WebElement element = driver.findElement(InputName_Locator);
    Utility.printElementInfo("Input Name ", element);

    }

    @Test
    public void TestText(){
    By InputEmail_Locator = By.name("email");
    //guardando el elemento

        WebElement element = driver.findElement(InputEmail_Locator);
        Utility.printElementInfo("Input Email", element);

    }

    @Test
    public void TestClassName(){
    By ImageThumbnail_Locator = By.className("thumbnail");
    WebElement element = driver.findElement(ImageThumbnail_Locator);
    Utility.printElementInfo("Input Image", element);
    }

    @Test
    public void TestTagName(){
    By TagName_Locator = By.tagName("table");
    WebElement element = driver.findElement(TagName_Locator);
    Utility.printElementInfo("Input Tag", element);

    }

    @Test
    public void TestLinkText(){
    By LinkText_Locator = By.linkText("Go to Appointment Page");
    WebElement element = driver.findElement(LinkText_Locator);
    Utility.printElementInfo("Text Link", element);

    }

    @Test
    public void TestPartialLinkText(){
        By PartialLinkText_Locator = By.linkText("Go to");
        WebElement element = driver.findElement(PartialLinkText_Locator);
        Utility.printElementInfo("Text Link", element);

    }
//By TextAppointmentHeader_Locator = By.cssSelector("div.sqsrte-scaled-text-container.loaded h2");
    @Test
    public void TextAppointmentHeader(){
        By TextAppointmentHeader_Locator = By.cssSelector("div.sqsrte-scaled-text-container.loaded h2");
        WebElement element = driver.findElement(TextAppointmentHeader_Locator);
        Utility.printElementInfo("Text Link", element);

    }



}
