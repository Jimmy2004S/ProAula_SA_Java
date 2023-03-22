
package proyectodeinvestigacion.main;
import VentanasProAula.VentanaInicio;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import manejoDatos.ProyectoInvestigacionDAO;



public class Principal {
    
   public static void main(String[] ar) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    
       
       try {
            UIManager.setLookAndFeel(new AcrylLookAndFeel());
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
           VentanaInicio b;
           b = new VentanaInicio();
           b.setLocationRelativeTo(null);
           b.setVisible(true);
                    break;
                }
            }
       } catch (UnsupportedLookAndFeelException ex) {
           Logger.getLogger(VentanaInicio.class.getName()).log(Level.SEVERE, null, ex);
       }

 
    
}}
   
