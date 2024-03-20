/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.main;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.CtaCteCliente;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.Payment;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.entities.Usuario;
import ar.com.ventas.frame.A0000Test0;
import ar.com.ventas.frame.A000tstprodxcbarrasFrame;
import ar.com.ventas.frame.AbmClienteFrame;
import ar.com.ventas.frame.AbmClientesInactivosFrame;
import ar.com.ventas.frame.AbmComprobantesCompraFrame;
import ar.com.ventas.frame.AbmPeriodosFrame;
import ar.com.ventas.frame.AbmProductoFrame;
import ar.com.ventas.frame.AbmProductoV2Frame;
import ar.com.ventas.frame.AbmProveedoresFrame;
import ar.com.ventas.frame.AbmRubroFrame;
import ar.com.ventas.frame.AbmStockFrame;
import ar.com.ventas.frame.AbmSubRubroFrame;
import ar.com.ventas.frame.AbmUsuariosFrame;
import ar.com.ventas.frame.AbmVendedorFrame;
import ar.com.ventas.frame.CantidadVentaPeriodoFrame;
import ar.com.ventas.frame.CierreCajaDiarioFrame;
import ar.com.ventas.frame.ComprobantesPendientesFrame;
import ar.com.ventas.frame.ConfiguracionFrame;
import ar.com.ventas.frame.ConsultarPrecioFrame;
import ar.com.ventas.frame.CuentaCorrienteProveedorFrame;
import ar.com.ventas.frame.CuentaCorrienteStockFrame;
import ar.com.ventas.frame.FacturarFrame;
import ar.com.ventas.frame.ImportarClienteFrame;
import ar.com.ventas.frame.ImportarProductoFrame;
import ar.com.ventas.frame.InformeStockComprasFrame;
import ar.com.ventas.frame.LibroIvaComprasFrame;
import ar.com.ventas.frame.ListaFacturas;
import ar.com.ventas.frame.ListaPreciosFrame;
import ar.com.ventas.frame.ListadoActualizarPreciosFrame;
import ar.com.ventas.frame.ListarClientePorVendedorFrame;
import ar.com.ventas.frame.ListarPorFamiliaProductosFrame;
import ar.com.ventas.frame.ListarRecibosFrame;
import ar.com.ventas.frame.MarcarProductosParaGondolaFrame;
import ar.com.ventas.frame.ModificarPrecioProductoFrame;
import ar.com.ventas.frame.NotaCreditoSelectFrame;
import ar.com.ventas.frame.PagosFrame;
import ar.com.ventas.frame.PedidoFrame;
import ar.com.ventas.frame.ProductosByRubroSubRubroFrame;
import ar.com.ventas.frame.ProductosEnCeroFrame;
import ar.com.ventas.frame.ProductosInactivosFrame;
import ar.com.ventas.frame.ProductosIvaCeroFrame;
import ar.com.ventas.frame.RankingDeudoresFrame;
import ar.com.ventas.frame.RegenerarPdfFrame;
import ar.com.ventas.frame.RegenerarPresupPdfFrame;
import ar.com.ventas.frame.ReimpresionDocumentoPorClienteFrame;
import ar.com.ventas.frame.RelacionVendeListaPorceFrame;
import ar.com.ventas.frame.ResumenCajaDiarioFrame;
import ar.com.ventas.frame.SeguimientoProcesosCompraFrame;
import ar.com.ventas.frame.SeguimientoVentaCigarrilloFrame;
import ar.com.ventas.frame.StockProductosActivosFrame;
import ar.com.ventas.frame.VentaCigarrillosEntreFechasFrame;
import ar.com.ventas.frame.VentasXClienteFrame;
import ar.com.ventas.frame.VerCuentaCorrienteClienteFrame;
import ar.com.ventas.frame.VerFcAbonadasPorPeriodoFrame;
import ar.com.ventas.frame.VerProductosFrame;
import ar.com.ventas.frame.VerReservorioFrame;
import ar.com.ventas.frame.VerSaldosPendientesProveedoresFrame;
import ar.com.ventas.frame.VerificarCajasFrame;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.CtaCteClienteService;
import ar.com.ventas.services.InventoryService;
import ar.com.ventas.services.PaymentService;
import ar.com.ventas.services.ReciboService;
import ar.com.ventas.services.UsuarioService;
import ar.com.ventas.util.LectorDeExcel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author supervisor
 */
public class MainFrame extends javax.swing.JFrame {

    private String filtro = "";
    private Usuario usuario;
    private final Integer nivel = 1;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {

        initComponents();
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        this.setLocationRelativeTo(null);
        recBtn.setVisible(false);
        backupMnu.setVisible(false);
        seguimientoMnu.setVisible(false);
        goBtn.setVisible(false);
        ventasCigarrillosMnu.setVisible(false);
//        99
//        listaPreciosMnu.setVisible(false);
//        InetAddress localHost=null;
//        try {
//            localHost = InetAddress.getLocalHost();
//        } catch (UnknownHostException ex) {
//            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//System.out.println(localHost.getHostName());
//System.out.println(localHost.getHostAddress());

//        System.out.println(address.getHostName());
//        DecimalFormat df_grv = new DecimalFormat("#######0.00");
//        //                                        1234567890
//        System.out.println(df_grv.format(10));
//        System.out.println(df_grv.format(123456));
//        System.out.println(df_grv.format(1234));
//        System.out.println(df_grv.format(100));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jMenuItem5 = new javax.swing.JMenuItem();
        salirBtn = new javax.swing.JButton();
        facturarBtn = new javax.swing.JButton();
        cobrarBtn = new javax.swing.JButton();
        facturaBtn = new javax.swing.JButton();
        notaCreditoBtn = new javax.swing.JButton();
        consultarPrecioBtn = new javax.swing.JButton();
        recBtn = new javax.swing.JButton();
        goBtn = new javax.swing.JButton();
        mainMenuFrame = new javax.swing.JMenuBar();
        archivo = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        clientesMenu = new javax.swing.JMenuItem();
        productosMenu = new javax.swing.JMenuItem();
        modificarProductoPorPrecioMnu = new javax.swing.JMenuItem();
        rubroMenu = new javax.swing.JMenuItem();
        subRubroMenu = new javax.swing.JMenuItem();
        usuariosMnu = new javax.swing.JMenuItem();
        vendedorMnu = new javax.swing.JMenuItem();
        relacionVendeListaPorcMnu = new javax.swing.JMenuItem();
        stockMnu = new javax.swing.JMenuItem();
        productosInactivosMnu = new javax.swing.JMenuItem();
        productosIvaCeroMnu = new javax.swing.JMenuItem();
        clientesInactivosMnu = new javax.swing.JMenuItem();
        nuevoProductoMnu = new javax.swing.JMenuItem();
        productoByRubroSubMnu = new javax.swing.JMenuItem();
        salirMenu = new javax.swing.JMenuItem();
        herramientas = new javax.swing.JMenu();
        configMenu = new javax.swing.JMenuItem();
        actualizaPrecioMenu = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        reimpresionPedidoMnu = new javax.swing.JMenuItem();
        regenerarPdfMnu = new javax.swing.JMenuItem();
        regenerarPresupPdfMnu = new javax.swing.JMenuItem();
        backupMnu = new javax.swing.JMenuItem();
        testCBMnu = new javax.swing.JMenuItem();
        marcarProductosParaGondolaMnu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        informes = new javax.swing.JMenu();
        ivaVentasMenu = new javax.swing.JMenuItem();
        ventasPorCliente = new javax.swing.JMenuItem();
        informeProductosMnu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cierreDiarioMnu = new javax.swing.JMenuItem();
        resumenCajaDiarioMnu = new javax.swing.JMenuItem();
        verificarCajasMnu = new javax.swing.JMenuItem();
        listarRcXdiaMnu = new javax.swing.JMenuItem();
        rankingMnu = new javax.swing.JMenuItem();
        facturadoPorFamiliaMnu = new javax.swing.JMenuItem();
        clientePorVendedorMnu = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        stockProductosActivosMnu = new javax.swing.JMenuItem();
        stockFaltantesMnu = new javax.swing.JMenuItem();
        cantidadVentaPeriodoMnu = new javax.swing.JMenuItem();
        cantVentaStockFamiliaMnu = new javax.swing.JMenuItem();
        ctaStockMnu = new javax.swing.JMenuItem();
        stockParaComprasMnu = new javax.swing.JMenuItem();
        listadosActualizaPrecioMnu = new javax.swing.JMenuItem();
        listaPreciosMnu = new javax.swing.JMenuItem();
        listaProductosCeroMnu = new javax.swing.JMenuItem();
        saldosClientesMnu = new javax.swing.JMenuItem();
        ventasCigarrillosMnu = new javax.swing.JMenuItem();
        seguimientoVentaCigarrilloMnu = new javax.swing.JMenuItem();
        ventas = new javax.swing.JMenu();
        abmProveedoresMnu = new javax.swing.JMenuItem();
        abmComprobantesMnu = new javax.swing.JMenuItem();
        periodosMnu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        libroIvaComprasMnu = new javax.swing.JMenuItem();
        cuentaCorrienteMnu = new javax.swing.JMenuItem();
        pendientesMnu = new javax.swing.JMenuItem();
        saldosPendientesMnu = new javax.swing.JMenuItem();
        abonadosPorPeriodoMnu = new javax.swing.JMenuItem();
        pagosMnu = new javax.swing.JMenuItem();
        seguimientoMnu = new javax.swing.JMenuItem();
        salirMnu = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        versionMnu = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("Dist. - A y M"), this, org.jdesktop.beansbinding.BeanProperty.create("title"));
        bindingGroup.addBinding(binding);

        salirBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        facturarBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        facturarBtn.setText("Pedido");
        facturarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturarBtnActionPerformed(evt);
            }
        });

        cobrarBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cobrarBtn.setText("Cobrar");
        cobrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobrarBtnActionPerformed(evt);
            }
        });

        facturaBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        facturaBtn.setText("Presupuesto");
        facturaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaBtnActionPerformed(evt);
            }
        });

        notaCreditoBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        notaCreditoBtn.setText("Devolución");
        notaCreditoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notaCreditoBtnActionPerformed(evt);
            }
        });

        consultarPrecioBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        consultarPrecioBtn.setText("Consultar Precios");
        consultarPrecioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarPrecioBtnActionPerformed(evt);
            }
        });

        recBtn.setText("rec");
        recBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recBtnActionPerformed(evt);
            }
        });

        goBtn.setText("Cantidad Registros");
        goBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBtnActionPerformed(evt);
            }
        });

        archivo.setText("Archivo");
        archivo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenu1.setText("ABM");
        jMenu1.setFont(jMenu1.getFont().deriveFont(jMenu1.getFont().getSize()+2f));

        clientesMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        clientesMenu.setText("Clientes");
        clientesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesMenuActionPerformed(evt);
            }
        });
        jMenu1.add(clientesMenu);

        productosMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        productosMenu.setText("Productos");
        productosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosMenuActionPerformed(evt);
            }
        });
        jMenu1.add(productosMenu);

        modificarProductoPorPrecioMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        modificarProductoPorPrecioMnu.setText("Producto X Precio");
        modificarProductoPorPrecioMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarProductoPorPrecioMnuActionPerformed(evt);
            }
        });
        jMenu1.add(modificarProductoPorPrecioMnu);

        rubroMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rubroMenu.setText("Rubro");
        rubroMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rubroMenuActionPerformed(evt);
            }
        });
        jMenu1.add(rubroMenu);

        subRubroMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        subRubroMenu.setText("Sub Rubro");
        subRubroMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subRubroMenuActionPerformed(evt);
            }
        });
        jMenu1.add(subRubroMenu);

        usuariosMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        usuariosMnu.setText("Usuarios");
        usuariosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosMnuActionPerformed(evt);
            }
        });
        jMenu1.add(usuariosMnu);

        vendedorMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        vendedorMnu.setText("Vendedores");
        vendedorMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendedorMnuActionPerformed(evt);
            }
        });
        jMenu1.add(vendedorMnu);

        relacionVendeListaPorcMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        relacionVendeListaPorcMnu.setText("Relación Vend-List-Porc");
        relacionVendeListaPorcMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relacionVendeListaPorcMnuActionPerformed(evt);
            }
        });
        jMenu1.add(relacionVendeListaPorcMnu);

        stockMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        stockMnu.setText("Stock");
        stockMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockMnuActionPerformed(evt);
            }
        });
        jMenu1.add(stockMnu);

        productosInactivosMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        productosInactivosMnu.setText("Productos Inactivos");
        productosInactivosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosInactivosMnuActionPerformed(evt);
            }
        });
        jMenu1.add(productosInactivosMnu);

        productosIvaCeroMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        productosIvaCeroMnu.setText("Productos Iva Cero");
        productosIvaCeroMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosIvaCeroMnuActionPerformed(evt);
            }
        });
        jMenu1.add(productosIvaCeroMnu);

        clientesInactivosMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        clientesInactivosMnu.setText("Clientes Inactivos");
        clientesInactivosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesInactivosMnuActionPerformed(evt);
            }
        });
        jMenu1.add(clientesInactivosMnu);

        nuevoProductoMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nuevoProductoMnu.setText("Producto - Nueva Versión");
        nuevoProductoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProductoMnuActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoProductoMnu);

        productoByRubroSubMnu.setText("PRODUCTOS X RUBRO Y SUB_RUBRO");
        productoByRubroSubMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoByRubroSubMnuActionPerformed(evt);
            }
        });
        jMenu1.add(productoByRubroSubMnu);

        archivo.add(jMenu1);

        salirMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        salirMenu.setText("Salir");
        salirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuActionPerformed(evt);
            }
        });
        archivo.add(salirMenu);

        mainMenuFrame.add(archivo);

        herramientas.setText("Herramientas");
        herramientas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        configMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        configMenu.setText("Configuración");
        configMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configMenuActionPerformed(evt);
            }
        });
        herramientas.add(configMenu);

        actualizaPrecioMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        actualizaPrecioMenu.setText("Reservorio");
        actualizaPrecioMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizaPrecioMenuActionPerformed(evt);
            }
        });
        herramientas.add(actualizaPrecioMenu);

        jMenu5.setText("Reimpresión");
        jMenu5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });

        reimpresionPedidoMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        reimpresionPedidoMnu.setText("Selección x Cliente");
        reimpresionPedidoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reimpresionPedidoMnuActionPerformed(evt);
            }
        });
        jMenu5.add(reimpresionPedidoMnu);

        herramientas.add(jMenu5);

        regenerarPdfMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        regenerarPdfMnu.setText("Regenerar Fc/Nc PDF");
        regenerarPdfMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regenerarPdfMnuActionPerformed(evt);
            }
        });
        herramientas.add(regenerarPdfMnu);

        regenerarPresupPdfMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        regenerarPresupPdfMnu.setText("Regenerar Presup./Devol PDF");
        regenerarPresupPdfMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regenerarPresupPdfMnuActionPerformed(evt);
            }
        });
        herramientas.add(regenerarPresupPdfMnu);

        backupMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        backupMnu.setText("Backup");
        backupMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupMnuActionPerformed(evt);
            }
        });
        herramientas.add(backupMnu);

        testCBMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        testCBMnu.setText("Test CB");
        testCBMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testCBMnuActionPerformed(evt);
            }
        });
        herramientas.add(testCBMnu);

        marcarProductosParaGondolaMnu.setText("MARCAR PRODUCTOS PARA GONDOLA");
        marcarProductosParaGondolaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marcarProductosParaGondolaMnuActionPerformed(evt);
            }
        });
        herramientas.add(marcarProductosParaGondolaMnu);

        jMenuItem1.setText("BUSCAR DOMICILIOS DE CLIENTES DUPLICADOS");
        herramientas.add(jMenuItem1);

        mainMenuFrame.add(herramientas);

        informes.setText("Informes");
        informes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ivaVentasMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ivaVentasMenu.setText("Lista Movimientos");
        ivaVentasMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ivaVentasMenuActionPerformed(evt);
            }
        });
        informes.add(ivaVentasMenu);

        ventasPorCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ventasPorCliente.setText("Ventas x Cliente");
        ventasPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasPorClienteActionPerformed(evt);
            }
        });
        informes.add(ventasPorCliente);

        informeProductosMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        informeProductosMnu.setText("Productos");
        informeProductosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informeProductosMnuActionPerformed(evt);
            }
        });
        informes.add(informeProductosMnu);

        jMenu2.setText("Cierre de Caja");
        jMenu2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cierreDiarioMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cierreDiarioMnu.setText("Cierre Caja Diario");
        cierreDiarioMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cierreDiarioMnuActionPerformed(evt);
            }
        });
        jMenu2.add(cierreDiarioMnu);

        resumenCajaDiarioMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        resumenCajaDiarioMnu.setText("Resumen Cierre Caja Diario");
        resumenCajaDiarioMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resumenCajaDiarioMnuActionPerformed(evt);
            }
        });
        jMenu2.add(resumenCajaDiarioMnu);

        verificarCajasMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        verificarCajasMnu.setText("Verificar Cajas");
        verificarCajasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarCajasMnuActionPerformed(evt);
            }
        });
        jMenu2.add(verificarCajasMnu);

        informes.add(jMenu2);

        listarRcXdiaMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listarRcXdiaMnu.setText("Listar Recibos x día");
        listarRcXdiaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarRcXdiaMnuActionPerformed(evt);
            }
        });
        informes.add(listarRcXdiaMnu);

        rankingMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rankingMnu.setText("Ranking Deudores");
        rankingMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingMnuActionPerformed(evt);
            }
        });
        informes.add(rankingMnu);

        facturadoPorFamiliaMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        facturadoPorFamiliaMnu.setText("Facturado x Familia");
        facturadoPorFamiliaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturadoPorFamiliaMnuActionPerformed(evt);
            }
        });
        informes.add(facturadoPorFamiliaMnu);

        clientePorVendedorMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        clientePorVendedorMnu.setText("Clientes Por Vendedor");
        clientePorVendedorMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientePorVendedorMnuActionPerformed(evt);
            }
        });
        informes.add(clientePorVendedorMnu);

        jMenu6.setText("Stock");
        jMenu6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        stockProductosActivosMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        stockProductosActivosMnu.setText("Productos Activos");
        stockProductosActivosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockProductosActivosMnuActionPerformed(evt);
            }
        });
        jMenu6.add(stockProductosActivosMnu);

        stockFaltantesMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        stockFaltantesMnu.setText("Productos Faltantes");
        jMenu6.add(stockFaltantesMnu);

        cantidadVentaPeriodoMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cantidadVentaPeriodoMnu.setText("Cant vendidos x período");
        cantidadVentaPeriodoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadVentaPeriodoMnuActionPerformed(evt);
            }
        });
        jMenu6.add(cantidadVentaPeriodoMnu);

        cantVentaStockFamiliaMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cantVentaStockFamiliaMnu.setText("Cantidad Ventas x período x Familia");
        cantVentaStockFamiliaMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantVentaStockFamiliaMnuActionPerformed(evt);
            }
        });
        jMenu6.add(cantVentaStockFamiliaMnu);

        ctaStockMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ctaStockMnu.setText("Cta. Cte. Stock");
        ctaStockMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctaStockMnuActionPerformed(evt);
            }
        });
        jMenu6.add(ctaStockMnu);

        stockParaComprasMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        stockParaComprasMnu.setText("Stock Para Compras");
        stockParaComprasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockParaComprasMnuActionPerformed(evt);
            }
        });
        jMenu6.add(stockParaComprasMnu);

        informes.add(jMenu6);

        listadosActualizaPrecioMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listadosActualizaPrecioMnu.setText("Listados Para Actualizar Precios");
        listadosActualizaPrecioMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadosActualizaPrecioMnuActionPerformed(evt);
            }
        });
        informes.add(listadosActualizaPrecioMnu);

        listaPreciosMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listaPreciosMnu.setText("Lista de Precios");
        listaPreciosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPreciosMnuActionPerformed(evt);
            }
        });
        informes.add(listaPreciosMnu);

        listaProductosCeroMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        listaProductosCeroMnu.setText("Lista Productos precio Cero");
        listaProductosCeroMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaProductosCeroMnuActionPerformed(evt);
            }
        });
        informes.add(listaProductosCeroMnu);

        saldosClientesMnu.setText("SALDOS CLIENTES PARA COMPENSAR");
        saldosClientesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldosClientesMnuActionPerformed(evt);
            }
        });
        informes.add(saldosClientesMnu);

        ventasCigarrillosMnu.setText("VENTAS CIGARRILLOS");
        ventasCigarrillosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasCigarrillosMnuActionPerformed(evt);
            }
        });
        informes.add(ventasCigarrillosMnu);

        seguimientoVentaCigarrilloMnu.setText("SEGUIMIENTO VENTA CIGARRILLO");
        seguimientoVentaCigarrilloMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seguimientoVentaCigarrilloMnuActionPerformed(evt);
            }
        });
        informes.add(seguimientoVentaCigarrilloMnu);

        mainMenuFrame.add(informes);

        ventas.setText("Compras");
        ventas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        abmProveedoresMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        abmProveedoresMnu.setText("Abm Proveedores");
        abmProveedoresMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmProveedoresMnuActionPerformed(evt);
            }
        });
        ventas.add(abmProveedoresMnu);

        abmComprobantesMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        abmComprobantesMnu.setText("Abm Comprobantes");
        abmComprobantesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abmComprobantesMnuActionPerformed(evt);
            }
        });
        ventas.add(abmComprobantesMnu);

        periodosMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        periodosMnu.setText("Periodos");
        periodosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodosMnuActionPerformed(evt);
            }
        });
        ventas.add(periodosMnu);

        jMenu3.setText("Iva Compras");
        jMenu3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        libroIvaComprasMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        libroIvaComprasMnu.setText("Libro Iva Compras");
        libroIvaComprasMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libroIvaComprasMnuActionPerformed(evt);
            }
        });
        jMenu3.add(libroIvaComprasMnu);

        ventas.add(jMenu3);

        cuentaCorrienteMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cuentaCorrienteMnu.setText("Cuenta Corriente");
        cuentaCorrienteMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuentaCorrienteMnuActionPerformed(evt);
            }
        });
        ventas.add(cuentaCorrienteMnu);

        pendientesMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pendientesMnu.setText("Comprob. Pendientes de Pago");
        pendientesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendientesMnuActionPerformed(evt);
            }
        });
        ventas.add(pendientesMnu);

        saldosPendientesMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        saldosPendientesMnu.setText("Listado Saldos Pendientes de Pago");
        saldosPendientesMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saldosPendientesMnuActionPerformed(evt);
            }
        });
        ventas.add(saldosPendientesMnu);

        abonadosPorPeriodoMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        abonadosPorPeriodoMnu.setText("Comprob. Abonados x Período");
        abonadosPorPeriodoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abonadosPorPeriodoMnuActionPerformed(evt);
            }
        });
        ventas.add(abonadosPorPeriodoMnu);

        pagosMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pagosMnu.setText("Pagos");
        pagosMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagosMnuActionPerformed(evt);
            }
        });
        ventas.add(pagosMnu);

        seguimientoMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        seguimientoMnu.setText("Seguimiento de Procesos");
        seguimientoMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seguimientoMnuActionPerformed(evt);
            }
        });
        ventas.add(seguimientoMnu);

        mainMenuFrame.add(ventas);

        salirMnu.setText("Salir");
        salirMnu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        salirMnu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMnuMouseClicked(evt);
            }
        });
        mainMenuFrame.add(salirMnu);

        jMenu4.setText("?");

        versionMnu.setText("Version");
        versionMnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                versionMnuActionPerformed(evt);
            }
        });
        jMenu4.add(versionMnu);

        mainMenuFrame.add(jMenu4);

        setJMenuBar(mainMenuFrame);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(facturarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(facturaBtn)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consultarPrecioBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(notaCreditoBtn)
                                .addGap(18, 18, 18)
                                .addComponent(cobrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(goBtn))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recBtn)
                            .addComponent(salirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recBtn)
                    .addComponent(goBtn))
                .addGap(222, 222, 222)
                .addComponent(consultarPrecioBtn)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(facturarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(facturaBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cobrarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salirBtn)
                    .addComponent(notaCreditoBtn))
                .addGap(37, 37, 37))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuActionPerformed
        salir();
    }//GEN-LAST:event_salirMenuActionPerformed

    private void clientesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesMenuActionPerformed
        AbmClienteFrame abmCliente = new AbmClienteFrame(null, null, null, null, null, null);
        abmCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_clientesMenuActionPerformed

    private void productosMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosMenuActionPerformed
        AbmProductoFrame productoFrame = new AbmProductoFrame(filtro);
        productoFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_productosMenuActionPerformed

    private void salirMnuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMnuMouseClicked
        salir();
    }//GEN-LAST:event_salirMnuMouseClicked

    private void rubroMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rubroMenuActionPerformed
        if (habilitado()) {
            AbmRubroFrame abmRubro = new AbmRubroFrame();
            abmRubro.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_rubroMenuActionPerformed

    private void subRubroMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subRubroMenuActionPerformed
        if (habilitado()) {
            AbmSubRubroFrame abmSubRubro = new AbmSubRubroFrame();
            abmSubRubro.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_subRubroMenuActionPerformed

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        salir();
    }//GEN-LAST:event_salirBtnActionPerformed

    private void facturarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturarBtnActionPerformed
        PedidoFrame pf = new PedidoFrame();
        pf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_facturarBtnActionPerformed

    private void configMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configMenuActionPerformed
        if (habilitado()) {
            configuracion();
        }
    }//GEN-LAST:event_configMenuActionPerformed

    private void cobrarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobrarBtnActionPerformed
        VerCuentaCorrienteClienteFrame cf = new VerCuentaCorrienteClienteFrame(null, null, null, false, 0);
        cf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cobrarBtnActionPerformed

    private void ventasPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasPorClienteActionPerformed
        if (habilitado()) {
            VentasXClienteFrame vxcf = new VentasXClienteFrame();
            vxcf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_ventasPorClienteActionPerformed

    private void informeProductosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informeProductosMnuActionPerformed
        VerProductosFrame vpf = new VerProductosFrame();
        vpf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_informeProductosMnuActionPerformed

    private void facturaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaBtnActionPerformed
        FacturarFrame ff = new FacturarFrame();
        ff.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_facturaBtnActionPerformed

    private void notaCreditoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notaCreditoBtnActionPerformed
        NotaCreditoSelectFrame ncf = new NotaCreditoSelectFrame();
        ncf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_notaCreditoBtnActionPerformed

    private void versionMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_versionMnuActionPerformed
        VersionFrame vf = new VersionFrame();
        vf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_versionMnuActionPerformed

    private void ivaVentasMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ivaVentasMenuActionPerformed
        ListaFacturas vivpp = new ListaFacturas();
        vivpp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ivaVentasMenuActionPerformed

    private void reimpresionPedidoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reimpresionPedidoMnuActionPerformed
        ReimpresionDocumentoPorClienteFrame rpf = new ReimpresionDocumentoPorClienteFrame(null);
        rpf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reimpresionPedidoMnuActionPerformed

    private void cierreDiarioMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cierreDiarioMnuActionPerformed
        if (habilitado()) {
//            backup();
            cerrarCaja();
        }
    }//GEN-LAST:event_cierreDiarioMnuActionPerformed

    private void modificarProductoPorPrecioMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarProductoPorPrecioMnuActionPerformed
        if (habilitado()) {
            modificarPorPrecio();
        }
    }//GEN-LAST:event_modificarProductoPorPrecioMnuActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed

    }//GEN-LAST:event_jMenu5ActionPerformed

    private void actualizaPrecioMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizaPrecioMenuActionPerformed
        VerReservorioFrame vrf = new VerReservorioFrame();
        vrf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_actualizaPrecioMenuActionPerformed

    private void rankingMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingMnuActionPerformed
        RankingDeudoresFrame rdf = new RankingDeudoresFrame();
        rdf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rankingMnuActionPerformed

    private void consultarPrecioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarPrecioBtnActionPerformed
        ConsultarPrecioFrame cpf = new ConsultarPrecioFrame();
        cpf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_consultarPrecioBtnActionPerformed

    private void facturadoPorFamiliaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturadoPorFamiliaMnuActionPerformed
        if (habilitado()) {
            rankingFamilias();
        }
    }//GEN-LAST:event_facturadoPorFamiliaMnuActionPerformed

    private void vendedorMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendedorMnuActionPerformed
        AbmVendedorFrame avf = new AbmVendedorFrame();
        avf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vendedorMnuActionPerformed

    private void usuariosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosMnuActionPerformed
        if (habilitado()) {
            AbmUsuariosFrame auf = new AbmUsuariosFrame();
            auf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_usuariosMnuActionPerformed

    private void relacionVendeListaPorcMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relacionVendeListaPorcMnuActionPerformed
        if (habilitado()) {
            RelacionVendeListaPorceFrame rvlpf = new RelacionVendeListaPorceFrame();
            rvlpf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_relacionVendeListaPorcMnuActionPerformed

    private void clientePorVendedorMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientePorVendedorMnuActionPerformed
        if (habilitado()) {
            clientePorVendedor();
        }
    }//GEN-LAST:event_clientePorVendedorMnuActionPerformed

    private void abmProveedoresMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmProveedoresMnuActionPerformed
        if (habilitado()) {
            AbmProveedoresFrame apf = new AbmProveedoresFrame();
            apf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_abmProveedoresMnuActionPerformed

    private void abmComprobantesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abmComprobantesMnuActionPerformed
        if (habilitado()) {
            Date fd = new Date();
            Date fa = new Date();
            Integer row = -1;
            AbmComprobantesCompraFrame accf = new AbmComprobantesCompraFrame(fd, fa, row);
            accf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_abmComprobantesMnuActionPerformed

    private void periodosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodosMnuActionPerformed
        if (habilitado()) {
            AbmPeriodosFrame apf = new AbmPeriodosFrame();
            apf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_periodosMnuActionPerformed

    private void cuentaCorrienteMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuentaCorrienteMnuActionPerformed
        if (habilitado()) {
            CuentaCorrienteProveedorFrame ccpf = new CuentaCorrienteProveedorFrame(null, 0);
            ccpf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_cuentaCorrienteMnuActionPerformed

    private void libroIvaComprasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libroIvaComprasMnuActionPerformed
        if (habilitado()) {
            LibroIvaComprasFrame licf = new LibroIvaComprasFrame();
            licf.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_libroIvaComprasMnuActionPerformed

    private void listarRcXdiaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarRcXdiaMnuActionPerformed
        if (habilitado()) {
            listarRecibos();
        }
    }//GEN-LAST:event_listarRcXdiaMnuActionPerformed

    private void pendientesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendientesMnuActionPerformed
        if (habilitado()) {
            pendientes();
        }
    }//GEN-LAST:event_pendientesMnuActionPerformed

    private void abonadosPorPeriodoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abonadosPorPeriodoMnuActionPerformed
        if (habilitado()) {
            abonados();
        }
    }//GEN-LAST:event_abonadosPorPeriodoMnuActionPerformed

    private void pagosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagosMnuActionPerformed
        if (habilitado()) {
            pagos();
        }
    }//GEN-LAST:event_pagosMnuActionPerformed

    private void saldosPendientesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldosPendientesMnuActionPerformed
        if (habilitado()) {
            listadoPendientes();
        }
    }//GEN-LAST:event_saldosPendientesMnuActionPerformed

    private void stockMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockMnuActionPerformed
        stock();
    }//GEN-LAST:event_stockMnuActionPerformed

    private void backupMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupMnuActionPerformed
        backup();
    }//GEN-LAST:event_backupMnuActionPerformed

    private void stockProductosActivosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockProductosActivosMnuActionPerformed
        StockProductosActivosFrame spaf = new StockProductosActivosFrame();
        spaf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_stockProductosActivosMnuActionPerformed

    private void cantidadVentaPeriodoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadVentaPeriodoMnuActionPerformed
        CantidadVentaPeriodoFrame cvpf = new CantidadVentaPeriodoFrame();
        cvpf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cantidadVentaPeriodoMnuActionPerformed

    private void ctaStockMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctaStockMnuActionPerformed
        habilitar();
        if (usuario != null) {
            CuentaCorrienteStockFrame ccsf = new CuentaCorrienteStockFrame(null, null, null, null, null);
            ccsf.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_ctaStockMnuActionPerformed

    private void seguimientoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seguimientoMnuActionPerformed
        seguimiento();
    }//GEN-LAST:event_seguimientoMnuActionPerformed

    private void productosInactivosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosInactivosMnuActionPerformed
        if (habilitado()) {
            inactivos();
        }
    }//GEN-LAST:event_productosInactivosMnuActionPerformed

    private void resumenCajaDiarioMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resumenCajaDiarioMnuActionPerformed
        if (habilitado()) {
            resumenCaja();
        }
    }//GEN-LAST:event_resumenCajaDiarioMnuActionPerformed

    private void stockParaComprasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockParaComprasMnuActionPerformed
        if (habilitado()) {
            paraCompras();
        }
    }//GEN-LAST:event_stockParaComprasMnuActionPerformed

    private void productosIvaCeroMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosIvaCeroMnuActionPerformed
        productosIvaCero();
    }//GEN-LAST:event_productosIvaCeroMnuActionPerformed

    private void verificarCajasMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarCajasMnuActionPerformed
        if (habilitado()) {
            verificarCajas();
        }
    }//GEN-LAST:event_verificarCajasMnuActionPerformed

    private void cantVentaStockFamiliaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantVentaStockFamiliaMnuActionPerformed
        informeStockFamiliaPeriodo();
    }//GEN-LAST:event_cantVentaStockFamiliaMnuActionPerformed

    private void clientesInactivosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesInactivosMnuActionPerformed
        clientesInactivos();
    }//GEN-LAST:event_clientesInactivosMnuActionPerformed

    private void nuevoProductoMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoProductoMnuActionPerformed
        AbmProductoV2Frame npf1 = new AbmProductoV2Frame(null);
        npf1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nuevoProductoMnuActionPerformed

    private void listadosActualizaPrecioMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadosActualizaPrecioMnuActionPerformed
        ListadoActualizarPreciosFrame lapf = new ListadoActualizarPreciosFrame();
        lapf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_listadosActualizaPrecioMnuActionPerformed

    private void testCBMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testCBMnuActionPerformed
        A000tstprodxcbarrasFrame atxcbf = new A000tstprodxcbarrasFrame();
        atxcbf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_testCBMnuActionPerformed

    private void regenerarPdfMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regenerarPdfMnuActionPerformed
        regenerarPd();
    }//GEN-LAST:event_regenerarPdfMnuActionPerformed

    private void regenerarPresupPdfMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regenerarPresupPdfMnuActionPerformed
        regenerarPresupPdf();
    }//GEN-LAST:event_regenerarPresupPdfMnuActionPerformed

    private void listaPreciosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPreciosMnuActionPerformed
        listaPrecios();
    }//GEN-LAST:event_listaPreciosMnuActionPerformed

    private void listaProductosCeroMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaProductosCeroMnuActionPerformed
        ProductosEnCeroFrame prcf = new ProductosEnCeroFrame();
        prcf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_listaProductosCeroMnuActionPerformed

    private void recBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recBtnActionPerformed
        rec();
    }//GEN-LAST:event_recBtnActionPerformed

    private void marcarProductosParaGondolaMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marcarProductosParaGondolaMnuActionPerformed
        marcarParaGondola();
    }//GEN-LAST:event_marcarProductosParaGondolaMnuActionPerformed

    private void saldosClientesMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldosClientesMnuActionPerformed
        saldosClientes();
    }//GEN-LAST:event_saldosClientesMnuActionPerformed

    private void productoByRubroSubMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoByRubroSubMnuActionPerformed
        prodByRuSub();
    }//GEN-LAST:event_productoByRubroSubMnuActionPerformed

    private void goBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBtnActionPerformed
//        List<Cliente> clientes = null;
//        Integer can=1;
//        Integer 
//        try {
//            clientes = new ClienteService().getAllClientes();
//            System.out.println(clientes.size());
//        } catch (Exception ex) {
//            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        do{
//            
//        }while (can > 0);
//        
//        clientes = new ClienteService().getAllClientesActivos();
    }//GEN-LAST:event_goBtnActionPerformed

    private void ventasCigarrillosMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasCigarrillosMnuActionPerformed
        ventasCigarrillos();
    }//GEN-LAST:event_ventasCigarrillosMnuActionPerformed

    private void seguimientoVentaCigarrilloMnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seguimientoVentaCigarrilloMnuActionPerformed
        seguimientoVentaCigarrillo();
    }//GEN-LAST:event_seguimientoVentaCigarrilloMnuActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abmComprobantesMnu;
    private javax.swing.JMenuItem abmProveedoresMnu;
    private javax.swing.JMenuItem abonadosPorPeriodoMnu;
    private javax.swing.JMenuItem actualizaPrecioMenu;
    private javax.swing.JMenu archivo;
    private javax.swing.JMenuItem backupMnu;
    private javax.swing.JMenuItem cantVentaStockFamiliaMnu;
    private javax.swing.JMenuItem cantidadVentaPeriodoMnu;
    private javax.swing.JMenuItem cierreDiarioMnu;
    private javax.swing.JMenuItem clientePorVendedorMnu;
    private javax.swing.JMenuItem clientesInactivosMnu;
    private javax.swing.JMenuItem clientesMenu;
    private javax.swing.JButton cobrarBtn;
    private javax.swing.JMenuItem configMenu;
    private javax.swing.JButton consultarPrecioBtn;
    private javax.swing.JMenuItem ctaStockMnu;
    private javax.swing.JMenuItem cuentaCorrienteMnu;
    private javax.swing.JButton facturaBtn;
    private javax.swing.JMenuItem facturadoPorFamiliaMnu;
    private javax.swing.JButton facturarBtn;
    private javax.swing.JButton goBtn;
    private javax.swing.JMenu herramientas;
    private javax.swing.JMenuItem informeProductosMnu;
    private javax.swing.JMenu informes;
    private javax.swing.JMenuItem ivaVentasMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem libroIvaComprasMnu;
    private javax.swing.JMenuItem listaPreciosMnu;
    private javax.swing.JMenuItem listaProductosCeroMnu;
    private javax.swing.JMenuItem listadosActualizaPrecioMnu;
    private javax.swing.JMenuItem listarRcXdiaMnu;
    private javax.swing.JMenuBar mainMenuFrame;
    private javax.swing.JMenuItem marcarProductosParaGondolaMnu;
    private javax.swing.JMenuItem modificarProductoPorPrecioMnu;
    private javax.swing.JButton notaCreditoBtn;
    private javax.swing.JMenuItem nuevoProductoMnu;
    private javax.swing.JMenuItem pagosMnu;
    private javax.swing.JMenuItem pendientesMnu;
    private javax.swing.JMenuItem periodosMnu;
    private javax.swing.JMenuItem productoByRubroSubMnu;
    private javax.swing.JMenuItem productosInactivosMnu;
    private javax.swing.JMenuItem productosIvaCeroMnu;
    private javax.swing.JMenuItem productosMenu;
    private javax.swing.JMenuItem rankingMnu;
    private javax.swing.JButton recBtn;
    private javax.swing.JMenuItem regenerarPdfMnu;
    private javax.swing.JMenuItem regenerarPresupPdfMnu;
    private javax.swing.JMenuItem reimpresionPedidoMnu;
    private javax.swing.JMenuItem relacionVendeListaPorcMnu;
    private javax.swing.JMenuItem resumenCajaDiarioMnu;
    private javax.swing.JMenuItem rubroMenu;
    private javax.swing.JMenuItem saldosClientesMnu;
    private javax.swing.JMenuItem saldosPendientesMnu;
    private javax.swing.JButton salirBtn;
    private javax.swing.JMenuItem salirMenu;
    private javax.swing.JMenu salirMnu;
    private javax.swing.JMenuItem seguimientoMnu;
    private javax.swing.JMenuItem seguimientoVentaCigarrilloMnu;
    private javax.swing.JMenuItem stockFaltantesMnu;
    private javax.swing.JMenuItem stockMnu;
    private javax.swing.JMenuItem stockParaComprasMnu;
    private javax.swing.JMenuItem stockProductosActivosMnu;
    private javax.swing.JMenuItem subRubroMenu;
    private javax.swing.JMenuItem testCBMnu;
    private javax.swing.JMenuItem usuariosMnu;
    private javax.swing.JMenuItem vendedorMnu;
    private javax.swing.JMenu ventas;
    private javax.swing.JMenuItem ventasCigarrillosMnu;
    private javax.swing.JMenuItem ventasPorCliente;
    private javax.swing.JMenuItem verificarCajasMnu;
    private javax.swing.JMenuItem versionMnu;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void seleccionarArchivoImportarProductos() {
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if (archivo != null) {
            if (LectorDeExcel.validarExtension(archivo)) {
                ImportarProductoFrame ipf = new ImportarProductoFrame(archivo);
                ipf.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "El formato elegido no está soportado.",
                        "Atencion",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void seleccionarArchivoImportarClientes() {
        JFileChooser selector = new JFileChooser();
        selector.showOpenDialog(this);
        File archivo = selector.getSelectedFile();
        if (archivo != null) {
            if (LectorDeExcel.validarExtension(archivo)) {
                ImportarClienteFrame icf = new ImportarClienteFrame(archivo);
                icf.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "El formato elegido no está soportado.",
                        "Atencion",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void salir() {
        int escape = JOptionPane.showConfirmDialog(null, "CONFIRME SALIR DEL SISTEMA", "Atención - salir de SISTEMA", JOptionPane.YES_NO_OPTION);
        // 0 = si; 1 = no
        if (escape == 0) {
            System.exit(0);
        }
    }

    private void modificarPorPrecio() {
        ModificarPrecioProductoFrame mppf = new ModificarPrecioProductoFrame(null);
        mppf.setVisible(true);
        this.dispose();
    }

    private void configuracion() {
        ConfiguracionFrame cf = new ConfiguracionFrame();
        cf.setVisible(true);
        this.dispose();
    }

    private void cerrarCaja() {
        CierreCajaDiarioFrame ccdf = new CierreCajaDiarioFrame(1);
        ccdf.setVisible(true);
        this.dispose();
    }

    private void rankingFamilias() {
        ListarPorFamiliaProductosFrame lpfpf = new ListarPorFamiliaProductosFrame();
        lpfpf.setVisible(true);
        this.dispose();
    }

    private void clientePorVendedor() {
        ListarClientePorVendedorFrame lcpvf = new ListarClientePorVendedorFrame(null);
        lcpvf.setVisible(true);
        this.dispose();
    }

    private void listarRecibos() {
        ListarRecibosFrame lrf = new ListarRecibosFrame();
        lrf.setVisible(true);
        this.dispose();
    }

    private void pendientes() {
        ComprobantesPendientesFrame cpf = new ComprobantesPendientesFrame(0);
        cpf.setVisible(true);
        this.dispose();
    }

    private void abonados() {
        VerFcAbonadasPorPeriodoFrame vfappf = new VerFcAbonadasPorPeriodoFrame();
        vfappf.setVisible(true);
        this.dispose();
    }

    private void pagos() {
        PagosFrame pf = new PagosFrame();
        pf.setVisible(true);
        this.dispose();
    }

    private void listadoPendientes() {
        VerSaldosPendientesProveedoresFrame vsppf = new VerSaldosPendientesProveedoresFrame();
        vsppf.setVisible(true);
        this.dispose();
    }

    private void stock() {
        if (habilitado()) {
            AbmStockFrame asf = new AbmStockFrame(null, "", false);
            asf.setVisible(true);
            this.dispose();
        }
    }

    private void backup() {

    }

    private boolean habilitado() {
        FileReader fr = null;
        try {
            fr = new FileReader("c:/ventas/permisos.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        BufferedReader br = new BufferedReader(fr);
        String acceso = "";
        try {
            acceso = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (acceso.equals("1")) {
            return true;
        }
        habilitar();
        return usuario != null;
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
                if (!isNumeric(field.getText())) {
                    JOptionPane.showMessageDialog(this, "DEBE SER UN NUMERO");
                    usuario = null;
                    break;
                }
                int cod = Integer.valueOf(field.getText());
                try {
                    usuario = new UsuarioService().getUsuarioByCodigo(cod);
                } catch (Exception ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
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
                                if (!isNumeric(new String(field2.getPassword()))) {
                                    JOptionPane.showMessageDialog(this, "DEBE SER UN NUMERO");
                                    usuario = null;
                                    break;
                                }
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

//    private void mario() {
//        AbTest m = new AbTest();
//        m.setVisible(true);
//        this.dispose();
//    }
    private void seguimiento() {
        SeguimientoProcesosCompraFrame spcf = new SeguimientoProcesosCompraFrame();
        spcf.setVisible(true);
        this.dispose();
    }

    private void inactivos() {
        ProductosInactivosFrame pif = new ProductosInactivosFrame();
        pif.setVisible(true);
        this.dispose();
    }

//    private boolean habi2() {
//        return true;
//    }
//    private void prodCnDto() {
//        ProductosConDtoFrame pcdf = new ProductosConDtoFrame();
//        pcdf.setVisible(true);
//        this.dispose();
//    }
    private void resumenCaja() {
        ResumenCajaDiarioFrame rcdf = new ResumenCajaDiarioFrame();
        rcdf.setVisible(true);
        this.dispose();
    }

    private void paraCompras() {
        InformeStockComprasFrame iscf = new InformeStockComprasFrame();
        iscf.setVisible(true);
        this.dispose();
    }

    private void clientesInactivos() {
        AbmClientesInactivosFrame acif = new AbmClientesInactivosFrame(null);
        acif.setVisible(true);
        this.dispose();
    }

    private void productosIvaCero() {
        ProductosIvaCeroFrame picf = new ProductosIvaCeroFrame();
        picf.setVisible(true);
        this.dispose();
    }

    private void verificarCajas() {
        VerificarCajasFrame vcf = new VerificarCajasFrame(null, null, null);
        vcf.setVisible(true);
        this.dispose();
    }

    private boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    private void informeStockFamiliaPeriodo() {

    }

    private void regenerarPd() {
        RegenerarPdfFrame rpf = new RegenerarPdfFrame();
        rpf.setVisible(true);
        this.dispose();
    }

    private void regenerarPresupPdf() {
        RegenerarPresupPdfFrame rpf = new RegenerarPresupPdfFrame();
        rpf.setVisible(true);
        this.dispose();
    }

    private void listaPrecios() {
        ListaPreciosFrame lpf = new ListaPreciosFrame();
        lpf.setVisible(true);
        this.dispose();
    }

    private void rec() {
        List<CtaCteCliente> ctaCte = null;
        Date fecha = new Date();
        try {
            fecha = sdf.parse("15/09/2022");
        } catch (ParseException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        try {
            ctaCte = new CtaCteClienteService().getCtaCteClienteByFecha(fecha);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (CtaCteCliente c : ctaCte) {
            try {
                Recibo re = new ReciboService().getReciboById(c.getRecibo().getId());
                re.setVisto(1);
                new ReciboService().updateRecibo(re);
            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        List<Inventory> cuenta;
        try {
            cuenta = new InventoryService().getCtaCtePorFecha(fecha);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        for (Inventory in : cuenta) {
            try {
                Payment re = new PaymentService().getPaymentById(in.getRecibo().getId());
                re.setVisto(1);
                new PaymentService().updatePayment(re);
            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JOptionPane.showMessageDialog(this, "LISTO");
        System.exit(0);
    }

    private void marcarParaGondola() {
        MarcarProductosParaGondolaFrame mppgf = new MarcarProductosParaGondolaFrame();
        mppgf.setVisible(true);
        this.dispose();
    }

    private void saldosClientes() {
        A0000Test0 mppgf = new A0000Test0();
        mppgf.setVisible(true);
        this.dispose();
    }

    private void prodByRuSub() {
        ProductosByRubroSubRubroFrame pbrsf = new ProductosByRubroSubRubroFrame();
        pbrsf.setVisible(true);
        this.dispose();
    }

    private void ventasCigarrillos() {
        VentaCigarrillosEntreFechasFrame vceff = new VentaCigarrillosEntreFechasFrame();
        vceff.setVisible(true);
        this.dispose();
    }

    private void seguimientoVentaCigarrillo() {
        SeguimientoVentaCigarrilloFrame svcf = new SeguimientoVentaCigarrilloFrame();
        svcf.setVisible(true);
        this.dispose();
    }
}
