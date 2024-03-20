/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.Proveedor;
import ar.com.ventas.services.ComprobanteComprasService;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class VerComprobantesCompraImpagosByProveedorFrame extends javax.swing.JFrame {

    private List<ComprobanteCompras> facturas;
    private Proveedor proveedor;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("#0.00");
    private Integer menu;
    /**
     * Creates new form VerComprobantesCompraImpagosByProveedorFrame
     *
     * @param p
     */
    public VerComprobantesCompraImpagosByProveedorFrame(Proveedor p, Integer menu) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        this.proveedor = p;
        this.menu = menu;
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

        jLabel1 = new javax.swing.JLabel();
        proveedorTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        pagarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Proveedor:");

        proveedorTxt.setText("PROVEEDOR");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Número", "Total Comprobante", "Saldo Pendiente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        pagarBtn.setText("Pagar");
        pagarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarBtnActionPerformed(evt);
            }
        });

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(proveedorTxt))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pagarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(proveedorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(pagarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pagarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarBtnActionPerformed
        pagar();
    }//GEN-LAST:event_pagarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(VerComprobantesCompraImpagosByProveedorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerComprobantesCompraImpagosByProveedorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerComprobantesCompraImpagosByProveedorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerComprobantesCompraImpagosByProveedorFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerComprobantesCompraImpagosByProveedorFrame(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pagarBtn;
    private javax.swing.JTextField proveedorTxt;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void pagar() {
        int r = tabla.getSelectedRow();
        int rows = tabla.getSelectedRowCount();
        if (rows > 1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar solo una Fc");
            return;
        }
        if (r < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar solo una Fc");
            return;
        }
        ComprobanteCompras c = facturas.get(r);
        IngresarPagoFrame ipf = new IngresarPagoFrame(c, menu);
        ipf.setVisible(true);
        this.dispose();
    }

    private void volver() {
        CuentaCorrienteProveedorFrame ccpf = new CuentaCorrienteProveedorFrame(proveedor, menu);
        ccpf.setVisible(true);
        this.dispose();
    }

    private void llenarTabla() {
        proveedorTxt.setText(proveedor.getRazonSocial());
        facturas = null;
        try {
            facturas = new ComprobanteComprasService().getComprobantesImpagosByProveedor(proveedor);
        } catch (Exception ex) {
            Logger.getLogger(VerComprobantesCompraImpagosByProveedorFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (facturas != null) {
            limpiarTabla();
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (ComprobanteCompras co : facturas) {
                Object ob[] = new Object[4];
                ob[0] = sdf.format(co.getFechaFactura());
                String let = co.getLetra() + " ";
                String suc = "0000" + co.getNumeroSucursal().toString();
                String num = "00000000" + co.getNumeroFactura().toString();
                int ls = suc.length();
                int ln = num.length();
                String nf = let + suc.substring(ls - 4, ls) + "-" + num.substring(ln - 8, ln);
                ob[1] = nf;
                ob[2]=df.format(co.getTotal());
                ob[3]=df.format(co.getTotal()-co.getPagado());
                tbl.addRow(ob);
            }
            //tabla.setModel(tbl);
        }
    }

    private void limpiarTabla() {
        int r = tabla.getRowCount();
        if (r > 0) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (int i = 0; i < r; i++) {
                tbl.removeRow(0);
            }
            tabla.setModel(tbl);
        }
    }
}
