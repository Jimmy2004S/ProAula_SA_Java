package proaula.JJ.domain;

public class Profesor extends Persona{

    private String departamento;
    
    public Profesor() {
    }

    public Profesor(String departamento) {
        this.departamento = departamento;
    }

    public Profesor(String departamento, int codigo) {
        super(codigo);
        this.departamento = departamento;
    }

    public Profesor(String departamento, int codigo, String nombres, String apellidos, String identificacion, String tipo_persona, String correo, String clave , String telefono) {
        super(codigo, nombres, apellidos, identificacion, tipo_persona, correo, clave , telefono);
        this.departamento = departamento;
    }
    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() +  " Profesor{" + "departamento=" + departamento + '}';
    }

    
    
      
}



    