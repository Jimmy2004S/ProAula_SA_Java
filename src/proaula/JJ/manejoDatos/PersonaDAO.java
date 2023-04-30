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
import proaula.JJ.domain.Persona;

public class PersonaDAO implements IAccesoDatos {

    private Connection conTransaccional;
    private static final String SQL_INSERT = "INSERT INTO `persona`(`nombre`, `apellido`,"
            + " `identificacion`, `tipo_persona`, `email`, `clave`, `telefono`) "
            + "VALUES ('?','?','?','?','?','?','?')";
    private static final String SQL_SELECT = "SELECT p.codigo, p.nombre, p.apellido,"
            + " p.tipo_persona , p.identificacion , p.email FROM Persona p LEFT "
            + "JOIN Estudiante e ON p.codigo = e.codigo LEFT JOIN Profesor pr ON "
            + "p.codigo = pr.codigo WHERE p.estado='Activo';";
    private static final String SQL_DELETE = "UPDATE `persona` SET estado='Inactivo' WHERE codigo=?";
    private static final String SQL_SELECT_POR_REFERENCIA = "SELECT p.codigo, p.nombre, p.apellido,"
            + " p.tipo_persona , p.identificacion , p.email FROM Persona p LEFT "
            + "JOIN Estudiante e ON p.codigo = e.codigo LEFT JOIN Profesor pr ON p.codigo"
            + " = pr.codigo WHERE identificacion=? && p.estado='Activo';";
    private static final String UPDATE = "UPDATE `persona` SET `nombre`=?,`apellido`=?,"
            + "`identificacion`=?,`tipo_persona`=?,`email`=?,`clave`=?,`telefono`=? WHERE codigo=?";

    public PersonaDAO() {

    }

    public PersonaDAO(Connection conTransaccional) {
        this.conTransaccional = conTransaccional;
    }

    @Override
    public void Insert(Object recurso) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        Persona persona = (Persona) recurso;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, persona.getNombres());
            ps.setString(2, persona.getApellidos());
            ps.setString(3, persona.getIdentificacion());
            ps.setString(4, persona.getTipo_persona());
            ps.setString(5, persona.getCorreo());
            ps.setString(6, persona.getClave());
            ps.setString(7, persona.getTelefono());
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
        List<Persona> listPersona = new ArrayList<>();
        Persona persona = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                persona = new Estudiante();
                persona.setCodigo(rs.getInt("codigo"));
                persona.setNombres(rs.getString("nombre"));
                persona.setApellidos(rs.getString("apellido"));
                persona.setIdentificacion(rs.getString("identificacion"));
                persona.setTipo_persona(rs.getString("tipo_persona"));
                persona.setCorreo(rs.getString("email"));
                listPersona.add(persona);
            }
        } finally {
            Conexion.cerrarFlujo(rs);
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
        return listPersona;
    }

    @Override
    public void Update(Object recurso) throws SQLException {
        Persona persona = (Persona) recurso;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setInt(0, persona.getCodigo());
            ps.setString(1, persona.getNombres());
            ps.setString(2, persona.getApellidos());
            ps.setString(3, persona.getIdentificacion());
            ps.setString(4, persona.getTipo_persona());
            ps.setString(5, persona.getCorreo());
            ps.setString(6, persona.getClave());
            ps.setString(7, persona.getTelefono());
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
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.executeUpdate();
        } finally {
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
    }

    @Override
    public Persona consultarReferencia(Object recurso) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Persona recursoPersona = (Persona) recurso;
        String identificacion = recursoPersona.getIdentificacion();
        Persona persona = new Estudiante();

        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SQL_SELECT_POR_REFERENCIA);
            ps.setString(1, identificacion);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (identificacion.equalsIgnoreCase(rs.getString("identificacion"))) {
                    persona.setCodigo(rs.getInt("codigo"));
                    persona.setNombres(rs.getString("nombre"));
                    persona.setApellidos(rs.getString("apellido"));
                    persona.setTipo_persona(rs.getString("tipo_persona"));
                    break;
                }
            }
        } finally {
            Conexion.cerrarFlujo(rs);
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
        return persona;
    }

    private Persona Estudiante() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
