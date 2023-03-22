package proyectodeinvestigacion.domain;

public class Profesor extends Persona{

    private String cargo;
    public Profesor() {
    }

    public Profesor(int codigo) {
        super(codigo);
    }

    public Profesor(String cargo) {
        this.cargo = cargo;
    }

    public Profesor(String cargo, int codigo) {
        super(codigo);
        this.cargo = cargo;
    }

    public Profesor(String cargo, String nombres, String apellidos, String identificacion, String correo, String user, String clave) {
        super(nombres, apellidos, identificacion, correo, user, clave);
        this.cargo = cargo;
    }

    public Profesor(String cargo, int codigo, String nombres, String apellidos, String identificacion, String correo, String user, String clave) {
        super(codigo, nombres, apellidos, identificacion, correo, user, clave);
        this.cargo = cargo;
    }

    
    
    

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
      
}



    