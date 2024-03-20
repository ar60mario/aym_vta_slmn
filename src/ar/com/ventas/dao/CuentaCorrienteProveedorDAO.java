/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.CuentaCorrienteProveedor;
import ar.com.ventas.entities.Proveedor;
import ar.com.ventas.entities.ReciboProveedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcela
 */
public class CuentaCorrienteProveedorDAO extends GenericoDAO {

    public List<CuentaCorrienteProveedor> getAllByProveedor(Proveedor proveedor) {
        List<CuentaCorrienteProveedor> ctaCteP = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        ctaCteP = (List<CuentaCorrienteProveedor>) session.createCriteria(CuentaCorrienteProveedor.class)
                .add(Restrictions.eq("proveedor", proveedor))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("id"))
                .list();
        return ctaCteP;
    }
    
    public List<CuentaCorrienteProveedor> getAllByProveedorInverso(Proveedor proveedor) {
        List<CuentaCorrienteProveedor> ctaCteP = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        ctaCteP = (List<CuentaCorrienteProveedor>) session.createCriteria(CuentaCorrienteProveedor.class)
                .add(Restrictions.eq("proveedor", proveedor))
                .addOrder(Order.desc("fecha"))
//                .addOrder(Order.desc("id"))
                .list();
        return ctaCteP;
    }

    public List<CuentaCorrienteProveedor> getCtaCteProvByProvMasFechas(Proveedor pro, Date fd, Date fa) {
        List<CuentaCorrienteProveedor> movimientos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        movimientos = (List<CuentaCorrienteProveedor>) session.createCriteria(CuentaCorrienteProveedor.class)
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("proveedor", pro))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("id"))
                .list();
        return movimientos;
    }
    
    public List<CuentaCorrienteProveedor> getCtaCteProvByProvMasFechasInverso(Proveedor pro, Date fd, Date fa) {
        List<CuentaCorrienteProveedor> movimientos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        movimientos = (List<CuentaCorrienteProveedor>) session.createCriteria(CuentaCorrienteProveedor.class)
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("proveedor", pro))
                .addOrder(Order.desc("fecha"))
                .addOrder(Order.desc("id"))
                .list();
        return movimientos;
    }

    public CuentaCorrienteProveedor getCtaCteByComprobante(ComprobanteCompras cc) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(CuentaCorrienteProveedor.class);
        criteria.add(Restrictions.eq("comprobante", cc));
        CuentaCorrienteProveedor cuenta = (CuentaCorrienteProveedor) criteria.uniqueResult();
        return cuenta;
    }
    
    public CuentaCorrienteProveedor getCtaCteByRecibo(ReciboProveedor rp) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(CuentaCorrienteProveedor.class);
        criteria.add(Restrictions.eq("reciboProveedor", rp));
        CuentaCorrienteProveedor cuenta = (CuentaCorrienteProveedor) criteria.uniqueResult();
        return cuenta;
    }
}
