package clase1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import test.BaseTest;
import utils.Utility;

import static test.BaseTest.driver;

public class XpathStrategiesTest extends BaseTest {

    static HomePage homepage;

    @BeforeAll
    static void InitPage() {
        homepage = new HomePage(driver);
        homepage.ClickOnCoursePageLink();
    }

    @Test
    public void AbsolutePath() {
        By AbsolutePath_Locator = By.xpath("//input[]");
        WebElement element = driver.findElement(AbsolutePath_Locator);
        Utility.printElementInfo("Absolute Path", element);
    }

    //Xpath using Tag Name
    @Test
    public void TagNameTest() {
        By TagName_Locator = By.xpath("//input[@type=]");
        WebElement element = driver.findElement(TagName_Locator);
        Utility.printElementInfo("Tag Name", element);
    }

    //Xpath using Tag Name + Attribute
    @Test
    public void TagNameAttr() {
        By TagNameAttr_Locator = By.xpath("//input[@type=`text']");
        WebElement element = driver.findElement(TagNameAttr_Locator);
        Utility.printElementInfo("Tag Name Attribute", element);
    }

    //Atributo Class
    @Test
    void ClassAttributeTest() {
        By ClassAttribute_Locator = By.xpath("//img[@class='thumbnail']");
        WebElement element = driver.findElement(ClassAttribute_Locator);
        Utility.printElementInfo("Class Attribute", element);
    }

    //Any tag with attribute + value
    @Test
    void AnyTagWithAttributeValueTest() {
        By AnyTagWithAttributeValue_Locator = By.xpath("//input[@type='text']");
        WebElement element = driver.findElement(AnyTagWithAttributeValue_Locator);
        Utility.printElementInfo("Any Tag with Attribute Value", element);
    }

    @Test
    void testAttrValue() {
        By MultipleAttributes_Locator = By.xpath("//input[@id='name']");
        WebElement element = driver.findElement(MultipleAttributes_Locator);
        Utility.printElementInfo("Multiple Attributes", element);
    }

    @Test
    void testAttrClass() {
        By imgThumbnail_Locator = By.xpath("//img[@class='thumbnail']");
        WebElement element = driver.findElement(imgThumbnail_Locator);
        Utility.printElementInfo("Image Thumbnail", element);

    }

    @Test
    void AnyTag() {
        By AnyTag_Locator = By.xpath("//*[name='lastName']");
        WebElement element = driver.findElement(AnyTag_Locator);
        Utility.printElementInfo("Any Tag", element);
    }

    @Test
    void testContains() {
        By Contains_Locator = By.xpath("//input[contains(@id,'name')]");
        WebElement element = driver.findElement(Contains_Locator);
        Utility.printElementInfo("Contains", element);
    }

    @Test
    void testFunctionText(){
        By labelAPITesting_Locator = By.xpath("//label[text()='API testing!']");
        WebElement element = driver.findElement(labelAPITesting_Locator);
        Utility.printElementInfo("TextFunction", element);
    }

    @Test
    void testFunctionContainsText() {
        By ContainsText_Locator = By.xpath("//input[contains(@text(),'appointment')]");
        WebElement element = driver.findElement(ContainsText_Locator);
        Utility.printElementInfo("Appointment", element);
    }
    @Test
    void testFunctionStartWithText() {
        By StartWith_Locator = By.xpath("//a[starts-with(text(),'Go to')]");
        WebElement element = driver.findElement(StartWith_Locator);
        Utility.printElementInfo("Appointment", element);
    }

    @Test
    void Hierarchy(){
        By FindByHierarchy_Locator = By.xpath("[//table/..']");
        WebElement element = driver.findElement(FindByHierarchy_Locator);
        Utility.printElementInfo("Hierarchy", element);
    }

    @Test
    void textPathIndex1(){
            By FindPathIndex1Locator = By.xpath("['//Input[1]']");
            WebElement element = driver.findElement(FindPathIndex1Locator);
            Utility.printElementInfo("PathIndex", element);
    }
    @Test
    void textPathIndex1AnyFather(){
        By FindPathIndex1AnyFatherLocator = By.xpath("['(//Input)[1]']");
        WebElement element = driver.findElement(FindPathIndex1AnyFatherLocator);
        Utility.printElementInfo("PathIndex", element);
    }
}
