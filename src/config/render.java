
package config;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;



public class render extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object renderizable, boolean isSelected, boolean hasFocus, int row, int column) {
       
        if(renderizable instanceof JButton){
            JButton boton = (JButton)renderizable;
            return boton; 
        }
        //To change body of generated methods, choose Tools | Templates.
        return super.getTableCellRendererComponent(table, renderizable, isSelected, hasFocus, row, column);
    }  
}
