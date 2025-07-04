/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package encarguitos;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author falio
 */
public class RegistrarNotificaciones extends javax.swing.JFrame {
Conexion bd = new Conexion();
Usuario u=new Usuario();

    /**
     * Creates new form RegistrarNotificaciones
     */
    public RegistrarNotificaciones() {
        initComponents();
        try {
            if(bd.conexion.isClosed()){
                System.out.println("Noo!!!. Se cerro");
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int correoActual = Login.u.idUsuario;
        System.out.println("Correo obtenido: " + correoActual);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtSoli = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        TxtNomUs = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        BtnRegistrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescripcion = new javax.swing.JTextArea();
        BtnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(60, 140, 22));
        jLabel3.setText("Correo de Usuario");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registrar Notificación");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        TxtSoli.setForeground(new java.awt.Color(153, 153, 153));
        TxtSoli.setText("Ingrese el ID de la Solicitud");
        TxtSoli.setBorder(null);
        TxtSoli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtSoliMouseClicked(evt);
            }
        });
        jPanel1.add(TxtSoli, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 280, -1));

        jSeparator2.setForeground(new java.awt.Color(60, 140, 22));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 290, 10));

        TxtNomUs.setForeground(new java.awt.Color(153, 153, 153));
        TxtNomUs.setText("Ingresar Correo de Usuario");
        TxtNomUs.setBorder(null);
        TxtNomUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtNomUsMouseClicked(evt);
            }
        });
        TxtNomUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNomUsActionPerformed(evt);
            }
        });
        jPanel1.add(TxtNomUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 280, -1));

        jSeparator3.setForeground(new java.awt.Color(60, 140, 22));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 290, 10));

        BtnRegistrar.setBackground(new java.awt.Color(60, 140, 22));
        BtnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        BtnRegistrar.setText("Registrar");
        BtnRegistrar.setToolTipText("");
        BtnRegistrar.setBorder(null);
        BtnRegistrar.setBorderPainted(false);
        BtnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRegistrar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 100, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(60, 140, 22));
        jLabel4.setText("ID Solicitud");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(60, 140, 22));
        jLabel5.setText("Descripción");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        taDescripcion.setColumns(20);
        taDescripcion.setRows(5);
        jScrollPane1.setViewportView(taDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 290, 160));

        BtnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        BtnVolver.setContentAreaFilled(false);
        BtnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(BtnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrar plantilla .png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNomUsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtNomUsMouseClicked
        TxtNomUs.setText("");
    }//GEN-LAST:event_TxtNomUsMouseClicked

    private void TxtSoliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtSoliMouseClicked
        TxtSoli.setText("");
    }//GEN-LAST:event_TxtSoliMouseClicked

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
              
        // Validar campos vacíos
        if(TxtNomUs.getText().trim().isEmpty() || TxtNomUs.getText().equals("Ingresar Nombre de Usuario")) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre de usuario válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(TxtSoli.getText().trim().isEmpty() || TxtSoli.getText().equals("Ingrese el ID de la Solicitud")) {
            JOptionPane.showMessageDialog(this, "Ingrese un ID de solicitud válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(taDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "La descripción no puede estar vacía", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que el ID sea numérico
        int idSolicitud;
        try {
            idSolicitud = Integer.parseInt(TxtSoli.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID de solicitud debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener ID de usuario
        String nombreUsuario = TxtNomUs.getText().trim();
        int idUsuario = bd.obtenerIdUsuario(nombreUsuario);

        if(idUsuario == -1) {
            JOptionPane.showMessageDialog(this, "El usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar antes de registrar
        int confirm = JOptionPane.showConfirmDialog(this, 
            "¿Registrar esta notificación?", 
            "Confirmar", 
            JOptionPane.YES_NO_OPTION);

        if(confirm == JOptionPane.YES_OPTION) {
            Notificacion nueva = new Notificacion(0, idUsuario, idSolicitud, taDescripcion.getText().trim(), false);
            boolean exito = bd.insertarNotificacion(nueva);

            if(exito) {
                JOptionPane.showMessageDialog(this, "Notificación registrada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la notificación", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BtnRegistrarActionPerformed
    private void limpiarCampos() {
        TxtNomUs.setText("Ingresar Nombre de Usuario");
        TxtSoli.setText("Ingrese el ID de la Solicitud");
        taDescripcion.setText("");
    }
    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
        // TODO add your handling code here:
        PrincipalRepartidor PR = new PrincipalRepartidor();
        PR.u=u;
        PR.bd=bd;
        PR.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void TxtNomUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNomUsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNomUsActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarNotificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarNotificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarNotificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarNotificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarNotificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JButton BtnVolver;
    private javax.swing.JTextField TxtNomUs;
    private javax.swing.JTextField TxtSoli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea taDescripcion;
    // End of variables declaration//GEN-END:variables
}
