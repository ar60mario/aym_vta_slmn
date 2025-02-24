/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.entities.RenglonNotaCredito;
import ar.com.ventas.entities.Rental;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ActivityRowService;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ProductoService;
import ar.com.ventas.services.RenglonFacturaService;
import ar.com.ventas.services.RenglonNotaCreditoService;
import ar.com.ventas.services.RentalService;
import ar.com.ventas.util.UtilFrame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author argia
 */
public class SeguimientoVentaCigarrilloFrame extends javax.swing.JFrame {

    private List<Producto> productos = null;
    private List<RenglonFactura> renglones1;
    private List<ActivityRow> renglones2;
    private List<RenglonNotaCredito> renglones3;
    private List<Rental> renglones4;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    // activityrow
    // renglonNotaCredito
    // renglon nota debito
    // rental (NC)

    /**
     * Creates new form SeguimientoVentaCigarrilloFrame
     */
    public SeguimientoVentaCigarrilloFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
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
        filtroTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        deTxt = new javax.swing.JTextField();
        alTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SEGUIMIENTO VENTAS DE CIGARRILLOS POR PRODUCTO Y FECHA");

        jLabel1.setText("FILTRO PRODUCTO:");

        filtroTxt.setText("FILTRO");
        filtroTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filtroTxtKeyPressed(evt);
            }
        });

        jLabel2.setText("PRODUCTO:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        combo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboKeyPressed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DETALLE", "CANTIDAD", "FECHA", "FACTURA", "COD.CLIENTE", "CLIENTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(50);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(30);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(150);
        }

        jLabel3.setText("DESDE:");

        deTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        deTxt.setText("DE");
        deTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deTxtKeyPressed(evt);
            }
        });

        alTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        alTxt.setText("AL");
        alTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alTxtKeyPressed(evt);
            }
        });

        jLabel4.setText("HASTA:");

        volverBtn.setText("VOLVER");
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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filtroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 373, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(volverBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(filtroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(deTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(alTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(volverBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtroTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!filtroTxt.getText().isEmpty()) {
                llenarCombo();
            }
        }
    }//GEN-LAST:event_filtroTxtKeyPressed

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        if (evt.getModifiers() == 16) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                deTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_comboActionPerformed

    private void comboKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboKeyPressed
        if (evt.getKeyCode() == 10) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                deTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_comboKeyPressed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void deTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = deTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                alTxt.requestFocus();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            deTxt.setText(fe);
        }
    }//GEN-LAST:event_deTxtKeyPressed

    private void alTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_alTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            String fe = alTxt.getText();
            int largo = fe.length();
            if (largo == 10) {
                buscarMovimientos();
            } else {
                if (largo > 10) {
                    JOptionPane.showMessageDialog(this, "ERROR EN LARGO DE FECHA");
                    return;
                }
            }
            fe = UtilFrame.fecha(fe);
            alTxt.setText(fe);
        }
    }//GEN-LAST:event_alTxtKeyPressed

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
            java.util.logging.Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeguimientoVentaCigarrilloFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alTxt;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField deTxt;
    private javax.swing.JTextField filtroTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarCombo() {
        String filtro = filtroTxt.getText();
        productos = null;
        try {
            productos = new ProductoService().getAllProductosOrdenadoByNombre(filtro);
        } catch (Exception ex) {
            Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (productos != null && !productos.isEmpty()) {
            for (Producto p : productos) {
                combo.addItem(p.getDetalle());
            }
            combo.addFocusListener(null);
            combo.showPopup();
            combo.requestFocus();
        }
    }

    private void limpiarCampos() {
        filtroTxt.setText("");
        combo.removeAllItems();
        combo.addItem("");
        UtilFrame.limpiarTabla(tabla);
        deTxt.setText("");
        alTxt.setText("");
    }

    private void buscarMovimientos() {
        int row = combo.getSelectedIndex();
        if (row < 1) {
            JOptionPane.showMessageDialog(this, "SELECCIONE UN PRODUCTO");
            return;
        }
        UtilFrame.limpiarTabla(tabla);
        Date df = new Date();
        Date af = new Date();
        try {
            df = sdf.parse(deTxt.getText());
            af = sdf.parse(alTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Producto pr = productos.get(row - 1);
        // IVA_VENTAS
        renglones1 = null;
        try {
            renglones1 = new RenglonFacturaService().getRenglonesFcByFechasAndProducto(df, af, pr);
        } catch (Exception ex) {
            //Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(Level.SEVERE, null, ex);
            //esta vacio
        }
        if (renglones1 != null && !renglones1.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (RenglonFactura rf : renglones1) {
                String fc = "FC "+rf.getIvaVentas().getLetra() + " "
                        + rf.getIvaVentas().getNumeroFactura();
                Object o[] = new Object[7];
                o[0] = rf.getProducto().getCodigo();
                o[1] = rf.getProducto().getDetalle();
                o[2] = rf.getCantidad();
                o[3] = rf.getIvaVentas().getFecha();
                o[4] = fc;
                o[5] = rf.getIvaVentas().getCliente().getCodigo();
                o[6] = rf.getIvaVentas().getCliente().getRazonSocial();
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
        //ACTIVITY_ROW
        renglones2 = null;
        try {
            renglones2 = new ActivityRowService().getRowByFechaAndProducto(df, af, pr);
        } catch (Exception ex) {
            //Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(Level.SEVERE, null, ex);
            //esta vacio
        }
        if (renglones2 != null && !renglones2.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (ActivityRow rf : renglones2) {
                String codClie = rf.getActivity().getCustomer().getCodigo();
                String nombreClie;
                try {
                    Cliente cliente = new ClienteService().getClienteByCodigo(codClie);
                    nombreClie = cliente.getRazonSocial();
                } catch (Exception ex) {
                    Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(Level.SEVERE, null, ex);
                    nombreClie = "-";
                }
                String fc = "PR "+rf.getActivity().getLetra() + " "
                        + rf.getActivity().getNumeroFactura();
                Object o[] = new Object[7];
                o[0] = rf.getCodigoProducto();
                o[1] = pr.getDetalle();
                o[2] = rf.getCantidad();
                o[3] = rf.getActivity().getFecha();
                o[4] = fc;
                o[5] = codClie;
                o[6] = nombreClie;
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
        // renglonNotaCredito
        renglones3 = null;
        try {
            renglones3 = new RenglonNotaCreditoService().getRenglonesNCByFechasAndProducto(df, af, pr);
        } catch (Exception ex) {
            //Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(Level.SEVERE, null, ex);
            //esta vacio
        }
        if (renglones3 != null && !renglones3.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (RenglonNotaCredito rf : renglones3) {
                String fc = "NC "+rf.getIvaVentas().getLetra() + " "
                        + rf.getIvaVentas().getNumeroFactura();
                Object o[] = new Object[7];
                o[0] = rf.getProducto().getCodigo();
                o[1] = rf.getProducto().getDetalle();
                o[2] = rf.getCantidad();
                o[3] = rf.getIvaVentas().getFecha();
                o[4] = fc;
                o[5] = rf.getIvaVentas().getCliente().getCodigo();
                o[6] = rf.getIvaVentas().getCliente().getRazonSocial();
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
        // rental (NC)
        renglones4 = null;
        try {
            renglones4 = new RentalService().getRenglonesDevolByFechasAndProducto(df, af, pr);
        } catch (Exception ex) {
            //Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(Level.SEVERE, null, ex);
            //esta vacio
        }
        if (renglones4 != null && !renglones4.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (Rental rf : renglones4) {
                String codClie = rf.getActivity().getCustomer().getCodigo();
                String nombreClie;
                try {
                    Cliente cliente = new ClienteService().getClienteByCodigo(codClie);
                    nombreClie = cliente.getRazonSocial();
                } catch (Exception ex) {
                    Logger.getLogger(SeguimientoVentaCigarrilloFrame.class.getName()).log(Level.SEVERE, null, ex);
                    nombreClie = "-";
                }
                String fc = "DV "+rf.getActivity().getLetra() + " "
                        + rf.getActivity().getNumeroFactura();
                Object o[] = new Object[7];
                o[0] = rf.getCodigoProducto();
                o[1] = pr.getDetalle();
                o[2] = rf.getCantidad();
                o[3] = rf.getActivity().getFecha();
                o[4] = fc;
                o[5] = rf.getActivity().getCustomer().getCodigo();
                o[6] = nombreClie;
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
        
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }
}
