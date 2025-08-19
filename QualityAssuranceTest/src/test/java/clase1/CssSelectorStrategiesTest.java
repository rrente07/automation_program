package clase1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import test.BaseTest;
import utils.Utility;

import java.util.List;

public class CssSelectorStrategiesTest extends BaseTest{
        static HomePage homepage;

        @BeforeAll
        static void initPage(){
            homepage = new HomePage(driver);
            homepage.ClickOnCoursePageLink();
        }


        //Tag Name - devuelve 12
    @Test
    public void TagNameTest(){
    By TagName_Locator = By.cssSelector("input");
        WebElement element = driver.findElement(TagName_Locator);
        Utility.printElementInfo("Tag", element);

    }
//Tag name + Attribute
    @Test
    public void TagNameAttr(){
        By TagNameAttr_Locator = By.cssSelector("input[type]");
        WebElement element = driver.findElement(TagNameAttr_Locator);
        Utility.printElementInfo("tag attribute", element);

    }
//Tag Name Attribute + Value
    @Test
    public void TagNameAttrValue(){
            By TagNameAttrValue_Locator = By.cssSelector("input[type='text']");
            WebElement element = driver.findElement(TagNameAttrValue_Locator);
            Utility.printElementInfo("Tag name", element);
    }
//ID using #

    @Test
    public void TestID(){
            By InputEmail_Locator = By.cssSelector("#email");
            WebElement element = driver.findElement(InputEmail_Locator);
            Utility.printElementInfo("Email ID", element);
    }

    //Tag + ID using #

    @Test
    public void TestTag(){
            By TagID_Locator = By.cssSelector("input#email");
            WebElement element = driver.findElement(TagID_Locator);
            Utility.printElementInfo("class", element);
    }
//Class using "."
    @Test
    public void TestClass() {
        By TestClass_Locator = By.cssSelector(".thumbnail");
        WebElement element = driver.findElement(TestClass_Locator);
        Utility.printElementInfo("Class", element);
    }
// Tag y Class using "."

      @Test
        public void TagClassTest()
    {
            By ClassTagTest_Locator = By.cssSelector("img.thumbnail");
            WebElement element = driver.findElement(ClassTagTest_Locator);
            Utility.printElementInfo("Tag", element);
    }

    //Using to get eny elements or all
    @Test
    public void AllElement(){
            By AllElement_Locator = By.cssSelector("*[type=checkbox]");
WebElement element = driver.findElement(AllElement_Locator);
    }

    //Father-son relationship
    @Test
    public void FatherSonTest(){
            By Fatherson_Locator = By.cssSelector("form>select");
            WebElement element = driver.findElement(Fatherson_Locator);
            Utility.printElementInfo("father", element);
}
//siblings
    @Test
    public void Siblings(){
            By Sibling_Locator = By.cssSelector("form+table");
            WebElement element = driver.findElement(Sibling_Locator);
            Utility.printElementInfo("Siblings", element);
        }

        //Relation sucesor

    @Test
   public void TestSuccessor(){
            By successor_Locator = By.cssSelector("div[class='sqs-block-content'] img");
            WebElement element = driver.findElement(successor_Locator);
            Utility.printElementInfo("successor", element);

    }

    //Me falto ~=





    //Partial Match ends with - " $= "
@Test
    public void EndsSpecificText (){
            By EndsSpecificText_Locator = By.cssSelector("input[type$='ate']");
            WebElement element = driver.findElement(EndsSpecificText_Locator);
            Utility.printElementInfo("text1",element);
}

//Partial Match Starts with - ^=
    @Test
    public void StartWithExactText(){
            By StartWithExactText_Locator = By.cssSelector("input[type$='ail']");
            WebElement element = driver.findElement(StartWithExactText_Locator);
            Utility.printElementInfo("text2",element);
    }

    //Multiples values
@Test
public void MultipleText() {
    By MultipleValue_Locator = By.cssSelector("input[type='text'][name='name']");
    WebElement element = driver.findElement(MultipleValue_Locator);
    Utility.printElementInfo("text2", element);
}
    //Logical OR (coma) ,
    @Test
    void testLogicalOR() {
        By InputName_Locator = By.cssSelector("input,*[type='email']");
        WebElement element = driver.findElement(InputName_Locator);
        Utility.printElementInfo("Input Name", element);
    }

    //Using not() function
    @Test
    void testNotFunction() {
        By InputLastName_Locator = By.cssSelector("input:not([id='name'])");
        WebElement element = driver.findElement(InputLastName_Locator);
        Utility.printElementInfo("InputLastName_Locator", element);
    }

    //Find all and count all the elements that have a tag "input"

    @Test
    void TestFindAllTagInput(){
            By AllTagInput_Locator = By.tagName("input");
            List<WebElement> Link = driver.findElements(AllTagInput_Locator);
            System.out.println("System Print:" + Link.size());


    }
}


