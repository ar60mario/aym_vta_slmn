/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Producto;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ProductoService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class A000tstprodxcbarrasFrame extends javax.swing.JFrame {

    /**
     * Creates new form A000tstprodxcbarrasFrame
     */
    public A000tstprodxcbarrasFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        limpiarCampos();
        go();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CODIGOS BARRA DUPLICADOS");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Código Barras", "Descripción", "Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(25);
        }

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(volverBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        MainFrame wmp = new MainFrame();
        wmp.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(A000tstprodxcbarrasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A000tstprodxcbarrasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A000tstprodxcbarrasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A000tstprodxcbarrasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A000tstprodxcbarrasFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarTabla() {
        int rows = tabla.getRowCount();
        if (rows > 0) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (int i = 0; i < rows; i++) {
                tbl.removeRow(0);
            }
            tabla.setModel(tbl);
        }
    }

    private void limpiarCampos() {
        limpiarTabla();
    }

    private void go() {
        List<Producto> pr = null;
        try {
            pr = new ProductoService().getAllOrderByCodigoBarras();
        } catch (Exception ex) {
            Logger.getLogger(A000tstprodxcbarrasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        int u = 0;
        Producto pr0 = null;
        Long cod0 = 0L;
        Long cod1=1L;
        if (pr != null && !pr.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Producto a : pr) {
                if (a.getCodigoBarras() != null) {
                    if (a.getCodigoBarras() > 0L) {
                        if (u == 0) {
                            cod0 = a.getCodigoBarras();
                            pr0 = a;
                            u = 1;
//                            System.out.println("SI");
                        } else {
//                            System.out.println("NO");
                            //JOptionPane.showMessageDialog(this, "EE");
                            cod1 = a.getCodigoBarras();
                            if (cod1.equals(cod0)) {
                                Object o[] = new Object[4];
                                o[0] = pr0.getCodigo();
                                o[1] = pr0.getCodigoBarras();
                                o[2] = pr0.getDetalle();
                                if (pr0.getInactivo()) {
                                    o[3] = "INACTIVO";
                                } else {
                                    o[3] = "ACTIVO";
                                }
                                tbl.addRow(o);
                                o[0] = a.getCodigo();
                                o[1] = a.getCodigoBarras();
                                o[2] = a.getDetalle();
                                if (a.getInactivo()) {
                                    o[3] = "INACTIVO";
                                } else {
                                    o[3] = "ACTIVO";
                                }
                                tbl.addRow(o);
//                                System.out.println(a.getCodigoBarras() + " " + cod1);
//                                System.out.println(pr0.getCodigoBarras());
//                                System.out.println(a.getCodigoBarras().equals(pr0.getCodigoBarras()));
//                                System.out.println("...");
                            }
                        }
//                        System.out.println(a.getCodigoBarras() + " " + cod1);
//                        System.out.println(pr0.getCodigoBarras());
//                        System.out.println(a.getCodigoBarras().equals(pr0.getCodigoBarras()));
//                        System.out.println("...");
//                        cod1 = cod0;
//                        pr0 = a;
                    }
                }
                cod0 = cod1;
                pr0 = a;
            }
            tabla.setModel(tbl);
        }
    }
}
