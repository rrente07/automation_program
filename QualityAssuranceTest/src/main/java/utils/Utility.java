package utils;

import data.Product;
import org.openqa.selenium.WebElement;

import java.io.File;

public class Utility {

    public static void printElementInfo(String name, WebElement element) {
        String marker = "------------------------------";
        System.out.println(marker);
        System.out.println("Element meta-data: " + name);
        System.out.println(marker);
        System.out.println("WebElement object:: " + element);
        System.out.println("Outer HTML:: " + element.getAttribute("outerHTML"));
        System.out.println("Inner HTML:: " + element.getAttribute("innerHTML"));
        System.out.println("Text:: " + element.getText());
        System.out.println("Value::" + element.getAttribute("value"));
        System.out.println("Tag:: " + element.getTagName());
        System.out.println("Displayed?:: " + element.isDisplayed());
        System.out.println("Selected?:: " + element.isSelected());
        System.out.println("Enabled?:: " + element.isEnabled());
        System.out.println(marker);
    }

    public static double extractPriceFromText(String rawPriceText){
        System.out.println("Raw price text:" + rawPriceText);

        //Keeping only numbers and dots. Replacing the rest with space
        String cleanedPrice = rawPriceText.replaceAll("[^0-9.]"," ").trim();

        //Taking the first number
        String firstNumber = cleanedPrice.split("\\s+")[0];
        System.out.println("firstNumber: "+firstNumber);
        return Double.valueOf(firstNumber);

    }

    public static boolean waitForNewFile(File folder, int timeoutInSeconds, int originalFileCount) {
        System.out.println("originalFileCount:"+originalFileCount);
        int elapsed = 0;
        while (elapsed < timeoutInSeconds) {
            File[] files = folder.listFiles();
            if (files != null && files.length > originalFileCount) {
                System.out.println("new file count:"+files.length);
                return true; // New file appeared
            }
            try {
                Thread.sleep(1000); // poll every 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elapsed++;
        }
        return false; // timeout reached
    }

    public static void clearDownloadFolder(String downloadPath){

        File folder = new File(downloadPath);
        File[] files = folder.listFiles();

        if(files!=null){
            for (File file : files){
                if(file.isFile()){
                    boolean deleted = file.delete();
                    if(!deleted){
                        System.out.println("File couldn't be deleted:"+file.getName());
                    }
                }
            }
        }

    }}


