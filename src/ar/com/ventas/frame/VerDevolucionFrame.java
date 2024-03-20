/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.ClienteTraba;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.CustomerTraba;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rental;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ClienteTrabaService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.CustomerService;
import ar.com.ventas.services.CustomerTrabaService;
import ar.com.ventas.services.ProductoService;
import ar.com.ventas.services.RentalService;
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
public class VerDevolucionFrame extends javax.swing.JFrame {

    public List<Rental> renglonNotaCredito = new ArrayList<Rental>();
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
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    ;
    private Cliente clienteNotaCredito = null;
    private Customer clienteNC = null;
    private Producto producto = null;
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
    private Float porcentualDescuen = 0F;
    private Double descuen = 0.0;
    private Producto productoSeleccionado;
    private Float cantidad;
    private Integer categoriaIva = 1;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat df1 = new DecimalFormat("#0.0");
    private Double saldoCliente = 0.00;
    private String filtro = "";
    private String letraNotaCredito;
    private Integer sucursalNotaCredito;
    private Integer numeroNotaCredito;
    private Routines config = null;
    private Double precioFinal = 0.0;
    private Integer nro = 0;
    private Integer maxNro = 41;
    private Integer cantidadAtadosMassalin;
    private Integer cantidadAtadosNobleza;
    public Boolean encontrado;
    private Activity factura;
    private List<Rental> renglonF = null;
    private int traba = 0;

    /**
     * Creates new form NotaCreditoFrame
     *
     * @param fac
     */
    public VerDevolucionFrame(Activity fac, Cliente cl) {
        getContentPane().setBackground(new java.awt.Color(255, 250, 205));
        initComponents();
        this.setLocationRelativeTo(null);
        this.factura = fac;
        this.clienteNotaCredito = cl;
        clienteNC = factura.getCustomer();
        bloquearCampos();
//      levanto el modelo creado del frame
        DefaultTableModel tabla = (DefaultTableModel) tablaNotaCredito.getModel();
        limpiarCampos();
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
        jLabel11 = new javax.swing.JLabel();
        numeroNotaCreditoTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descuentoVolumenTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Nc. A y M");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tablaNotaCredito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cant", "Detalle", "P.Unit", "Gravado", "Impuesto", "IVA", "dto.", "SubTotal", "Sug."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        jLabel8.setText("TOTAL:");

        totalTxt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        totalTxt.setForeground(new java.awt.Color(255, 0, 0));
        totalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTxt.setText("TOTAL");

        terminarBtn.setText("Terminar Devolución");
        terminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar Devolución");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        descuentoGlobalLbl.setText("Descuento:");

        descuentoGlobalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoGlobalTxt.setText("DESCU");

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
        cantidadItemsTxt.setText("Nro Itm");

        jLabel9.setText("Importe:");

        importeMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeMassalinTxt.setText("IMP MASS");

        jLabel10.setText("Importe:");

        importeNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeNoblezaTxt.setText("IMP NOBL");

        jLabel11.setText("Número Devolución:");

        numeroNotaCreditoTxt.setText("Num Devolución");

        jLabel3.setText("DESCUENTO:");

        descuentoVolumenTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoVolumenTxt.setText("DESCU");

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
                        .addGap(87, 87, 87)
                        .addComponent(razonSocialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(descuentoGlobalLbl)
                        .addGap(18, 18, 18)
                        .addComponent(descuentoGlobalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numeroNotaCreditoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(texto2PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(texto1PieNcTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(85, 85, 85)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel3))
                                        .addGap(28, 28, 28))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(importeMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(importeNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cancelarBtn)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(terminarBtn)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                    .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(numeroNotaCreditoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto1PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto2PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel9)
                    .addComponent(importeMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(importeNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBtn)
                    .addComponent(terminarBtn)
                    .addComponent(jLabel18)
                    .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar la Devolucion?", "Atencion", JOptionPane.YES_NO_OPTION);
        // 0 = si; 1 = no
        if (escape == 0) {
            ReimpresionDocumentoPorClienteFrame rpcf = new ReimpresionDocumentoPorClienteFrame(clienteNotaCredito);
            rpcf.setVisible(true);
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
            java.util.logging.Logger.getLogger(VerDevolucionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerDevolucionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerDevolucionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerDevolucionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new VerDevolucionFrame(null, null).setVisible(true);
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
    private javax.swing.JTextField descuentoVolumenTxt;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JTextField importeMassalinTxt;
    private javax.swing.JTextField importeNoblezaTxt;
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
        importeMassalinTxt.setText("");
        importeNoblezaTxt.setText("");
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
        importeMassalinTxt.setEditable(false);
        importeNoblezaTxt.setEditable(false);
    }

    private void buscar() {
        filtro = "";
        Long id = (long) 1;
        try {
            Routines conf = new RoutinesService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(VerDevolucionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecha = Calendar.getInstance().getTime();
        Cliente cli = new Cliente();
        categoriaIva = 2;
        try {
            clienteNotaCredito = new ClienteService().getClienteByCodigo(codigoTxt.getText());
            clienteNC = new CustomerService().getCustomerByCodigo(codigoTxt.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - cliente");
            Logger.getLogger(VerDevolucionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clienteNotaCredito != null) {
            String codigo = clienteNotaCredito.getCodigo();
            CustomerTraba cuTr = null;
            ClienteTraba ct = null;
            try {
                ct = new ClienteTrabaService().getClienteByCodigo(codigo);
                cuTr = new CustomerTrabaService().getClienteByCodigo(codigo);
            } catch (Exception ex) {
                Logger.getLogger(VerCuentaCorrienteClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (ct.getTraba1() != null) {
                if (ct.getTraba1()) {
                    JOptionPane.showMessageDialog(this, "Cliente bloqueado para esta Operación");
                    codigoTxt.requestFocus();
                    return;
                }
            }
            if (cuTr.getTraba2() != null) {
                if (cuTr.getTraba2()) {
                    JOptionPane.showMessageDialog(this, "Cliente bloqueado para esta Operación");
                    codigoTxt.requestFocus();
                    return;
                }
            }
            razonSocialTxt.setText(clienteNotaCredito.getRazonSocial());
            fechaTxt.setText(sdf.format(fecha));
            ivaTxt.setText("--");
            if (clienteNotaCredito.getSaldo() != null) { //cliente
                if (clienteNC.getSaldo() != null) { //customer
                    saldoCliente = clienteNotaCredito.getSaldo() + clienteNC.getSaldo();
                } else {
                    saldoCliente = clienteNotaCredito.getSaldo();
                    clienteNC.setSaldo(0.0);
                    try {
                        new CustomerService().updateCustomer(clienteNC);
                    } catch (Exception ex) {
                        Logger.getLogger(VerDevolucionFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                clienteNotaCredito.setSaldo(0.0);
                try {
                    new ClienteService().updateCliente(clienteNotaCredito);
                } catch (Exception ex) {
                    Logger.getLogger(VerDevolucionFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (clienteNC.getSaldo() != null) {
                    saldoCliente = clienteNC.getSaldo();
                } else {
                    saldoCliente = 0.0;
                    clienteNC.setSaldo(0.0);
                    try {
                        new CustomerService().updateCustomer(clienteNC);
                    } catch (Exception ex) {
                        Logger.getLogger(VerDevolucionFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            Boolean terminar = false;
            cancelarBtn.setEnabled(true);
            codigoTxt.setEditable(false);
            totalTxt.setEnabled(true);
            totalTxt.setEditable(false);
            agregarProducto();
        } else {
            JOptionPane.showMessageDialog(this, "Error - cliente no existe");
            codigoTxt.requestFocus();

        }
    }

    private void terminarNotaCredito() {
        Integer categoriaIva = 0;
        categoriaIva = clienteNotaCredito.getCategoriaDeIva();
        //saldoCliente = clienteNotaCredito.getSaldo() + clienteNC.getSaldo();
        //Double saldoCalculo = totalNotaCredito + saldoCliente;
        //clienteNotaCredito.setSaldo(saldoCliente);
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
        ReimpresionDocumentoPorClienteFrame rpcf = new ReimpresionDocumentoPorClienteFrame(clienteNotaCredito);
        rpcf.setVisible(true);
        this.dispose();
    }

    private void generarNotaCredito() {
        renglones = new String[maxNro];
        textoNotaCreditoPapel = "Devolución";
        fechaNotaCreditoPapel = sdf.format(fecha);
        clienteNotaCreditoPapel = razonSocialTxt.getText();
        codigoClienteNotaCreditoPapel = clienteNotaCredito.getCodigo();
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
//        if (categoriaIva != 1) {
//            //                                    1         2         3         4         5         6         7         8         9        10
//            //                           1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
//            nombresColumnaNotaCreditoPapel = "  IT CANT                    DETALLE                    P.UNIT.    DESC.   IMPORTE       IMP.     TOTAL     SUG";
//        } else {
            nombresColumnaNotaCreditoPapel = "IT  CANT                  DETALLE                  P.UNIT.     DESC.      IMPORTE       IMP.        TOTAL       SUG";
//        }
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
                    renglones[r] = renglones[r] + "    " + str0;
                }
                if (largo == 2) {
                    renglones[r] = renglones[r] + "   " + str0;
                }
                if (largo == 3) {
                    renglones[r] = renglones[r] + "  " + str0;
                }
                if (largo == 4) {
                    renglones[r] = renglones[r] + " " + str0;
                }
                if (largo == 5) {
                    renglones[r] = renglones[r] + str0;
                }
                str0 = tablaNotaCredito.getValueAt(r, 2).toString();
                String espacio = " ";
                largo = str0.length();
                if (largo > 38) {
                    str0 = str0.substring(0, 38);
                    tablaNotaCredito.setValueAt(str0, r, 2);
                } else {
                    for (int l = largo; l < 38; l++) {
                        espacio += " ";
                    }
                }
                renglones[r] = renglones[r] + " " + tablaNotaCredito.getValueAt(r, 2) + espacio;
                if (categoriaIva != 1) {
//                  aqui detalle de importes no inscripto en IVA           *****
// Precio Unitario
                    str0 = tablaNotaCredito.getValueAt(r, 3).toString();
                    str0 = str0.replace(",", ".");
                    Double doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "        "; // 9
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(-doble) + " ";
// Descuento
                    str0 = tablaNotaCredito.getValueAt(r, 7).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "      "; // 6
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
                    espacio = "         "; // 9
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Impuesto
                    str0 = tablaNotaCredito.getValueAt(r, 5).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "       "; // 7
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(-doble) + " ";
//  Total linea
                    str0 = tablaNotaCredito.getValueAt(r, 8).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "         "; // 9
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Sugerido
                    str0 = tablaNotaCredito.getValueAt(r, 9).toString();
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "       "; // 7
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                    renglones[r] = renglones[r] + espacio + df.format(-doble) + " ";
//                } else {
//                    // aqui detalle importes inscripto
//// Precio Unitario
//                    str0 = tablaNotaCredito.getValueAt(r, 3).toString();
//                    str0 = str0.replace(",", ".");
//                    Double doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "     ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//// Descuento
//                    str0 = tablaNotaCredito.getValueAt(r, 7).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "     ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//// Gravado
//                    str0 = tablaNotaCredito.getValueAt(r, 4).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "      ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//// Iva
//                    str0 = tablaNotaCredito.getValueAt(r, 6).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "     ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//// Impuesto
//                    str0 = tablaNotaCredito.getValueAt(r, 5).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "       ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
////  Total linea
//                    str0 = tablaNotaCredito.getValueAt(r, 8).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "      ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//// Sugerido
//                    str0 = tablaNotaCredito.getValueAt(r, 9).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "    ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
                }
            } else {
                // agregar renglon en blanco
                renglones[r] = " ";
            }
        }
// Saldo Cliente
        String str0 = String.valueOf(saldoCliente);
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
        Double totalPagar = saldoCliente + totalNotaCredito;
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

    private void agregarProducto() {
        if (nro > 0) {
            terminarBtn.setEnabled(true);
        } else {
            terminarBtn.setEnabled(false);
        }
        if (nro > 0) {
            cancelarBtn.setEnabled(true);
        }
    }

    private void borrarTablaProductos() {
        int cantidadRow = tablaNotaCredito.getRowCount();
        DefaultTableModel model1 = (DefaultTableModel) tablaNotaCredito.getModel();
        if (cantidadRow > 0) {
            for (int i = 0; i < cantidadRow; i++) {
                model1.removeRow(0);
            }
            tablaNotaCredito.setModel(model1);
            nro = 0;
        }
        renglonNotaCredito = new ArrayList<Rental>();
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
        for (Rental renFa : renglonNotaCredito) {
            totalGravado += renFa.getGravado();
            int codi = renFa.getCodigoProducto();
            Producto produ = null;
            try {
                produ = new ProductoService().getProductoByCodigo(codi);
            } catch (Exception ex) {
                Logger.getLogger(VerDevolucionFrame.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            if (produ.getRubro().getCodigo().equals(1)) {
                cantidadAtadosMassalin += renFa.getCantidad().intValue();
                importeTotalMassalin += renFa.getTotal();
            }
            cantidadAtadosMassalinTxt.setText(String.valueOf(cantidadAtadosMassalin));
            importeMassalinTxt.setText(String.valueOf(df.format(importeTotalMassalin)));
            if (produ.getRubro().getCodigo().equals(2)) {
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
        totalNotaCredito = rint((totalGravado + totalImpuesto + totalIva) * 100) / 100;
        totalTxt.setText(String.valueOf(df.format(totalNotaCredito)));
    }

    private void cargarDatos() {
        // CLIENTE SELECCIONADO Y FACTURA
        codigoTxt.setText(clienteNC.getCodigo());
        String cod = clienteNC.getCodigo();
        razonSocialTxt.setText(clienteNotaCredito.getRazonSocial());
        Long id = (long) 1;
        try {
            Configuracion conf = new ConfiguracionService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(VerDevolucionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecha = factura.getFecha();
        categoriaIva = 4;
        clienteNotaCredito = clienteNotaCredito;
        numeroNotaCreditoTxt.setText(String.valueOf(factura.getNumeroFactura()));
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
        if (factura.getPorcentajeDescuentoGlobal() != null) {
            if (factura.getPorcentajeDescuentoGlobal() > 0) {
                descuentoGlobalTxt.setText(df1.format(factura.getPorcentajeDescuentoGlobal()));
                tieneDto = true;
                descuen = factura.getDescuentoGlobal();
            } else {
                descuentoGlobalTxt.setText("0.0");
                tieneDto = false;
                descuen = 0.0;
            }
        } else {
            descuentoGlobalTxt.setText("0.0");
            tieneDto = false;
            descuen = 0.0;
        }
        texto1PieNcTxt.setText(factura.getTextoPieFactura1());
        texto2PieNcTxt.setText(factura.getTextoPieFactura2());
        cancelarBtn.setEnabled(true);
        codigoTxt.setEditable(false);
        totalTxt.setEnabled(true);
        totalTxt.setEditable(false);
    }

    private void cargarRenglones() {
        try {
            renglonF = new RentalService().getRentalFromActivity(factura);
            DefaultTableModel tabla = (DefaultTableModel) tablaNotaCredito.getModel();
            for (Rental rp : renglonF) {
                Rental rf = new Rental();
                rf.setCantidad(rp.getCantidad());
                rf.setCodigoProducto(rp.getCodigoProducto());
                rf.setItemNro(rp.getItemNro());
                rf.setDescripcion(rp.getDescripcion());
                rf.setGravado(-rp.getGravado());
                rf.setNoGravado(-rp.getNoGravado());
                rf.setExento(-rp.getExento());
                rf.setImpuesto(-rp.getImpuesto());
                rf.setDescuento(-rp.getDescuento());
                rf.setIva(-rp.getIva());
                rf.setTotal(-rp.getTotal());
                rf.setSugerido(-rp.getSugerido());
                renglonNotaCredito.add(rf);
                Object linea[] = new Object[10];
                linea[0] = rp.getCodigoProducto();
                linea[1] = rp.getCantidad().intValue();
                linea[2] = rp.getDescripcion();
                Double col_3 = (rp.getGravado() + rp.getImpuesto() + rp.getIva()) / rp.getCantidad();
                Double col_4 = rp.getGravado();
                Double col_5 = rp.getImpuesto();
                Double col_6 = rp.getIva();
                Double col_8 = rp.getTotal();
                Double col_9 = rp.getSugerido();
                if(col_3 < 0){
                    col_3 = col_3 * -1;
                }
                if(col_4 < 0){
                    col_4 = col_4 * -1;
                }
                if(col_5 < 0){
                    col_5 = col_5 * -1;
                }
                if(col_6 < 0){
                    col_6 = col_6 * -1;
                }
                if(col_8 < 0){
                    col_8 = col_8 * -1;
                }
                if(col_9 < 0){
                    col_9 = col_9 * -1;
                }
                linea[3] = df.format(col_3);
                linea[4] = df.format(col_4);
                linea[5] = df.format(col_5);
                linea[6] = df.format(col_6);
                linea[7] = df.format(0.00);
                linea[8] = df.format(col_8);
                linea[9] = df.format(col_9);
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
            Logger.getLogger(VerDevolucionFrame.class.getName()).log(Level.SEVERE, null, ex);
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
            g2.drawString(espacio + textoNotaCreditoPapel, 30, row);
            row += 25;
            //         123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
            espacio = "                                                                           ";
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
            g2.drawString("Ref.Interna:" + letraNotaCredito + " " + sucursalNotaCredito + "-" + numeroNotaCredito, 350, row);
            //g2.drawString(vencimientoNotaCreditoPapel, 400, row);
            row += 25;
            g2.drawString(nombresColumnaNotaCreditoPapel, 30, row);
            row += 15;
            for (int x = 0; x < maxNro; x++) {
                if (renglones[x] != null) {
                    g2.drawString(renglones[x], 30, row);
                }
                row += 10;
            }
            row += 40;
            g2.drawString(lineaTotalesNotaCreditoPapel, 30, row);
            g2.setFont(new Font("Monospaced", Font.BOLD, 11));
            g2.drawString(importeTotalNotaCreditoPapel, 490, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 9));
            row += 21;
//            g2.drawString("SALDO ANTERIOR: " + totalDeudaNotaCreditoPapel, 403, row);
//            row += 10;
//            g2.drawString("SALDO TOTAL:    " + totalPagarNotaCreditoPapel, 403, row);
//            row += 10;
            espacio = "     ";
            g2.drawString(espacio + texto1NotaCreditoPapel, 30, row);
            row += 10;
            g2.drawString(espacio + texto2NotaCreditoPapel, 30, row);
            row += 10;
            g2.drawString(espacio + texto3NotaCreditoPapel, 30, row);
            row += 15;
//            g2.drawString(espacio + texto4FacturaPapel, 30, row);
//            row += 20;
            g2.drawString(cantidadesNotaCreditoPapel, 30, row);
            return PAGE_EXISTS;
        }
    }
}
