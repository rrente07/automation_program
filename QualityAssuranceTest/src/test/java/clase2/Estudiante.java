package clase2;

public class Estudiante extends Persona{

    private int estudianteID;

    public Estudiante(String nombre, int edad, int estudianteID) {
        super(nombre, edad);
      this.estudianteID = estudianteID;
    }

    public int getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(int estudianteID) {
        this.estudianteID = estudianteID;
    }

    public void estudiar(){

        System.out.println("El estudiante:" + getNombre() + "con Identificador ID" + getEstudianteID() + "esta estudiando");
    }
}
