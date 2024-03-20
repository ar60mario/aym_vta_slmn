/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import java.awt.event.KeyEvent;

/**
 *
 * @author Mario
 */
public class TestComboFrame extends javax.swing.JFrame {

    /**
     * Creates new form TestComboFrame
     */
    public TestComboFrame() {
        initComponents();
        limpiarCampos();
        llenarCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salirBtn = new javax.swing.JButton();
        contenidoTxt = new javax.swing.JTextField();
        buscarTxt = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();
        textoLbl = new javax.swing.JLabel();
        comboItem = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });
        salirBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                salirBtnKeyPressed(evt);
            }
        });

        contenidoTxt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        contenidoTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contenidoTxt.setText("CONTENIDO");

        buscarTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscarTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        buscarTxt.setText("BUSCAR");
        buscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarTxtKeyPressed(evt);
            }
        });

        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        textoLbl.setText("jLabel1");

        comboItem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboItemMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                comboItemMouseReleased(evt);
            }
        });
        comboItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboItemActionPerformed(evt);
            }
        });
        comboItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboItemKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contenidoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buscarBtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(salirBtn)
                        .addGap(18, 18, 18)
                        .addComponent(textoLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarBtn))
                .addGap(18, 18, 18)
                .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(contenidoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirBtn)
                    .addComponent(textoLbl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirBtnActionPerformed

    private void buscarTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscar();
        }
    }//GEN-LAST:event_buscarTxtKeyPressed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        buscar();
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void salirBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_salirBtnKeyPressed
        System.exit(0);
    }//GEN-LAST:event_salirBtnKeyPressed

    private void comboItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboItemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int b = 1;
            int a = comboItem.getSelectedIndex()-1;
            mostrar(a,b);
        }
    }//GEN-LAST:event_comboItemKeyPressed

    private void comboItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboItemMouseReleased
        System.out.println("release");
    }//GEN-LAST:event_comboItemMouseReleased

    private void comboItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboItemMouseClicked
        System.out.println("clic");
    }//GEN-LAST:event_comboItemMouseClicked

    private void comboItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboItemActionPerformed
        System.out.println("acction performed" + evt.getModifiers());
        if (evt.getModifiers() == 16) {
            salirBtn.requestFocus();
        }
    }//GEN-LAST:event_comboItemActionPerformed

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
            java.util.logging.Logger.getLogger(TestComboFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestComboFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestComboFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestComboFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestComboFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarBtn;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JComboBox comboItem;
    private javax.swing.JTextField contenidoTxt;
    private javax.swing.JButton salirBtn;
    private javax.swing.JLabel textoLbl;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        buscarTxt.setText("");
        contenidoTxt.setText("");
        textoLbl.setText("");
    }

    private void llenarCombo() {
        comboItem.removeAllItems();
        comboItem.addItem("");
        for (int i = 0; i < 11; i++) {
            comboItem.addItem(i);
        }
    }

    private void buscar() {
        comboItem.requestFocus();
        comboItem.addFocusListener(null);
        comboItem.showPopup();
    }

    private void mostrar(int a, int b) {
        System.out.println(a);
        System.out.println(b);
        if (b == 1) {
            contenidoTxt.setText(String.valueOf(a));
            salirBtn.requestFocus();
            System.out.println("Tambien llegue aqui!!");
        }
    }
}
