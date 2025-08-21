package clase1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import pages.HomePage;
import test.BaseTest;
import utils.Utility;

public class RelativeLocatorsTest extends BaseTest {

    static HomePage homePage;

    @BeforeAll
    static void InitPage(){
homePage = new HomePage(driver);
homePage.ClickOnWebElementTestLink();
    }

 /*
    Cómo usar los Relative Locators:
    1. Primero localizas un elemento que tenga un localizador conocido
     (por ejemplo, un ID o nombre de clase).
    2. Luego usas los métodos de los localizadores relativos para encontrar
     el elemento objetivo (target) en relación con ese primer elemento.
     Por ejemplo, puedes encontrar un elemento que esté "debajo"(below)
     de un elemento conocido o "a la derecha de" (toRightOf).
 */

   //Find "Text" above "Click me button"
    @Test
    void relativeLocatorAbove(){
        By clickMeBtn_Locator = By.id("mainButton");
        By text_Locator = RelativeLocator.with(By.tagName("p")).above(clickMeBtn_Locator);
        WebElement element = driver.findElement(text_Locator);
        Utility.printElementInfo("Locator Above", element);
    }
//Find left button located below test
    @Test
    void relativeLocatorBelow(){
        By belowText_Locator = By.id("belowTarget");
        By leftBtn_Locator = RelativeLocator.with(By.tagName("button")).below(belowText_Locator);
        WebElement element = driver.findElement(leftBtn_Locator);
        Utility.printElementInfo("left button", element);
    }

    //Finding "Right" button located 'toRightOf' "Left" button
    @Test
    void relativeLocator_RightOf() {

        WebElement leftBtn = driver.findElement(By.id("leftBtn"));

        By btnRightOfLeftBtn_Locator = RelativeLocator.with(By.tagName("button")).toRightOf(leftBtn);

        WebElement element = driver.findElement(btnRightOfLeftBtn_Locator);

        Utility.printElementInfo("btn RightOf LeftBtn ", element);
    }

    //Finding Text "Center" located to the left of "Right" button
    @Test
    void relativeLocator_LeftOf() {

        By textLeftOfRightBtn_Locator = RelativeLocator.with(By.tagName("p")).toLeftOf(By.id("rightBtn"));

        WebElement element = driver.findElement(textLeftOfRightBtn_Locator);
        Utility.printElementInfo("text Left Of RightBtn ", element);
    }

    //Finding Textbox located near of Label
    @Test
    void relativeLocator_NearOf() {

        By nearLabel_Locator = By.id("nearLabel");
        By texbox_Locator = RelativeLocator.with(By.tagName("input")).near(nearLabel_Locator);

        WebElement element = driver.findElement(texbox_Locator);
        Utility.printElementInfo("texbox_Locator", element);
    }


}
