/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Stores;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.StoreService;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Mario
 */
public class ResumenCajaDiarioFrame extends javax.swing.JFrame {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("#0.00");
    private List<Stores> cajas = null;
    /**
     * Creates new form ResumenCajaDiarioFrame
     */
    public ResumenCajaDiarioFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
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
        desdeTxt = new javax.swing.JTextField();
        hastaTxt = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        excelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("RESUMEN CAJA DIARIO");

        jLabel1.setText("Desde:");

        jLabel2.setText("Hasta:");

        desdeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        desdeTxt.setText("desde");
        desdeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                desdeTxtKeyPressed(evt);
            }
        });

        hastaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hastaTxt.setText("hasta");
        hastaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hastaTxtKeyPressed(evt);
            }
        });

        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Total Depósito", "Diferencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        excelBtn.setText("Excel");
        excelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelBtnActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desdeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hastaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(excelBtn)
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
                    .addComponent(desdeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(hastaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarBtn)
                    .addComponent(volverBtn)
                    .addComponent(excelBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        buscar();
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void desdeTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desdeTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            desde();
        }
    }//GEN-LAST:event_desdeTxtKeyPressed

    private void hastaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hastaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            hasta();
        }
    }//GEN-LAST:event_hastaTxtKeyPressed

    private void excelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelBtnActionPerformed
        excel();
    }//GEN-LAST:event_excelBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ResumenCajaDiarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResumenCajaDiarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResumenCajaDiarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResumenCajaDiarioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResumenCajaDiarioFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarBtn;
    private javax.swing.JTextField desdeTxt;
    private javax.swing.JButton excelBtn;
    private javax.swing.JTextField hastaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void buscar() {
        llenarTabla();
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void desde() {
        if (desdeTxt.getText().isEmpty()) {
            desdeTxt.setText(sdf.format(new Date()));
            desdeTxt.requestFocus();
        } else {
            int largo = desdeTxt.getText().length();
            if (largo == 2) {
                Calendar cal = Calendar.getInstance();
                int mes = cal.get(Calendar.MONTH) + 1;
                int anio = cal.get(Calendar.YEAR);
                String an = String.valueOf(anio);
                String f = "0" + String.valueOf(mes);
                if (f.length() > 2) {
                    f = f.substring(1, 3);
                }
                f = f + "/" + an;
                desdeTxt.setText(desdeTxt.getText() + "/" + f);
                hastaTxt.requestFocus();
            } else {
                if (largo == 5) {
                    Calendar cal = Calendar.getInstance();
                    int anio = cal.get(Calendar.YEAR);
                    String an = "/" + String.valueOf(anio);
                    desdeTxt.setText(desdeTxt.getText() + an);
                    hastaTxt.requestFocus();
                } else {
                    if (largo != 10) {
                        JOptionPane.showMessageDialog(this, "Error en fecha");
                        desdeTxt.setText("");
//                          request focus mismo campo
                        desdeTxt.requestFocus();
                    } else {
                        String veinte = desdeTxt.getText().substring(6, 8);
                        if (!veinte.equals("20")) {
                            JOptionPane.showMessageDialog(this, "Error en AÑO");
//                              request focus mismo campo
                            desdeTxt.requestFocus();
                        } else {
                            hastaTxt.requestFocus();
                        }
                    }
                }
            }
        }
    }

    private void hasta() {
        if (hastaTxt.getText().isEmpty()) {
            hastaTxt.setText(sdf.format(new Date()));
            hastaTxt.requestFocus();
        } else {
            int largo = hastaTxt.getText().length();
            if (largo == 2) {
                Calendar cal = Calendar.getInstance();
                int mes = cal.get(Calendar.MONTH) + 1;
                int anio = cal.get(Calendar.YEAR);
                String an = String.valueOf(anio);
                String f = "0" + String.valueOf(mes);
                if (f.length() > 2) {
                    f = f.substring(1, 3);
                }
                f = f + "/" + an;
                hastaTxt.setText(hastaTxt.getText() + "/" + f);
                llenarTabla();
            } else {
                if (largo == 5) {
                    Calendar cal = Calendar.getInstance();
                    int anio = cal.get(Calendar.YEAR);
                    String an = "/" + String.valueOf(anio);
                    hastaTxt.setText(hastaTxt.getText() + an);
                    llenarTabla();
                } else {
                    if (largo != 10) {
                        JOptionPane.showMessageDialog(this, "Error en fecha");
                        hastaTxt.setText("");
//                          request focus mismo campo
                        hastaTxt.requestFocus();
                    } else {
                        String veinte = hastaTxt.getText().substring(6, 8);
                        if (!veinte.equals("20")) {
                            JOptionPane.showMessageDialog(this, "Error en AÑO");
//                              request focus mismo campo
                            hastaTxt.requestFocus();
                        } else {
                            llenarTabla();
                        }
                    }
                }
            }

        }
    }

    private void llenarTabla() {
        cajas = null;
        Date f1 = new Date();
        Date f2 = f1;
        try {
            f1 = sdf.parse(desdeTxt.getText());
            f2 = sdf.parse(hastaTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ResumenCajaDiarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cajas = new StoreService().getCajasEntreFechas(f1, f2);
        } catch (Exception ex) {
            Logger.getLogger(ResumenCajaDiarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(cajas!=null && !cajas.isEmpty()){
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for(Stores c:cajas){
                Object o[] = new Object[3];
                o[0]=sdf.format(c.getFecha());
                o[1]=df.format(c.getTotalDeposito());
                o[2]=df.format(c.getDiferencia());
                tbl.addRow(o);
            }
            tabla.setModel(tbl);
        }
    }

    private void limpiarCampos() {
        desdeTxt.setText("");
        hastaTxt.setText("");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -30);
        String f = sdf.format(calendar.getTime());
        desdeTxt.setText("01" + f.substring(2, 10));
        hastaTxt.setText(sdf.format(new Date()));
        limpiarTabla();
    }

    private void limpiarTabla() {
         int row = tabla.getRowCount();
        if (row > 0) {
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            for (int i = 0; i < row; i++) {
                tbl.removeRow(0);
            }
            tabla.setModel(tbl);
        }
    }

    private void excel() {
        String rutaArchivo = "c:/informes/resumen_caja_diario.xls";
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            archivo.delete();
        }
        try {
            archivo.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(VerIvaVentasPorPeriodoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableWorkbook libro = null;
        try {
            libro = Workbook.createWorkbook(archivo);
        } catch (IOException ex) {
            Logger.getLogger(VerIvaVentasPorPeriodoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        WritableSheet hoja1 = libro.createSheet("R_C_D", 0);
        try {
            hoja1.addCell(new jxl.write.Label(0, 0, "Distribuidora A&M - RESUMEN CAJA DIARIO"));
            hoja1.addCell(new jxl.write.Label(0, 1, "Fecha"));
            hoja1.addCell(new jxl.write.Label(1, 1, "Total Depósito"));
            hoja1.addCell(new jxl.write.Label(2, 1, "Diferencia"));
            DefaultTableModel tbl = (DefaultTableModel) tabla.getModel();
            int y = 2;
            int rows = tabla.getRowCount();
            for (int i = 0; i < rows - 1; i++) {
                hoja1.addCell(new jxl.write.Label(0, y, tbl.getValueAt(i, 0).toString()));
                hoja1.addCell(new jxl.write.Number(1, y, Double.valueOf(tbl.getValueAt(i, 1).toString().replace(",", "."))));
                hoja1.addCell(new jxl.write.Number(2, y, Double.valueOf(tbl.getValueAt(i, 2).toString().replace(",", "."))));
                y += 1;
            }
        } catch (WriteException ex) {
            Logger.getLogger(VerIvaVentasPorPeriodoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error configurando Excel");
        }
        try {
            libro.write();
            libro.close();
        } catch (IOException ex) {
            Logger.getLogger(VerIvaVentasPorPeriodoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 437");
        } catch (WriteException ex) {
            Logger.getLogger(VerIvaVentasPorPeriodoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error: 438");
        }
        JOptionPane.showMessageDialog(this, "Excel creado correctamente");
    }
}
