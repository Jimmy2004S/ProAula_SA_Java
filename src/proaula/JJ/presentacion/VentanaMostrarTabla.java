package proaula.JJ.presentacion;

import proaula.JJ.domain.ProyectoInvestigacion;
import proaula.JJ.domain.Login;
import config.*;
import config.render;

import java.awt.Toolkit;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import proaula.JJ.domain.Estudiante;
import proaula.JJ.domain.Grupo;
import proaula.JJ.servicios.GrupoService;
import proaula.JJ.servicios.IService;
import proaula.JJ.servicios.PersonaService;
import proaula.JJ.servicios.ProyectosService;
import proaula.JJ.servicios.IGrupoService;

public final class VentanaMostrarTabla extends javax.swing.JFrame {

    //INICIO DE SESION
    Login login = null;
    // JTABLE
    JButton btnEliminar = new JButton("");
    JButton OpcionEditar = new JButton("");
    JButton btnPdf = new JButton("");
    DefaultTableModel modelo = new DefaultTableModel();
    static Date fecha;

    public VentanaMostrarTabla() {
        initComponents();
        labelUsuario.setText(login.getUser());
        labelIdentificacion.setText(Login.getClave());
//        if(l.getIdentificacion().equalsIgnoreCase("1043635986")){
//            btnEditar.setEnabled(true);
//            btnEliminar.setEnabled(true);
//        }
        login = new Login();
        CrearGrupos.setSize(510, 470);
        insertarIcono(btnEliminar, "/imagenes/Eliminar.png");
        insertarIcono(OpcionEditar, "/imagenes/Editar.png");
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
        Object[] proyectos = new Object[8];
        ProyectosService proyectoService = new ProyectosService();
        List<ProyectoInvestigacion> listProyectos = proyectoService.listar();
        modelo = (DefaultTableModel) tblTabla.getModel();
        for (int i = 0; i < listProyectos.size(); i++) {
            proyectos[0] = listProyectos.get(i).getCodigo();
            proyectos[1] = listProyectos.get(i).getAcronimo();
            proyectos[2] = "";
            proyectos[3] = listProyectos.get(i).getDescripcion();
            proyectos[4] = listProyectos.get(i).getFechaRegistro();
            proyectos[5] = btnEliminar;
            proyectos[6] = OpcionEditar;
            proyectos[7] = btnPdf;
            modelo.addRow(proyectos);
        }
        tblTabla.setModel(modelo);
    }

    public boolean eliminar() {
        int fila = tblTabla.getSelectedRow();
        int codigo = Integer.parseInt(tblTabla.getValueAt(fila, 0).toString());
        ProyectosService proyectoService = new ProyectosService();
        if (proyectoService.eliminar(codigo)) {
            return true;
        }
        txtBuscar.setText("");
        limpiarTabla();
        Listar();
        return false;
    }

    public void generarReportes() {
    }

    public void AgregarProyecto() {
        fecha = jCalendar2.getDate();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String fech = format.format(fecha);
        int codigo_grupo = Integer.parseInt((String) ComboBox.getSelectedItem());

        ProyectosService proyectoService = new ProyectosService();
        //ENVIAR OBJETO AL METODO AGRREGAR
        ProyectoInvestigacion proyecto = new ProyectoInvestigacion();
        proyecto.setAcronimo(txtNombreP.getText());
        proyecto.setDescripcion(txtObjetivoP.getText());
        proyecto.setFechaRegistro(fech);
        proyecto.setCodigo_grupo(codigo_grupo);
        proyecto.setCodigo_lider(codigo_grupo);
        proyectoService.agregar(proyecto);
        limpiarTabla();
    }

    boolean modificar() {
        ProyectosService proyectoService = new ProyectosService();
        ProyectoInvestigacion proyecto = new ProyectoInvestigacion();
        //TOMAR DATOS 
        int fila = tblTabla.getSelectedRow();
        int codigo = Integer.parseInt(tblTabla.getValueAt(fila, 0).toString());
        fecha = jCalendar3.getDate();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String fech = format.format(fecha);
        //ENVIAR OBJETO AL METODO UPDATE

        proyecto.setCodigo(codigo);
        proyecto.setAcronimo(txtAcroni3.getText());
        proyecto.setDescripcion("");
        proyecto.setFechaRegistro(fech);
        proyecto.setCodigo_grupo(1);
        proyecto.setCodigo_lider(2);
        proyectoService.modificar(proyecto);
        return true;
    }

    public void crearGrupos() {
        IGrupoService grupoS = new GrupoService();
        String nombre = txtNombreGrupo.getText();
        grupoS.agregarGrupo(nombre);
    }

   void agregarAlGrupo(){
         
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CrearGrupos = new javax.swing.JDialog();
        panelFondo = new javax.swing.JPanel();
        btnCrearGrupos = new javax.swing.JButton();
        labelRegresarGrupo = new javax.swing.JLabel();
        panelLog = new javax.swing.JPanel();
        txtNombreGrupo = new javax.swing.JTextField();
        panelAzSup = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        txtIdentificacionPersona = new javax.swing.JTextField();
        LabelAgregarAlGrupo = new javax.swing.JLabel();
        txtNom2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPersonasGrupo = new javax.swing.JList<>();
        btnDesp = new javax.swing.JLabel();
        pnmenuSuperior = new javax.swing.JPanel();
        lbFecha = new javax.swing.JLabel();
        pnlDesple = new javax.swing.JPanel();
        lbSalir = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelIdentificacion = new javax.swing.JLabel();
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
        labelbRegresarAgregar = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox<>();
        labelCrearGrupos = new javax.swing.JLabel();
        pnEditar = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        LabelRegresarEditar = new javax.swing.JLabel();
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
        panelFondo.add(btnCrearGrupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 120, 30));

        labelRegresarGrupo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelRegresarGrupo.setText("Regresar");
        labelRegresarGrupo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelRegresarGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegresarGrupoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelRegresarGrupoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelRegresarGrupoMouseExited(evt);
            }
        });
        panelFondo.add(labelRegresarGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, -1, -1));

        panelLog.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelLog.add(txtNombreGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 230, 30));

        panelFondo.add(panelLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 460, 70));

        panelAzSup.setBackground(new java.awt.Color(39, 107, 215));
        panelFondo.add(panelAzSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 40));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdentificacionPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacionPersonaActionPerformed(evt);
            }
        });
        txtIdentificacionPersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdentificacionPersonaKeyTyped(evt);
            }
        });
        jPanel7.add(txtIdentificacionPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, 30));

        LabelAgregarAlGrupo.setText("Agregar");
        LabelAgregarAlGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelAgregarAlGrupoMouseClicked(evt);
            }
        });
        jPanel7.add(LabelAgregarAlGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        txtNom2.setEditable(false);
        jPanel7.add(txtNom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 160, 30));

        jScrollPane1.setViewportView(listPersonasGrupo);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 140, 170));

        panelFondo.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 460, 210));

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

        labelUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelUsuario.setText(".");
        pnlDesple.add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 210, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuariox96.png"))); // NOI18N
        pnlDesple.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        labelIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        labelIdentificacion.setText(".");
        pnlDesple.add(labelIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 270, 140, -1));

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
        tblTabla.setToolTipText("");
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

        pnMostrarT.add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 730, 260));

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

        labelbRegresarAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelbRegresarAgregar.setText("Regresar");
        labelbRegresarAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelbRegresarAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelbRegresarAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelbRegresarAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelbRegresarAgregarMouseExited(evt);
            }
        });
        pnAgregar.add(labelbRegresarAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, -1, -1));

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

        btnModificar.setBackground(new java.awt.Color(0, 102, 255));
        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        pnEditar.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 450, 130, 33));

        LabelRegresarEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LabelRegresarEditar.setText("Regresar");
        LabelRegresarEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LabelRegresarEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelRegresarEditarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LabelRegresarEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LabelRegresarEditarMouseExited(evt);
            }
        });
        pnEditar.add(LabelRegresarEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, -1, -1));

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
        IService personaS = new PersonaService();
        Estudiante estudiante = new Estudiante();
        estudiante.setIdentificacion(Login.getUser());
        
        String nombre = personaS.buscarEstudiante(estudiante).getNombres();
        
        jCalendar2.setDate(fecha = new Date());
        txtNombreP.setText("");
        txtLiderP.setText(nombre);
        txtIdentificacion2.setText(Login.getUser());
        txtObjetivoP.setText("");
    }//GEN-LAST:event_btnAgregarActionPerformed


    private void btnVentanaProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentanaProfActionPerformed

        VentanaAdministrarPersonas v = new VentanaAdministrarPersonas(this, true);
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
            btnModificar.setVisible(true);
            
            //Llenar los campos con la informacion a editar
            int codigo = Integer.parseInt(tblTabla.getValueAt(fil, 0).toString());
            txtAcroni3.setText(tblTabla.getValueAt(fil, 1).toString());
            String Lider = tblTabla.getValueAt(fil, 2).toString();
            txtCodigo3.setText(Integer.toString(codigo));
            txtLider3.setText(Lider);
            txtObjetivo3.setText(tblTabla.getValueAt(fil, 3).toString());
//          txtIdentificacion3.setText((String) profesorDAO.consultar(Lider));
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
            btnModificar.setVisible(false);
        }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        if (modificar() == true) {
            pnAgregar.setVisible(false);
            pnMostrarT.setVisible(true);
            btnModificar.setVisible(false);
            Listar();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

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
        if (posicion > 5) {
            Animacion.Animacion.mover_izquierda(250, 0, 2, 2, btnDesp);
            Animacion.Animacion.mover_izquierda(0, -250, 2, 2, pnlDesple);
        } else {
            Animacion.Animacion.mover_derecha(0, 250, 2, 2, btnDesp);
            Animacion.Animacion.mover_derecha(-250, 0, 2, 2, pnlDesple);
        }
        hora();
    }//GEN-LAST:event_btnDespMouseEntered

    private void txtAcroni3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAcroni3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAcroni3ActionPerformed

    private void labelbRegresarAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelbRegresarAgregarMouseClicked
        pnMostrarT.setVisible(true);
        pnAgregar.setVisible(false);

    }//GEN-LAST:event_labelbRegresarAgregarMouseClicked

    private void LabelRegresarEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelRegresarEditarMouseClicked
        pnEditar.setVisible(false);
        pnMostrarT.setVisible(true);
    }//GEN-LAST:event_LabelRegresarEditarMouseClicked

    private void pnlDespleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDespleMouseExited

    }//GEN-LAST:event_pnlDespleMouseExited

    private void lbSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalirMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lbSalirMouseEntered

    private void labelbRegresarAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelbRegresarAgregarMouseEntered
        labelbRegresarAgregar.setFont(new java.awt.Font("Tahoma", 0, 18));
    }//GEN-LAST:event_labelbRegresarAgregarMouseEntered

    private void labelbRegresarAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelbRegresarAgregarMouseExited
        labelbRegresarAgregar.setFont(new java.awt.Font("Tahoma", 0, 14));
    }//GEN-LAST:event_labelbRegresarAgregarMouseExited

    private void txtIdentificacion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacion3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacion3ActionPerformed

    private void txtCodigo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigo3ActionPerformed

    private void LabelRegresarEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelRegresarEditarMouseEntered
        LabelRegresarEditar.setFont(new java.awt.Font("Tahoma", 0, 18));
    }//GEN-LAST:event_LabelRegresarEditarMouseEntered

    private void LabelRegresarEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelRegresarEditarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelRegresarEditarMouseExited

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
        if (txtNombreP.getText().length() >= 30) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        int key = evt.getKeyChar();
        boolean mayusculas = key >= 65 && key <= 90 || key == 32;
        boolean minusculas = key >= 97 && key <= 122;
        boolean simbolos = key == 45;
        if (!(mayusculas || minusculas || simbolos)) {
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

    private void labelRegresarGrupoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegresarGrupoMouseEntered
        labelRegresarGrupo.setFont(new java.awt.Font("Tahoma", 0, 18));
    }//GEN-LAST:event_labelRegresarGrupoMouseEntered

    private void labelRegresarGrupoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegresarGrupoMouseExited
        labelRegresarGrupo.setFont(new java.awt.Font("Tahoma", 0, 14));
    }//GEN-LAST:event_labelRegresarGrupoMouseExited

    private void labelRegresarGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegresarGrupoMouseClicked
        CrearGrupos.setVisible(false);
        pnAgregar.setVisible(true);
    }//GEN-LAST:event_labelRegresarGrupoMouseClicked

    private void txtIdentificacionPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacionPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacionPersonaActionPerformed

    private void txtIdentificacionPersonaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionPersonaKeyTyped

    }//GEN-LAST:event_txtIdentificacionPersonaKeyTyped

    private void LabelAgregarAlGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelAgregarAlGrupoMouseClicked
//        agregarAlGrupo();
//       if(LabelParticipante1.getText().equals("")){
//          LabelParticipante1.setText(txtNom2.getText()); 
//       }else if(!LabelParticipante1.getText().equalsIgnoreCase("") && LabelParticipante2.getText().equals("")){
//            txtNom2.setText("");
//            agregarAlGrupo();
//             LabelParticipante2.setText(txtNom2.getText());
//        }else if(!LabelParticipante1.getText().equalsIgnoreCase("") && !LabelParticipante2.getText().equalsIgnoreCase("")){
//            txtNom2.setText("");
//            agregarAlGrupo();
//            LabelParticipante3.setText(txtNom2.getText());
//        }else{
//            
//        }


    }//GEN-LAST:event_LabelAgregarAlGrupoMouseClicked

    public void llenarComboBox(){
        IGrupoService grupoS = new GrupoService();
        List<Grupo> listGrupo = grupoS.listarGrupos();
        listGrupo.forEach((grupo) -> {
            ComboBox.addItem(Integer.toString(grupo.getCodigo()));
        });  
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

    public void fechas() {
        jCalendar2.setDate(fecha = new Date());
        jCalendar3.setDate(fecha = new Date());
    }

    public void ValoresPredeterminados() {
        btnRegistrar.setVisible(false);
        pnAgregar.setVisible(false);
        pnEditar.setVisible(false);
        btnVentanaProf.setVisible(false);
    }

    public void hora() {
        boolean d = true;
        do {
            fecha = new Date();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            lbFecha.setText(format.format(fecha));
        } while (1 == 2);
    }

    public void ValidacionInicio() {
//        if (l.getIdentificacion().equalsIgnoreCase("1043635986")) {
//           
//            btnAgregar.setVisible(false);
//        }
        btnVentanaProf.setVisible(true);
    }

    public void TextosEnCampos() {
        TextPrompt txt1 = new TextPrompt(" Buscar", txtBuscar);
        TextPrompt txt2 = new TextPrompt(" Nombre del proyecto", txtNombreP);
        TextPrompt txt3 = new TextPrompt(" Lider del proyecto", txtLiderP);
        TextPrompt txt4 = new TextPrompt(" Objetivo", txtObjetivoP);
        TextPrompt txt5 = new TextPrompt(" Identificacion del usuario ", txtIdentificacionPersona);
        TextPrompt txt6 = new TextPrompt(" Nombre del grupo ", txtNombreGrupo);
    }

    public void vaciarComboBox() {
        ComboBox.removeAllItems();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JDialog CrearGrupos;
    private javax.swing.JLabel LabelAgregarAlGrupo;
    private javax.swing.JLabel LabelRegresarEditar;
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCrearGrupos;
    private javax.swing.JLabel btnDesp;
    private javax.swing.JButton btnModificar;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCrearGrupos;
    private javax.swing.JLabel labelIdentificacion;
    private javax.swing.JLabel labelRegresarGrupo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelbRegresarAgregar;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbSalir;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JList<String> listPersonasGrupo;
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
    private javax.swing.JTextField txtIdentificacion2;
    private javax.swing.JTextField txtIdentificacion3;
    private javax.swing.JTextField txtIdentificacionPersona;
    private javax.swing.JTextField txtLider3;
    private javax.swing.JTextField txtLiderP;
    private javax.swing.JTextField txtNom2;
    private javax.swing.JTextField txtNombreGrupo;
    private javax.swing.JTextField txtNombreP;
    private javax.swing.JTextField txtObjetivo3;
    private javax.swing.JTextField txtObjetivoP;
    // End of variables declaration//GEN-END:variables
}
