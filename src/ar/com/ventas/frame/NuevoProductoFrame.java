/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.SubRubro;
import ar.com.ventas.services.ProductoService;
import ar.com.ventas.services.RubroService;
import ar.com.ventas.services.SubRubroService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcela
 */
public class NuevoProductoFrame extends javax.swing.JFrame {

    private List<Rubro> listaRubros = new ArrayList<Rubro>();
    private List<SubRubro> listaSubRubros = new ArrayList<SubRubro>();
    private String filtro;
    private Producto productoRelacionado = null;
    private List<Producto> productosRelacionados = null;

    /**
     * Creates new form NuevoProductoFrame
     */
    public NuevoProductoFrame() {
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        this.initComponents();
        this.borrarCampos();
        this.llenarComboRubro();
        this.llenarComboSubRubro();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        guardarBtn = new javax.swing.JButton();
        volerBtn = new javax.swing.JButton();
        idTxt = new javax.swing.JTextField();
        codigoBarrasTxt = new javax.swing.JTextField();
        impuestoTxt = new javax.swing.JTextField();
        nombreTxt = new javax.swing.JTextField();
        sugeridoTxt = new javax.swing.JTextField();
        precioTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboRubro = new javax.swing.JComboBox();
        comboSubRubro = new javax.swing.JComboBox();
        inactivoChk = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        unidadChk = new javax.swing.JCheckBox();
        cantidadCajaTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        codigoRelacionTxt = new javax.swing.JTextField();
        filtroTxt = new javax.swing.JTextField();
        comboCaja = new javax.swing.JComboBox<>();
        buscarPorCodigoBtn = new javax.swing.JButton();
        buscarPorFiltroBtn = new javax.swing.JButton();
        ivaCeroChk = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("NUEVO PRODUCTO");

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        volerBtn.setText("Volver");
        volerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volerBtnActionPerformed(evt);
            }
        });

        idTxt.setText("CODIGO");
        idTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTxtActionPerformed(evt);
            }
        });

        codigoBarrasTxt.setText("Codigo de Barras");
        codigoBarrasTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoBarrasTxtActionPerformed(evt);
            }
        });

        impuestoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        impuestoTxt.setText("Impuesto");

        nombreTxt.setText("DETALLE");

        sugeridoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sugeridoTxt.setText("Sugerido");

        precioTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioTxt.setText("Precio");

        jLabel1.setText("Código");

        jLabel4.setText("Impuesto");

        jLabel5.setText("Detalle:");

        jLabel6.setText("Precio");

        jLabel7.setText("Sugerido");

        jLabel9.setText("Rubro:");

        jLabel10.setText("Sub Rubro:");

        comboRubro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboRubro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboRubroActionPerformed(evt);
            }
        });

        comboSubRubro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        inactivoChk.setText("Inactivo");

        jLabel3.setText("Código de Barras:");

        jLabel8.setText("*");

        jLabel11.setText("*");

        jLabel12.setText("*");

        jLabel13.setText("*");

        jLabel14.setText("*");

        jLabel15.setText("Cantidad caja:");

        unidadChk.setText("Es Caja");
        unidadChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadChkActionPerformed(evt);
            }
        });

        cantidadCajaTxt.setText("CANT");

        jLabel2.setText("Producto Relacionado:");

        jLabel16.setText("Código:");

        jLabel17.setText("Filtro:");

        codigoRelacionTxt.setText("CODIGO-RELACION");

        filtroTxt.setText("NOMBRE");

        comboCaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCajaActionPerformed(evt);
            }
        });

        buscarPorCodigoBtn.setText("Buscar");
        buscarPorCodigoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorCodigoBtnActionPerformed(evt);
            }
        });

        buscarPorFiltroBtn.setText("Buscar");
        buscarPorFiltroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorFiltroBtnActionPerformed(evt);
            }
        });

        ivaCeroChk.setText("IVA 0%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guardarBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)
                        .addComponent(jLabel4)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel15)
                        .addComponent(jLabel2)
                        .addComponent(jLabel16)
                        .addComponent(jLabel17)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(precioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14))
                    .addComponent(codigoBarrasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(idTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(impuestoTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(sugeridoTxt, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 69, Short.MAX_VALUE)
                                    .addComponent(unidadChk))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inactivoChk)
                                    .addComponent(ivaCeroChk)))))
                    .addComponent(cantidadCajaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboCaja, javax.swing.GroupLayout.Alignment.LEADING, 0, 224, Short.MAX_VALUE)
                            .addComponent(filtroTxt, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarPorFiltroBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboSubRubro, javax.swing.GroupLayout.Alignment.LEADING, 0, 224, Short.MAX_VALUE)
                            .addComponent(comboRubro, javax.swing.GroupLayout.Alignment.LEADING, 0, 224, Short.MAX_VALUE)
                            .addComponent(volerBtn)
                            .addComponent(codigoRelacionTxt, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(buscarPorCodigoBtn))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoBarrasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel14))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(precioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(ivaCeroChk))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(impuestoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(inactivoChk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(sugeridoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unidadChk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboSubRubro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cantidadCajaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(codigoRelacionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarPorCodigoBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(filtroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarPorFiltroBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBtn)
                    .addComponent(volerBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volerBtnActionPerformed
        AbmProductoFrame abmProductoFrame = new AbmProductoFrame(filtro);
        abmProductoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volerBtnActionPerformed

    private void idTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTxtActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        this.guardar();
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void codigoBarrasTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoBarrasTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoBarrasTxtActionPerformed

    private void comboRubroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboRubroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboRubroActionPerformed

    private void unidadChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadChkActionPerformed
        if (unidadChk.isSelected()) {
            cantidadCajaTxt.setEditable(false);
            codigoRelacionTxt.setEditable(false);
            filtroTxt.setEditable(false);
        } else {
            cantidadCajaTxt.setEditable(true);
            codigoRelacionTxt.setEditable(true);
            filtroTxt.setEditable(true);
        }
        cantidadCajaTxt.setText("0");
        comboCaja.removeAllItems();
        comboCaja.addItem("");
    }//GEN-LAST:event_unidadChkActionPerformed

    private void comboCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCajaActionPerformed
        int rows = comboCaja.getItemCount();
        if (rows > 1) {
            mostrar();
        }
    }//GEN-LAST:event_comboCajaActionPerformed

    private void buscarPorCodigoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorCodigoBtnActionPerformed
        buscarPorCodigo();
    }//GEN-LAST:event_buscarPorCodigoBtnActionPerformed

    private void buscarPorFiltroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorFiltroBtnActionPerformed
        buscarPorFiltro();
    }//GEN-LAST:event_buscarPorFiltroBtnActionPerformed

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
            java.util.logging.Logger.getLogger(NuevoProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoProductoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarPorCodigoBtn;
    private javax.swing.JButton buscarPorFiltroBtn;
    private javax.swing.JTextField cantidadCajaTxt;
    private javax.swing.JTextField codigoBarrasTxt;
    private javax.swing.JTextField codigoRelacionTxt;
    private javax.swing.JComboBox<String> comboCaja;
    private javax.swing.JComboBox comboRubro;
    private javax.swing.JComboBox comboSubRubro;
    private javax.swing.JTextField filtroTxt;
    private javax.swing.JButton guardarBtn;
    private javax.swing.JTextField idTxt;
    private javax.swing.JTextField impuestoTxt;
    private javax.swing.JCheckBox inactivoChk;
    private javax.swing.JCheckBox ivaCeroChk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JTextField precioTxt;
    private javax.swing.JTextField sugeridoTxt;
    private javax.swing.JCheckBox unidadChk;
    private javax.swing.JButton volerBtn;
    // End of variables declaration//GEN-END:variables

    private void guardar() {
        if (validarCampos()) {
            Producto producto = new Producto();
            producto.setCodigo(Integer.valueOf(idTxt.getText()));
            producto.setDetalle(nombreTxt.getText());
            producto.setListaPdf(true);
            if (!codigoBarrasTxt.getText().isEmpty()) {
                producto.setCodigoBarras(Long.valueOf(codigoBarrasTxt.getText()));
            } else {
                producto.setCodigoBarras(null);
            }
            if (!impuestoTxt.getText().isEmpty()) {
                producto.setImpuesto(Float.valueOf(impuestoTxt.getText()));
            } else {
                producto.setImpuesto(Float.valueOf("0.00"));
            }
            if (!sugeridoTxt.getText().isEmpty()) {
                producto.setSugerido(Double.valueOf(sugeridoTxt.getText()));
            } else {
                producto.setSugerido(Double.valueOf("0.00"));
            }
            producto.setPrecio(Double.valueOf(precioTxt.getText()));
            if (inactivoChk.isSelected()) {
                producto.setInactivo(true);
            } else {
                producto.setInactivo(false);
            }
            if (ivaCeroChk.isSelected()) {
                producto.setIvaCero(true);
            } else {
                producto.setIvaCero(false);
            }
            if (unidadChk.isSelected()) {
                producto.setUnidad(true);
                producto.setCantidadCaja(0);
            } else {
                producto.setUnidad(false);
                int can = Integer.valueOf(cantidadCajaTxt.getText());
                producto.setCantidadCaja(can);
                producto.setProductoCaja(productoRelacionado);
            }
            System.out.println(unidadChk.isSelected());
            //System.exit(0);
            if (asignarRubro(producto)) {
                if (asignarSubRubro(producto)) {
                    try {
                        new ProductoService().guardarProducto(producto);
                        JOptionPane.showMessageDialog(this, "Producto guardado correctamente.");
                        borrarCampos();
                        llenarComboRubro();
                        llenarComboSubRubro();
                    } catch (Exception ex) {
                        //ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Ha ocurrido un error "
                                + "guardando el Producto. (Código duplicado)");
                        idTxt.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error (Sub Rubro) guardando el Producto.");
                    comboSubRubro.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error (Rubro) guardando el Producto.");
                comboRubro.requestFocus();
            }
        }
    }

    private void borrarCampos() {
        unidadChk.setSelected(true);
        if (!unidadChk.isSelected()) {
            cantidadCajaTxt.setEditable(false);
            codigoRelacionTxt.setEditable(false);
            filtroTxt.setEditable(false);
        } else {
            cantidadCajaTxt.setEditable(true);
            codigoRelacionTxt.setEditable(true);
            filtroTxt.setEditable(true);
        }
        comboRubro.removeAllItems();
        comboRubro.addItem(" ");
        comboSubRubro.removeAllItems();
        comboSubRubro.addItem(" ");
        comboCaja.removeAllItems();
        comboCaja.addItem("");
        idTxt.setText("");
        codigoBarrasTxt.setText("");
        impuestoTxt.setText("");
        sugeridoTxt.setText("");
        precioTxt.setText("");
        nombreTxt.setText("");
        inactivoChk.setSelected(false);
        cantidadCajaTxt.setText("0");
        codigoRelacionTxt.setText("");
        filtroTxt.setText("");
    }

    private void llenarComboRubro() {

        try {
            listaRubros = new RubroService().getAllRubros();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se encuentran Rubros para llenar");
        }
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboRubro.getModel();

        if (listaRubros != null && !listaRubros.isEmpty()) {
            for (Rubro rubro : listaRubros) {
                model.addElement(rubro.getNombre());
            }
            comboRubro.setModel(model);
        }
    }

    private void llenarComboSubRubro() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboSubRubro.getModel();
        try {
            listaSubRubros = new SubRubroService().getAllSubRubros();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se encuentran SubRubros para llenar");
        }
        if (listaSubRubros != null && !listaSubRubros.isEmpty()) {
            for (SubRubro subRubro : listaSubRubros) {
                model.addElement(subRubro.getDetalle());
            }
            comboSubRubro.setModel(model);
        }
    }

    private boolean validarCampos() {
        if (nombreTxt.getText().trim().length() > 39) {
            JOptionPane.showMessageDialog(this, "Largo Producto Superado - " + String.valueOf(nombreTxt.getText().trim().length()));
            return false;
        }
        if (idTxt.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Producto - Falta completar CODIGO");
            return false;
        }
        if (nombreTxt.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Producto - Falta completar NOMBRE");
            return false;
        }
        if (precioTxt.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Producto - No permitido Sin precio");
            return false;
        }
        if (comboRubro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Producto - Seleccione Rubro");
            return false;
        }
        if (comboSubRubro.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "producto - Seleccione Sub Rubro");
            return false;
        }
        if (!unidadChk.isSelected()) {
            if (codigoRelacionTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "DEBE INDICAR PRODUCTO RELACIONADO");
                codigoRelacionTxt.requestFocus();
                return false;
            }
            if (filtroTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "DEBE INDICAR PRODUCTO RELACIONADO");
                codigoRelacionTxt.requestFocus();
                return false;
            }
        }
        return true;
    }

    private boolean asignarRubro(Producto prod) {
        int itemSeleccionado = comboRubro.getSelectedIndex();
        if (itemSeleccionado >= 1) {
            prod.setRubro(listaRubros.get(itemSeleccionado - 1));
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Rubro de la lista.");
            return false;
        }
    }

    private boolean asignarSubRubro(Producto prod) {
        int itemSeleccionado = comboSubRubro.getSelectedIndex();
        if (itemSeleccionado >= 1) {
            prod.setSubRubro(listaSubRubros.get(itemSeleccionado - 1));
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un SubRubro de la lista.");
            return false;
        }
    }

    private void mostrar() {
        int row = comboCaja.getSelectedIndex();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UN PRODUCTO DE LA LISTA");
            comboCaja.requestFocus();
            return;
        }
        productoRelacionado = null;
        productoRelacionado = productosRelacionados.get(row - 1);
        codigoRelacionTxt.setText(productoRelacionado.getCodigo().toString());
        filtroTxt.setText(productoRelacionado.getDetalle());
        guardarBtn.requestFocus();
    }

    private void buscarPorCodigo() {
        if (codigoRelacionTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "INDIQUE UN CODIGO VALIDO");
            codigoRelacionTxt.requestFocus();
            return;
        }
        int codigo = Integer.valueOf(codigoRelacionTxt.getText());
        productoRelacionado = null;
        try {
            productoRelacionado = new ProductoService().getProductoByCodigo(codigo);
        } catch (Exception ex) {
            Logger.getLogger(NuevoProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (productoRelacionado != null) {
            filtroTxt.setText(productoRelacionado.getDetalle());
            guardarBtn.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "CODIGO INEXISTENTE");
            codigoRelacionTxt.requestFocus();
            return;
        }
    }

    private void buscarPorFiltro() {
        if (filtroTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "INGRESE UN DETALLE A BUSCAR");
            filtroTxt.requestFocus();
            return;
        }
        String filtro2 = filtroTxt.getText();
        productosRelacionados = null;
        try {
            productosRelacionados = new ProductoService().getProductosByFiltroActivosSinDepo(filtro2);
        } catch (Exception ex) {
            Logger.getLogger(NuevoProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        comboCaja.removeAllItems();
        comboCaja.addItem("");
        if (productosRelacionados != null && !productosRelacionados.isEmpty()) {
            for (Producto p : productosRelacionados) {
                comboCaja.addItem(p.getDetalle());
            }
        }
        comboCaja.requestFocus();
        comboCaja.addFocusListener(null);
        comboCaja.showPopup();
    }
}
