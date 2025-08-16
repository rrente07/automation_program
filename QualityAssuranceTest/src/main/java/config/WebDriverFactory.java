package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
//Create the driver for the type of user I am used
    public static WebDriver CreateDriver(BrowserType type){
        WebDriver driver;
        switch(type){
            //Initiate Driver the type FirefoxDriver
            case FIREFOX : driver = new FirefoxDriver();
            break;
            case CRHOME : driver= new ChromeDriver();
            default :
                // Initiate Chrome with arguments add --start-Maximized start with navigator maximize
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;
        }
        return driver;
    }
}
