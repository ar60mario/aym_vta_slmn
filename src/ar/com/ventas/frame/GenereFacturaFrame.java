/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.bo.IvaVentasBO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.CtaCteCliente;
import ar.com.ventas.entities.CuentaCorriente;
import ar.com.ventas.entities.FcReserved;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.entities.RenglonFcReserved;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.CtaCteClienteService;
import ar.com.ventas.services.FacturaService;
import ar.com.ventas.services.FcReservedService;
import ar.com.ventas.services.IvaVentasService;
import ar.com.ventas.services.ProductoService;
import ar.com.ventas.services.RenglonFacturaService;
import ar.com.ventas.services.RenglonFcReservedService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import static java.lang.Math.rint;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class GenereFacturaFrame extends javax.swing.JFrame {

    public List<RenglonFactura> renglonFactura = new ArrayList<RenglonFactura>();
    private String textoFacturaPapel;
    private String fechaFacturaPapel;
    private String clienteFacturaPapel;
    private String codigoClienteFacturaPapel;
    private String direccionFacturaPapel;
    private String cuitFacturaPapel;
    private String condicionVentaFacturaPapel;
    private String vencimientoFacturaPapel;
    private String inscripcionClienteFacturaPapel;
    private String nombresColumnaFacturaPapel;
    private String[] renglones = null;
    private String texto1FacturaPapel;
    private String texto2FacturaPapel;
    private String texto3FacturaPapel;
    private String totalDeudaFacturaPapel;
    private String lineaTotalesFacturaPapel;
    private String totalPagarFacturaPapel;
    private String importeTotalFacturaPapel;
    private String cantidadesFacturaPapel;
    private Date fecha;
    private SimpleDateFormat sdf;
    private Cliente clienteFactura = null;
    private Producto producto = null;
    private DefaultTableModel tabla = null;
    private Double totalFactura = 0.00;
    private Double totalImpuesto = 0.00;
    private Double totalIva = 0.00;
    private Double totalGravado = 0.00;
    private Double totalNoGravado = 0.0;
    private Double gravado = 0.00;
    private Double noGravado = 0.00;
    private Double iva = 0.00;
    private Float porcentualIva;
    private Double impuesto = null;
    private Double totalLinea = 0.00;
    private Boolean tieneDto = false;
    private Cliente clienteSeleccionado;
    private Producto productoSeleccionado;
    private Float cantidad;
    private Integer categoriaIva = 1;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat df1 = new DecimalFormat("#0");
    private Double saldoCliente = 0.00;
    private String filtro = "";
    private String letraFactura;
    private Integer sucursalFactura;
    private Integer numeroFactura;
    private Configuracion config = null;
    private Double precioFinal = 0.0;
    private Integer nro = 0;
    private Integer maxNro = 41;
    private Integer cantidadAtadosMassalin;
    private Integer cantidadAtadosNobleza;
    public Boolean encontrado;
    private FcReserved reserved;
    private List<RenglonFcReserved> rfr = null;

    /**
     * Creates new form FacturaFrame
     */
    public GenereFacturaFrame(FcReserved reserved) {
        //getContentPane().setBackground(new java.awt.Color(135, 206, 235));
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        initComponents();
        this.setLocationRelativeTo(null);
        this.reserved = reserved;
        limpiarCampos();
        bloquearCampos();
//      levanto el modelo creado del frame
        tabla = (DefaultTableModel) tablaFactura.getModel();
        cargarDatos();
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
        tablaFactura = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigoTxt = new javax.swing.JTextField();
        razonSocialTxt = new javax.swing.JTextField();
        fechaTxt = new javax.swing.JTextField();
        ivaTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        totalTxt = new javax.swing.JTextField();
        terminarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        descuentoGlobalLbl = new javax.swing.JLabel();
        descuentoGlobalTxt = new javax.swing.JTextField();
        descuentoBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        descuentoVolumenTxt = new javax.swing.JTextField();
        texto1PieFacturaTxt = new javax.swing.JTextField();
        texto2PieFacturaTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cantidadAtadosMassalinTxt = new javax.swing.JTextField();
        cantidadAtadosNoblezaTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cantidadItemsTxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        importeMassalinTxt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        importeNoblezaTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("A Y M . FACTURA");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cant", "Detalle", "P.Unit", "Gravado", "Impuesto", "IVA", "dto.", "SubTotal", "Sug."
            }
        ));
        jScrollPane1.setViewportView(tablaFactura);
        if (tablaFactura.getColumnModel().getColumnCount() > 0) {
            tablaFactura.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaFactura.getColumnModel().getColumn(1).setPreferredWidth(10);
            tablaFactura.getColumnModel().getColumn(2).setPreferredWidth(330);
            tablaFactura.getColumnModel().getColumn(3).setPreferredWidth(20);
            tablaFactura.getColumnModel().getColumn(4).setPreferredWidth(25);
            tablaFactura.getColumnModel().getColumn(5).setPreferredWidth(25);
            tablaFactura.getColumnModel().getColumn(6).setPreferredWidth(25);
            tablaFactura.getColumnModel().getColumn(7).setPreferredWidth(20);
            tablaFactura.getColumnModel().getColumn(8).setPreferredWidth(30);
            tablaFactura.getColumnModel().getColumn(9).setPreferredWidth(20);
        }

        jLabel1.setText("Cliente:");

        jLabel2.setText("Iva:");

        jLabel4.setText("Fecha:");

        codigoTxt.setText("CODIGO");
        codigoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoTxtKeyPressed(evt);
            }
        });

        razonSocialTxt.setText("RAZON SOCIAL");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        fechaTxt.setText("FECHA");

        ivaTxt.setText("IVA");

        jLabel8.setText("TOTAL FACTURA:");

        totalTxt.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        totalTxt.setForeground(new java.awt.Color(204, 0, 0));
        totalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTxt.setText("TOTAL");

        terminarBtn.setText("Generar");
        terminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Volver");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        descuentoGlobalLbl.setText("Descuento:");

        descuentoGlobalTxt.setText("DESCUENTO");

        descuentoBtn.setText("Dto");

        jLabel12.setText("Descuento");

        descuentoVolumenTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoVolumenTxt.setText("DESCEUNTO");

        texto1PieFacturaTxt.setText("TEXTO 1 PIE FACTURA");

        texto2PieFacturaTxt.setText("TEXTO 2 PIE FACTURA");

        jLabel15.setText("Massalin:");

        jLabel17.setText("Nobleza:");

        cantidadAtadosMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadAtadosMassalinTxt.setText("Cant.Mass.");

        cantidadAtadosNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadAtadosNoblezaTxt.setText("Cant.Nobl.");

        jLabel18.setText("Cant. Items:");

        cantidadItemsTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadItemsTxt.setText("Cantidad Items");

        jLabel19.setText("Importe:");

        importeMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeMassalinTxt.setText("IMP.MASS.");

        jLabel20.setText("Importe:");

        importeNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeNoblezaTxt.setText("IMP.NOBL.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 844, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(razonSocialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(descuentoGlobalLbl)
                        .addGap(18, 18, 18)
                        .addComponent(descuentoGlobalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texto1PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texto2PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(importeMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(importeNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(descuentoBtn)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel12)
                                            .addGap(18, 18, 18)
                                            .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(11, 11, 11))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelarBtn)
                .addGap(29, 29, 29)
                .addComponent(terminarBtn)
                .addGap(93, 93, 93))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(razonSocialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descuentoGlobalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descuentoGlobalLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descuentoBtn)
                    .addComponent(jLabel12)
                    .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto1PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto2PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(importeMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(importeNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBtn)
                    .addComponent(terminarBtn))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar la factura?", "Atencion", JOptionPane.YES_NO_OPTION);
        // 0 = si; 1 = no
        if (escape == 0) {
            VerReservorioFrame vrf = new VerReservorioFrame();
            vrf.setVisible(true);
            this.dispose();
        } else {
            terminarBtn.setEnabled(true);
            tablaFactura.setEnabled(true);
            //nombreProductoConsultaTxt.setEnabled(false);
        }
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void terminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Quiere ingresar un texto antes de Imprimir?",
                "Texto en el pie de Pedido",
                JOptionPane.YES_NO_OPTION);
        if (escape == 0) {
            texto1PieFacturaTxt.setEnabled(true);
            texto2PieFacturaTxt.setEnabled(true);
            texto1PieFacturaTxt.requestFocus();
        } else {
            terminarFactura();
        }
    }//GEN-LAST:event_terminarBtnActionPerformed

    private void codigoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!codigoTxt.getText().isEmpty()) {
                buscar();
                cancelarBtn.setEnabled(true);
            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                FacturarFrame ff = new FacturarFrame();
                ff.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_codigoTxtKeyPressed

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
            java.util.logging.Logger.getLogger(GenereFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenereFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenereFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenereFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenereFacturaFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField cantidadAtadosMassalinTxt;
    private javax.swing.JTextField cantidadAtadosNoblezaTxt;
    private javax.swing.JTextField cantidadItemsTxt;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JButton descuentoBtn;
    private javax.swing.JLabel descuentoGlobalLbl;
    private javax.swing.JTextField descuentoGlobalTxt;
    private javax.swing.JTextField descuentoVolumenTxt;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JTextField importeMassalinTxt;
    private javax.swing.JTextField importeNoblezaTxt;
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField razonSocialTxt;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JButton terminarBtn;
    private javax.swing.JTextField texto1PieFacturaTxt;
    private javax.swing.JTextField texto2PieFacturaTxt;
    private javax.swing.JTextField totalTxt;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        texto1PieFacturaTxt.setText("");
        texto2PieFacturaTxt.setText("");
        cantidadAtadosMassalinTxt.setText("");
        cantidadAtadosNoblezaTxt.setText("");
        ivaTxt.setText("");
        codigoTxt.setText("");
        fechaTxt.setText("");
        razonSocialTxt.setText("");
        totalTxt.setText("");
        totalTxt.setText("0.00");
        descuentoVolumenTxt.setText("0.00");
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        cantidadItemsTxt.setText("");
        descuentoGlobalTxt.setText("");
        importeMassalinTxt.setText("");
        importeNoblezaTxt.setText("");
        importeMassalinTxt.setEditable(false);
        importeNoblezaTxt.setEditable(false);
    }

    private void bloquearCampos() {
        cancelarBtn.setEnabled(false);
        terminarBtn.setEnabled(false);
        descuentoBtn.setEnabled(false);
        ivaTxt.setEditable(false);
        codigoTxt.setEnabled(true);
        codigoTxt.setEditable(true);
        fechaTxt.setEditable(false);
        razonSocialTxt.setEditable(false);
        totalTxt.setEnabled(false);
        descuentoVolumenTxt.setEnabled(false);
        cantidadItemsTxt.setEnabled(false);
        texto1PieFacturaTxt.setEnabled(false);
        texto2PieFacturaTxt.setEnabled(false);
        cantidadAtadosMassalinTxt.setEditable(false);
        cantidadAtadosNoblezaTxt.setEditable(false);
        descuentoGlobalTxt.setEditable(false);
    }

    private void buscar() {
        filtro = "";
        Long id = (long) 1;
        try {
            Configuracion conf = new ConfiguracionService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(GenereFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha = Calendar.getInstance().getTime();
        Cliente cli = new Cliente();
        categoriaIva = 4;
        try {
            clienteFactura = new ClienteService().getClienteByCodigo(codigoTxt.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - cliente");
            Logger.getLogger(GenereFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clienteFactura != null) {
            razonSocialTxt.setText(clienteFactura.getRazonSocial());
            fechaTxt.setText(sdf.format(fecha));
            if (clienteFactura.getCategoriaDeIva() != null) {
                if (clienteFactura.getCategoriaDeIva() == 1) {
                    ivaTxt.setText("Resp. Inscripto");
                }
                if (clienteFactura.getCategoriaDeIva() == 2) {
                    ivaTxt.setText("Monotributo");
                }
                if (clienteFactura.getCategoriaDeIva() == 4) {
                    ivaTxt.setText("Consumidor Final");
                }
                categoriaIva = clienteFactura.getCategoriaDeIva();
            } else {
                ivaTxt.setText("Consumidor Final");
            }
            if (clienteFactura.getSaldo() != null) {
                saldoCliente = clienteFactura.getSaldo();
            } else {
                saldoCliente = 0.0;
            }
            cancelarBtn.setEnabled(true);
            terminarBtn.setEnabled(true);
            codigoTxt.setEditable(false);
            descuentoVolumenTxt.setEnabled(true);
            descuentoVolumenTxt.setEditable(false);
            totalTxt.setEnabled(true);
            totalTxt.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(this, "Error - cliente no existe");
            codigoTxt.requestFocus();
        }
    }

    private void terminarFactura() {
        Integer categoriaIva = 0;
        IvaVentas ivaVentas = new IvaVentas();
        categoriaIva = clienteFactura.getCategoriaDeIva();
        saldoCliente = clienteFactura.getSaldo();
        saldoCliente += totalFactura;
        clienteFactura.setSaldo(saldoCliente);
        try {
            new ClienteService().updateCliente(clienteFactura);
        } catch (Exception ex) {
            Logger.getLogger(GenereFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long id = (long) 1;
        try {
            config = new ConfiguracionService().getFacturas(id);
        } catch (Exception ex) {
            Logger.getLogger(GenereFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        config.setUltimaFechaSistema(fecha);
        if (categoriaIva.equals(1)) {
            letraFactura = "A";
            // es inscriptp
            sucursalFactura = config.getSucursalA();
            numeroFactura = config.getNumeroFacturaA();
            numeroFactura += 1;
            config.setNumeroFacturaA(numeroFactura);
            try {
                new ConfiguracionService().updateConfiguracion(config);
            } catch (Exception ex) {
                Logger.getLogger(GenereFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            letraFactura = "B";
            // el resto de las categorias
            sucursalFactura = config.getSucursalB();
            numeroFactura = config.getNumeroFacturaB();
            numeroFactura += 1;
            config.setNumeroFacturaB(numeroFactura);
            try {
                new ConfiguracionService().updateConfiguracion(config);
            } catch (Exception ex) {
                Logger.getLogger(GenereFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ivaVentas.setCliente(clienteFactura);
        ivaVentas.setDescuentoGlobal(0.0);
        ivaVentas.setExento(0.0);
        ivaVentas.setFecha(fecha);
        ivaVentas.setFechaCae(fecha);
        ivaVentas.setCae(0L);
        ivaVentas.setGravado(totalGravado);
        ivaVentas.setImpuesto(totalImpuesto);
        ivaVentas.setIva(totalIva);
        ivaVentas.setNoGravado(0.0);
        ivaVentas.setTotal(totalFactura);
        ivaVentas.setLetra(letraFactura);
        ivaVentas.setNumeroSucursal(sucursalFactura);
        ivaVentas.setNumeroFactura(numeroFactura);
//        try {
//            new IvaVentasBO().saveIvaVentas(ivaVentas);
//        } catch (Exception ex) {
//            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
        for (RenglonFactura reFa : renglonFactura) {
            reFa.setIvaVentas(ivaVentas);
            Integer cod = reFa.getProducto().getCodigo();
            try {
                producto = new ProductoService().getProductoByCodigo(cod);
            } catch (Exception ex) {
                Logger.getLogger(GenereFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            Float stock = (float) 0.0;
            if (producto.getStock() != null) {
                stock = producto.getStock();
            } else {
                stock = (float) 0.0;
            }
            reFa.setProducto(producto);
            stock -= reFa.getCantidad();
            producto.setStock(stock);
//            try {
//                new RenglonFacturaService().saveRenglon(rf);
//            } catch (Exception ex) {
//                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
            try {
                new ProductoService().updateProducto(producto);
            } catch (Exception ex) {
                Logger.getLogger(GenereFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            new FacturaService().grabarFactura(ivaVentas, renglonFactura); //saveFactura(ivaVentas, renglonFactura);
        } catch (Exception ex) {
            Logger.getLogger(GenereFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CtaCteCliente ccc = new CtaCteCliente();
        ccc.setCliente(clienteFactura);
        ccc.setFactura(ivaVentas);
        ccc.setFecha(fecha);
        ccc.setDebe(totalFactura);
        ccc.setHaber(0.0);
        ccc.setTipo("FC");
        ccc.setSaldo(saldoCliente);
        try {
            new CtaCteClienteService().saveCtaCteCliente(ccc);
        } catch (Exception ex) {
            Logger.getLogger(GenereFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        // eliminar los renglones
        try {
            new FcReservedService().deleteFcReserved(reserved);
        } catch (Exception ex) {
            Logger.getLogger(GenereFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        generarFactura();
        VerReservorioFrame ff = new VerReservorioFrame();
        ff.setVisible(true);
        this.dispose();
    }

    private void generarFactura() {
        renglones = new String[maxNro];
        textoFacturaPapel = "FACTURA";
        fechaFacturaPapel = sdf.format(fecha);
        clienteFacturaPapel = razonSocialTxt.getText();
        
        
 ///          ***********************************************************************************       
        
        
        codigoClienteFacturaPapel = clienteFactura.getDomicilio().getNumero();
        direccionFacturaPapel = clienteFactura.getDomicilio().getCalle() + " " + clienteFactura.getDomicilio().getNumero() + " - " + clienteFactura.getDomicilio().getLocalidad();
        cuitFacturaPapel = clienteFactura.getCuit();
        String condVta = "";
        Date fechaVto = fecha;
        Calendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        if (clienteFactura.getFormaDePago().equals(1)) {
            condVta = "CONTADO               ";
        }
        if (clienteFactura.getFormaDePago().equals(2)) {
            condVta = "7 DIAS F.F            ";
            cal.add(Calendar.DATE, 7);
            fechaVto = cal.getTime();
        }
        if (clienteFactura.getFormaDePago().equals(3)) {
            condVta = "14 DIAS F.F.          ";
            cal.add(Calendar.DATE, 14);
            fechaVto = cal.getTime();
        }
        if (clienteFactura.getFormaDePago().equals(4)) {
            condVta = "OTRO                  ";
            fechaVto = null;
        }
        condicionVentaFacturaPapel = condVta;
        vencimientoFacturaPapel = sdf.format(fechaVto);
        String catego = "";
        if (clienteFactura.getCategoriaDeIva().equals(1)) {
            catego = "Responsable Inscripto       ";
        }
        if (clienteFactura.getCategoriaDeIva().equals(2)) {
            catego = "Monotributo                 ";
        }
        if (clienteFactura.getCategoriaDeIva().equals(3)) {
            catego = "Exento                      ";
        }
        if (clienteFactura.getCategoriaDeIva().equals(4)) {
            catego = "Consumidor Final            ";
        }
        inscripcionClienteFacturaPapel = catego;
        if (categoriaIva != 1) {
            //                                    1         2         3         4         5         6         7         8         9        10
            //                           1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
            nombresColumnaFacturaPapel = "  IT CANT                   DETALLE                   P.UNIT.   DESC.  IMPORTE      IMP.    TOTAL    SUG";
        } else {
            nombresColumnaFacturaPapel = "  IT CANT                   DETALLE                   P.UNIT.    DESC.   GRAVADO      IVA       IMP.    TOTAL      SUG";
        }
        DecimalFormat df = new DecimalFormat("#0.00");
        int maxTabla = tablaFactura.getRowCount();
        for (int r = 0; r < maxNro; r++) {
            if (r < maxTabla) {
                String str0 = String.valueOf(r + 1);
                int largo = str0.length();
                if (largo < 2) {
                    renglones[r] = " " + str0 + " ";
                } else {
                    renglones[r] = str0 + " ";
                }

                str0 = tablaFactura.getValueAt(r, 1).toString();
                largo = str0.length();
                if (largo == 1) {
                    renglones[r] = renglones[r] + "   " + str0;
                }
                if (largo == 2) {
                    renglones[r] = renglones[r] + "  " + str0;
                }
                if (largo == 3) {
                    renglones[r] = renglones[r] + " " + str0;
                }
                if (largo == 4) {
                    renglones[r] = renglones[r] + str0;
                }
                str0 = tablaFactura.getValueAt(r, 2).toString();
                String espacio = " ";
                largo = str0.length();
                if (largo > 42) {
                    str0 = str0.substring(0, 42);
                    tablaFactura.setValueAt(str0, r, 2);
                } else {
                    for (int l = largo; l < 42; l++) {
                        espacio += " ";
                    }
                }
                renglones[r] = renglones[r] + "  " + tablaFactura.getValueAt(r, 2) + espacio;
                if (categoriaIva != 1) {
//                  aqui detalle de importes no inscripto en IVA           *****
// Precio Unitario
                    str0 = tablaFactura.getValueAt(r, 3).toString();
                    str0 = str0.replace(",", ".");
                    Double doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "      ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Descuento
                    str0 = tablaFactura.getValueAt(r, 7).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "     ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Importe
                    str0 = tablaFactura.getValueAt(r, 4).toString();
                    str0 = str0.replace(",", ".");
                    Double calculo = Double.valueOf(str0);
                    str0 = tablaFactura.getValueAt(r, 6).toString();
                    str0 = str0.replace(",", ".");
                    calculo += Double.valueOf(str0);
                    str0 = String.valueOf(calculo);
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "      ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Impuesto
                    str0 = tablaFactura.getValueAt(r, 5).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "       ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//  Total linea
                    str0 = tablaFactura.getValueAt(r, 8).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "      ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Sugerido
                    str0 = tablaFactura.getValueAt(r, 9).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "    ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
                } else {
                    // aqui detalle importes inscripto
// Precio Unitario
                    str0 = tablaFactura.getValueAt(r, 3).toString();
                    str0 = str0.replace(",", ".");
                    Double doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "     ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Descuento
                    str0 = tablaFactura.getValueAt(r, 7).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "     ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Gravado
                    str0 = tablaFactura.getValueAt(r, 4).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "      ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Iva
                    str0 = tablaFactura.getValueAt(r, 6).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "     ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Impuesto
                    str0 = tablaFactura.getValueAt(r, 5).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "       ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//  Total linea
                    str0 = tablaFactura.getValueAt(r, 8).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "      ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Sugerido
                    str0 = tablaFactura.getValueAt(r, 9).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "    ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
                }
            } else {
                // agregar renglon en blanco
                renglones[r] = " ";
            }
        }
// Saldo Cliente
        String str0 = String.valueOf(saldoCliente - totalFactura);
        str0 = str0.replace(",", ".");
        Double doble = Double.valueOf(str0);
        int largo = doble.intValue();
        String espacio = "          ";
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
        totalDeudaFacturaPapel = espacio + df.format(doble);
// Total Factura
        str0 = String.valueOf(totalFactura);
        str0 = str0.replace(",", ".");
        doble = Double.valueOf(str0);
        largo = doble.intValue();
        espacio = "        ";
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
        importeTotalFacturaPapel = espacio + df.format(doble);
// Linea Totales
        if (categoriaIva != 1) {
            str0 = String.valueOf(totalImpuesto);
            str0 = str0.replace(",", ".");
            doble = Double.valueOf(str0);
            largo = doble.intValue();
            espacio = "                                                                            ";
            largo = String.valueOf(largo).length();
            espacio = espacio.substring(largo);
            lineaTotalesFacturaPapel = espacio + df.format(doble);
        } else {
            str0 = String.valueOf(totalGravado);
            str0 = str0.replace(",", ".");
            doble = Double.valueOf(str0);
            largo = doble.intValue();
            espacio = "           ";
            largo = String.valueOf(largo).length();
            espacio = espacio.substring(largo);
            lineaTotalesFacturaPapel = espacio + df.format(doble);
            str0 = String.valueOf(totalImpuesto);
            str0 = str0.replace(",", ".");
            doble = Double.valueOf(str0);
            largo = doble.intValue();
            espacio = "           ";
            largo = String.valueOf(largo).length();
            espacio = espacio.substring(largo);
            lineaTotalesFacturaPapel += espacio + df.format(doble);
            str0 = String.valueOf(totalIva);
            str0 = str0.replace(",", ".");
            doble = Double.valueOf(str0);
            largo = doble.intValue();
            espacio = "                                 ";
            largo = String.valueOf(largo).length();
            espacio = espacio.substring(largo);
            lineaTotalesFacturaPapel += espacio + df.format(doble);
        }
// Total a Pagar
        Double totalPagar = saldoCliente;
        str0 = String.valueOf(totalPagar);
        str0 = str0.replace(",", ".");
        doble = Double.valueOf(str0);
        largo = doble.intValue();
        espacio = "          ";
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
        totalPagarFacturaPapel = espacio + df.format(doble);
// Cantidades atados
        cantidadesFacturaPapel = "                  CANT.ATADOS NOBLEZA: " + String.valueOf(cantidadAtadosNobleza);
        cantidadesFacturaPapel += "                 CANT ATADOS MASSALIN: " + String.valueOf(cantidadAtadosMassalin);
        texto1FacturaPapel = texto1PieFacturaTxt.getText();
        texto2FacturaPapel = texto2PieFacturaTxt.getText();
        texto3FacturaPapel = "-";
        PrinterJob pj = PrinterJob.getPrinterJob();
        PageFormat pf = pj.defaultPage();
        Paper paper = new Paper();
        double margin = 8;
        paper.setImageableArea(margin, margin, paper.getWidth() - margin * 2, paper.getHeight() - margin * 2);
        pf.setPaper(paper);
        pj.setPrintable(new MyPrintable(), pf);
//        if (pj.printDialog()) {
        try {
            pj.print();
        } catch (PrinterException e) {
            System.out.println(e);
        }
//        }
    }

    private void borrarTablaProductos() {
        int cantidadRow = tablaFactura.getRowCount();
        DefaultTableModel model1 = (DefaultTableModel) tablaFactura.getModel();
        if (cantidadRow > 0) {
            for (int i = 0; i < cantidadRow; i++) {
                model1.removeRow(0);
            }
            tablaFactura.setModel(model1);
            nro = 0;
        }
        renglonFactura = new ArrayList<RenglonFactura>();
    }

    private void calcularTotales() {
        totalGravado = 0.0;
        totalIva = 0.0;
        totalImpuesto = 0.0;
        totalFactura = 0.0;
        nro = 0;
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        Double importeTotalMassalin = 0.0;
        Double importeTotalNobleza = 0.0;
        for (RenglonFactura renFa : renglonFactura) {
            totalGravado += renFa.getGravado();
            if (renFa.getProducto().getRubro().getCodigo().equals(1)) {
                cantidadAtadosMassalin += renFa.getCantidad().intValue();
                importeTotalMassalin += renFa.getTotal();
            }
            cantidadAtadosMassalinTxt.setText(String.valueOf(cantidadAtadosMassalin));
            importeMassalinTxt.setText(String.valueOf(df.format(importeTotalMassalin)));
            if (renFa.getProducto().getRubro().getCodigo().equals(2)) {
                cantidadAtadosNobleza += renFa.getCantidad().intValue();
                importeTotalNobleza += renFa.getTotal();
            }
            cantidadAtadosNoblezaTxt.setText(String.valueOf(cantidadAtadosNobleza));
            importeNoblezaTxt.setText(String.valueOf(df.format(importeTotalNobleza)));
            totalIva += renFa.getIva();
            totalImpuesto += renFa.getImpuesto();
            nro += 1;
            renFa.setItemNro(nro);
        }
        cantidadItemsTxt.setText(String.valueOf(nro));
        totalFactura = rint((totalGravado + totalImpuesto + totalIva) * 100) / 100;
        totalTxt.setText(String.valueOf(df.format(totalFactura)));
    }

    private void cargarDatos() {
        String codigo = reserved.getCliente().getCodigo();
        codigoTxt.setText(codigo);
        try {
            clienteFactura = new ClienteService().getClienteByCodigo(codigo);
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            rfr = new RenglonFcReservedService().getRenglonesDeReserved(reserved);
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rfr != null && !rfr.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tablaFactura.getModel();
            for (RenglonFcReserved reng : rfr) {
                RenglonFactura ar = new RenglonFactura();
                ar.setCantidad(reng.getCantidad());
                System.out.println(reng.getProducto());
                System.out.println(reng.getProducto().getDetalle());
                ar.setProducto(reng.getProducto());
                ar.setDescripcion(reng.getProducto().getDetalle());
                ar.setDescuento(reng.getDescuento());
                ar.setExento(reng.getExento());
                ar.setGravado(reng.getGravado());
                ar.setImpuesto(reng.getImpuesto());
                ar.setItemNro(reng.getItemNro());
                ar.setIva(reng.getIva());
                ar.setNoGravado(reng.getNoGravado());
                ar.setSugerido(reng.getSugerido());
                ar.setTotal(reng.getTotal());
                renglonFactura.add(ar);
                Object ob[] = new Object[10];
                ob[0] = reng.getProducto().getCodigo();
                ob[1] = df1.format(reng.getCantidad());
                ob[2] = reng.getProducto().getDetalle();
                ob[3] = df.format(reng.getPrecioUnitario());
                ob[4] = df.format(reng.getGravado());
                ob[5] = df.format(reng.getImpuesto());
                ob[6] = df.format(reng.getIva());
                ob[7] = df.format(reng.getDescuento());
                ob[8] = df.format(reng.getTotal());
                ob[9] = df.format(reng.getSugerido());
                tbl.addRow(ob);
            }
            tablaFactura.setModel(tbl);
        }
        calcularTotales();
        buscar();
    }

    class MyPrintable implements Printable {

        public int print(Graphics g, PageFormat pf, int pageIndex) {
            if (pageIndex != 0) {
                return NO_SUCH_PAGE;
            }
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(new Font("Monospaced", Font.PLAIN, 8));
            g2.setPaint(Color.black);
            int row = 45;
            //                1234567890123456789012345678901234567890123456789012345678901234567890
            String espacio = "                                                         ";
            g2.drawString(espacio + textoFacturaPapel, 30, row);
            row += 25;
            //         123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
            espacio = "                                                                           ";
            g2.drawString(espacio + fechaFacturaPapel, 30, row);
            espacio = "            ";
            row += 50;
            g2.drawString(espacio + clienteFacturaPapel, 30, row);
            g2.drawString(codigoClienteFacturaPapel, 480, row);
            row += 15;
            espacio = "            ";
            g2.drawString(espacio + direccionFacturaPapel, 30, row);
            row += 15;
            g2.drawString(cuitFacturaPapel, 100, row);
            g2.drawString(inscripcionClienteFacturaPapel, 360, row);
            row += 25;
            g2.drawString(condicionVentaFacturaPapel, 150, row);
            g2.drawString("Ref.Interna:" + letraFactura + " " + sucursalFactura + "-" + numeroFactura, 350, row);
            //g2.drawString(vencimientoFacturaPapel, 400, row);
            row += 25;
            g2.drawString(nombresColumnaFacturaPapel, 30, row);
            row += 15;
            for (int x = 0; x < maxNro; x++) {
                if (renglones[x] != null) {
                    g2.drawString(renglones[x], 40, row);
                }
                row += 10;
            }
            row += 40;
            g2.drawString(lineaTotalesFacturaPapel, 30, row);
            g2.setFont(new Font("Monospaced", Font.BOLD, 11));
            g2.drawString(importeTotalFacturaPapel, 490, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            row += 21;
            g2.drawString("SALDO ANTERIOR: " + totalDeudaFacturaPapel, 403, row);
            row += 10;
            g2.drawString("SALDO TOTAL:    " + totalPagarFacturaPapel, 403, row);
            row += 10;
            espacio = "     ";
            g2.setFont(new Font("Monospaced", Font.BOLD, 9));
            g2.drawString(espacio + texto1FacturaPapel, 30, row);
            row += 10;
            g2.drawString(espacio + texto2FacturaPapel, 30, row);
            row += 10;
            g2.drawString(espacio + texto3FacturaPapel, 30, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            row += 15;
//            g2.drawString(espacio + texto4FacturaPapel, 30, row);
//            row += 20;
            g2.drawString(cantidadesFacturaPapel, 30, row);
            return PAGE_EXISTS;
        }
    }
}
