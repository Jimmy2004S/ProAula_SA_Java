package proaula.JJ.servicios;

import config.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proaula.JJ.domain.Grupo;
import proaula.JJ.manejoDatos.ExisteDAO;
import proaula.JJ.manejoDatos.GrupoDAO;
import proaula.JJ.manejoDatos.IExiste;
import proaula.JJ.manejoDatos.IGrupoDAO;

/**
 *
 * @author jimen
 */
public class GrupoService implements IGrupoService {

    @Override
    public boolean agregarGrupo(String nombre) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);

            IGrupoDAO grupoDAO = new GrupoDAO(conexion);
            IExiste existeDAO = new ExisteDAO(conexion);
            int codigoGrupo = -1;
            if (existeDAO.existeGrupo(0, nombre) == null) {
                grupoDAO.InsertGrupo(nombre);
                codigoGrupo = existeDAO.existeGrupo(0, nombre).getCodigo();
            } else {
                JOptionPane.showMessageDialog(null, "El grupo ya existe");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GrupoService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
    public List listarGrupos() {
        Connection conexion = null;
        List<Grupo> listGrupo = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
            IGrupoDAO grupoDAO = new GrupoDAO(conexion);
            listGrupo = grupoDAO.SelectGrupo();
    }
    catch (SQLException ex
        ) {
            Logger.getLogger(GrupoService.class.getName()).log(Level.SEVERE, null, ex);
    }
        return listGrupo;
    }

    @Override
        public boolean modificarGrupo(Object recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public boolean eliminarGrupo(int codigoGrupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public boolean agregarPersonaGrupo(int codigoPersona, int codigoGrupo) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            conexion.setAutoCommit(false);
        
            IGrupoDAO grupoDAO = new GrupoDAO(conexion);
            IExiste existeDAO = new ExisteDAO(conexion);
            
            if(existeDAO.existeGrupo( codigoGrupo , "") != null){
                grupoDAO.InsertPersonaGrupo(codigoPersona, codigoGrupo);
            }else{
                JOptionPane.showMessageDialog(null, "No existe el grupo");
                return false;
            

}
        } catch (SQLException ex) {
            Logger.getLogger(GrupoService.class
.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    @Override
        public boolean borrarPersonaGrupo(int codigoPersona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
        public List listarPersonaGrupo(int codigoGrupo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Grupo buscarGrupo(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
