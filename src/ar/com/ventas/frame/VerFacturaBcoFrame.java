/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.entities.Request;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.CustomerService;
import ar.com.ventas.services.ProductoService;
import ar.com.ventas.services.RenglonFacturaService;
import ar.com.ventas.services.RoutinesService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class VerFacturaBcoFrame extends javax.swing.JFrame {

    public List<ActivityRow> renglonFactura = new ArrayList<ActivityRow>();
    private String lineaTitulos = "";
    private String textoFacturaPapel;
    private String modeloFcPapel;
    private String fechaFacturaPapel;
    private String clienteFacturaPapel;
    private String codigoClienteFacturaPapel;
    private String direccionFacturaPapel;
    private String cuitFacturaPapel;
    private String condicionVentaFacturaPapel;
//    private String vencimientoFacturaPapel;
    private String inscripcionClienteFacturaPapel;
    private String nombresColumnaFacturaPapel;
    private String[] renglones = null;
    private String texto1FacturaPapel;
    private String texto2FacturaPapel;
    private String texto3FacturaPapel;
//    private String totalDeudaFacturaPapel;
    private String lineaTotalesFacturaPapel;
//    private String totalPagarFacturaPapel;
    private String importeTotalFacturaPapel;
    private String cantidadesFacturaPapel;
    private Date fecha;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    ;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat df2 = new DecimalFormat("#0.0");
    private Cliente clienteFactura = null;
    private Cliente clienteReferencia;
    private Customer customer = null;
    private Producto producto = null;
    private DefaultTableModel tabla = null;
    private Double totalFactura = 0.00;
    private Double totalImpuesto = 0.00;
    private Double totalIva = 0.00;
    private Double totalGravado = 0.00;
//    private Double totalNoGravado = 0.0;
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
    private List<RenglonFactura> renglonP = null;
    private Request pedido;
    private IvaVentas factura;
    private String texto1Cae = "";
    private String texto2Cae = "";
    private String numCae = "";
    private String vencCae = "";
    private String cuit1 = "";
    private Cliente cl;

    /**
     * Creates new form FacturaFrame
     *
     * @param factura
     * @param cl
     */
    public VerFacturaBcoFrame(IvaVentas factura, Cliente cl) {
        getContentPane().setBackground(new java.awt.Color(135, 206, 235));
        initComponents();
        this.factura = factura;
        this.cl = cl;
        clienteFactura = cl;
        categoriaIva = clienteFactura.getCategoriaDeIva();
        try {
            clienteSeleccionado = new ClienteService().getClienteByCodigo(factura.getCliente().getCodigo());
            clienteReferencia = clienteSeleccionado;
        } catch (Exception ex) {
            Logger.getLogger(VerFacturaBcoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setLocationRelativeTo(null);
        limpiarCampos();
        bloquearCampos();
//      levanto el modelo creado del frame
        tabla = (DefaultTableModel) tablaFactura.getModel();
        cargarDatosIniciales();
        cargarCliente();
        cargarRenglones();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codigoTxt = new javax.swing.JTextField();
        razonSocialTxt = new javax.swing.JTextField();
        fechaTxt = new javax.swing.JTextField();
        ivaTxt = new javax.swing.JTextField();
        saldoTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        totalTxt = new javax.swing.JTextField();
        terminarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        descuentoGlobalLbl = new javax.swing.JLabel();
        descuentoGlobalTxt = new javax.swing.JTextField();
        texto1PieFacturaTxt = new javax.swing.JTextField();
        texto2PieFacturaTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cantidadAtadosNoblezaTxt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        totalMassalinTxt = new javax.swing.JTextField();
        totalNoblezaTxt = new javax.swing.JTextField();
        cantidadAtadosMassalinTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        saldoOfTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        saldoTotalTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        descuentoTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("AyM - Duplicado Factura Web");
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

        jLabel3.setText("Saldo CF:");

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

        saldoTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saldoTxt.setForeground(new java.awt.Color(0, 0, 153));
        saldoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        saldoTxt.setText("SALDO");

        jLabel8.setText("TOTAL FACTURA:");

        totalTxt.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        totalTxt.setForeground(new java.awt.Color(204, 0, 0));
        totalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTxt.setText("TOTAL");

        terminarBtn.setText("Imprimir");
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

        texto1PieFacturaTxt.setText("TEXTO 1 PIE FACTURA");

        texto2PieFacturaTxt.setText("TEXTO 2 PIE FACTURA");

        jLabel15.setText("Massalin:");

        jLabel17.setText("Nobleza:");

        cantidadAtadosNoblezaTxt.setText("Cant Nobl");

        jLabel19.setText("Importe:");

        jLabel20.setText("Importe:");

        totalMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalMassalinTxt.setText("TOT $ MASS");

        totalNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalNoblezaTxt.setText("TOT $ NOBL");

        cantidadAtadosMassalinTxt.setText("Cant Mass");

        jLabel9.setText("Saldo OF:");

        saldoOfTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saldoOfTxt.setForeground(new java.awt.Color(0, 0, 204));
        saldoOfTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        saldoOfTxt.setText("SALDO A");

        jLabel10.setText("Total:");

        saldoTotalTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saldoTotalTxt.setForeground(new java.awt.Color(0, 0, 204));
        saldoTotalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        saldoTotalTxt.setText("TOTAL SALD");

        jLabel5.setText("Descuento:");

        descuentoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoTxt.setText("DTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(terminarBtn)
                                .addGap(94, 94, 94)
                                .addComponent(cancelarBtn))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                    .addComponent(descuentoGlobalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(saldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(saldoOfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(saldoTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(texto2PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(texto1PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(descuentoTxt))
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                    .addComponent(jLabel3)
                    .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(saldoOfTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(saldoTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto1PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(descuentoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto2PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(totalMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(totalNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminarBtn)
                    .addComponent(cancelarBtn))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar la Factura?", "Atencion", JOptionPane.YES_NO_OPTION);
        // 0 = si; 1 = no
        if (escape == 0) {
            ReimpresionDocumentoPorClienteFrame rdpcf = new ReimpresionDocumentoPorClienteFrame(cl);
            rdpcf.setVisible(true);
            this.dispose();
        } else {
            tablaFactura.setEnabled(true);
        }
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void terminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBtnActionPerformed
        terminarFactura();
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
            java.util.logging.Logger.getLogger(VerFacturaBcoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerFacturaBcoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerFacturaBcoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerFacturaBcoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerFacturaBcoFrame(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField cantidadAtadosMassalinTxt;
    private javax.swing.JTextField cantidadAtadosNoblezaTxt;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JLabel descuentoGlobalLbl;
    private javax.swing.JTextField descuentoGlobalTxt;
    private javax.swing.JTextField descuentoTxt;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField razonSocialTxt;
    private javax.swing.JTextField saldoOfTxt;
    private javax.swing.JTextField saldoTotalTxt;
    private javax.swing.JTextField saldoTxt;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JButton terminarBtn;
    private javax.swing.JTextField texto1PieFacturaTxt;
    private javax.swing.JTextField texto2PieFacturaTxt;
    private javax.swing.JTextField totalMassalinTxt;
    private javax.swing.JTextField totalNoblezaTxt;
    private javax.swing.JTextField totalTxt;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        totalMassalinTxt.setText("");
        totalNoblezaTxt.setText("");
        texto1PieFacturaTxt.setText("");
        texto2PieFacturaTxt.setText("");
        cantidadAtadosMassalinTxt.setText("");
        cantidadAtadosNoblezaTxt.setText("");
        ivaTxt.setText("");
        codigoTxt.setText("");
        fechaTxt.setText("");
        razonSocialTxt.setText("");
        totalTxt.setText("");
        saldoTxt.setText("0.00");
        totalTxt.setText("0.00");
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        descuentoGlobalTxt.setText("");
    }

    private void bloquearCampos() {
        cancelarBtn.setEnabled(false);
        terminarBtn.setEnabled(false);
        ivaTxt.setEditable(false);
        codigoTxt.setEnabled(true);
        codigoTxt.setEditable(true);
        fechaTxt.setEditable(false);
        razonSocialTxt.setEditable(false);
        totalTxt.setEnabled(false);
        saldoTxt.setEditable(false);
        texto1PieFacturaTxt.setEnabled(false);
        texto2PieFacturaTxt.setEnabled(false);
        cantidadAtadosMassalinTxt.setEditable(false);
        cantidadAtadosNoblezaTxt.setEditable(false);
        descuentoGlobalTxt.setEditable(false);
        totalMassalinTxt.setEditable(false);
        totalNoblezaTxt.setEditable(false);
    }

    private void buscar() {
        cargarDatosIniciales();
        filtro = "";
        Long id = (long) 1;
        try {
            Configuracion conf = new ConfiguracionService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(VerFacturaBcoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecha = Calendar.getInstance().getTime();
//        categoriaIva = 2;
        try {
            clienteReferencia = new ClienteService().getClienteByCodigo(codigoTxt.getText());
            customer = new CustomerService().getCustomerByCodigo(codigoTxt.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - cliente");
            Logger.getLogger(VerFacturaBcoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clienteReferencia != null) {

            if (customer != null) {
                razonSocialTxt.setText(clienteReferencia.getRazonSocial());
                fechaTxt.setText(sdf.format(fecha));
                ivaTxt.setText("--");
                if (customer.getSaldo() != null) {
                    saldoTxt.setText(String.valueOf(df.format(customer.getSaldo() + clienteReferencia.getSaldo())));
                    saldoCliente = customer.getSaldo() + clienteReferencia.getSaldo();
                } else {
                    saldoTxt.setText("0.00");
                    saldoCliente = 0.0;
                }
                Boolean terminar = false;
                cancelarBtn.setEnabled(true);
                codigoTxt.setEditable(false);
                totalTxt.setEnabled(true);
                totalTxt.setEditable(false);
            } else {
                JOptionPane.showMessageDialog(this, "Error - cliente no existe");
                codigoTxt.requestFocus();
            }
        }
    }

    private void terminarFactura() {
        numCae = factura.getCae().toString();
        vencCae = sdf.format(factura.getFechaCae());
        fecha = factura.getFecha();
        letraFactura = factura.getLetra();
        sucursalFactura = factura.getNumeroSucursal();
        numeroFactura = factura.getNumeroFactura();
        String cui = factura.getCliente().getCuit();
        cuit1 = cui.substring(0, 2) + cui.substring(3, 11) + cui.substring(12, 13);
        if (numCae.length() > 10) {
            int x = 0;
            Integer suma1 = 0;
            Integer suma2 = 0;
            String tipo_cbte = "";
            if (letraFactura.equals("A")) {
                tipo_cbte = "1";
            } else {
                tipo_cbte = "6";
            }
            String fv = vencCae.substring(6, 10) + vencCae.substring(3, 5) + vencCae.substring(0, 2);
            String cadena = cuit1 + "0" + tipo_cbte + "0005" + numCae + fv;
            System.out.println(cadena);
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    System.out.println(cadena.substring(i, i + 1).toString());
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    System.out.println(cadena.substring(i, i + 1).toString());
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma2 += num;
                    x = 0;
                }
            }
            suma1 = suma1 * 3;
            int total = suma1 + suma2;
            int dv = (int) (rint(total / 10 + .9) * 10);
            dv = dv - total;
            cadena += String.valueOf(dv);
            String txtCadenaRP = "";
            for (int i = 0; i < 40; i = i + 2) {
                String charNum = cadena.substring(i, i + 2);
                int numChar = Integer.valueOf(charNum);
                if (numChar < 50) {
                    numChar += 48;
                } else {
                    numChar += 142;
                }
                char c = (char) numChar;
                txtCadenaRP = txtCadenaRP + c;
            }
            txtCadenaRP = (char) 40 + txtCadenaRP + (char) 41;
            texto2Cae = txtCadenaRP;
        }
        generarFactura();
        ReimpresionDocumentoPorClienteFrame ff
                = new ReimpresionDocumentoPorClienteFrame(cl);
        ff.setVisible(true);
        this.dispose();
    }

    private void generarFactura() {
        renglones = new String[maxNro];
        textoFacturaPapel = "FACTURA";
        fechaFacturaPapel = sdf.format(fecha);
        clienteFacturaPapel = razonSocialTxt.getText();
        codigoClienteFacturaPapel = factura.getCliente().getCodigo();
        direccionFacturaPapel = factura.getCliente().getDomicilio().getCalle()
                + " " + factura.getCliente().getDomicilio().getNumero()
                + " - " + factura.getCliente().getDomicilio().getLocalidad();
        cuitFacturaPapel = factura.getCliente().getCuit();

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
//        vencimientoFacturaPapel = sdf.format(fechaVto);
        String catego = "";
        modeloFcPapel = "Cod.Nro.";
        if (categoriaIva.equals(1)) {
            catego = "Responsable Inscripto       ";
            modeloFcPapel += "1";
        }
        if (categoriaIva.equals(2)) {
            catego = "Monotributo                 ";
            modeloFcPapel += "1";
        }
        if (categoriaIva.equals(3)) {
            catego = "Exento                      ";
            modeloFcPapel += "6";
        }
        if (categoriaIva.equals(4)) {
            catego = "Consumidor Final            ";
            modeloFcPapel += "6";
        }
        inscripcionClienteFacturaPapel = catego;
        if (categoriaIva.equals(1) || categoriaIva.equals(2)) {
            //                                    1         2         3         4         5         6         7         8         9        10
            //                           1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
            nombresColumnaFacturaPapel = "  IT   CANT                 DETALLE                   P.UNIT.    DESC.   GRAVADO      IVA       IMP.    TOTAL      SUG";
        } else {
            nombresColumnaFacturaPapel = "  IT   CANT                 DETALLE                    P.UNIT.     DESC.  IMPORTE       IMP.     TOTAL     SUG";
        }
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
                    renglones[r] = renglones[r] + "     " + str0;
                }
                if (largo == 2) {
                    renglones[r] = renglones[r] + "    " + str0;
                }
                if (largo == 3) {
                    renglones[r] = renglones[r] + "   " + str0;
                }
                if (largo == 4) {
                    renglones[r] = renglones[r] + "  " + str0;
                }
                if (largo == 5) {
                    renglones[r] = renglones[r] + " " + str0;
                }
                if (largo == 6) {
                    renglones[r] = renglones[r] + str0;
                }
                str0 = tablaFactura.getValueAt(r, 2).toString();
                String espacio = " ";
                largo = str0.length();
                if (largo > 42) {
                    str0 = str0.substring(0, 40);
                    tablaFactura.setValueAt(str0, r, 2);
                } else {
                    for (int l = largo; l < 40; l++) {
                        espacio += " ";
                    }
                }
                renglones[r] = renglones[r] + " " + tablaFactura.getValueAt(r, 2) + espacio;
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
// Importet
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
        String str0 = String.valueOf(saldoCliente - factura.getTotal());
        str0 = str0.replace(",", ".");
        Double doble = Double.valueOf(str0);
        int largo = doble.intValue();
        String espacio = "          ";
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
//        totalDeudaFacturaPapel = espacio + df.format(doble);
// Total Factura
        str0 = df.format(factura.getTotal());
        str0 = str0.replace(",", ".");
        doble = Double.valueOf(str0);
        largo = doble.intValue();
        espacio = "        ";
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
        importeTotalFacturaPapel = espacio + df.format(doble);
// Linea Totales

        if (categoriaIva.equals(1) || categoriaIva.equals(2)) {
            if (factura.getDescuentoGlobal() > 0.0) {
//                                        1         2         3         4         5         6         7         8         9        10
//                              01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789
                lineaTitulos = "      Gravado            Descuento           Impuesto                  Iva                     Total Factura";
                str0 = df.format(factura.getGravado());
                str0 = str0.replace(",", ".");
                doble = Double.valueOf(str0);
                largo = doble.intValue();
                espacio = "            ";
                largo = String.valueOf(largo).length();
                espacio = espacio.substring(largo);
                lineaTotalesFacturaPapel = espacio + df.format(doble);
                
                str0 = df.format(factura.getDescuentoGlobal());
                str0 = str0.replace(",", ".");
                doble = Double.valueOf(str0);
                largo = doble.intValue();
                espacio = "                 ";
                largo = String.valueOf(largo).length();
                espacio = espacio.substring(largo);
                lineaTotalesFacturaPapel += espacio + df.format(doble);
                
                str0 = String.valueOf(totalImpuesto);
                str0 = str0.replace(",", ".");
                doble = Double.valueOf(str0);
                largo = doble.intValue();
                espacio = "                 ";
                largo = String.valueOf(largo).length();
                espacio = espacio.substring(largo);
                lineaTotalesFacturaPapel += espacio + df.format(doble);
                str0 = String.valueOf(factura.getIva());
                str0 = str0.replace(",", ".");
                doble = Double.valueOf(str0);
                largo = doble.intValue();
                espacio = "                   ";
                largo = String.valueOf(largo).length();
                espacio = espacio.substring(largo);
                lineaTotalesFacturaPapel += espacio + df.format(doble);
            } else {
                lineaTitulos = "      Gravado                   Impuesto                       Iva                            Total Factura";
                str0 = df.format(totalGravado);
                str0 = str0.replace(",", ".");
                doble = Double.valueOf(str0);
                largo = doble.intValue();
                espacio = "             ";
                largo = String.valueOf(largo).length();
                espacio = espacio.substring(largo);
                lineaTotalesFacturaPapel = espacio + df.format(doble);
                str0 = String.valueOf(totalImpuesto);
                str0 = str0.replace(",", ".");
                doble = Double.valueOf(str0);
                largo = doble.intValue();
                espacio = "                          ";
                largo = String.valueOf(largo).length();
                espacio = espacio.substring(largo);
                lineaTotalesFacturaPapel += espacio + df.format(doble);
                str0 = String.valueOf(totalIva);
                str0 = str0.replace(",", ".");
                doble = Double.valueOf(str0);
                largo = doble.intValue();
                espacio = "                          ";
                largo = String.valueOf(largo).length();
                espacio = espacio.substring(largo);
                lineaTotalesFacturaPapel += espacio + df.format(doble);
            }
        } else {
            lineaTitulos = "                                                             Impuesto                  Total Factura";
            str0 = String.valueOf(totalImpuesto);
            str0 = str0.replace(",", ".");
            doble = Double.valueOf(str0);
            largo = doble.intValue();
            espacio = "                                                                            ";
            largo = String.valueOf(largo).length();
            espacio = espacio.substring(largo);
            lineaTotalesFacturaPapel = espacio + df.format(doble);
        }
// Total a Pagar
//        Double totalPagar = saldoCliente;
        str0 = String.valueOf(factura.getTotal());
        str0 = str0.replace(",", ".");
        doble = Double.valueOf(str0);
        largo = doble.intValue();
        espacio = "          ";
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
//        totalPagarFacturaPapel = espacio + df.format(doble);
// Cantidades atados
        cantidadesFacturaPapel = "                  CANT.ATADOS NOBLEZA: " + String.valueOf(cantidadAtadosNobleza);
        cantidadesFacturaPapel += "                 CANT ATADOS MASSALIN: " + String.valueOf(cantidadAtadosMassalin);
        texto1FacturaPapel = texto1PieFacturaTxt.getText();
        texto2FacturaPapel = texto2PieFacturaTxt.getText();
        texto3FacturaPapel = "-";
        texto1Cae = String.valueOf(numCae);

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
        totalFactura = 0.0;
        nro = 0;
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        Double importeTotalMassalin = 0.0;
        Double importeTotalNobleza = 0.0;
        for (ActivityRow renFa : renglonFactura) {
            totalGravado += renFa.getGravado();
            int cp = renFa.getCodigoProducto();
            Producto pro;
            try {
                pro = new ProductoService().getProductoByCodigo(cp);
            } catch (Exception ex) {
                Logger.getLogger(VerFacturaBcoFrame.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            System.out.println(pro.getCodigo());
            System.out.println(pro.getRubro().getCodigo());
            if (pro.getRubro().getCodigo().equals(1)) {
                cantidadAtadosMassalin += renFa.getCantidad().intValue();
                importeTotalMassalin += renFa.getTotal();
            }
            cantidadAtadosMassalinTxt.setText(String.valueOf(cantidadAtadosMassalin));
            totalMassalinTxt.setText(String.valueOf(df.format(importeTotalMassalin)));
            if (pro.getRubro().getCodigo().equals(2)) {
                cantidadAtadosNobleza += renFa.getCantidad().intValue();
                importeTotalNobleza += renFa.getTotal();
            }
            cantidadAtadosNoblezaTxt.setText(String.valueOf(cantidadAtadosNobleza));
            totalNoblezaTxt.setText(String.valueOf(df.format(importeTotalNobleza)));
            totalIva += renFa.getIva();
            totalImpuesto += renFa.getImpuesto();
            nro += 1;
            renFa.setItemNro(nro);
        }
        totalFactura = rint((totalGravado + totalImpuesto + totalIva) * 100) / 100;
        totalTxt.setText(String.valueOf(df.format(totalFactura)));
        saldoCliente = 0.00;
        if (clienteFactura != null) {
            if (clienteReferencia != null) {
                saldoCliente = customer.getSaldo() + clienteReferencia.getSaldo();
//                System.out.println("1");
            } else {
                saldoCliente = clienteFactura.getSaldo();
//                System.out.println("2");
            }
        } else {
            if (clienteReferencia != null) {
                saldoCliente = clienteReferencia.getSaldo();
//                System.out.println("3");
            }
        }
        totalTxt.setText(df.format(factura.getTotal()));
        if (factura.getDescuentoGlobal() != null) {
            if (!factura.getDescuentoGlobal().equals(0.0)) {
                descuentoTxt.setText(df.format(factura.getDescuentoGlobal()));
            } else {
                descuentoTxt.setText(df.format(0.0));
            }
        }
//        System.out.println(saldoCliente);
//        System.out.println(totalFactura);
//        System.exit(0);
    }

    private void cargarCliente() {
        //String cod = clienteReferencia.getCodigo();
        //clienteFactura.setCodigo(cod);
        codigoClienteFacturaPapel = clienteFactura.getCodigo();
        codigoTxt.setText(codigoClienteFacturaPapel);
        razonSocialTxt.setText(clienteFactura.getRazonSocial());
        //descuento = factura.getPorcentualDescuentoGlobal();
        if (factura.getPorcentualDescuentoGlobal() != null) {
            descuentoGlobalTxt.setText(df2.format(factura.getPorcentualDescuentoGlobal()));
        } else {
            descuentoGlobalTxt.setText(df2.format(0));
        }
        try {
            customer = new CustomerService().getCustomerByCodigo(codigoClienteFacturaPapel);
        } catch (Exception ex) {
            Logger.getLogger(VerFacturaBcoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ivaTxt.setText("--");
//        categoriaIva = 2;
        saldoTxt.setText(String.valueOf(df.format(customer.getSaldo())));
        saldoOfTxt.setText(String.valueOf(df.format(clienteReferencia.getSaldo())));
        Double saldoTotal = customer.getSaldo() + clienteReferencia.getSaldo();
        saldoTotalTxt.setText(String.valueOf(df.format(saldoTotal)));
        //fecha = Calendar.getInstance().getTime();
        fechaTxt.setText(sdf.format(fecha));
    }

    private void cargarRenglones() {
        if (factura.getTextoPieFactura1() != null) {
            texto1PieFacturaTxt.setText(factura.getTextoPieFactura1());
        } else {
            texto1PieFacturaTxt.setText("");
        }
        if (factura.getTextoPieFactura2() != null) {
            texto2PieFacturaTxt.setText(factura.getTextoPieFactura2());
        } else {
            texto2PieFacturaTxt.setText("");
        }
        try {
            renglonP = new RenglonFacturaService().getAllRenglonFacturaFromIvaVentas(factura);
        } catch (Exception ex) {
            Logger.getLogger(VerFacturaBcoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabla = (DefaultTableModel) tablaFactura.getModel();
        for (RenglonFactura rp : renglonP) {
            ActivityRow rf = new ActivityRow();
            rf.setCantidad(rp.getCantidad());
            rf.setCodigoProducto(rp.getProducto().getCodigo());
            rf.setItemNro(rp.getItemNro());
            rf.setDescripcion(rp.getDescripcion());
            rf.setGravado(rp.getGravado());
            rf.setNoGravado(rp.getNoGravado());
            rf.setExento(rp.getExento());
            rf.setImpuesto(rp.getImpuesto());
            rf.setDescuento(rp.getDescuento());
            rf.setIva(rp.getIva());
            rf.setTotal(rp.getTotal());
            rf.setSugerido(rp.getSugerido());
            renglonFactura.add(rf);
            Object linea[] = new Object[10];
            linea[0] = rp.getProducto().getCodigo();
            linea[1] = rp.getCantidad().intValue();
            linea[2] = rp.getDescripcion();
            linea[3] = df.format((rp.getGravado() + rp.getImpuesto() + rp.getIva()) / rp.getCantidad());
            linea[4] = df.format(rp.getGravado());
            linea[5] = df.format(rp.getImpuesto());
            linea[6] = df.format(rp.getIva());
            linea[7] = 0.00;
            linea[8] = df.format(rp.getTotal());
            linea[9] = df.format(rp.getSugerido());
            tabla.addRow(linea);
        }
        tablaFactura.setModel(tabla);
        Boolean terminar = false;
        cancelarBtn.setEnabled(true);
        codigoTxt.setEditable(false);
        totalTxt.setEnabled(true);
        totalTxt.setEditable(false);
        calcularTotales();
        cancelarBtn.setEnabled(true);
        terminarBtn.setEnabled(true);
    }

    private void cargarDatosIniciales() {
        filtro = "";
        Long id = (long) 1;
        try {
            Routines conf = new RoutinesService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(VerFacturaBcoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecha = factura.getFecha();
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
            g2.setFont(new Font("Monospaced", Font.PLAIN, 14));
            String espacio = "                              ";
            g2.drawString(espacio + letraFactura, 30, row);
            espacio = "                                                         ";
            g2.setFont(new Font("Monospaced", Font.PLAIN, 6));
            g2.drawString(modeloFcPapel, 271, 53);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 8));
            g2.drawString(espacio + textoFacturaPapel, 30, row);
            g2.drawString("Distribuidora A & M", 50, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 8));
            row += 12;
            g2.drawString("Av.San Martín 3284", 50, row);
            row += 12;
            g2.drawString("1678 - Caseros Prov. Buenos Aires", 50, row);
            row += 12;
            g2.drawString("Tel: 4759-6677 - mail: distaym@yahoo.com.ar", 50, row);
            row += 12;
            g2.drawString("CUIT:20-12412758-1 inic.activ.18/04/2005", 50, row);
            row = 70;
            String sucFactura = "000" + sucursalFactura.toString();
            int largo = sucFactura.length();
            sucFactura = sucFactura.substring(largo - 4, largo);
            String numFactura = "0000000" + numeroFactura.toString();
            largo = numFactura.length();
            numFactura = numFactura.substring(largo - 8, largo);
            g2.drawString(" " + sucFactura + "-" + numFactura, 380, row);
            row += 15;
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
            row += 18;
            g2.drawString(condicionVentaFacturaPapel, 150, row);
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
            g2.drawString(lineaTitulos, 45, row);
            row += 20;
            g2.drawString(lineaTotalesFacturaPapel, 30, row);
            g2.setFont(new Font("Monospaced", Font.BOLD, 11));
            g2.drawString(importeTotalFacturaPapel, 490, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            row += 21;
//            g2.drawString("SALDO ANTERIOR: " + totalDeudaFacturaPapel, 403, row);
//            row += 10;
//            g2.drawString("SALDO TOTAL:    " + totalPagarFacturaPapel, 403, row);
//            row += 10;
            espacio = "     ";
            g2.setFont(new Font("Monospaced", Font.BOLD, 9));
            g2.drawString(espacio + texto1FacturaPapel, 30, row);
            row += 10;
            g2.drawString(espacio + texto2FacturaPapel, 30, row);
            row += 10;
            g2.drawString(espacio + texto3FacturaPapel, 30, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            row += 15;
            g2.drawString(cantidadesFacturaPapel, 30, row);
            row += 20;
            g2.drawString(" CAE " + texto1Cae + "  Venc. CAE " + vencCae, 30, row);
            g2.setFont(new Font("PF Interleavev 2 of 5 Text", Font.PLAIN, 18));
            g2.drawString("           " + texto2Cae, 160, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            return PAGE_EXISTS;
        }
    }
}
