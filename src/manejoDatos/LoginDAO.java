
package manejoDatos;

import config.Conexion;
import proyectodeinvestigacion.domain.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDAO {
    
   Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public Login validar(String nombre , String identificacion){
        Login l = new Login();
        
        String sql = "SELECT * FROM profesores WHERE user=? AND identificacion =?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, identificacion);
            rs = ps.executeQuery();
            if(rs.next()){
                l.setUser(rs.getString("user"));
                l.setClave(rs.getString("clave"));
            }
        } catch (Exception e) {
            System.out.println("Error de login: " + e);
        }return l;  
    }
    
}
