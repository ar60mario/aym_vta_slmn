/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonNotaCredito;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.RenglonNotaCreditoService;
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
public class VerNotaCreditoFrame extends javax.swing.JFrame {

    public List<RenglonNotaCredito> renglonNotaCredito = new ArrayList<RenglonNotaCredito>();
    private String textoNotaCreditoPapel;
    private String fechaNotaCreditoPapel;
    private String clienteNotaCreditoPapel;
    private String codigoClienteNotaCreditoPapel;
    private String direccionNotaCreditoPapel;
    private String cuitNotaCreditoPapel;
    private String condicionVentaNotaCreditoPapel;
    private String vencimientoNotaCreditoPapel;
    private String inscripcionClienteNotaCreditoPapel;
    private String nombresColumnaNotaCreditoPapel;
    private String[] renglones = null;
    private String texto1NotaCreditoPapel;
    private String texto2NotaCreditoPapel;
    private String texto3NotaCreditoPapel;
    private String totalDeudaNotaCreditoPapel;
    private String lineaTotalesNotaCreditoPapel;
    private String totalPagarNotaCreditoPapel;
    private String importeTotalNotaCreditoPapel;
    private String cantidadesNotaCreditoPapel;
    private Date fecha;
    private SimpleDateFormat sdf;
    private SimpleDateFormat sdfCae = new SimpleDateFormat("yyyyMMdd");
    private Cliente clienteNotaCredito = null;
    private Producto producto = null;
    private DefaultTableModel tabla = null;
    private Double totalNotaCredito = 0.00;
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
    private DecimalFormat dfs = new DecimalFormat("0000");
    private DecimalFormat dfn = new DecimalFormat("00000000");
    private Double saldoCliente = 0.00;
    private String filtro = "";
    private String letraNotaCredito;
    private Integer sucursalNotaCredito;
    private Integer numeroNotaCredito;
    private Configuracion config = null;
    private Double precioFinal = 0.0;
    private Integer nro = 0;
    private Integer maxNro = 41;
    private Integer cantidadAtadosMassalin;
    private Integer cantidadAtadosNobleza;
    public Boolean encontrado;
    private IvaVentas factura;
    private List<RenglonNotaCredito> renglonF = null;
    private String texto1Cae = "";
    private String texto2Cae = "";
    private String vencCae = "";
    private String cuit1 = "";
    private Cliente cl;

    /**
     * Creates new form NotaCreditoFrame
     *
     * @param fac
     */
    public VerNotaCreditoFrame(IvaVentas fac, Cliente cl) {
        getContentPane().setBackground(new java.awt.Color(255, 250, 205));
        initComponents();
        this.setLocationRelativeTo(null);
        this.factura = fac;
        this.cl = cl;
        Cliente cli = factura.getCliente();
        this.clienteSeleccionado = cli;
        bloquearCampos();
//      levanto el modelo creado del frame
        tabla = (DefaultTableModel) tablaNotaCredito.getModel();
        cargarDatos();
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
        tablaNotaCredito = new javax.swing.JTable();
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
        texto1PieNcTxt = new javax.swing.JTextField();
        texto2PieNcTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cantidadAtadosMassalinTxt = new javax.swing.JTextField();
        cantidadAtadosNoblezaTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cantidadItemsTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        importeMassalinTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        importeNoblezaTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        numeroNotaCreditoTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("A Y M . NOTA DE CREDITO");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tablaNotaCredito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cant", "Detalle", "P.Unit", "Gravado", "Impuesto", "IVA", "dto.", "SubTotal", "Sug."
            }
        ));
        jScrollPane1.setViewportView(tablaNotaCredito);
        if (tablaNotaCredito.getColumnModel().getColumnCount() > 0) {
            tablaNotaCredito.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaNotaCredito.getColumnModel().getColumn(1).setPreferredWidth(10);
            tablaNotaCredito.getColumnModel().getColumn(2).setPreferredWidth(330);
            tablaNotaCredito.getColumnModel().getColumn(3).setPreferredWidth(20);
            tablaNotaCredito.getColumnModel().getColumn(4).setPreferredWidth(25);
            tablaNotaCredito.getColumnModel().getColumn(5).setPreferredWidth(25);
            tablaNotaCredito.getColumnModel().getColumn(6).setPreferredWidth(25);
            tablaNotaCredito.getColumnModel().getColumn(7).setPreferredWidth(20);
            tablaNotaCredito.getColumnModel().getColumn(8).setPreferredWidth(30);
            tablaNotaCredito.getColumnModel().getColumn(9).setPreferredWidth(20);
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

        jLabel8.setText("TOTAL NOTA CREDITO:");

        totalTxt.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        totalTxt.setForeground(new java.awt.Color(204, 0, 0));
        totalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTxt.setText("TOTAL");

        terminarBtn.setText("Terminar Nota Credito");
        terminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar NC");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        descuentoGlobalLbl.setText("Descuento:");

        descuentoGlobalTxt.setText("DESCUENTO");

        texto1PieNcTxt.setText("TEXTO 1 PIE FACTURA");

        texto2PieNcTxt.setText("TEXTO 2 PIE FACTURA");

        jLabel15.setText("Massalin:");

        jLabel17.setText("Nobleza:");

        cantidadAtadosMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadAtadosMassalinTxt.setText("Cant Mass");

        cantidadAtadosNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadAtadosNoblezaTxt.setText("Cant Nobl");

        jLabel18.setText("Cant. Items:");

        cantidadItemsTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadItemsTxt.setText("Cantidad Items");

        jLabel9.setText("Importe:");

        importeMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeMassalinTxt.setText("IMP MASS");

        jLabel10.setText("Importe:");

        importeNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeNoblezaTxt.setText("IMP NOBL");

        jLabel3.setText("Número Nota de Crédito:");

        numeroNotaCreditoTxt.setText("jTextField1");

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
                        .addGap(221, 221, 221)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroNotaCreditoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texto1PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texto2PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(33, 33, 33)
                                        .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelarBtn)
                                .addGap(51, 51, 51)
                                .addComponent(terminarBtn)))
                        .addGap(54, 54, 54))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(razonSocialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(descuentoGlobalLbl)
                                .addGap(18, 18, 18)
                                .addComponent(descuentoGlobalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(importeMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(importeNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))))
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
                    .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(numeroNotaCreditoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto1PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto2PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(importeMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(importeNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBtn)
                    .addComponent(terminarBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar la NC?", "Atencion", JOptionPane.YES_NO_OPTION);
        // 0 = si; 1 = no
        if (escape == 0) {
            ReimpresionDocumentoPorClienteFrame rdpcf = new ReimpresionDocumentoPorClienteFrame(cl);
            rdpcf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void terminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBtnActionPerformed
        terminarNotaCredito();
    }//GEN-LAST:event_terminarBtnActionPerformed

    private void codigoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!codigoTxt.getText().isEmpty()) {
                buscar();
                cancelarBtn.setEnabled(true);
            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                MainFrame ff = new MainFrame();
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
            java.util.logging.Logger.getLogger(VerNotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerNotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerNotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerNotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerNotaCreditoFrame(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField cantidadAtadosMassalinTxt;
    private javax.swing.JTextField cantidadAtadosNoblezaTxt;
    private javax.swing.JTextField cantidadItemsTxt;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JLabel descuentoGlobalLbl;
    private javax.swing.JTextField descuentoGlobalTxt;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JTextField importeMassalinTxt;
    private javax.swing.JTextField importeNoblezaTxt;
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numeroNotaCreditoTxt;
    private javax.swing.JTextField razonSocialTxt;
    private javax.swing.JTable tablaNotaCredito;
    private javax.swing.JButton terminarBtn;
    private javax.swing.JTextField texto1PieNcTxt;
    private javax.swing.JTextField texto2PieNcTxt;
    private javax.swing.JTextField totalTxt;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        texto1PieNcTxt.setText("");
        texto2PieNcTxt.setText("");
        cantidadAtadosMassalinTxt.setText("");
        cantidadAtadosNoblezaTxt.setText("");
        ivaTxt.setText("");
        codigoTxt.setText("");
        fechaTxt.setText("");
        razonSocialTxt.setText("");
        totalTxt.setText("");
        totalTxt.setText("0.00");
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        cantidadItemsTxt.setText("");
        descuentoGlobalTxt.setText("");
        importeNoblezaTxt.setText("");
        importeMassalinTxt.setText("");
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
        cantidadItemsTxt.setEnabled(false);
        texto1PieNcTxt.setEnabled(false);
        texto2PieNcTxt.setEnabled(false);
        cantidadAtadosMassalinTxt.setEditable(false);
        cantidadAtadosNoblezaTxt.setEditable(false);
        descuentoGlobalTxt.setEditable(false);
        importeNoblezaTxt.setEditable(false);
        importeMassalinTxt.setEditable(false);
    }

    private void buscar() {
        filtro = "";
        Long id = (long) 1;
        try {
            Configuracion conf = new ConfiguracionService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(VerNotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha = Calendar.getInstance().getTime();
        Cliente cli = new Cliente();
        categoriaIva = 4;
        try {
            clienteNotaCredito = new ClienteService().getClienteByCodigo(codigoTxt.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - cliente");
            Logger.getLogger(VerNotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clienteNotaCredito != null) {
            razonSocialTxt.setText(clienteNotaCredito.getRazonSocial());
            fechaTxt.setText(sdf.format(fecha));
            if (clienteNotaCredito.getCategoriaDeIva() != null) {
                if (clienteNotaCredito.getCategoriaDeIva() == 1) {
                    ivaTxt.setText("Resp. Inscripto");
                }
                if (clienteNotaCredito.getCategoriaDeIva() == 2) {
                    ivaTxt.setText("Monotributo");
                }
                if (clienteNotaCredito.getCategoriaDeIva() == 4) {
                    ivaTxt.setText("Consumidor Final");
                }
                categoriaIva = clienteNotaCredito.getCategoriaDeIva();
            } else {
                ivaTxt.setText("Consumidor Final");
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

    private void terminarNotaCredito() {
        Integer categoriaIva = 0;
        categoriaIva = clienteNotaCredito.getCategoriaDeIva();
        saldoCliente = clienteNotaCredito.getSaldo();
        saldoCliente += totalNotaCredito;
        clienteNotaCredito.setSaldo(saldoCliente);
        sucursalNotaCredito = factura.getNumeroSucursal();
        numeroNotaCredito = factura.getNumeroFactura();
        if (categoriaIva.equals(1)) {
            letraNotaCredito = "A";
            // es inscriptp
        } else {
            letraNotaCredito = "B";
            // el resto de las categorias
        }
        generarNotaCredito();
        ReimpresionDocumentoPorClienteFrame rdpcf = new ReimpresionDocumentoPorClienteFrame(cl);
        rdpcf.setVisible(true);
        this.dispose();
    }

    private void generarNotaCredito() {
        renglones = new String[maxNro];
        textoNotaCreditoPapel = "Nota de Crédito";

        fechaNotaCreditoPapel = sdf.format(fecha);
        clienteNotaCreditoPapel = razonSocialTxt.getText();
        codigoClienteNotaCreditoPapel = clienteNotaCredito.getDomicilio().getNumero();
        direccionNotaCreditoPapel = clienteNotaCredito.getDomicilio().getCalle() + " " + clienteNotaCredito.getDomicilio().getNumero() + " - " + clienteNotaCredito.getDomicilio().getLocalidad();
        cuitNotaCreditoPapel = clienteNotaCredito.getCuit();
        String condVta = "";
        Date fechaVto = fecha;
        Calendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        if (clienteNotaCredito.getFormaDePago().equals(1)) {
            condVta = "CONTADO               ";
        }
        if (clienteNotaCredito.getFormaDePago().equals(2)) {
            condVta = "7 DIAS F.F            ";
            cal.add(Calendar.DATE, 7);
            fechaVto = cal.getTime();
        }
        if (clienteNotaCredito.getFormaDePago().equals(3)) {
            condVta = "14 DIAS F.F.          ";
            cal.add(Calendar.DATE, 14);
            fechaVto = cal.getTime();
        }
        if (clienteNotaCredito.getFormaDePago().equals(4)) {
            condVta = "OTRO                  ";
            fechaVto = null;
        }
        condicionVentaNotaCreditoPapel = condVta;
        vencimientoNotaCreditoPapel = sdf.format(fechaVto);
        String catego = "";
        if (clienteNotaCredito.getCategoriaDeIva().equals(1)) {
            catego = "Responsable Inscripto       ";
        }
        if (clienteNotaCredito.getCategoriaDeIva().equals(2)) {
            catego = "Monotributo                 ";
        }
        if (clienteNotaCredito.getCategoriaDeIva().equals(3)) {
            catego = "Exento                      ";
        }
        if (clienteNotaCredito.getCategoriaDeIva().equals(4)) {
            catego = "Consumidor Final            ";
        }
        inscripcionClienteNotaCreditoPapel = catego;
        if (categoriaIva != 1) {
            //                                    1         2         3         4         5         6         7         8         9        10
            //                           1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
            nombresColumnaNotaCreditoPapel = "  IT CANT                    DETALLE                    P.UNIT.    DESC.   IMPORTE       IMP.     TOTAL     SUG";
        } else {
            nombresColumnaNotaCreditoPapel = "  IT CANT                   DETALLE                   P.UNIT.    DESC.   GRAVADO      IVA       IMP.    TOTAL      SUG";
        }
        DecimalFormat df = new DecimalFormat("#0.00");
        int maxTabla = tablaNotaCredito.getRowCount();
        for (int r = 0; r < maxNro; r++) {
            if (r < maxTabla) {
                String str0 = String.valueOf(r + 1);
                int largo = str0.length();
                if (largo < 2) {
                    renglones[r] = " " + str0 + " ";
                } else {
                    renglones[r] = str0 + " ";
                }
                str0 = tablaNotaCredito.getValueAt(r, 1).toString();
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
                str0 = tablaNotaCredito.getValueAt(r, 2).toString();
                String espacio = " ";
                largo = str0.length();
                if (largo > 42) {
                    str0 = str0.substring(0, 42);
                    tablaNotaCredito.setValueAt(str0, r, 2);
                } else {
                    for (int l = largo; l < 42; l++) {
                        espacio += " ";
                    }
                }
                renglones[r] = renglones[r] + "  " + tablaNotaCredito.getValueAt(r, 2) + espacio;
                if (categoriaIva != 1) {
//                  aqui detalle de importes no inscripto en IVA           *****
// Precio Unitario
                    str0 = tablaNotaCredito.getValueAt(r, 3).toString();
                    str0 = str0.replace(",", ".");
                    Double doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "      ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Descuento
                    str0 = tablaNotaCredito.getValueAt(r, 7).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "     ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Importe
                    str0 = tablaNotaCredito.getValueAt(r, 4).toString();
                    str0 = str0.replace(",", ".");
                    Double calculo = Double.valueOf(str0);
                    str0 = tablaNotaCredito.getValueAt(r, 6).toString();
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
                    str0 = tablaNotaCredito.getValueAt(r, 5).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "       ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//  Total linea
                    str0 = tablaNotaCredito.getValueAt(r, 8).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "      ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Sugerido
                    str0 = tablaNotaCredito.getValueAt(r, 9).toString();
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
                    str0 = tablaNotaCredito.getValueAt(r, 3).toString();
                    str0 = str0.replace(",", ".");
                    Double doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "     ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Descuento
                    str0 = tablaNotaCredito.getValueAt(r, 7).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "     ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Gravado
                    str0 = tablaNotaCredito.getValueAt(r, 4).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "      ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Iva
                    str0 = tablaNotaCredito.getValueAt(r, 6).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "     ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Impuesto
                    str0 = tablaNotaCredito.getValueAt(r, 5).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "       ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//  Total linea
                    str0 = tablaNotaCredito.getValueAt(r, 8).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "      ";
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Sugerido
                    str0 = tablaNotaCredito.getValueAt(r, 9).toString();
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
        String str0 = String.valueOf(saldoCliente - totalNotaCredito);
        str0 = str0.replace(",", ".");
        Double doble = Double.valueOf(str0);
        int largo = doble.intValue();
        String espacio = "          ";
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
        totalDeudaNotaCreditoPapel = espacio + df.format(doble);
// Total Nota de Crédito
        str0 = String.valueOf(totalNotaCredito);
        str0 = str0.replace(",", ".");
        doble = Double.valueOf(str0);
        largo = doble.intValue();
        espacio = "        ";
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
        importeTotalNotaCreditoPapel = espacio + df.format(doble);
// Linea Totales
        if (categoriaIva != 1) {
            str0 = String.valueOf(totalImpuesto);
            str0 = str0.replace(",", ".");
            doble = Double.valueOf(str0);
            largo = doble.intValue();
            espacio = "                                                                            ";
            largo = String.valueOf(largo).length();
            espacio = espacio.substring(largo);
            lineaTotalesNotaCreditoPapel = espacio + df.format(doble);
        } else {
            str0 = String.valueOf(totalGravado);
            str0 = str0.replace(",", ".");
            doble = Double.valueOf(str0);
            largo = doble.intValue();
            espacio = "           ";
            largo = String.valueOf(largo).length();
            espacio = espacio.substring(largo);
            lineaTotalesNotaCreditoPapel = espacio + df.format(doble);
            str0 = String.valueOf(totalImpuesto);
            str0 = str0.replace(",", ".");
            doble = Double.valueOf(str0);
            largo = doble.intValue();
            espacio = "           ";
            largo = String.valueOf(largo).length();
            espacio = espacio.substring(largo);
            lineaTotalesNotaCreditoPapel += espacio + df.format(doble);
            str0 = String.valueOf(totalIva);
            str0 = str0.replace(",", ".");
            doble = Double.valueOf(str0);
            largo = doble.intValue();
            espacio = "                                 ";
            largo = String.valueOf(largo).length();
            espacio = espacio.substring(largo);
            lineaTotalesNotaCreditoPapel += espacio + df.format(doble);
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
        totalPagarNotaCreditoPapel = espacio + df.format(doble);
// Cantidades atados
        cantidadesNotaCreditoPapel = "                  CANT.ATADOS NOBLEZA: " + String.valueOf(cantidadAtadosNobleza);
        cantidadesNotaCreditoPapel += "                 CANT ATADOS MASSALIN: " + String.valueOf(cantidadAtadosMassalin);
        texto1NotaCreditoPapel = texto1PieNcTxt.getText();
        texto2NotaCreditoPapel = texto2PieNcTxt.getText();
        texto3NotaCreditoPapel = "-";
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
        totalNotaCredito = 0.0;
        nro = 0;
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        Double importeTotalMassalin = 0.0;
        Double importeTotalNobleza = 0.0;
        for (RenglonNotaCredito renFa : renglonNotaCredito) {
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
        totalNotaCredito = factura.getTotal();
        totalTxt.setText(String.valueOf(df.format(totalNotaCredito)));
    }

    private void cargarDatos() {
        // CLIENTE SELECCIONADO Y FACTURA
        limpiarCampos();
        codigoTxt.setText(clienteSeleccionado.getCodigo());
        razonSocialTxt.setText(clienteSeleccionado.getRazonSocial());
        Long id = (long) 1;
        try {
            Configuracion conf = new ConfiguracionService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(VerNotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sd2 = new SimpleDateFormat("yyyyMMdd");
        fecha = factura.getFecha();
        texto1Cae = factura.getCae().toString();
        vencCae = sd2.format(factura.getFechaCae());
        String cuit = factura.getCliente().getCuit();
        cuit1 = cuit.substring(0, 2) + cuit.substring(3, 11) + cuit.substring(12, 13);
        if (factura.getTextoPieFactura1() != null) {
            if (factura.getTextoPieFactura2() != null) {
                if (!factura.getTextoPieFactura1().isEmpty()) {
                    texto1PieNcTxt.setText(factura.getTextoPieFactura1());
                }
                if (!factura.getTextoPieFactura2().isEmpty()) {
                    texto2PieNcTxt.setText(factura.getTextoPieFactura2());
                }
            } else {
                if (!factura.getTextoPieFactura1().isEmpty()) {
                    texto1PieNcTxt.setText(factura.getTextoPieFactura1());
                }
            }
        } else {
            if (factura.getTextoPieFactura2() != null) {
                if (!factura.getTextoPieFactura2().isEmpty()) {
                    texto2PieNcTxt.setText(factura.getTextoPieFactura2());
                }
            }
        }
        numeroNotaCreditoTxt.setText(String.valueOf(factura.getNumeroFactura()));
        categoriaIva = 4;
        clienteNotaCredito = clienteSeleccionado;
        fechaTxt.setText(sdf.format(fecha));
        if (clienteNotaCredito.getCategoriaDeIva() != null) {
            if (clienteNotaCredito.getCategoriaDeIva() == 1) {
                ivaTxt.setText("Resp. Inscripto");
            }
            if (clienteNotaCredito.getCategoriaDeIva() == 2) {
                ivaTxt.setText("Monotributo");
            }
            if (clienteNotaCredito.getCategoriaDeIva() == 4) {
                ivaTxt.setText("Consumidor Final");
            }
            categoriaIva = clienteNotaCredito.getCategoriaDeIva();
        } else {
            ivaTxt.setText("Consumidor Final");
        }
        cancelarBtn.setEnabled(true);
        codigoTxt.setEditable(false);
        totalTxt.setEnabled(true);
        totalTxt.setEditable(false);
    }

    private void cargarRenglones() {
        try {
            renglonF = new RenglonNotaCreditoService().getAllRenglonNotaCreditoFromIvaVentas(factura);
            tabla = (DefaultTableModel) tablaNotaCredito.getModel();
            for (RenglonNotaCredito rp : renglonF) {
                RenglonNotaCredito rf = new RenglonNotaCredito();
                rf.setCantidad(rp.getCantidad());
                rf.setProducto(rp.getProducto());
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
                renglonNotaCredito.add(rf);
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
                tablaNotaCredito.setModel(tabla);
            }
            cancelarBtn.setEnabled(true);
            codigoTxt.setEditable(false);
            totalTxt.setEnabled(true);
            totalTxt.setEditable(false);
            calcularTotales();
            cancelarBtn.setEnabled(true);
            terminarBtn.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(VerNotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
            g2.setFont(new Font("Monospaced", Font.PLAIN, 14));
            String espacio = "                              ";
            g2.drawString(espacio + letraNotaCredito, 30, row);
            espacio = "                                                         ";
            g2.setFont(new Font("Monospaced", Font.BOLD, 9));
            g2.drawString(espacio + textoNotaCreditoPapel, 30, row);
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
            //         123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
            espacio = "                                                                           ";
            g2.drawString(espacio + " "
                    + dfs.format(sucursalNotaCredito) + "-"
                    + dfn.format(numeroNotaCredito), 30, row);
            row += 15;
            g2.setFont(new Font("Monospaced", Font.PLAIN, 6));
            if (letraNotaCredito.equals("A")) {
                g2.drawString("Cód.Nro.:03", 271, 53);
            } else {
                g2.drawString("Cód.Nro.:08", 271, 53);
            }
            g2.setFont(new Font("Monospaced", Font.PLAIN, 8));
            g2.drawString(espacio + fechaNotaCreditoPapel, 30, row);
            espacio = "            ";
            row += 50;
            g2.drawString(espacio + clienteNotaCreditoPapel, 30, row);
            g2.drawString(codigoClienteNotaCreditoPapel, 480, row);
            row += 15;
            espacio = "            ";
            g2.drawString(espacio + direccionNotaCreditoPapel, 30, row);
            row += 15;
            g2.drawString(cuitNotaCreditoPapel, 100, row);
            g2.drawString(inscripcionClienteNotaCreditoPapel, 360, row);
            row += 25;
            g2.drawString(condicionVentaNotaCreditoPapel, 150, row);
            g2.drawString("Ref.Interna:" + letraNotaCredito + " " + sucursalNotaCredito
                    + "-" + numeroNotaCredito, 350, row);
            //g2.drawString(vencimientoNotaCreditoPapel, 400, row);
            row += 25;
            g2.drawString(nombresColumnaNotaCreditoPapel, 30, row);
            row += 15;
            for (int x = 0; x < maxNro; x++) {
                if (renglones[x] != null) {
                    g2.drawString(renglones[x], 40, row);
                }
                row += 10;
            }
            row += 12;
            if (categoriaIva == 1) {
                g2.drawString("Gravado       "
                        + "Impuesto                            "
                        + " Iva                            Total Nota de Crédito", 70, row);
            } else {
                g2.drawString("                                "
                        + "Impuesto          "
                        + "Total Nota de Crédito", 220, row);
                //
            }
            row += 12;
            g2.drawString(lineaTotalesNotaCreditoPapel, 30, row);
            g2.setFont(new Font("Monospaced", Font.BOLD, 11));
            g2.drawString(importeTotalNotaCreditoPapel, 490, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            row += 21;
            //g2.drawString("SALDO ANTERIOR: " + totalDeudaNotaCreditoPapel, 403, row);
            //row += 10;
            //g2.drawString("SALDO TOTAL:    " + totalPagarNotaCreditoPapel, 403, row);
            //row += 10;
            espacio = "     ";
            g2.setFont(new Font("Monospaced", Font.BOLD, 9));
            g2.drawString(espacio + texto1NotaCreditoPapel, 30, row);
            row += 10;
            g2.drawString(espacio + texto2NotaCreditoPapel, 30, row);
            row += 10;
            g2.drawString(espacio + texto3NotaCreditoPapel, 30, row);
            row += 15;
//            g2.drawString(espacio + texto4FacturaPapel, 30, row);
//            
            g2.drawString(cantidadesNotaCreditoPapel, 30, row);
            row += 20;
            String tipo_cbte = "3";
            if (letraNotaCredito.equals("B")) {
                tipo_cbte = "8";
            }
            g2.drawString(" CAE " + texto1Cae + "  Venc. CAE " + vencCae, 30, row);
            g2.setFont(new Font("PF Interleavev 2 of 5 Text", Font.PLAIN, 18));
            int x = 0;
            Integer suma1 = 0;
            Integer suma2 = 0;
//            System.out.println(cuit1);
//            System.exit(0);
            String vCae = sdfCae.format(factura.getFechaCae());
            String cadena = cuit1 + "0" + tipo_cbte + "0005" + texto1Cae + vCae;
            for (int i = 0; i < 39; i++) {
                if (x == 0) {
                    //System.out.println(cadena.substring(i, i + 1).toString());
                    int num = Integer.valueOf(cadena.substring(i, i + 1).toString());
                    suma1 += num;
                    x = 1;
                } else {
                    //System.out.println(cadena.substring(i, i + 1).toString());
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
            g2.drawString("           " + texto2Cae, 160, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            return PAGE_EXISTS;
        }
    }
}
