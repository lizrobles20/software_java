/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginSE;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static loginSE.principalSE.nombreUser;
/**
 *
 * @author lizir
 */

public class principalSE extends javax.swing.JFrame {
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    conexionBD cBD = new conexionBD();
    Connection con = null;
    DefaultTableModel modelo;
    perfilClinico pC = new perfilClinico();
    loginInterfaz log = new loginInterfaz();
    
    File fichero;
    public void seleccionarFoto(){
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.PNG","png","*JPG","jpg","*JPEG","jpeg");
        fc.setFileFilter(filtro);
        
        int seleccion = fc.showOpenDialog(this);
        
        if(seleccion == JFileChooser.APPROVE_OPTION){
            fichero = fc.getSelectedFile();
            String ruta = fichero.getAbsolutePath();
            
            try {
                con = cBD.Conectar();
                ps = con.prepareStatement("UPDATE usuarios SET fotoUsuario=? WHERE usuario='"+nombreUser.getText()+"'");
                FileInputStream fis = new FileInputStream(fichero);
                ps.setBinaryStream(1, fis, (int) fichero.length());
                
                int res = ps.executeUpdate();
                if (res>0){
                JOptionPane.showMessageDialog(null, "¡Éxito! Se ha guardado la foto de perfil");
                } else {
                JOptionPane.showMessageDialog(null, "Ups. Ha sucedido un error.");
                }
            } catch(Exception e){
            System.err.println(e);
            }
            
            int x = fotoUsuario.getWidth();
            int y = fotoUsuario.getHeight();
            
            fotoImagen img = new fotoImagen(x,y,ruta);
            fotoUsuario.removeAll();
            fotoUsuario.add(img);
            fotoUsuario.repaint();      
        }
    }
    
    void listar(){
        try{
         String sql = "select id_paciente, nombreP, apellidosP from datosgenerales";
         con = cBD.Conectar();
         st = con.createStatement();
         rs = st.executeQuery(sql);
         Object[]pacientes = new Object[3];
         modelo = (DefaultTableModel)tablaPacientes.getModel();
         while(rs.next()){
             pacientes[0] = rs.getInt("id_paciente");
             pacientes[1] = rs.getString("nombreP");
             pacientes[2] = rs.getString("apellidosP");
             modelo.addRow(pacientes);
         }
         tablaPacientes.setModel(modelo);
         
        }catch (Exception e){
            System.err.println(e);  
        }
    }
    /**
     * Creates new form principalSE
     */
    public principalSE() {
        initComponents();
        nombreUser.setBackground(new java.awt.Color(0,0,0,1)); 
        campoCorreo.setBackground(new java.awt.Color(0,0,0,1)); 
        tablaPacientes.getTableHeader().setFont(new Font("Roboto", Font.PLAIN, 20));
        tablaPacientes.getTableHeader().setDefaultRenderer(new HeaderColor());
        tablaPacientes.getTableHeader().setVisible(false);
        listar();
        id.setVisible(false);
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgPrincipal = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCerrarS = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        btnCerrarS2 = new javax.swing.JLabel();
        lblBienvenido = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        fotoUsuario = new javax.swing.JPanel();
        campoCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        cargarFoto = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        nombreUser = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblPacientes = new javax.swing.JLabel();
        filtrar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        bgPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        bgPrincipal.setPreferredSize(new java.awt.Dimension(1680, 900));
        bgPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(153, 204, 255));
        jLabel2.setFont(new java.awt.Font("Roboto Black", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Apellidos");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 410, 40));

        jLabel3.setBackground(new java.awt.Color(153, 204, 255));
        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Código Paciente");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1, 400, 40));

        jLabel4.setBackground(new java.awt.Color(153, 204, 255));
        jLabel4.setFont(new java.awt.Font("Roboto Black", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Nombre");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 410, 40));

        bgPrincipal.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 1240, 40));

        jPanel2.setBackground(new java.awt.Color(229, 237, 246));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrarS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSE/icon cerrar sesion.png"))); // NOI18N
        btnCerrarS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarSMouseClicked(evt);
            }
        });
        jPanel2.add(btnCerrarS, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, 50, 50));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSE/SE png.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        logo.setIconTextGap(0);
        jPanel2.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 100));

        btnCerrarS2.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        btnCerrarS2.setText("Cerrar sesión");
        btnCerrarS2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarS2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarS2MouseClicked(evt);
            }
        });
        jPanel2.add(btnCerrarS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 60, -1, 30));

        lblBienvenido.setFont(new java.awt.Font("Roboto Medium", 0, 48)); // NOI18N
        lblBienvenido.setText("Bienvenido");
        jPanel2.add(lblBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 110));

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 310, -1));

        bgPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 1320, 100));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N

        tablaPacientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaPacientes.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        tablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id_paciente", "nombreP", "apellidosP"
            }
        ));
        tablaPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaPacientes.setRowHeight(50);
        tablaPacientes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tablaPacientesMouseMoved(evt);
            }
        });
        tablaPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPacientes);

        bgPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 1240, 660));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout fotoUsuarioLayout = new javax.swing.GroupLayout(fotoUsuario);
        fotoUsuario.setLayout(fotoUsuarioLayout);
        fotoUsuarioLayout.setHorizontalGroup(
            fotoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        fotoUsuarioLayout.setVerticalGroup(
            fotoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );

        jPanel1.add(fotoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 230, 230));

        campoCorreo.setEditable(false);
        campoCorreo.setBackground(new java.awt.Color(102, 153, 255));
        campoCorreo.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        campoCorreo.setForeground(new java.awt.Color(255, 255, 255));
        campoCorreo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoCorreo.setBorder(null);
        campoCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(campoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 340, 50));

        lblCorreo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorreo.setText("Correo");
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 90, -1));

        cargarFoto.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        cargarFoto.setText("Cargar foto de perfil");
        cargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarFotoActionPerformed(evt);
            }
        });
        jPanel1.add(cargarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("Usuario");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 90, -1));

        nombreUser.setEditable(false);
        nombreUser.setBackground(new java.awt.Color(102, 153, 255));
        nombreUser.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        nombreUser.setForeground(new java.awt.Color(255, 255, 255));
        nombreUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombreUser.setBorder(null);
        nombreUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUserActionPerformed(evt);
            }
        });
        jPanel1.add(nombreUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 230, 50));

        btnCrear.setBackground(new java.awt.Color(153, 204, 255));
        btnCrear.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnCrear.setText("Crear nuevo perfil clínico");
        btnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrear.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCrearMouseMoved(evt);
            }
        });
        btnCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearMouseExited(evt);
            }
        });
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 640, -1, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenesSE/degradado-difuminado-azul-7935.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 900));

        bgPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 900));

        lblPacientes.setFont(new java.awt.Font("Roboto Medium", 0, 36)); // NOI18N
        lblPacientes.setText("Lista de pacientes");
        bgPrincipal.add(lblPacientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, -1, -1));

        filtrar.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        filtrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los pacientes", "Mis pacientes" }));
        filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarActionPerformed(evt);
            }
        });
        bgPrincipal.add(filtrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 140, 180, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(bgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        String users = nombreUser.getText();
        this.setVisible(false);
        pC.txtUsuarios.setText(users);
        pC.setVisible(true);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void nombreUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUserActionPerformed
        
    }//GEN-LAST:event_nombreUserActionPerformed

    private void btnCerrarS2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarS2MouseClicked
        this.dispose();
        new loginInterfaz().setVisible(true);
    }//GEN-LAST:event_btnCerrarS2MouseClicked

    private void btnCerrarSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarSMouseClicked
        this.dispose();
        new loginInterfaz().setVisible(true);
    }//GEN-LAST:event_btnCerrarSMouseClicked

    private void tablaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPacientesMouseClicked
        int seleccionado = tablaPacientes.rowAtPoint(evt.getPoint());
        id.setText(String.valueOf(tablaPacientes.getValueAt(seleccionado, 0)));
        this.setVisible(false);
        visualizarHistorial vh = new visualizarHistorial();
        vh.setVisible(true);
        vh.txtID.setText(id.getText());
        vh.txtUsuarios.setText(nombreUser.getText());
        try{
        String idpac = vh.txtID.getText();
        String sqli = "select id_paciente, nombreP, apellidosP, edadP, generoP, fechaNac, lugarNac, "
                + "estadoResi, municipio, colonia, calleNum, CURP, RFC, email, tel, estadoCivil, foto from datosgenerales where id_paciente='" +idpac+ "'";
         con = cBD.Conectar();
         st = con.createStatement();
         rs = st.executeQuery(sqli);
         
         BufferedImage buffimg = null;
         byte[] image = null;
         
         while(rs.next()){
             vh.txtNombreP.setText(rs.getString("nombreP"));
             vh.txtApellidos.setText(rs.getString("apellidosP"));
             vh.txtEdad.setText(rs.getString("edadP"));
             vh.cbGenero.setSelectedItem(rs.getString("generoP"));
             vh.txtFechaN.setText(rs.getString("fechaNac"));
             vh.txtLugarN.setText(rs.getString("lugarNac"));
             vh.txtEstado.setText(rs.getString("estadoResi"));
             vh.txtMunicipio.setText(rs.getString("municipio"));
             vh.txtColonia.setText(rs.getString("colonia"));
             vh.txtCalleyN.setText(rs.getString("calleNum"));
             vh.txtCURP.setText(rs.getString("CURP"));
             vh.txtRFC.setText(rs.getString("RFC"));
             vh.txtCorreo.setText(rs.getString("email"));
             vh.txtTel.setText(rs.getString("tel"));
             vh.txtEstadoC.setText(rs.getString("estadoCivil"));
             
             image = rs.getBytes("foto");
             InputStream img = rs.getBinaryStream(17);
             try {
                 buffimg = ImageIO.read(img);
                 fotoImagenMYSQL imagen = new fotoImagenMYSQL(vh.fotoPaciente.getHeight(), vh.fotoPaciente.getWidth(), buffimg);
                 vh.fotoPaciente.add(imagen);
                 vh.fotoPaciente.repaint();
             } catch(IOException ex){
                 System.err.println(ex.toString());
             }
         }
         
         String sqli2 = "select id_paciente, nombreF, apellidosF, edadF, generoF, fechaNacF, "
                    + "lugarNacF, estadoResiF, municipioF, coloniaF, calleNumF, CURPfam, RFCfam, emailFam, telFam from datoscontacto where id_paciente='" +idpac+ "'";
         st = con.createStatement();
         rs = st.executeQuery(sqli2);
         while(rs.next()){
             vh.txtNombreF.setText(rs.getString("nombreF"));
             vh.txtApellidosF.setText(rs.getString("apellidosF"));
             vh.txtEdadF.setText(rs.getString("edadF"));
             vh.cbGeneroF.setSelectedItem(rs.getString("generoF"));
             vh.txtFechaNF.setText(rs.getString("fechaNacF"));
             vh.txtLugarNF.setText(rs.getString("lugarNacF"));
             vh.txtEstadoF.setText(rs.getString("estadoResiF"));
             vh.txtMunicipioF.setText(rs.getString("municipioF"));
             vh.txtColoniaF.setText(rs.getString("coloniaF"));
             vh.txtCalleyNF.setText(rs.getString("calleNumF"));
             vh.txtCURPF.setText(rs.getString("CURPfam"));
             vh.txtRFCF.setText(rs.getString("RFCfam"));
             vh.txtCorreoF.setText(rs.getString("emailFam"));
             vh.txtTelF.setText(rs.getString("telFam"));
         }
         String sqli3 = "select motivo, analisisSangre, cambios, alergias, medAlergia, discapacidad, tipoDis from motivoconsulta where id_paciente='" +idpac+ "'";
         st = con.createStatement();
         rs = st.executeQuery(sqli3);
         while(rs.next()){
             vh.txtAreaMotivo.setText(rs.getString("motivo"));
             vh.cbAnalisis.setSelectedItem(rs.getString("analisisSangre"));
             vh.cbCambios.setSelectedItem(rs.getString("cambios"));
             vh.cbAlergia.setSelectedItem(rs.getString("alergias"));
             vh.txtAlergia.setText(rs.getString("medAlergia"));
             vh.cbDiscapacidad.setSelectedItem(rs.getString("discapacidad"));
             vh.txtDiscapacidad.setText(rs.getString("tipoDis"));
         }
         String sqli4 = "select famPM, famPMdes, famEC, famECdes, famPsico, famConductas, famRelacion, famMaltrato from historialfamiliar where id_paciente='" +idpac+ "'";
         st = con.createStatement();
         rs = st.executeQuery(sqli4);
         while(rs.next()){
             vh.cbFamPM.setSelectedItem(rs.getString("famPM"));
             vh.txtAreaFamPM.setText(rs.getString("famPMdes"));
             vh.cbFamEC.setSelectedItem(rs.getString("famEC"));
             vh.txtAreaFamEC.setText(rs.getString("famECdes"));
             vh.cbFamCP.setSelectedItem(rs.getString("famPsico"));
             vh.cbFamConductas.setSelectedItem(rs.getString("famConductas"));
             vh.cbFamRelacion.setSelectedItem(rs.getString("famRelacion"));
             vh.cbFamDaño.setSelectedItem(rs.getString("famMaltrato"));
         }
        }catch (Exception e){
            System.err.println(e);  
        }
    }//GEN-LAST:event_tablaPacientesMouseClicked

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void tablaPacientesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPacientesMouseMoved
        
    }//GEN-LAST:event_tablaPacientesMouseMoved

    private void btnCrearMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseMoved
        btnCrear.setBackground(new Color(229,237,246));
    }//GEN-LAST:event_btnCrearMouseMoved

    private void btnCrearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearMouseExited
        btnCrear.setBackground(new Color(153,204,255));
    }//GEN-LAST:event_btnCrearMouseExited

    private void cargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarFotoActionPerformed
        seleccionarFoto();
    }//GEN-LAST:event_cargarFotoActionPerformed

    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarActionPerformed
        if (filtrar.getSelectedIndex() == 1){
            int filas=tablaPacientes.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
            try{
         String sql = "select id_paciente, nombreP, apellidosP from datosgenerales where usuarioDoctor='" +nombreUser.getText()+"'";
         con = cBD.Conectar();
         st = con.createStatement();
         rs = st.executeQuery(sql);
         Object[]pacientes = new Object[3];
         modelo = (DefaultTableModel)tablaPacientes.getModel();
         while(rs.next()){
             pacientes[0] = rs.getInt("id_paciente");
             pacientes[1] = rs.getString("nombreP");
             pacientes[2] = rs.getString("apellidosP");
             modelo.addRow(pacientes);
         }
         tablaPacientes.setModel(modelo);
         
        }catch (Exception e){
            System.err.println(e);  
        }
        } else {
            int filas2=tablaPacientes.getRowCount();
            for (int i = 0;filas2>i; i++) {
                modelo.removeRow(0);
            }
            listar();
        }
    }//GEN-LAST:event_filtrarActionPerformed

    private void campoCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCorreoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principalSE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principalSE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principalSE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principalSE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principalSE().setVisible(true);
               
            }
        });
    }
     public class HeaderColor extends DefaultTableCellRenderer {

        public HeaderColor() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
           
           setBackground(new java.awt.Color(153,204,255));
//you can change the color that u want 
            return this;
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgPrincipal;
    private javax.swing.JLabel btnCerrarS;
    private javax.swing.JLabel btnCerrarS2;
    private javax.swing.JButton btnCrear;
    public static javax.swing.JTextField campoCorreo;
    private javax.swing.JButton cargarFoto;
    public javax.swing.JComboBox<String> filtrar;
    public static javax.swing.JPanel fotoUsuario;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblPacientes;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel logo;
    public static javax.swing.JTextField nombreUser;
    public javax.swing.JTable tablaPacientes;
    // End of variables declaration//GEN-END:variables
}
