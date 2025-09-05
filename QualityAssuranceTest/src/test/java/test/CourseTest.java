package tests;

import config.Configuration;
import data.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CoursePage;
import pages.HomePage;
import test.AlertTest;
import test.BaseTest;
import utils.Utility;

import java.io.File;

public class CourseTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(CourseTest.class);
    static HomePage homePage;
    static CoursePage coursePage;

    @BeforeAll
    static void initPage() {
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);
        homePage.ClickOnCoursePageLink();
    }

    @Test
    void testDownloads() {

        //Limpiar el directorio
        Utility.clearDownloadFolder(Configuration.DOWNLOAD_PATH);

        File downloadDir = new File(Configuration.DOWNLOAD_PATH);
        File[] previousFiles = downloadDir.listFiles();

        int initialCount = (previousFiles != null) ? previousFiles.length : 0;

        logger.info("initialCount:" + initialCount);

        coursePage.clickOnDownloadLink();

        //Verificar la descarga
        boolean fileDownloaded = Utility.waitForNewFile(downloadDir, 10, initialCount);

        Assertions.assertTrue(fileDownloaded, "Failed: document was not downloaded");

    }

    @Test
    void testUploadFile() {

        String picturePath = (System.getProperty("user.dir")) + "/src/test/resources/profile_placeholder_480.png";

        File file = new File(picturePath);
        logger.info("Uploading image from path:"+file.getAbsolutePath());

        //Subir archivo
        coursePage.uploadFile(picturePath);

        //Verificar que la imagen se suba correctamente
        boolean imageUploaded = coursePage.isImageUploaded();
        logger.info("imageUploaded: "+imageUploaded);

        Assertions.assertTrue(imageUploaded,"Failed: Image was not uploaded.");

    }

    @Test
    void verifyAddingSpecificCourse_SingleStudent() {

        Student student = new Student("Pedro", "Perez","Colombia","09/25/2025");

        coursePage.typeName(student.getName());
        coursePage.selectCountry(student.getCountry());
        coursePage.typeDate(student.getDate());

        coursePage.selectJavaCourse();

        coursePage.clickOnAddCourseButton();

        boolean isTextPresent = coursePage.verifyTextIsPresentInTable(student.getName());
        logger.info("Is student name present: "+isTextPresent);
        Assertions.assertTrue(isTextPresent, "Failed: Student name is not present in the Table");

    }

    @Test
    void verifyAdding_RandomCourses_SingleStudent() {

        Student student = new Student("Ana", "Ramirez", "Mexico", "09/27/2025");
        coursePage.typeName(student.getName());
        coursePage.selectCountry(student.getCountry());
        coursePage.typeDate(student.getDate());

        coursePage.selectRandomCourses(2);
        coursePage.addingSelectedCoursesToStudent(student);

        coursePage.clickOnAddCourseButton();

        boolean isStudentPresent = coursePage.verifyStudentIsPresentInTable(student);
        logger.info("isStudentPresent: "+isStudentPresent);
        Assertions.assertTrue(isStudentPresent,"Failed: Student was not present in the Table");

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/files/students.csv", numLinesToSkip = 1)
    void verifyAdding_RandomCourses_MultipleStudents(String name, String lastName, String country, String date) {
        Student student = new Student(name, lastName, country, date);

        coursePage.typeName(student.getName());
        coursePage.selectCountry(student.getCountry());
        coursePage.typeDate(student.getDate());

        coursePage.selectRandomCourses(2);
        coursePage.addingSelectedCoursesToStudent(student);

        coursePage.clickOnAddCourseButton();

        boolean isStudentPresent = coursePage.verifyStudentIsPresentInTable(student);
        logger.info("isStudentPresent: " + isStudentPresent);
        Assertions.assertTrue(isStudentPresent, "Failed: Student was not present in the Table");
    }

}


