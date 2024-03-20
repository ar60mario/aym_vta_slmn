/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.ClienteBO;
import ar.com.ventas.bo.ConfiguracionBO;
import ar.com.ventas.bo.CtaCteClienteBO;
import ar.com.ventas.bo.CustomerBO;
import ar.com.ventas.bo.InventoryBO;
import ar.com.ventas.bo.PaymentBO;
import ar.com.ventas.bo.ReciboBO;
import ar.com.ventas.bo.RoutinesBO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.CtaCteCliente;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.Payment;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.util.HibernateUtil;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class PaymentService {

    public Payment savePayment(Payment payment) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Payment pay = null;
        try {
            pay = new PaymentBO().savePayment(payment);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return pay;
    }

    public void savePaymentParaAjuste(Routines rou, Payment payment, Customer cus, Inventory inv,
            Configuracion cfg, Recibo rec, CtaCteCliente ccc, Cliente cliente) throws Exception {
        Payment pay;
        Recibo recibo;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Session session2 = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx2 = session2.beginTransaction();
        try {
            pay = new PaymentBO().savePayment(payment);
            inv.setRecibo(pay);
            new InventoryBO().saveInventory(inv);
            new RoutinesBO().updateFacturas(rou);
            new CustomerBO().updateCustomer(cus);
            recibo = new ReciboBO().saveRecibo(rec);
            ccc.setRecibo(recibo);
            new CtaCteClienteBO().saveCtaCteCliente(ccc);
            new ClienteBO().updateCliente(cliente);
            new ConfiguracionBO().updateConfiguracion(cfg);
            tx.commit();
            tx2.commit();
        } catch (Exception ex) {
            tx.rollback();
            tx2.rollback();
            throw new Exception(ex);
        }
    }

    public Payment updatePayment(Payment payment) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Payment pay = null;
        try {
            pay = new PaymentBO().updatePayment(payment);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return pay;
    }

    public Payment getPaymentById(Long id) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Payment payment = null;
        try {
            payment = new PaymentBO().getPaymentById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return payment;
    }

    public List<Payment> getPaymentByDia(Date fecha) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Payment> recibis = null;
        try {
            recibis = new PaymentBO().getPaymentByDia(fecha);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibis;
    }
}
