package proaula.JJ.manejoDatos;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import proaula.JJ.domain.Grupo;

public class GrupoDAO implements IGrupoDAO {

    private Connection conTransaccional;
    private static final String INSERT_GRUPO = "INSERT INTO grupo(nick) VALUES (?)";
    private static final String DELETE_GRUPO = "DELETE FROM `grupo` WHERE codigo=?";
    private static final String UPDATE_GRUPO = "UPDATE `grupo` SET `codigo`=?,`nombre`=? WHERE codigo=?";
    private static final String SELECT_GRUPO = "SELECT * FROM `grupo`";

    private static final String SELECT_PERSONA_GRUPO = "SELECT `codigo_persona` FROM `grupo_persona` WHERE codigo_grupo=?";
    private static final String DELETE_PERSONA_GRUPO = "DELETE FROM `grupo_persona` WHERE codigo_persona=?";
    private static final String INSERT_PERSONA_GRUPO = "INSERT INTO `grupo_persona` (`codigo_grupo`, `codigo_persona`) VALUES (?,?);";

    public GrupoDAO(Connection conTransaccional) {
        this.conTransaccional = conTransaccional;
    }

    public GrupoDAO() {
    }

    @Override
    public void InsertGrupo(String nombre) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(INSERT_GRUPO);
            ps.setString(2, nombre);
            ps.executeUpdate();
        } finally {
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional != null) {
                Conexion.cerrarFlujo(conn);
            }
        }
    }

    @Override
    public void DeleteGrupo(int codigoGrupo) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(DELETE_GRUPO);
            ps.setInt(1, codigoGrupo);
            ps.executeUpdate();
        } finally {
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional != null) {
                Conexion.cerrarFlujo(conn);
            }
        }
    }

    @Override
    public List SelectGrupo() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Grupo> listGrupo = new ArrayList<Grupo>();
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SELECT_GRUPO);
            rs = ps.executeQuery();
            while (rs.next()) {
                Grupo grupo = new Grupo();
                grupo.setCodigo(rs.getInt("codigo"));
                grupo.setNick(rs.getString("nombre"));
                listGrupo.add(grupo);
            }
        } finally {
            Conexion.cerrarFlujo(rs);
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional != null) {
                Conexion.cerrarFlujo(conn);
            }
        }
        return listGrupo;
    }

    @Override
    public void UpdateGrupo(Object recurso) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(UPDATE_GRUPO);
            ps.setInt(1, (int) recurso);
            ps.executeUpdate();
        } finally {
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional != null) {
                Conexion.cerrarFlujo(conn);
            }

        }
    }

    @Override
    public void InsertPersonaGrupo(int codigoPersona , int codigoGrupo) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(INSERT_PERSONA_GRUPO);
            ps.setInt(1, codigoGrupo);
            ps.setInt(2, codigoPersona);
            ps.executeUpdate();
        } finally {
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional != null) {
                Conexion.cerrarFlujo(conn);
            }
        }
    }

    @Override
    public void DeletePersonaGrupo(int codigoPersona) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(DELETE_PERSONA_GRUPO);
            ps.setInt(1, codigoPersona);
            ps.executeUpdate();
        } finally {
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional != null) {
                Conexion.cerrarFlujo(conn);
            }
        }
    }

    @Override
    public List SelectPersonaGrupo(int codigoGrupo) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Integer> listCodigoPersona = new ArrayList<Integer>();
        Integer codigoPersona = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SELECT_PERSONA_GRUPO);
            ps.setInt(1, codigoGrupo);
            rs = ps.executeQuery();
            while (rs.next()) {
                codigoPersona = rs.getInt("codigo_persona");
                listCodigoPersona.add(codigoPersona);
            }
        } finally {
            Conexion.cerrarFlujo(rs);
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional != null) {
                Conexion.cerrarFlujo(conn);
            }
        }
        return listCodigoPersona;
    }


}
