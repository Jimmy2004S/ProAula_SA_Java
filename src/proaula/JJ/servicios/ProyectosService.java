/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proaula.JJ.servicios;

import config.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proaula.JJ.domain.Estudiante;
import proaula.JJ.domain.Login;
import proaula.JJ.domain.Persona;
import proaula.JJ.domain.Profesor;
import proaula.JJ.domain.ProyectoInvestigacion;
import proaula.JJ.manejoDatos.EstudianteDAO;
import proaula.JJ.manejoDatos.ExisteDAO;
import proaula.JJ.manejoDatos.IAccesoDatos;
import proaula.JJ.manejoDatos.IExiste;
import proaula.JJ.manejoDatos.PersonaDAO;
import proaula.JJ.manejoDatos.ProfesorDAO;
import proaula.JJ.manejoDatos.ProyectoInvestigacionDAO;

/**
 *
 * @author jimen
 */
public class ProyectosService implements IProyectos {

    @Override
    public boolean agregar(Object recurso) {
        ProyectoInvestigacion proyecto = (ProyectoInvestigacion) recurso;
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            //Objetos de la capa de datos 
            IExiste existeDAO = new ExisteDAO(conexion);
            IAccesoDatos proyectoDAO = new ProyectoInvestigacionDAO(conexion);
            IAccesoDatos estudianteDAO = new EstudianteDAO(conexion);
            IAccesoDatos profesorDAO = new ProfesorDAO(conexion);

            //Buscamos el codigo de la persona que esta agregando el proyecto
            Persona persona = null;
            int codigoPersona = -1;
            Estudiante estudiante = null;
            Profesor profesor = null;
            //Validamos en que tabla va buscar el codigo
            if(Login.getTipo_persona().equalsIgnoreCase("Estudiante")){
                persona = new Estudiante();
                persona.setIdentificacion(Login.getUser());
                estudiante = (Estudiante) estudianteDAO.consultarReferencia(persona);   
                codigoPersona = estudiante.getCodigo();
            }else if(Login.getTipo_persona().equalsIgnoreCase("Profesor")){
                persona = new Profesor();
                persona.setIdentificacion(Login.getUser());
                profesor = (Profesor) profesorDAO.consultarReferencia(persona);
                codigoPersona = profesor.getCodigo();
            }

            proyecto.setCodigo_lider(codigoPersona);
            if (existeDAO.existeProyecto(proyecto.getAcronimo()) == null) {
                proyectoDAO.Insert(proyecto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProyectosService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex);
        }
        return false;
    }

    @Override
    public List listar() {
        Connection conexion = null;
        List<ProyectoInvestigacion> listProyectos = null;
        try {
            conexion = Conexion.getConnection();
            IAccesoDatos proyectoDAO = new ProyectoInvestigacionDAO(conexion);
            listProyectos = proyectoDAO.Select();
        } catch (SQLException ex) {
            Logger.getLogger(ProyectosService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error ; " + ex);
        }
        return listProyectos;
    }

    @Override
    public boolean eliminar(int codigo) {

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            IAccesoDatos proyectoDAO = new ProyectoInvestigacionDAO(conexion);
            IExiste existe = new ExisteDAO(conexion);
            proyectoDAO.Delete(codigo);
            conexion.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProyectosService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex);
        }
        return false;
    }

    @Override
    public boolean modificar(Object recurso) {
        Connection conexion = null;
        
        try {
            conexion = Conexion.getConnection();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProyectosService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
