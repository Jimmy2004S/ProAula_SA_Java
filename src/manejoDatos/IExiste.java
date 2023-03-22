
package manejoDatos;

import proyectodeinvestigacion.domain.ProyectoInvestigacion;
import proyectodeinvestigacion.domain.Estudiante;
import proyectodeinvestigacion.domain.Profesor;
import proyectodeinvestigacion.domain.Grupo;

public interface IExiste{
    
    boolean existeProfesor(Profesor profesor);
    boolean existeProyecto(ProyectoInvestigacion proyecto);
    boolean existeGrupo(Grupo grupo);
    boolean existeEstudiante(Estudiante estudiante);
}
