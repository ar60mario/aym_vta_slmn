/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.util.LectorDeExcel;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jxl.read.biff.BiffException;

/**
 *
 * @author Marcela
 */
public class ImportarClienteFrame extends javax.swing.JFrame {
    private File archivoImportado = null;
    private List<Cliente> listaClientes = null;

    /**
     * Creates new form ImporterClienteFrame
     */
    public ImportarClienteFrame(File archivo) {
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        initComponents();
        this.archivoImportado = archivo;
        try{
            this.llenarTablaClienteImportado();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error importando los datos.\nSi esto persiste, asegurese que el archivo sea correcto.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        tablaClienteImportado = new javax.swing.JTable();
        aceptarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        tablaClienteImportado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Razón Social", "CUIT", "Calle", "Núm", "Piso", "Dto", "CP", "Localidad", "Tel", "Mail", "FP", "Ct"
            }
        ));
        jScrollPane1.setViewportView(tablaClienteImportado);
        if (tablaClienteImportado.getColumnModel().getColumnCount() > 0) {
            tablaClienteImportado.getColumnModel().getColumn(0).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(0).setPreferredWidth(20);
            tablaClienteImportado.getColumnModel().getColumn(1).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(1).setPreferredWidth(120);
            tablaClienteImportado.getColumnModel().getColumn(2).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(2).setPreferredWidth(30);
            tablaClienteImportado.getColumnModel().getColumn(3).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablaClienteImportado.getColumnModel().getColumn(4).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(4).setPreferredWidth(30);
            tablaClienteImportado.getColumnModel().getColumn(5).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(5).setPreferredWidth(30);
            tablaClienteImportado.getColumnModel().getColumn(6).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(6).setPreferredWidth(30);
            tablaClienteImportado.getColumnModel().getColumn(7).setPreferredWidth(30);
            tablaClienteImportado.getColumnModel().getColumn(8).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(8).setPreferredWidth(100);
            tablaClienteImportado.getColumnModel().getColumn(9).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(9).setPreferredWidth(100);
            tablaClienteImportado.getColumnModel().getColumn(10).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(10).setPreferredWidth(100);
            tablaClienteImportado.getColumnModel().getColumn(11).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(11).setPreferredWidth(10);
            tablaClienteImportado.getColumnModel().getColumn(12).setResizable(false);
            tablaClienteImportado.getColumnModel().getColumn(12).setPreferredWidth(10);
        }

        aceptarBtn.setText("Aceptar");
        aceptarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBtnActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(aceptarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volverBtn)
                .addGap(151, 151, 151))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarBtn)
                    .addComponent(volverBtn))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void aceptarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBtnActionPerformed
        guardarClientes();
    }//GEN-LAST:event_aceptarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ImportarClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportarClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportarClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportarClienteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportarClienteFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaClienteImportado;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarTablaClienteImportado() {
        
        try {
            listaClientes = LectorDeExcel.leerExcelCliente(archivoImportado);
        } catch (BiffException ex) {
            Logger.getLogger(ImportarClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ImportarClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaClienteImportado.getModel();
        if(listaClientes != null && !listaClientes.isEmpty()){
            for(Cliente cliente : listaClientes){
                Object[] fila = new Object[13];
                
                fila[0] = cliente.getCodigo();
                fila[1] = cliente.getRazonSocial();
                fila[2] = cliente.getCuit();
                fila[3] = cliente.getDomicilio().getCalle();
                fila[4] = cliente.getDomicilio().getNumero();
                fila[5] = cliente.getDomicilio().getPiso();
                fila[6] = cliente.getDomicilio().getDepartamento();
                fila[7] = cliente.getDomicilio().getCodigoPostal();
                fila[8] = cliente.getDomicilio().getLocalidad();
                fila[9] = cliente.getTelefono();
                fila[10] = cliente.getMail();
                fila[11] = cliente.getFormaDePago();
                fila[12] = cliente.getCategoriaDeIva();
                
                modelo.addRow(fila);
            }
            tablaClienteImportado.setModel(modelo);
        }else{
            Object[] mensaje = new Object[1];
            mensaje[1] = "No se recuperó ningún CLIENTE del archivo importado";
            modelo.addRow(mensaje);
        }
        
    }

    private void guardarClientes() {
        
        int confirm = JOptionPane.showConfirmDialog(this, "Se guardarán todos los CLIENTES listados.\n¿Confirma la operación?",
            "Confirmar", JOptionPane.OK_CANCEL_OPTION);
        if(confirm == JOptionPane.OK_OPTION){
            try{
                new ClienteService().saveListaClientes(listaClientes);
                JOptionPane.showMessageDialog(this, "Clientes guardados correctamente.");
                MainFrame mf = new MainFrame();
                mf.setVisible(true);
                this.dispose();
            }catch(Exception ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
}
