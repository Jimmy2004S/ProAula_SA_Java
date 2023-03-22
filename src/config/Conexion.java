
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    
    public PreparedStatement ps;
    public Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/proyectosi";
    String user = "root";
    String password = "";
    
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("No se pudo conectar: "+e);
        }
        return conn;
    }
   
    public void cerrarFlujo(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
     public void cerrarFlujo(PreparedStatement ps){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
     public void cerrarFlujo(ResultSet rs){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
     
    
}
