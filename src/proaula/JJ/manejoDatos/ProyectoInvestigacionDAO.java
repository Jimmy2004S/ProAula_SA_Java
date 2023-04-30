package proaula.JJ.manejoDatos;

import proaula.JJ.domain.ProyectoInvestigacion;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProyectoInvestigacionDAO implements IAccesoDatos {

    private Connection conTransaccional;
    private static final String INSERT = "INSERT INTO proyectos (nombre, descripcion, fecha_inicio, likes, codigo_grupo, codigo_lider_proyecto) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE proyectos set codigo=?, nombre=?, descripcion=? ,fecha_inicio=?, likes=?, codigo_grupo=? , codigo_lider_proyecto=? WHERE codigo =?";
    private static final String DELETE = "DELETE FROM proyectos WHERE codigo=?";
    private static final String SELECT = "SELECT * FROM proyectos";
    boolean bandera = false;

    public ProyectoInvestigacionDAO(Connection conTransaccional) {
        this.conTransaccional = conTransaccional;
    }

    public ProyectoInvestigacionDAO() {
       
    }

    @Override
    public void Insert(Object recurso) throws SQLException {
        ProyectoInvestigacion proyecto = (ProyectoInvestigacion) recurso;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, proyecto.getAcronimo());
            ps.setString(2, proyecto.getDescripcion());
            ps.setString(3, proyecto.getFechaRegistro());
            ps.setInt(4, proyecto.getLike());
            ps.setInt(5, proyecto.getCodigo_grupo());
            ps.setInt(6, proyecto.getCodigo_lider());
            ps.executeUpdate();
        } finally {
           Conexion.cerrarFlujo(ps);
           if(this.conTransaccional == null){
               Conexion.cerrarFlujo(conn);
           }
        }

    }

    @Override
    public List Select() throws SQLException {
        List<ProyectoInvestigacion> listProyecto = new ArrayList<ProyectoInvestigacion>();
        ProyectoInvestigacion proyecto = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                String fecha = rs.getString("fecha_inicio");
                int likes = rs.getInt("likes");
                int idGrupo = rs.getInt("codigo_grupo");
                int idLider = rs.getInt("codigo_lider_proyecto");
                proyecto = new ProyectoInvestigacion(codigo, nombre, descripcion, fecha, likes, idGrupo, idLider);
                listProyecto.add(proyecto);
            }
        } finally {
            Conexion.cerrarFlujo(rs);
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
        return listProyecto;
    }

    @Override
    public void Update(Object recurso) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            ProyectoInvestigacion proyecto = (ProyectoInvestigacion) recurso;
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setInt(0, proyecto.getCodigo());
            ps.setString(1, proyecto.getAcronimo());
            ps.setString(2, proyecto.getDescripcion());
            ps.setString(3, proyecto.getFechaRegistro());
            ps.setInt(4, proyecto.getLike());
            ps.setInt(5, proyecto.getCodigo_grupo());
            ps.setInt(6, proyecto.getCodigo_lider());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Update proyecto: " + e);
        } finally {
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }

    }

    @Override
    public void Delete(int recurso) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, recurso);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Proyecto Eliminado");
        } finally {
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
    }

    @Override
    public List consultarReferencia(Object recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
