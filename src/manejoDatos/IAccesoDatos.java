
package manejoDatos;

import java.util.List;

public interface IAccesoDatos{
    
    IExiste existe = new ExisteDAO();
    
    void registrar(Object recurso);
    List buscar(String recurso);
    boolean update(Object recurso);
    void eliminar(int recurso);
    Object consultar(Object recurso);   
}