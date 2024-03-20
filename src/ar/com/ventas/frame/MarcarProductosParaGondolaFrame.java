/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.SubRubro;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ProductoService;
import ar.com.ventas.services.SubRubroService;
import ar.com.ventas.util.DesktopApi;
import ar.com.ventas.util.PDFBuilder;
import ar.com.ventas.util.UtilFrame;
import com.itextpdf.text.DocumentException;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class MarcarProductosParaGondolaFrame extends javax.swing.JFrame {

    private List<SubRubro> sub_rubros;
    private List<Producto> prod1;
    private List<Producto> prod2;

    /**
     * Creates new form MarcarProductosParaGondolaFrame
     */
    public MarcarProductosParaGondolaFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        this.setLocationRelativeTo(null);
        cargarCombo();
        limpiarCampos();
        llenarTablaAbajo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        pdfBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        combo = new javax.swing.JComboBox<>();
        filtroTxt = new javax.swing.JTextField();
        agregarBtn = new javax.swing.JButton();
        quitarBtn = new javax.swing.JButton();
        vaciarTablaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        volverBtn.setText("VOLVER");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DETALLE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabla1.getColumnModel().getColumn(1).setPreferredWidth(500);
        }

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DETALLE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla2);
        if (tabla2.getColumnModel().getColumnCount() > 0) {
            tabla2.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabla2.getColumnModel().getColumn(1).setPreferredWidth(500);
        }

        jLabel1.setText("SUB-RUBRO:");

        pdfBtn.setText("PDF");
        pdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("FILTRO:");

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });

        filtroTxt.setText("FILTRO");
        filtroTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filtroTxtKeyPressed(evt);
            }
        });

        agregarBtn.setText("AGREGAR");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });

        quitarBtn.setText("QUITAR");
        quitarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarBtnActionPerformed(evt);
            }
        });

        vaciarTablaBtn.setText("VACIAR TABLA");
        vaciarTablaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaciarTablaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pdfBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(filtroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregarBtn)
                            .addComponent(quitarBtn)
                            .addComponent(vaciarTablaBtn))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(filtroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(agregarBtn))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(vaciarTablaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quitarBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(pdfBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActionPerformed
        filtroTxt.requestFocus();
    }//GEN-LAST:event_comboActionPerformed

    private void filtroTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            int row = combo.getSelectedIndex();
            if (row > 0) {
                SubRubro r = sub_rubros.get(row - 1);
                if (filtroTxt.getText().isEmpty()) {
                    prod1 = null;
                    try {
                        prod1 = new ProductoService().getAllProductosActivosBySubRubroByNombre(r);
                    } catch (Exception ex) {
                        Logger.getLogger(MarcarProductosParaGondolaFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    llenarTablaArriba();
                } else {
                    String filtro = filtroTxt.getText();
                    prod1 = null;
                    try {
                        prod1 = new ProductoService().getAllProductosActivosBySubRubroByNombreAndFiltro(r, filtro);
                    } catch (Exception ex) {
                        Logger.getLogger(MarcarProductosParaGondolaFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    llenarTablaArriba();
                }
            } else {
                if (filtroTxt.getText().isEmpty()) {
                    prod1 = null;
                    try {
                        prod1 = new ProductoService().getProductosActivosByNombre();
                    } catch (Exception ex) {
                        Logger.getLogger(MarcarProductosParaGondolaFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    llenarTablaArriba();
                } else {
                    String filtro = filtroTxt.getText();
                    prod1 = null;
                    try {
                        prod1 = new ProductoService().getAllProductosOrdenadoByNombre(filtro);
                    } catch (Exception ex) {
                        Logger.getLogger(MarcarProductosParaGondolaFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    llenarTablaArriba();
                }
            }
        }
    }//GEN-LAST:event_filtroTxtKeyPressed

    private void vaciarTablaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaciarTablaBtnActionPerformed
        int rows = tabla2.getRowCount();
        if (rows < 1) {
            return;
        }
        int a = JOptionPane.showConfirmDialog(this, "CONFIRMA VACIAR LA LISTA ABAJO",
                "Atención", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            for (int i = 0; i < rows; i++) {
                Producto p = prod2.get(i);
                p.setActualizarGondola(false);
                try {
                    new ProductoService().updateProducto(p);
                } catch (Exception ex) {
                    Logger.getLogger(MarcarProductosParaGondolaFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        llenarTablaAbajo();
    }//GEN-LAST:event_vaciarTablaBtnActionPerformed

    private void quitarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarBtnActionPerformed
        int row = tabla2.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR PRODUCTO EN TABLA ABAJO PARA QUITAR");
            return;
        }
        Producto p = prod2.get(row);
        p.setActualizarGondola(false);
        int a = JOptionPane.showConfirmDialog(this, "CONFIRMA QUITAR DE LISTA",
                "Atención", JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            try {
                new ProductoService().updateProducto(p);

            } catch (Exception ex) {
                Logger.getLogger(MarcarProductosParaGondolaFrame.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        llenarTablaAbajo();
    }//GEN-LAST:event_quitarBtnActionPerformed

    private void pdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfBtnActionPerformed
        int count = tabla2.getRowCount();
        if (count > 0) {
            pdf();
        }
    }//GEN-LAST:event_pdfBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        int rowCount = tabla1.getSelectedRowCount();
        if(rowCount < 1){
            JOptionPane.showMessageDialog(this, "SELECCIONE LOS PRODUCTOS QUE DESEA AGREGAR ABAJO");
            return;
        }
        agregarAbajo(rowCount);
    }//GEN-LAST:event_agregarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MarcarProductosParaGondolaFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarcarProductosParaGondolaFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarcarProductosParaGondolaFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarcarProductosParaGondolaFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarcarProductosParaGondolaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JTextField filtroTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pdfBtn;
    private javax.swing.JButton quitarBtn;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla2;
    private javax.swing.JButton vaciarTablaBtn;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        filtroTxt.setText("");
    }

    private void cargarCombo() {
        combo.removeAllItems();
        combo.addItem("TODOS");
        sub_rubros = null;
        try {
            sub_rubros = new SubRubroService().getAllSubRubros();

        } catch (Exception ex) {
            Logger.getLogger(MarcarProductosParaGondolaFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        if (sub_rubros != null && !sub_rubros.isEmpty()) {
            for (SubRubro sb : sub_rubros) {
                combo.addItem(sb.getDetalle());
            }
        }
    }

    private void llenarTablaAbajo() {
        UtilFrame.limpiarTabla(tabla2);
        prod2 = null;
        try {
            prod2 = new ProductoService().getProductosParaGondola();

        } catch (Exception ex) {
            Logger.getLogger(MarcarProductosParaGondolaFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        if (prod2 != null && !prod2.isEmpty()) {
            DefaultTableModel tbl2 = (DefaultTableModel) tabla2.getModel();
            for (Producto p : prod2) {
                Object o[] = new Object[2];
                o[0] = p.getCodigo();
                o[1] = p.getDetalle();
                tbl2.addRow(o);
            }
            tabla2.setModel(tbl2);
        }
    }

    private void pdf() {
        try {
            File pdf = PDFBuilder.armarEtiquetas(prod2);
            DesktopApi.open(pdf);
            JOptionPane.showMessageDialog(this, "LO ENCUENTRA EN C:/INFORMES/ETIQUETAS_GONDOLA Y FECHA");
        } catch (DocumentException ex) {
            Logger.getLogger(MarcarProductosParaGondolaFrame.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            Logger.getLogger(MarcarProductosParaGondolaFrame.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void llenarTablaArriba() {
        UtilFrame.limpiarTabla(tabla1);
        if (prod1 != null && !prod1.isEmpty()) {
            DefaultTableModel tbl1 = (DefaultTableModel) tabla1.getModel();
            for (Producto p : prod1) {
                Object o[] = new Object[2];
                o[0] = p.getCodigo();
                o[1] = p.getDetalle();
                tbl1.addRow(o);
            }
            tabla1.setModel(tbl1);
        }
    }

    private void agregarAbajo(int rowCount) {
        int rows[] = tabla1.getSelectedRows();
        for (int x = 0; x < rowCount; x++) {
            Producto p = prod1.get(rows[x]);
            p.setActualizarGondola(true);
            try {
                new ProductoService().updateProducto(p);
            } catch (Exception ex) {
                Logger.getLogger(MarcarProductosParaGondolaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        llenarTablaAbajo();
    }
}
