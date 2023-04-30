
package proaula.JJ.manejoDatos;

import java.sql.SQLException;
import java.util.List;

public interface IGrupoDAO{
    
    IExiste existe = new ExisteDAO();
    
    public void InsertGrupo(String nombre)throws SQLException;
    public List SelectGrupo()throws SQLException;
    public void UpdateGrupo(Object recurso)throws SQLException;
    public void DeleteGrupo(int codigoGrupo)throws SQLException;
    
    public void InsertPersonaGrupo(int codigoPersona , int codigoGrupo) throws SQLException;
    public void DeletePersonaGrupo(int codigoPersona)throws SQLException;
    public List SelectPersonaGrupo(int codigoGrupo)throws SQLException;
    
}