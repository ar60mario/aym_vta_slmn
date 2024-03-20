/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.CtaCteStockBO;
import ar.com.ventas.entities.CtaCteStock;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Proveedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class CtaCteStockService {
    
//    public CtaCteCliente getUltimoMovimiento(Cliente cli) throws Exception {
//        CtaCteCliente ccc = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            ccc = new CtaCteClienteBO().getUltimoMovimiento(cli);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return ccc;
//    }
//    
    public void saveCtaCteStock(CtaCteStock ctaCteStock) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new CtaCteStockBO().saveCtaCteStock(ctaCteStock);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<CtaCteStock> getCtaCteStocByFecha(Date fechaDe,Date fechaA) throws Exception {
        List<CtaCteStock> ctaCte = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ctaCte = new CtaCteStockBO().getCtaCteStockByFecha(fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ctaCte;
    }
    
    public List<CtaCteStock> getCtaCteStocByFechaAndProveedor(Proveedor p, Date fechaDe,Date fechaA) throws Exception {
        List<CtaCteStock> ctaCte = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ctaCte = new CtaCteStockBO().getCtaCteStockByFechaAndProveedor(p, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ctaCte;
    }
    
    public List<CtaCteStock> getCtaCteStocByFechaAndProducto(Producto p, Date fechaDe,Date fechaA) throws Exception {
        List<CtaCteStock> ctaCte = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ctaCte = new CtaCteStockBO().getCtaCteStockByFechaAndProducto(p, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ctaCte;
    }
    
    public List<CtaCteStock> getCtaCteStocByComprobante(Long p) throws Exception {
        List<CtaCteStock> ctaCte = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ctaCte = new CtaCteStockBO().getCtaCteStockByComprobante(p);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ctaCte;
    }
    
//    public CtaCteCliente getMovimientoByIvaVentas(IvaVentas iv) throws Exception {
//        CtaCteCliente ccc = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            ccc = new CtaCteClienteBO().getMovimientosByIvaVentas(iv);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return ccc;
//    }
//    
//    public CtaCteCliente getMovimientoById(Long id) throws Exception {
//        CtaCteCliente ccc = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            ccc = new CtaCteClienteBO().getMovimientosById(id);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return ccc;
//    }
}
