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
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.CustomerTraba;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rental;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ActivityRowService;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ClienteTrabaService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.CustomerService;
import ar.com.ventas.services.CustomerTrabaService;
import ar.com.ventas.services.InventoryService;
import ar.com.ventas.services.NotaCreditoService;
import ar.com.ventas.services.ProductoService;
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
public class NotaCreditoDeFacturaFrame extends javax.swing.JFrame {

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
    private Cliente clienteNotaCredito = null;
    private Customer clienteNC = null;
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
    private Double descuento = 0.0;
    private Cliente clienteSeleccionado;
    private Producto productoSeleccionado;
    private Float cantidad;
    private Integer categoriaIva = 4;
    //private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat df = new DecimalFormat("#0.00");
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
    private List<ActivityRow> renglonF = null;

    /**
     * Creates new form NotaCreditoFrame
     *
     * @param cli
     * @param fac
     */
    public NotaCreditoDeFacturaFrame(Cliente cli, Activity fac) {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(255, 250, 205));
        this.setLocationRelativeTo(null);
        this.clienteSeleccionado = cli;
        this.factura = fac;
        bloquearCampos();
        imprimeCbx.setSelected(true);
//      levanto el modelo creado del frame
        tabla = (DefaultTableModel) tablaNotaCredito.getModel();
        String cod = clienteSeleccionado.getCodigo();
        ClienteTraba ct = null;
        try {
            ct = new ClienteTrabaService().getClienteByCodigo(cod);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ct.getTraba1() != null) {
            if (ct.getTraba1()) {
                JOptionPane.showMessageDialog(this, "Cliente bloqueado para esta Operación");
                volver();
            }
        }
        CustomerTraba cuTr = null;
        try {
            cuTr = new CustomerTrabaService().getClienteByCodigo(cod);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (cuTr.getTraba2() != null) {
            if (cuTr.getTraba2()) {
                JOptionPane.showMessageDialog(this, "Cliente bloqueado para esta Operación");
                volver();
            }
        }
        if (clienteSeleccionado == null && fac == null) {
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "No se pudo importar el Presupuesto solicitado");
            volver();
        } else {
            cargarDatos();
            cargarRenglones();
            bloquearCliente();
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
        tablaNotaCredito = new javax.swing.JTable();
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
        texto1PieNcTxt = new javax.swing.JTextField();
        texto2PieNcTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cantidadAtadosMassalinTxt = new javax.swing.JTextField();
        cantidadAtadosNoblezaTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cantidadItemsTxt = new javax.swing.JTextField();
        borrarNoSeleccionadoBtn = new javax.swing.JButton();
        leerCantidadBtn = new javax.swing.JButton();
        nuevaCantidadTxt = new javax.swing.JTextField();
        grabarCantidadBtn = new javax.swing.JButton();
        leerPrecioBtn = new javax.swing.JButton();
        nuevoPrecioTxt = new javax.swing.JTextField();
        grabarPrecioBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        totalMassalinTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        totalNoblezaTxt = new javax.swing.JTextField();
        imprimeCbx = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        descuentoGlobalTxt = new javax.swing.JTextField();
        descuentoVolumenTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DEVOLUCION A y M");
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

        jLabel3.setText("Saldo:");

        jLabel4.setText("Fecha:");

        codigoTxt.setText("CODIGO");
        codigoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoTxtKeyPressed(evt);
            }
        });

        razonSocialTxt.setText("RAZON SOCIAL");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");

        ivaTxt.setText("IVA");

        saldoTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        saldoTxt.setForeground(new java.awt.Color(0, 0, 204));
        saldoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        saldoTxt.setText("SALDO");

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

        cancelarBtn.setText("Canc. Devol.");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

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

        borrarNoSeleccionadoBtn.setText("Devolver Seleccionado");
        borrarNoSeleccionadoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarNoSeleccionadoBtnActionPerformed(evt);
            }
        });

        leerCantidadBtn.setText("Leer Cantidad");
        leerCantidadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerCantidadBtnActionPerformed(evt);
            }
        });

        nuevaCantidadTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nuevaCantidadTxt.setText("NUEV CANT");

        grabarCantidadBtn.setText("Grabar Cantidad");
        grabarCantidadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarCantidadBtnActionPerformed(evt);
            }
        });

        leerPrecioBtn.setText("Leer Precio");
        leerPrecioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerPrecioBtnActionPerformed(evt);
            }
        });

        nuevoPrecioTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nuevoPrecioTxt.setText("NUEV PREC");

        grabarPrecioBtn.setText("Grabar Precio");
        grabarPrecioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarPrecioBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Importe:");

        totalMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalMassalinTxt.setText("Total Mass");

        jLabel6.setText("Importe:");

        totalNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalNoblezaTxt.setText("Total Nobl");

        imprimeCbx.setText("Imprime");

        jLabel7.setText("Descuento:");

        descuentoGlobalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoGlobalTxt.setText("DESC");

        descuentoVolumenTxt.setText("TOT DESC");

        jLabel9.setText("Descuento:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(borrarNoSeleccionadoBtn)
                        .addGap(864, 864, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(texto1PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texto2PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(imprimeCbx)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelarBtn)
                                .addGap(65, 122, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(saldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(309, 309, 309)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(leerPrecioBtn)
                                                .addGap(18, 18, 18)
                                                .addComponent(nuevoPrecioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(leerCantidadBtn)
                                                .addGap(18, 18, 18)
                                                .addComponent(nuevaCantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(grabarCantidadBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(grabarPrecioBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel18)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47))))
                    .addGroup(layout.createSequentialGroup()
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
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(descuentoGlobalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(terminarBtn)
                .addGap(71, 71, 71))
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
                    .addComponent(jLabel7)
                    .addComponent(descuentoGlobalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrarNoSeleccionadoBtn)
                    .addComponent(leerCantidadBtn)
                    .addComponent(nuevaCantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grabarCantidadBtn)
                    .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leerPrecioBtn)
                    .addComponent(nuevoPrecioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grabarPrecioBtn)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto1PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto2PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBtn)
                    .addComponent(imprimeCbx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(totalMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(totalNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminarBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar la Devolución?", "Atencion", JOptionPane.YES_NO_OPTION);
        // 0 = si; 1 = no
        if (escape == 0) {
            volver();
        } else {
            //nombreProductoConsultaTxt.setEnabled(false);
            grabarPrecioBtn.setEnabled(false);
            leerPrecioBtn.setEnabled(true);
            nuevoPrecioTxt.setEnabled(true);
            borrarNoSeleccionadoBtn.setEnabled(true);
            terminarBtn.setEnabled(true);
            tablaNotaCredito.setEnabled(true);
            leerCantidadBtn.setEnabled(true);
            nuevaCantidadTxt.setText("");
            nuevoPrecioTxt.setText("");
            grabarCantidadBtn.setEnabled(false);
        }
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void terminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Quiere ingresar un texto antes de Imprimir?",
                "Texto en el pie de Devolución",
                JOptionPane.YES_NO_OPTION);
        if (escape == 0) {
            texto1PieNcTxt.setEnabled(true);
            texto2PieNcTxt.setEnabled(true);
            texto1PieNcTxt.requestFocus();
        } else {
            terminarNotaCredito();
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
                MainFrame ff = new MainFrame();
                ff.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_codigoTxtKeyPressed

    private void borrarNoSeleccionadoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarNoSeleccionadoBtnActionPerformed
        borrarNoSeleccionado();
    }//GEN-LAST:event_borrarNoSeleccionadoBtnActionPerformed

    private void leerCantidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerCantidadBtnActionPerformed
        int lin = tablaNotaCredito.getSelectedRow();
        if (lin > -1) {
            Rental rf = renglonNotaCredito.get(lin);
            nuevaCantidadTxt.setText(String.valueOf(rf.getCantidad().intValue()));
            leerCantidadBtn.setEnabled(false);
            grabarCantidadBtn.setEnabled(true);
            grabarPrecioBtn.setEnabled(false);
            leerPrecioBtn.setEnabled(false);
            nuevoPrecioTxt.setEnabled(false);
            borrarNoSeleccionadoBtn.setEnabled(false);
            terminarBtn.setEnabled(false);
            tablaNotaCredito.setEnabled(false);
        }

    }//GEN-LAST:event_leerCantidadBtnActionPerformed

    private void grabarCantidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarCantidadBtnActionPerformed
        int lin = tablaNotaCredito.getSelectedRow();
        if (lin > -1) {
            if (!nuevaCantidadTxt.getText().isEmpty()) {
                leerCantidadBtn.setEnabled(true);
                grabarCantidadBtn.setEnabled(false);
                Rental rf = renglonNotaCredito.get(lin);
                Float cantidadAnterior = rf.getCantidad();
                Float cant = Float.valueOf(nuevaCantidadTxt.getText());
                if (!(cant > 0.0)) {
                    JOptionPane.showMessageDialog(this, "Debe colocar cantidad mayor que cero");
                    return;
                }
                if (cant > cantidadAnterior) {
                    JOptionPane.showMessageDialog(this, "Esta colocando una cantidad Mayor");
                    nuevaCantidadTxt.requestFocus();
                    return;
                } else {
                    rf.setCantidad(cant);
                }
                Double precioUnitario = rf.getGravado() / cantidadAnterior;
                Double impuestoUnitario = rf.getImpuesto() / cantidadAnterior;
                renglonNotaCredito.set(lin, rf);
                tablaNotaCredito.setValueAt(cant.intValue(), lin, 1);
                // en unidad
                precioFinal = rint(((precioUnitario * (1 + (porcentualIva / 100))) + impuestoUnitario) * 100) / 100;
                tablaNotaCredito.setValueAt(df.format(precioFinal), lin, 3);
                nuevaCantidadTxt.setText("");

                // por cantidad
                gravado = rint((precioUnitario * cant) * 100) / 100;
                impuesto = rint((impuestoUnitario * cant) * 100) / 100;
                iva = rint(gravado * porcentualIva) / 100;
                totalLinea = rint((gravado + impuesto + iva) * 100) / 100;
                rf.setGravado(gravado);
                rf.setImpuesto(impuesto);
                rf.setIva(iva);
                rf.setTotal(totalLinea);
                tablaNotaCredito.setValueAt(df.format(gravado), lin, 4);
                tablaNotaCredito.setValueAt(df.format(impuesto), lin, 5);
                tablaNotaCredito.setValueAt(df.format(iva), lin, 6);
                tablaNotaCredito.setValueAt(df.format(totalLinea), lin, 8);
                leerPrecioBtn.setEnabled(true);
                nuevoPrecioTxt.setEnabled(true);
                borrarNoSeleccionadoBtn.setEnabled(true);
                terminarBtn.setEnabled(true);
                tablaNotaCredito.setEnabled(true);
                calcularTotales();
            }
        }
    }//GEN-LAST:event_grabarCantidadBtnActionPerformed

    private void leerPrecioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerPrecioBtnActionPerformed
        leerPrecio();
    }//GEN-LAST:event_leerPrecioBtnActionPerformed

    private void grabarPrecioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarPrecioBtnActionPerformed
        int lin = tablaNotaCredito.getSelectedRow();
        if (lin > -1) {
            if (!nuevoPrecioTxt.getText().isEmpty()) {
                leerPrecioBtn.setEnabled(true);
                grabarPrecioBtn.setEnabled(false);
                leerCantidadBtn.setEnabled(true);
                Rental rf = renglonNotaCredito.get(lin);
                Float cant = rf.getCantidad();
                Double impuestoUnitario = rf.getImpuesto() / cant;
                Double nuevoImporte = Double.valueOf(nuevoPrecioTxt.getText().replaceAll("\\,", "\\.")) / (1 + (porcentualIva / 100));
                precioFinal = rint(((nuevoImporte * (1 + (porcentualIva / 100))) + impuestoUnitario) * 100) / 100;
                // por cantidad
                gravado = -rint((nuevoImporte * cant) * 100) / 100;
                impuesto = -rint(impuestoUnitario * cant * 100) / 100;
                iva = rint(gravado * 21) / 100;
                totalLinea = rint((gravado + impuesto + iva) * 100) / 100;
                rf.setGravado(gravado);
                rf.setIva(iva);
                rf.setTotal(totalLinea);
                tablaNotaCredito.setValueAt(df.format(precioFinal), lin, 3);
                tablaNotaCredito.setValueAt(df.format(gravado), lin, 4);
                tablaNotaCredito.setValueAt(df.format(impuesto), lin, 5);
                tablaNotaCredito.setValueAt(df.format(iva), lin, 6);
                tablaNotaCredito.setValueAt(df.format(totalLinea), lin, 8);
                tablaNotaCredito.setEnabled(true);
                nuevoPrecioTxt.setText("");
                terminarBtn.setEnabled(true);
                nuevaCantidadTxt.setEnabled(true);
                leerCantidadBtn.setEnabled(true);
                nuevoPrecioTxt.setEnabled(true);
                borrarNoSeleccionadoBtn.setEnabled(true);
                calcularTotales();
                tablaNotaCredito.requestFocus();
            }
        }
    }//GEN-LAST:event_grabarPrecioBtnActionPerformed

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
            java.util.logging.Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotaCreditoDeFacturaFrame(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarNoSeleccionadoBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField cantidadAtadosMassalinTxt;
    private javax.swing.JTextField cantidadAtadosNoblezaTxt;
    private javax.swing.JTextField cantidadItemsTxt;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JTextField descuentoGlobalTxt;
    private javax.swing.JTextField descuentoVolumenTxt;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JButton grabarCantidadBtn;
    private javax.swing.JButton grabarPrecioBtn;
    private javax.swing.JCheckBox imprimeCbx;
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton leerCantidadBtn;
    private javax.swing.JButton leerPrecioBtn;
    private javax.swing.JTextField nuevaCantidadTxt;
    private javax.swing.JTextField nuevoPrecioTxt;
    private javax.swing.JTextField razonSocialTxt;
    private javax.swing.JTextField saldoTxt;
    private javax.swing.JTable tablaNotaCredito;
    private javax.swing.JButton terminarBtn;
    private javax.swing.JTextField texto1PieNcTxt;
    private javax.swing.JTextField texto2PieNcTxt;
    private javax.swing.JTextField totalMassalinTxt;
    private javax.swing.JTextField totalNoblezaTxt;
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
        saldoTxt.setText("0.00");
        totalTxt.setText("0.00");
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        cantidadItemsTxt.setText("");
        nuevaCantidadTxt.setText("");
        nuevoPrecioTxt.setText("");
        totalMassalinTxt.setText("");
        totalNoblezaTxt.setText("");
    }

    private void desbloquearCliente() {
        String cod = clienteSeleccionado.getCodigo();
        ClienteTraba ct = null;
        try {
            ct = new ClienteTrabaService().getClienteByCodigo(cod);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ct.setTraba1(false);
        try {
            new ClienteTrabaService().updateCliente(ct);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CustomerTraba cuTr = null;
        try {
            cuTr = new CustomerTrabaService().getClienteByCodigo(cod);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuTr.setTraba2(false);
        try {
            new CustomerTrabaService().updateCliente(cuTr);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void bloquearCliente() {
        String cod = clienteSeleccionado.getCodigo();
        ClienteTraba ct = null;
        try {
            ct = new ClienteTrabaService().getClienteByCodigo(cod);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ct.setTraba1(true);
        try {
            new ClienteTrabaService().updateCliente(ct);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CustomerTraba cuTr = null;
        try {
            cuTr = new CustomerTrabaService().getClienteByCodigo(cod);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuTr.setTraba2(true);
        try {
            new CustomerTrabaService().updateCliente(cuTr);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        cantidadItemsTxt.setEnabled(false);
        texto1PieNcTxt.setEnabled(false);
        texto2PieNcTxt.setEnabled(false);
        cantidadAtadosMassalinTxt.setEditable(false);
        cantidadAtadosNoblezaTxt.setEditable(false);
        nuevoPrecioTxt.setText("");
        totalMassalinTxt.setText("");
        totalNoblezaTxt.setText("");
        totalMassalinTxt.setEditable(false);
        totalNoblezaTxt.setEditable(false);
    }

    private void buscar() {
        filtro = "";
        Long id = (long) 1;
        try {
            Configuracion conf = new ConfiguracionService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha = Calendar.getInstance().getTime();
        Cliente cli = new Cliente();
        categoriaIva = 4;
        try {
            clienteNotaCredito = new ClienteService().getClienteByCodigo(codigoTxt.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - cliente");
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
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
//                categoriaIva = clienteNotaCredito.getCategoriaDeIva();
            } else {
                ivaTxt.setText("Consumidor Final");
            }
            razonSocialTxt.setText(clienteNotaCredito.getRazonSocial());
            fechaTxt.setText(sdf.format(fecha));
            ivaTxt.setText("--");
            if (clienteNotaCredito.getSaldo() != null) { //cliente
                if (clienteNC.getSaldo() != null) { //customer
                    saldoTxt.setText(String.valueOf(df.format(clienteNotaCredito.getSaldo() + clienteNC.getSaldo())));
                    saldoCliente = clienteNotaCredito.getSaldo() + clienteNC.getSaldo();
                } else {
                    saldoCliente = clienteNotaCredito.getSaldo();
                    saldoTxt.setText(String.valueOf(df.format(clienteNotaCredito.getSaldo())));
                    clienteNC.setSaldo(0.0);
                    try {
                        new CustomerService().updateCustomer(clienteNC);
                    } catch (Exception ex) {
                        Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                clienteNotaCredito.setSaldo(0.0);
                try {
                    new ClienteService().updateCliente(clienteNotaCredito);
                } catch (Exception ex) {
                    Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (clienteNC.getSaldo() != null) {
                    saldoCliente = clienteNC.getSaldo();
                    saldoTxt.setText(String.valueOf(df.format(clienteNC.getSaldo())));
                } else {
                    saldoTxt.setText("0.00");
                    saldoCliente = 0.0;
                    clienteNC.setSaldo(0.0);
                    try {
                        new CustomerService().updateCustomer(clienteNC);
                    } catch (Exception ex) {
                        Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
//            if (clienteNotaCredito.getSaldo() != null) {
//                saldoTxt.setText(String.valueOf(df.format(clienteNotaCredito.getSaldo())));
//                saldoCliente = clienteNotaCredito.getSaldo();
//            } else {
//                saldoTxt.setText("0.00");
//                saldoCliente = 0.0;
//            }
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
        Integer categoriaIva = 4;
        Activity ivaVentas = new Activity();

        //saldoCliente = clienteNC.getSaldo();
        //saldoCliente += totalNotaCredito;
        Long id_v;
        if (clienteNotaCredito.getVendedor() != null) {
            id_v = clienteNotaCredito.getVendedor().getId();
        } else {
            id_v = 99L;
        }
        clienteNC.setSaldo(clienteNC.getSaldo() + totalNotaCredito);
        try {
            new CustomerService().updateCustomer(clienteNC);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        desbloquearCliente();
        Long id = (long) 1;
        try {
            config = new RoutinesService().getFacturas(id);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        config.setUltimaFechaSistema(fecha);
//        
//        if (categoriaIva.equals(1)) {
//            letraNotaCredito = "A";
//            // es inscriptp
//            sucursalNotaCredito = config.getSucursal();
//            numeroNotaCredito = config.getNumeroFactura();
//            numeroNotaCredito += 1;
//            config.setNumeroFactura(numeroNotaCredito);
//            try {
//                new RoutinesService().updateRoutines(config);
//            } catch (Exception ex) {
//                Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
        letraNotaCredito = "B";
        // el resto de las categorias
        sucursalNotaCredito = config.getSucursal();
        numeroNotaCredito = config.getNumeroFactura();
        numeroNotaCredito += 1;
        config.setNumeroFactura(numeroNotaCredito);
        try {
            new RoutinesService().updateRoutines(config);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
//        }
        ivaVentas.setCustomer(clienteNC);
        Float dg = clienteNC.getDescuento();
        ivaVentas.setIdVendedor(id_v);
        ivaVentas.setDescuentoGlobal(descuento);
        ivaVentas.setPorcentajeDescuentoGlobal(dg);
        ivaVentas.setExento(0.0);
        ivaVentas.setFecha(fecha);
        ivaVentas.setFechaCae(fecha);
        ivaVentas.setCae(0L);
        ivaVentas.setGravado(totalGravado);
        ivaVentas.setImpuesto(totalImpuesto);
        ivaVentas.setIva(totalIva);
        ivaVentas.setNoGravado(0.0);
        ivaVentas.setTotal(totalNotaCredito);
        ivaVentas.setLetra(letraNotaCredito);
        ivaVentas.setNumeroSucursal(sucursalNotaCredito);
        ivaVentas.setNumeroFactura(numeroNotaCredito);
        if (!texto1PieNcTxt.getText().isEmpty()) {
            ivaVentas.setTextoPieFactura1(texto1PieNcTxt.getText());
        } else {
            ivaVentas.setTextoPieFactura1("");
        }
        if (!texto2PieNcTxt.getText().isEmpty()) {
            ivaVentas.setTextoPieFactura2(texto2PieNcTxt.getText());
        } else {
            ivaVentas.setTextoPieFactura2("");
        }
        try {
            new NotaCreditoService().saveDevolucionCompleta(ivaVentas, renglonNotaCredito);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Rental reFa : renglonNotaCredito) {
            Integer cod = reFa.getCodigoProducto();
            try {
                producto = new ProductoService().getProductoByCodigo(cod);
            } catch (Exception ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            Float stock = 0.0F;
            if (producto.getStock() != null) {
                stock = producto.getStock();
            } else {
                stock = 0.0F;
            }
            reFa.setCodigoProducto(producto.getCodigo());
            stock += reFa.getCantidad();
            producto.setStock(stock);
            try {
                new ProductoService().updateProducto(producto);
            } catch (Exception ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Inventory ccc = new Inventory();
        ccc.setCliente(clienteNC);
        ccc.setNotaCredito(ivaVentas);
        ccc.setFecha(fecha);
        ccc.setDebe(0.0);
        ccc.setHaber(-totalNotaCredito);
        ccc.setTipo("NC");
        ccc.setSaldo(saldoCliente + totalNotaCredito);
        try {
            new InventoryService().saveInventory(ccc);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        generarNotaCredito();
        MainFrame ff = new MainFrame();
        ff.setVisible(true);
        this.dispose();
    }

    private void generarNotaCredito() {
        renglones = new String[maxNro];
        textoNotaCreditoPapel = "DEVOLUCION";
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
            nombresColumnaNotaCreditoPapel = "IT  CANT                   DETALLE                  P.UNIT.     DESC.      IMPORTE        IMP.        TOTAL        SUG";
//        } else {
//            nombresColumnaNotaCreditoPapel = "  IT CANT                   DETALLE                   P.UNIT.    DESC.   GRAVADO      IVA       IMP.    TOTAL      SUG";
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
                    renglones[r] = renglones[r] + " " +str0;
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
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
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
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
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
                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
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
        String espacio = "          "; //10
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
        totalDeudaNotaCreditoPapel = espacio + df.format(doble);
// Total Nota de Crédito
        str0 = String.valueOf(totalNotaCredito);
        str0 = str0.replace(",", ".");
        doble = Double.valueOf(str0);
        largo = doble.intValue();
        espacio = "          "; //10
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
            espacio = "           "; // 11
            largo = String.valueOf(largo).length();
            espacio = espacio.substring(largo);
            lineaTotalesNotaCreditoPapel = espacio + df.format(doble);
            str0 = String.valueOf(totalImpuesto);
            str0 = str0.replace(",", ".");
            doble = Double.valueOf(str0);
            largo = doble.intValue();
            espacio = "           "; // 11
            largo = String.valueOf(largo).length();
            espacio = espacio.substring(largo);
            lineaTotalesNotaCreditoPapel += espacio + df.format(doble);
            str0 = String.valueOf(totalIva);
            str0 = str0.replace(",", ".");
            doble = Double.valueOf(str0);
            largo = doble.intValue();
            espacio = "                                 "; // 33
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
        espacio = "          "; // 10
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
        totalPagarNotaCreditoPapel = espacio + df.format(doble);
// Cantidades atados
        cantidadesNotaCreditoPapel = "                  CANT.ATADOS NOBLEZA: " + String.valueOf(cantidadAtadosNobleza);
        cantidadesNotaCreditoPapel += "                 CANT ATADOS MASSALIN: " + String.valueOf(cantidadAtadosMassalin);
        texto1NotaCreditoPapel = texto1PieNcTxt.getText();
        texto2NotaCreditoPapel = texto2PieNcTxt.getText();
        texto3NotaCreditoPapel = "-";
        if (imprimeCbx.isSelected()) {
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
            Producto prod = null;
            try {
                prod = new ProductoService().getProductoByCodigo(codi);
            } catch (Exception ex) {
                Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            if (prod.getRubro().getCodigo().equals(1)) {
                cantidadAtadosMassalin += renFa.getCantidad().intValue();
                importeTotalMassalin += renFa.getTotal();
            }
            cantidadAtadosMassalinTxt.setText(String.valueOf(cantidadAtadosMassalin));
            totalMassalinTxt.setText(String.valueOf(df.format(importeTotalMassalin)));
            if (prod.getRubro().getCodigo().equals(2)) {
                cantidadAtadosNobleza += renFa.getCantidad().intValue();
                importeTotalNobleza += renFa.getTotal();
            }
            cantidadAtadosNoblezaTxt.setText(String.valueOf(cantidadAtadosNobleza));
            totalNoblezaTxt.setText(String.valueOf(df.format(importeTotalNobleza)));
            totalIva += renFa.getIva();
            totalImpuesto += renFa.getImpuesto();
            totalNotaCredito += renFa.getTotal();
            nro += 1;
            renFa.setItemNro(nro);
        }
        cantidadItemsTxt.setText(String.valueOf(nro));
        String tnc = df.format(totalNotaCredito);
        totalNotaCredito = Double.valueOf(tnc.replace(",", "."));
        totalTxt.setText(String.valueOf(df.format(totalNotaCredito)));
    }

    private void cargarDatos() {
        // CLIENTE SELECCIONADO Y FACTURA
        limpiarCampos();
        codigoTxt.setText(clienteSeleccionado.getCodigo());
        try {
            clienteNC = new CustomerService().getCustomerByCodigo(clienteSeleccionado.getCodigo());
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        if (clienteNC.getDescuento() != null) {
            descuentoGlobalTxt.setText(clienteNC.getDescuento().toString());
        } else {
            descuentoGlobalTxt.setText("0");
        }
        buscar();
//        razonSocialTxt.setText(clienteSeleccionado.getRazonSocial());
//        if(clienteNC.getSaldo() != null){
//            saldoTxt.setText(String.valueOf(df.format(clienteSeleccionado.getSaldo() + clienteNC.getSaldo())));
//        }else{
//            saldoTxt.setText(df.format(clienteSeleccionado.getSaldo()));
//            clienteNC.setSaldo(0.0);
//            try {
//                new CustomerService().updateCustomer(clienteNC);
//            } catch (Exception ex) {
//                Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        Long id = (long) 1;
        try {
            Routines conf = new RoutinesService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha = Calendar.getInstance().getTime();
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
//            categoriaIva = clienteNotaCredito.getCategoriaDeIva();
        } else {
            ivaTxt.setText("Consumidor Final");
        }
        cancelarBtn.setEnabled(true);
        codigoTxt.setEditable(false);
        totalTxt.setEnabled(true);
        totalTxt.setEditable(false);
        agregarProducto();
    }

    private void cargarRenglones() {
        renglonF = null;
        try {
            renglonF = new ActivityRowService().getAllActivityRowFromIvaVentas(factura);
            tabla = (DefaultTableModel) tablaNotaCredito.getModel();
            for (ActivityRow rp : renglonF) {
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
                linea[3] = df.format((rp.getGravado() + rp.getImpuesto() + rp.getIva()) / rp.getCantidad());
                linea[4] = df.format(-rp.getGravado());
                linea[5] = df.format(-rp.getImpuesto());
                linea[6] = df.format(-rp.getIva());
                linea[7] = 0.00;
                linea[8] = df.format(-rp.getTotal());
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
            Logger.getLogger(NotaCreditoDeFacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private void borrarSeleccionado() {
//        DefaultTableModel model = (DefaultTableModel) tablaNotaCredito.getModel();
//        int cantidadSeleccionadas = tablaNotaCredito.getSelectedRowCount();
//        int a[] = tablaNotaCredito.getSelectedRows();
//        if (a.length > 0) {
//            for (int n = cantidadSeleccionadas - 1; n > -1; n--) {
//                model.removeRow(a[n]);
//                renglonNotaCredito.remove(a[n]);
//            }
//        }
//        tablaNotaCredito.setModel(model);
//        calcularTotales();
//    }
    private void borrarNoSeleccionado() {
        DefaultTableModel model = (DefaultTableModel) tablaNotaCredito.getModel();
        int cantidadSeleccionadas = tablaNotaCredito.getSelectedRowCount();
        int cantidadTabla = tablaNotaCredito.getRowCount();
        int a[] = tablaNotaCredito.getSelectedRows();
        if (a.length > 0) {
            for (int n = cantidadTabla - 1; n > -1; n--) {
                if (n != a[cantidadSeleccionadas - 1]) {
                    model.removeRow(n);
                    renglonNotaCredito.remove(n);
                } else {
                    cantidadSeleccionadas -= 1;
                    if (cantidadSeleccionadas < 1) {
                        cantidadSeleccionadas += 1;
                    }
                }
            }
        }
        tablaNotaCredito.setModel(model);
        calcularTotales();
    }

    private void leerPrecio() {
        int lin = tablaNotaCredito.getSelectedRow();
        if (lin > -1) {
            Rental rf = renglonNotaCredito.get(lin);
            int cod = rf.getCodigoProducto();
            Producto pro = null;
            try {
                pro = new ProductoService().getProductoByCodigo(cod);
            } catch (Exception ex) {
                Logger.getLogger(PedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            int codRub = pro.getRubro().getCodigo();
            if (codRub < 3) {
                JOptionPane.showMessageDialog(this, "No puede modificar Precio de este producto");
                leerPrecioBtn.setEnabled(true);
                grabarPrecioBtn.setEnabled(false);
                leerCantidadBtn.setEnabled(true);
                terminarBtn.requestFocus();
                return;
            }
            Float cant = rf.getCantidad();
            Double iva = rf.getIva() / cant;
            Double prec = rf.getGravado() / cant;
            nuevoPrecioTxt.setText(String.valueOf(df.format(-(prec + iva))));
            leerPrecioBtn.setEnabled(false);
            grabarPrecioBtn.setEnabled(true);
            leerCantidadBtn.setEnabled(false);
            terminarBtn.setEnabled(false);
            borrarNoSeleccionadoBtn.setEnabled(false);
            tablaNotaCredito.setEnabled(false);
            grabarCantidadBtn.setEnabled(false);
        }
    }

    private void volver() {
        desbloquearCliente();
        NotaCreditoSelectFrame ncpf = new NotaCreditoSelectFrame();
        ncpf.setVisible(true);
        this.dispose();

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
            g2.drawString("SALDO ANTERIOR: " + totalDeudaNotaCreditoPapel, 403, row);
            row += 10;
            g2.drawString("SALDO TOTAL:    " + totalPagarNotaCreditoPapel, 403, row);
            row += 10;
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
