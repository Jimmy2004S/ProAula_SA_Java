
package manejoDatos;

import config.Conexion;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import proyectodeinvestigacion.domain.Grupo;

public class GrupoDAO extends Conexion implements IAccesoDatos{

    IExiste existe;
    ProfesorDAO profesorDAO = new ProfesorDAO();
    ProyectoInvestigacionDAO proyecto = new ProyectoInvestigacionDAO();
    Conexion cn = new Conexion();
    
    @Override
    public void registrar(Object recurso) {
        Grupo grupo = (Grupo) recurso;
        String arregloPersona[] = grupo.getPersona();
        String sql = "INSERT INTO grupo(NombreGru, Participante1 , Participante2 , Participante3) "
               + "VALUES (?,?,?,?)";
        conn = cn.Conexion();
      try {
           ps = conn.prepareStatement(sql);
           ps.setString(2, grupo.getNick());
           ps.setString(3, arregloPersona[1]);
           ps.setString(4, arregloPersona[2]);
           ps.setString(5, arregloPersona[3]);
           JOptionPane.showMessageDialog(null, "Grupo creado");
       } catch (SQLException ex) {
           System.out.println("Error " + ex);
      }finally{
          super.cerrarFlujo(conn);
      }
    }

    @Override
    public List buscar(String recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(int recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultar(Object recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
