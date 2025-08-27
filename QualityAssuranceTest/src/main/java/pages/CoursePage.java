package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursePage extends BasePage{

    public CoursePage(WebDriver driver) {
        super(driver);
    }
//Locator to the LINK
    By OnDownloadLink_Locator = By.cssSelector("a[href='/s/This-is-a-file-to-test-Downloads.txt']");

    //Click On Download Link

    public void ClickOnDownloadClick(){
    click(OnDownloadLink_Locator);
    }
}
