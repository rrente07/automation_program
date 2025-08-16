package clase1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

//Metodo que usamos para ordenar los test puede ser cuando hayas dependencias y necesitamos crear objetos antes: puede ser por el nombre, por el display name
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitExampleTest {
    @BeforeEach
    void SetUp(){
        System.out.println("------> This is the BeforeEach");
    }
    @BeforeAll
    static void beforeAll() {

        System.out.println("------> This is the Before All");
    }
    @Order(1)
    @Test
    @DisplayName("ABOUT_001 - he name of the test case")
    void login(){
        System.out.println("This is about test page");
    }
    @Order(3)
    @Test
    @DisplayName("HEADER_001 - This is the verification header (BUG#3434)")
    void VerifyHeaderPage(){
        System.out.println("This is the header test");
    }

    //if we want to disable a test we can use DISABLE puede ser para un test que falla, no lo eliminamos.
    @Disabled
    @Order(2)
    @Test
    @DisplayName("HOME_001 - This is the verification header (BUG#3434)")
    void Logout(){
        System.out.println("This is the logout");
    }
    @AfterEach
  void AfterEach(){
      System.out.println("------> This is the BeforeEach");
  }
    @AfterAll
    static void afterAll() {
        System.out.println("------> This is the After All");
    }
}
