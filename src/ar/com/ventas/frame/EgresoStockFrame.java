/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Usuario;
import ar.com.ventas.services.ProductoService;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class EgresoStockFrame extends javax.swing.JFrame {

    private Producto producto;
    private DecimalFormat df = new DecimalFormat("#0.0");
    private Usuario u;
    private String fil;
    private Boolean xNom;

    /**
     * Creates new form EgresoStockFrame
     *
     * @param p
     * @param u
     * @param fil
     * @param xNom
     */
    public EgresoStockFrame(Producto p, Usuario u, String fil, Boolean xNom) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        this.producto = p;
        this.u = u;
        this.fil = fil;
        this.xNom = xNom;
        llenarFrame();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codigoTxt = new javax.swing.JTextField();
        descripcionTxt = new javax.swing.JTextField();
        actualTxt = new javax.swing.JTextField();
        minimoTxt = new javax.swing.JTextField();
        cantidadTxt = new javax.swing.JTextField();
        descontarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        usuarioTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DESCONTAR A STOCK");

        codigoTxt.setText("CODIGO");

        descripcionTxt.setText("DESCRIPCION");

        actualTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        actualTxt.setText("ACTUAL");

        minimoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        minimoTxt.setText("MINIMO");

        cantidadTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadTxt.setText("CANTIDAD");
        cantidadTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadTxtKeyPressed(evt);
            }
        });

        descontarBtn.setText("Descontar");
        descontarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descontarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Código:");

        jLabel2.setText("Descripción:");

        jLabel3.setText("Actual:");

        jLabel4.setText("Mínimo:");

        jLabel5.setText("Cantidad a descontar:");

        jLabel6.setText("Usuario:");

        usuarioTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuarioTxt.setText("USUARIO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcionTxt)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(actualTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(minimoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(descontarBtn)
                                                .addGap(18, 18, 18)
                                                .addComponent(volverBtn))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(108, 108, 108)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(usuarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 102, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(usuarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(descripcionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(actualTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minimoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descontarBtn)
                    .addComponent(volverBtn))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cantidadTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            descontar();
        }
    }//GEN-LAST:event_cantidadTxtKeyPressed

    private void descontarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descontarBtnActionPerformed
        descontar();
    }//GEN-LAST:event_descontarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EgresoStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EgresoStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EgresoStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EgresoStockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EgresoStockFrame(null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actualTxt;
    private javax.swing.JTextField cantidadTxt;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JButton descontarBtn;
    private javax.swing.JTextField descripcionTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField minimoTxt;
    private javax.swing.JTextField usuarioTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarFrame() {
        codigoTxt.setText(producto.getCodigo().toString());
        descripcionTxt.setText(producto.getDetalle());
        if (producto.getStock() != null) {
            actualTxt.setText(df.format(producto.getStock()));
        } else {
            actualTxt.setText(df.format(0.0));
        }
        if (producto.getStockMinimo() != null) {
            minimoTxt.setText(df.format(producto.getStockMinimo()));
        } else {
            minimoTxt.setText(df.format(0.0));
        }
        usuarioTxt.setText(u.getNombre());
        usuarioTxt.setEditable(false);
        cantidadTxt.setText("");
        cantidadTxt.requestFocus();
        actualTxt.setEditable(false);
        codigoTxt.setEditable(false);
        descripcionTxt.setEditable(false);
        minimoTxt.setEditable(false);
    }

    private void descontar() {
        if (!cantidadTxt.getText().isEmpty()) {
            Float c = Float.valueOf(cantidadTxt.getText());
            Float a = 0F;
            if (producto.getStock() != null) {
                a = producto.getStock();
            } else {
                a = 0F;
            }
            a -= c;
            int op = JOptionPane.showConfirmDialog(null, "Confirma descontar Stock?",
                    "ACTUALIZAR STOCK",
                    JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                if (a < 0) {
                    if (producto.getUnidad() != null) {
                        if (producto.getUnidad()) {
                            if (producto.getProductoCaja() != null) {
                                Producto caja = producto.getProductoCaja();
                                int can = producto.getCantidadCaja();
                                float stk1 = caja.getStock();
                                stk1 -= 1;
                                caja.setStock(stk1);
                                try {
                                    new ProductoService().updateProducto(caja);
                                } catch (Exception ex) {
                                    Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                a += can;
                            }
                        }
                    }
                }
                producto.setStock(a);
                try {
                    new ProductoService().updateProducto(producto);
                } catch (Exception ex) {
                    Logger.getLogger(EgresoStockFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Stock actualizado");
                volver();
            }
        }
    }

    private void volver() {
        AbmStockFrame mf = new AbmStockFrame(u, fil, xNom);
        mf.setVisible(true);
        this.dispose();
    }
}
