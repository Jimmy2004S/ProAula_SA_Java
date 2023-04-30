
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    

    private static final String url = "jdbc:mysql://localhost:3306/proyectosi";
    private static final String user = "root";
    private static String password = "";
    
       public void ss (){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
 public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
   
    public static void cerrarFlujo(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
     public static void cerrarFlujo(PreparedStatement ps){
        try {
            if(ps != null){
                ps.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
     
     public static void cerrarFlujo(ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
     
    
}
