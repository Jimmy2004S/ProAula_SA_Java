package proaula.JJ.manejoDatos;

import config.Conexion;
import proaula.JJ.domain.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO implements ILogin{

    private Connection conTransaccional;
    private static final String SELECT = "SELECT * FROM persona WHERE identificacion=? AND clave=?";

    public LoginDAO(Connection conTransaccional) {
        this.conTransaccional = conTransaccional;
    }

    public LoginDAO() {
        
    }

    public Login validar(String user, String clave) throws SQLException{
        Login login = new Login();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SELECT);
            ps.setString(1, user);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            if (rs.next()) {
                Login.setUser(rs.getString("identificacion"));
                Login.setClave(rs.getString("clave"));
                Login.setTipo_persona(rs.getString("tipo_persona"));
            }
        } finally{
            Conexion.cerrarFlujo(rs);
            Conexion.cerrarFlujo(ps);
            if(this.conTransaccional == null){
                Conexion.cerrarFlujo(conn);
            }
        }
        return login;
    }

}
