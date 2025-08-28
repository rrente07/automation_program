package test;

import config.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.CoursePage;
import pages.HomePage;
import utils.Utility;

import java.io.File;

public class CourseTest extends BaseTest{

    static HomePage homePage;
    static CoursePage coursePage;

    @BeforeAll
    static void initPage() {
        homePage = new HomePage(driver);
        homePage.ClickOnCoursePageLink();
    }

    @Test
    void testDownloads() {

        //Limpiar el directorio
        Utility.clearDownloadFolder(Configuration.DOWNLOAD_PATH);

        File downloadDir = new File(Configuration.DOWNLOAD_PATH);
        File[] previousFiles = downloadDir.listFiles();

        int initialCount = (previousFiles != null) ? previousFiles.length : 0;

        System.out.println("initialCount:" + initialCount);

        coursePage.ClickOnDownloadClick();

        //Verificar la descarga
        boolean fileDownloaded = Utility.waitForNewFile(downloadDir,10, initialCount);

        Assertions.assertTrue(fileDownloaded,"Failed: document was not downloaded");

    }

    @Test
    void testUploadFile() {

        String picturePath = (System.getProperty("user.dir"))+"/src/test/resources/Profile Placeholder.png";

        File file = new File(picturePath);
        System.out.println("Uploading image from path:"+file.getAbsolutePath());

        //Subir archivo
        coursePage.uploadFile(picturePath);

        //Verificar que la imagen se subió correctamente
        boolean imageUploaded = coursePage.isImageUploaded();
        System.out.println("imageUploaded: "+imageUploaded);

        Assertions.assertTrue(imageUploaded,"Failed: Image was not uploaded.");

    }

}
