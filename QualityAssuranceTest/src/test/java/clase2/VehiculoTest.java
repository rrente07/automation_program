package clase2;

import org.junit.jupiter.api.Test;

public class VehiculoTest {

    @Test
    void VehiculoTest() {

        Vehiculo vehiculo1 = new Vehiculo();

        //Establecer los atributos de vehiculo

        vehiculo1.setColor("rojo");
        vehiculo1.setMarca("Honda");
        vehiculo1.setModelo("Civic");
        vehiculo1.setYear(2024);

        //Simular encender el vehiculo
        vehiculo1.encender();

        //Simular acelerar el vehiculo
       vehiculo1.car_Acelerar(100);

        //Mostrar informacion del vehiculo
       vehiculo1.mostrar_informacion();
    }
}
