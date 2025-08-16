package clase2;

public class Vehiculo {
    //Atributos privados del vehiculo
    private String marca;
    private  String modelo;
    private  int year;
    private String color;
    private int velocidad;
    private int acelerar;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYear(int i) {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public String setColor(String color) {
        this.color = color;
        return color;
    }

    //Metodo para encender el vehiculo
    public void encender(){
        System.out.println("Vehiculo encendido:");
    }
    //Metodo acelerar vehiculo
   public void car_Acelerar (int velocidad){
          acelerar = acelerar + velocidad;
       System.out.println("La aceleracion es:" + acelerar);
}
    //Metodo mostra informacion del vehiculo
    public void mostrar_informacion(){
        System.out.println("Hola mi vehiculo es:" + marca + "y modelo: " + modelo+ " año: " + year + " y color: " + color);
    }
}
