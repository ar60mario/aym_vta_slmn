/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Producto;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ProductoService;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Supervisor
 */
public class ModificarPrecioProductoFrame extends javax.swing.JFrame {

    List<Producto> listadoProducto = null;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private DefaultTableModel tbl = null;
    private String filtro = "";
    private DecimalFormat df = new DecimalFormat("#0.00");

    /**
     * Creates new form AbmProductoFrame
     */
    public ModificarPrecioProductoFrame(String filtro) {
        getContentPane().setBackground(new java.awt.Color(0, 139, 139));
        initComponents();
        this.filtro = filtro;
        limpiarCampos();
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

        volverBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        modificarBtn = new javax.swing.JButton();
        productoTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        productoBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        codigoProductoTxt = new javax.swing.JTextField();
        buscarPorCodigoBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        precioTxt = new javax.swing.JTextField();
        impuestoTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        sugeridoTxt = new javax.swing.JTextField();
        grabarBtn = new javax.swing.JButton();
        marcarParaGondolaBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Codigo de barra", "Detalle", "Precio", "Impuesto", "Rubro", "Sub rubro", "Sugerido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);
        if (tablaProductos.getColumnModel().getColumnCount() > 0) {
            tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tablaProductos.getColumnModel().getColumn(2).setPreferredWidth(200);
            tablaProductos.getColumnModel().getColumn(3).setResizable(false);
            tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(75);
            tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(75);
            tablaProductos.getColumnModel().getColumn(5).setPreferredWidth(50);
            tablaProductos.getColumnModel().getColumn(6).setPreferredWidth(50);
            tablaProductos.getColumnModel().getColumn(7).setPreferredWidth(50);
        }

        modificarBtn.setText("Modificar");
        modificarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBtnActionPerformed(evt);
            }
        });

        productoTxt.setText("PRODUCTO");
        productoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                productoTxtKeyPressed(evt);
            }
        });

        jLabel1.setText("Producto:");

        productoBtn.setText("Buscar");
        productoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Código:");

        codigoProductoTxt.setText("CODIGO PRODUCTO");
        codigoProductoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoProductoTxtKeyPressed(evt);
            }
        });

        buscarPorCodigoBtn.setText("Buscar x Código");
        buscarPorCodigoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorCodigoBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Precio:");

        jLabel4.setText("Impuesto:");

        precioTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioTxt.setText("PRECIO");
        precioTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioTxtKeyPressed(evt);
            }
        });

        impuestoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        impuestoTxt.setText("IMPUE");
        impuestoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                impuestoTxtKeyPressed(evt);
            }
        });

        jLabel5.setText("Sugerido:");

        sugeridoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sugeridoTxt.setText("SUGERID");
        sugeridoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sugeridoTxtKeyPressed(evt);
            }
        });

        grabarBtn.setText("Grabar");
        grabarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarBtnActionPerformed(evt);
            }
        });

        marcarParaGondolaBtn.setText("Marcar Para Góndola");
        marcarParaGondolaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcarParaGondolaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(impuestoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sugeridoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modificarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(marcarParaGondolaBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(grabarBtn)
                        .addGap(18, 18, 18)
                        .addComponent(volverBtn)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(productoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productoBtn)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigoProductoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarPorCodigoBtn)
                .addContainerGap(192, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(productoBtn)
                    .addComponent(jLabel2)
                    .addComponent(codigoProductoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarPorCodigoBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(modificarBtn)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(precioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(impuestoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(sugeridoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grabarBtn)
                    .addComponent(marcarParaGondolaBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        this.dispose();
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }//GEN-LAST:event_volverBtnActionPerformed

    private void modificarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBtnActionPerformed
        Producto producto = this.productoSeleccionado();
        int lin = tablaProductos.getSelectedRow();
        if (lin < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto para cambiar su precio");
            tablaProductos.requestFocus();
            return;
        }
        filtro = productoTxt.getText();
        if (producto != null) {
            Double precio = Double.valueOf(precioTxt.getText());
            Float impuesto = Float.valueOf(impuestoTxt.getText());
            Double sugerido = Double.valueOf(sugeridoTxt.getText());
            producto.setPrecio(precio);
            producto.setImpuesto(impuesto);
            producto.setSugerido(sugerido);
            tablaProductos.setValueAt(df.format(precio), lin, 3);
            tablaProductos.setValueAt(df.format(impuesto), lin, 4);
            tablaProductos.setValueAt(df.format(sugerido), lin, 7);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un producto para continuar");
        }
    }//GEN-LAST:event_modificarBtnActionPerformed

    private void productoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoBtnActionPerformed
        borrarTabla();
        this.llenarTabla();
    }//GEN-LAST:event_productoBtnActionPerformed

    private void productoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productoTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            borrarTabla();
            this.llenarTabla();
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                MainFrame mf = new MainFrame();
                mf.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_productoTxtKeyPressed

    private void buscarPorCodigoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorCodigoBtnActionPerformed
        if (!codigoProductoTxt.getText().isEmpty()) {
            Producto prod = null;
            try {
                prod = new ProductoService().getProductoByCodigo(Integer.valueOf(codigoProductoTxt.getText()));
            } catch (Exception ex) {
                Logger.getLogger(ModificarPrecioProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (prod != null) {
                borrarTabla();
                listadoProducto.add(prod);
                tbl = (DefaultTableModel) tablaProductos.getModel();
                Object ob[] = new Object[8];
                ob[0] = prod.getCodigo();
                ob[1] = prod.getCodigoBarras();
                ob[2] = prod.getDetalle();
                ob[3] = df.format(prod.getPrecio());
                ob[4] = df.format(prod.getImpuesto());
                ob[5] = prod.getRubro().getNombre();
                ob[6] = prod.getSubRubro().getDetalle();
                ob[7] = df.format(prod.getSugerido());
                tbl.addRow(ob);
                tablaProductos.setModel(tbl);
            } else {
                JOptionPane.showMessageDialog(this, "Código Inexistente");
                codigoProductoTxt.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar un Código de Producto");
        }
    }//GEN-LAST:event_buscarPorCodigoBtnActionPerformed

    private void codigoProductoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoProductoTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!codigoProductoTxt.getText().isEmpty()) {
                Producto prod = null;
                try {
                    prod = new ProductoService().getProductoByCodigo(Integer.valueOf(codigoProductoTxt.getText()));
                } catch (Exception ex) {
                    Logger.getLogger(ModificarPrecioProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (prod != null) {
                    borrarTabla();
                    listadoProducto.add(prod);
                    tbl = (DefaultTableModel) tablaProductos.getModel();
                    Object ob[] = new Object[8];
                    ob[0] = prod.getCodigo();
                    ob[1] = prod.getCodigoBarras();
                    ob[2] = prod.getDetalle();
                    ob[3] = df.format(prod.getPrecio());
                    ob[4] = df.format(prod.getImpuesto());
                    ob[5] = prod.getRubro().getNombre();
                    ob[6] = prod.getSubRubro().getDetalle();
                    ob[7] = df.format(prod.getSugerido());
                    tbl.addRow(ob);
                    tablaProductos.setModel(tbl);
                } else {
                    JOptionPane.showMessageDialog(this, "Código Inexistente");
                    codigoProductoTxt.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debe ingresar un Código de Producto");
            }
        }
    }//GEN-LAST:event_codigoProductoTxtKeyPressed

    private void grabarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarBtnActionPerformed
        grabar();
    }//GEN-LAST:event_grabarBtnActionPerformed

    private void precioTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (precioTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un precio o Cero");
                precioTxt.requestFocus();
            } else {
                impuestoTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_precioTxtKeyPressed

    private void impuestoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_impuestoTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (impuestoTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un Impuesto o Cero");
                impuestoTxt.requestFocus();
            } else {
                sugeridoTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_impuestoTxtKeyPressed

    private void sugeridoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sugeridoTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (sugeridoTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un precio Sugerido o Cero");
                sugeridoTxt.requestFocus();
            } else {
                
            }
        }
    }//GEN-LAST:event_sugeridoTxtKeyPressed

    private void marcarParaGondolaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcarParaGondolaBtnActionPerformed
        marcarParaGondola();
    }//GEN-LAST:event_marcarParaGondolaBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarPrecioProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarPrecioProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarPrecioProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarPrecioProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarPrecioProductoFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarPorCodigoBtn;
    private javax.swing.JTextField codigoProductoTxt;
    private javax.swing.JButton grabarBtn;
    private javax.swing.JTextField impuestoTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton marcarParaGondolaBtn;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JTextField precioTxt;
    private javax.swing.JButton productoBtn;
    private javax.swing.JTextField productoTxt;
    private javax.swing.JTextField sugeridoTxt;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void llenarTabla() {
        this.filtro = productoTxt.getText();
        try {
            ProductoService productoService = new ProductoService();
            listadoProducto = productoService.getProductosByFiltroActivos(filtro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "error con la base de datos");
        }
        tbl = (DefaultTableModel) tablaProductos.getModel();
        if (listadoProducto != null && !listadoProducto.isEmpty()) {
            for (Producto producto : listadoProducto) { // Recorro la lista de productos y lleno la tabla.
                Object[] fila = new Object[8];
                fila[0] = producto.getCodigo();
                fila[1] = producto.getCodigoBarras();
                fila[2] = producto.getDetalle();
                fila[3] = df.format(producto.getPrecio());
                fila[4] = df.format(producto.getImpuesto());
                fila[5] = producto.getRubro().getCodigo();
                fila[6] = producto.getSubRubro().getCodigo();
                fila[7] = df.format(producto.getSugerido());
                tbl.addRow(fila); // Agrego la fila a la tabla
            }
        }
        tablaProductos.setModel(tbl); // Pongo la tabla visible.
    }

    private Producto productoSeleccionado() {
        Producto producto = null;
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada != -1 && listadoProducto != null && !listadoProducto.isEmpty()) {
            producto = listadoProducto.get(filaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Producto de la lista");
        }
        return producto;
    }
    
    private Producto getProductoSeleccionado() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            Producto producto = listadoProducto.get(filaSeleccionada);
            return producto;
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un Producto de la lista.");
        }
        return null;
    }

    private void limpiarCampos() {
        productoTxt.setText(this.filtro);
        codigoProductoTxt.setText("");
        precioTxt.setText("");
        impuestoTxt.setText("");
        sugeridoTxt.setText("");
    }

    private void borrarTabla() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
            int filas = tablaProductos.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
                Producto prod = listadoProducto.get(0);
                listadoProducto.remove(prod);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    private void grabar() {
        if (tablaProductos.getRowCount() > 0) {
            for (Producto prod:listadoProducto) {
                try {
                    new ProductoService().updateProducto(prod);
                } catch (Exception ex) {
                    Logger.getLogger(ModificarPrecioProductoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        borrarTabla();
        limpiarCampos();
        productoTxt.requestFocus();
    }

    private void marcarParaGondola() {
        
    }
}
