
package proaula.JJ.manejoDatos;

import java.sql.SQLException;
import java.util.List;

public interface IAccesoDatos{
    
    IExiste existe = new ExisteDAO();
    
    void Insert(Object recurso)throws SQLException;
    List Select()throws SQLException;
    void Update(Object recurso)throws SQLException;
    void Delete(int recurso)throws SQLException;
    public Object consultarReferencia(Object recurso)throws SQLException;
    
}