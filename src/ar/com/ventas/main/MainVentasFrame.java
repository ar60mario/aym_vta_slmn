/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.main;

import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.entities.Stores;
import ar.com.ventas.frame.CierreCajaDiarioFrame;
import ar.com.ventas.services.ActivityService;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.CustomerService;
import ar.com.ventas.services.IvaVentasService;
import ar.com.ventas.services.RoutinesService;
import ar.com.ventas.services.StoreService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mario
 */
public class MainVentasFrame extends javax.swing.JFrame {

    private Double subTotalIngresos = 0.00;
    private Double subtotalEgresos = 0.00;
    private Date fecha;
    private Date fechaA;
    private Double deudoresAnteriorCf = 0.00;
    private Double deudoresAnteriorOf = 0.00;
    private Double deudoresHoyOf = 0.0;
    private Double deudoresHoyCf = 0.0;
    private Double totalFacturado = 0.00;
    private Double totalFacOf = 0.0;
    private Double diferencia = 0.00;
    private Double vales = 0.00;
    private Double efectivo = 0.00;
    private Double inicial = 0.00;
    private Double saldoCliente = 0.00;
    private Double saldoCli = 0.00;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form MainVentasFrame
     */
    public MainVentasFrame() {
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        initComponents();
        this.setLocationRelativeTo(null);
        siBtn.setVisible(false);
        ingresarBtn.setVisible(false);
        verificar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        siBtn = new javax.swing.JButton();
        mensajeTxt = new javax.swing.JLabel();
        ingresarBtn = new javax.swing.JButton();
        mensaje2Txt = new javax.swing.JLabel();
        salirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        siBtn.setText("Continuar");
        siBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siBtnActionPerformed(evt);
            }
        });

        mensajeTxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mensajeTxt.setText("DEBE CERRAR CAJA ANTERIOR!");

        ingresarBtn.setText("Ingresar a Sistema");
        ingresarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarBtnActionPerformed(evt);
            }
        });

        mensaje2Txt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mensaje2Txt.setText("jLabel1");

        salirBtn.setText("Salir");
        salirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mensajeTxt)
                    .addComponent(ingresarBtn)
                    .addComponent(siBtn)
                    .addComponent(mensaje2Txt))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salirBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mensajeTxt)
                .addGap(33, 33, 33)
                .addComponent(mensaje2Txt)
                .addGap(28, 28, 28)
                .addComponent(siBtn)
                .addGap(18, 18, 18)
                .addComponent(ingresarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(salirBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siBtnActionPerformed
        CierreCajaDiarioFrame ccdf = new CierreCajaDiarioFrame(0);
        ccdf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_siBtnActionPerformed

    private void ingresarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBtnActionPerformed
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ingresarBtnActionPerformed

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MainVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainVentasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainVentasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ingresarBtn;
    private javax.swing.JLabel mensaje2Txt;
    private javax.swing.JLabel mensajeTxt;
    private javax.swing.JButton salirBtn;
    private javax.swing.JButton siBtn;
    // End of variables declaration//GEN-END:variables

    private void verificar() {
        fecha = new Date();
        Long cfg = 1L;
        Configuracion config;
        try {
            config = new ConfiguracionService().getFacturas(cfg);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
            return;
        }
        if (config.getUltimaFechaSistema() != null) {
            Date fechaSistemaAntes = config.getUltimaFechaSistema();
            String f1 = sdf.format(fecha);
            String f2 = sdf.format(fechaSistemaAntes);
            if (!f1.equals(f2)) {
                Date fechaUltimaCierre = config.getUltimaFechaCierre();
                String f3 = sdf.format(fechaUltimaCierre);
                if (f2.equals(f3)) {
                    mensajeTxt.setText("Sistema Correcto");
                    mensaje2Txt.setText("");
                    ingresarBtn.setVisible(true);
                } else {
                    if (fechaSistemaAntes.before(fechaUltimaCierre)) {
                        mensajeTxt.setText("Sistema Correcto");
                        mensaje2Txt.setText("");
                        ingresarBtn.setVisible(true);
                    } else {
                        getContentPane().setBackground(new java.awt.Color(255, 0, 0));
                        mensajeTxt.setText("Debe cerrar Caja Anterior!!!");
                        mensaje2Txt.setText("Lo hace ahora?");
                        siBtn.setVisible(true);
                    }
                }
            } else {
                mensajeTxt.setText("Sistema Correcto");
                mensaje2Txt.setText("");
                ingresarBtn.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "ERROR EN LAS FECHAS DEL SISTEMA\n"
                    + "INGRESE AL SISTEMA APLIQUE LOS PAGOS SI NECESITA\n"
                    + "Y CIERRE LA CAJA NORMALMENTE DESDE EL MENU");
        }
    }

    private void grabar() {
        Configuracion config = null;
        Routines conf = null;
        try {
            config = new ConfiguracionService().getFacturas(1L);
            conf = new RoutinesService().getFacturas(1L);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date fus = config.getUltimaFechaSistema();
        Date fuc = config.getUltimaFechaCierre();
        config.setUltimaFechaCierre(fus);
        conf.setUltimaFechaCierre(fus);
        fecha = fus;
        fechaA = fuc;
        subTotalIngresos = 0.0;
        subtotalEgresos = 0.0;
        Stores movim = null;
        try {
            movim = new StoreService().getMovimientoCajaByFecha(fuc);
        } catch (Exception ex) {
            Logger.getLogger(CierreCajaDiarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (movim != null) {
            deudoresAnteriorCf = movim.getTotalDeudoresHoyCf();
            subTotalIngresos += deudoresAnteriorCf;
            deudoresAnteriorOf = movim.getTotalDeudoresHoyOf();
            subTotalIngresos += deudoresAnteriorOf;
        }
        List<Activity> facturas = null;
        try {
            facturas = new ActivityService().getFcByFecha(fecha);
        } catch (Exception ex) {
            Logger.getLogger(CierreCajaDiarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        totalFacturado = 0.0;
        if (facturas != null && !facturas.isEmpty()) {
            for (Activity ac : facturas) {
                totalFacturado += ac.getTotal();
            }
            subTotalIngresos += totalFacturado;
        }
        List<IvaVentas> fact = null;
        try {
            fact = new IvaVentasService().getFactByFecha(fecha);
        } catch (Exception ex) {
            Logger.getLogger(CierreCajaDiarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        totalFacOf = 0.0;
        if (fact != null && !fact.isEmpty()) {
            for (IvaVentas fc : fact) {
                totalFacOf += fc.getTotal();
            }
            subTotalIngresos += totalFacOf;
        }
        deudoresHoyOf = 0.0;
        deudoresHoyCf = 0.0;
        List<Cliente> clie = null;
        List<Customer> clientes = null;
        saldoCli = 0.0;
        saldoCliente = 0.0;
        try {
            clie = new ClienteService().getClienteDeudores();
        } catch (Exception ex) {
            Logger.getLogger(CierreCajaDiarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clie != null && !clie.isEmpty()) {
            for (Cliente cli : clie) {
                saldoCli += cli.getSaldo();
            }
            deudoresHoyOf = saldoCli;
        } else {
            deudoresHoyOf = 0.0;
        }
        try {
            clientes = new CustomerService().getCustomersDeudores();
        } catch (Exception ex) {
            Logger.getLogger(CierreCajaDiarioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clientes != null && !clientes.isEmpty()) {
            for (Customer cu : clientes) {
                saldoCliente += cu.getSaldo();
            }
            deudoresHoyCf = saldoCliente;
        } else {
            deudoresHoyCf = 0.0;
        }
        efectivo = 0.00;
        vales = 0.00;
        inicial = 0.00;
        subtotalEgresos = efectivo + vales + saldoCli + saldoCliente + inicial;
        diferencia = subtotalEgresos - subTotalIngresos;
        Stores st = new Stores();
        st.setCajaInicial(inicial);
        st.setCerrado(false);
        st.setDiferencia(diferencia);
        st.setFecha(fecha);
        st.setFechaAnterior(fechaA);
        st.setSaldoDeudorAnteriorCf(deudoresAnteriorCf);
        st.setSaldoDeudorAnteriorOf(deudoresAnteriorOf);
        st.setSubtotalAbajo(subtotalEgresos);
        st.setSubtotalArriba(subTotalIngresos);
        st.setTotalDeposito(efectivo);
        st.setTotalVales(vales);
        st.setTotalDeudoresHoyCf(deudoresHoyCf);
        st.setTotalDeudoresHoyOf(deudoresHoyOf);
        st.setTotalFacturadoCf(totalFacturado);
        st.setTotalFacturadoOf(totalFacOf);
        try {
            new StoreService().saveMovimientoCaja(st);
            new ConfiguracionService().updateConfiguracion(config);
            new RoutinesService().updateRoutines(conf);
        } catch (Exception ex) {
            Logger.getLogger(MainVentasFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
