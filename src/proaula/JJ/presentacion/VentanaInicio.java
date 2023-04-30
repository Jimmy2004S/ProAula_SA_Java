
package proaula.JJ.presentacion;

import proaula.JJ.domain.Login;
import proaula.JJ.manejoDatos.LoginDAO;
import config.TextPrompt;
import javax.swing.JOptionPane;
import proaula.JJ.domain.Estudiante;
import proaula.JJ.manejoDatos.ILogin;
import proaula.JJ.servicios.ILoginService;
import proaula.JJ.servicios.IService;
import proaula.JJ.servicios.LoginService;
import proaula.JJ.servicios.PersonaService;

public class VentanaInicio extends javax.swing.JFrame {
    
    public VentanaInicio() {
        initComponents();
        TextPrompt txt1 = new TextPrompt("Nombre de Usuario", txtUser);
        TextPrompt txt2 = new TextPrompt("Identificacion", txtContraseña);
        TextPrompt txt3 = new TextPrompt("Correo", txtCorreoFrom);
        TextPrompt txt4 = new TextPrompt("Asunto", txtAsunto);
        TextPrompt txt5 = new TextPrompt("Descripcion", txtContent);
        pnAyuda.setVisible(false);
        pnRegistrarse.setVisible(false);
        
    }

    public void validar(){
        String user = txtUser.getText();
        String contra = txtContraseña.getText();
        if(user.equals("") ||  contra.equals("")){
            JOptionPane.showMessageDialog(null, "Llene los campos");
        } else {
            Login login = new Login();
            ILoginService loginS = new LoginService();
            login = loginS.validar(user, contra);
            if(Login.getClave() != null && Login.getClave() != null){
                VentanaMostrarTabla v = new VentanaMostrarTabla();
                v.setVisible(true);
                v.setLocationRelativeTo(null);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
            }
        }
    }
    
    public void registrar (){
        IService SEstudiante = new PersonaService();
        Estudiante estudiante = new Estudiante();
        estudiante.setNombres(txtNombre.getText());
        estudiante.setApellidos(txtApellido.getText());
        estudiante.setIdentificacion(txtIdentificacion.getText());
        estudiante.setSemestre(txtSemestre.getText());
        estudiante.setCorreo(txtCorreo2.getText());
        estudiante.setClave(txtIdentificacion.getText());
        SEstudiante.agregarEstudiante(estudiante);   
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnLogin = new javax.swing.JPanel();
        btnEntrar = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        labelImagen = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        rbMostrarCon = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelLogo = new javax.swing.JLabel();
        labelLogox = new javax.swing.JLabel();
        labelProblemas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        pnAyuda = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        txtCorreoFrom = new javax.swing.JTextField();
        txtAsunto = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        labelRegresarProb = new javax.swing.JLabel();
        pnRegistrarse = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lbIdentificacion = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCorreo2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        lbApellido = new javax.swing.JLabel();
        txtSemestre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnLogin.setBackground(new java.awt.Color(255, 255, 255));
        pnLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEntrar.setBackground(new java.awt.Color(0, 90, 169));
        btnEntrar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("INICIAR");
        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEntrar.setFocusPainted(false);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        pnLogin.add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 150, 50));

        txtUser.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtUser.setFocusable(false);
        txtUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtUserMouseExited(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        pnLogin.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 310, 40));
        pnLogin.add(labelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, -1, -1));

        txtContraseña.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txtContraseña.setFocusable(false);
        txtContraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtContraseñaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtContraseñaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtContraseñaMouseExited(evt);
            }
        });
        pnLogin.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 310, 40));

        rbMostrarCon.setBackground(new java.awt.Color(255, 255, 255));
        rbMostrarCon.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rbMostrarCon.setText("Mostrar contraseña");
        rbMostrarCon.setFocusable(false);
        rbMostrarCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rbMostrarConMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rbMostrarConMouseExited(evt);
            }
        });
        rbMostrarCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMostrarConActionPerformed(evt);
            }
        });
        pnLogin.add(rbMostrarCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 210, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/image (2).png"))); // NOI18N
        pnLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 450, 300));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario48.png"))); // NOI18N
        pnLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 50, 40));

        labelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoUnix331.png"))); // NOI18N

        labelLogox.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        labelLogox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelLogox.setText("FUNDACION UNIVERSITARIA COLOMBO INTERNACIONAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelLogox, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(labelLogo)
                    .addGap(5, 5, 5)
                    .addComponent(labelLogox)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnLogin.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 1020, 120));

        labelProblemas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelProblemas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelProblemas.setText("¿Problemas para iniciar?");
        labelProblemas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelProblemas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelProblemasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelProblemasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelProblemasMouseExited(evt);
            }
        });
        pnLogin.add(labelProblemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 150, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/llavex25.png"))); // NOI18N
        pnLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 30, -1));

        btnRegistrar.setBackground(new java.awt.Color(255, 51, 51));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrarse");
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnLogin.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 500, 90, 30));

        getContentPane().add(pnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnAyuda.setBackground(new java.awt.Color(255, 255, 255));
        pnAyuda.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(39, 107, 215));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("PORTAL DE AYUDA Y SOPORTE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel4)
                .addContainerGap(608, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnAyuda.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1030, 80));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtContent.setColumns(20);
        txtContent.setRows(5);
        txtContent.setBorder(null);
        jScrollPane1.setViewportView(txtContent);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 380, 160));
        jPanel4.add(txtCorreoFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 310, 40));
        jPanel4.add(txtAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 310, 40));

        jPanel6.setBackground(new java.awt.Color(39, 107, 215));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enviar");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel5)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, -1, -1));

        pnAyuda.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 490, 400));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        pnAyuda.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 1020, 90));

        labelRegresarProb.setText("Regresar");
        labelRegresarProb.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelRegresarProb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegresarProbMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelRegresarProbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelRegresarProbMouseExited(evt);
            }
        });
        pnAyuda.add(labelRegresarProb, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 590, -1, -1));

        getContentPane().add(pnAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 730));

        jPanel7.setEnabled(false);
        jPanel7.setFocusable(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIdentificacion.setText("Identificacion");
        jPanel7.add(lbIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel7.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 231, 32));

        jLabel8.setText("Nombre");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, -1));

        txtCorreo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreo2ActionPerformed(evt);
            }
        });
        jPanel7.add(txtCorreo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 230, 30));

        jLabel9.setText("Semestre");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, -1));

        txtIdentificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentificacionActionPerformed(evt);
            }
        });
        jPanel7.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 170, 30));

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel7.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 230, 30));

        lbApellido.setText("apellid");
        jPanel7.add(lbApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txtSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSemestreActionPerformed(evt);
            }
        });
        jPanel7.add(txtSemestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 230, 30));

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnRegistrarseLayout = new javax.swing.GroupLayout(pnRegistrarse);
        pnRegistrarse.setLayout(pnRegistrarseLayout);
        pnRegistrarseLayout.setHorizontalGroup(
            pnRegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRegistrarseLayout.createSequentialGroup()
                .addGroup(pnRegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnRegistrarseLayout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnRegistrarseLayout.createSequentialGroup()
                        .addGap(428, 428, 428)
                        .addComponent(jButton2)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        pnRegistrarseLayout.setVerticalGroup(
            pnRegistrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnRegistrarseLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButton2)
                .addContainerGap(249, Short.MAX_VALUE))
        );

        getContentPane().add(pnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed

        validar();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void rbMostrarConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMostrarConActionPerformed
     
        if(rbMostrarCon.isSelected()){
            txtContraseña.setEchoChar((char)0);
        }else{
            txtContraseña.setEchoChar('*');
        }
    }//GEN-LAST:event_rbMostrarConActionPerformed

    private void txtUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseEntered
       txtUser.setFocusable(true);
    }//GEN-LAST:event_txtUserMouseEntered

    private void txtUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserMouseExited

    }//GEN-LAST:event_txtUserMouseExited

    private void txtContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaMouseClicked

    private void txtContraseñaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMouseEntered
        txtContraseña.setFocusable(true);
    }//GEN-LAST:event_txtContraseñaMouseEntered

    private void txtContraseñaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraseñaMouseExited
         
    }//GEN-LAST:event_txtContraseñaMouseExited

    private void rbMostrarConMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbMostrarConMouseEntered
        rbMostrarCon.setFocusable(true);
        txtContraseña.setEchoChar((char)0);
    }//GEN-LAST:event_rbMostrarConMouseEntered

    private void rbMostrarConMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbMostrarConMouseExited
        if(!rbMostrarCon.isSelected()){
            txtContraseña.setEchoChar('*');
        }rbMostrarCon.setFocusable(false);
    }//GEN-LAST:event_rbMostrarConMouseExited

    private void txtUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyReleased
    
    }//GEN-LAST:event_txtUserKeyReleased

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
 
    }//GEN-LAST:event_txtUserKeyTyped

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
 
    }//GEN-LAST:event_txtUserKeyPressed

    private void labelProblemasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelProblemasMouseClicked
        pnLogin.setVisible(false);
        pnAyuda.setVisible(true);
    }//GEN-LAST:event_labelProblemasMouseClicked

    private void labelRegresarProbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegresarProbMouseClicked
       pnLogin.setVisible(true);
       pnAyuda.setVisible(false);
              
    }//GEN-LAST:event_labelRegresarProbMouseClicked

    private void labelProblemasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelProblemasMouseEntered
       labelProblemas.setFont(new java.awt.Font("Tahoma", 0, 14));
    }//GEN-LAST:event_labelProblemasMouseEntered

    private void labelProblemasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelProblemasMouseExited
       labelProblemas.setFont(new java.awt.Font("Tahoma", 0, 12));
    }//GEN-LAST:event_labelProblemasMouseExited

    private void labelRegresarProbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegresarProbMouseEntered
        labelRegresarProb.setFont(new java.awt.Font("Tahoma", 0, 18));
    }//GEN-LAST:event_labelRegresarProbMouseEntered

    private void labelRegresarProbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegresarProbMouseExited
        labelRegresarProb.setFont(new java.awt.Font("Tahoma", 0, 14));
    }//GEN-LAST:event_labelRegresarProbMouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        pnAyuda.setVisible(false);
        pnLogin.setVisible(false);
        pnRegistrarse.setVisible(true);
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtCorreo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreo2ActionPerformed

    private void txtIdentificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentificacionActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSemestreActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       registrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelLogox;
    private javax.swing.JLabel labelProblemas;
    private javax.swing.JLabel labelRegresarProb;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbIdentificacion;
    private javax.swing.JPanel pnAyuda;
    private javax.swing.JPanel pnLogin;
    private javax.swing.JPanel pnRegistrarse;
    private javax.swing.JRadioButton rbMostrarCon;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtAsunto;
    private javax.swing.JTextArea txtContent;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtCorreo2;
    private javax.swing.JTextField txtCorreoFrom;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSemestre;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
