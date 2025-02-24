/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Proveedor;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ProveedorService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class AbmProveedoresFrame extends javax.swing.JFrame {

    private List<Proveedor> proveedores;

    /**
     * Creates new form AbmProveedoresFrame
     */
    public AbmProveedoresFrame() {
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        initComponents();
        this.setLocationRelativeTo(null);
        alfabeticoRb.setSelected(true);
        numericoRb.setSelected(false);
        llenarTabla();
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
        tablaProveedores = new javax.swing.JTable();
        nuevoBtn = new javax.swing.JButton();
        modificarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        alfabeticoRb = new javax.swing.JRadioButton();
        numericoRb = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ABM - PROVEEDORES");

        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Razón Social"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProveedores);
        if (tablaProveedores.getColumnModel().getColumnCount() > 0) {
            tablaProveedores.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaProveedores.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        nuevoBtn.setText("Nuevo");
        nuevoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBtnActionPerformed(evt);
            }
        });

        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        alfabeticoRb.setText("Alfabético");
        alfabeticoRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alfabeticoRbActionPerformed(evt);
            }
        });

        numericoRb.setText("Numérico");
        numericoRb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numericoRbActionPerformed(evt);
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
                        .addComponent(alfabeticoRb)
                        .addGap(18, 18, 18)
                        .addComponent(numericoRb)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevoBtn)
                        .addGap(18, 18, 18)
                        .addComponent(modificarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alfabeticoRb)
                    .addComponent(numericoRb))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevoBtn)
                    .addComponent(modificarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBtnActionPerformed
        nuevo();
    }//GEN-LAST:event_nuevoBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        modificar();
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void numericoRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numericoRbActionPerformed
        numericoRb.setSelected(true);
        alfabeticoRb.setSelected(false);
        llenarTabla();
    }//GEN-LAST:event_numericoRbActionPerformed

    private void alfabeticoRbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alfabeticoRbActionPerformed
        numericoRb.setSelected(false);
        alfabeticoRb.setSelected(true);
        llenarTabla();
    }//GEN-LAST:event_alfabeticoRbActionPerformed

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
            java.util.logging.Logger.getLogger(AbmProveedoresFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AbmProveedoresFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AbmProveedoresFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AbmProveedoresFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AbmProveedoresFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton alfabeticoRb;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JButton nuevoBtn;
    private javax.swing.JRadioButton numericoRb;
    private javax.swing.JTable tablaProveedores;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        limpiarTabla();
        proveedores = null;
        try {
            if (numericoRb.isSelected()) {
                proveedores = new ProveedorService().getAllProveedoresActivosByCodigo();
            } else {
                proveedores = new ProveedorService().getAllProveedoresActivosByNombre();
            }

        } catch (Exception ex) {
            Logger.getLogger(AbmProveedoresFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (proveedores != null && !proveedores.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tablaProveedores.getModel();
            for (Proveedor pro : proveedores) {
                Object ob[] = new Object[2];
                ob[0] = pro.getCodigo();
                ob[1] = pro.getRazonSocial();
                tbl.addRow(ob);
            }
            tablaProveedores.setModel(tbl);
        }
    }

    private void nuevo() {
        NuevoProveedorFrame npf = new NuevoProveedorFrame();
        npf.setVisible(true);
        this.dispose();
    }

    private void modificar() {
        int row = tablaProveedores.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Proveedor para Modificar");
            return;
        }
        Proveedor prov = proveedores.get(row);
        ModificarProveedorFrame mpf = new ModificarProveedorFrame(prov);
        mpf.setVisible(true);
        this.dispose();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void limpiarTabla() {
        int rows = tablaProveedores.getRowCount();
        if (rows>0){
            DefaultTableModel tbl= (DefaultTableModel) tablaProveedores.getModel();
            for(int i=0;i<rows;i++){
                tbl.removeRow(0);
            }
            tablaProveedores.setModel(tbl);
        }
    }
}
