
package proaula.JJ.domain;

public abstract class Persona {
    private  int codigo;
    private String nombres;
    private String apellidos;
    private String identificacion;
    private String tipo_persona;
    private String correo;
    private String clave;
    private String telefono;

    public Persona(){  
    }
    
    public Persona(int codigo){
        this.codigo = codigo;
    }

    public Persona(int codigo, String nombres, String apellidos, String identificacion, String tipo_persona, String correo, String clave, String telefono) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
        this.tipo_persona = tipo_persona;
        this.correo = correo;
        this.clave = clave;
         this.telefono = telefono;
    }  

    public String getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return "Persona{" + "codigo=" + codigo + ", nombres=" + nombres + ", apellidos=" + apellidos + ", identificacion=" + identificacion + ", tipo_persona=" + tipo_persona + ", correo=" + correo + ", clave=" + clave + ", telefono=" + telefono + '}';
    }

    
}
