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
import ar.com.ventas.entities.Routines;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.Usuario;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.CustomerService;
import ar.com.ventas.services.CustomerTrabaService;
import ar.com.ventas.services.PresupuestoService;
import ar.com.ventas.services.ProductoService;
import ar.com.ventas.services.RoutinesService;
import ar.com.ventas.services.UsuarioService;
import ar.com.ventas.util.Constantes;
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
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class FacturaFrame extends javax.swing.JFrame {

    private List<Cliente> clientes = null;
    public List<ActivityRow> renglonFactura = new ArrayList<ActivityRow>();
    private Double saldoTot = 0.0;
    private String textoFacturaPapel;
    private String fechaFacturaPapel;
    private String clienteFacturaPapel;
    private String codigoClienteFacturaPapel;
    private String direccionFacturaPapel;
    private String condicionVentaFacturaPapel;
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
    private Customer clienteFactura = null;
    private Cliente clienteFc = null;
    //private Producto producto = null;
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
    private Float descuen = 0F;
    private Double descuento = 0.0;
    private Double totalDescuen = 0.0;
    private Producto productoSeleccionado;
    private Float cantidad;
    //private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat df = new DecimalFormat("#0.00");
    private Double saldoCliente = 0.00;
    private String filtro = "";
    private String letraFactura;
    private Integer sucursalFactura;
    private Integer numeroFactura;
    private Routines config = null;
    private Double precioFinal = 0.0;
    private Integer nro = 0;
    private Integer maxNro = 41; //41
    private Integer cantidadAtadosMassalin;
    private Integer cantidadAtadosNobleza;
    public Boolean encontrado;
    private Usuario usuario;
    private final Integer nivel = 1;
    private String entrega;

    /**
     * Creates new form FacturaFrame
     */
    public FacturaFrame() {
        //getContentPane().setBackground(new java.awt.Color(135, 206, 235));
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        initComponents();
        this.setLocationRelativeTo(null);
        limpiarCampos();
        bloquearCampos();
//      levanto el modelo creado del frame
        tabla = (DefaultTableModel) tablaFactura.getModel();
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
        buscarClienteBtn = new javax.swing.JButton();
        incorporarAFacturaBtn = new javax.swing.JButton();
        eliminarItemBtn = new javax.swing.JButton();
        buscarClienteXNombre = new javax.swing.JButton();
        buscarProductoXNombreBtn = new javax.swing.JButton();
        descuentoGlobalLbl = new javax.swing.JLabel();
        descuentoGlobalTxt = new javax.swing.JTextField();
        descuentoLineaLbl = new javax.swing.JLabel();
        descuentoLineaTxt = new javax.swing.JTextField();
        comboClientes = new javax.swing.JComboBox();
        comboProductos = new javax.swing.JComboBox();
        nombreClienteABuscarTxt = new javax.swing.JTextField();
        nombreProductoABuscarTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        descuentoVolumenTxt = new javax.swing.JTextField();
        totalDeudaTxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        recalcularBtn = new javax.swing.JButton();
        texto1PieFacturaTxt = new javax.swing.JTextField();
        texto2PieFacturaTxt = new javax.swing.JTextField();
        volverBtn = new javax.swing.JButton();
        nombreProductoConsultaTxt = new javax.swing.JTextField();
        precioProductoConsultaTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cantidadAtadosMassalinTxt = new javax.swing.JTextField();
        cantidadAtadosNoblezaTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cantidadItemsTxt = new javax.swing.JTextField();
        nuevaCantidadTxt = new javax.swing.JTextField();
        leerCantidadBtn = new javax.swing.JButton();
        grabarCantidadBtn = new javax.swing.JButton();
        leerPrecioBtn = new javax.swing.JButton();
        nuevoPrecioTxt = new javax.swing.JTextField();
        grabarPrecioBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        totalMassalinTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        totalNoblezaTxt = new javax.swing.JTextField();
        totalCompraActualTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        imprimeChk = new javax.swing.JCheckBox();
        descuentoBtn = new javax.swing.JButton();
        ivaCeroTxt = new javax.swing.JTextField();
        pdfChk = new javax.swing.JCheckBox();

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

        jLabel3.setText("Saldo Anterior:");

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

        cancelarBtn.setText("Cancelar Presup");
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

        incorporarAFacturaBtn.setText("Incorporar a Presup");
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

        descuentoLineaLbl.setText("Dscto:");

        descuentoLineaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoLineaTxt.setText("DCTO");
        descuentoLineaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descuentoLineaTxtKeyPressed(evt);
            }
        });

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

        jLabel12.setText("Descuento");

        descuentoVolumenTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        descuentoVolumenTxt.setText("DESCUENTO");

        totalDeudaTxt.setBackground(new java.awt.Color(51, 0, 204));
        totalDeudaTxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalDeudaTxt.setForeground(new java.awt.Color(204, 255, 255));
        totalDeudaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalDeudaTxt.setText("TOT DEU");

        jLabel16.setText("Saldo otra Factura:");

        recalcularBtn.setText("Recalcular");
        recalcularBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recalcularBtnActionPerformed(evt);
            }
        });

        texto1PieFacturaTxt.setText("TEXTO 1 PIE FACTURA");

        texto2PieFacturaTxt.setText("TEXTO 2 PIE FACTURA");

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        nombreProductoConsultaTxt.setText("NOMBRE PRODUCTO CONSULTA");

        precioProductoConsultaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioProductoConsultaTxt.setText("PRECIO PROD CONSU");

        jLabel15.setText("Massalin:");

        jLabel17.setText("Nobleza:");

        cantidadAtadosMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadAtadosMassalinTxt.setText("Cant Mass");

        cantidadAtadosNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadAtadosNoblezaTxt.setText("Cant Nobl");

        jLabel18.setText("Cant. Items:");

        cantidadItemsTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cantidadItemsTxt.setText("Cantidad Items");

        nuevaCantidadTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nuevaCantidadTxt.setText("NUEV CANT");
        nuevaCantidadTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nuevaCantidadTxtKeyPressed(evt);
            }
        });

        leerCantidadBtn.setText("Leer Cantidad");
        leerCantidadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerCantidadBtnActionPerformed(evt);
            }
        });

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
        nuevoPrecioTxt.setText("NUE PREC");
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

        jLabel19.setText("Importe:");

        totalMassalinTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalMassalinTxt.setText("TOT MASS");

        jLabel9.setText("Importe:");

        totalNoblezaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalNoblezaTxt.setText("TOT NOBL");

        totalCompraActualTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalCompraActualTxt.setText("TOT COMP ACT");

        jLabel10.setText("Deuda Total:");

        imprimeChk.setText("Imprime");

        descuentoBtn.setText("Desc.");
        descuentoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descuentoBtnActionPerformed(evt);
            }
        });

        ivaCeroTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ivaCeroTxt.setText("IVA CERO");

        pdfChk.setText("Pdf");

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
                        .addComponent(ivaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saldoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nombreClienteABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarClienteXNombre)
                        .addGap(18, 18, 18)
                        .addComponent(comboClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarClienteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(razonSocialTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(descuentoGlobalLbl)
                        .addGap(18, 18, 18)
                        .addComponent(descuentoGlobalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(volverBtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(275, 275, 275))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(249, 249, 249)
                                        .addComponent(nombreProductoABuscarTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buscarProductoXNombreBtn)
                                        .addGap(202, 202, 202)
                                        .addComponent(jLabel12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel7))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(8, 8, 8)
                                                                .addComponent(codigoProductoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(descuentoLineaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(cantidadTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGap(38, 38, 38)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(precioProductoConsultaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                    .addComponent(comboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addGap(121, 121, 121)
                                                                    .addComponent(jLabel8)))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(nombreProductoConsultaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(leerPrecioBtn)
                                                                    .addComponent(leerCantidadBtn))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(nuevaCantidadTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(nuevoPrecioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(4, 4, 4)
                                                        .addComponent(codigoBarrasTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(incorporarAFacturaBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(descuentoBtn)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(agregarBtn)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(eliminarItemBtn)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel18))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(409, 409, 409)
                                                        .addComponent(ivaCeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel16)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(totalCompraActualTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(113, 113, 113)
                                                        .addComponent(jLabel10)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(totalDeudaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(recalcularBtn)
                                                        .addGap(136, 136, 136)
                                                        .addComponent(pdfChk)))
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(descuentoVolumenTxt)
                                    .addComponent(grabarPrecioBtn)
                                    .addComponent(cantidadItemsTxt)
                                    .addComponent(grabarCantidadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalTxt))
                                .addGap(50, 50, 50)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imprimeChk)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(texto1PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(descuentoLineaLbl)
                                .addComponent(texto2PieFacturaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cancelarBtn)
                            .addComponent(terminarBtn))
                        .addGap(80, 80, 80))))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(descuentoBtn)
                    .addComponent(ivaCeroTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(agregarBtn)
                        .addComponent(eliminarItemBtn)
                        .addComponent(incorporarAFacturaBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(cantidadItemsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalDeudaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(recalcularBtn)
                    .addComponent(totalCompraActualTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(cantidadAtadosMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadAtadosNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(totalMassalinTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(totalNoblezaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarClienteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteBtnActionPerformed
        buscar();
    }//GEN-LAST:event_buscarClienteBtnActionPerformed

    private void desbloquearCliente() {
        String cod = clienteFc.getCodigo();
        CustomerTraba cuTr = null;
        try {
            cuTr = new CustomerTrabaService().getClienteByCodigo(cod);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuTr.setTraba2(false);
        try {
            new CustomerTrabaService().updateCliente(cuTr);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al desbloquear Cliente");
        }
    }

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null,
                "Esta seguro de abandonar el Presupuesto?",
                "Atencion", JOptionPane.YES_NO_OPTION);
        // 0 = si; 1 = no
        if (escape == 0) {
            limpiarCampos();
            bloquearCampos();
            borrarTablaProductos();
            volverBtn.setEnabled(true);
            buscarClienteBtn.setEnabled(true);
            codigoTxt.requestFocus();
            leerCantidadBtn.setEnabled(false);
            nuevaCantidadTxt.setEnabled(false);
            leerPrecioBtn.setEnabled(false);
            nuevoPrecioTxt.setEnabled(false);
            nombreClienteABuscarTxt.setEnabled(true);
            buscarClienteXNombre.setEnabled(true);
            comboClientes.setEnabled(true);
            desbloquearCliente();
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
            //nombreProductoConsultaTxt.setEnabled(false);
        }
    }//GEN-LAST:event_cancelarBtnActionPerformed

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        eliminarItemBtn.setEnabled(false);
        recalcularBtn.setEnabled(false);
        texto1PieFacturaTxt.setEnabled(false);
        texto2PieFacturaTxt.setEnabled(false);
        codigoBarrasTxt.setText("");
        agregarProducto();
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void incorporarAFacturaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incorporarAFacturaBtnActionPerformed
        if (!cantidadTxt.getText().isEmpty()) {
            if (!codigoBarrasTxt.getText().isEmpty()) {
                int l = cantidadTxt.getText().length();
                if (l > 6) {
                    System.out.print("\007");
                    System.out.flush();
                    JOptionPane.showMessageDialog(this, "Utilice una cantidad menor");
                } else {
                    buscarProducto();
                }
            } else {
                if (!codigoProductoTxt.getText().isEmpty()) {
                    int l = cantidadTxt.getText().length();
                    if (l > 6) {
                        System.out.print("\007");
                        System.out.flush();
                        JOptionPane.showMessageDialog(this, "Utilice una cantidad menor");
                    } else {
                        buscarProducto();
                    }
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Ingrese Código Barras o Código producto");
                    codigoBarrasTxt.requestFocus();
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad");
            cantidadTxt.requestFocus();
        }
    }//GEN-LAST:event_incorporarAFacturaBtnActionPerformed

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
                Cliente xCli = null;
                Integer seleccion = comboClientes.getSelectedIndex();
                xCli = clientes.get(seleccion - 1);
                codigoTxt.setText(xCli.getCodigo());
                buscar();
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
                    Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_comboProductosActionPerformed

    private void terminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarBtnActionPerformed
        int escape = JOptionPane.showConfirmDialog(null, "Quiere ingresar un texto antes de Imprimir?",
                "Texto en el pie de Factura",
                JOptionPane.YES_NO_OPTION);
        if (escape == 0) {
            texto1PieFacturaTxt.setEnabled(true);
            texto2PieFacturaTxt.setEnabled(true);
            texto1PieFacturaTxt.requestFocus();
        } else {
            Cliente yCli = null;
            try {
                yCli = new ClienteService().getClienteByCodigo(clienteFactura.getCodigo());
            } catch (Exception ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (yCli != null) {
                if (yCli.getImporteMostrador() != null) {
                    Double importx = yCli.getImporteMostrador();
                    if (importx > 0.00) {
                        //JOptionPane.showMessageDialog(this, "Deberia cerrar primero el otro comprobante");
                        int a = JOptionPane.showConfirmDialog(this, "Deberia cerrar primero el otro comprobante", "Atención", JOptionPane.YES_NO_OPTION);
                        if (a == 0) {
                            return;
                        }
                    }
                }
            }
            if (yCli.getEntrega() != null) {
                entrega = yCli.getEntrega();
            } else {
                entrega = "";
            }
            terminarBtn.setEnabled(false);
            terminarFactura();
        }
    }//GEN-LAST:event_terminarBtnActionPerformed

    private void recalcularBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recalcularBtnActionPerformed
        calcularTotales();
        agregarBtn.requestFocus();
    }//GEN-LAST:event_recalcularBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        FacturarFrame ff = new FacturarFrame();
        ff.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void codigoTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!codigoTxt.getText().isEmpty()) {
                buscar();
                cancelarBtn.setEnabled(true);
            } else {
                nombreClienteABuscarTxt.requestFocus();
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
                int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar el Presupuesto?", "Atencion", JOptionPane.YES_NO_OPTION);
                if (escape != 1) {
                    limpiarCampos();
                    bloquearCampos();
                    borrarTablaProductos();
                    volverBtn.setEnabled(true);
                    buscarClienteBtn.setEnabled(true);
                    codigoTxt.requestFocus();
                    leerCantidadBtn.setEnabled(false);
                    nuevaCantidadTxt.setEnabled(false);
                    leerPrecioBtn.setEnabled(false);
                    nuevoPrecioTxt.setEnabled(false);
                    nombreClienteABuscarTxt.setEnabled(true);
                    buscarClienteXNombre.setEnabled(true);
                    comboClientes.setEnabled(true);
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
                cantidad = Float.valueOf(cantidadTxt.getText());
                if (!(cantidad > 0.0)) {
                    JOptionPane.showMessageDialog(this, "Debe colocar cantidad mayor que cero");
                    cantidadTxt.setText("");
                    cantidadTxt.requestFocus();
                    return;
                }
                if (!codigoBarrasTxt.getText().isEmpty()) {
                    int l = cantidadTxt.getText().length();
                    if (l > 6) {
                        InputStream path;
                        path = getClass().getResourceAsStream("sonido/stop.wav");
                        try {
                            Clip sonido = AudioSystem.getClip();
                            sonido.open(AudioSystem.getAudioInputStream(path));
                            sonido.start();
                        } catch (LineUnavailableException ex) {
                            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnsupportedAudioFileException ex) {
                            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        JOptionPane.showMessageDialog(this, "Utilice una cantidad menor");
                    } else {
                        buscarProducto();
                    }
                } else {
                    if (!codigoProductoTxt.getText().isEmpty()) {
                        int l = cantidadTxt.getText().length();
                        if (l > 6) {
                            InputStream path;
                            path = getClass().getResourceAsStream("sonido/stop.wav");
                            try {
                                Clip sonido = AudioSystem.getClip();
                                sonido.open(AudioSystem.getAudioInputStream(path));
                                sonido.start();
                            } catch (LineUnavailableException ex) {
                                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (UnsupportedAudioFileException ex) {
                                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JOptionPane.showMessageDialog(this, "Utilice una cantidad menor");
                        } else {
                            buscarProducto();
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
        recalcularBtn.setEnabled(false);
        texto1PieFacturaTxt.setEnabled(false);
        texto2PieFacturaTxt.setEnabled(false);
        codigoBarrasTxt.setText("");
        agregarProducto();
    }//GEN-LAST:event_agregarBtnKeyPressed

    private void nombreClienteABuscarTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreClienteABuscarTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (nombreClienteABuscarTxt.getText().isEmpty()) {
                codigoTxt.requestFocus();
                return;
            }
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
                return;
            } else {
                nombreProductoABuscarTxt.requestFocus();
                return;
            }
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                int escape = JOptionPane.showConfirmDialog(null, "Esta seguro de abandonar el Presupuesto?", "Atencion", JOptionPane.YES_NO_OPTION);
                if (escape == 0) {
                    limpiarCampos();
                    bloquearCampos();
                    borrarTablaProductos();
                    volverBtn.setEnabled(true);
                    buscarClienteBtn.setEnabled(true);
                    codigoTxt.requestFocus();
                    leerCantidadBtn.setEnabled(false);
                    nuevaCantidadTxt.setEnabled(false);
                    leerPrecioBtn.setEnabled(false);
                    nuevoPrecioTxt.setEnabled(false);
                    nombreClienteABuscarTxt.setEnabled(true);
                    buscarClienteXNombre.setEnabled(true);
                    comboClientes.setEnabled(true);
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
//                    incorporarAFacturaBtn.setEnabled(true);
//                    cantidadTxt.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_codigoBarrasTxtKeyPressed

    private boolean isNumeric(KeyEvent evt) {
        String cod = String.valueOf(evt.getKeyChar());
        try {
            Integer.parseInt(cod);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    private void leerCantidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerCantidadBtnActionPerformed
        int lin = tablaFactura.getSelectedRow();
        tablaFactura.setEnabled(false);
        if (lin > -1) {
            ActivityRow rf = renglonFactura.get(lin);
            if (rf.getDescuento() > 0.0) {
                JOptionPane.showMessageDialog(this, "NO PERMITIDO CAMBIAR CANTIDAD");
                tablaFactura.setEnabled(true);
                agregarBtn.requestFocus();
                return;
            }
            nuevaCantidadTxt.setEditable(true);
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
            recalcularBtn.setEnabled(false);
        }
    }//GEN-LAST:event_leerCantidadBtnActionPerformed

    private void grabarCantidadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grabarCantidadBtnActionPerformed
        int lin = tablaFactura.getSelectedRow();
        tablaFactura.setEnabled(true);
        if (lin > -1) {
            if (!nuevaCantidadTxt.getText().isEmpty()) {
                leerCantidadBtn.setEnabled(true);
                leerPrecioBtn.setEnabled(true);
                nuevoPrecioTxt.setEnabled(true);
                grabarCantidadBtn.setEnabled(false);
                ActivityRow rf = renglonFactura.get(lin);
                cantidad = Float.valueOf(nuevaCantidadTxt.getText());
                if (!(cantidad > 0.0)) {
                    JOptionPane.showMessageDialog(this, "Debe colocar cantidad mayor que cero");
                    return;
                }
                int cp = rf.getCodigoProducto();
                Producto pro = null;
                try {
                    pro = new ProductoService().getProductoByCodigo(cp);
                } catch (Exception ex) {
                    Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                Double prex = rf.getPrecioUnitario();
                //prex = prex / (1 + porcentualIva / 100);
                calcularLinea(pro, prex, cantidad);
                rf.setCantidad(cantidad);
                rf.setDescripcion(pro.getDetalle());
                rf.setDescuento(descuento);
                rf.setExento(0.0);
                rf.setGravado(gravado);
                rf.setImpuesto(impuesto);
                rf.setIva(iva);
                rf.setNoGravado(noGravado);
                rf.setCodigoProducto(pro.getCodigo());
                rf.setSugerido(pro.getSugerido());
                rf.setTotal(totalLinea);
                renglonFactura.set(lin, rf);
                tablaFactura.setValueAt(cantidad.intValue(), lin, 1);
                // en unidad
                tablaFactura.setValueAt(df.format(precioFinal), lin, 3);
                nuevaCantidadTxt.setText("");

                // por cantidad
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
                recalcularBtn.setEnabled(true);
                calcularTotales();
            }
            agregarBtn.requestFocus();
        }
    }//GEN-LAST:event_grabarCantidadBtnActionPerformed

    private void comboClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comboClientesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (comboClientes.getSelectedIndex() > 0) {
                nombreClienteABuscarTxt.setText("");
                Cliente xCli = null;
                Integer seleccion = comboClientes.getSelectedIndex();
                xCli = clientes.get(seleccion - 1);
                codigoTxt.setText(xCli.getCodigo());
                buscar();
            }
        }
    }//GEN-LAST:event_comboClientesKeyPressed

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
                    Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
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
                int cp = rf.getCodigoProducto();
                Producto pro = null;
                try {
                    pro = new ProductoService().getProductoByCodigo(cp);
                } catch (Exception ex) {
                    Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                Double pre = Double.valueOf(nuevoPrecioTxt.getText().replace(",", "."));
                pre = pre / (1 + porcentualIva / 100);
                rf.setPrecioUnitario(pre);
                calcularLinea2(pro, pre);
                rf.setCantidad(cantidad);
                rf.setDescripcion(pro.getDetalle());
                rf.setDescuento(descuento);
                rf.setExento(0.0);
                rf.setGravado(gravado);
                rf.setImpuesto(impuesto);
                rf.setIva(iva);
                rf.setNoGravado(noGravado);
                rf.setCodigoProducto(pro.getCodigo());
                rf.setSugerido(pro.getSugerido());
                rf.setTotal(totalLinea);
                renglonFactura.set(lin, rf);
                tablaFactura.setValueAt(cantidad.intValue(), lin, 1);
                // en unidad
                tablaFactura.setValueAt(df.format(precioFinal), lin, 3);
                nuevaCantidadTxt.setText("");

                // por cantidad
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
                recalcularBtn.setEnabled(true);
                nuevoPrecioTxt.setText("");
                recalcularBtn.setEnabled(true);
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

    private void descuentoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descuentoBtnActionPerformed
        int row = tablaFactura.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un Producto");
            return;
        }
        int pr = renglonFactura.get(row).getCodigoProducto();
        if (renglonFactura.get(row).getDescuento() > 0.00) {
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
            if (row < 0) {
                descuentoLineaTxt.setEnabled(false);
                agregarBtn.requestFocus();
                return;
            }
            int pr = renglonFactura.get(row).getCodigoProducto();
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

    private void nuevaCantidadTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevaCantidadTxtKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int lin = tablaFactura.getSelectedRow();
            tablaFactura.setEnabled(true);
            if (lin > -1) {
                if (!nuevaCantidadTxt.getText().isEmpty()) {
                    leerCantidadBtn.setEnabled(true);
                    leerPrecioBtn.setEnabled(true);
                    nuevaCantidadTxt.setEditable(false);
                    grabarCantidadBtn.setEnabled(false);
                    ActivityRow rf = renglonFactura.get(lin);
                    cantidad = Float.valueOf(nuevaCantidadTxt.getText());
                    if (!(cantidad > 0.0)) {
                        JOptionPane.showMessageDialog(this, "Debe colocar cantidad mayor que cero");
                        return;
                    }
                    int cp = rf.getCodigoProducto();
                    Producto pro = null;
                    try {
                        pro = new ProductoService().getProductoByCodigo(cp);
                    } catch (Exception ex) {
                        Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
//                    System.out.println(rf.getPrecioUnitario());
//                    JOptionPane.showMessageDialog(this, pro);
                    Double prex = rf.getPrecioUnitario();
                    //prex = prex / (1 + porcentualIva / 100);
                    calcularLinea(pro, prex, cantidad);
                    rf.setCantidad(cantidad);
                    rf.setDescripcion(pro.getDetalle());
                    rf.setDescuento(descuento);
                    rf.setExento(0.0);
                    rf.setGravado(gravado);
                    rf.setImpuesto(impuesto);
                    rf.setIva(iva);
                    rf.setNoGravado(noGravado);
                    rf.setCodigoProducto(pro.getCodigo());
                    rf.setSugerido(pro.getSugerido());
                    rf.setTotal(totalLinea);
                    renglonFactura.set(lin, rf);
                    tablaFactura.setValueAt(cantidad.intValue(), lin, 1);
                    // en unidad
                    tablaFactura.setValueAt(df.format(precioFinal), lin, 3);
                    nuevaCantidadTxt.setText("");

                    // por cantidad
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
                    recalcularBtn.setEnabled(true);
                    calcularTotales();
                }
            }
            agregarBtn.requestFocus();
        }
    }//GEN-LAST:event_nuevaCantidadTxtKeyPressed

    private void nuevoPrecioTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nuevoPrecioTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            int lin = tablaFactura.getSelectedRow();
            if (lin > -1) {
                if (!nuevoPrecioTxt.getText().isEmpty()) {
                    leerPrecioBtn.setEnabled(true);
                    grabarPrecioBtn.setEnabled(false);
                    leerCantidadBtn.setEnabled(true);
                    ActivityRow rf = renglonFactura.get(lin);
                    int cp = rf.getCodigoProducto();
                    Producto pro = null;
                    try {
                        pro = new ProductoService().getProductoByCodigo(cp);
                    } catch (Exception ex) {
                        Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Double pre = Double.valueOf(nuevoPrecioTxt.getText().replace(",", "."));
                    pre = pre / (1 + porcentualIva / 100);
                    rf.setPrecioUnitario(pre);
                    calcularLinea2(pro, pre);
                    rf.setCantidad(cantidad);
                    rf.setDescripcion(pro.getDetalle());
                    rf.setDescuento(descuento);
                    rf.setExento(0.0);
                    rf.setGravado(gravado);
                    rf.setImpuesto(impuesto);
                    rf.setIva(iva);
                    rf.setNoGravado(noGravado);
                    rf.setCodigoProducto(pro.getCodigo());
                    rf.setSugerido(pro.getSugerido());
                    rf.setTotal(totalLinea);
                    renglonFactura.set(lin, rf);
                    tablaFactura.setValueAt(cantidad.intValue(), lin, 1);
                    // en unidad
                    tablaFactura.setValueAt(df.format(precioFinal), lin, 3);
                    nuevaCantidadTxt.setText("");
                    nuevaCantidadTxt.setEditable(false);
                    // por cantidad
                    tablaFactura.setValueAt(df.format(gravado), lin, 4);
                    tablaFactura.setValueAt(df.format(impuesto), lin, 5);
                    tablaFactura.setValueAt(df.format(iva), lin, 6);
                    tablaFactura.setValueAt(df.format(totalLinea), lin, 8);
                    tablaFactura.setEnabled(true);
                    agregarBtn.setEnabled(true);
                    agregarBtn.requestFocus();
                    eliminarItemBtn.setEnabled(true);
                    terminarBtn.setEnabled(true);
                    nuevoPrecioTxt.setEnabled(true);
                    leerPrecioBtn.setEnabled(true);
                    nuevoPrecioTxt.setEditable(false);
                    recalcularBtn.setEnabled(true);
                    nuevoPrecioTxt.setText("");
                    recalcularBtn.setEnabled(true);
                    tablaFactura.setEnabled(true);
                    agregarBtn.setEnabled(true);
                    eliminarItemBtn.setEnabled(true);
                    terminarBtn.setEnabled(true);
                    nuevaCantidadTxt.setEnabled(true);
                    leerCantidadBtn.setEnabled(true);
                    calcularTotales();
                }
            }
        }
    }//GEN-LAST:event_nuevoPrecioTxtKeyPressed

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
            java.util.logging.Logger.getLogger(FacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturaFrame().setVisible(true);
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
    private javax.swing.JLabel descuentoLineaLbl;
    private javax.swing.JTextField descuentoLineaTxt;
    private javax.swing.JTextField descuentoVolumenTxt;
    private javax.swing.JButton eliminarItemBtn;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JButton grabarCantidadBtn;
    private javax.swing.JButton grabarPrecioBtn;
    private javax.swing.JCheckBox imprimeChk;
    private javax.swing.JButton incorporarAFacturaBtn;
    private javax.swing.JTextField ivaCeroTxt;
    private javax.swing.JTextField ivaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JCheckBox pdfChk;
    private javax.swing.JTextField precioProductoConsultaTxt;
    private javax.swing.JTextField razonSocialTxt;
    private javax.swing.JButton recalcularBtn;
    private javax.swing.JTextField saldoTxt;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JButton terminarBtn;
    private javax.swing.JTextField texto1PieFacturaTxt;
    private javax.swing.JTextField texto2PieFacturaTxt;
    private javax.swing.JTextField totalCompraActualTxt;
    private javax.swing.JTextField totalDeudaTxt;
    private javax.swing.JTextField totalMassalinTxt;
    private javax.swing.JTextField totalNoblezaTxt;
    private javax.swing.JTextField totalTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        ivaCeroTxt.setText("");
        ivaCeroTxt.setEditable(false);
        texto1PieFacturaTxt.setText("");
        texto2PieFacturaTxt.setText("");
        totalCompraActualTxt.setText("");
        totalCompraActualTxt.setEditable(false);
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
        descuentoVolumenTxt.setText("0.00");
        descuentoLineaTxt.setText("");
        totalDeudaTxt.setText("0.00");
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        nombreProductoConsultaTxt.setText("");
        precioProductoConsultaTxt.setText("");
        cantidadItemsTxt.setText("");
        descuentoGlobalTxt.setText("");
        nuevaCantidadTxt.setText("");
        nuevoPrecioTxt.setText("");
        totalMassalinTxt.setText("");
        totalNoblezaTxt.setText("");
        imprimeChk.setSelected(true);
        pdfChk.setSelected(false);
    }

    private void bloquearCampos() {
        agregarBtn.setEnabled(false);
        cancelarBtn.setEnabled(false);
        recalcularBtn.setEnabled(false);
        terminarBtn.setEnabled(false);
        incorporarAFacturaBtn.setEnabled(false);
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
        totalNoblezaTxt.setEditable(false);
        totalMassalinTxt.setEditable(false);
        descuentoGlobalTxt.setEditable(false);
        nuevaCantidadTxt.setEnabled(false);
        leerCantidadBtn.setEnabled(false);
        grabarCantidadBtn.setEnabled(false);
        leerPrecioBtn.setEnabled(false);
        grabarPrecioBtn.setEnabled(false);
        nuevoPrecioTxt.setEnabled(false);
    }

    private void llenarComboClientes() {
        filtro = nombreClienteABuscarTxt.getText();
        clientes = null;
        try {
            clientes = new ClienteService().getClientesByFiltro(filtro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - leyendo Clientes");
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboClientes.getModel();
        if (clientes != null && !clientes.isEmpty()) {
            for (Cliente cli : clientes) {
                if (cli.getAlias() != null) {
                    model.addElement(cli.getAlias() + " "
                            + cli.getRazonSocial());
                } else {
                    model.addElement(cli.getRazonSocial());
                }
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
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
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
        String codigo = clienteFc.getCodigo();
        CustomerTraba cuTr = null;
        try {
            cuTr = new CustomerTrabaService().getClienteByCodigo(codigo);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuTr.setTraba2(true);
        try {
            new CustomerTrabaService().updateCliente(cuTr);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al bloquear Cliente");
        }
    }

    private void buscar() {
        filtro = "";
        comboClientes.removeAllItems();
        Long id = (long) 1;
        try {
            Routines conf = new RoutinesService().getFacturas(id);
            porcentualIva = conf.getIva();
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha = Calendar.getInstance().getTime();
        //categoriaIva = 4;
        clienteFactura = null;
        clienteFc = null;
        try {
            clienteFactura = new CustomerService().getCustomerByCodigo(codigoTxt.getText());
            clienteFc = new ClienteService().getClienteByCodigo(codigoTxt.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error - cliente");
            buscarClienteBtn.setEnabled(true);
            codigoTxt.requestFocus();
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        if (clienteFc != null) {
            if (clienteFc.getVendedor() == null) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar Vendedor para este Cliente");
                buscarClienteBtn.setEnabled(true);
                codigoTxt.requestFocus();
                return;
            }
            if (clienteFactura == null) {
                JOptionPane.showMessageDialog(this, "Cliente no habilitado");
                buscarClienteBtn.setEnabled(true);
                codigoTxt.requestFocus();
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Cliente inexistente");
            return;
        }
        if (!clienteFactura.getActivo()) {
            JOptionPane.showMessageDialog(this, "Cliente Inactivo");
            buscarClienteBtn.setEnabled(true);
            codigoTxt.requestFocus();
            return;
        }
        if (clienteFactura != null) {
            String codigo = clienteFc.getCodigo();
            CustomerTraba cuTr = null;
            try {
                cuTr = new CustomerTrabaService().getClienteByCodigo(codigo);
            } catch (Exception ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (cuTr != null) {
                if (cuTr.getTraba2()) {
                    JOptionPane.showMessageDialog(this, "Este cliente esta bloqueado para esta operacion");
                    clienteFc = null;
                    return;
                }
            }
            bloquearCliente();
            if (clienteFc.getImporteMostrador() != null) {
                totalCompraActualTxt.setText(df.format(clienteFc.getImporteMostrador()));
            }
            Double calcu = 0.00;
            Cliente xCli = null;
            try {
                xCli = new ClienteService().getClienteByCodigo(clienteFc.getCodigo());
            } catch (Exception ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (xCli != null) {
                if (xCli.getImporteMostrador() != null) {
                    totalCompraActualTxt.setText(df.format(xCli.getImporteMostrador()));
                    calcu += xCli.getImporteMostrador();
                }
                calcu += xCli.getSaldo();
                calcu += clienteFactura.getSaldo();
                calcu += totalFactura;
            }
            totalDeudaTxt.setText(df.format(calcu));
            razonSocialTxt.setText(clienteFc.getRazonSocial());
            fechaTxt.setText(sdf.format(fecha));
            if (clienteFactura.getTieneDescuento() != null) {
                if (clienteFactura.getTieneDescuento()) {
                    if (clienteFactura.getDescuento() != null) {
                        descuentoGlobalTxt.setText(df.format(clienteFactura.getDescuento()));
                        tieneDto = true;
                        descuen = clienteFactura.getDescuento();
                    } else {
                        descuentoGlobalTxt.setText("0.00");
                        tieneDto = false;
                        descuen = 0F;
                    }
                } else {
                    descuentoGlobalTxt.setText("0.00");
                    tieneDto = false;
                    descuen = 0F;
                }
            } else {
                descuentoGlobalTxt.setText("0.00");
                descuen = 0F;
                tieneDto = false;
            }
//            if (clienteFc.getCategoriaDeIva() != null) {
//                if (clienteFc.getCategoriaDeIva() == 1) {
//                    ivaTxt.setText("Resp. Inscripto");
//                }
//                if (clienteFc.getCategoriaDeIva() == 2) {
            ivaTxt.setText("-");
//                }
//                if (clienteFc.getCategoriaDeIva() == 4) {
//                    ivaTxt.setText("Consumidor Final");
//                }
            //categoriaIva = 4; //clienteFc.getCategoriaDeIva();
//            } else {
//                ivaTxt.setText("Consumidor Final");
//            }
            if (clienteFactura.getSaldo() != null) {
                saldoTxt.setText(String.valueOf(df.format(clienteFactura.getSaldo() + clienteFc.getSaldo())));
                saldoCliente = clienteFactura.getSaldo();
            } else {
                if (clienteFc.getSaldo() != null) {
                    saldoTxt.setText(String.valueOf(df.format(clienteFc.getSaldo())));
                } else {
                    saldoTxt.setText("0.00");
                }
                saldoCliente = 0.0;
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

    private void terminarFactura() {
        //Integer categoriaIva = 4;
        Activity ivaVentas = new Activity();
        String c = clienteFactura.getCodigo();
        try {
            clienteFactura = new CustomerService().getCustomerByCodigo(c);
            clienteFc = new ClienteService().getClienteByCodigo(c);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error - comunicación");
            return;
        }
        saldoCliente = clienteFactura.getSaldo();
        saldoCliente += totalFactura;
        clienteFactura.setSaldo(saldoCliente);
        Double saldo1 = 0.00;
        if (clienteFc.getSaldo() != null) {
            saldo1 = clienteFc.getSaldo();
        }
        Long id = (long) 1;
        Configuracion confi;
        try {
            config = new RoutinesService().getFacturas(id);
            confi = new ConfiguracionService().getFacturas(id);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        config.setUltimaFechaSistema(fecha);
        confi.setUltimaFechaSistema(fecha);
        letraFactura = "B";
        // el resto de las categorias
        sucursalFactura = config.getSucursal();
        numeroFactura = config.getNumeroFactura();
        numeroFactura += 1;
        config.setNumeroFactura(numeroFactura);

//        try {
////            new RoutinesService().updateRoutines(config);
////            new ConfiguracionService().updateConfiguracion(confi);
//        } catch (Exception ex) {
//            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Long ve = clienteFc.getVendedor().getId();
        ivaVentas.setCustomer(clienteFactura);
        ivaVentas.setIdVendedor(ve);
        ivaVentas.setDescuentoGlobal(totalDescuen);
        ivaVentas.setPorcentajeDescuentoGlobal(descuen);
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
        if (!texto1PieFacturaTxt.getText().isEmpty()) {
            ivaVentas.setTextoPieFactura1(texto1PieFacturaTxt.getText());
        } else {
            ivaVentas.setTextoPieFactura1("");
        }
        if (!texto2PieFacturaTxt.getText().isEmpty()) {
            ivaVentas.setTextoPieFactura2(texto2PieFacturaTxt.getText());
        } else {
            ivaVentas.setTextoPieFactura2("");
        }
        ivaVentas.setSaldoActual1(saldo1);
        ivaVentas.setSaldoActual2(saldoCliente);
//        for (ActivityRow reFa : renglonFactura) {
//            reFa.setActivity(ivaVentas);
//            Integer cod = reFa.getCodigoProducto();
//            try {
//                producto = new ProductoService().getProductoByCodigo(cod);
//            } catch (Exception ex) {
//                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Float stock = 0.0F;
//            if (producto.getStock() != null) {
//                stock = producto.getStock();
//            }
//            reFa.setCodigoProducto(producto.getCodigo());
//            stock -= reFa.getCantidad();
////            System.out.println(stock);
////            System.out.println(producto.getUnidad());
////            System.out.println(producto.getProductoCaja());
//            if (stock < 0) {
//                if (producto.getUnidad() != null) {
//                    if (producto.getUnidad()) {
//                        if (producto.getProductoCaja() != null) {
//                            Producto caja = producto.getProductoCaja();
//                            int can = producto.getCantidadCaja();
//                            float stk1 = caja.getStock();
//                            
//                            stk1 -= 1;
//                            caja.setStock(stk1);
//                            try {
//                                new ProductoService().updateProducto(caja);
//                            } catch (Exception ex) {
//                                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            stock += can;
//                        }
//                    }
//                }
//            }
//            producto.setStock(stock);
//            try {
//                new ProductoService().updateProducto(producto);
//            } catch (Exception ex) {
//                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
//            }
////            JOptionPane.showMessageDialog(this, "ver");
//        }
        Inventory ccc = new Inventory();
        ccc.setCliente(clienteFactura);
        ccc.setFactura(ivaVentas);
        ccc.setFecha(fecha);
        ccc.setDebe(totalFactura);
        ccc.setHaber(0.0);
        ccc.setTipo("FC");
        ccc.setSaldo(saldoCliente);
        List<Producto> productos = new ArrayList<>();
        Producto p;
        for (ActivityRow a_r : renglonFactura) {
            Integer cod = a_r.getCodigoProducto();
            try {
                p = new ProductoService().getAllProductoByCodigo(cod);
            } catch (Exception ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            Float st;
            if (p.getStock() != null) {
                st = p.getStock();
            } else {
                st = 0F;
            }
            st -= a_r.getCantidad();
            p.setStock(st);
            productos.add(p);
        }
        try {
            /*
            try {
            new InventoryService().saveInventory(ccc);
            } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
             */
            new PresupuestoService().savePresupuestoCompleto(clienteFactura, config, ivaVentas, ccc, renglonFactura, confi, productos);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        desbloquearCliente();
        generarFactura(ivaVentas);
        FacturarFrame ff = new FacturarFrame();
        ff.setVisible(true);
        this.dispose();
    }

    private void generarFactura(Activity ivaVentas) {
        renglones = new String[maxNro];
        textoFacturaPapel = "PRESUPUESTO";
        fechaFacturaPapel = sdf.format(fecha);
        clienteFacturaPapel = razonSocialTxt.getText();
        Cliente xCli = null;
        try {
            xCli = new ClienteService().getClienteByCodigo(clienteFactura.getCodigo());
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        codigoClienteFacturaPapel = xCli.getCodigo();
        direccionFacturaPapel = xCli.getDomicilio().getCalle() + " " + xCli.getDomicilio().getNumero() + " - " + xCli.getDomicilio().getLocalidad();
        //cuitFacturaPapel = xCli.getCuit();
        String condVta = "";
//        Date fechaVto = fecha;
//        Calendar cal = new GregorianCalendar();
//        cal.setTime(fecha);
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
        //nombresColumnaFacturaPapel = "  IT   CANT                 DETALLE                   P.UNIT.     GRAVADO      IVA       IMP.     TOTAL     SUG";
        nombresColumnaFacturaPapel = "IT   CANT                   DETALLE                  P.UNIT.     DESC.      IMPORTE       IMP.        TOTAL        SUG";
//        }
        //DecimalFormat df = new DecimalFormat("#0.00");
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
                if (largo > 38) {
                    str0 = str0.substring(0, 38);
                    tablaFactura.setValueAt(str0, r, 2);
                } else {
                    for (int l = largo; l < 38; l++) {
                        espacio += " ";
                    }
                }
                renglones[r] = renglones[r] + " " + tablaFactura.getValueAt(r, 2) + espacio;
                //      if (categoriaIva != 1) {
//                  aqui detalle de importes no inscripto en IVA           *****
// Precio Unitario
                str0 = tablaFactura.getValueAt(r, 3).toString();
                str0 = str0.replace(",", ".");
                Double doble = Double.valueOf(str0);
                largo = doble.intValue();
                espacio = "        "; // 9
                largo = String.valueOf(largo).length();
                espacio = espacio.substring(largo);
                renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Descuento
                str0 = tablaFactura.getValueAt(r, 7).toString();
                str0 = str0.replace(",", ".");
                doble = Double.valueOf(str0);
                largo = doble.intValue();
                espacio = "      "; // 6
                largo = String.valueOf(largo).length();
                espacio = espacio.substring(largo);
                renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Importe
                str0 = tablaFactura.getValueAt(r, 4).toString(); //GRAVADO
                str0 = str0.replace(",", ".");
                Double calculo = Double.valueOf(str0);
                str0 = tablaFactura.getValueAt(r, 6).toString(); // IVA
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
                str0 = tablaFactura.getValueAt(r, 5).toString();
                str0 = str0.replace(",", ".");
                doble = Double.valueOf(str0);
                largo = doble.intValue();
                espacio = "       "; // 7
                largo = String.valueOf(largo).length();
                espacio = espacio.substring(largo);
                renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//  Total linea
                str0 = tablaFactura.getValueAt(r, 8).toString();
                str0 = str0.replace(",", ".");
                doble = Double.valueOf(str0);
                largo = doble.intValue();
                espacio = "         "; // 9
                largo = String.valueOf(largo).length();
                espacio = espacio.substring(largo);
                renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
// Sugerido
                str0 = tablaFactura.getValueAt(r, 9).toString();
                int lrg = str0.length();
                if (lrg > 8) {
                    doble = 0.0;
                    espacio = "       "; // 7
                } else {
                    str0 = str0.replace(",", ".");
                    doble = Double.valueOf(str0);
                    largo = doble.intValue();
                    espacio = "       "; // 7
                    largo = String.valueOf(largo).length();
                    espacio = espacio.substring(largo);
                }
                renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
                // } 
//                else {
//                    // aqui detalle importes inscripto
//// Precio Unitario
//                    str0 = tablaFactura.getValueAt(r, 3).toString();
//                    str0 = str0.replace(",", ".");
//                    Double doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "     ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//// Descuento
//                    str0 = tablaFactura.getValueAt(r, 7).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "     ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//// Gravado
//                    str0 = tablaFactura.getValueAt(r, 4).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "      ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//// Iva
//                    str0 = tablaFactura.getValueAt(r, 6).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "     ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//// Impuesto
//                    str0 = tablaFactura.getValueAt(r, 5).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "       ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
////  Total linea
//                    str0 = tablaFactura.getValueAt(r, 8).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "      ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//// Sugerido
//                    str0 = tablaFactura.getValueAt(r, 9).toString();
//                    str0 = str0.replace(",", ".");
//                    doble = Double.valueOf(str0);
//                    largo = doble.intValue();
//                    espacio = "    ";
//                    largo = String.valueOf(largo).length();
//                    espacio = espacio.substring(largo);
//                    renglones[r] = renglones[r] + espacio + df.format(doble) + " ";
//                }
            } else {
                // agregar renglon en blanco
                renglones[r] = " ";
            }
        }
        // Saldo Cliente
        try {
            clienteFc = new ClienteService().getClienteByCodigo(clienteFactura.getCodigo());
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        saldoTot = clienteFc.getSaldo();
        saldoCliente = clienteFactura.getSaldo();
        String str0 = String.valueOf(saldoCliente + saldoTot - totalFactura);
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
        // if (categoriaIva != 1) {
        str0 = String.valueOf(totalImpuesto);
        str0 = str0.replace(",", ".");
        doble = Double.valueOf(str0);
        largo = doble.intValue();
        //espacio = "                                                                            ";
        espacio = "                                                            Total Impuesto: ";
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
        lineaTotalesFacturaPapel = espacio + df.format(doble);
        //  } 
        //else {
//            str0 = String.valueOf(totalGravado);
//            str0 = str0.replace(",", ".");
//            doble = Double.valueOf(str0);
//            largo = doble.intValue();
//            espacio = "           ";
//            largo = String.valueOf(largo).length();
//            espacio = espacio.substring(largo);
//            lineaTotalesFacturaPapel = espacio + df.format(doble);
//            str0 = String.valueOf(totalImpuesto);
//            str0 = str0.replace(",", ".");
//            doble = Double.valueOf(str0);
//            largo = doble.intValue();
//            espacio = "           ";
//            largo = String.valueOf(largo).length();
//            espacio = espacio.substring(largo);
//            lineaTotalesFacturaPapel += espacio + df.format(doble);
//            str0 = String.valueOf(totalIva);
//            str0 = str0.replace(",", ".");
//            doble = Double.valueOf(str0);
//            largo = doble.intValue();
//            espacio = "                                 ";
//            largo = String.valueOf(largo).length();
//            espacio = espacio.substring(largo);
//            lineaTotalesFacturaPapel += espacio + df.format(doble);
        //}
// Total a Pagar
        Double totalPagar = saldoCliente + saldoTot;
        str0 = String.valueOf(totalPagar);
        str0 = str0.replace(",", ".");
        doble = Double.valueOf(str0);
        largo = doble.intValue();
        espacio = "          ";
        largo = String.valueOf(largo).length();
        espacio = espacio.substring(largo);
        totalPagarFacturaPapel = espacio + df.format(doble);
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
        recalcularBtn.setEnabled(true);
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
            InputStream path;
            path = getClass().getResourceAsStream("c:/ventas/stop.wav");
            try {
                Clip sonido = AudioSystem.getClip();
                sonido.open(AudioSystem.getAudioInputStream(path));
                sonido.start();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Cantidad de artículos excedido");
            return;
        }
        terminarBtn.setEnabled(true);
        recalcularBtn.setEnabled(true);
        eliminarItemBtn.setEnabled(true);
        cancelarBtn.setEnabled(true);
        Producto pro = null;
        encontrado = false;
        if (!codigoBarrasTxt.getText().isEmpty()) {
            try {
                pro = new ProductoService().getProductoByCodigoBarras(Long.valueOf(codigoBarrasTxt.getText()));
                encontrado = true;
            } catch (Exception ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                codigoBarrasTxt.requestFocus();
            }
        } else {
            if (!codigoProductoTxt.getText().isEmpty()) {
                try {
                    pro = new ProductoService().getProductoByCodigo(Integer.valueOf(codigoProductoTxt.getText()));
                    encontrado = true;
                } catch (Exception ex) {
                    Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
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
                    if (existe(pro)) {
                        JOptionPane.showMessageDialog(this, "YA INGRESO ESTE PRODUCTO EN LA FACTURA");
                        return;
                    }
                    cantidad = Float.valueOf(cantidadTxt.getText());
                    // en unidad
                    if (!(cantidad > 0.0)) {
                        JOptionPane.showMessageDialog(this, "Debe colocar cantidad mayor que cero");
                        cantidadTxt.requestFocus();
                        return;
                    }
                    if (totalLinea > Constantes.maximoVenta) {
                        System.out.print("\007");
                        System.out.flush();
                        JOptionPane.showMessageDialog(this, "Importe supera maximo de linea");
                        codigoProductoTxt.setText("");
                        cantidadTxt.setText("");
                        buscarClienteBtn.setEnabled(false);
                        recalcularBtn.setEnabled(true);
                        codigoBarrasTxt.requestFocus();
                        return;
                    }
                    Double prex = pro.getPrecio();
                    calcularLinea(pro, prex, cantidad);
                    ActivityRow rf = new ActivityRow();
                    rf.setCantidad(cantidad);
                    rf.setDescripcion(pro.getDetalle());
                    rf.setPrecioUnitario(pro.getPrecio());
                    rf.setImpuestoUnitario(pro.getImpuesto());
                    rf.setDescuento(descuento);
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
                    fila[7] = df.format(descuento);
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
                    buscarClienteBtn.setEnabled(false);
                    recalcularBtn.setEnabled(true);
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
        agregarBtn.requestFocus();
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
                if (prod.getInactivo()) {
                    JOptionPane.showMessageDialog(this, "Producto Inactivo");
                    codigoProductoTxt.setText("");
                    codigoProductoTxt.requestFocus();
                    return;
                }
                //if (!(prod.getSubRubro().getCodigo().equals(5099))) {
                nombreProductoConsultaTxt.setText(prod.getDetalle());
                Float pi = porcentualIva;
                if (prod.getIvaCero()) {
                    pi = 0F;
                    ivaCeroTxt.setText("IVA CERO");
                } else {
                    ivaCeroTxt.setText("");
                }
                Double precioProductoConsulta = prod.getPrecio();
                precioProductoConsulta += precioProductoConsulta * pi / 100;
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

    private void calcularTotales() {
        totalGravado = 0.0;
        totalIva = 0.0;
        totalImpuesto = 0.0;
        totalDescuen = 0.0;
        totalFactura = 0.0;
        nro = 0;
        cantidadAtadosMassalin = 0;
        cantidadAtadosNobleza = 0;
        Double importeTotalMassalin = 0.0;
        Double importeTotalNobleza = 0.0;
        Double totalCalculo = 0.0;
        for (ActivityRow renFa : renglonFactura) {
            totalGravado += renFa.getGravado();
            totalIva += renFa.getIva();
            Producto xPro = null;
            try {
                xPro = new ProductoService().getProductoByCodigo(renFa.getCodigoProducto());
            } catch (Exception ex) {
                Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            if (xPro.getRubro().getCodigo().equals(1)) {
                cantidadAtadosMassalin += renFa.getCantidad().intValue();
                importeTotalMassalin += renFa.getTotal();
            }
            cantidadAtadosMassalinTxt.setText(String.valueOf(cantidadAtadosMassalin));
            totalMassalinTxt.setText(df.format(importeTotalMassalin));
            if (xPro.getRubro().getCodigo().equals(2)) {
                cantidadAtadosNobleza += renFa.getCantidad().intValue();
                importeTotalNobleza += renFa.getTotal();
            }
            cantidadAtadosNoblezaTxt.setText(String.valueOf(cantidadAtadosNobleza));
            totalNoblezaTxt.setText(df.format(importeTotalNobleza));
            if (tieneDto) {
                if (xPro.getRubro().getCodigo().equals(5)) {
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
        totalTxt.setText(String.valueOf(df.format(totalFactura)));
        totalDeudaTxt.setText(df.format(saldoCliente + totalFactura));
        String codClie = clienteFactura.getCodigo();
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
            calcu += clienteFactura.getSaldo();
            calcu += totalFactura;
        }
        totalDeudaTxt.setText(df.format(calcu));
    }

    private void consultarProductoBarras() {
        nombreProductoConsultaTxt.setEnabled(true);
        precioProductoConsultaTxt.setEnabled(true);
        if (!codigoBarrasTxt.getText().isEmpty()) {
            Long codigoBarras = Long.valueOf(codigoBarrasTxt.getText());
            Producto prod = null;
            try {
                prod = new ProductoService().getProductoByCodigoBarras(codigoBarras);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "COD BARRAS DUPLICADO");
                //Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                codigoProductoTxt.setText("");
                codigoBarrasTxt.setText("");
                codigoProductoTxt.requestFocus();
                return;
            }
            if (prod == null) {
                JOptionPane.showMessageDialog(this, "No existe Producto_2936");
                //Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
                codigoProductoTxt.setText("");
                codigoBarrasTxt.setText("");
                codigoProductoTxt.requestFocus();
                return;
            }
            nombreProductoConsultaTxt.setText(prod.getDetalle());
            Double precioProductoConsulta = prod.getPrecio();
            precioProductoConsulta += precioProductoConsulta * porcentualIva / 100;
            if (prod.getImpuesto() != null) {
                precioProductoConsulta += prod.getImpuesto();
            }
            precioProductoConsultaTxt.setText(df.format(precioProductoConsulta));
            cantidadTxt.requestFocus();
        }
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
            //Float cant = rf.getCantidad();
            Double iva = rf.getPrecioUnitario() * porcentualIva / 100;
            Double prec = rf.getPrecioUnitario();
            nuevoPrecioTxt.setText(String.valueOf(df.format(prec + iva)));
            nuevoPrecioTxt.setEditable(true);
            leerPrecioBtn.setEnabled(false);
            grabarPrecioBtn.setEnabled(true);
            leerCantidadBtn.setEnabled(false);
            tablaFactura.setEnabled(false);
            agregarBtn.setEnabled(false);
            eliminarItemBtn.setEnabled(false);
            terminarBtn.setEnabled(false);
            nuevaCantidadTxt.setEnabled(false);
            recalcularBtn.setEnabled(false);
            nuevoPrecioTxt.requestFocus();
        }
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

    private void calcularLinea(Producto pro, Double pre, Float canti) {
        Float pi = porcentualIva;
        if (pro.getIvaCero()) {
            pi = 0F;
        }

        descuento = 0.0;
        String s1;
        String st1;
        Double pr;
        impuesto = pro.getImpuesto() * canti.doubleValue();
        s1 = df.format(impuesto);
        impuesto = Double.valueOf(s1.replace(",", "."));
        pr = (pre * (1 + (pi / 100))) * canti.doubleValue();
        st1 = df.format(pr);
        pr = Double.valueOf(st1.replace(",", "."));
        totalLinea = pr + impuesto;
        s1 = df.format(totalLinea);
        totalLinea = Double.valueOf(s1.replace(",", "."));
        precioFinal = (pre * (1 + (pi / 100))) + pro.getImpuesto();
        gravado = pre * canti.doubleValue();
        s1 = df.format(gravado);
        gravado = Double.valueOf(s1.replace(",", "."));
        if (pro.getIvaCero()) {
            iva = 0.0;
        } else {
            iva = gravado * pi / 100;
            s1 = df.format(iva);
            iva = Double.valueOf(s1.replace(",", "."));
        }

//        String st1;
//        Double pr = 0.0;
//        pr = (pre * (1 + (pi / 100)));
//        st1 = df.format(pr);
//        pr = Double.valueOf(st1.replace(",", "."));
//        precioFinal = pr + pro.getImpuesto();
//        String s1 = df.format(precioFinal);
//        precioFinal = Double.valueOf(s1.replace(",", "."));
//        
//        gravado = precioFinal * canti;
//        s1 = df.format(gravado / (1 + (pi / 100)));
//        gravado = Double.valueOf(s1.replace(",", "."));
//        if (pro.getIvaCero()) {
//            iva = 0.0;
//        } else {
//            iva = gravado * pi / 100;
//            s1 = df.format(iva);
//            iva = Double.valueOf(s1.replace(",", "."));
//        }
//        totalLinea = gravado + iva + impuesto;
//        descuento = 0.0;
//        System.out.println(totalLinea);
//        System.out.println(gravado);
//        System.out.println(impuesto);
//        System.out.println(iva);
//        System.exit(0);
    }

    private void calcularLinea2(Producto pro, Double pre) {
        Float pi = porcentualIva;
        if (pro.getIvaCero()) {
            pi = 0F;
        }
        String st1;
        Double pr = 0.0;
        pr = pre * (1 + pi / 100);
        st1 = df.format(pr);
        pr = Double.valueOf(st1.replace(",", "."));
        precioFinal = pr;
        String s1 = df.format(precioFinal);
        precioFinal = Double.valueOf(s1.replace(",", "."));
        impuesto = 0.0;
        gravado = precioFinal * cantidad;
        s1 = df.format(gravado / (1 + (pi / 100)));
        gravado = Double.valueOf(s1.replace(",", "."));
        if (pro.getIvaCero()) {
            iva = 0.0;
        } else {
            iva = gravado * pi / 100;
            s1 = df.format(iva);
            iva = Double.valueOf(s1.replace(",", "."));
        }
        totalLinea = gravado + iva;
        descuento = 0.0;
    }

    private void pdf(Activity iv, List<ActivityRow> rf, Integer caN, Integer caM, Double sAn, Double sTo, Boolean saldos) {
        String code = iv.getCustomer().getCodigo();
        Cliente cli = null;
        try {
            cli = new ClienteService().getClienteByCodigo(code);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            File ps = new PDFBuilder().armarPresup(cli, iv, rf, caN, caM, sAn, sTo, saldos);
            DesktopApi.open(ps);
            JOptionPane.showMessageDialog(this, "PDF CREADO CORRECTAMENTE");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err1");
            JOptionPane.showMessageDialog(this, "ERROR FILE 3212");
        } catch (DocumentException ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("err2");
            JOptionPane.showMessageDialog(this, "ERROR DOCUMENT 3216");
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR EXCEPTION 3219");
            System.out.println("err3");
        }
    }

    private boolean existe(Producto pp) {
        Boolean existe = false;
        for (ActivityRow ar : renglonFactura) {
            if (ar.getCodigoProducto().equals(pp.getCodigo())) {
                existe = true;
            }
        }
        return existe;
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
            String sucFactura = "0001";
            espacio = "                                                         ";
            g2.drawString(espacio + textoFacturaPapel, 30, row);
            if (sucursalFactura != null) {
                sucFactura = "000" + sucursalFactura.toString();
            }
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
//            g2.drawString("--", 100, row);
//            g2.drawString("--", 360, row);
            row += 17;
            g2.drawString(condicionVentaFacturaPapel, 150, row);
            g2.drawString("Ref.Interna:" + letraFactura + " " + sucursalFactura + "-" + numeroFactura, 350, row);
            row += 17;
            if (!entrega.isEmpty()) {
                g2.drawString(espacio + "Domicilio entrega: " + entrega, 30, row);
            }
            row += 17;
            g2.drawString(nombresColumnaFacturaPapel, 30, row);
            row += 15;
            for (int x = 0; x < maxNro; x++) {
                if (renglones[x] != null) {
                    g2.drawString(renglones[x], 30, row);
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
