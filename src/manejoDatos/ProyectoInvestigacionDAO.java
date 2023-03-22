
package manejoDatos;

import proyectodeinvestigacion.domain.ProyectoInvestigacion;
import config.Conexion;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProyectoInvestigacionDAO extends Conexion implements IAccesoDatos{
    
    private static final String INSERT =  "INSERT INTO proyectos (Acronimo, lider_proyecto, id_profesor, Objetivo, Fecha, id_Grupo) VALUES (?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE proyectos set codigo=?, Acronimo=?, lider_proyecto=?, id_profesor=?, Objetivo=?, Fecha=? WHERE codigo =?";
    private static final String DELETE = "DELETE FROM proyectos WHERE codigo=?";
    IExiste existe;
    ProfesorDAO profesorDAO = new ProfesorDAO();
    ProyectoInvestigacion proyecto = null;
    Conexion cn = new Conexion();
    boolean bandera = false;
    
    @Override
    public void registrar(Object recurso) {
        proyecto = (ProyectoInvestigacion) recurso;
        existe = new ExisteDAO();
        if(existe.existeProyecto(proyecto) == false && !profesorDAO.consultar(proyecto.getLiderProyecto()).equals("") ){
            try {
            conn = cn.Conexion();
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, proyecto.getAcronimo());
            ps.setString(2, proyecto.getLiderProyecto());
            ps.setString(3, (String) profesorDAO.consultar(proyecto.getLiderProyecto()));
            ps.setString(4, proyecto.getObjetivo());
            ps.setString(5, proyecto.getFechaRegistro());
            ps.setInt(6, proyecto.getId_grupo());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registrado ");
        } catch (HeadlessException | SQLException e) {
            System.out.println("Registrar proyecto: " + e);
        } finally {
            super.cerrarFlujo(conn);
           }
        }   
    }
    
    @Override
    public List buscar(String recurso) {
        List<ProyectoInvestigacion> listProyecto = new ArrayList();
        String sql;
        if(2==2){
             sql = "select * from proyectos";
        }else{
            sql = "select * from proyectos WHERE id_profesor='" +recurso+ "'";
        }   
        try {
            conn = cn.Conexion();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int codigo = rs.getInt(1);
                String acronimo = rs.getString("Acronimo");
                String LiderProyecto = rs.getString("lider_proyecto");
                String objetivo = rs.getString("Objetivo");
                String fecha = rs.getString("Fecha");
                int idGrupo = rs.getInt("id_grupo");    
                proyecto = new ProyectoInvestigacion(codigo, acronimo, objetivo, LiderProyecto, LiderProyecto, fecha, idGrupo);
                listProyecto.add(proyecto);
            }
        } catch (SQLException e) {
            System.out.println("Consultar proyecto: " + e);
        }finally {
            super.cerrarFlujo(conn);
           }
       return listProyecto;
    }

    @Override
    public boolean update(Object recurso) {
        proyecto = (ProyectoInvestigacion) recurso; 
        try {
            conn = cn.Conexion();
            ps = conn.prepareStatement(UPDATE);
            ps.setInt(0, proyecto.getCodigo());
            ps.setString(1, proyecto.getAcronimo());
            ps.setString(2, proyecto.getLiderProyecto());
            ps.setString(3, (String) profesorDAO.consultar(proyecto.getLiderProyecto()));
            ps.setString(4, proyecto.getObjetivo());
            ps.setString(5, proyecto.getFechaRegistro());
            ps.execute();
            bandera = true;
        } catch (SQLException e) {
            System.out.println("Update proyecto: " + e);
        } finally {
            super.cerrarFlujo(conn);
        }
        return bandera;
    }

    @Override
    public void eliminar(int recurso) {
        try {
            conn = cn.Conexion();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, recurso);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Proyecto Eliminado");
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error eliminar: " + e);
        } finally {
            super.cerrarFlujo(conn);
        }
    }

    @Override
    public Object consultar(Object recurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}


