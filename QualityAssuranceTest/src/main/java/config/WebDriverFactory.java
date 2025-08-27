package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

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

                Map<String,Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", config.Configuration.DOWNLOAD_PATH);
                prefs.put("download.prompt_for_download",false);
                prefs.put("safebrowsing.enabled",true);

                options.setExperimentalOption("prefs",prefs);

                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;
        }
        return driver;
    }
}
