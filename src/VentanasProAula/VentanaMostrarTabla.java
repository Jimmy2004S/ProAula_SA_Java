package VentanasProAula;

import proyectodeinvestigacion.domain.ProyectoInvestigacion;
import proyectodeinvestigacion.domain.Profesor;
import proyectodeinvestigacion.domain.Grupo;
import proyectodeinvestigacion.domain.Login;
import manejoDatos.LoginDAO;
import config.*;
import config.render;

import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import manejoDatos.*;

public final class VentanaMostrarTabla extends javax.swing.JFrame {
    
    //MANEJO DE DATOS
    IAccesoDatos grupoDAO = new GrupoDAO();
    IAccesoDatos proyectoDAO = new ProyectoInvestigacionDAO(); 
    IAccesoDatos profesorDAO = new ProfesorDAO();
    ProyectoInvestigacion proyecto;
    Grupo grupo;
    Conexion con = new Conexion();
    Connection conne = con.Conexion();
    //INICIO DE SESION
    Login l = new Login();
    LoginDAO login = new LoginDAO();
    Statement st;
    ResultSet rs;
    // JTABLE
    JButton btnEliminar = new JButton("");
    JButton btnEditar = new JButton("");
    JButton btnPdf = new JButton("");
    DefaultTableModel modelo = new DefaultTableModel();
    
    static Date fecha;    
    int codigo;
    
    public VentanaMostrarTabla() {
        initComponents();
        jlUsuario.setText(l.getUser());
        jlIdentificacion.setText(Login.getClave());
//        if(l.getIdentificacion().equalsIgnoreCase("1043635986")){
//            btnEditar.setEnabled(true);
//            btnEliminar.setEnabled(true);
//        }
        CrearGrupos.setSize(510, 470);
        insertarIcono(btnEliminar, "/imagenes/Eliminar.png");
        insertarIcono(btnEditar, "/imagenes/Editar.png");
        insertarIcono(btnPdf, "/imagenes/pdf.png");
        fechas();
        ValoresPredeterminados();
        TextosEnCampos();
        ValidacionInicio();
        hora();
        Listar();
        llenarComboBox();
    }

    public void Listar() {
        this.tblTabla.setDefaultRenderer(Object.class, new render());
        List<ProyectoInvestigacion> listProyectos = proyectoDAO.buscar(Login.getClave());
            Object[] proyectos = new Object[8];
            modelo = (DefaultTableModel) tblTabla.getModel();
            for(int i = 0 ; i < listProyectos.size(); i++) {
                proyectos[0] = listProyectos.get(i).getCodigo();
                proyectos[1] = listProyectos.get(i).getAcronimo();
                proyectos[2] = listProyectos.get(i).getLiderProyecto();
                proyectos[3] = listProyectos.get(i).getObjetivo();
                proyectos[4] = listProyectos.get(i).getFechaRegistro();
                proyectos[5] = btnEliminar;
                proyectos[6] = btnEditar;
                proyectos[7] = btnPdf;
                modelo.addRow(proyectos);
            }
            tblTabla.setModel(modelo); 
    }
    
    public void eliminar() {
        int fila = tblTabla.getSelectedRow();
        codigo = Integer.parseInt(tblTabla.getValueAt(fila, 0).toString());
        proyectoDAO = new ProyectoInvestigacionDAO();
        proyectoDAO.eliminar(codigo);
        txtBuscar.setText("");
        limpiarTabla();
        Listar();
    }
    public void generarReportes() {
    }
    public void AgregarProyecto() {
        fecha = jCalendar2.getDate();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String fech = format.format(fecha);
        int grupo = Integer.parseInt((String) ComboBox.getSelectedItem());
        
        //ENVIAR OBJETO AL METODO AGRREGAR
        proyecto = new ProyectoInvestigacion();
        proyecto.setAcronimo(txtNombreP.getText());
        proyecto.setIdProfesor((String) profesorDAO.consultar(txtNombreP.getText()));
        proyecto.setLiderProyecto(txtLiderP.getText());
        proyecto.setObjetivo(txtObjetivoP.getText());
        proyecto.setFechaRegistro(fech);
        proyecto.setId_grupo(grupo);
        proyectoDAO.registrar(proyecto);
        limpiarTabla();
    }
    boolean modificar() {
        //TOMAR DATOS 
        int fila = tblTabla.getSelectedRow();
        codigo = Integer.parseInt(tblTabla.getValueAt(fila, 0).toString());
        fecha = jCalendar3.getDate();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String fech = format.format(fecha);
        //ENVIAR OBJETO AL METODO UPDATE
        proyecto = new ProyectoInvestigacion();
        proyecto.setCodigo(codigo);
        proyecto.setAcronimo(txtAcroni3.getText());
        proyecto.setLiderProyecto(txtLider3.getText());
        proyecto.setObjetivo(txtObjetivo3.getText());
        proyecto.setIdProfesor(txtIdentificacion3.getText());
        proyecto.setFechaRegistro(fech);
        return proyectoDAO.update(proyecto);
    }
   
    public void crearGrupos(){
        String PersonaGrupo[] = {LabelParticipante1.getText(), LabelParticipante2.getText() , LabelParticipante3.getText() };
        grupo = new Grupo();
        grupo.setNick(txtNombreGrupo.getText());
        grupo.setPersona(PersonaGrupo);
        grupoDAO.registrar(grupo);
   } 
   
   void agregarAlGrupo(){
        String sql = "SELECT Nombre FROM profesores WHERE identificacion='"+txtId.getText()+"'";
        String nomb2 = "";
        try {
            st = conne.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
              nomb2 = rs.getString("Nombre");
              System.out.println("AQUI: " + rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        txtNom2.setText(nomb2);  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CrearGrupos = new javax.swing.JDialog();
        panelFondo = new javax.swing.JPanel();
        btnCrearGrupos = new javax.swing.JButton();
        labelRegresarGr = new javax.swing.JLabel();
        panelLog = new javax.swing.JPanel();
        txtNombreGrupo = new javax.swing.JTextField();
        panelAzSup = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        LabelAgregarAlGrupo = new javax.swing.JLabel();
        txtNom2 = new javax.swing.JTextField();
        LabelParticipante1 = new javax.swing.JLabel();
        LabelParticipante2 = new javax.swing.JLabel();
        LabelParticipante3 = new javax.swing.JLabel();
        btnDesp = new javax.swing.JLabel();
        pnmenuSuperior = new javax.swing.JPanel();
        lbFecha = new javax.swing.JLabel();
        pnlDesple = new javax.swing.JPanel();
        lbSalir = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlIdentificacion = new javax.swing.JLabel();
        pnMostrarT = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnVentanaProf = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        Scroll = new javax.swing.JScrollPane();
        tblTabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pnAgregar = new javax.swing.JPanel();
        txtNombreP = new javax.swing.JTextField();
        txtLiderP = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        txtObjetivoP = new javax.swing.JTextField();
        jCalendar2 = new com.toedter.calendar.JDateChooser();
        txtIdentificacion2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblLogo2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbRegresar2 = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox<>();
        labelCrearGrupos = new javax.swing.JLabel();
        pnEditar = new javax.swing.JPanel();
        btnEditar2 = new javax.swing.JButton();
        lbRegresar3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jCalendar3 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtLider3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIdentificacion3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCodigo3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtAcroni3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtObjetivo3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblLogo1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        CrearGrupos.setResizable(false);
        CrearGrupos.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCrearGrupos.setBackground(new java.awt.Color(39, 107, 215));
        btnCrearGrupos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCrearGrupos.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearGrupos.setText("Crear Grupo");
        btnCrearGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearGruposActionPerformed(evt);
            }
        });
        panelFondo.add(btnCrearGrupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 120, 30));

        labelRegresarGr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelRegresarGr.setText("Regresar");
        labelRegresarGr.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelRegresarGr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegresarGrMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelRegresarGrMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelRegresarGrMouseExited(evt);
            }
        });
        panelFondo.add(labelRegresarGr, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        panelLog.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelLog.add(txtNombreGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 230, 30));

        panelFondo.add(panelLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 460, 70));

        panelAzSup.setBackground(new java.awt.Color(39, 107, 215));
        panelFondo.add(panelAzSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 40));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel7.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 30));

        LabelAgregarAlGrupo.setText("Agregar");
        LabelAgregarAlGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelAgregarAlGrupoMouseClicked(evt);
            }
        });
        jPanel7.add(LabelAgregarAlGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        txtNom2.setEditable(false);
        jPanel7.add(txtNom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 160, 30));
        jPanel7.add(LabelParticipante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 170, 30));
        jPanel7.add(LabelParticipante2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 170, 30));
        jPanel7.add(LabelParticipante3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 160, 30));

        panelFondo.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 460, 140));

        CrearGrupos.getContentPane().add(panelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 420));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDesp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"))); // NOI18N
        btnDesp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDesp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDespMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDespMouseEntered(evt);
            }
        });
        getContentPane().add(btnDesp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 50, -1));

        pnmenuSuperior.setBackground(new java.awt.Color(39, 107, 215));
        pnmenuSuperior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbFecha.setBackground(new java.awt.Color(0, 0, 0));
        lbFecha.setForeground(new java.awt.Color(255, 255, 255));
        lbFecha.setText(".");
        pnmenuSuperior.add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 150, -1));

        getContentPane().add(pnmenuSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 50));

        pnlDesple.setBackground(new java.awt.Color(0, 0, 0));
        pnlDesple.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));
        pnlDesple.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlDespleMouseExited(evt);
            }
        });
        pnlDesple.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSalir.setFont(lbSalir.getFont().deriveFont((lbSalir.getFont().getStyle() & ~java.awt.Font.ITALIC) & ~java.awt.Font.BOLD, lbSalir.getFont().getSize()+1));
        lbSalir.setForeground(new java.awt.Color(255, 255, 255));
        lbSalir.setText("Cerrar sesion");
        lbSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbSalirMouseEntered(evt);
            }
        });
        pnlDesple.add(lbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, 110, -1));

        jlUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jlUsuario.setText(".");
        pnlDesple.add(jlUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 210, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuariox96.png"))); // NOI18N
        pnlDesple.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jlIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        jlIdentificacion.setText(".");
        pnlDesple.add(jlIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 270, 140, -1));

        getContentPane().add(pnlDesple, new org.netbeans.lib.awtextra.AbsoluteConstraints(-250, 50, 250, 610));

        pnMostrarT.setBackground(new java.awt.Color(255, 255, 255));
        pnMostrarT.setForeground(new java.awt.Color(204, 204, 204));
        pnMostrarT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
        pnMostrarT.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 303, 33));

        btnVentanaProf.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnVentanaProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Administrar.png"))); // NOI18N
        btnVentanaProf.setFocusable(false);
        btnVentanaProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentanaProfActionPerformed(evt);
            }
        });
        pnMostrarT.add(btnVentanaProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, -1, 32));

        btnAgregar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/añadir-24.png"))); // NOI18N
        btnAgregar.setFocusable(false);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMouseExited(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        pnMostrarT.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, -1, -1));

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Acronimo", "Lider del proyecto", "Objetivo", "Fecha", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTabla.setOpaque(false);
        tblTabla.setRowHeight(35);
        tblTabla.setRowMargin(0);
        tblTabla.setSelectionBackground(new java.awt.Color(255, 0, 0));
        tblTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblTablaMouseEntered(evt);
            }
        });
        Scroll.setViewportView(tblTabla);
        if (tblTabla.getColumnModel().getColumnCount() > 0) {
            tblTabla.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblTabla.getColumnModel().getColumn(0).setMaxWidth(500);
            tblTabla.getColumnModel().getColumn(1).setResizable(false);
            tblTabla.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblTabla.getColumnModel().getColumn(2).setResizable(false);
            tblTabla.getColumnModel().getColumn(3).setResizable(false);
            tblTabla.getColumnModel().getColumn(4).setResizable(false);
            tblTabla.getColumnModel().getColumn(5).setPreferredWidth(30);
            tblTabla.getColumnModel().getColumn(5).setMaxWidth(500);
            tblTabla.getColumnModel().getColumn(6).setPreferredWidth(30);
            tblTabla.getColumnModel().getColumn(6).setMaxWidth(500);
            tblTabla.getColumnModel().getColumn(7).setPreferredWidth(30);
            tblTabla.getColumnModel().getColumn(7).setMaxWidth(500);
        }

        pnMostrarT.add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 800, 250));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Buscar.png"))); // NOI18N
        pnMostrarT.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, -1, 33));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoUnix331.png"))); // NOI18N
        jPanel2.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("FUNDACION UNIVERSITARIA COLOMBO INTERNACIONAL");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 380, -1));

        pnMostrarT.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1000, 100));

        getContentPane().add(pnMostrarT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1000, 610));

        pnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        pnAgregar.setForeground(new java.awt.Color(204, 204, 204));
        pnAgregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreP.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtNombreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePActionPerformed(evt);
            }
        });
        txtNombreP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePKeyTyped(evt);
            }
        });
        pnAgregar.add(txtNombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 230, 40));

        txtLiderP.setEditable(false);
        txtLiderP.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnAgregar.add(txtLiderP, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 200, 40));

        btnRegistrar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/añadir-24.png"))); // NOI18N
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnAgregar.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 50, 33));

        txtObjetivoP.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtObjetivoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObjetivoPActionPerformed(evt);
            }
        });
        txtObjetivoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObjetivoPKeyTyped(evt);
            }
        });
        pnAgregar.add(txtObjetivoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 230, 40));

        jCalendar2.setDateFormatString("dd/MM/yyyy hh:mm");
        jCalendar2.setEnabled(false);
        pnAgregar.add(jCalendar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 210, 40));

        txtIdentificacion2.setEditable(false);
        pnAgregar.add(txtIdentificacion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 200, 40));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoUnix331.png"))); // NOI18N
        jPanel1.add(lblLogo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 360, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("FUNDACION UNIVERSITARIA COLOMBO INTERNACIONAL");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 380, -1));

        pnAgregar.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 1000, 100));

        lbRegresar2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbRegresar2.setText("Regresar");
        lbRegresar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbRegresar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRegresar2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbRegresar2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbRegresar2MouseExited(evt);
            }
        });
        pnAgregar.add(lbRegresar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, -1, -1));

        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });
        pnAgregar.add(ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 230, 40));

        labelCrearGrupos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCrearGrupos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCrearGrupos.setText("¿Desea agregar un grupo?");
        labelCrearGrupos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelCrearGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCrearGruposMouseClicked(evt);
            }
        });
        pnAgregar.add(labelCrearGrupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 170, -1));

        getContentPane().add(pnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1000, 610));

        pnEditar.setBackground(new java.awt.Color(255, 255, 255));
        pnEditar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditar2.setBackground(new java.awt.Color(0, 102, 255));
        btnEditar2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEditar2.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar2.setText("ACTUALIZAR");
        btnEditar2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar2ActionPerformed(evt);
            }
        });
        pnEditar.add(btnEditar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 130, 33));

        lbRegresar3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbRegresar3.setText("Regresar");
        lbRegresar3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbRegresar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRegresar3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbRegresar3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbRegresar3MouseExited(evt);
            }
        });
        pnEditar.add(lbRegresar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, -1, -1));

        jPanel3.setEnabled(false);
        jPanel3.setFocusable(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Codigo:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jCalendar3.setDateFormatString("d/MM/yyyy hh:mm");
        jCalendar3.setEnabled(false);
        jPanel3.add(jCalendar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 190, 30));

        jLabel4.setText("Fecha:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        txtLider3.setEnabled(false);
        jPanel3.add(txtLider3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 231, 32));

        jLabel7.setText("Lider Del Proyecto:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtIdentificacion3.setEnabled(false);
        txtIdentificacion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacion3ActionPerformed(evt);
            }
        });
        jPanel3.add(txtIdentificacion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 230, 30));

        jLabel9.setText("Identificacion:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        txtCodigo3.setEnabled(false);
        txtCodigo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigo3ActionPerformed(evt);
            }
        });
        jPanel3.add(txtCodigo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 170, 30));

        pnEditar.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 670, 160));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtAcroni3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAcroni3ActionPerformed(evt);
            }
        });
        jPanel4.add(txtAcroni3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 190, 32));

        jLabel5.setText("Acronimo:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));
        jPanel4.add(txtObjetivo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 500, 30));

        jLabel6.setText("Objetivo:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        pnEditar.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 670, 140));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoUnix331.png"))); // NOI18N
        jPanel5.add(lblLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1000, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("FUNDACION UNIVERSITARIA COLOMBO INTERNACIONAL");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1000, -1));

        pnEditar.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 1000, 120));

        getContentPane().add(pnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1000, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        //MOSTRAR EL PANEL DE AGREGAR
        pnAgregar.setVisible(true);
        pnMostrarT.setVisible(false);
        pnEditar.setVisible(false);
        btnRegistrar.setVisible(true);
        //PREPARAR LOS CAMPOS DE TEXTO
        String nombre = ""; 
        List<Profesor> listProfesor = profesorDAO.buscar(Login.getClave());
        for (int i = 0; i < listProfesor.size(); i++) {
            nombre = listProfesor.get(i).getNombres();
        }  
        jCalendar2.setDate(fecha = new Date());
        txtNombreP.setText("");
        txtLiderP.setText(nombre);
        txtIdentificacion2.setText(Login.getClave());
        txtObjetivoP.setText("");
    }//GEN-LAST:event_btnAgregarActionPerformed


    private void btnVentanaProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentanaProfActionPerformed

        VentanaProfesor v = new VentanaProfesor(this, true);
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }//GEN-LAST:event_btnVentanaProfActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    TableRowSorter trs;
    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtBuscar.getText(), 0, 1, 3, 4));
            }
        });
        trs = new TableRowSorter(modelo);
        tblTabla.setRowSorter(trs);
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseEntered
        btnAgregar.setFocusable(true);
    }//GEN-LAST:event_btnAgregarMouseEntered

    private void btnAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseExited
        btnAgregar.setFocusable(false);
    }//GEN-LAST:event_btnAgregarMouseExited

    private void tblTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseClicked
        int col = tblTabla.getSelectedColumn();
        int fil = tblTabla.getSelectedRow();

        if (col == 5) {
            int op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar?");
            if (op == 0) {
                eliminar();
            }
        }
        if (col == 6) {
            //MOSTRAR EL PANEL PARA EDITAR Y OCULTAR EL RESTO
            pnMostrarT.setVisible(false);
            pnEditar.setVisible(true);
            btnEditar2.setVisible(true);
            //Llenar los campos con la informacion a editar
            codigo = Integer.parseInt( tblTabla.getValueAt(fil, 0).toString());
            ProyectoInvestigacionDAO p = new ProyectoInvestigacionDAO();
         
            String Lider = tblTabla.getValueAt(fil,2).toString();
            jCalendar3.setDate(fecha = new Date());
            txtAcroni3.setText(tblTabla.getValueAt(fil,1).toString());
            txtCodigo3.setText(Integer.toString(codigo));
            txtLider3.setText(Lider);
            txtObjetivo3.setText(tblTabla.getValueAt(fil,3).toString());
            txtIdentificacion3.setText((String) profesorDAO.consultar(Lider));
        }
        if (col == 7) {
            generarReportes();
        }
    }//GEN-LAST:event_tblTablaMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        if (txtNombreP.getText().equals("") && txtLiderP.getText().equals("")
                && txtObjetivoP.getText().equals("")) {
            txtNombreP.setText("");
            JOptionPane.showMessageDialog(this, "Los campos estan vacios");
        } else {
            AgregarProyecto();
            Listar();
            pnAgregar.setVisible(false);
            pnMostrarT.setVisible(true);
            btnEditar2.setVisible(false);
        }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar2ActionPerformed

        if(modificar() == true){
         pnAgregar.setVisible(false);
         pnMostrarT.setVisible(true);
         btnEditar2.setVisible(false);
         Listar();
        }
    }//GEN-LAST:event_btnEditar2ActionPerformed

    private void txtObjetivoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObjetivoPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObjetivoPActionPerformed

    private void lbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalirMouseClicked
  
        this.dispose();
        VentanaInicio v = new VentanaInicio();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
    }//GEN-LAST:event_lbSalirMouseClicked

    private void btnDespMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDespMouseClicked
        
    }//GEN-LAST:event_btnDespMouseClicked

    private void btnDespMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDespMouseEntered
        int posicion = btnDesp.getX();
        if(posicion > 5){
            Animacion.Animacion.mover_izquierda(250, 0, 2, 2, btnDesp);
            Animacion.Animacion.mover_izquierda(0, -250, 2, 2, pnlDesple);
        }else{
            Animacion.Animacion.mover_derecha(0, 250, 2, 2, btnDesp);
            Animacion.Animacion.mover_derecha(-250, 0, 2, 2, pnlDesple);
        }
        hora();
    }//GEN-LAST:event_btnDespMouseEntered

    private void txtAcroni3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAcroni3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAcroni3ActionPerformed

    private void lbRegresar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRegresar2MouseClicked
        pnMostrarT.setVisible(true);
        pnAgregar.setVisible(false);
        
    }//GEN-LAST:event_lbRegresar2MouseClicked

    private void lbRegresar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRegresar3MouseClicked
        pnEditar.setVisible(false);
        pnMostrarT.setVisible(true);
    }//GEN-LAST:event_lbRegresar3MouseClicked

    private void pnlDespleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDespleMouseExited

    }//GEN-LAST:event_pnlDespleMouseExited

    private void lbSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalirMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbSalirMouseEntered

    private void lbRegresar2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRegresar2MouseEntered
       lbRegresar2.setFont(new java.awt.Font("Tahoma", 0, 18)); 
    }//GEN-LAST:event_lbRegresar2MouseEntered

    private void lbRegresar2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRegresar2MouseExited
        lbRegresar2.setFont(new java.awt.Font("Tahoma", 0, 14)); 
    }//GEN-LAST:event_lbRegresar2MouseExited

    private void txtIdentificacion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacion3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacion3ActionPerformed

    private void txtCodigo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigo3ActionPerformed

    private void lbRegresar3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRegresar3MouseEntered
        lbRegresar3.setFont(new java.awt.Font("Tahoma", 0, 18));
    }//GEN-LAST:event_lbRegresar3MouseEntered

    private void lbRegresar3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRegresar3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lbRegresar3MouseExited

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        hora();
    }//GEN-LAST:event_formMouseEntered

    private void tblTablaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseEntered
        hora();
    }//GEN-LAST:event_tblTablaMouseEntered

    private void txtNombrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePActionPerformed

    private void txtNombrePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePKeyTyped
        if(txtNombreP.getText().length() >= 20){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        int key = evt.getKeyChar();
        boolean mayusculas = key >=65 && key <= 90 || key == 32;
        boolean minusculas = key >=97 && key <= 122;
        if(!(mayusculas || minusculas)){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNombrePKeyTyped

    private void txtObjetivoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObjetivoPKeyTyped
     
    }//GEN-LAST:event_txtObjetivoPKeyTyped

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        
    }//GEN-LAST:event_ComboBoxActionPerformed

    private void btnCrearGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearGruposActionPerformed
        vaciarComboBox();
        crearGrupos();
        llenarComboBox();
    }//GEN-LAST:event_btnCrearGruposActionPerformed

    private void labelCrearGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCrearGruposMouseClicked
       CrearGrupos.setVisible(true);
       CrearGrupos.setLocationRelativeTo(null);
       
    }//GEN-LAST:event_labelCrearGruposMouseClicked

    private void labelRegresarGrMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegresarGrMouseEntered
        labelRegresarGr.setFont(new java.awt.Font("Tahoma", 0, 18));
    }//GEN-LAST:event_labelRegresarGrMouseEntered

    private void labelRegresarGrMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegresarGrMouseExited
        labelRegresarGr.setFont(new java.awt.Font("Tahoma", 0, 14));
    }//GEN-LAST:event_labelRegresarGrMouseExited

    private void labelRegresarGrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegresarGrMouseClicked
        CrearGrupos.setVisible(false);
        pnAgregar.setVisible(true);
    }//GEN-LAST:event_labelRegresarGrMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
      
    }//GEN-LAST:event_txtIdKeyTyped
 
    private void LabelAgregarAlGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelAgregarAlGrupoMouseClicked
        agregarAlGrupo();
       if(LabelParticipante1.getText().equals("")){
          LabelParticipante1.setText(txtNom2.getText()); 
       }else if(!LabelParticipante1.getText().equalsIgnoreCase("") && LabelParticipante2.getText().equals("")){
            txtNom2.setText("");
            agregarAlGrupo();
             LabelParticipante2.setText(txtNom2.getText());
        }else if(!LabelParticipante1.getText().equalsIgnoreCase("") && !LabelParticipante2.getText().equalsIgnoreCase("")){
            txtNom2.setText("");
            agregarAlGrupo();
            LabelParticipante3.setText(txtNom2.getText());
        }else{
            
        }
            
        
        
    }//GEN-LAST:event_LabelAgregarAlGrupoMouseClicked

    public void llenarComboBox(){
       String sql = "SELECT id_Grupo FROM grupo";
       try {
            st = conne.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                ComboBox.addItem(Integer.toString(rs.getInt("id_Grupo")));
            }
        } catch (SQLException e) {
            System.out.println("consultar: " + e);
        } 
   }
    public void insertarIcono(JButton btn, String ruta) {
        btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ruta)));
    }
    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    public void fechas(){
        jCalendar2.setDate(fecha = new Date());
        jCalendar3.setDate(fecha = new Date());
    }
    public void ValoresPredeterminados(){
        btnRegistrar.setVisible(false);
        pnAgregar.setVisible(false);
        pnEditar.setVisible(false);
        btnVentanaProf.setVisible(false);  
    }    
    public void hora(){
         boolean d = true;
        do{
            fecha = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        lbFecha.setText(format.format(fecha)); 
        }while(1 == 2);
    }
    public void ValidacionInicio(){
//        if (l.getIdentificacion().equalsIgnoreCase("1043635986")) {
//           
//            btnAgregar.setVisible(false);
//        }
 btnVentanaProf.setVisible(true);
    }
    public void TextosEnCampos(){
       TextPrompt txt1 = new TextPrompt(" Buscar", txtBuscar);
        TextPrompt txt2 = new TextPrompt(" Nombre del proyecto", txtNombreP);
        TextPrompt txt3 = new TextPrompt(" Lider del proyecto", txtLiderP);
        TextPrompt txt4 = new TextPrompt(" Objetivo", txtObjetivoP); 
        TextPrompt txt5 = new TextPrompt(" Identificacion del usuario ", txtId); 
        TextPrompt txt6 = new TextPrompt(" Nombre del grupo ", txtNombreGrupo); 
    }
    public void vaciarComboBox(){
       ComboBox.removeAllItems();
   }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JDialog CrearGrupos;
    private javax.swing.JLabel LabelAgregarAlGrupo;
    private javax.swing.JLabel LabelParticipante1;
    private javax.swing.JLabel LabelParticipante2;
    private javax.swing.JLabel LabelParticipante3;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCrearGrupos;
    private javax.swing.JLabel btnDesp;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVentanaProf;
    private com.toedter.calendar.JDateChooser jCalendar2;
    private com.toedter.calendar.JDateChooser jCalendar3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel jlIdentificacion;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JLabel labelCrearGrupos;
    private javax.swing.JLabel labelRegresarGr;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbRegresar2;
    private javax.swing.JLabel lbRegresar3;
    private javax.swing.JLabel lbSalir;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JPanel panelAzSup;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelLog;
    private javax.swing.JPanel pnAgregar;
    private javax.swing.JPanel pnEditar;
    private javax.swing.JPanel pnMostrarT;
    private javax.swing.JPanel pnlDesple;
    private javax.swing.JPanel pnmenuSuperior;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtAcroni3;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo3;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdentificacion2;
    private javax.swing.JTextField txtIdentificacion3;
    private javax.swing.JTextField txtLider3;
    private javax.swing.JTextField txtLiderP;
    private javax.swing.JTextField txtNom2;
    private javax.swing.JTextField txtNombreGrupo;
    private javax.swing.JTextField txtNombreP;
    private javax.swing.JTextField txtObjetivo3;
    private javax.swing.JTextField txtObjetivoP;
    // End of variables declaration//GEN-END:variables
}
