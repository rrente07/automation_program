package pages;

import data.Student;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoursePage extends BasePage{
    private static final Logger logger = LoggerFactory.getLogger(CoursePage.class);
    By downloadLink_Locator = By.cssSelector("a[href='/s/This-is-a-file-to-test-Downloads.txt']");

    By nameInput_Locator = By.id("name");
    By lastNameInput_Locator = By.id("lastName");
    By emailInput_Locator = By.id("email");

    By inputFileUpload_Locator = By.id("photo");
    By thumbnail_Locator = By.id("thumbnail");

    By selectCountry_Locator = By.id("country");
    By ageInput_Locator = By.id("age");
    By dateInput_Locator = By.id("selectedDate");

    By checkbSelenium_Locator = By.id("selenium");
    By checkbProgramming_Locator = By.id("programming");
    By checkbJava_Locator = By.id("java");
    By checkbAPITesting_Locator = By.id("apiTesting");
    By checkboxesCoursesList_Locator = By.cssSelector("input[type='checkbox']");

    By addCourseBtn_Locator = By.xpath("//button[@type='button'][text()='Adicionar Curso']");
    By courseTable_Locator = By.id("userTable");

    By tableCellsList_Locator = By.cssSelector("table tr td");


    public CoursePage(WebDriver driver) {
        super();
    }

    //Hacer click en el link de descarga
    public void clickOnDownloadLink(){
        click(downloadLink_Locator);
    }

    //MÃ©todo para cargar la imagen
    public void uploadFile(String filePath){
        uploadFile(inputFileUpload_Locator,filePath);
    }

    //Verificar que la imagen de la thumbnail se subiÃ³
    public boolean isImageUploaded(){

        try {
            WebElement thumbnail = findElement(thumbnail_Locator);

            String src = thumbnail.getAttribute("src");

            boolean uploaded = (src!=null) && (!src.isEmpty());

            System.out.println("Image uploaded status: "+uploaded);
            // System.out.println("Image src:" + src);

            return uploaded;

        } catch (Exception e) {
            System.out.println("Error uploading the image." + e.getMessage());
            return false;

        }

    }


    //Add Student and courses

    public void typeName(String name){
        type(nameInput_Locator,name);
    }

    public void typeLastName(String lastName){
        type(lastNameInput_Locator,lastName);
    }

    public void selectCountry(String country){
        Select select = new Select(findElement(selectCountry_Locator));
        select.selectByVisibleText(country);

    }

    public void typeDate(String date){
        type(dateInput_Locator,date);
    }

    public void selectJavaCourse(){
        WebElement checkboxJava = findElement(checkbJava_Locator);
        scrollIntoViewAndClick(checkboxJava);
    }

    public void selectProgrammingCourse(){
        WebElement checkbox = findElement(checkbProgramming_Locator);
        scrollIntoViewAndClick(checkbox);
    }

    public void selectSeleniumCourse(){
        WebElement checkbox = findElement(checkbSelenium_Locator);
        scrollIntoViewAndClick(checkbox);
    }

    public void selectAPITestingCourse(){
        WebElement checkbox = findElement(checkbAPITesting_Locator);
        scrollIntoViewAndClick(checkbox);
    }

    public void selectRandomCourses(int quantity){
        List<WebElement> coursesList = findElements(checkboxesCoursesList_Locator);
        Collections.shuffle(coursesList);

        for (int i = 0; i < Math.min(quantity,coursesList.size()); i++) {
            scrollIntoViewAndClick(coursesList.get(i));
        }

    }

    public void clickOnAddCourseButton(){
        scrollIntoViewAndClick(addCourseBtn_Locator);
    }


    //Verify student was added to the Table

    public boolean verifyTextIsPresentInTable(String element){

        List<WebElement> cellsList = findElements(tableCellsList_Locator);
        List<String> cellsTextList = new ArrayList<>();

        for(WebElement cell : cellsList){
            cellsTextList.add(cell.getText());
        }

        boolean isTextPresent = cellsTextList.contains(element);
        System.out.println("is Text '"+element+"' present? ->"+isTextPresent);

        return isTextPresent;

    }

    public boolean verifyStudentIsPresentInTable(Student student){
        WebElement table = findElement(courseTable_Locator);
        List<WebElement> rowsList = table.findElements(By.tagName("tr"));

        for(WebElement row: rowsList){
            List<WebElement> cells = row.findElements(By.tagName("td"));

            if(cells.size() == 4){
                String nameCell = cells.get(0).getText().trim();
                String studentName = student.getName();
                boolean isNamePresent = nameCell.equalsIgnoreCase(studentName);
                System.out.println("isNamePresent: "+ isNamePresent);

                String countryCell = cells.get(1).getText().trim();
                String studentCountry = student.getCountry();
                boolean isCountryPresent = countryCell.equalsIgnoreCase(studentCountry);
                System.out.println("isCountryPresent: "+ isCountryPresent);

                String dateCell = cells.get(2).getText().trim();
                String studentDate = student.getDate();
                boolean isDatePresent = Utility.compareDates(dateCell,"yyyy-MM-dd",
                        studentDate,"MM/dd/yyyy");
                System.out.println("isDatePresent:" + isDatePresent);

                String courseCell = cells.get(3).getText().trim();
                List<String> studentCourses = student.getNameOfCourses();
                boolean areAllCoursesPresent = studentCourses.stream().allMatch(
                        course -> courseCell.contains(course));
                System.out.println("areAllCoursesPresent:" + areAllCoursesPresent);

                if(isNamePresent && isCountryPresent && isDatePresent && areAllCoursesPresent)
                    return  true;
            }

        }

        return false;

    }

    public void addingSelectedCoursesToStudent(Student student){
        List<WebElement> coursesList = findElements(checkboxesCoursesList_Locator);

        for (WebElement course : coursesList){
            if(course.isSelected()){
                String courseName = course.getDomAttribute("value");
                System.out.println("courseName: "+courseName);
                if(!courseName.isEmpty())
                    student.AddCourse (courseName);
            }
        }

    }


}















