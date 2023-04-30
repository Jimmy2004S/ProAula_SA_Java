
package proaula.JJ.domain;

public class Estudiante extends Persona{
    
    private String semestre;
    private String carrera;

    public Estudiante() {
    }

    public Estudiante(String semestre, String carrera) {
        this.semestre = semestre;
        this.carrera = carrera;
    }

    public Estudiante(String semestre, String carrera, int codigo) {
        super(codigo);
        this.semestre = semestre;
        this.carrera = carrera;
    }

    public Estudiante(int codigo, String nombres, String apellidos, String identificacion, String tipo_persona, String correo, String clave, String telefono) {
        super(codigo, nombres, apellidos, identificacion, tipo_persona, correo, clave, telefono);
    }

    public Estudiante(String semestre, String carrera, int codigo, String nombres, String apellidos, String identificacion, String tipo_persona, String correo, String clave, String telefono) {
        super(codigo, nombres, apellidos, identificacion, tipo_persona, correo, clave , telefono);
        this.semestre = semestre;
        this.carrera = carrera;
    }
    
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
   
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return super.toString() + " Estudiante{" + "semestre=" + semestre + ", carrera=" + carrera + '}';
    }
    
    
}
