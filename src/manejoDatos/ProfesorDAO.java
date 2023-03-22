package manejoDatos;
import proyectodeinvestigacion.domain.Profesor;
import config.Conexion;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProfesorDAO extends Conexion implements IAccesoDatos{

    boolean bandera = false;
    Profesor profesor = null;
    Conexion cn = new Conexion();
    
    private static final String SQL_INSERT = "INSERT INTO profesores (Nombre,identificacion,Cargo,user,correo) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE profesores set codigo=?, Nombre=?, identificacion=?, cargo=?, user=?, correo=?  WHERE codigo =?";
    private static final String SQL_DELETE = "DELETE FROM profesores WHERE codigo=?";
    
    @Override
    public void registrar(Object recurso) {
        profesor = (Profesor) recurso;
        try {
            if (existe.existeProfesor(profesor) == false) {
                conn =  cn.Conexion();
                ps = conn.prepareStatement(SQL_INSERT);
                ps.setString(1, profesor.getNombres());
                ps.setString(2, profesor.getIdentificacion());
                ps.setString(3, profesor.getCargo());
                ps.setString(4, profesor.getUser());
                ps.setString(5, profesor.getCorreo());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "¡¡Registrado!!  \n Usuario: " + profesor.getUser() + "\n contraseña: " + profesor.getIdentificacion());
            }else{
                JOptionPane.showInputDialog("Ya existe el Profesor");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        } finally {
           super.cerrarFlujo(conn);
        }
    }

    @Override
    public List buscar(String recurso) {
        List<Profesor> listProfesor= new ArrayList(); 
         String sql = "";
        if(recurso.equals("")){
            sql = "select * from profesores";
        }else{
            sql = "SELECT * FROM profesores WHERE identificacion ='"+recurso+"'";
        }     
        try {
            conn =  cn.Conexion();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String identificacion = rs.getString("identificacion");
                String cargo = rs.getString("cargo");
                String correo = rs.getString("correo");
                String user = rs.getString("user");
                String clave = rs.getString("clave");
                profesor = new Profesor(cargo, codigo, nombre, "", identificacion, correo, user, clave);
                listProfesor.add(profesor);
            } 
        } catch (SQLException e) {
            System.out.println("consultar: " + e);
        }finally{
            super.cerrarFlujo(conn);
        }
        return listProfesor;
    } 

    @Override
    public boolean update(Object recurso) {
        Profesor profesor = (Profesor) recurso;
        try {
            conn =  cn.Conexion();
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setInt(0, profesor.getCodigo());
            ps.setString(1, profesor.getNombres());
            ps.setString(2, profesor.getIdentificacion());
            ps.setString(3, profesor.getCargo());
            ps.setString(4, profesor.getUser());
            ps.setString(5, profesor.getCorreo());
            ps.executeUpdate();
            bandera = true;
        } catch (SQLException e) {
            System.out.println("Update: " + e);
        }finally{
            super.cerrarFlujo(conn);
        } 
        return false;
    }

    @Override
    public void eliminar(int recurso) {
        try {
            conn =  cn.Conexion();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, recurso);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Eliminar: " + e);
        }finally{
          super.cerrarFlujo(conn);
        }
    }
    
    @Override
    public Object consultar(Object recurso) {
        boolean banderaProfe = false;
        String idProfe = "";
        String nomProfesor = (String)recurso;
        String sql = "SELECT * FROM profesores WHERE Nombre='" + nomProfesor + "'";
        try {
            conn = cn.Conexion();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if (nomProfesor.equalsIgnoreCase(rs.getString("Nombre"))) {
                    idProfe = rs.getString("identificacion");
                    break;
                }
            }
            if (banderaProfe == false) {
                JOptionPane.showMessageDialog(null, "El profesor no existe");
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Tomar id profesor: " + e);
        }finally{
            super.cerrarFlujo(conn);
        }
        return idProfe;
    }
    
}
