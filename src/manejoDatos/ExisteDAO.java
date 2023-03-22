/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejoDatos;

import proyectodeinvestigacion.domain.ProyectoInvestigacion;
import proyectodeinvestigacion.domain.Estudiante;
import proyectodeinvestigacion.domain.Profesor;
import proyectodeinvestigacion.domain.Grupo;
import config.Conexion;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jimmy
 */
public class ExisteDAO extends Conexion implements  IExiste {

    private static final String SELECT_ESTUDIANTES = "SELECT * FROM estudiantes";
    boolean bandera;
   Conexion cn = new Conexion();
   
    @Override
    public boolean existeProyecto(ProyectoInvestigacion proyecto) {
        bandera = false;
        String sql2 = "SELECT * FROM proyectos";
        try {
            conn = cn.Conexion();
            st = conn.createStatement();
            rs = st.executeQuery(sql2);
            String acro = proyecto.getAcronimo();
            while (rs.next()) {
                if (acro.equalsIgnoreCase(rs.getString("Acronimo"))) {
                    bandera = true;
                    JOptionPane.showMessageDialog(null, "Ya existe un proyecto con este nombre");
                    break;
                }
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }finally{
            super.cerrarFlujo(conn);
        }
        return bandera;
    }
    

    @Override
    public boolean existeProfesor(Profesor profesor) {
        bandera = false;
        String sql = "select * from profesores";
        String nombre = profesor.getNombres();
        String identificacion = profesor.getIdentificacion();
        try {
            conn = cn.Conexion();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if (nombre.equals(rs.getString("Nombre")) || identificacion.equals(rs.getString("identificacion"))) {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe");
                    bandera = true;
                    break;
                }
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }finally{
            super.cerrarFlujo(conn);
        }
        return bandera;
    }

    @Override
    public boolean existeGrupo(Grupo grupo) {
        return false; 
    }

    @Override
    public boolean existeEstudiante(Estudiante estudiante) {
        
        String identificacion = estudiante.getIdentificacion();
        conn = cn.Conexion();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(SELECT_ESTUDIANTES);
            while(rs.next()){
               if(identificacion.equals(rs.getString("identificacion"))){
                  return true;
            }}
        } catch (SQLException ex) {
            Logger.getLogger(ExisteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return false;     
    }

  

   
    
    
    
}
