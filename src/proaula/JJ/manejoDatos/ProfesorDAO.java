package proaula.JJ.manejoDatos;

import proaula.JJ.domain.Profesor;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO extends Conexion implements IAccesoDatos {

    private Connection conTransaccional;
    boolean bandera = false;
    private static final String SQL_INSERT = "INSERT INTO profesores (codigo , departamento) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE profesores set departamento=?  WHERE codigo=?";
    private static final String SQL_SELECT = "SELECT * FROM persona p\n"
            + "JOIN profesor pr ON p.codigo = pr.codigo WHERE p.estado='Activo'";
    private static final String SQL_SELECT_REFERENCIA = "SELECT * FROM persona p "
            + "JOIN profesor pr ON p.codigo = pr.codigo WHERE p.codigo=? ";

    public ProfesorDAO() {

    }

    public ProfesorDAO(Connection conTransaccional) {
        this.conTransaccional = conTransaccional;
    }

    @Override
    public void Insert(Object recurso) throws SQLException {
        Profesor profesor;
        profesor = (Profesor) recurso;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
                conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
                ps = conn.prepareStatement(SQL_INSERT);
                ps.setInt(1, profesor.getCodigo());
                ps.setString(2, profesor.getDepartamento());
                ps.executeUpdate();
        } finally {
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
    }

    @Override
    public List Select() throws SQLException {
        List<Profesor>listProfesor = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setCodigo(rs.getInt("codigo"));
                profesor.setNombres(rs.getString("nombre"));
                profesor.setApellidos(rs.getString("apellido"));
                profesor.setIdentificacion(rs.getString("identificacion"));
                profesor.setTipo_persona(rs.getString("tipo_persona"));
                profesor.setCorreo(rs.getString("email"));
                profesor.setClave(rs.getString("clave"));
                profesor.setTelefono(rs.getString("telefono"));
                profesor.setDepartamento(rs.getString("departamento"));
                listProfesor.add(profesor);
            }
        } finally {
            Conexion.cerrarFlujo(ps);
            Conexion.cerrarFlujo(rs);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
        return listProfesor;
    }

    @Override
    public void Update(Object recurso) throws SQLException {
        Profesor profesor = (Profesor) recurso;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, profesor.getDepartamento());
            ps.executeUpdate();
        } finally {
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
    }

    @Override
    public void Delete(int recurso) throws SQLException {
  
    }

    @Override
    public Profesor consultarReferencia(Object recurso) throws SQLException {
        Profesor recursoProfesor = (Profesor) recurso;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Profesor profesor = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT_REFERENCIA);
            ps.setInt(1, recursoProfesor.getCodigo());
            ps.setString(2,recursoProfesor.getDepartamento());
            rs = ps.executeQuery();
            while (rs.next()) {
                profesor = new Profesor();
                profesor.setCodigo(rs.getInt("codigo"));
                profesor.setNombres(rs.getString("nombre"));
                profesor.setApellidos(rs.getString("apellido"));
                profesor.setIdentificacion(rs.getString("identificacion"));
                profesor.setTipo_persona(rs.getString("tipo_persona"));
                profesor.setCorreo(rs.getString("email"));
                profesor.setClave(rs.getString("clave"));
                profesor.setDepartamento(rs.getString("departamento")); 
            }
        } finally {
            Conexion.cerrarFlujo(rs);
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
        return profesor;
    }
    
    
}

