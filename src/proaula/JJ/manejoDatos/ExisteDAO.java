/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proaula.JJ.manejoDatos;

import proaula.JJ.domain.ProyectoInvestigacion;
import proaula.JJ.domain.Estudiante;
import proaula.JJ.domain.Grupo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proaula.JJ.domain.Persona;

/**
 *
 * @author Jimmy
 */
public class ExisteDAO implements IExiste {

    private Connection conTransaccional;
    private static final String SELECT_PERSONA = "SELECT * FROM `persona` WHERE codigo=? || identificacion=?";
    private static final String SELECT_PROYECTOS = "SELECT * FROM proyectos";
    private static final String SELECT__GRUPOS = "SELECT * FROM `grupo` WHERE codigo=? || nombre=?";

    public ExisteDAO() {
    }

    public ExisteDAO(Connection conTransaccional) {
        this.conTransaccional = conTransaccional;
    }

    @Override
    public ProyectoInvestigacion existeProyecto(String nombreproyecto) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProyectoInvestigacion proyecto = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SELECT_PROYECTOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (nombreproyecto.equalsIgnoreCase(rs.getString("nombre"))) {
                    proyecto = new ProyectoInvestigacion();
                    proyecto.setCodigo(rs.getInt("codigo"));
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
        return proyecto;
    }


    @Override
    public Grupo existeGrupo(int codigo , String nombre) throws SQLException{
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Grupo grupo = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SELECT_PERSONA);
            ps.setInt(1, codigo);
            ps.setString(2, nombre);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (nombre.equals(rs.getString("nombre")) || codigo == rs.getInt("codigo")) {
                    grupo = new Grupo();
                    grupo.setCodigo(rs.getInt("codigo"));
                    grupo.setNick(rs.getString("nombre"));
                    break;
                }
            }
        }finally {
            Conexion.cerrarFlujo(rs);
            Conexion.cerrarFlujo(ps);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
        return grupo;
    }

   
    @Override
    public Persona existePersona(int codigo , String identificacion) throws SQLException {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Persona persona = null;
        try {
            conn = this.conTransaccional != null ? this.conTransaccional : Conexion.getConnection();
            ps = conn.prepareStatement(SELECT_PERSONA);
            ps.setInt(1, codigo);
            ps.setString(2, identificacion);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (identificacion.equals(rs.getString("identificacion")) || codigo == rs.getInt("codigo")) {
                    persona = new Estudiante();
                    persona.setNombres(rs.getString("nombre"));
                    persona.setApellidos(rs.getString("apellidos"));
                    persona.setTipo_persona(rs.getString("tipo_persona"));
                    break;
                }
            }
        }finally {
            Conexion.cerrarFlujo(ps);
            Conexion.cerrarFlujo(rs);
            if (this.conTransaccional == null) {
                Conexion.cerrarFlujo(conn);
            }
        }
        return persona;
    }



}
