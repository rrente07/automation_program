package clase2;

import org.junit.jupiter.api.Test;

public class HerenciaTest {

    @Test
    void estudianteTest() {

      //Crear objeto estudiante
        Estudiante estudiante = new Estudiante("pepe", 20, 3445);

        //Llamar a los metodos presentarse heredado de la clase persona
        estudiante.Presentarse();

        System.out.println("Para este estudiante que estamos hablando su informacion es:" );

    }
}
