/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proaula.JJ.servicios;

import config.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import proaula.JJ.domain.Estudiante;
import proaula.JJ.domain.Persona;
import proaula.JJ.domain.Profesor;
import proaula.JJ.manejoDatos.EstudianteDAO;
import proaula.JJ.manejoDatos.ExisteDAO;
import proaula.JJ.manejoDatos.IAccesoDatos;
import proaula.JJ.manejoDatos.IExiste;
import proaula.JJ.manejoDatos.PersonaDAO;
import proaula.JJ.manejoDatos.ProfesorDAO;

/**
 *
 * @author jimen
 */
public class PersonaService implements IService{
    
    @Override
    public boolean agregarEstudiante(Object recurso) {
        Connection conexion = null;
        Estudiante recursoEstudiante = (Estudiante) recurso;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            //Objetos de la capa de datos
            PersonaDAO personaDAO = new PersonaDAO(conexion);
            IAccesoDatos estudianteDAO = new EstudianteDAO(conexion);
            IExiste existeDAO = new ExisteDAO(conexion);
            
            int codigoPersona = -1;
            if (existeDAO.existePersona(recursoEstudiante.getCodigo() , recursoEstudiante.getIdentificacion()) == null) {
                //Agregar a la tabla persona
                personaDAO.Insert(recursoEstudiante);
                //Buscamos el codigo que se genero en la insercion
                Estudiante estudiante = (Estudiante) personaDAO.consultarReferencia(recursoEstudiante);
                codigoPersona = estudiante.getCodigo();
                //Agregamos el resto en la tabla estudiante
                recursoEstudiante.setCodigo(codigoPersona);
                estudianteDAO.Insert(recursoEstudiante);
            }
            conexion.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al registrar estudiante: " + ex);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    @Override
    public boolean agregarProfesor(Object recurso) {
        Connection conexion = null;
        Profesor recursoProfesor = (Profesor) recurso;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            //Objetos de Acceso a datos
            PersonaDAO personaDAO = new PersonaDAO(conexion);
            ProfesorDAO profesorDAO = new ProfesorDAO(conexion);
            ExisteDAO existeDAO = new ExisteDAO(conexion);
            
            int codigoPersona = -1;
            if (existeDAO.existePersona(recursoProfesor.getCodigo() , recursoProfesor.getIdentificacion()) == null) {
                //Agregar a la tabla persona
                personaDAO.Insert(recursoProfesor);
                //Buscamos el codigo que se genero en la insercion
                Profesor profesor = (Profesor) personaDAO.consultarReferencia(recursoProfesor);
                codigoPersona = profesor.getCodigo();
                //Agregamos a la tabla profesor
                recursoProfesor.setCodigo(codigoPersona);
                profesorDAO.Insert(recursoProfesor);
            }
            conexion.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return false;
    }

    @Override
    public List listar() {
        Connection conexion = null;
        List<Persona> listPersona = null;
        try {
            conexion = Conexion.getConnection();
            IAccesoDatos personaDAO = new PersonaDAO(conexion);
            listPersona = personaDAO.Select();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Aqui : " + ex);
        }
        return listPersona;
    }

    @Override
    public List listarEstudiante() {
        Connection conexion = null;
        List<Estudiante> listEstudiante = null;
        List<Estudiante> list = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            EstudianteDAO estudianteDAO = new EstudianteDAO(conexion);
            
            listEstudiante = estudianteDAO.Select();
            list = new ArrayList();
            
            for (int i = 0; i < listEstudiante.size(); i++) {
                Estudiante estudiante = new Estudiante();
                estudiante.setCodigo(listEstudiante.get(i).getCodigo());
                estudiante.setNombres(listEstudiante.get(i).getNombres());
                estudiante.setApellidos(listEstudiante.get(i).getApellidos());
                estudiante.setIdentificacion(listEstudiante.get(i).getIdentificacion());
                estudiante.setTipo_persona(listEstudiante.get(i).getTipo_persona());
                estudiante.setCorreo(listEstudiante.get(i).getCorreo());
                estudiante.setClave(listEstudiante.get(i).getClave());
                estudiante.setTelefono(listEstudiante.get(i).getTelefono());
                estudiante.setCarrera(listEstudiante.get(i).getCarrera());
                estudiante.setSemestre(listEstudiante.get(i).getSemestre());
                list.add(estudiante);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Aqui : " + ex);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }

    @Override
    public List listarProfesor() {
        Connection conexion = null;
        List<Profesor> listProfesor = null;
        List<Profesor> list = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            IAccesoDatos profesorDAO = new ProfesorDAO(conexion);
            
            listProfesor = profesorDAO.Select();
            list = new ArrayList();
            
            for (int i = 0; i < listProfesor.size(); i++) {
                Profesor profesor = new Profesor();
                profesor.setCodigo(listProfesor.get(i).getCodigo());
                profesor.setNombres(listProfesor.get(i).getNombres());
                profesor.setApellidos(listProfesor.get(i).getApellidos());
                profesor.setIdentificacion(listProfesor.get(i).getIdentificacion());
                profesor.setTipo_persona(listProfesor.get(i).getTipo_persona());
                profesor.setCorreo(listProfesor.get(i).getCorreo());
                profesor.setClave(listProfesor.get(i).getClave());
                profesor.setTelefono(listProfesor.get(i).getTelefono());
                profesor.setDepartamento(listProfesor.get(i).getDepartamento());
                list.add(profesor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Aqui : " + ex);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }

    @Override
    public boolean modificarEstudiante(Object recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificarProfesor(Object recurso) {
        Connection conexion = null;
        Profesor recursoProfesor = (Profesor) recurso;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            IExiste existeDAO = new ExisteDAO(conexion);
            IAccesoDatos personaDAO = new PersonaDAO(conexion);
            IAccesoDatos profesorDAO = new ProfesorDAO(conexion);
            if(existeDAO.existePersona(recursoProfesor.getCodigo(), recursoProfesor.getIdentificacion()) != null){
                //Actualizamos en persona
                personaDAO.Update(recursoProfesor);
                Profesor profesor = (Profesor) personaDAO.consultarReferencia(recursoProfesor.getIdentificacion());
                int codigo = profesor.getCodigo();
                profesor.setCodigo(codigo);
                profesorDAO.Update(profesor);
            }else{
                return false;
            }
            conexion.commit();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al registrar profesor: " + ex);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
        return true;
    }

    @Override
    public Persona buscar(Object recurso) {
     return null;
    }

    @Override
    public Estudiante buscarEstudiante(Object recurso) {
        Connection conexion = null;
        Estudiante recursoEstudiante = (Estudiante) recurso;
        Estudiante estudiante = null;
        try {
            conexion = Conexion.getConnection();
            IAccesoDatos estudianteDAO = new EstudianteDAO(conexion);
            estudiante = (Estudiante) estudianteDAO.consultarReferencia(recursoEstudiante);    
        } catch (SQLException ex) {
            Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return estudiante;
    }

    @Override
    public Profesor buscarProfesor(Object recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPersona(int codigo) {
        Connection conexion = null;  
        try {
            conexion = Conexion.getConnection();
            IAccesoDatos personaDAO = new PersonaDAO(conexion);
            personaDAO.Delete(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }


      
}
