/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoDatos;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectodeinvestigacion.domain.Estudiante;
import proyectodeinvestigacion.domain.Profesor;

public class EstudianteDAO extends Conexion implements IAccesoDatos {

    private static final String SQL_INSERT = "INSERT INTO estudiantes(nombre, apellidos, semestre, identificacion, correo, user, clave) VALUES (?,?,? ,?,?,?,?)";
    private static final String SQL_SELECT = "SELECT * estudiantes";
    Conexion cn = new Conexion();
    Estudiante estudiante = null;
    
    @Override
    public void registrar(Object recurso) {
        estudiante = (Estudiante) recurso;
        if(!existe.existeEstudiante(estudiante)){
            conn =  cn.Conexion();
            try {
                ps = conn.prepareStatement(SQL_INSERT);
                ps.setString(1, estudiante.getNombres());
                ps.setString(2, estudiante.getApellidos());
                ps.setString(3, estudiante.getSemestre());
                ps.setString(4, estudiante.getIdentificacion());
                ps.setString(5, estudiante.getCorreo());
                ps.setString(6, estudiante.getUser());
                ps.setString(7, estudiante.getClave());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Estudiante R");
            } catch (SQLException ex) {
                System.out.println("Problemas Registrar estudiante: " + ex);
            }finally{
                super.cerrarFlujo(conn);
            }       
        } 
    }

    @Override
    public List buscar(String recurso) {   
        List<Estudiante> listEstudiante = new ArrayList();
        conn = cn.Conexion();
        try {
            conn = cn.Conexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String identificacion = rs.getString("identificacion");
                String correo = rs.getString("correo");
                String user = rs.getString("user");
                String clave = rs.getString("clave");
                estudiante = new Estudiante(nombre, codigo, nombre, recurso, identificacion, correo, user, clave);
                listEstudiante.add(estudiante);
            }
        } catch (SQLException ex) {
            System.out.println("Error listar Estudiante: " + ex);
        }finally{
            super.cerrarFlujo(rs);
            super.cerrarFlujo(ps);
            super.cerrarFlujo(conn);
        }
        return listEstudiante;
    }

    @Override
    public boolean update(Object recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultar(Object recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
