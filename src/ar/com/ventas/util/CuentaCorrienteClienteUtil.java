/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.util;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.CtaCteCliente;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.Payment;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.services.ConfiguracionService;
import ar.com.ventas.services.PaymentService;
import ar.com.ventas.services.RoutinesService;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author argia
 */
public class CuentaCorrienteClienteUtil {
    public Integer ajusteSaldoCliente1(Double imp_py, Double imp_re, Double sal2_cu,
            Double sal2_cli, Customer cus, Cliente cli, String tx_py, String tx_re){
        
        Routines rou;
        try {
            rou = new RoutinesService().getFacturas(1L);
        } catch (Exception ex) {
//            Logger.getLogger(CuentaCorrienteClienteUtil.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR 32");
            return 1; // error leyendo configuracion salmon
        }
        int nr = rou.getNumeroRecibo();
        nr += 1;
        rou.setNumeroRecibo(nr);
        Configuracion cfg;
        try {
            cfg = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
//            Logger.getLogger(VerCuentaCorrienteClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR 43");
            return 2; // error leyendo configuracion azul
        }
        int nrc = cfg.getNumeroRecibo();
        nrc += 1;
        cfg.setNumeroRecibo(nrc);

        Payment py = new Payment();
        py.setCliente(cus);
        py.setFecha(new Date());
        py.setImporte(imp_py);
        py.setNumero(nr);
        py.setVisto(0);

        Recibo rec = new Recibo();
        rec.setCliente(cli);
        rec.setFecha(new Date());
        rec.setImporte(imp_re);
        rec.setNumero(nrc);
        rec.setVisto(0);

        Inventory inv = new Inventory();
        inv.setCliente(cus);
        inv.setDebe(imp_py);
        inv.setFecha(new Date());
        inv.setHaber(0.0);
        inv.setRecibo(py);
        inv.setSaldo(sal2_cu);
        inv.setTipo(tx_py);

        CtaCteCliente ccc = new CtaCteCliente();
        ccc.setCliente(cli);
        ccc.setDebe(0.0);
        ccc.setFecha(new Date());
        ccc.setHaber(imp_re);
        ccc.setRecibo(rec);
        ccc.setSaldo(sal2_cli);
        ccc.setTipo(tx_re);

        cus.setSaldo(sal2_cu);

        cli.setSaldo(sal2_cli);

        try {
            new PaymentService().savePaymentParaAjuste(rou, py, cus, inv, cfg, rec, ccc, cli);
        } catch (Exception ex) {
//            Logger.getLogger(VerCuentaCorrienteClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR 90");
            return 3; // error aplicando el ajuste
        }

        return 0; //esta bien
    }
    
    public Integer ajusteSaldoCliente2(Double imp_py, Double imp_re, Double sal2_cu,
            Double sal2_cli, Customer cus, Cliente cli, String tx_py, String tx_re){
        
        Routines rou;
        try {
            rou = new RoutinesService().getFacturas(1L);
        } catch (Exception ex) {
//            Logger.getLogger(CuentaCorrienteClienteUtil.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR 105");
            return 1; // error leyendo configuracion salmon
        }
        int nr = rou.getNumeroRecibo();
        nr += 1;
        rou.setNumeroRecibo(nr);
        Configuracion cfg;
        try {
            cfg = new ConfiguracionService().getFacturas(1L);
        } catch (Exception ex) {
//            Logger.getLogger(VerCuentaCorrienteClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR 116");
            return 2; // error leyendo configuracion azul
        }
        int nrc = cfg.getNumeroRecibo();
        nrc += 1;
        cfg.setNumeroRecibo(nrc);

        Payment py = new Payment();
        py.setCliente(cus);
        py.setFecha(new Date());
        py.setImporte(imp_py);
        py.setNumero(nr);
        py.setVisto(0);

        Recibo rec = new Recibo();
        rec.setCliente(cli);
        rec.setFecha(new Date());
        rec.setImporte(imp_re);
        rec.setNumero(nrc);
        rec.setVisto(0);

        Inventory inv = new Inventory();
        inv.setCliente(cus);
        inv.setDebe(0.00);
        inv.setFecha(new Date());
        inv.setHaber(imp_py);
        inv.setRecibo(py);
        inv.setSaldo(sal2_cu);
        inv.setTipo(tx_py);

        CtaCteCliente ccc = new CtaCteCliente();
        ccc.setCliente(cli);
        ccc.setDebe(imp_re);
        ccc.setFecha(new Date());
        ccc.setHaber(0.00);
        ccc.setRecibo(rec);
        ccc.setSaldo(sal2_cli);
        ccc.setTipo(tx_re);

        cus.setSaldo(sal2_cu);

        cli.setSaldo(sal2_cli);

        try {
            new PaymentService().savePaymentParaAjuste(rou, py, cus, inv, cfg, rec, ccc, cli);
        } catch (Exception ex) {
//            Logger.getLogger(VerCuentaCorrienteClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR 163");
            return 3; // error aplicando el ajuste
        }

        return 0; //esta bien
    }
}
