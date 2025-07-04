/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package encarguitos;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author falio
 */
public class RegistrarPedidoServicio extends javax.swing.JFrame {
Conexion bd = new Conexion();

    /**
     * Creates new form RegistrarPedidoServicio
     */
    public RegistrarPedidoServicio() {
        initComponents();
        
        try {
            if(bd.conexion.isClosed()){
                System.out.println("Noo!!!. Se cerro");
            }
        } catch (SQLException ex) {
            
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MostrarCmbCliente();MostrarCmbRepartidor();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbRepartidor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        taEspesificaciones = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        BtnRegistrar1 = new javax.swing.JButton();
        txtFeEn = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        BtnVolver = new javax.swing.JButton();
        cmbCliente = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(60, 140, 22));
        jLabel9.setText("Fecha de Entrega");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registrar Pedido o Servicio");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(60, 140, 22));
        jLabel4.setText("Asignar Repartidor");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(60, 140, 22));
        jLabel5.setText("Tipo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        cmbRepartidor.setBackground(new java.awt.Color(60, 140, 22));
        cmbRepartidor.setForeground(new java.awt.Color(255, 255, 255));
        cmbRepartidor.setBorder(null);
        jPanel1.add(cmbRepartidor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 290, -1));

        taEspesificaciones.setColumns(20);
        taEspesificaciones.setRows(5);
        jScrollPane1.setViewportView(taEspesificaciones);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 290, 210));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(60, 140, 22));
        jLabel7.setText("Pedido");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        cmbTipo.setBackground(new java.awt.Color(60, 140, 22));
        cmbTipo.setForeground(new java.awt.Color(255, 255, 255));
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Pedido", "Servicio", "Pedido y Servicio" }));
        cmbTipo.setBorder(null);
        jPanel1.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 290, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(60, 140, 22));
        jLabel10.setText("Fecha de Entrega");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, -1, -1));

        BtnRegistrar1.setBackground(new java.awt.Color(60, 140, 22));
        BtnRegistrar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnRegistrar1.setForeground(new java.awt.Color(255, 255, 255));
        BtnRegistrar1.setText("Registrar");
        BtnRegistrar1.setToolTipText("");
        BtnRegistrar1.setBorder(null);
        BtnRegistrar1.setBorderPainted(false);
        BtnRegistrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRegistrar1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BtnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrar1ActionPerformed(evt);
            }
        });
        jPanel1.add(BtnRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 670, 100, 30));

        txtFeEn.setForeground(new java.awt.Color(153, 153, 153));
        txtFeEn.setText("Ingresar Fecha de Entrega");
        txtFeEn.setBorder(null);
        txtFeEn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFeEnMouseClicked(evt);
            }
        });
        jPanel1.add(txtFeEn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 280, -1));

        jSeparator6.setForeground(new java.awt.Color(60, 140, 22));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 640, 290, 10));

        BtnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volver.png"))); // NOI18N
        BtnVolver.setContentAreaFilled(false);
        BtnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(BtnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        cmbCliente.setBackground(new java.awt.Color(60, 140, 22));
        cmbCliente.setForeground(new java.awt.Color(255, 255, 255));
        cmbCliente.setBorder(null);
        jPanel1.add(cmbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 290, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(60, 140, 22));
        jLabel11.setText("Asignar Cliente");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(60, 140, 22));
        jLabel12.setText("Total a Pagar");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        txtTotal.setBorder(null);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalKeyTyped(evt);
            }
        });
        jPanel1.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 280, -1));

        jSeparator7.setForeground(new java.awt.Color(60, 140, 22));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 290, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrar plantilla .png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setText("$");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFeEnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFeEnMouseClicked
        txtFeEn.setText("");
    }//GEN-LAST:event_txtFeEnMouseClicked

    private void BtnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrar1ActionPerformed
        Cliente c= new Cliente();
        Usuario u= new Usuario();
        Solicitud s = new Solicitud();
        String Espe = taEspesificaciones.getText(),feEn = txtFeEn.getText(); 

        double total = Double.parseDouble(txtTotal.getText());
        ConsultarPedidosAsignados CPA = new ConsultarPedidosAsignados();
        
        // Validar que los textos no estén vacíos
        if (Espe.isEmpty() || feEn.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Al menos una de las variables está vacía.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validar formato de la fecha
        if (!esFechaValida(feEn)) {
            JOptionPane.showMessageDialog(null, "Formato incorrecto. Usa YYYY-MM-DD.", "Error de formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que la fecha sea futura
        if (!esFechaFutura(feEn)) {
            JOptionPane.showMessageDialog(null, "La fecha ingresada debe ser posterior a hoy.", "Error de fecha", JOptionPane.ERROR_MESSAGE);
            return;
        }
        c=bd.obtenerCliente(cmbCliente.getItemAt(cmbCliente.getSelectedIndex()));
        u=bd.obtenerRepartidor(cmbRepartidor.getItemAt(cmbRepartidor.getSelectedIndex()));
        
       bd.insertarSolicitud(new Solicitud(0,u.idUsuario,c.idCliente,cmbTipo.getItemAt(cmbTipo.getSelectedIndex()),
                Espe,"",feEn,"Pendiente" ,total));
    }//GEN-LAST:event_BtnRegistrar1ActionPerformed

    private void BtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVolverActionPerformed
            ConsultarPedidosServicios v = new ConsultarPedidosServicios();
            v.bd=bd;
            v.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_BtnVolverActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyTyped
        char c = evt.getKeyChar();
    String text = txtTotal.getText();


    // Solo permitir dígitos y un punto
    if (!Character.isDigit(c) && c != '.') {
        evt.consume();
        return;
    }

    if (c == '.' && text.contains(".")) {
        evt.consume();
    }
    }//GEN-LAST:event_txtTotalKeyTyped

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
            java.util.logging.Logger.getLogger(RegistrarPedidoServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPedidoServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPedidoServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPedidoServicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarPedidoServicio().setVisible(true);
            }
        });
    }
    public static boolean esFechaValida(String fecha) {
        return fecha.matches("\\d{4}-\\d{2}-\\d{2}");
    } 
    public static boolean esFechaFutura(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.setLenient(false); // Evita interpretaciones incorrectas

        try {
            Date fechaIngresada = formato.parse(fecha); // Convierte la cadena a fecha
            Date fechaHoy = new Date(); // Obtiene la fecha actual

            return fechaIngresada.after(fechaHoy); // Devuelve true si es después de hoy
        } catch (ParseException e) {
            return false; // Si hay error en el formato, devuelve false
        }
    }
    
    public void MostrarCmbCliente(){
        ArrayList<String[]>datos =bd.mostrarClientes();
        cmbCliente.removeAllItems();
        if (datos.size() == 0) {
            cmbCliente.addItem("No hay datos disponibles");
            return;
        }
        // Recorrer los resultados y agregarlos al JComboBox
        cmbCliente.addItem("Selecciona un Cliente"); 
        for (String[] data : datos) {
            // Por ejemplo, usar el primer campo como elemento (puedes ajustarlo según la lógica necesaria)
            cmbCliente.addItem(data[1]); // data[0] es el nombre, código o lo que se necesite mostrar
        }
    }
    public void MostrarCmbRepartidor(){
        ArrayList<String[]>datos =bd.mostrarRepartidor();
        cmbRepartidor.removeAllItems();
        if (datos.size() == 0) {
            cmbRepartidor.addItem("No hay datos disponibles");
            return;
        }
        // Recorrer los resultados y agregarlos al JComboBox
        cmbRepartidor.addItem("Selecciona un Repartidor"); 
        for (String[] data : datos) {
            // Por ejemplo, usar el primer campo como elemento (puedes ajustarlo según la lógica necesaria)
            cmbRepartidor.addItem(data[1]); // data[0] es el nombre, código o lo que se necesite mostrar
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrar1;
    private javax.swing.JButton BtnVolver;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbRepartidor;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextArea taEspesificaciones;
    private javax.swing.JTextField txtFeEn;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
