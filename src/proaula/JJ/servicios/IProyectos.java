
package proaula.JJ.servicios;

import java.util.List;

public interface IProyectos {
    
    public boolean agregar(Object recurso);
    public boolean eliminar(int codigo);
    public List listar();
    public boolean modificar(Object recurso);
}
