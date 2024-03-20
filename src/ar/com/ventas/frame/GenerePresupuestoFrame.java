/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.ClienteTraba;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.CustomerTraba;
import ar.com.ventas.entities.FcReserved;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonFcReserved;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ClienteTrabaService;
import ar.com.ventas.services.CustomerService;
import ar.com.ventas.services.CustomerTrabaService;
import ar.com.ventas.services.FacturaService;
import ar.com.ventas.services.FcReservedService;
import ar.com.ventas.services.InventoryService;
import ar.com.ventas.services.ProductoService;
import ar.com.ventas.services.RenglonFcReservedService;
import ar.com.ventas.services.RoutinesService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class GenerePresupuestoFrame extends javax.swing.JFrame {

    public List<ActivityRow> renglonFactura = new ArrayList<ActivityRow>();
    private String textoFacturaPapel;
    private String fechaFacturaPapel;
    private String clienteFacturaPapel;
    private Float descuen = 0F;
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
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Customer clienteFactura = null;
    private Cliente clienteFc = null;
    private Producto producto = null;
    private DefaultTableModel tabla = null;
    private Double totalFactura = 0.00;
    private Double totalImpuesto = 0.00;
    private Double totalIva = 0.00;
    private Double totalGravado = 0.00;
    private Double totalNoGravado = 0.0;
    private Double totalDescuen = 0.0;
    private Double gravado = 0.00;
    private Double noGravado = 0.00;
    private Double iva = 0.00;
    private Float porcentualIva;
    private Double impuesto = null;
    private Double totalLinea = 0.00;
    private Boolean tieneDto = false;
    private Customer clienteSeleccionado;
    private Producto productoSeleccionado;
    private Float cantidad;
    private Integer categoriaIva = 1;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat df1 = new DecimalFormat("#0");
    private DecimalFormat df2 = new DecimalFormat("#0.0");
    private Double saldoCliente = 0.00;
    private String filtro = "";
    private String letraFactura;
    private Integer sucursalFactura;
    private Integer numeroFactura;
    private Routines config = null;
    private Double precioFinal = 0.0;
    private Integer nro = 0;
    private Integer maxNro = 41;
    private Integer cantidadAtadosMassalin;
    private Integer cantidadAtadosNobleza;
    public Boolean encontrado;
    private FcReserved reservada;
    private List<RenglonFcReserved> rfr = null;

    /**
     * Creates new form FacturaFrame
     */
    public GenerePresupuestoFrame(FcReserved reservada) {
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        initComponents();
        this.setLocationRelativeTo(null);
        limpiarCampos();
        this.reservada = reservada;
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
        totalMassalinTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        totalNoblezaTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("A y M - Presupuesto");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cant", "Detalle", "P.Unit", "Gravado", "Impuesto", "IVA", "dto.", "SubTotal", "Sug."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
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

        jLabel8.setText("TOTAL:");

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
        descuentoVolumenTxt.setText("DESCUENTO");

        texto1PieFacturaTxt.setText("TEXTO 1 PIE FACTURA");

        texto2PieFacturaTxt.setText("TEXTO 2 PIE FACTURA");

        jLabel15.setText("Massalin:");

        jLabel17.setText("Nobleza:");

        cantidadAtadosMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadAtadosMassalinTxt.setText("Cant Mass");

        cantidadAtadosNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadAtadosNoblezaTxt.setText("Cant Nobl");

        jLabel18.setText("Cant. Items:");

        cantidadItemsTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadItemsTxt.setText("Cantidad Items");

        jLabel19.setText("Importe:");

        totalMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalMassalinTxt.setText("TOT MASS");

        jLabel9.setText("Importe:");

        totalNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalNoblezaTxt.setText("TOT NOBL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 14, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(texto2PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(texto1PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(descuentoBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel19)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(totalMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(totalNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel18))
                                                    .addComponent(cancelarBtn, javax.swing.GroupLayout.Alignment.TRAILING))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(terminarBtn))))
                                .addGap(46, 46, 46))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(totalMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(totalNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(terminarBtn)
                    .addComponent(cancelarBtn))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar el Presupuesto?", "Atencion", JOptionPane.YES_NO_OPTION);
        // 0 = si; 1 = no
        if (escape == 0) {
            VerReservorioFrame vrf = new VerReservorioFrame();
            vrf.setVisible(true);
            this.dispose();
        } else {
            tablaFactura.setEnabled(true);
        }
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void terminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Quiere ingresar un texto antes de Imprimir?",
                "Texto en el pie de Factura",
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
            java.util.logging.Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerePresupuestoFrame(null).setVisible(true);
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
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField razonSocialTxt;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JButton terminarBtn;
    private javax.swing.JTextField texto1PieFacturaTxt;
    private javax.swing.JTextField texto2PieFacturaTxt;
    private javax.swing.JTextField totalMassalinTxt;
    private javax.swing.JTextField totalNoblezaTxt;
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
        totalMassalinTxt.setText("");
        totalNoblezaTxt.setText("");
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
        totalNoblezaTxt.setEditable(false);
        totalMassalinTxt.setEditable(false);
        descuentoGlobalTxt.setEditable(false);
    }

    private void buscar() {
        filtro = "";
        Long id = (long) 1;
        try {
            Routines conf = new RoutinesService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        fecha = Calendar.getInstance().getTime();
        categoriaIva = 4;
        clienteFactura = null;
        clienteFc = null;
        try {
            clienteFactura = new CustomerService().getCustomerByCodigo(codigoTxt.getText());
            clienteFc = new ClienteService().getClienteByCodigo(codigoTxt.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - cliente");
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        if (clienteFc != null) {
            if (clienteFactura == null) {
                JOptionPane.showMessageDialog(this, "Cliente no habilitado");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cliente inexistente");
        }
        if (!clienteFactura.getActivo()) {
            JOptionPane.showMessageDialog(this, "Cliente Inactivo");
            return;
        }
        if (clienteFactura != null) {
            razonSocialTxt.setText(clienteFc.getRazonSocial());
            fechaTxt.setText(sdf.format(fecha));
            if (clienteFc.getCategoriaDeIva() != null) {
                if (clienteFc.getCategoriaDeIva() == 1) {
                    ivaTxt.setText("Resp. Inscripto");
                }
                if (clienteFc.getCategoriaDeIva() == 2) {
                    ivaTxt.setText("Monotributo");
                }
                if (clienteFc.getCategoriaDeIva() == 4) {
                    ivaTxt.setText("Consumidor Final");
                }
                categoriaIva = clienteFc.getCategoriaDeIva();
            } else {
                ivaTxt.setText("Consumidor Final");
            }
            if (clienteFactura.getSaldo() != null) {
                saldoCliente = clienteFactura.getSaldo();
            } else {
                saldoCliente = 0.0;
            }
            cancelarBtn.setEnabled(true);
            codigoTxt.setEditable(false);
            descuentoVolumenTxt.setEnabled(true);
            descuentoVolumenTxt.setEditable(false);
            totalTxt.setEnabled(true);
            totalTxt.setEditable(false);
            terminarBtn.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Error - cliente no existe");
            codigoTxt.requestFocus();
        }
    }

    private void terminarFactura() {
        Integer categoriaIva = 0;
        Activity ivaVentas = new Activity();
        categoriaIva = 2;
        saldoCliente = clienteFactura.getSaldo();
        saldoCliente += totalFactura;
        clienteFactura.setSaldo(saldoCliente);
        try {
            new CustomerService().updateCustomer(clienteFactura);
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long id = (long) 1;
        try {
            config = new RoutinesService().getFacturas(id);
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (categoriaIva.equals(1)) {
            letraFactura = "A";
            // es inscriptp
//            sucursalFactura = config.getSucursalA();
//            numeroFactura = config.getNumeroFacturaA();
//            numeroFactura += 1;
//            config.setNumeroFacturaA(numeroFactura);
            try {
                //new ConfiguracionService().updateConfiguracion(config);
            } catch (Exception ex) {
                Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            letraFactura = "B";
            // el resto de las categorias
            sucursalFactura = config.getSucursal();
            numeroFactura = config.getNumeroFactura();
            numeroFactura += 1;
            config.setNumeroFactura(numeroFactura);
            config.setUltimaFechaSistema(fecha);
            try {
                new RoutinesService().updateRoutines(config);
            } catch (Exception ex) {
                Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ivaVentas.setCustomer(clienteFactura);
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
        for (ActivityRow reFa : renglonFactura) {
            reFa.setActivity(ivaVentas);
            Integer cod = reFa.getCodigoProducto();
            try {
                producto = new ProductoService().getProductoByCodigo(cod);
            } catch (Exception ex) {
                Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            Float stock = (float) 0.0;
            if (producto.getStock() != null) {
                stock = producto.getStock();
            } else {
                stock = (float) 0.0;
            }
            reFa.setCodigoProducto(producto.getCodigo());
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
                Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            new FacturaService().saveFactura(ivaVentas, renglonFactura);
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Inventory ccc = new Inventory();
        ccc.setCliente(clienteFactura);
        ccc.setFactura(ivaVentas);
        ccc.setFecha(fecha);
        ccc.setDebe(totalFactura);
        ccc.setHaber(0.0);
        ccc.setTipo("FC");
        ccc.setSaldo(saldoCliente);
        try {
            new InventoryService().saveInventory(ccc);
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (rfr != null && !rfr.isEmpty()) {
            for (RenglonFcReserved renglon : rfr) {
                try {
                    new RenglonFcReservedService().deleteRenglonFcReserved(renglon);
                } catch (Exception ex) {
                    Logger.getLogger(VerReservorioFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                new FcReservedService().deleteFcReserved(reservada);
            } catch (Exception ex) {
                Logger.getLogger(VerReservorioFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        desbloquearCliente();
        generarFactura();
        VerReservorioFrame ff = new VerReservorioFrame();
        ff.setVisible(true);
        this.dispose();
    }

    private void generarFactura() {
        renglones = new String[maxNro];
        textoFacturaPapel = "PRESUPUESTO";
        fechaFacturaPapel = sdf.format(fecha);
        clienteFacturaPapel = razonSocialTxt.getText();
        Cliente xCli = null;
        try {
            xCli = new ClienteService().getClienteByCodigo(clienteFactura.getCodigo());
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        codigoClienteFacturaPapel = xCli.getCodigo(); //Domicilio().getNumero();
        direccionFacturaPapel = xCli.getDomicilio().getCalle() + " " + xCli.getDomicilio().getNumero() + " - " + xCli.getDomicilio().getLocalidad();
        cuitFacturaPapel = xCli.getCuit();
        String condVta = "";
        Date fechaVto = fecha;
        Calendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        //if (clienteFactura.getFormaDePago().equals(1)) {
        condVta = "CONTADO               ";
        //}
//        if (clienteFactura.getFormaDePago().equals(2)) {
//            condVta = "7 DIAS F.F            ";
//            cal.add(Calendar.DATE, 7);
//            fechaVto = cal.getTime();
//        }
//        if (clienteFactura.getFormaDePago().equals(3)) {
//            condVta = "14 DIAS F.F.          ";
//            cal.add(Calendar.DATE, 14);
//            fechaVto = cal.getTime();
//        }
//        if (clienteFactura.getFormaDePago().equals(4)) {
//            condVta = "OTRO                  ";
//            fechaVto = null;
//        }
        condicionVentaFacturaPapel = condVta;
        vencimientoFacturaPapel = sdf.format(fechaVto);
        String catego = "";
//        if (clienteFactura.getCategoriaDeIva().equals(1)) {
//            catego = "Responsable Inscripto       ";
//        }
//        if (clienteFactura.getCategoriaDeIva().equals(2)) {
        catego = "--";
//        }
//        if (clienteFactura.getCategoriaDeIva().equals(3)) {
//            catego = "Exento                      ";
//        }
//        if (clienteFactura.getCategoriaDeIva().equals(4)) {
//            catego = "Consumidor Final            ";
//        }
//        inscripcionClienteFacturaPapel = catego;
//        if (categoriaIva != 1) {
        //                                    1         2         3         4         5         6         7         8         9        10
        //                           1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
//            nombresColumnaFacturaPapel = "  IT CANT                   DETALLE                   P.UNIT.   DESC.  IMPORTE      IMP.    TOTAL    SUG";
//        } else {
        nombresColumnaFacturaPapel = "  IT CANT                   DETALLE                   P.UNIT.    DESC.   GRAVADO      IMP.    TOTAL      SUG";
//        }
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
        cantidadesFacturaPapel = "                  CANT.ATADOS NOBLEZA: " + String.valueOf(df.format(cantidadAtadosNobleza));
        cantidadesFacturaPapel += "                 CANT ATADOS MASSALIN: " + String.valueOf(df.format(cantidadAtadosMassalin));
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

    private void calcularTotales() {
        totalGravado = 0.0;
        totalIva = 0.0;
        totalImpuesto = 0.0;
        totalDescuen = 0.0;
        totalFactura = 0.0;
        nro = 0;
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        Double totalCalculo = 0.0;
        Double importeTotalMassalin = 0.0;
        Double importeTotalNobleza = 0.0;
        for (ActivityRow renFa : renglonFactura) {
            int cp = renFa.getCodigoProducto();
            Producto pr0 = null;
            try {
                pr0 = new ProductoService().getAllProductoByCodigo(cp);
            } catch (Exception ex) {
                Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (pr0.getIvaCero()) {
                totalGravado += renFa.getTotal();
            } else {
                totalGravado += renFa.getGravado();
            }
            Producto xPro = null;
            try {
                xPro = new ProductoService().getProductoByCodigo(renFa.getCodigoProducto());
            } catch (Exception ex) {
                Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (xPro.getRubro().getCodigo().equals(1)) {
                cantidadAtadosMassalin += renFa.getCantidad().intValue();
                importeTotalMassalin += renFa.getTotal();
            }
            cantidadAtadosMassalinTxt.setText(String.valueOf(df.format(cantidadAtadosMassalin)));
            totalMassalinTxt.setText(String.valueOf(importeTotalMassalin));
            if (xPro.getRubro().getCodigo().equals(2)) {
                cantidadAtadosNobleza += renFa.getCantidad().intValue();
                importeTotalNobleza += renFa.getTotal();
            }
            cantidadAtadosNoblezaTxt.setText(String.valueOf(df.format(cantidadAtadosNobleza)));
            totalNoblezaTxt.setText(String.valueOf(importeTotalNobleza));
            if (tieneDto) {
                if (xPro.getRubro().getCodigo().equals(5)) {
                    totalCalculo += renFa.getTotal();
                }
            }
            totalIva += renFa.getIva();
            totalImpuesto += renFa.getImpuesto();
            nro += 1;
            renFa.setItemNro(nro);
        }
        cantidadItemsTxt.setText(String.valueOf(nro));
        if (tieneDto) {
            Double tD0 = totalCalculo * descuen / 100;
            String tD1 = df.format(tD0);
            totalDescuen = Double.valueOf(tD1.replace(",", "."));
            totalGravado -= totalDescuen;
        } else {
            totalDescuen = 0.0;
        }
        totalFactura = rint((totalGravado + totalImpuesto + totalIva) * 100) / 100;
//        if (tieneDto) {
//            Double tD0 = totalCalculo * descuen / 100;
//            String tD1 = df.format(tD0);
//            totalDescuen = Double.valueOf(tD1.replace(",", "."));
//            totalGravado -= totalDescuen;
//        } else {
//            totalDescuen = 0.0;
//        }
        descuentoVolumenTxt.setText(df.format(totalDescuen));
//        totalFactura = rint((totalFactura - totalDescuen) * 100) / 100;
        totalTxt.setText(String.valueOf(df.format(totalFactura)));
    }

    private void cargarDatos() {
        String codigo = reservada.getCliente().getCodigo();
        codigoTxt.setText(codigo);
        try {
            clienteFactura = new CustomerService().getCustomerByCodigo(codigo);
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clienteFactura == null) {
            JOptionPane.showMessageDialog(this, "Debe Guardar al Cliente");
        }
        if (!clienteFactura.getActivo()) {
            JOptionPane.showMessageDialog(this, "Debe Habilitar al Cliente");
        }
        if (reservada.getDescuentoGlobal() != null) {
            descuentoGlobalTxt.setText(df2.format(reservada.getDescuentoGlobal()));
            tieneDto = true;
            descuen = reservada.getDescuentoGlobal().floatValue();
        } else {
            descuentoGlobalTxt.setText("0.00");
            tieneDto = false;
            descuen = 0F;
        }
        try {
            rfr = new RenglonFcReservedService().getRenglonesDeReserved(reservada);
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (rfr != null && !rfr.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tablaFactura.getModel();
            for (RenglonFcReserved reng : rfr) {
                ActivityRow ar = new ActivityRow();
                ar.setCantidad(reng.getCantidad());
//                System.out.println(reng.getProducto());
//                System.out.println(reng.getProducto().getDetalle());
                ar.setCodigoProducto(reng.getProducto().getCodigo());
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
                Double impUno = reng.getImpuesto() / reng.getCantidad();
                Double ivaUno = reng.getIva() / reng.getCantidad();
                ob[3] = df.format(reng.getPrecioUnitario() + impUno + ivaUno);
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

    private void desbloquearCliente() {
        String cod = clienteFc.getCodigo();
        CustomerTraba cuTr = null;
        ClienteTraba ct = null;
        try {
            cuTr = new CustomerTrabaService().getClienteByCodigo(cod);
            ct = new ClienteTrabaService().getClienteByCodigo(cod);
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuTr.setTraba2(false);
        ct.setTraba1(false);
        try {
            new CustomerTrabaService().updateCliente(cuTr);
            new ClienteTrabaService().updateCliente(ct);
        } catch (Exception ex) {
            Logger.getLogger(GenerePresupuestoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al desbloquear Cliente");
        }
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
            g2.drawString("--", 360, row);
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
            row += 20;
            if (clienteFactura.getTieneDescuento()) {
                g2.drawString("Descuento: " + descuen + "% Total descuento: " + df.format(totalDescuen), 30, row);
            }
            row += 20;
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
