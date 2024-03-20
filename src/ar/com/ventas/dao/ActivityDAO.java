/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcela
 */
public class ActivityDAO extends GenericDAO{
    
    public List<Activity> getFacturasByFiltro(Customer cod, Date fechaDe, Date fechaA) {
        List<Activity> facturas = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        facturas = (List<Activity>) 
                session.createCriteria(Activity.class)
                        .add(Restrictions.eq("customer", cod))
                        .add(Restrictions.between("fecha", fechaDe, fechaA) )
                        .list();
        return facturas;
    }
    
    public List<Activity> getPresupuestoByVendedor(Long cod, Date fechaDe, Date fechaA) {
        List<Activity> facturas = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        facturas = (List<Activity>) 
                session.createCriteria(Activity.class)
                        .add(Restrictions.and(
                                Restrictions.isNotNull("idVendedor"),
                                Restrictions.eq("idVendedor", cod)))
                        .add(Restrictions.between("fecha", fechaDe, fechaA))
                        .add(Restrictions.gt("total", 0.00))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return facturas;
    }
    
    public List<Activity> getDevolucionByVendedor(Long cod, Date fechaDe, Date fechaA) {
        List<Activity> facturas = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        facturas = (List<Activity>) 
                session.createCriteria(Activity.class)
                        .add(Restrictions.and(
                                Restrictions.isNotNull("idVendedor"),
                                Restrictions.eq("idVendedor", cod)))
                        .add(Restrictions.between("fecha", fechaDe, fechaA))
                        .add(Restrictions.lt("total", 0.00))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return facturas;
    }
    
    public List<Activity> getPresupuestosByFiltro(Customer cod, Date fechaDe, Date fechaA) {
        List<Activity> facturas = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        facturas = (List<Activity>) 
                session.createCriteria(Activity.class)
                        .add(Restrictions.eq("customer", cod))
                        .add(Restrictions.between("fecha", fechaDe, fechaA) )
                        .add(Restrictions.gt("total", 0.0))
                        .list();
        return facturas;
    }
    
    public List<Activity> getDevolucionesByFiltro(Customer cod, Date fechaDe, Date fechaA) {
        List<Activity> facturas = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        facturas = (List<Activity>) 
                session.createCriteria(Activity.class)
                        .add(Restrictions.eq("customer", cod))
                        .add(Restrictions.between("fecha", fechaDe, fechaA) )
                        .add(Restrictions.lt("total", 0.0))
                        .list();
        return facturas;
    }
    
    public List<Activity> getFcByFecha(Date fecha) {
        List<Activity> facturas = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        facturas = (List<Activity>) 
                session.createCriteria(Activity.class)
                        .add(Restrictions.eq("fecha", fecha) )
                        .list();
        return facturas;
    }
    
    //public 
    
    public Activity getByLetraNumero(String letra,Integer sucursal, Integer numero) {
        Activity factura = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Activity iv ");
        sb.append("where iv.letra = '" + letra + "' and iv.numeroSucursal = '" + sucursal + "' and iv.numeroFactura = '" + numero +"' ");
        Query query = session.createQuery(sb.toString());
        factura = (Activity) query.uniqueResult();
        return factura;
    }
    
    public List<Activity> getFacturasByCod(Customer cod) {
        List<Activity> facturas = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Activity iv ");
        sb.append("where iv.customer = :cod ");
        sb.append("order by iv.fecha asc");
        Query query = session.createQuery(sb.toString());
        query.setParameter("cod", cod);
        facturas = (List<Activity>) query.list();
        return facturas;
    }
    
    public List<Activity> getFacturasByPeriodo(Date fechaDe, Date fechaA) {
        List<Activity> facturas = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        facturas = (List<Activity>) 
                session.createCriteria(Activity.class)
                        .add(Restrictions.between("fecha", fechaDe, fechaA))
                        .addOrder(Order.asc("fecha"))
                        .addOrder(Order.asc("letra"))
                        .addOrder(Order.asc("numeroFactura"))
                        .list();
        return facturas;
    }
    
    
}
