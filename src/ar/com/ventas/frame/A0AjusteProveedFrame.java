/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.CtaCteCliente;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Payment;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.services.ActivityRowService;
import ar.com.ventas.services.ActivityService;
import ar.com.ventas.services.CtaCteClienteService;
import ar.com.ventas.services.CustomerService;
import ar.com.ventas.services.InventoryService;
import ar.com.ventas.services.IvaVentasService;
import ar.com.ventas.services.PaymentService;
import ar.com.ventas.services.ReciboService;
import ar.com.ventas.services.RenglonFacturaService;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class A0AjusteProveedFrame extends javax.swing.JFrame {

    /**
     * Creates new form AjusteFrame
     */
    public A0AjusteProveedFrame() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rcBtn = new javax.swing.JButton();
        fcBtn = new javax.swing.JButton();
        salirBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rcBtn.setText("Rc");
        rcBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rcBtnActionPerformed(evt);
            }
        });

        fcBtn.setText("Fc");
        fcBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fcBtnActionPerformed(evt);
            }
        });

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
                    .addComponent(rcBtn)
                    .addComponent(fcBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(335, Short.MAX_VALUE)
                .addComponent(salirBtn)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salirBtn)
                .addGap(23, 23, 23)
                .addComponent(fcBtn)
                .addGap(36, 36, 36)
                .addComponent(rcBtn)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rcBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rcBtnActionPerformed
        Customer cus = null;
        try {
            cus = new CustomerService().getCustomerByCodigo("1061");
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        CtaCteCliente cc1 = null;
        try {
            cc1 = new CtaCteClienteService().getMovimientoById(1782L);
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Recibo rc = null;
        try {
            rc = new ReciboService().getReciboById(880L);
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Payment py1 = new Payment();
        py1.setCliente(cus);
        py1.setFecha(new Date());
        py1.setImporte(rc.getImporte());
        py1.setNumero(rc.getNumero());
        try {
            py1 = new PaymentService().savePayment(py1);
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Inventory inv = new Inventory();
        inv.setCliente(cus);
        inv.setDebe(cc1.getDebe());
        inv.setFactura(null);
        inv.setFecha(cc1.getFecha());
        inv.setHaber(cc1.getHaber());
        inv.setNotaCredito(null);
        inv.setRecibo(py1);
        inv.setSaldo(0.00);
        inv.setTipo("RC");
        try {
            new InventoryService().saveInventory(inv);
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rcBtnActionPerformed

    private void salirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirBtnActionPerformed

    private void fcBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fcBtnActionPerformed
        IvaVentas iv = null;
        try {
            iv = new IvaVentasService().getIvaVentasById(924L);
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Activity ac = new Activity();
        ac.setCae(0L);
        Customer cus = null;
        try {
            cus = new CustomerService().getCustomerByCodigo(iv.getCliente().getCodigo());
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cliente cli = iv.getCliente();
        Double sald = cli.getSaldo();
        sald -= iv.getTotal();
        cli.setSaldo(sald);
        try {
            //new ClienteService().updateCliente(cli);
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        sald = cus.getSaldo();
        sald += iv.getTotal();
        cus.setSaldo(sald);
        try {
            //new CustomerService().updateCustomer(cus);
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ac.setCustomer(cus);
        ac.setDescuentoGlobal(0.0);
        ac.setExento(0.0);
        ac.setFecha(iv.getFecha());
        ac.setFechaCae(iv.getFechaCae());
        ac.setGravado(iv.getGravado());
        ac.setGravadoCigarrillos(0.0);
        ac.setImpuesto(iv.getImpuesto());
        ac.setIva(iv.getIva());
        ac.setLetra(iv.getLetra());
        ac.setNoGravado(0.0);
        ac.setNumeroFactura(iv.getNumeroFactura());
        ac.setNumeroSucursal(1);
        ac.setTotal(iv.getTotal());
        ac.setTextoPieFactura1(iv.getTextoPieFactura1());
        ac.setTextoPieFactura2(iv.getTextoPieFactura2());
        try {
            ac = new ActivityService().saveActivity(ac);
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        Inventory inv = new Inventory();
        inv.setCliente(cus);
        inv.setDebe(0.00);
        inv.setFactura(ac);
        inv.setFecha(ac.getFecha());
        inv.setHaber(ac.getTotal());
        inv.setNotaCredito(null);
        inv.setRecibo(null);
        inv.setSaldo(0.00);
        inv.setTipo("FC");
        try {
            new InventoryService().saveInventory(inv);
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<RenglonFactura> rnc = null;
        try {
            rnc = new RenglonFacturaService().getAllRenglonFacturaFromIvaVentas(iv);
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (RenglonFactura re: rnc) {
            ActivityRow rt = new ActivityRow();
            rt.setActivity(ac);
            rt.setCantidad(re.getCantidad());
            rt.setCodigoProducto(re.getProducto().getCodigo());
            rt.setDescripcion(re.getDescripcion());
            rt.setDescuento(0.0);
            rt.setExento(0.0);
            rt.setGravado(re.getGravado());
            rt.setImpuesto(re.getImpuesto());
            rt.setItemNro(re.getItemNro());
            rt.setIva(re.getIva());
            rt.setNoGravado(0.0);
            rt.setSugerido(re.getSugerido());
            rt.setTotal(re.getTotal());
            try {
                new ActivityRowService().saveRenglon(rt);
            } catch (Exception ex) {
                Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CtaCteCliente ccc = null;
        try {
            ccc = new CtaCteClienteService().getMovimientoByIvaVentas(iv);
        } catch (Exception ex) {
            Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("cta cte id");
        System.out.println(ccc.getId());
        System.out.println("Activity id");
        System.out.println(ac.getId());
        System.out.println("Activity total");
        System.out.println(ac.getTotal());
    }//GEN-LAST:event_fcBtnActionPerformed

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
            java.util.logging.Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(A0AjusteProveedFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new A0AjusteProveedFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fcBtn;
    private javax.swing.JButton rcBtn;
    private javax.swing.JButton salirBtn;
    // End of variables declaration//GEN-END:variables
}
