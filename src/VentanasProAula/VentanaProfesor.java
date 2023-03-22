package VentanasProAula;

import manejoDatos.IAccesoDatos;
import proyectodeinvestigacion.domain.Profesor;
import manejoDatos.ProfesorDAO;
import config.Conexion;
import config.Correos;
import config.TextPrompt;
import config.render;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.JOptionPane;

public class VentanaProfesor extends javax.swing.JDialog {

    //VARIABLES PARA ENVIAR CORREOS
    Correos correo = new Correos();
    //VARIABLES PARA USAR LA BASE DE DATOS
    IAccesoDatos profesorDAO = new ProfesorDAO();
    Profesor profesor;
    Conexion con = new Conexion();
    Connection connet = con.Conexion();
    Statement st;
    ResultSet rs;
    int id;
    static String nombreUsu;
   
    DefaultTableModel modelo;
    JButton btnEliminar = new JButton("");
    String nombre;


    public VentanaProfesor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        TextPrompt txt1 = new TextPrompt("Buscar", txtBuscar);
        TextPrompt txt2 = new TextPrompt("Identificacion", txtId);
        TextPrompt txt3 = new TextPrompt("Nombre", txtNomProf);
        TextPrompt txt4 = new TextPrompt("Correo", txtCorreo);
        insertarIcono(btnEliminar, "/imagenes/Eliminar.png");
        Listar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoCargoProfesor = new javax.swing.ButtonGroup();
        grupoDoctorado = new javax.swing.ButtonGroup();
        pnBotones = new javax.swing.JPanel();
        btnMenu = new javax.swing.JPanel();
        txtNomProf = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jComCargo = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JPanel();
        lbAgregar = new javax.swing.JLabel();
        btnModificar = new javax.swing.JPanel();
        lbModificar = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla2 = new javax.swing.JTable();
        etiFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GESTIONAR PROFESORES");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnBotones.setBackground(new java.awt.Color(0, 0, 0, 80));
        pnBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenu.setBackground(new java.awt.Color(153, 153, 153));
        btnMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMenuMouseEntered(evt);
            }
        });
        btnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnBotones.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 20, 60));

        txtNomProf.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtNomProf.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtNomProf.setSelectionColor(new java.awt.Color(0, 55, 255));
        txtNomProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtNomProfMousePressed(evt);
            }
        });
        txtNomProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomProfActionPerformed(evt);
            }
        });
        txtNomProf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomProfKeyTyped(evt);
            }
        });
        pnBotones.add(txtNomProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 270, 38));

        txtId.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtId.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtId.setSelectionColor(new java.awt.Color(0, 55, 255));
        txtId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtIdMousePressed(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        pnBotones.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 270, 40));

        jComCargo.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jComCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione --", "Profesor", "Estudiante" }));
        jComCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComCargoActionPerformed(evt);
            }
        });
        pnBotones.add(jComCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 150, -1));

        btnAgregar.setBackground(new java.awt.Color(39, 107, 215));
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbAgregar.setForeground(new java.awt.Color(255, 255, 255));
        lbAgregar.setText("Agregar");
        lbAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAgregarMouseClicked(evt);
            }
        });
        btnAgregar.add(lbAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        pnBotones.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 200, 40));

        btnModificar.setBackground(new java.awt.Color(255, 0, 0));
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });
        btnModificar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbModificar.setBackground(new java.awt.Color(255, 255, 255));
        lbModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbModificar.setForeground(new java.awt.Color(255, 255, 255));
        lbModificar.setText("Modificar");
        lbModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbModificarMouseClicked(evt);
            }
        });
        btnModificar.add(lbModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        pnBotones.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 200, 40));

        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnBotones.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 270, 40));

        getContentPane().add(pnBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 350, 300));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Buscar.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBuscar.setBorder(null);
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.setSelectionColor(new java.awt.Color(102, 204, 255));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 230, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 270, 40));

        tblTabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Identificacion", "Cargo", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTabla2.setRowHeight(30);
        tblTabla2.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tblTabla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTabla2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblTabla2MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblTabla2);
        if (tblTabla2.getColumnModel().getColumnCount() > 0) {
            tblTabla2.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblTabla2.getColumnModel().getColumn(0).setMaxWidth(500);
            tblTabla2.getColumnModel().getColumn(4).setPreferredWidth(30);
            tblTabla2.getColumnModel().getColumn(4).setMaxWidth(500);
            tblTabla2.getColumnModel().getColumn(5).setPreferredWidth(30);
            tblTabla2.getColumnModel().getColumn(5).setMaxWidth(500);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 600, 190));

        etiFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Escribiendo.png"))); // NOI18N
        jPanel2.add(etiFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 680));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void Listar() {
        this.tblTabla2.setDefaultRenderer(Object.class, new render());
        String buscar = "";
        List<Profesor> listProfesor =  profesorDAO.buscar(buscar);
        Object[] profesor = new Object[5];
        modelo = (DefaultTableModel) tblTabla2.getModel();
            for(int i = 0; i <  listProfesor.size() ; i++) {
               profesor[0] = listProfesor.get(i).getCodigo();
               profesor[1] = listProfesor.get(i).getNombres();
               profesor[2] = listProfesor.get(i).getIdentificacion();
               profesor[3] = listProfesor.get(i).getCargo();
               profesor[4] = btnEliminar;
               modelo.addRow(profesor);
            }
            tblTabla2.setModel(modelo);
    }
    
    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    void Agregar() {
//        String sql = "SELECT max(codigo) from profesores";
//        int idMax = 0;
//        try {
//            st = connet.createStatement();
//            rs = st.executeQuery(sql);
//            while(rs.next()){
//                idMax = rs.getInt("max(codigo)");
//            }
//        } catch (SQLException ex) {
//            System.out.println("Problemas con id max: " + ex);
//        }
//         String idMax2 = Integer.toString(idMax+1);
        String cargo = (String) jComCargo.getSelectedItem();
        if(cargo.equals("Profesor")){
            profesor = new Profesor();
            profesor.setNombres(txtNomProf.getText());
            profesor.setIdentificacion(txtId.getText());
            profesor.setCargo(cargo);
            nombreUsu = txtNomProf.getText();
            profesor.setUser(nombreUsu);
            profesor.setCorreo(txtCorreo.getText());
            profesorDAO.registrar(profesor);
        }
       
        
        limpiarTabla();
    }
    
    void modificar() {
        int fila = tblTabla2.getSelectedRow();
        id = Integer.parseInt(tblTabla2.getValueAt(fila, 0).toString());
        nombreUsu = txtNomProf.getText()+"_"+id;
        nombre = (String) tblTabla2.getValueAt(fila, 1).toString();
        //ACTUALIZAR PROFESOR
        profesor  = new Profesor();
        profesor.setCodigo(id);
        profesor.setNombres((String) tblTabla2.getValueAt(fila, 1).toString());
        profesor.setIdentificacion(txtId.getText());
        profesor.setCargo(jComCargo.getSelectedItem().toString());
        profesor.setCorreo(txtCorreo.getText());
        profesorDAO.update(profesor);
        
        //ACTUALIZAR PROYECTOS
        String sql = "UPDATE proyectos set id_profesor='" + txtId.getText() + "',LiderProyecto='"
                +txtNomProf.getText()+"' WHERE LiderProyecto ='" +nombre+ "'";
        try {
            connet = con.Conexion();
            st = connet.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Problemas al modificar " + ex);
        }
    }
    
    void eliminar() throws SQLException {
        int fila = tblTabla2.getSelectedRow();
        id = Integer.parseInt(tblTabla2.getValueAt(fila, 0).toString());
        profesorDAO.eliminar(id);
        txtBuscar.setText("");
        limpiarTabla();
        
    }
    public final void insertarIcono(JButton btn, String ruta) {
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
    }
    
    private void createEmail() {
        correo.createEmail(txtCorreo.getText().trim(), txtId.getText(), nombreUsu);
    }
    private void sendEmail() {
        correo.sendEmail();
    }

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed

    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNomProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomProfActionPerformed

    }//GEN-LAST:event_txtNomProfActionPerformed

    private void txtNomProfMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNomProfMousePressed

    }//GEN-LAST:event_txtNomProfMousePressed

    private void txtIdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdMousePressed

    }//GEN-LAST:event_txtIdMousePressed

    TableRowSorter trs;
    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped

        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscar.getText(), 0, 1 , 3));
            }
        });

        trs = new TableRowSorter(modelo);
        tblTabla2.setRowSorter(trs);

    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void tblTabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTabla2MouseClicked
        int fila = tblTabla2.getSelectedRow();
        int col = tblTabla2.getSelectedColumn();
        //VALORES DE FILA SELECIONADA
        jComCargo.setSelectedItem(tblTabla2.getValueAt(fila, 3).toString());
        txtNomProf.setText(tblTabla2.getValueAt(fila, 1).toString());
        txtId.setText( tblTabla2.getValueAt(fila, 2).toString());
        //MOVER MENU DEZPLAZANTE
        int posicion = pnBotones.getX();
        if(posicion > 270){
            Animacion.Animacion.mover_izquierda(600,270, 2, 2, pnBotones);
        }
        if (col == 4) {
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar?");
            if (op == 0) {
                try {
                    eliminar();
                    Listar();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }

    }//GEN-LAST:event_tblTabla2MouseClicked

    private void jComCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComCargoActionPerformed

    private void lbAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAgregarMouseClicked

        
        if (!txtNomProf.getText().equals("") && !txtId.getText().equals("")
                && !jComCargo.getSelectedItem().equals("-- Seleccione --")
                && !txtCorreo.getText().equals("") && !jComCargo.getSelectedItem().equals("-- Seleccione --")) {
            Agregar();

            sendEmail();
            //VACIAR LOS CAMPOS
            txtNomProf.setText("");
            txtId.setText("");
            txtCorreo.setText("");
            jComCargo.setSelectedItem("--");
        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            limpiarTabla();
        }
        Listar();
        
        
    }//GEN-LAST:event_lbAgregarMouseClicked

    private void btnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseClicked
        int posicion = pnBotones.getY();
        if(posicion > 270){
            Animacion.Animacion.mover_izquierda(600,270, 2, 2, pnBotones);
        }else{
            Animacion.Animacion.mover_derecha(270,600, 2, 2, pnBotones);
        }
    }//GEN-LAST:event_btnMenuMouseClicked

    private void tblTabla2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTabla2MouseEntered
        int posicion = pnBotones.getY();
        if(posicion > 180){
            
        }else{
            Animacion.Animacion.mover_izquierda(270,600, 2, 2, pnBotones);
        }
    }//GEN-LAST:event_tblTabla2MouseEntered

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        modificar();
        Listar();
    }//GEN-LAST:event_btnModificarMouseClicked

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped

        int key = evt.getKeyChar();
        boolean numeros = (key >= 48 && key <= 57);
        
        if(!numeros){
            evt.consume();
//            Toolkit.getDefaultToolkit().beep();
        }if(txtId.getText().length() >= 12){
            evt.consume();
        }
        
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtNomProfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomProfKeyTyped
//        int key = evt.getKeyChar();
//        boolean mayusculas = key >=65 && key <= 90;
//        boolean minusculas = key >=97 && key <= 122;
//        
//        if(!(mayusculas || minusculas)){
//            evt.consume();
////            Toolkit.getDefaultToolkit().beep();
//        }if(txtId.getText().length() >= 25){
//            evt.consume();
//        }
    }//GEN-LAST:event_txtNomProfKeyTyped

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        if (!txtNomProf.getText().equals("")
                && !txtId.getText().equals("") && !jComCargo.getSelectedItem().equals("-- Seleccione --") && !txtCorreo.getText().equals("")) {
            Agregar();
            createEmail();
            sendEmail();
            txtNomProf.setText("");
            txtId.setText("");
            txtCorreo.setText("");
            jComCargo.setSelectedItem("--");
        } else if(jComCargo.getSelectedItem().equals("-- Seleccione --")){
            JOptionPane.showMessageDialog(null, "Cargo no selecionado");
            limpiarTabla();
        }
            else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            limpiarTabla();
        }
        Listar();
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseEntered
     
    }//GEN-LAST:event_btnMenuMouseEntered

    private void lbModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbModificarMouseClicked
        modificar();
        Listar();
    }//GEN-LAST:event_lbModificarMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoCargoProfesor;
    private javax.swing.JPanel btnAgregar;
    private javax.swing.JPanel btnMenu;
    private javax.swing.JPanel btnModificar;
    private javax.swing.JLabel etiFondo;
    private javax.swing.ButtonGroup grupoDoctorado;
    private javax.swing.JComboBox<String> jComCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAgregar;
    private javax.swing.JLabel lbModificar;
    private javax.swing.JPanel pnBotones;
    private javax.swing.JTable tblTabla2;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNomProf;
    // End of variables declaration//GEN-END:variables
}
