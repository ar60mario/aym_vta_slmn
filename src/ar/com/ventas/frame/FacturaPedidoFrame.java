/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.CustomerTraba;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Request;
import ar.com.ventas.entities.RequestRow;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Usuario;
import ar.com.ventas.services.ActivityRowService;
import ar.com.ventas.services.ActivityService;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.CustomerService;
import ar.com.ventas.services.CustomerTrabaService;
import ar.com.ventas.services.InventoryService;
import ar.com.ventas.services.PresupuestoService;
import ar.com.ventas.services.ProductoService;
import ar.com.ventas.services.RequestRowService;
import ar.com.ventas.services.RequestService;
import ar.com.ventas.services.RoutinesService;
import ar.com.ventas.services.UsuarioService;
import ar.com.ventas.util.DesktopApi;
import ar.com.ventas.util.PDFBuilder;
import com.itextpdf.text.DocumentException;
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
import java.io.File;
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
public class FacturaPedidoFrame extends javax.swing.JFrame {

    public List<ActivityRow> renglonFactura = new ArrayList<ActivityRow>();
    private String textoFacturaPapel;
    private String fechaFacturaPapel;
    private String clienteFacturaPapel;
    private String codigoClienteFacturaPapel;
    private String direccionFacturaPapel;
    private String cuitFacturaPapel;
    private String condicionVentaFacturaPapel;
    //private String vencimientoFacturaPapel;
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
    private Cliente clienteReferencia;
    private Producto producto = null;
    private DefaultTableModel tabla = null;
    private Double totalFactura = 0.00;
    private Double totalImpuesto = 0.00;
    private Double totalIva = 0.00;
    private Double totalGravado = 0.00;
    //private Double totalNoGravado = 0.0;
    private Double gravado = 0.00;
    private Double noGravado = 0.00;
    private Double iva = 0.00;
    private Float porcentualIva;
    private Double impuesto = null;
    private Double totalLinea = 0.00;
    private Boolean tieneDto = false;
    //private final Cliente clienteSeleccionado;
    private Producto productoSeleccionado;
    private Float cantidad;
    private Integer categoriaIva = 1;
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat df1 = new DecimalFormat("#0.0");
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
    private List<RequestRow> renglonP = null;
    private Request pedido;
    private Usuario usuario;
    private final Integer nivel = 1;
    private Float descuen = 0F;
    private Double totalDescuen = 0.0;
    //private double totalDtoUni = 0.0;

    /**
     * Creates new form FacturaPedidoFrame
     *
     * @param cli
     * @param pe
     */
    public FacturaPedidoFrame(Cliente cli, Request pe) {
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        initComponents();
        this.clienteReferencia = cli;
        try {
            clienteFactura = new CustomerService().getCustomerByCodigo(clienteReferencia.getCodigo());
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //clienteSeleccionado = clienteReferencia;
        this.pedido = pe;
        this.setLocationRelativeTo(null);
        limpiarCampos();
        bloquearCampos();
        tabla = (DefaultTableModel) tablaFactura.getModel();
        cargarDatosIniciales();
        cargarCliente();
        bloquearCliente();
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
        incorporarAFacturaBtn = new javax.swing.JButton();
        eliminarItemBtn = new javax.swing.JButton();
        buscarProductoXNombreBtn = new javax.swing.JButton();
        descuentoGlobalLbl = new javax.swing.JLabel();
        descuentoGlobalTxt = new javax.swing.JTextField();
        descuentoLineaLbl = new javax.swing.JLabel();
        descuentoLineaTxt = new javax.swing.JTextField();
        comboProductos = new javax.swing.JComboBox();
        nombreProductoABuscarTxt = new javax.swing.JTextField();
        descuentoBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        descuentoVolumenTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        totalDeudaTxt = new javax.swing.JTextField();
        texto1PieFacturaTxt = new javax.swing.JTextField();
        texto2PieFacturaTxt = new javax.swing.JTextField();
        nombreProductoConsultaTxt = new javax.swing.JTextField();
        precioProductoConsultaTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cantidadAtadosNoblezaTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cantidadItemsTxt = new javax.swing.JTextField();
        leerCantidadBtn = new javax.swing.JButton();
        nuevaCantidadTxt = new javax.swing.JTextField();
        grabarCantidadBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        totalMassalinTxt = new javax.swing.JTextField();
        totalNoblezaTxt = new javax.swing.JTextField();
        leerPrecioBtn = new javax.swing.JButton();
        nuevoPrecioTxt = new javax.swing.JTextField();
        grabarPrecioBtn = new javax.swing.JButton();
        cantidadAtadosMassalinTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        saldoOfTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        saldoTotalTxt = new javax.swing.JTextField();
        imprimeChk = new javax.swing.JCheckBox();
        pdfChk = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Notas de Pedido");
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
        saldoTxt.setForeground(new java.awt.Color(0, 0, 153));
        saldoTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        saldoTxt.setText("SALDO");

        jLabel8.setText("TOTAL PRESUPUESTO:");

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

        totalTxt.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        totalTxt.setForeground(new java.awt.Color(204, 0, 0));
        totalTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTxt.setText("TOTAL");

        terminarBtn.setText("Terminar Presup");
        terminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancel Presup");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        incorporarAFacturaBtn.setText("Ingresar a Presup");
        incorporarAFacturaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incorporarAFacturaBtnActionPerformed(evt);
            }
        });

        eliminarItemBtn.setText("Eliminar Item seleccionado");
        eliminarItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarItemBtnActionPerformed(evt);
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
        descuentoGlobalTxt.setText("DESCUENTO");

        descuentoLineaLbl.setText("Dscto:");

        descuentoLineaTxt.setText("DESCUENTO");
        descuentoLineaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descuentoLineaTxtKeyPressed(evt);
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

        nombreProductoABuscarTxt.setText("NOMBRE PRODUCTO A BUSCAR");
        nombreProductoABuscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreProductoABuscarTxtKeyPressed(evt);
            }
        });

        descuentoBtn.setText("Dto");
        descuentoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descuentoBtnActionPerformed(evt);
            }
        });

        jLabel12.setText("Descuento");

        descuentoVolumenTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoVolumenTxt.setText("DESCUENTO");

        jLabel13.setText("Total Deuda:");

        totalDeudaTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalDeudaTxt.setForeground(new java.awt.Color(0, 0, 153));
        totalDeudaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalDeudaTxt.setText("TOTAL DEUDA");

        texto1PieFacturaTxt.setText("TEXTO 1 PIE FACTURA");

        texto2PieFacturaTxt.setText("TEXTO 2 PIE FACTURA");

        nombreProductoConsultaTxt.setText("NOMBRE PRODUCTO CONSULTA");

        precioProductoConsultaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioProductoConsultaTxt.setText("PRECIO PROD CONSU");

        jLabel15.setText("Massalin:");

        jLabel17.setText("Nobleza:");

        cantidadAtadosNoblezaTxt.setText("Cant Nobl");

        jLabel18.setText("Cant. Items:");

        cantidadItemsTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadItemsTxt.setText("Cant Items");

        leerCantidadBtn.setText("Leer Cantidad");
        leerCantidadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerCantidadBtnActionPerformed(evt);
            }
        });

        nuevaCantidadTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nuevaCantidadTxt.setText("NUEV CANT");
        nuevaCantidadTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nuevaCantidadTxtKeyPressed(evt);
            }
        });

        grabarCantidadBtn.setText("Grabar Cantidad");
        grabarCantidadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarCantidadBtnActionPerformed(evt);
            }
        });

        jLabel19.setText("Importe:");

        jLabel20.setText("Importe:");

        totalMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalMassalinTxt.setText("TOT $ MASS");

        totalNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalNoblezaTxt.setText("TOT $ NOBL");

        leerPrecioBtn.setText("Leer Precio");
        leerPrecioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerPrecioBtnActionPerformed(evt);
            }
        });

        nuevoPrecioTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nuevoPrecioTxt.setText("NUEV PREC");
        nuevoPrecioTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nuevoPrecioTxtKeyPressed(evt);
            }
        });

        grabarPrecioBtn.setText("Grabar Precio");
        grabarPrecioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grabarPrecioBtnActionPerformed(evt);
            }
        });

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

        imprimeChk.setText("Imprime");

        pdfChk.setText("Pdf");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(totalDeudaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(133, 133, 133)
                                        .addComponent(agregarBtn)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(284, 284, 284)
                                                .addComponent(jLabel18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGap(141, 141, 141)
                                                .addComponent(imprimeChk)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(282, 282, 282)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(leerCantidadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nuevaCantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(grabarCantidadBtn))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(leerPrecioBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(pdfChk)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(nuevoPrecioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(grabarPrecioBtn))))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(texto1PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cancelarBtn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(texto2PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(terminarBtn))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(incorporarAFacturaBtn)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(descuentoLineaLbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(descuentoLineaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)))
                                        .addGap(18, 18, 18)
                                        .addComponent(descuentoBtn)))
                                .addGap(0, 75, Short.MAX_VALUE)))
                        .addGap(81, 81, 81))
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
                                .addGap(54, 54, 54)
                                .addComponent(descuentoGlobalLbl)
                                .addGap(18, 18, 18)
                                .addComponent(descuentoGlobalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel7))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(cantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(8, 8, 8)
                                                            .addComponent(codigoProductoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(38, 38, 38)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(precioProductoConsultaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(eliminarItemBtn)
                                                            .addComponent(nombreProductoConsultaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(4, 4, 4)
                                                    .addComponent(codigoBarrasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(125, 125, 125)
                                    .addComponent(jLabel8)
                                    .addGap(44, 44, 44)
                                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                            .addComponent(saldoTotalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(249, 249, 249)
                                            .addComponent(nombreProductoABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(buscarProductoXNombreBtn)))
                                    .addGap(41, 41, 41)
                                    .addComponent(jLabel12)
                                    .addGap(36, 36, 36)
                                    .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(208, 208, 208))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreProductoABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarProductoXNombreBtn)
                    .addComponent(jLabel6)
                    .addComponent(codigoBarrasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(descuentoVolumenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoProductoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreProductoConsultaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leerCantidadBtn)
                    .addComponent(nuevaCantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grabarCantidadBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descuentoLineaLbl)
                    .addComponent(descuentoLineaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precioProductoConsultaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leerPrecioBtn)
                    .addComponent(nuevoPrecioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grabarPrecioBtn)
                    .addComponent(descuentoBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarBtn)
                    .addComponent(eliminarItemBtn)
                    .addComponent(incorporarAFacturaBtn)
                    .addComponent(jLabel18)
                    .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(totalDeudaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imprimeChk)
                    .addComponent(pdfChk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto1PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto2PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(totalNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(totalMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar el Presupuesto?", "Atencion", JOptionPane.YES_NO_OPTION);
        // 0 = si; 1 = no
        if (escape == 0) {
            desbloquearCliente();
            PedidosPendientes ff = new PedidosPendientes();
            ff.setVisible(true);
            this.dispose();
        } else {
            incorporarAFacturaBtn.setEnabled(false);
            eliminarItemBtn.setEnabled(true);
            agregarBtn.setEnabled(true);
            agregarBtn.requestFocus();
            codigoBarrasTxt.setEnabled(false);
            codigoProductoTxt.setEnabled(false);
            cantidadTxt.setEnabled(false);
            nombreProductoABuscarTxt.setEnabled(false);
            comboProductos.setEnabled(false);
            tablaFactura.setEnabled(true);
            eliminarItemBtn.setEnabled(true);
            leerPrecioBtn.setEnabled(true);
            leerCantidadBtn.setEnabled(true);
            nuevoPrecioTxt.setEnabled(true);
            nuevaCantidadTxt.setEnabled(true);
            nuevoPrecioTxt.setText("");
            nuevaCantidadTxt.setText("");
            grabarCantidadBtn.setEnabled(false);
            grabarPrecioBtn.setEnabled(false);
            agregarBtn.requestFocus();
        }
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        eliminarItemBtn.setEnabled(false);
        texto1PieFacturaTxt.setEnabled(false);
        texto2PieFacturaTxt.setEnabled(false);
        codigoBarrasTxt.setText("");
        leerCantidadBtn.setEnabled(false);
        leerPrecioBtn.setEnabled(false);
        nuevoPrecioTxt.setEnabled(false);
        nuevaCantidadTxt.setEnabled(false);
        agregarProducto();
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void incorporarAFacturaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incorporarAFacturaBtnActionPerformed
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
    }//GEN-LAST:event_incorporarAFacturaBtnActionPerformed

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
                    Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_comboProductosActionPerformed

    private void terminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Quiere ingresar un texto antes de Imprimir?",
                "Texto en pie de Nota de Pedido",
                JOptionPane.YES_NO_OPTION);
        if (escape == 0) {
            texto1PieFacturaTxt.setEnabled(true);
            texto2PieFacturaTxt.setEnabled(true);
            texto1PieFacturaTxt.requestFocus();
        } else {
            terminarBtn.setEnabled(false);
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

    private void codigoProductoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoProductoTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!codigoProductoTxt.getText().isEmpty()) {
                consultarProducto();
                incorporarAFacturaBtn.setEnabled(true);
            } else {
                codigoBarrasTxt.requestFocus();
            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar la N-Pedido?", "Atencion", JOptionPane.YES_NO_OPTION);
                if (escape == 0) {
                    FacturarFrame ff = new FacturarFrame();
                    ff.setVisible(true);
                    this.dispose();
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
                        codigoProductoTxt.setText("");
                        codigoProductoTxt.requestFocus();
                    }
                }
            }
        }
    }//GEN-LAST:event_codigoProductoTxtKeyPressed

    private void cantidadTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!cantidadTxt.getText().isEmpty()) {
                if (!codigoBarrasTxt.getText().isEmpty()) {
                    buscarProducto();
                    if (nro < maxNro - 1) {
                        agregarBtn.setEnabled(true);
                        agregarBtn.requestFocus();
                    } else {
                        agregarBtn.setEnabled(false);
                        terminarBtn.requestFocus();
                    }
                } else {
                    if (!codigoProductoTxt.getText().isEmpty()) {
                        buscarProducto();
                        if (nro < maxNro - 1) {
                            agregarBtn.setEnabled(true);
                            agregarBtn.requestFocus();
                        } else {
                            agregarBtn.setEnabled(false);
                            terminarBtn.requestFocus();
                        }
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
                codigoBarrasTxt.requestFocus();
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
                        cantidadTxt.setText("");
                        cantidadTxt.requestFocus();

                    }
                }
            }
        }
    }//GEN-LAST:event_cantidadTxtKeyPressed

    private boolean isNumeric(KeyEvent evt) {
        String cod = String.valueOf(evt.getKeyChar());
        try {
            Integer.parseInt(cod);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    private void eliminarItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarItemBtnActionPerformed
        int selectRow = tablaFactura.getSelectedRow();
        if (selectRow != -1) {
            int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de Eliminar Item?", "Atencion", JOptionPane.YES_NO_OPTION);
            // 0 = si; 1 = no
            if (escape == 0) {
                tabla.removeRow(selectRow);
                renglonFactura.remove(selectRow);
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
        texto1PieFacturaTxt.setEnabled(false);
        texto2PieFacturaTxt.setEnabled(false);
        codigoBarrasTxt.setText("");
        agregarProducto();
    }//GEN-LAST:event_agregarBtnKeyPressed

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
                incorporarAFacturaBtn.setEnabled(true);
                //cantidadTxt.requestFocus();
            } else {
                nombreProductoABuscarTxt.requestFocus();
            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar la N-Pedido?", "Atencion", JOptionPane.YES_NO_OPTION);
                if (escape == 0) {
                    FacturarFrame ff = new FacturarFrame();
                    ff.setVisible(true);
                    this.dispose();
                } else {
                    codigoProductoTxt.setText("");
                    codigoBarrasTxt.setText("");
                    codigoBarrasTxt.requestFocus();
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
                    cantidadTxt.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_codigoBarrasTxtKeyPressed

    private void leerCantidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerCantidadBtnActionPerformed
        int lin = tablaFactura.getSelectedRow();
        if (lin > -1) {
            ActivityRow rf = renglonFactura.get(lin);
            nuevaCantidadTxt.setText(String.valueOf(rf.getCantidad().intValue()));
            leerCantidadBtn.setEnabled(false);
            grabarCantidadBtn.setEnabled(true);
            leerPrecioBtn.setEnabled(false);
            grabarPrecioBtn.setEnabled(false);
            tablaFactura.setEnabled(false);
            agregarBtn.setEnabled(false);
            eliminarItemBtn.setEnabled(false);
            terminarBtn.setEnabled(false);
            nuevoPrecioTxt.setEnabled(false);
        }
    }//GEN-LAST:event_leerCantidadBtnActionPerformed

    private void grabarCantidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarCantidadBtnActionPerformed
        int lin = tablaFactura.getSelectedRow();
        if (lin > -1) {
            if (!nuevaCantidadTxt.getText().isEmpty()) {
                leerCantidadBtn.setEnabled(true);
                grabarCantidadBtn.setEnabled(false);
                leerPrecioBtn.setEnabled(true);
                ActivityRow rf = renglonFactura.get(lin);
                Float cantidadAnterior = rf.getCantidad();
                Float cant = Float.valueOf(nuevaCantidadTxt.getText());
                if (!(cant > 0.0)) {
                    JOptionPane.showMessageDialog(this, "Debe colocar cantidad mayor que cero");
                    return;
                }
                rf.setCantidad(cant);
                Double precioUnitario = rf.getGravado() / cantidadAnterior;
                Double impuestoUnitario = rf.getImpuesto() / cantidadAnterior;
                renglonFactura.set(lin, rf);
                tablaFactura.setValueAt(cant.intValue(), lin, 1);
                // en unidad
                precioFinal = rint(((precioUnitario * (1 + (porcentualIva / 100))) + impuestoUnitario) * 100) / 100;
                tablaFactura.setValueAt(df.format(precioFinal), lin, 3);
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
                tablaFactura.setValueAt(df.format(gravado), lin, 4);
                tablaFactura.setValueAt(df.format(impuesto), lin, 5);
                tablaFactura.setValueAt(df.format(iva), lin, 6);
                tablaFactura.setValueAt(df.format(totalLinea), lin, 8);
                tablaFactura.setEnabled(true);
                agregarBtn.setEnabled(true);
                eliminarItemBtn.setEnabled(true);
                terminarBtn.setEnabled(true);
                nuevoPrecioTxt.setEnabled(true);
                leerPrecioBtn.setEnabled(true);

                calcularTotales();
                agregarBtn.requestFocus();
            }
        }
    }//GEN-LAST:event_grabarCantidadBtnActionPerformed

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
                    Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_comboProductosKeyPressed

    private void leerPrecioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerPrecioBtnActionPerformed
        int lin = tablaFactura.getSelectedRow();
        ActivityRow rf = renglonFactura.get(lin);
        if (rf.getDescuento() > 0.0) {
            JOptionPane.showMessageDialog(this, "No puede modificar Precio de este producto");
            leerPrecioBtn.setEnabled(true);
            grabarPrecioBtn.setEnabled(false);
            leerCantidadBtn.setEnabled(true);
            agregarBtn.requestFocus();
            return;
        }
        if (habilitado()) {
            leerPrecio();
        }
    }//GEN-LAST:event_leerPrecioBtnActionPerformed

    private void grabarPrecioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarPrecioBtnActionPerformed
        int lin = tablaFactura.getSelectedRow();
        if (lin > -1) {
            if (!nuevoPrecioTxt.getText().isEmpty()) {
                leerPrecioBtn.setEnabled(true);
                grabarPrecioBtn.setEnabled(false);
                leerCantidadBtn.setEnabled(true);
                ActivityRow rf = renglonFactura.get(lin);
                Float cant = rf.getCantidad();
                Double impuestoUnitario = rf.getImpuesto() / cant;
                Double nuevoImporte = Double.valueOf(nuevoPrecioTxt.getText()
                        .replaceAll("\\,", "\\.")) / (1 + (porcentualIva / 100));
                precioFinal = rint(((nuevoImporte * (1 + (porcentualIva / 100))) + impuestoUnitario) * 100) / 100;
                // por cantidad
                gravado = rint((nuevoImporte * cant) * 100) / 100;
                impuesto = rint(impuestoUnitario * cant * 100) / 100;
                iva = rint(gravado * 21) / 100;
                totalLinea = rint((gravado + impuesto + iva) * 100) / 100;
                rf.setGravado(gravado);
                rf.setIva(iva);
                rf.setTotal(totalLinea);
                tablaFactura.setValueAt(df.format(precioFinal), lin, 3);
                tablaFactura.setValueAt(df.format(gravado), lin, 4);
                tablaFactura.setValueAt(df.format(impuesto), lin, 5);
                tablaFactura.setValueAt(df.format(iva), lin, 6);
                tablaFactura.setValueAt(df.format(totalLinea), lin, 8);
                nuevoPrecioTxt.setText("");
                tablaFactura.setEnabled(true);
                agregarBtn.setEnabled(true);
                eliminarItemBtn.setEnabled(true);
                terminarBtn.setEnabled(true);
                nuevaCantidadTxt.setEnabled(true);
                leerCantidadBtn.setEnabled(true);
                calcularTotales();
            }
        }
    }//GEN-LAST:event_grabarPrecioBtnActionPerformed

    private void nuevaCantidadTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevaCantidadTxtKeyPressed
        if (evt.getKeyCode() != 10) {
            if (evt.getKeyCode() != 27) {
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
                        nuevaCantidadTxt.setText("");
                        nuevaCantidadTxt.requestFocus();
                    }
                }
            }
        }
    }//GEN-LAST:event_nuevaCantidadTxtKeyPressed

    private void nuevoPrecioTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevoPrecioTxtKeyPressed
        if (evt.getKeyCode() != 10) {
            if (evt.getKeyCode() != 27) {
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
                        && evt.getKeyCode() != 110 // punto decimal
                        //&& evt.getKeyCode() != 45 // Menos
                        && evt.getKeyCode() != 127) { // Suprimir
                    if (!isNumeric(evt)) {
                        JOptionPane.showMessageDialog(this, "Solo números");
                        nuevoPrecioTxt.setText("");
                        nuevoPrecioTxt.requestFocus();
                    }
                }
            }
        }
    }//GEN-LAST:event_nuevoPrecioTxtKeyPressed

    private void descuentoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descuentoBtnActionPerformed
        int row = tablaFactura.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un Producto");
            return;
        }
        int pr = renglonFactura.get(row).getCodigoProducto();
        System.out.println(renglonFactura.get(row).getDescuento());
        if (renglonFactura.get(row).getDescuento() > 0.00) {
            JOptionPane.showMessageDialog(this, "DESCUENTO YA REALIZADO");
            return;
        }
        Producto p = null;
        try {
            p = new ProductoService().getProductoByCodigo(pr);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
                tablaFactura.setEnabled(false);
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
            int row = tablaFactura.getSelectedRow();
            int pr = renglonFactura.get(row).getCodigoProducto();
            Producto p = null;
            try {
                p = new ProductoService().getProductoByCodigo(pr);
            } catch (Exception ex) {
                Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
            Double totNuevo0 = renglonFactura.get(row).getTotal();
            Double totNuevo1 = totNuevo0 * dtoLinea / 100;
            String tn1 = df.format(totNuevo1);
            Double totNuevo2 = totNuevo0 - totNuevo1;
            String tn2 = df.format(totNuevo2);
            Double desc = Double.valueOf(tn1.replace(",", "."));
            Double totL = Double.valueOf(tn2.replace(",", "."));
            ActivityRow rf = renglonFactura.get(row);
            rf.setDescuento(desc);
            rf.setTotal(totL);
            renglonFactura.set(row, rf);
            tablaFactura.setValueAt(df.format(desc), row, 7);
            tablaFactura.setValueAt(df.format(totL), row, 8);
            tablaFactura.setEnabled(true);
            calcularTotales();
            descuentoLineaTxt.setText("");
            descuentoLineaTxt.setEnabled(false);
            descuentoBtn.setEnabled(true);
            agregarBtn.requestFocus();
            codigoProductoTxt.setEnabled(false);
            codigoBarrasTxt.setEnabled(false);
            cantidadTxt.setEnabled(false);
            incorporarAFacturaBtn.setEnabled(false);
            cantidadTxt.setText("");
            codigoProductoTxt.setText("");
            buscarProductoXNombreBtn.setEnabled(false);
            nombreProductoABuscarTxt.setEnabled(false);
            comboProductos.setEnabled(false);
            texto1PieFacturaTxt.setEnabled(true);
            texto2PieFacturaTxt.setEnabled(true);
        }
    }//GEN-LAST:event_descuentoLineaTxtKeyPressed

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
            java.util.logging.Logger.getLogger(FacturaPedidoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaPedidoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaPedidoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaPedidoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaPedidoFrame(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBtn;
    private javax.swing.JButton buscarProductoXNombreBtn;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JTextField cantidadAtadosMassalinTxt;
    private javax.swing.JTextField cantidadAtadosNoblezaTxt;
    private javax.swing.JTextField cantidadItemsTxt;
    private javax.swing.JTextField cantidadTxt;
    private javax.swing.JTextField codigoBarrasTxt;
    private javax.swing.JTextField codigoProductoTxt;
    private javax.swing.JTextField codigoTxt;
    private javax.swing.JComboBox comboProductos;
    private javax.swing.JButton descuentoBtn;
    private javax.swing.JLabel descuentoGlobalLbl;
    private javax.swing.JTextField descuentoGlobalTxt;
    private javax.swing.JLabel descuentoLineaLbl;
    private javax.swing.JTextField descuentoLineaTxt;
    private javax.swing.JTextField descuentoVolumenTxt;
    private javax.swing.JButton eliminarItemBtn;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JButton grabarCantidadBtn;
    private javax.swing.JButton grabarPrecioBtn;
    private javax.swing.JCheckBox imprimeChk;
    private javax.swing.JButton incorporarAFacturaBtn;
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JTextField nombreProductoABuscarTxt;
    private javax.swing.JTextField nombreProductoConsultaTxt;
    private javax.swing.JTextField nuevaCantidadTxt;
    private javax.swing.JTextField nuevoPrecioTxt;
    private javax.swing.JCheckBox pdfChk;
    private javax.swing.JTextField precioProductoConsultaTxt;
    private javax.swing.JTextField razonSocialTxt;
    private javax.swing.JTextField saldoOfTxt;
    private javax.swing.JTextField saldoTotalTxt;
    private javax.swing.JTextField saldoTxt;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JButton terminarBtn;
    private javax.swing.JTextField texto1PieFacturaTxt;
    private javax.swing.JTextField texto2PieFacturaTxt;
    private javax.swing.JTextField totalDeudaTxt;
    private javax.swing.JTextField totalMassalinTxt;
    private javax.swing.JTextField totalNoblezaTxt;
    private javax.swing.JTextField totalTxt;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        nuevaCantidadTxt.setText("");
        nuevoPrecioTxt.setText("");
        totalMassalinTxt.setText("");
        totalNoblezaTxt.setText("");
        texto1PieFacturaTxt.setText("");
        texto2PieFacturaTxt.setText("");
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
        comboProductos.removeAllItems();
        comboProductos.addItem("");
        nombreProductoABuscarTxt.setText("");
        descuentoVolumenTxt.setText("0.00");
        descuentoLineaTxt.setText("");
        totalDeudaTxt.setText("0.00");
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        nombreProductoConsultaTxt.setText("");
        precioProductoConsultaTxt.setText("");
        cantidadItemsTxt.setText("");
        descuentoGlobalTxt.setText("");
        imprimeChk.setSelected(true);
    }

    private void bloquearCampos() {
        grabarCantidadBtn.setEnabled(false);
        grabarPrecioBtn.setEnabled(false);
        agregarBtn.setEnabled(false);
        cancelarBtn.setEnabled(false);
        terminarBtn.setEnabled(false);
        incorporarAFacturaBtn.setEnabled(false);
        buscarProductoXNombreBtn.setEnabled(false);
        eliminarItemBtn.setEnabled(false);
        descuentoBtn.setEnabled(false);
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
        descuentoVolumenTxt.setEnabled(false);
        totalDeudaTxt.setEnabled(false);
        nombreProductoABuscarTxt.setEnabled(false);
        nombreProductoConsultaTxt.setEnabled(false);
        descuentoLineaTxt.setEnabled(false);
        comboProductos.setEnabled(false);
        precioProductoConsultaTxt.setEnabled(false);
        cantidadItemsTxt.setEnabled(false);
        texto1PieFacturaTxt.setEnabled(false);
        texto2PieFacturaTxt.setEnabled(false);
        cantidadAtadosMassalinTxt.setEditable(false);
        cantidadAtadosNoblezaTxt.setEditable(false);
        descuentoGlobalTxt.setEditable(false);
        totalMassalinTxt.setEditable(false);
        totalNoblezaTxt.setEditable(false);
    }

    private void llenarComboProductos() {
        filtro = nombreProductoABuscarTxt.getText();
        List<Producto> productos = new ArrayList<Producto>();
        try {
            productos = new ProductoService().getProductosByFiltroActivosSinDepo(filtro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - leyendo Productos");
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboProductos.getModel();
        if (productos != null && !productos.isEmpty()) {
            for (Producto pro : productos) {
                model.addElement(pro.getDetalle());
            }
            comboProductos.setModel(model);
        }
    }

    private void buscar() {
        cargarDatosIniciales();
        filtro = "";
        Long id = (long) 1;
        try {
            Configuracion conf = new ConfiguracionService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecha = Calendar.getInstance().getTime();
        categoriaIva = 2;
        try {
            clienteReferencia = new ClienteService().getClienteByCodigo(codigoTxt.getText());
            clienteFactura = new CustomerService().getCustomerByCodigo(codigoTxt.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - cliente");
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clienteReferencia != null) {
            if (clienteFactura != null) {
                razonSocialTxt.setText(clienteReferencia.getRazonSocial());
                fechaTxt.setText(sdf.format(fecha));
                ivaTxt.setText("--");
                if (clienteFactura.getSaldo() != null) {
                    saldoTxt.setText(df.format(clienteFactura.getSaldo()));
                    if (clienteReferencia.getSaldo() != null) {
                        saldoOfTxt.setText(df.format(clienteReferencia.getSaldo()));
                        saldoTotalTxt.setText(df.format(clienteFactura.getSaldo() + clienteReferencia.getSaldo()));
                        saldoCliente = clienteFactura.getSaldo() + clienteReferencia.getSaldo();
                    } else {
                        saldoOfTxt.setText("0.00");
                        clienteReferencia.setSaldo(0.0);
                        saldoTotalTxt.setText(df.format(clienteFactura.getSaldo()));
                        saldoCliente = clienteFactura.getSaldo();
                    }
                } else {
                    saldoTxt.setText("0.00");
                    clienteFactura.setSaldo(0.0);
                    if (clienteReferencia.getSaldo() != null) {
                        saldoOfTxt.setText(df.format(clienteReferencia.getSaldo()));
                        saldoTotalTxt.setText(df.format(clienteReferencia.getSaldo()));
                        saldoCliente = clienteReferencia.getSaldo();
                    } else {
                        saldoOfTxt.setText("0.00");
                        saldoTotalTxt.setText("0.00");
                        clienteReferencia.setSaldo(0.0);
                        saldoCliente = 0.0;
                    }
                }
                //Boolean terminar = false;
                agregarBtn.setEnabled(true);
                cancelarBtn.setEnabled(true);
                nombreProductoConsultaTxt.setEditable(false);
                precioProductoConsultaTxt.setEditable(false);
                codigoTxt.setEditable(false);
                descuentoVolumenTxt.setEnabled(true);
                descuentoVolumenTxt.setEditable(false);
                totalTxt.setEnabled(true);
                totalTxt.setEditable(false);
                totalDeudaTxt.setEnabled(true);
                totalDeudaTxt.setEditable(false);
                agregarProducto();
            } else {
                JOptionPane.showMessageDialog(this, "Error - cliente no existe");
                codigoTxt.requestFocus();
            }
        }
    }

    private void bloquearCliente() {
        String codigo = clienteReferencia.getCodigo();
        CustomerTraba cuTr = null;
        try {
            cuTr = new CustomerTrabaService().getClienteByCodigo(codigo);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuTr.setTraba2(true);
        try {
            new CustomerTrabaService().updateCliente(cuTr);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al bloquear Cliente");
        }
    }

    private void desbloquearCliente() {
        String cod = clienteReferencia.getCodigo();
        CustomerTraba cuTr = null;
        try {
            cuTr = new CustomerTrabaService().getClienteByCodigo(cod);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuTr.setTraba2(false);
        try {
            new CustomerTrabaService().updateCliente(cuTr);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al desbloquear Cliente");
        }
    }

    private void terminarFactura() {
        Integer categoriaIva = 2;
        Activity ivaVentas = new Activity();
        saldoCliente = clienteFactura.getSaldo() + clienteReferencia.getSaldo();
        Double saldo = clienteFactura.getSaldo() + totalFactura;
        clienteFactura.setSaldo(saldo);
        saldoCliente = saldo;
        try {
            new CustomerService().updateCustomer(clienteFactura);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        desbloquearCliente();
        pedido.setFacturado(true);
        try {
            new RequestService().updateRequest(pedido);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long id = (long) 1;
        Configuracion confi = null;
        try {
            config = new RoutinesService().getFacturas(id);
            confi = new ConfiguracionService().getFacturas(id);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        config.setUltimaFechaSistema(fecha);
        confi.setUltimaFechaSistema(fecha);
        if (categoriaIva.equals(2)) {
            letraFactura = "B";
            // es inscripto
            sucursalFactura = config.getSucursal();
            numeroFactura = config.getNumeroFactura();
            numeroFactura += 1;
            config.setNumeroFactura(numeroFactura);
        } else {
            letraFactura = "B";
            // el resto de las categorias
            sucursalFactura = config.getSucursal();
            numeroFactura = config.getNumeroFactura();
            numeroFactura += 1;
            config.setNumeroFactura(numeroFactura);
        }
        try {
            new RoutinesService().updateRoutines(config);
            new ConfiguracionService().updateConfiguracion(confi);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Long ve = clienteReferencia.getVendedor().getId();
        ivaVentas.setCustomer(clienteFactura);
        ivaVentas.setIdVendedor(ve);
        if (tieneDto) {
            ivaVentas.setDescuentoGlobal(totalDescuen);
            ivaVentas.setPorcentajeDescuentoGlobal(descuen);
        } else {
            ivaVentas.setDescuentoGlobal(0.0);
            ivaVentas.setPorcentajeDescuentoGlobal(0F);
        }
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
        String s2;
        if (clienteReferencia.getSaldo() != null) {
            s2 = df.format(clienteReferencia.getSaldo());
        } else {
            s2 = df.format(0);
        }
        ivaVentas.setSaldoActual1(Double.valueOf(s2.replace(",", ".")));
        String s1 = df.format(saldoCliente - totalFactura);
        ivaVentas.setSaldoActual2(Double.valueOf(s1.replace(",", ".")));
        try {
            ivaVentas = new ActivityService().saveActivity(ivaVentas);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (ActivityRow reFa : renglonFactura) {
            reFa.setActivity(ivaVentas);
            Integer cod = reFa.getCodigoProducto();

            try {
                producto = new ProductoService().getProductoByCodigo(cod);
            } catch (Exception ex) {
                Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            Float stock = 0.0F;
            if (producto.getStock() != null) {
                stock = producto.getStock();
            } else {
                stock = 0.0F;
            }
            reFa.setCodigoProducto(producto.getCodigo());
            stock -= reFa.getCantidad();
            if (stock < 0) {
                if (producto.getUnidad() != null) {
                    if (producto.getUnidad()) {
                        if (producto.getProductoCaja() != null) {
                            Producto caja = producto.getProductoCaja();
                            int can = producto.getCantidadCaja();
                            float stk1 = caja.getStock();
                            stk1 -= 1;
                            caja.setStock(stk1);
                            try {
                                new ProductoService().updateProducto(caja);
                            } catch (Exception ex) {
                                Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            stock += can;
                        }
                    }
                }
            }
            producto.setStock(stock);
            try {
                new ProductoService().updateProducto(producto);
            } catch (Exception ex) {
                Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                new ActivityRowService().saveRenglon(reFa);
            } catch (Exception ex) {
                Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
//        int x = 0;
//        try {
//            new PresupuestoService().savePresupuestoCompleto(clienteFactura, config, ivaVentas, ccc, renglonFactura, confi);
//            x = 1;
//        } catch (Exception ex) {
//            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        if (x == 0) {
//            try {
//                pedido.setFacturado(false);
//                new RequestService().updateRequest(pedido);
//            } catch (Exception ex) {
//                Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        generarFactura(ivaVentas);
        PedidosPendientes ff = new PedidosPendientes();
        ff.setVisible(true);
        this.dispose();
    }

    private void generarFactura(Activity ivaVentas) {
        renglones = new String[maxNro];
        textoFacturaPapel = "PRESUPUESTO";
        fechaFacturaPapel = sdf.format(fecha);
        clienteFacturaPapel = razonSocialTxt.getText();
        codigoClienteFacturaPapel = clienteReferencia.getCodigo();
        direccionFacturaPapel = clienteReferencia.getDomicilio().getCalle() + " " + clienteReferencia.getDomicilio().getNumero() + " - " + clienteReferencia.getDomicilio().getLocalidad();
        cuitFacturaPapel = "--";
        String condVta = "";
        Date fechaVto = fecha;
        Calendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        condVta = "CONTADO";
        condicionVentaFacturaPapel = condVta;
        //vencimientoFacturaPapel = sdf.format(fechaVto);
        String catego = "--";
        inscripcionClienteFacturaPapel = catego;
        if (categoriaIva != 1) {
            //                                    1         2         3         4         5         6         7         8         9        10
            //                           1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
            nombresColumnaFacturaPapel = "  IT CANT                   DETALLE                     P.UNIT.    DESC.   IMPORTE       IMP.     TOTAL    SUG";
        } else {
            nombresColumnaFacturaPapel = "  IT CANT                   DETALLE                    P.UNIT.    DESC.   GRAVADO      IVA       IMP.    TOTAL      SUG";
        }
        DecimalFormat df = new DecimalFormat("#0.00");
        int maxTabla = tablaFactura.getRowCount();
        for (int r = 0; r < maxNro; r++) {
            if (r < maxTabla) {
                String str0 = String.valueOf(r + 1);
                int largo = str0.length();
                if (largo < 2) {
                    renglones[r] = " " + str0;
                } else {
                    renglones[r] = str0;
                }
                str0 = tablaFactura.getValueAt(r, 1).toString();
                largo = str0.length();
                if (largo == 1) {
                    renglones[r] = " " + renglones[r] + "     " + str0;
                }
                if (largo == 2) {
                    renglones[r] = " " + renglones[r] + "    " + str0;
                }
                if (largo == 3) {
                    renglones[r] = " " + renglones[r] + "   " + str0;
                }
                if (largo == 4) {
                    renglones[r] = " " + renglones[r] + "  " + str0;
                }
                if (largo == 5) {
                    renglones[r] = " " + renglones[r] + " " + str0;
                }
                if (largo == 6) {
                    renglones[r] = renglones[r] + " " + str0;
                }
                str0 = tablaFactura.getValueAt(r, 2).toString();
                String espacio = " ";
                largo = str0.length();
                if (largo > 40) {
                    str0 = str0.substring(0, 40);
                    tablaFactura.setValueAt(str0, r, 2);
                } else {
                    for (int l = largo; l < 40; l++) {
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
        Double sA1 = doble;
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
            espacio = "                                                            Total Impuesto: ";
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
        totalPagarFacturaPapel = espacio + df.format(totalPagar);
        Double sT1 = doble;
// Cantidades atados
        cantidadesFacturaPapel = "                  CANT.ATADOS NOBLEZA: " + String.valueOf(cantidadAtadosNobleza);
        cantidadesFacturaPapel += "                 CANT ATADOS MASSALIN: " + String.valueOf(cantidadAtadosMassalin);
        Integer caTN1 = cantidadAtadosNobleza;
        Integer caTM1 = cantidadAtadosMassalin;
        texto1FacturaPapel = texto1PieFacturaTxt.getText();
        texto2FacturaPapel = texto2PieFacturaTxt.getText();
        texto3FacturaPapel = "-";
        Boolean saldos = true;
        if (pdfChk.isSelected()) {
            pdf(ivaVentas, renglonFactura, caTN1, caTM1, sA1, sT1, saldos);

        }
        if (imprimeChk.isSelected()) {
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

    private void pdf(Activity iv, List<ActivityRow> rf, Integer caN, Integer caM, Double sAn, Double sTo, Boolean saldos) {
        String code = iv.getCustomer().getCodigo();
        Cliente cli = null;
        try {
            cli = new ClienteService().getClienteByCodigo(code);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File ps = new PDFBuilder().armarPresup(cli, iv, rf, caN, caM, sAn, sTo, saldos);
            DesktopApi.open(ps);
            JOptionPane.showMessageDialog(this, "Encuentra el presupuesto en: c:/pdf/pr y el numero de presupuesto");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err1");
            JOptionPane.showMessageDialog(this, "ERROR FILE 2203");
        } catch (DocumentException ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err2");
            JOptionPane.showMessageDialog(this, "ERROR DOCUMENT 2207");
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err3");
            JOptionPane.showMessageDialog(this, "ERROR EXCEPTION 2211");
        }
    }

    private void agregarProducto() {
        agregarBtn.setEnabled(false);
        if (nro > 0) {
            terminarBtn.setEnabled(true);
        } else {
            terminarBtn.setEnabled(false);
        }
        incorporarAFacturaBtn.setEnabled(true);
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
        codigoBarrasTxt.requestFocus();
    }

    private void buscarProducto() {
        filtro = "";
        if (nro < maxNro - 1) {
            agregarBtn.setEnabled(true);
        } else {
            agregarBtn.setEnabled(false);
        }
        terminarBtn.setEnabled(true);
        eliminarItemBtn.setEnabled(true);
        cancelarBtn.setEnabled(true);
        incorporarAFacturaBtn.setEnabled(false);
        Producto pro = null;
        encontrado = false;
        if (!codigoBarrasTxt.getText().isEmpty()) {
            try {
                pro = new ProductoService().getProductoByCodigoBarras(Long.valueOf(codigoBarrasTxt.getText()));
                encontrado = true;
            } catch (Exception ex) {
                Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
                codigoBarrasTxt.requestFocus();
            }
        } else {
            if (!codigoProductoTxt.getText().isEmpty()) {
                try {
                    pro = new ProductoService().getProductoByCodigo(Integer.valueOf(codigoProductoTxt.getText()));
                    encontrado = true;
                } catch (Exception ex) {
                    Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
                    codigoBarrasTxt.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese Código de Producto o Código de Barras");
                codigoBarrasTxt.requestFocus();
            }
        }
        if (pro != null) {
            if (pro.getInactivo() != null) {
                if (!pro.getInactivo()) {  //  || pro.getSubRubro().getCodigo() == 5099
                    cantidad = Float.valueOf(cantidadTxt.getText());
                    // en unidad
                    if (!(cantidad > 0.0)) {
                        JOptionPane.showMessageDialog(this, "Debe colocar cantidad mayor que cero");
                        cantidadTxt.requestFocus();
                        return;
                    }
                    precioFinal = rint(((pro.getPrecio() * (1 + (porcentualIva / 100))) + pro.getImpuesto()) * 100) / 100;
                    // por cantidad
                    gravado = rint((pro.getPrecio() * cantidad) * 100) / 100;
                    impuesto = rint(pro.getImpuesto() * cantidad * 100) / 100;
                    iva = rint(gravado * 21) / 100;
                    totalLinea = rint((gravado + impuesto + iva) * 100) / 100;
                    ActivityRow rf = new ActivityRow();
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
                    renglonFactura.add(rf);
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
                    Rectangle rect = tablaFactura.getCellRect(nro - 1, 0, true);
                    tablaFactura.scrollRectToVisible(rect);
                    tablaFactura.clearSelection();
                    tablaFactura.setRowSelectionInterval(nro - 1, nro - 1);
                    tablaFactura.setModel(tabla); // poner visible la tabla
                    codigoProductoTxt.setEnabled(false);
                    codigoBarrasTxt.setEnabled(false);
                    cantidadTxt.setEnabled(false);
                    incorporarAFacturaBtn.setEnabled(false);
                    cantidadTxt.setText("");
                    codigoProductoTxt.setText("");
                    buscarProductoXNombreBtn.setEnabled(false);
                    nombreProductoABuscarTxt.setEnabled(false);
                    comboProductos.setEnabled(false);
                    texto1PieFacturaTxt.setEnabled(true);
                    texto2PieFacturaTxt.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Error - producto inactivo");
                    codigoProductoTxt.setText("");
                    cantidadTxt.setText("");
                    codigoBarrasTxt.requestFocus();
                    //codigoProductoTxt.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error - producto inactivo");
                codigoProductoTxt.setText("");
                cantidadTxt.setText("");
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
        int cantidadRow = tablaFactura.getRowCount();
        DefaultTableModel model1 = (DefaultTableModel) tablaFactura.getModel();
        if (cantidadRow > 0) {
            for (int i = 0; i < cantidadRow; i++) {
                model1.removeRow(0);
            }
            tablaFactura.setModel(model1);
            nro = 0;
        }
        renglonFactura = new ArrayList<ActivityRow>();
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
                //Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
        totalFactura = 0.0;
        nro = 0;
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        Double importeTotalMassalin = 0.0;
        Double importeTotalNobleza = 0.0;
        Double totalCalculo = 0.0;
        for (ActivityRow renFa : renglonFactura) {
            totalGravado += renFa.getGravado();
            int cp = renFa.getCodigoProducto();
            iva = rint(renFa.getGravado() * porcentualIva) / 100;
            totalIva += iva;
            Producto pro = null;
            try {
                pro = new ProductoService().getProductoByCodigo(cp);
            } catch (Exception ex) {
                Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
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

            if (tieneDto) {
                if (pro.getRubro().getCodigo().equals(5)) {
                    totalCalculo += renFa.getTotal();
                }
            }
            totalImpuesto += renFa.getImpuesto();
            totalFactura += renFa.getTotal();
            nro += 1;
            renFa.setItemNro(nro);
        }
        if (tieneDto) {
            Double tD0 = totalCalculo * descuen / 100;
            String tD1 = df.format(tD0);
            totalDescuen = Double.valueOf(tD1.replace(",", "."));
            totalFactura -= totalDescuen;
        } else {
            totalDescuen = 0.0;
        }

        descuentoVolumenTxt.setText(df.format(totalDescuen));
        cantidadItemsTxt.setText(String.valueOf(nro));
        totalFactura = rint((totalFactura - totalDescuen) * 100) / 100;
        totalTxt.setText(String.valueOf(df.format(totalFactura)));
        saldoCliente = 0.00;
        if (clienteFactura != null) {
            if (clienteReferencia != null) {
                saldoCliente = clienteFactura.getSaldo() + clienteReferencia.getSaldo();
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
//        System.out.println(saldoCliente);
//        System.out.println(totalFactura);
//        System.exit(0);
        totalDeudaTxt.setText(df.format(saldoCliente + totalFactura));
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
                //Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
                codigoProductoTxt.setText("");
                codigoBarrasTxt.setText("");
                codigoProductoTxt.requestFocus();
            }
        }
    }

    private void cargarCliente() {
        //String cod = clienteReferencia.getCodigo();
        //clienteFactura.setCodigo(cod);
        codigoClienteFacturaPapel = clienteFactura.getCodigo();
        codigoTxt.setText(codigoClienteFacturaPapel);
        razonSocialTxt.setText(clienteReferencia.getRazonSocial());
        ivaTxt.setText("--");
        categoriaIva = 2;
        saldoTxt.setText(String.valueOf(df.format(clienteFactura.getSaldo())));
        saldoOfTxt.setText(String.valueOf(df.format(clienteReferencia.getSaldo())));
        Double saldoTotal = clienteFactura.getSaldo() + clienteReferencia.getSaldo();
        saldoTotalTxt.setText(String.valueOf(df.format(saldoTotal)));
        fecha = Calendar.getInstance().getTime();
        fechaTxt.setText(sdf.format(fecha));
        tieneDto = false;
        if (clienteFactura.getTieneDescuento() != null) {
            if (clienteFactura.getTieneDescuento()) {
                descuentoGlobalTxt.setText(df1.format(clienteFactura.getDescuento()));
                descuen = clienteFactura.getDescuento();
                tieneDto = true;
            } else {
                descuentoGlobalTxt.setText(df1.format(0));
            }
        } else {
            descuentoGlobalTxt.setText(df1.format(0));
        }
    }

    private void cargarRenglones() {

        if (pedido.getTextoPiePedido1() != null) {
            texto1PieFacturaTxt.setText(pedido.getTextoPiePedido1());
        }
        if (pedido.getTextoPiePedido2() != null) {
            texto2PieFacturaTxt.setText(pedido.getTextoPiePedido2());
        }
        try {
            renglonP = new RequestRowService().getAllRenglonRequestFromRequest(pedido);
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        tabla = (DefaultTableModel) tablaFactura.getModel();
        for (RequestRow rp : renglonP) {
            ActivityRow rf = new ActivityRow();
            Float can = rp.getCantidad();
            Double tot = rp.getTotal();
            Double imp = rp.getImpuesto();
            Double calc1 = tot / can;  //porcentualIva
            Double calc2 = tot - imp;

            Double grav1 = calc2 / (1 + (porcentualIva / 100));

            rf.setCantidad(can);
            rf.setCodigoProducto(rp.getCodigoProducto());
            rf.setItemNro(rp.getItemNro());
            rf.setDescripcion(rp.getDescripcion());
            rf.setGravado(grav1);
            rf.setNoGravado(rp.getNoGravado());
            rf.setExento(rp.getExento());
            rf.setImpuesto(imp);
            rf.setDescuento(rp.getDescuento());
            rf.setIva(rp.getIva());
            rf.setTotal(rp.getTotal());
            rf.setSugerido(rp.getSugerido());
            renglonFactura.add(rf);
            Object linea[] = new Object[10];
            linea[0] = rp.getCodigoProducto();
            linea[1] = can;
            linea[2] = rp.getDescripcion();
            linea[3] = df.format(calc1);
            linea[4] = df.format(grav1);
            linea[5] = df.format(imp);
            linea[6] = df.format(rp.getIva());
            linea[7] = df.format(rp.getDescuento());
            linea[8] = df.format(rp.getTotal());
            linea[9] = df.format(rp.getSugerido());
            tabla.addRow(linea);
        }
        tablaFactura.setModel(tabla);
        //Boolean terminar = false;
        agregarBtn.setEnabled(true);
        cancelarBtn.setEnabled(true);
        nombreProductoConsultaTxt.setEditable(false);
        precioProductoConsultaTxt.setEditable(false);
        codigoTxt.setEditable(false);
        //descuentoVolumenTxt.setEnabled(true);
        descuentoVolumenTxt.setEditable(false);
        totalTxt.setEnabled(true);
        totalTxt.setEditable(false);
        totalDeudaTxt.setEnabled(true);
        totalDeudaTxt.setEditable(false);
        descuentoBtn.setEnabled(true);
        cancelarBtn.setEnabled(true);
        terminarBtn.setEnabled(true);
        eliminarItemBtn.setEnabled(true);
        calcularTotales();
        agregarBtn.requestFocus();
    }

    private void cargarDatosIniciales() {
        filtro = "";
        Long id = (long) 1;
        try {
            Routines conf = new RoutinesService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        fecha = Calendar.getInstance().getTime();
    }

    private void leerPrecio() {
        int lin = tablaFactura.getSelectedRow();
        if (lin > -1) {
            ActivityRow rf = renglonFactura.get(lin);
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
                agregarBtn.requestFocus();
                return;
            }
            Float cant = rf.getCantidad();
            Double iva = rf.getIva() / cant;
            Double prec = rf.getGravado() / cant;
            nuevoPrecioTxt.setText(String.valueOf(df.format(prec + iva)));
            leerPrecioBtn.setEnabled(false);
            grabarPrecioBtn.setEnabled(true);
            leerCantidadBtn.setEnabled(false);
            tablaFactura.setEnabled(false);
            agregarBtn.setEnabled(false);
            eliminarItemBtn.setEnabled(false);
            terminarBtn.setEnabled(false);
            nuevaCantidadTxt.setEnabled(false);
            nuevoPrecioTxt.requestFocus();
        }
    }

    private boolean habilitado() {
        FileReader fr = null;
        //Boolean habilita = false;
        try {
            fr = new FileReader("c:/ventas/permisos.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(fr);
        String acceso = "";
        try {
            acceso = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(FacturaPedidoFrame.class.getName()).log(Level.SEVERE, null, ex);
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
            g2.drawString(espacio + "X", 30, row);
            g2.setFont(new Font("Monospaced", Font.PLAIN, 8));
            espacio = "                                                         ";
            g2.drawString(espacio + textoFacturaPapel, 30, row);
            String sucFactura = "000" + sucursalFactura.toString();
            int largo = sucFactura.length();
            sucFactura = sucFactura.substring(largo - 4, largo);
            String numFactura = "0000000" + numeroFactura.toString();
            largo = numFactura.length();
            numFactura = numFactura.substring(largo - 8, largo);
            g2.drawString(letraFactura + " " + sucFactura + "-" + numFactura, 380, row);
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
            g2.drawString(cantidadesFacturaPapel, 30, row);
            return PAGE_EXISTS;
        }
    }
}
