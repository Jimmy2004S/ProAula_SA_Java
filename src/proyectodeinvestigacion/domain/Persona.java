
package proyectodeinvestigacion.domain;

public abstract class Persona {
    private  int codigo;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String correo;
    private String user;
    private String clave;

    public Persona(){  
    }
    
    public Persona(int codigo){
        this.codigo = codigo;
    }
    
    public Persona(String nombres, String apellidos, String identificacion, String correo, String user, String clave) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.correo = correo;
        this.user = user;
        this.clave = clave;
    }

    public Persona(int codigo, String nombres, String apellidos, String identificacion, String correo, String user, String clave) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.correo = correo;
        this.user = user;
        this.clave = clave;
    }
    
    



    public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
  
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

}
