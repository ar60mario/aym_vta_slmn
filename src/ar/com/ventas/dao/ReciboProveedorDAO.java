/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Proveedor;
import ar.com.ventas.entities.ReciboProveedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcela
 */
public class ReciboProveedorDAO extends GenericoDAO {

    public ReciboProveedor getReciboProveedorByNro(Integer nro, Proveedor p) {
        ReciboProveedor rc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        rc = (ReciboProveedor) session.createCriteria(ReciboProveedor.class)
                .add(Restrictions.eq("numero", nro))
                .add(Restrictions.eq("proveedor", p))
                .uniqueResult();
        return rc;
    }
    
    public List<ReciboProveedor> getRecibosEntreFechas(Date fd, Date fa) {
        List<ReciboProveedor> recibos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        recibos = (List<ReciboProveedor>) session.createCriteria(ReciboProveedor.class)
                .add(Restrictions.between("fecha", fd, fa))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("id"))
                .list();
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosByFechas(Date fd) {
        List<ReciboProveedor> recibos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        recibos = (List<ReciboProveedor>) session.createCriteria(ReciboProveedor.class)
                .add(Restrictions.eq("fecha", fd))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("id"))
                .list();
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosPorProveedorEntreFechas(Proveedor p, Date fd, Date fa) {
        List<ReciboProveedor> recibos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        recibos = (List<ReciboProveedor>) session.createCriteria(ReciboProveedor.class)
                .add(Restrictions.eq("proveedor", p))
                .add(Restrictions.between("fecha", fd, fa))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("id"))
                .list();
        return recibos;
    }

    public List<ReciboProveedor> getRecibosPorProveedor(Proveedor p) {
        List<ReciboProveedor> recibos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        recibos = (List<ReciboProveedor>) session.createCriteria(ReciboProveedor.class)
                .add(Restrictions.eq("proveedor", p))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("id"))
                .list();
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosPorProveedorImputados(Proveedor p) {
        List<ReciboProveedor> recibos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        recibos = (List<ReciboProveedor>) session.createCriteria(ReciboProveedor.class)
                .add(Restrictions.eq("proveedor", p))
                .add(Restrictions.eq("imputado", true))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("id"))
                .list();
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosPorProveedorNoImputados(Proveedor p) {
        List<ReciboProveedor> recibos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        recibos = (List<ReciboProveedor>) session.createCriteria(ReciboProveedor.class)
                .add(Restrictions.eq("proveedor", p))
                .add(Restrictions.eq("imputado", false))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("id"))
                .list();
        return recibos;
    }
}
