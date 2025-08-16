package clase1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import test.BaseTest;

public class XpathStrategiesTest extends BaseTest {

static HomePage homepage;

@BeforeAll
    static void InitPage(){
homepage = new HomePage(driver);
homepage.ClickOnCoursePageLink();
}

@Test
    public void AbsolutePath(){
    By AbsolutePath_Locator = By.xpath("");By.xpath("");
    WebElement element = driver.findElement(AbsolutePath_Locator);
}
}
