
package proaula.JJ.servicios;

import java.util.List;
import proaula.JJ.domain.Estudiante;
import proaula.JJ.domain.Persona;
import proaula.JJ.domain.Profesor;


/**
 *
 * @author jimen
 */
public interface IService {
    
    public boolean agregarEstudiante(Object recurso);
    public boolean agregarProfesor(Object recurso);
    public List listar();
    public List listarEstudiante();
    public List listarProfesor();
    public Persona buscar(Object recurso);
    public Estudiante buscarEstudiante(Object recurso);
    public Profesor buscarProfesor(Object recurso);
    public boolean eliminarPersona(int codigo);
    public boolean modificarEstudiante(Object recurso);
    public boolean modificarProfesor(Object recurso);
    
}
