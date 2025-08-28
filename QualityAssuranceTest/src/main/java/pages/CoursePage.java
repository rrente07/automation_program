package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CoursePage extends BasePage{

    public CoursePage(WebDriver driver) {
        super(driver);
    }
//Locator to the LINK
    By OnDownloadLink_Locator = By.cssSelector("a[href='/s/This-is-a-file-to-test-Downloads.txt']");
    By nameInputCoursePage_Locator = By.id("name");
    By lastNameCoursePage_Locator = By.id("lastName");
    By emailCoursePage_Locator = By.id("mail");
    By thumbnailCoursePage_Locator = By.id("thumbnail");
    By photoCoursePageInput_Locator = By.id("photo");
    By countryCoursePageSelect_Locator = By.id("country");
    By ageCoursePageInput_Locator = By.id("age");
    By dateCoursePageInput_Locator = By.id("selectedDate");
    By interestSeleniumCoursePageCheckbox_Locator = By.id("selenium");
    By interestProgrammingCoursePageCheckbox_Locator = By.id("programming");
    By interestJavaCoursePageCheckbox_Locator = By.id("java");
    By interestJavaApiTestingCoursePageCheckbox_Locator = By.id("apiTesting");
    By addingCourseToCoursePageButton_Locator = By.xpath("//button[@type='button'][text()='Adicionar Curso']");
    By viewAddCoursePageTable_Locator = By.id("userTable']");


    //Click On Download Link

    public void ClickOnDownloadClick(){
    click(OnDownloadLink_Locator);
    }

    //Metodo para cargar la imagen

    public void uploadFile(String filePath){
        uploadFile(photoCoursePageInput_Locator, filePath);
    }

    //Verificar que la imagen de la thumbnail se subió
    public boolean isImageUploaded(){

        try {
            WebElement thumbnail = findElement(thumbnailCoursePage_Locator);

            String src = thumbnail.getAttribute("src");

            boolean uploaded = (src!=null) && (!src.isEmpty());

            System.out.println("Image uploaded staus: "+uploaded);
            System.out.println("Image src:" + src);

            return uploaded;

        } catch (Exception e) {
            System.out.println("Error uploading the image." + e.getMessage());
            return false;

        }

    }}
