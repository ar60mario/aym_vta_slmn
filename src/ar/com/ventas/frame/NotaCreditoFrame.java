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
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.entities.Rental;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Usuario;
import ar.com.ventas.entities.Vendedor;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ClienteTrabaService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.CustomerService;
import ar.com.ventas.services.CustomerTrabaService;
import ar.com.ventas.services.InventoryService;
import ar.com.ventas.services.NotaCreditoService;
import ar.com.ventas.services.ProductoService;
import ar.com.ventas.services.RenglonFacturaService;
import ar.com.ventas.services.RoutinesService;
import ar.com.ventas.services.UsuarioService;
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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class NotaCreditoFrame extends javax.swing.JFrame {

    public List<Rental> renglonNotaCredito = new ArrayList<Rental>();
    private Usuario usuario;
    private final Integer nivel = 1;
    private String textoNotaCreditoPapel;
    private String fechaNotaCreditoPapel;
    private String clienteNotaCreditoPapel;
    private String codigoClienteNotaCreditoPapel;
    private String direccionNotaCreditoPapel;
    private String cuitNotaCreditoPapel;
    private String condicionVentaNotaCreditoPapel;
    //private String vencimientoNotaCreditoPapel;
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
    private Cliente clienteNotaCredito = null;
    private Customer clienteNC = null;
    private Producto producto = null;
    private DefaultTableModel tabla = null;
    private Double totalNotaCredito = 0.00;
    private Double totalImpuesto = 0.00;
    private Double totalIva = 0.00;
    private Double totalGravado = 0.00;
    private Double totalGravadoCigarrillos = 0.00;
    private final Double totalNoGravado = 0.0;
    private Double gravado = 0.00;
    private final Double noGravado = 0.00;
    private Double iva = 0.00;
    private Float porcentualIva;
    private Double impuesto = null;
    private Double totalLinea = 0.00;
    private Boolean tieneDto = false;
    private Float descuen = 0F;
    private Cliente clienteSeleccionado;
    private Producto productoSeleccionado;
    private Float cantidad;
    private Integer categoriaIva = 1;
    private final DecimalFormat df = new DecimalFormat("#0.00");
    private final DecimalFormat df1 = new DecimalFormat("#0.0");
    private Double saldoCliente = 0.00;
    private String filtro = "";
    private String letraNotaCredito;
    private Integer sucursalNotaCredito;
    private Integer numeroNotaCredito;
    private Routines config = null;
    private Double precioFinal = 0.0;
    private Integer nro = 0;
    private final Integer maxNro = 41;
    private Integer cantidadAtadosMassalin;
    private Integer cantidadAtadosNobleza;
    public Boolean encontrado;
    private final IvaVentas factura;
    private List<RenglonFactura> renglonF = null;
    private int traba = 0;
    private Double totalDescuen = 0.0;

    /**
     * Creates new form NotaCreditoFrame
     *
     * @param cli
     * @param fac
     */
    public NotaCreditoFrame(Cliente cli, IvaVentas fac) {
        getContentPane().setBackground(new java.awt.Color(255, 250, 205));
        initComponents();
        this.setLocationRelativeTo(null);
        this.clienteSeleccionado = cli;
        this.factura = fac;
        bloquearCampos();
//      levanto el modelo creado del frame
        tabla = (DefaultTableModel) tablaNotaCredito.getModel();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaNotaCredito = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        codigoProductoTxt = new javax.swing.JTextField();
        codigoBarrasTxt = new javax.swing.JTextField();
        cantidadTxt = new javax.swing.JTextField();
        codigoTxt = new javax.swing.JTextField();
        razonSocialTxt = new javax.swing.JTextField();
        fechaTxt = new javax.swing.JTextField();
        ivaTxt = new javax.swing.JTextField();
        saldoTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        agregarBtn = new javax.swing.JButton();
        totalTxt = new javax.swing.JTextField();
        terminarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        buscarClienteBtn = new javax.swing.JButton();
        incorporarANotaCreditoBtn = new javax.swing.JButton();
        eliminarItemBtn = new javax.swing.JButton();
        buscarClienteXNombre = new javax.swing.JButton();
        buscarProductoXNombreBtn = new javax.swing.JButton();
        descuentoGlobalLbl = new javax.swing.JLabel();
        descuentoGlobalTxt = new javax.swing.JTextField();
        comboClientes = new javax.swing.JComboBox();
        comboProductos = new javax.swing.JComboBox();
        nombreClienteABuscarTxt = new javax.swing.JTextField();
        nombreProductoABuscarTxt = new javax.swing.JTextField();
        totalDeudaTxt = new javax.swing.JTextField();
        texto1PieNcTxt = new javax.swing.JTextField();
        texto2PieNcTxt = new javax.swing.JTextField();
        volverBtn = new javax.swing.JButton();
        nombreProductoConsultaTxt = new javax.swing.JTextField();
        precioProductoConsultaTxt = new javax.swing.JTextField();
        cantidadAtadosMassalinTxt = new javax.swing.JTextField();
        cantidadAtadosNoblezaTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        imprimeCbx = new javax.swing.JCheckBox();
        cantidadItemsTxt = new javax.swing.JTextField();
        nuevaCantidadTxt = new javax.swing.JTextField();
        nuevoPrecioTxt = new javax.swing.JTextField();
        importeMassalinTxt = new javax.swing.JTextField();
        importeNoblezaTxt = new javax.swing.JTextField();
        descuentoLineaTxt = new javax.swing.JTextField();
        totalCompraActualTxt = new javax.swing.JTextField();
        descuentoVolumenTxt = new javax.swing.JTextField();
        leerCantidadBtn = new javax.swing.JButton();
        leerPrecioBtn = new javax.swing.JButton();
        grabarCantidadBtn = new javax.swing.JButton();
        grabarPrecioBtn = new javax.swing.JButton();
        descuentoBtn = new javax.swing.JButton();
        recalcularBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("DEVOLUCION");
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

        jLabel5.setText("Código:");

        jLabel6.setText("C.Barras:");

        jLabel7.setText("Cantidad:");

        codigoProductoTxt.setText("CODIGO P");
        codigoProductoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoProductoTxtKeyPressed(evt);
            }
        });

        codigoBarrasTxt.setText("COD BARRAS");
        codigoBarrasTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoBarrasTxtKeyPressed(evt);
            }
        });

        cantidadTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadTxt.setText("CANT");
        cantidadTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cantidadTxtKeyPressed(evt);
            }
        });

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
        saldoTxt.setForeground(new java.awt.Color(0, 0, 255));
        saldoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        saldoTxt.setText("SALDO");

        jLabel8.setText("TOTAL:");

        agregarBtn.setText("Agregar otro Item");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });
        agregarBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                agregarBtnKeyPressed(evt);
            }
        });

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

        buscarClienteBtn.setText("Buscar");
        buscarClienteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteBtnActionPerformed(evt);
            }
        });

        incorporarANotaCreditoBtn.setText("Incorporar a Dev.");
        incorporarANotaCreditoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incorporarANotaCreditoBtnActionPerformed(evt);
            }
        });

        eliminarItemBtn.setText("Eliminar Item");
        eliminarItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarItemBtnActionPerformed(evt);
            }
        });

        buscarClienteXNombre.setText("Buscar x nombre");
        buscarClienteXNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteXNombreActionPerformed(evt);
            }
        });

        buscarProductoXNombreBtn.setText("Buscar x nombre");
        buscarProductoXNombreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProductoXNombreBtnActionPerformed(evt);
            }
        });

        descuentoGlobalLbl.setText("Descuento:");

        descuentoGlobalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoGlobalTxt.setText("DESC");

        comboClientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientesActionPerformed(evt);
            }
        });
        comboClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboClientesKeyPressed(evt);
            }
        });

        comboProductos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductosActionPerformed(evt);
            }
        });
        comboProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comboProductosKeyPressed(evt);
            }
        });

        nombreClienteABuscarTxt.setText("NOMBRE CLIENTE A BUSCAR");
        nombreClienteABuscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreClienteABuscarTxtKeyPressed(evt);
            }
        });

        nombreProductoABuscarTxt.setText("NOMBRE PRODUCTO A BUSCAR");
        nombreProductoABuscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreProductoABuscarTxtKeyPressed(evt);
            }
        });

        totalDeudaTxt.setBackground(new java.awt.Color(0, 0, 204));
        totalDeudaTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalDeudaTxt.setForeground(new java.awt.Color(51, 255, 255));
        totalDeudaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalDeudaTxt.setText("TOTAL DEU");

        texto1PieNcTxt.setText("TEXTO 1 PIE FACTURA");

        texto2PieNcTxt.setText("TEXTO 2 PIE FACTURA");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        nombreProductoConsultaTxt.setText("NOMBRE PRODUCTO CONSULTA");

        precioProductoConsultaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioProductoConsultaTxt.setText("PRECIO PROD CONSU");

        cantidadAtadosMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadAtadosMassalinTxt.setText("Cant Mass");

        cantidadAtadosNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadAtadosNoblezaTxt.setText("Cant Nobl");

        jLabel13.setText("Total Deuda:");

        jLabel15.setText("Massalin:");

        jLabel17.setText("Nobleza:");

        jLabel18.setText("Cant. Items:");

        imprimeCbx.setText("Imprime");

        cantidadItemsTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadItemsTxt.setText("Cantidad Items");

        nuevaCantidadTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nuevaCantidadTxt.setText("NUE CAN");
        nuevaCantidadTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nuevaCantidadTxtKeyPressed(evt);
            }
        });

        nuevoPrecioTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nuevoPrecioTxt.setText("NUE PREC");
        nuevoPrecioTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nuevoPrecioTxtKeyPressed(evt);
            }
        });

        importeMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeMassalinTxt.setText("IMP MASS");

        importeNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        importeNoblezaTxt.setText("IMP NOBL");

        descuentoLineaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoLineaTxt.setText("DCTO");
        descuentoLineaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descuentoLineaTxtKeyPressed(evt);
            }
        });

        totalCompraActualTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalCompraActualTxt.setText("TOT COMP ACT");

        descuentoVolumenTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoVolumenTxt.setText("DESCUENTO");

        leerCantidadBtn.setText("Leer Cantidad");
        leerCantidadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerCantidadBtnActionPerformed(evt);
            }
        });

        leerPrecioBtn.setText("Leer Precio");
        leerPrecioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerPrecioBtnActionPerformed(evt);
            }
        });

        grabarCantidadBtn.setText("Grabar Cantidad");
        grabarCantidadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarCantidadBtnActionPerformed(evt);
            }
        });

        grabarPrecioBtn.setText("Grabar Precio");
        grabarPrecioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarPrecioBtnActionPerformed(evt);
            }
        });

        descuentoBtn.setText("Desc.");
        descuentoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descuentoBtnActionPerformed(evt);
            }
        });

        recalcularBtn.setText("Recalcular");
        recalcularBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recalcularBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("Importe:");

        jLabel10.setText("Importe:");

        jLabel11.setText("Dscto:");

        jLabel12.setText("Saldo otra Factura:");

        jLabel14.setText("Descuento:");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarClienteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(razonSocialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(descuentoGlobalLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descuentoGlobalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(volverBtn))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel11))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(codigoBarrasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(descuentoLineaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cantidadTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(descuentoBtn))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(232, 232, 232)
                                        .addComponent(nombreProductoABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buscarProductoXNombreBtn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(codigoProductoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(incorporarANotaCreditoBtn)
                                                .addGap(18, 18, 18)
                                                .addComponent(agregarBtn))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(18, 18, 18)
                                                .addComponent(totalCompraActualTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel13)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(totalDeudaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(eliminarItemBtn))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(recalcularBtn)
                                                            .addGap(48, 48, 48)
                                                            .addComponent(imprimeCbx))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(134, 134, 134)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(leerPrecioBtn)
                                                                .addComponent(leerCantidadBtn))
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(nuevoPrecioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                    .addGap(10, 10, 10)
                                                                    .addComponent(nuevaCantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGap(18, 18, 18)
                                                            .addComponent(grabarPrecioBtn)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(266, 266, 266)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel18)
                                                            .addComponent(jLabel8)
                                                            .addComponent(jLabel14))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(grabarCantidadBtn)
                                                            .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(precioProductoConsultaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(123, 123, 123))
                                                    .addComponent(nombreProductoConsultaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texto2PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(importeNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(106, 106, 106)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cancelarBtn)
                                    .addComponent(terminarBtn)))
                            .addComponent(texto1PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 66, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(nombreClienteABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarClienteXNombre)
                        .addGap(18, 18, 18)
                        .addComponent(comboClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(buscarClienteBtn)
                    .addComponent(descuentoGlobalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descuentoGlobalLbl)
                    .addComponent(volverBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarClienteXNombre)
                    .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreClienteABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreProductoABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarProductoXNombreBtn)
                            .addComponent(jLabel6)
                            .addComponent(codigoBarrasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoProductoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreProductoConsultaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(precioProductoConsultaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grabarCantidadBtn)
                        .addComponent(nuevaCantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(leerCantidadBtn))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(descuentoLineaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descuentoBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grabarPrecioBtn)
                    .addComponent(leerPrecioBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(incorporarANotaCreditoBtn)
                        .addComponent(agregarBtn)
                        .addComponent(eliminarItemBtn)
                        .addComponent(nuevoPrecioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(totalCompraActualTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(totalDeudaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recalcularBtn)
                    .addComponent(imprimeCbx))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto1PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto2PieNcTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(importeMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(importeNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarClienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteBtnActionPerformed
        buscar();
        cancelarBtn.setEnabled(true);
    }//GEN-LAST:event_buscarClienteBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar la Devolucion?", "Atencion", JOptionPane.YES_NO_OPTION);
        // 0 = si; 1 = no
        if (escape == 0) {
            desbloquearCliente();
            limpiarCampos();
            bloquearCampos();
            borrarTablaProductos();
            volverBtn.setEnabled(true);
            buscarClienteBtn.setEnabled(true);
            nombreClienteABuscarTxt.setEnabled(true);
            buscarClienteXNombre.setEnabled(true);
            comboClientes.setEnabled(true);
            codigoTxt.requestFocus();
        } else {
            incorporarANotaCreditoBtn.setEnabled(false);
            eliminarItemBtn.setEnabled(true);
            agregarBtn.setEnabled(true);
            codigoBarrasTxt.setEnabled(false);
            codigoProductoTxt.setEnabled(false);
            cantidadTxt.setEnabled(false);
            nombreProductoABuscarTxt.setEnabled(false);
            comboProductos.setEnabled(false);
            leerCantidadBtn.setEnabled(true);
            leerPrecioBtn.setEnabled(true);
            nuevaCantidadTxt.setEnabled(true);
            nuevoPrecioTxt.setEnabled(true);
            grabarCantidadBtn.setEnabled(false);
            grabarPrecioBtn.setEnabled(false);
            nuevoPrecioTxt.setText("");
            nuevaCantidadTxt.setText("");
            terminarBtn.setEnabled(true);
            agregarBtn.requestFocus();
        }
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        eliminarItemBtn.setEnabled(false);
        texto1PieNcTxt.setEnabled(false);
        texto2PieNcTxt.setEnabled(false);
        codigoBarrasTxt.setText("");
        agregarProducto();
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void incorporarANotaCreditoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incorporarANotaCreditoBtnActionPerformed
        if (!cantidadTxt.getText().isEmpty()) {
            if (!codigoBarrasTxt.getText().isEmpty()) {
                buscarProducto();
            } else {
                if (!codigoProductoTxt.getText().isEmpty()) {
                    buscarProducto();
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese Código Barras o Código producto");
                    codigoBarrasTxt.requestFocus();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad");
            cantidadTxt.requestFocus();
        }
    }//GEN-LAST:event_incorporarANotaCreditoBtnActionPerformed

    private void buscarClienteXNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteXNombreActionPerformed
        comboClientes.removeAllItems();
        comboClientes.addItem("");
        llenarComboClientes();
        comboClientes.addFocusListener(null);
        comboClientes.showPopup();
    }//GEN-LAST:event_buscarClienteXNombreActionPerformed

    private void comboClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesActionPerformed
        if (evt.getModifiers() == 16) {
            if (comboClientes.getSelectedIndex() > 0) {
                nombreClienteABuscarTxt.setText("");
                try {
                    Integer seleccion = comboClientes.getSelectedIndex();
                    clienteSeleccionado = new ClienteService().getClientesByFiltro(filtro).get(seleccion - 1);
                    codigoTxt.setText(clienteSeleccionado.getCodigo());
                    buscar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error - buscar cliente");
                    Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_comboClientesActionPerformed

    private void buscarProductoXNombreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProductoXNombreBtnActionPerformed
        comboProductos.removeAllItems();
        comboProductos.addItem("");
        llenarComboProductos();
        comboProductos.addFocusListener(null);
        comboProductos.showPopup();
    }//GEN-LAST:event_buscarProductoXNombreBtnActionPerformed

    private void comboProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductosActionPerformed
        if (evt.getModifiers() == 16) {
            if (comboProductos.getSelectedIndex() > 0) {
                nombreProductoABuscarTxt.setText("");
                nombreProductoABuscarTxt.setEnabled(false);
                buscarProductoXNombreBtn.setEnabled(false);
                try {
                    Integer seleccion = comboProductos.getSelectedIndex();
                    productoSeleccionado = new ProductoService().getProductosByFiltroActivosSinDepo(filtro).get(seleccion - 1);
                    codigoProductoTxt.setText(String.valueOf(productoSeleccionado.getCodigo()));
                    consultarProducto();
                    cantidadTxt.requestFocus();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error - buscar producto");
                    Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_comboProductosActionPerformed

    private void terminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBtnActionPerformed
        terminarNotaCredito();
    }//GEN-LAST:event_terminarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverBtnActionPerformed

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

    private void codigoProductoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoProductoTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!codigoProductoTxt.getText().isEmpty()) {
                consultarProducto();
                incorporarANotaCreditoBtn.setEnabled(false);
            } else {
                codigoBarrasTxt.requestFocus();
            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar la carga de NC?", "Atencion", JOptionPane.YES_NO_OPTION);
                if (escape != 1) {
                    limpiarCampos();
                    bloquearCampos();
                    borrarTablaProductos();
                    volverBtn.setEnabled(true);
                    buscarClienteXNombre.setEnabled(true);
                    nombreClienteABuscarTxt.setEnabled(true);
                    comboClientes.setEnabled(true);
                    codigoTxt.requestFocus();
                } else {
                    codigoProductoTxt.setText("");
                    codigoProductoTxt.requestFocus();
                }
            } else {
                if (evt.getKeyCode() != 8 // back space
                        && evt.getKeyCode() != 37 //flecha izquierda
                        && evt.getKeyCode() != 39 //flecha derecha
                        && evt.getKeyCode() != 17 //Ctrl
                        && evt.getKeyCode() != 16 //Mayuscula
                        && evt.getKeyCode() != 38 //flecha arriba
                        && evt.getKeyCode() != 40 //flecha abajo
                        && evt.getKeyCode() != 67 //C
                        && evt.getKeyCode() != 20 //traba mayusculas
                        && evt.getKeyCode() != 27 //Escape
                        && evt.getKeyCode() != 86 //V
                        && evt.getKeyCode() != 36 //Inicio
                        && evt.getKeyCode() != 35 //fin
                        && evt.getKeyCode() != 155 //Insert
                        // && evt.getKeyCode() != 110  // punto decimal
                        //&& evt.getKeyCode() != 45 // Menos
                        && evt.getKeyCode() != 127) { // Suprimir
                    if (!isNumeric(evt)) {
                        JOptionPane.showMessageDialog(this, "Solo números");
                        codigoBarrasTxt.setText("");
                        codigoBarrasTxt.requestFocus();
                        return;
                    }
                    //cantidadTxt.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_codigoProductoTxtKeyPressed

    private void cantidadTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!cantidadTxt.getText().isEmpty()) {
                cantidad = Float.valueOf(cantidadTxt.getText());
                if (!(cantidad > 0.0)) {
                    JOptionPane.showMessageDialog(this, "Debe colocar cantidad mayor que cero");
                    cantidadTxt.setText("");
                    cantidadTxt.requestFocus();
                    return;
                }
                if (!codigoBarrasTxt.getText().isEmpty()) {
                    buscarProducto();
                    leerCantidadBtn.setEnabled(true);
                    leerPrecioBtn.setEnabled(true);
                    nuevaCantidadTxt.setEnabled(true);
                    nuevoPrecioTxt.setEnabled(true);
                    agregarBtn.requestFocus();
                } else {
                    if (!codigoProductoTxt.getText().isEmpty()) {
                        buscarProducto();
                        leerCantidadBtn.setEnabled(true);
                        leerPrecioBtn.setEnabled(true);
                        nuevaCantidadTxt.setEnabled(true);
                        nuevoPrecioTxt.setEnabled(true);
                        agregarBtn.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(this, "Ingrese Código Barras o Código producto");
                        codigoBarrasTxt.requestFocus();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese una cantidad");
                cantidadTxt.requestFocus();
            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                codigoBarrasTxt.setText("");
                codigoProductoTxt.setText("");
                nombreProductoABuscarTxt.setText("");
                nombreProductoABuscarTxt.setEnabled(true);
                comboProductos.removeAllItems();
                comboProductos.addItem("");
                nombreProductoABuscarTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_cantidadTxtKeyPressed

    private void eliminarItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarItemBtnActionPerformed
        int selectRow = tablaNotaCredito.getSelectedRow();
        if (selectRow != -1) {
            int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de Eliminar Item?", "Atencion", JOptionPane.YES_NO_OPTION);
            // 0 = si; 1 = no
            if (escape == 0) {
                tabla.removeRow(selectRow);
                renglonNotaCredito.remove(selectRow);
                calcularTotales();
                agregarBtn.requestFocus();
                if (nro > 0) {
                    terminarBtn.setEnabled(true);
                } else {
                    terminarBtn.setEnabled(false);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto para eliminar");
        }
    }//GEN-LAST:event_eliminarItemBtnActionPerformed

    private void agregarBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_agregarBtnKeyPressed
        eliminarItemBtn.setEnabled(false);
        texto1PieNcTxt.setEnabled(false);
        texto2PieNcTxt.setEnabled(false);
        codigoBarrasTxt.setText("");
        agregarProducto();
    }//GEN-LAST:event_agregarBtnKeyPressed

    private void nombreClienteABuscarTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreClienteABuscarTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            comboClientes.removeAllItems();
            comboClientes.addItem("");
            llenarComboClientes();
            comboClientes.requestFocus();
            comboClientes.addFocusListener(null);
            comboClientes.showPopup();
        }
    }//GEN-LAST:event_nombreClienteABuscarTxtKeyPressed

    private void nombreProductoABuscarTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreProductoABuscarTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!nombreProductoABuscarTxt.getText().isEmpty()) {
                comboProductos.removeAllItems();
                comboProductos.addItem("");
                llenarComboProductos();
                DefaultComboBoxModel mdl = (DefaultComboBoxModel) comboProductos.getModel();
                int rows = mdl.getSize();
                if (rows < 2) {
                    nombreProductoABuscarTxt.setText("");
                    nombreProductoABuscarTxt.requestFocus();
                    return;
                }
                comboProductos.requestFocus();
                comboProductos.addFocusListener(null);
                comboProductos.showPopup();
            } else {
                codigoProductoTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_nombreProductoABuscarTxtKeyPressed

    private void codigoBarrasTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBarrasTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!codigoBarrasTxt.getText().isEmpty()) {
                consultarProductoBarras();
                //incorporarANotaCreditoBtn.setEnabled(true);
                //cantidadTxt.requestFocus();
            } else {
                nombreProductoABuscarTxt.requestFocus();
            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar la NC?", "Atencion", JOptionPane.YES_NO_OPTION);
                if (escape == 0) {
                    limpiarCampos();
                    bloquearCampos();
                    borrarTablaProductos();
                    volverBtn.setEnabled(true);
                    cancelarBtn.setEnabled(false);
                    leerCantidadBtn.setEnabled(false);
                    nuevaCantidadTxt.setEditable(false);
                    nuevaCantidadTxt.setEnabled(false);
                    nombreClienteABuscarTxt.setEnabled(true);
                    buscarClienteXNombre.setEnabled(true);
                    comboClientes.setEnabled(true);
                    codigoTxt.requestFocus();
                    return;
                } else {
                    codigoProductoTxt.setText("");
                    codigoBarrasTxt.setText("");
                    codigoBarrasTxt.requestFocus();
                }
                //incorporarANotaCreditoBtn.setEnabled(true);
                //cantidadTxt.requestFocus();
            } else {
                if (evt.getKeyCode() != 8 // back space
                        && evt.getKeyCode() != 37 //flecha izquierda
                        && evt.getKeyCode() != 39 //flecha derecha
                        && evt.getKeyCode() != 17 //Ctrl
                        && evt.getKeyCode() != 16 //Mayuscula
                        && evt.getKeyCode() != 38 //flecha arriba
                        && evt.getKeyCode() != 40 //flecha abajo
                        && evt.getKeyCode() != 67 //C
                        && evt.getKeyCode() != 20 //traba mayusculas
                        && evt.getKeyCode() != 27 //Escape
                        && evt.getKeyCode() != 86 //V
                        && evt.getKeyCode() != 36 //Inicio
                        && evt.getKeyCode() != 35 //fin
                        && evt.getKeyCode() != 155 //Insert
                        // && evt.getKeyCode() != 110  // punto decimal
                        //&& evt.getKeyCode() != 45 // Menos
                        && evt.getKeyCode() != 127) { // Suprimir
                    if (!isNumeric(evt)) {
                        JOptionPane.showMessageDialog(this, "Solo números");
                        codigoBarrasTxt.setText("");
                        codigoBarrasTxt.requestFocus();
                        return;
                    }

                }
            }
        }
    }//GEN-LAST:event_codigoBarrasTxtKeyPressed

    private void comboProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboProductosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (comboProductos.getSelectedIndex() > 0) {
                nombreProductoABuscarTxt.setText("");
                nombreProductoABuscarTxt.setEnabled(false);
                buscarProductoXNombreBtn.setEnabled(false);
                try {
                    Integer seleccion = comboProductos.getSelectedIndex();
                    productoSeleccionado = new ProductoService().getProductosByFiltroActivosSinDepo(filtro).get(seleccion - 1);
                    codigoProductoTxt.setText(String.valueOf(productoSeleccionado.getCodigo()));
                    consultarProducto();
                    cantidadTxt.requestFocus();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error - buscar producto");
                    Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_comboProductosKeyPressed

    private void comboClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboClientesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (comboClientes.getSelectedIndex() > 0) {
                nombreClienteABuscarTxt.setText("");
                try {
                    Integer seleccion = comboClientes.getSelectedIndex();
                    clienteSeleccionado = new ClienteService().getClientesByFiltro(filtro).get(seleccion - 1);
                    codigoTxt.setText(clienteSeleccionado.getCodigo());
                    buscar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error - buscar cliente");
                    Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_comboClientesKeyPressed

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
            terminarBtn.setEnabled(false);
            tablaNotaCredito.setEnabled(false);
            agregarBtn.setEnabled(false);
            eliminarItemBtn.setEnabled(false);
        }
    }//GEN-LAST:event_leerCantidadBtnActionPerformed

    private void leerPrecioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerPrecioBtnActionPerformed
        leerPrecio();
    }//GEN-LAST:event_leerPrecioBtnActionPerformed

    private void grabarCantidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarCantidadBtnActionPerformed
        grabarCantidad();
        
    }//GEN-LAST:event_grabarCantidadBtnActionPerformed

    private void grabarPrecioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarPrecioBtnActionPerformed
        grabarPrecio();
    }//GEN-LAST:event_grabarPrecioBtnActionPerformed

    private void descuentoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descuentoBtnActionPerformed
        int row = tablaNotaCredito.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un Producto");
            return;
        }
        int pr = renglonNotaCredito.get(row).getCodigoProducto();
        if (renglonNotaCredito.get(row).getDescuento() > 0.00) {
            JOptionPane.showMessageDialog(this, "DESCUENTO YA REALIZADO");
            return;
        }
        Producto p = null;
        try {
            p = new ProductoService().getProductoByCodigo(pr);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR LEYENDO PRODUCTO");
            return;
        }
        if (p.getLlevaDto() != null) {
            if (p.getLlevaDto()) {
                JOptionPane.showMessageDialog(this, "DESCUENTO NO PERMITIDO");
                return;
            }
        }
        if (p != null) {
            Rubro ru = p.getRubro();
            int cR = ru.getCodigo();
            if (cR != 5) {
                JOptionPane.showMessageDialog(this, "DESCUENTO NO PERMITIDO");
                return;
            }
            if (habilitado()) {
                descuentoLineaTxt.setEnabled(true);
                descuentoBtn.setEnabled(false);
                tablaNotaCredito.setEnabled(false);
                descuentoLineaTxt.requestFocus();
            }
        }
    }//GEN-LAST:event_descuentoBtnActionPerformed

    private void descuentoLineaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descuentoLineaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (descuentoLineaTxt.getText().isEmpty()) {
                descuentoLineaTxt.setEnabled(false);
                agregarBtn.requestFocus();
                return;
            }
            descuentoBtn.setEnabled(true);
            int row = tablaNotaCredito.getSelectedRow();
            int pr = renglonNotaCredito.get(row).getCodigoProducto();
            Producto p = null;
            try {
                p = new ProductoService().getProductoByCodigo(pr);
            } catch (Exception ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (p != null) {
                Rubro ru = p.getRubro();
                int cR = ru.getCodigo();
                if (cR != 5) {
                    JOptionPane.showMessageDialog(this, "DESCUENTO NO PERMITIDO");
                    return;
                }
            }
            int dtoLinea = Integer.valueOf(descuentoLineaTxt.getText());
            Double totNuevo0 = renglonNotaCredito.get(row).getTotal();
            Double totNuevo1 = totNuevo0 * dtoLinea / 100;
            String tn1 = df.format(totNuevo1);
            Double totNuevo2 = totNuevo0 - totNuevo1;
            String tn2 = df.format(totNuevo2);
            Double desc = Double.valueOf(tn1.replace(",", "."));
            Double totL = Double.valueOf(tn2.replace(",", "."));
            Rental rf = renglonNotaCredito.get(row);
            rf.setDescuento(desc);
            rf.setTotal(totL);
            renglonNotaCredito.set(row, rf);
            tablaNotaCredito.setValueAt(df.format(desc), row, 7);
            tablaNotaCredito.setValueAt(df.format(totL), row, 8);
            tablaNotaCredito.setEnabled(true);
            calcularTotales();
            descuentoLineaTxt.setText("");
            descuentoLineaTxt.setEnabled(false);
            descuentoBtn.setEnabled(true);
            agregarBtn.requestFocus();
            codigoProductoTxt.setEnabled(false);
            codigoBarrasTxt.setEnabled(false);
            cantidadTxt.setEnabled(false);
            incorporarANotaCreditoBtn.setEnabled(false);
            cantidadTxt.setText("");
            codigoProductoTxt.setText("");
            buscarProductoXNombreBtn.setEnabled(false);
            nombreProductoABuscarTxt.setEnabled(false);
            comboProductos.setEnabled(false);
            texto1PieNcTxt.setEnabled(true);
            texto2PieNcTxt.setEnabled(true);
        }
    }//GEN-LAST:event_descuentoLineaTxtKeyPressed

    private void recalcularBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recalcularBtnActionPerformed
        calcularTotales();
        agregarBtn.requestFocus();
    }//GEN-LAST:event_recalcularBtnActionPerformed

    private void nuevoPrecioTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevoPrecioTxtKeyPressed
        if(evt.getKeyCode() == 10){
            grabarPrecio();
        }
    }//GEN-LAST:event_nuevoPrecioTxtKeyPressed

    private void nuevaCantidadTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevaCantidadTxtKeyPressed
        if(evt.getKeyCode() == 10){
            grabarCantidad();
        }
    }//GEN-LAST:event_nuevaCantidadTxtKeyPressed

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
            java.util.logging.Logger.getLogger(NotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotaCreditoFrame(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JButton buscarClienteBtn;
    private javax.swing.JButton buscarClienteXNombre;
    private javax.swing.JButton buscarProductoXNombreBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField cantidadAtadosMassalinTxt;
    private javax.swing.JTextField cantidadAtadosNoblezaTxt;
    private javax.swing.JTextField cantidadItemsTxt;
    private javax.swing.JTextField cantidadTxt;
    private javax.swing.JTextField codigoBarrasTxt;
    private javax.swing.JTextField codigoProductoTxt;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JComboBox comboClientes;
    private javax.swing.JComboBox comboProductos;
    private javax.swing.JButton descuentoBtn;
    private javax.swing.JLabel descuentoGlobalLbl;
    private javax.swing.JTextField descuentoGlobalTxt;
    private javax.swing.JTextField descuentoLineaTxt;
    private javax.swing.JTextField descuentoVolumenTxt;
    private javax.swing.JButton eliminarItemBtn;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JButton grabarCantidadBtn;
    private javax.swing.JButton grabarPrecioBtn;
    private javax.swing.JTextField importeMassalinTxt;
    private javax.swing.JTextField importeNoblezaTxt;
    private javax.swing.JCheckBox imprimeCbx;
    private javax.swing.JButton incorporarANotaCreditoBtn;
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextField nombreClienteABuscarTxt;
    private javax.swing.JTextField nombreProductoABuscarTxt;
    private javax.swing.JTextField nombreProductoConsultaTxt;
    private javax.swing.JTextField nuevaCantidadTxt;
    private javax.swing.JTextField nuevoPrecioTxt;
    private javax.swing.JTextField precioProductoConsultaTxt;
    private javax.swing.JTextField razonSocialTxt;
    private javax.swing.JButton recalcularBtn;
    private javax.swing.JTextField saldoTxt;
    private javax.swing.JTable tablaNotaCredito;
    private javax.swing.JButton terminarBtn;
    private javax.swing.JTextField texto1PieNcTxt;
    private javax.swing.JTextField texto2PieNcTxt;
    private javax.swing.JTextField totalCompraActualTxt;
    private javax.swing.JTextField totalDeudaTxt;
    private javax.swing.JTextField totalTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        texto1PieNcTxt.setText("");
        texto2PieNcTxt.setText("");
        cantidadAtadosMassalinTxt.setText("");
        cantidadAtadosNoblezaTxt.setText("");
        ivaTxt.setText("");
        codigoBarrasTxt.setText("");
        codigoProductoTxt.setText("");
        codigoTxt.setText("");
        fechaTxt.setText("");
        razonSocialTxt.setText("");
        cantidadTxt.setText("");
        totalTxt.setText("");
        saldoTxt.setText("0.00");
        totalTxt.setText("0.00");
        comboClientes.removeAllItems();
        comboClientes.addItem("");
        comboProductos.removeAllItems();
        comboProductos.addItem("");
        nombreClienteABuscarTxt.setText("");
        nombreProductoABuscarTxt.setText("");
        totalDeudaTxt.setText("0.00");
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        nombreProductoConsultaTxt.setText("");
        precioProductoConsultaTxt.setText("");
        cantidadItemsTxt.setText("");
        descuentoGlobalTxt.setText("");
        nuevaCantidadTxt.setText("");
        nuevoPrecioTxt.setText("");
        importeMassalinTxt.setText("");
        importeNoblezaTxt.setText("");
        imprimeCbx.setSelected(true);
        descuentoLineaTxt.setText("");
        totalCompraActualTxt.setText("");
        descuentoVolumenTxt.setText("");
    }

    private boolean habilitado() {
        FileReader fr = null;
        //Boolean habilita = false;
        try {
            fr = new FileReader("c:/ventas/permisos.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(fr);
        String acceso = "";
        try {
            acceso = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (acceso.equals("1")) {
            return true;
        }
        habilitar();
        if (usuario != null) {
            return true;
        } else {
            return false;
        }
    }
    
    private void habilitar() {
        usuario = null;
        JTextField field = new JTextField("");
        String[] options = {"Ingresar"};
        int result = JOptionPane.showOptionDialog(
                null,
                field,
                "Autorización de USUARIO",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                0);
        if (field.getText().isEmpty()) {
            usuario = null;
            return;
        }
        switch (result) {
            case 0:
                int cod = Integer.valueOf(field.getText());
                try {
                    usuario = new UsuarioService().getUsuarioByCodigo(cod);
                } catch (Exception ex) {
                    Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (usuario != null) {
                    if (usuario.getActivo()) {
                        JPasswordField field2 = new JPasswordField("");
                        String[] opts = {"Ingresar"};
                        int resulta = JOptionPane.showOptionDialog(
                                null,
                                field2,
                                "CONTRASEÑA: " + usuario.getNombre() + ", Autorización",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opts,
                                0);
                        switch (resulta) {
                            case 0:
                                int contra = Integer.valueOf(new String(field2.getPassword()));
                                if (contra == usuario.getContrasena()) {
                                    if (usuario.getNivel() > nivel) {
                                        JOptionPane.showMessageDialog(this, "Usuario no Habilitado");
                                        usuario = null;
                                    } else {
                                        String f1 = sdf.format(usuario.getFecha());
                                        String f2 = sdf.format(new Date());
                                        if (usuario.getNivel() == 2) {
                                            if (!f1.equals(f2)) {
                                                JOptionPane.showMessageDialog(this, "Permiso de Usuario Vencido");
                                                usuario = null;
                                            }
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
                                    usuario = null;
                                }
                                break;
                            case 1:
                                usuario = null;
                                break;
                            case -1:
                                usuario = null;
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "USUARIO Inactivo");
                        usuario = null;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No existe el Usuario");
                    usuario = null;
                }
                break;
            case 1:
                usuario = null;
                break;
            case -1:
                usuario = null;
                break;
        }
    }
    
    private void bloquearCampos() {
        agregarBtn.setEnabled(false);
        cancelarBtn.setEnabled(false);
        terminarBtn.setEnabled(false);
        incorporarANotaCreditoBtn.setEnabled(false);
        buscarProductoXNombreBtn.setEnabled(false);
        eliminarItemBtn.setEnabled(false);
        ivaTxt.setEditable(false);
        codigoBarrasTxt.setEnabled(false);
        codigoTxt.setEnabled(true);
        codigoTxt.setEditable(true);
        codigoProductoTxt.setEnabled(false);
        fechaTxt.setEditable(false);
        razonSocialTxt.setEditable(false);
        cantidadTxt.setEnabled(false);
        totalTxt.setEnabled(false);
        saldoTxt.setEditable(false);
        totalDeudaTxt.setEnabled(false);
        nombreProductoABuscarTxt.setEnabled(false);
        nombreProductoConsultaTxt.setEnabled(false);
        comboProductos.setEnabled(false);
        precioProductoConsultaTxt.setEnabled(false);
        cantidadItemsTxt.setEnabled(false);
        texto1PieNcTxt.setEnabled(false);
        texto2PieNcTxt.setEnabled(false);
        cantidadAtadosMassalinTxt.setEditable(false);
        cantidadAtadosNoblezaTxt.setEditable(false);
        descuentoGlobalTxt.setEditable(false);
        leerCantidadBtn.setEnabled(false);
        leerPrecioBtn.setEnabled(false);
        nuevaCantidadTxt.setEnabled(false);
        nuevoPrecioTxt.setEnabled(false);
        grabarCantidadBtn.setEnabled(false);
        grabarPrecioBtn.setEnabled(false);
        importeMassalinTxt.setEditable(false);
        importeNoblezaTxt.setEditable(false);
    }

    private void llenarComboClientes() {
        filtro = nombreClienteABuscarTxt.getText();
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            clientes = new ClienteService().getClientesByFiltro(filtro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - leyendo Clientes");
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboClientes.getModel();
        if (clientes != null && !clientes.isEmpty()) {
            for (Cliente cli : clientes) {
                model.addElement(cli.getRazonSocial());
            }
            comboClientes.setModel(model);
        }
    }

    private void llenarComboProductos() {
        filtro = nombreProductoABuscarTxt.getText();
        List<Producto> productos = new ArrayList<Producto>();
        try {
            productos = new ProductoService().getProductosByFiltroActivosSinDepo(filtro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - leyendo Productos");
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboProductos.getModel();
        if (productos != null && !productos.isEmpty()) {
            for (Producto pro : productos) {
                model.addElement(pro.getDetalle());
            }
            comboProductos.setModel(model);
        }
    }

    private void bloquearCliente() {
        String s = clienteNotaCredito.getCodigo();
        ClienteTraba ct = null;
        try {
            ct = new ClienteTrabaService().getClienteByCodigo(s);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ct.setTraba1(true);
        try {
            new ClienteTrabaService().updateCliente(ct);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void desbloquearCliente() {
        String s = clienteNotaCredito.getCodigo();
        ClienteTraba ct = null;
        try {
            ct = new ClienteTrabaService().getClienteByCodigo(s);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ct.setTraba1(false);
        try {
            new ClienteTrabaService().updateCliente(ct);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buscar() {
        filtro = "";
        Long id = (long) 1;
        try {
            Routines conf = new RoutinesService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha = Calendar.getInstance().getTime();
        categoriaIva = 2;
        try {
            clienteNotaCredito = new ClienteService().getClienteByCodigo(codigoTxt.getText());
            clienteNC = new CustomerService().getCustomerByCodigo(codigoTxt.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - cliente");
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clienteNotaCredito != null) {
            String c = clienteNotaCredito.getCodigo();
            ClienteTraba ct = null;
            CustomerTraba cuTr = null;
            try {
                ct = new ClienteTrabaService().getClienteByCodigo(c);
                cuTr = new CustomerTrabaService().getClienteByCodigo(c);
            } catch (Exception ex) {
                Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (ct.getTraba1() != null) {
                if (ct.getTraba1()) {
                    JOptionPane.showMessageDialog(this, "Cliente bloqueado para esta Operación");
                    buscarClienteBtn.setEnabled(true);
                    codigoTxt.requestFocus();
                    return;
                }
            }
            if (cuTr.getTraba2() != null) {
                if (cuTr.getTraba2()) {
                    JOptionPane.showMessageDialog(this, "Cliente bloqueado para esta Operación");
                    buscarClienteBtn.setEnabled(true);
                    codigoTxt.requestFocus();
                    return;
                }
            }
            bloquearCliente();
            razonSocialTxt.setText(clienteNotaCredito.getRazonSocial());
            fechaTxt.setText(sdf.format(fecha));
            ivaTxt.setText("--");
            if(clienteNC.getTieneDescuento() != null){
                if(clienteNC.getTieneDescuento()){
                    descuentoGlobalTxt.setText(df1.format(clienteNC.getDescuento()));
                    tieneDto = true;
                    descuen = clienteNC.getDescuento();
                }else{
                    descuentoGlobalTxt.setText(df1.format(0));
                    tieneDto = false;
                    descuen = 0F;
                }
            }else{
                descuentoGlobalTxt.setText(df1.format(0));
                tieneDto = false;
                descuen = 0F;
            }
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
            //Boolean terminar = false;
            agregarBtn.setEnabled(true);
            buscarClienteBtn.setEnabled(false);
            volverBtn.setEnabled(false);
            buscarClienteXNombre.setEnabled(false);
            nombreClienteABuscarTxt.setEnabled(false);
            comboClientes.setEnabled(false);
            nombreProductoConsultaTxt.setEditable(false);
            precioProductoConsultaTxt.setEditable(false);
            codigoTxt.setEditable(false);
            descuentoVolumenTxt.setEnabled(true);
            descuentoVolumenTxt.setEditable(false);
            totalTxt.setEnabled(true);
            totalTxt.setEditable(false);
            totalDeudaTxt.setEnabled(true);
            totalDeudaTxt.setEditable(false);
            leerCantidadBtn.setEnabled(true);
            nuevaCantidadTxt.setEnabled(true);
            leerPrecioBtn.setEnabled(true);
            nuevoPrecioTxt.setEnabled(true);
            agregarProducto();
            cancelarBtn.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Error - cliente no existe");
            buscarClienteBtn.setEnabled(true);
            codigoTxt.requestFocus();
        }
    }

    private void terminarNotaCredito() {
        Integer categoriaIva = 0;
        desbloquearCliente();
        Activity ivaVentas = new Activity();
        categoriaIva = clienteNotaCredito.getCategoriaDeIva();
        //saldoCliente = clienteNotaCredito.getSaldo() + clienteNC.getSaldo();
        //Double saldoCalculo = totalNotaCredito + saldoCliente;
        //clienteNotaCredito.setSaldo(saldoCliente);
        String g = clienteNC.getCodigo();
        Long id_v;
        if (clienteNotaCredito.getVendedor() != null) {
            id_v = clienteNotaCredito.getVendedor().getId();
        } else {
            id_v = 99L;
        }
        clienteNC.setSaldo(totalNotaCredito + clienteNC.getSaldo());
        Double saldo1 = 0.00;
        if (clienteNotaCredito.getSaldo() != null) {
            saldo1 = clienteNotaCredito.getSaldo();
        }
        try {
            new CustomerService().updateCustomer(clienteNC);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            clienteNC = new CustomerService().getCustomerByCodigo(g);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long id = (long) 1;
        try {
            config = new RoutinesService().getFacturas(id);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        config.setUltimaFechaSistema(fecha);
        if (categoriaIva.equals(1)) {
            letraNotaCredito = "A";
            // es inscriptp
            sucursalNotaCredito = config.getSucursal();
            numeroNotaCredito = config.getNumeroFactura();
            numeroNotaCredito += 1;
            config.setNumeroFactura(numeroNotaCredito);
            try {
                new RoutinesService().updateRoutines(config);
            } catch (Exception ex) {
                Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            letraNotaCredito = "B";
            // el resto de las categorias
            sucursalNotaCredito = config.getSucursal();
            numeroNotaCredito = config.getNumeroFactura();
            numeroNotaCredito += 1;
            config.setNumeroFactura(numeroNotaCredito);
            try {
                new RoutinesService().updateRoutines(config);
            } catch (Exception ex) {
                Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ivaVentas.setCustomer(clienteNC);
        ivaVentas.setIdVendedor(id_v);
        ivaVentas.setDescuentoGlobal(totalDescuen);
        ivaVentas.setPorcentajeDescuentoGlobal(descuen);
        ivaVentas.setExento(0.0);
        ivaVentas.setFecha(fecha);
        ivaVentas.setFechaCae(fecha);
        ivaVentas.setCae(0L);
        String est = df.format(totalGravado);
        totalGravado = Double.valueOf(est.replace(",", "."));
        ivaVentas.setGravado(totalGravado);
        ivaVentas.setImpuesto(totalImpuesto);
        est = df.format(totalIva);
        totalIva = Double.valueOf(est.replace(",", "."));
        ivaVentas.setIva(totalIva);
        ivaVentas.setNoGravado(0.0);
        ivaVentas.setTotal(totalNotaCredito);
        ivaVentas.setLetra(letraNotaCredito);
        ivaVentas.setNumeroSucursal(sucursalNotaCredito);
        ivaVentas.setNumeroFactura(numeroNotaCredito);
        Vendedor ve = clienteNotaCredito.getVendedor();
        ivaVentas.setIdVendedor(ve.getId());
        ivaVentas.setGravadoCigarrillos(totalGravadoCigarrillos);
        String st0 = df.format(saldoCliente);
        saldoCliente = Double.valueOf(st0.replace(",","."));
        ivaVentas.setSaldoActual1(saldo1);
        ivaVentas.setSaldoActual2(saldoCliente);
        if(!texto1PieNcTxt.getText().isEmpty()){
            ivaVentas.setTextoPieFactura1(texto1PieNcTxt.getText());
        }else{
            ivaVentas.setTextoPieFactura1("");
        }
        if(!texto2PieNcTxt.getText().isEmpty()){
            ivaVentas.setTextoPieFactura2(texto2PieNcTxt.getText());
        }else{
            ivaVentas.setTextoPieFactura2("");
        }
        try {
            ivaVentas = new NotaCreditoService().saveDevolucionCompleta(ivaVentas, renglonNotaCredito);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
        ccc.setSaldo(clienteNC.getSaldo());
        ccc.setFactura(null);
        ccc.setRecibo(null);
        try {
            new InventoryService().saveInventory(ccc);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        generarNotaCredito();
        MainFrame ff = new MainFrame();
        ff.setVisible(true);
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
        //vencimientoNotaCreditoPapel = sdf.format(fechaVto);
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
            nombresColumnaNotaCreditoPapel = "IT   CANT                   DETALLE                  P.UNIT.     DESC.      IMPORTE       IMP.        TOTAL        SUG";
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
        agregarBtn.setEnabled(false);
        if (nro > 0) {
            terminarBtn.setEnabled(true);
        } else {
            terminarBtn.setEnabled(false);
        }
        incorporarANotaCreditoBtn.setEnabled(true);
        if (nro > 0) {
            cancelarBtn.setEnabled(true);
        }
        buscarProductoXNombreBtn.setEnabled(true);
        codigoProductoTxt.setEnabled(true);
        codigoBarrasTxt.setEnabled(true);
        cantidadTxt.setEnabled(true);
        nombreProductoABuscarTxt.setEnabled(true);
        nombreProductoConsultaTxt.setEnabled(true);
        comboProductos.setEnabled(true);
        leerCantidadBtn.setEnabled(false);
        leerPrecioBtn.setEnabled(false);
        nuevoPrecioTxt.setEnabled(false);
        nuevaCantidadTxt.setEnabled(false);
        //codigoBarrasTxt.requestFocus();
        nombreProductoABuscarTxt.requestFocus();
    }

    private void buscarProducto() {
        traba = 0;
        filtro = "";
        if (nro < maxNro - 1) {
            agregarBtn.setEnabled(true);
        } else {
            agregarBtn.setEnabled(false);
        }
        terminarBtn.setEnabled(true);
        eliminarItemBtn.setEnabled(true);
        cancelarBtn.setEnabled(true);
        Producto pro = null;
        encontrado = false;
        if (!codigoBarrasTxt.getText().isEmpty()) {
            try {
                pro = new ProductoService().getProductoByCodigoBarras(Long.valueOf(codigoBarrasTxt.getText()));
                encontrado = true;
            } catch (Exception ex) {
                Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
                codigoBarrasTxt.requestFocus();
            }
        } else {
            if (!codigoProductoTxt.getText().isEmpty()) {
                try {
                    pro = new ProductoService().getProductoByCodigo(Integer.valueOf(codigoProductoTxt.getText()));
                    encontrado = true;
                } catch (Exception ex) {
                    Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
                    codigoBarrasTxt.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese Código de Producto o Código de Barras");
                codigoBarrasTxt.requestFocus();
            }
        }
        if (pro != null) {
            if (pro.getInactivo() != null) {
                if (!pro.getInactivo()) {
                    //if (!pro.getSubRubro().getCodigo().equals(5099)) {
                    cantidad = Float.valueOf(cantidadTxt.getText());
                    // en unidad
                    if (!(cantidad > 0.0)) {
                        JOptionPane.showMessageDialog(this, "Debe colocar cantidad mayor que cero");
                        cantidadTxt.requestFocus();
                        return;
                    }
                    precioFinal = rint(((-pro.getPrecio() * (1 + (porcentualIva / 100))) + -pro.getImpuesto()) * 100) / 100;
                    // por cantidad
                    gravado = rint((-pro.getPrecio() * cantidad) * 100) / 100;
                    impuesto = rint(-pro.getImpuesto() * cantidad * 100) / 100;
                    iva = rint(gravado * 21) / 100;
                    totalLinea = rint((gravado + impuesto + iva) * 100) / 100;
                    Rental rf = new Rental();
                    rf.setCantidad(cantidad);
                    rf.setDescripcion(pro.getDetalle());
                    rf.setDescuento(0.0);
                    rf.setExento(0.0);
                    rf.setGravado(gravado);
                    rf.setImpuesto(impuesto);
                    rf.setIva(iva);
                    rf.setNoGravado(noGravado);
                    rf.setCodigoProducto(pro.getCodigo());
                    rf.setSugerido(pro.getSugerido());
                    rf.setTotal(totalLinea);
                    nro += 1;
                    renglonNotaCredito.add(rf);
                    calcularTotales();
                    Object[] fila = new Object[10];
                    fila[0] = pro.getCodigo();
                    fila[1] = cantidadTxt.getText();
                    fila[2] = pro.getDetalle();
                    fila[3] = df.format(precioFinal);
                    fila[4] = df.format(gravado);
                    fila[5] = df.format(impuesto);
                    fila[6] = df.format(iva);
                    fila[7] = df.format(0.0);
                    fila[8] = df.format(totalLinea);
                    fila[9] = df.format(pro.getSugerido());
                    tabla.addRow(fila); // Agrego la fila a la tabla
                    Rectangle rect = tablaNotaCredito.getCellRect(nro - 1, 0, true);
                    tablaNotaCredito.scrollRectToVisible(rect);
                    tablaNotaCredito.clearSelection();
                    tablaNotaCredito.setRowSelectionInterval(nro - 1, nro - 1);
                    tablaNotaCredito.setModel(tabla); // poner visible la tabla
                    codigoProductoTxt.setEnabled(false);
                    codigoBarrasTxt.setEnabled(false);
                    cantidadTxt.setEnabled(false);
                    incorporarANotaCreditoBtn.setEnabled(false);
                    cantidadTxt.setText("");
                    codigoProductoTxt.setText("");
                    buscarProductoXNombreBtn.setEnabled(false);
                    nombreProductoABuscarTxt.setEnabled(false);
                    comboProductos.setEnabled(false);
                    texto1PieNcTxt.setEnabled(true);
                    texto2PieNcTxt.setEnabled(true);
//                    } else {
//                        JOptionPane.showMessageDialog(this, "Error - producto no disponible");
//                        codigoProductoTxt.setText("");
//                        cantidadTxt.setText("");
//                        nombreProductoABuscarTxt.setText("");
//                        agregarBtn.setEnabled(false);
//                        codigoBarrasTxt.requestFocus();
//                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Error - producto inactivo");
                    codigoProductoTxt.setText("");
                    cantidadTxt.setText("");
                    buscarClienteBtn.setEnabled(false);
                    codigoBarrasTxt.requestFocus();
                    //codigoProductoTxt.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error - producto inactivo");
                codigoProductoTxt.setText("");
                cantidadTxt.setText("");
                buscarClienteBtn.setEnabled(false);
                codigoBarrasTxt.requestFocus();
                //codigoProductoTxt.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error - producto no existe");
            codigoProductoTxt.setText("");
            codigoBarrasTxt.requestFocus();
            //codigoProductoTxt.requestFocus();
        }
        comboProductos.removeAllItems();
        comboProductos.addItem("");
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

    private void consultarProducto() {
        nombreProductoConsultaTxt.setEnabled(true);
        precioProductoConsultaTxt.setEnabled(true);
        if (!codigoProductoTxt.getText().isEmpty()) {
            Integer codi = Integer.valueOf(codigoProductoTxt.getText());
            try {
                Producto prod = new ProductoService().getProductoByCodigo(codi);
                //if (!prod.getSubRubro().getCodigo().equals(5099)) {
                nombreProductoConsultaTxt.setText(prod.getDetalle());
                Double precioProductoConsulta = prod.getPrecio();
                precioProductoConsulta += precioProductoConsulta * porcentualIva / 100;
                if (prod.getImpuesto() != null) {
                    precioProductoConsulta += prod.getImpuesto();
                }
                precioProductoConsultaTxt.setText(String.valueOf(df.format(precioProductoConsulta)));
                cantidadTxt.requestFocus();
                //}
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No existe Producto");
                //Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                codigoProductoTxt.setText("");
                codigoProductoTxt.requestFocus();
            }
        }
    }

    private void calcularTotales() {
        totalGravado = 0.0;
        totalIva = 0.0;
        totalImpuesto = 0.0;
        totalDescuen = 0.0;
        //totalDtoUni = 0.0;
        totalNotaCredito = 0.0;
        nro = 0;
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        Double importeTotalMassalin = 0.0;
        Double importeTotalNobleza = 0.0;
        Double totalCalculo = 0.0;
        for (Rental renFa : renglonNotaCredito) {
            totalGravado += renFa.getGravado();
            iva = rint(renFa.getGravado() * porcentualIva) / 100;
            totalIva += iva;
            int codi = renFa.getCodigoProducto();
            Producto produ = null;
            try {
                produ = new ProductoService().getProductoByCodigo(codi);
            } catch (Exception ex) {
                Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
            
            
            
            
            
            if (tieneDto) {
                if (produ.getRubro().getCodigo().equals(5)) {
                    totalCalculo += renFa.getTotal();
                }
            }
            cantidadAtadosNoblezaTxt.setText(String.valueOf(cantidadAtadosNobleza));
            importeNoblezaTxt.setText(String.valueOf(df.format(importeTotalNobleza)));
            totalImpuesto += renFa.getImpuesto();
            totalNotaCredito += renFa.getTotal();
            nro += 1;
            renFa.setItemNro(nro);
        }
        if(tieneDto){
            Double tD0 = totalCalculo * descuen / 100;
            String tD1 = df.format(tD0);
            totalDescuen = Double.valueOf(tD1.replace(",", "."));
            totalGravado -= totalDescuen;
        } else {
            totalDescuen = 0.0;
        }
        descuentoVolumenTxt.setText(df.format(totalDescuen));
        cantidadItemsTxt.setText(String.valueOf(nro));
        totalNotaCredito = rint((totalNotaCredito - totalDescuen) * 100) / 100;
        totalTxt.setText(df.format(totalNotaCredito));
        totalDeudaTxt.setText(df.format(saldoCliente + totalNotaCredito));
        String codClie = clienteNC.getCodigo();
        Cliente xCli = null;
        try {
            xCli = new ClienteService().getClienteByCodigo(codClie);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Double calcu = 0.00;
        if (xCli != null) {
            if (xCli.getImporteMostrador() != null) {
                totalCompraActualTxt.setText(df.format(xCli.getImporteMostrador()));
                calcu += xCli.getImporteMostrador();
            }
            calcu += xCli.getSaldo();
            calcu += clienteNC.getSaldo();
            calcu += totalNotaCredito;
        }
        totalDeudaTxt.setText(df.format(calcu));
    }

    private void consultarProductoBarras() {
        nombreProductoConsultaTxt.setEnabled(true);
        precioProductoConsultaTxt.setEnabled(true);
        if (!codigoBarrasTxt.getText().isEmpty()) {
            Long codigoBarras = Long.valueOf(codigoBarrasTxt.getText());
            try {
                Producto prod = new ProductoService().getProductoByCodigoBarras(codigoBarras);
                nombreProductoConsultaTxt.setText(prod.getDetalle());
                Double precioProductoConsulta = prod.getPrecio();
                precioProductoConsulta += precioProductoConsulta * porcentualIva / 100;
                if (prod.getImpuesto() != null) {
                    precioProductoConsulta += prod.getImpuesto();
                }
                precioProductoConsultaTxt.setText(String.valueOf(df.format(precioProductoConsulta)));
                cantidadTxt.requestFocus();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "No existe Producto");
                //Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                codigoProductoTxt.setText("");
                codigoProductoTxt.requestFocus();
            }
        }
    }

    private void cargarDatos() {
        // CLIENTE SELECCIONADO Y FACTURA
        limpiarCampos();
        codigoTxt.setText(clienteSeleccionado.getCodigo());
        razonSocialTxt.setText(clienteSeleccionado.getRazonSocial());
        try {
            clienteNC = new CustomerService().getCustomerByCodigo(clienteSeleccionado.getCodigo());
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        saldoTxt.setText(String.valueOf(df.format(clienteSeleccionado.getSaldo())));

        Long id = (long) 1;
        try {
            Configuracion conf = new ConfiguracionService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        sdf = new SimpleDateFormat("dd/MM/yyyy");
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
            categoriaIva = clienteNotaCredito.getCategoriaDeIva();
        } else {
            ivaTxt.setText("Consumidor Final");
        }
        agregarBtn.setEnabled(true);
        buscarClienteBtn.setEnabled(false);
        volverBtn.setEnabled(false);
        cancelarBtn.setEnabled(true);
        buscarClienteXNombre.setEnabled(false);
        nombreClienteABuscarTxt.setEnabled(false);
        comboClientes.setEnabled(false);
        nombreProductoConsultaTxt.setEditable(false);
        precioProductoConsultaTxt.setEditable(false);
        codigoTxt.setEditable(false);
        totalTxt.setEnabled(true);
        totalTxt.setEditable(false);
        totalDeudaTxt.setEnabled(true);
        totalDeudaTxt.setEditable(false);
        agregarProducto();
    }

    private void cargarRenglones() {
        try {
            renglonF = new RenglonFacturaService().getAllRenglonFacturaFromIvaVentas(factura);
            tabla = (DefaultTableModel) tablaNotaCredito.getModel();
            for (RenglonFactura rp : renglonF) {
                Rental rf = new Rental();
                rf.setCantidad(rp.getCantidad());
                rf.setCodigoProducto(rp.getProducto().getCodigo());
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
                linea[0] = rp.getProducto().getCodigo();
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
            agregarBtn.setEnabled(true);
            buscarClienteBtn.setEnabled(false);
            volverBtn.setEnabled(false);
            cancelarBtn.setEnabled(true);
            buscarClienteXNombre.setEnabled(false);
            nombreClienteABuscarTxt.setEnabled(false);
            comboClientes.setEnabled(false);
            nombreProductoConsultaTxt.setEditable(false);
            precioProductoConsultaTxt.setEditable(false);
            codigoTxt.setEditable(false);
            totalTxt.setEnabled(true);
            totalTxt.setEditable(false);
            totalDeudaTxt.setEnabled(true);
            totalDeudaTxt.setEditable(false);
            calcularTotales();
            cancelarBtn.setEnabled(true);
            terminarBtn.setEnabled(true);
            eliminarItemBtn.setEnabled(true);
            agregarBtn.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            tablaNotaCredito.setEnabled(false);
            grabarCantidadBtn.setEnabled(false);
            agregarBtn.setEnabled(false);
            eliminarItemBtn.setEnabled(false);
        }
    }

    private boolean isNumeric(KeyEvent evt) {
        String cod = String.valueOf(evt.getKeyChar());
        try {
            Integer.parseInt(cod);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    private void grabarCantidad() {
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
                agregarBtn.setEnabled(true);
                eliminarItemBtn.setEnabled(true);
                terminarBtn.setEnabled(true);
                tablaNotaCredito.setEnabled(true);
                calcularTotales();
                agregarBtn.requestFocus();
            }
        }
    }

    private void grabarPrecio() {
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
                agregarBtn.setEnabled(true);
                eliminarItemBtn.setEnabled(true);
                calcularTotales();
                tablaNotaCredito.requestFocus();
            }
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
                    g2.drawString(renglones[x], 40, row);
                }
                row += 10;
            }
            row += 20;
            if (tieneDto) {
                g2.drawString("Descuento: " + descuen + "% Total descuento: " + df.format(totalDescuen), 30, row);
            }
            row += 20;
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
