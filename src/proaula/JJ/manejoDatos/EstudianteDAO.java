/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proaula.JJ.manejoDatos;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proaula.JJ.domain.Estudiante;

public class EstudianteDAO implements IAccesoDatos {

    private Connection conTransaccional;
    private static final String SQL_INSERT = "INSERT INTO estudiantes(codigo, semestre,carrera) VALUES (? ,?,?)";
    private static final String SQL_SELECT = "SELECT * FROM persona p\n"
            + "JOIN estudiante e ON p.codigo = e.codigo WHERE p.estado='Activo';";
    private static final String SQL_SELECT_REFERENCIA = "SELECT * FROM persona p "
            + "JOIN estudiante e ON p.codigo = e.codigo WHERE p.identificacion=? ;";


    public EstudianteDAO(Connection conTransaccional) {
        this.conTransaccional = conTransaccional;
    }

    public EstudianteDAO() {

    }

    @Override
    public void Insert(Object recurso) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Estudiante estudianteDatos = (Estudiante) recurso;

        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setInt(1, estudianteDatos.getCodigo());
            ps.setString(2, estudianteDatos.getSemestre());
            ps.setString(3, estudianteDatos.getCarrera());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Estudiante R");
        } finally {
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
    }

    @Override
    public List Select() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Estudiante> listEstudiante = new ArrayList();
        Estudiante estudiante = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                estudiante = new Estudiante();
                estudiante.setCodigo(rs.getInt(1));
                estudiante.setNombres(rs.getString("nombre"));
                estudiante.setApellidos(rs.getString("apellido"));
                estudiante.setIdentificacion(rs.getString("identificacion"));
                estudiante.setCorreo(rs.getString("email"));
                estudiante.setClave(rs.getString("clave"));
                estudiante.setSemestre(rs.getString("semestre"));
                estudiante.setCarrera(rs.getString("carrera"));
                listEstudiante.add(estudiante);
            }
        } finally {
            Conexion.cerrarFlujo(rs);
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
        return listEstudiante;
    }

    @Override
    public void Update(Object recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estudiante consultarReferencia(Object recurso) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Estudiante estudiante = new Estudiante();
        Estudiante recursoEstudiante = (Estudiante) recurso;
        
        String identificacion = recursoEstudiante.getIdentificacion();
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT_REFERENCIA);    
            ps.setString(1, identificacion );
            rs = ps.executeQuery();
            while (rs.next()) {
                estudiante = new Estudiante();
                estudiante.setCodigo(rs.getInt(1));
                estudiante.setNombres(rs.getString("nombre"));
                estudiante.setApellidos(rs.getString("apellido"));
                estudiante.setIdentificacion(rs.getString("identificacion"));
                estudiante.setCorreo(rs.getString("email"));
                estudiante.setClave(rs.getString("clave"));
                estudiante.setSemestre(rs.getString("semestre"));
                estudiante.setCarrera(rs.getString("carrera"));
            }
        } finally {
            Conexion.cerrarFlujo(rs);
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
        return estudiante;
    }

    @Override
    public void Delete(int recurso) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
