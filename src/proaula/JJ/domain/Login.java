
package proaula.JJ.domain;

public class Login{
    
    
    private static String user;
    private static String clave;
    private static String tipo_persona;

    public Login() {
    }

   
    public Login( String user , String clave , String tipo_persona) {
        Login.user = user;
        Login.clave = clave;
        Login.tipo_persona = tipo_persona;
    }

    public static String getTipo_persona() {
        return tipo_persona;
    }

    public static void setTipo_persona(String tipo_persona) {
        Login.tipo_persona = tipo_persona;
    }
    
    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Login.user = user;
    }
    public static String getClave() {
        return clave;
    }

    public static void setClave(String clave) {
        Login.clave = clave;
    }
    
    

}
