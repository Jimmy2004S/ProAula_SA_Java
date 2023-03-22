
package proyectodeinvestigacion.domain;

public class Estudiante extends Persona{
    
    private String semestre;

    public Estudiante() {
    }

    public Estudiante(int codigo) {
        super(codigo);
    }

    public Estudiante(String semestre) {
        this.semestre = semestre;
    }

    public Estudiante(String semestre, int codigo) {
        super(codigo);
        this.semestre = semestre;
    }

    public Estudiante(String semestre, String nombres, String apellidos, String identificacion, String correo, String user, String clave) {
        super(nombres, apellidos, identificacion, correo, user, clave);
        this.semestre = semestre;
    }

    public Estudiante(String semestre, int codigo, String nombres, String apellidos, String identificacion, String correo, String user, String clave) {
        super(codigo, nombres, apellidos, identificacion, correo, user, clave);
        this.semestre = semestre;
    }
    
    

    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
    
}
