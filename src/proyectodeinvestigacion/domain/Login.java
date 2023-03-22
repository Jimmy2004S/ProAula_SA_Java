
package proyectodeinvestigacion.domain;

public class Login{
    
    
    private static String user;
    private static String clave;

    public Login() {
    }

   
    public Login( String user , String clave) {
        this.user = user;
        this.clave = clave;
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
