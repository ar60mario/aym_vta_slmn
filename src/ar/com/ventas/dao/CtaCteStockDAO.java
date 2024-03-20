/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.CtaCteStock;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Proveedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class CtaCteStockDAO extends GenericoDAO {

    public List<CtaCteStock> getCtaCteStockByFecha(Date fechaDe, Date fechaA) {
        List<CtaCteStock> ctaCte = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        ctaCte = (List<CtaCteStock>) session.createCriteria(CtaCteStock.class)
                .add(Restrictions.between("fecha", fechaDe, fechaA))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("comprobante"))
                .addOrder(Order.asc("id"))
                .list();
        return ctaCte;
    }
    
    public List<CtaCteStock> getCtaCteStockByFechaAndProveedor(Proveedor p,Date fechaDe, Date fechaA) {
        List<CtaCteStock> ctaCte = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        ctaCte = (List<CtaCteStock>) session.createCriteria(CtaCteStock.class)
                .add(Restrictions.eq("proveedor", p))
                .add(Restrictions.between("fecha", fechaDe, fechaA))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("comprobante"))
                .addOrder(Order.asc("id"))
                .list();
        return ctaCte;
    }
    
    public List<CtaCteStock> getCtaCteStockByFechaAndProducto(Producto p,Date fechaDe, Date fechaA) {
        List<CtaCteStock> ctaCte = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        ctaCte = (List<CtaCteStock>) session.createCriteria(CtaCteStock.class)
                .add(Restrictions.eq("producto", p))
                .add(Restrictions.between("fecha", fechaDe, fechaA))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("comprobante"))
                .addOrder(Order.asc("id"))
                .list();
        return ctaCte;
    }
    
    public List<CtaCteStock> getCtaCteStockByComprobante(Long p) {
        List<CtaCteStock> ctaCte = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        ctaCte = (List<CtaCteStock>) session.createCriteria(CtaCteStock.class)
                .add(Restrictions.eq("comprobante", p))
                .addOrder(Order.asc("id"))
                .list();
        return ctaCte;
    }
//
//    public CtaCteCliente getMovimientoByIvaVentas(IvaVentas iv) {
//        CtaCteCliente ccc = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        StringBuffer sb = new StringBuffer();
//        sb.append("from CtaCteCliente ccl ");
//        sb.append("where ccl.factura = :iv ");
//
//        Query query = session.createQuery(sb.toString());
//        query.setParameter("iv", iv);
//
//        ccc = (CtaCteCliente) query.uniqueResult();
//        return ccc;
//    }
//
//    public CtaCteCliente getMovimientoById(Long id) {
//        CtaCteCliente ccc = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        StringBuffer sb = new StringBuffer();
//        sb.append("from CtaCteCliente ccl ");
//        sb.append("where ccl.id = :id ");
//
//        Query query = session.createQuery(sb.toString());
//        query.setParameter("id", id);
//
//        ccc = (CtaCteCliente) query.uniqueResult();
//        return ccc;
//    }
}
