
package proaula.JJ.manejoDatos;

import java.sql.SQLException;
import proaula.JJ.domain.ProyectoInvestigacion;
import proaula.JJ.domain.Grupo;
import proaula.JJ.domain.Persona;

public interface IExiste{
    
    Persona existePersona(int codigo, String identificacion) throws SQLException;
    ProyectoInvestigacion existeProyecto(String nombreproyecto) throws SQLException;
    Grupo existeGrupo(int codigo , String nombre) throws SQLException;
}
