/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Vendedor;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.RubroService;
import ar.com.ventas.services.VendedorService;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class AltaVendedorFrame extends javax.swing.JFrame {

    /**
     * Creates new form AltaVendedor
     */
    public AltaVendedorFrame() {
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        initComponents();
        this.setLocationRelativeTo(null);
        limpiarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        activoChk = new javax.swing.JCheckBox();
        guardarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        codigoTxt = new javax.swing.JTextField();
        nombreTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setText("Código:");

        jLabel2.setText("Nombre:");

        activoChk.setText("Activo");

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        codigoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        codigoTxt.setText("COD");
        codigoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoTxtKeyPressed(evt);
            }
        });

        nombreTxt.setText("NOMBRE");
        nombreTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreTxtKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(guardarBtn)
                                .addGap(18, 18, 18)
                                .addComponent(volverBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(activoChk)))
                        .addContainerGap(235, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nombreTxt)
                        .addGap(10, 10, 10))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activoChk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        guardar();
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void codigoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!codigoTxt.getText().isEmpty()) {
                if (!existe()) {
                    nombreTxt.requestFocus();
                }
            }
        } else {
            if (evt.getKeyCode() != 8 // back space
                    && evt.getKeyCode() != 37 //flecha izquierda
                    && evt.getKeyCode() != 39 //flecha derecha
                    && evt.getKeyCode() != 17 //Ctrl
                    && evt.getKeyCode() != 16 //Mayuscula
                    && evt.getKeyCode() != 38 //flecha arriba
                    && evt.getKeyCode() != 40 //flecha abajo
                    && evt.getKeyCode() != 67 //C
                    && evt.getKeyCode() != 20 //traba mayusculas
                    && evt.getKeyCode() != 27 //Escape
                    && evt.getKeyCode() != 86 //V
                    && evt.getKeyCode() != 36 //Inicio
                    && evt.getKeyCode() != 35 //fin
                    && evt.getKeyCode() != 155 //Insert
                    // && evt.getKeyCode() != 110  // punto decimal
                    //&& evt.getKeyCode() != 45 // Menos
                    && evt.getKeyCode() != 127) { // Suprimir
                if (!isNumeric(evt)) {
                    JOptionPane.showMessageDialog(this, "Solo números");
                    codigoTxt.setText("");
                    codigoTxt.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_codigoTxtKeyPressed

    private void nombreTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!nombreTxt.getText().isEmpty()) {
                guardar();
            }
        }
    }//GEN-LAST:event_nombreTxtKeyPressed

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
            java.util.logging.Logger.getLogger(AltaVendedorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaVendedorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaVendedorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaVendedorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaVendedorFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox activoChk;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        codigoTxt.setText("");
        nombreTxt.setText("");
        activoChk.setSelected(true);
    }

    private void guardar() {
        if (verificarCampos()) {
            int escape = JOptionPane.showConfirmDialog(null,
                    "Confirme GUARDAR vendedor",
                    "Grabar Vendedor",
                    JOptionPane.YES_NO_OPTION);
            if (escape == 0) {
                Vendedor ve = new Vendedor();
                ve.setCodigo(Integer.valueOf(codigoTxt.getText()));
                if (activoChk.isSelected()) {
                    ve.setActivo(true);
                } else {
                    ve.setActivo(false);
                }
                ve.setNombre(nombreTxt.getText());
                try {
                    new VendedorService().saveVendedor(ve);
                } catch (Exception ex) {
                    Logger.getLogger(AltaVendedorFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                limpiarCampos();
                codigoTxt.requestFocus();
            }
        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private boolean existe() {
        Vendedor vendedor = null;
        Integer codigo = Integer.valueOf(codigoTxt.getText());
        try {
            vendedor = new VendedorService().getVendedorByCodigo(codigo);
            JOptionPane.showMessageDialog(this, "Ya existe código " + vendedor.getNombre());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean verificarCampos() {
        if (existe()) {
            codigoTxt.setText("");
            codigoTxt.requestFocus();
            return false;
        }
        if (codigoTxt.getText().isEmpty()) {
            codigoTxt.requestFocus();
            return false;
        }
        if (nombreTxt.getText().isEmpty()) {
            nombreTxt.requestFocus();
            return false;
        }
        return true;
    }

    private boolean isNumeric(KeyEvent evt) {
        String cod = String.valueOf(evt.getKeyChar());
        try {
            Integer.parseInt(cod);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
