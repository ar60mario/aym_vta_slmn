/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonNotaCredito;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class RenglonNotaCreditoDAO extends GenericoDAO{
    
    public List<RenglonNotaCredito> getAllRenglonNCFromIvaVentas(IvaVentas factura) {
        List<RenglonNotaCredito> renglonFactura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonNotaCredito.class);
        criteria.add(Restrictions.eq("ivaVentas", factura));
        renglonFactura = (List<RenglonNotaCredito>) criteria.list();
        return renglonFactura;
    }
    
    public List<RenglonNotaCredito> getRenglonesNCByFechas(Date df, Date af) {
        List<RenglonNotaCredito> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonNotaCredito.class);
        criteria.add(Restrictions.lt("total",0.00));
        Criteria criteria2 = criteria.createCriteria("ivaVentas").add(Restrictions.between("fecha", df, af));
        //criteria2.add(Restrictions.gt("total",0.00));
        criteria2.addOrder(Order.asc("fecha"));
        renglones=criteria.list();
        return renglones;
    }
    
    public List<RenglonNotaCredito> getRenglonesNCByFechasAndRubro(Date df, Date af, Rubro rubro) {
        List<RenglonNotaCredito> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonNotaCredito.class);
        criteria.add(Restrictions.lt("total",0.00));
        Criteria criteria2 = criteria.createCriteria("ivaVentas").add(Restrictions.between("fecha", df, af));
        Criteria criteria3 = criteria.createCriteria("producto");
        criteria3.add(Restrictions.eq("rubro", rubro));
        //criteria2.add(Restrictions.gt("total",0.00));
        criteria2.addOrder(Order.asc("fecha"));
        renglones=criteria.list();
        return renglones;
    }
    
    public List<RenglonNotaCredito> getRenglonesNCByFechasAndProducto(Date df, Date af, Producto p) {
        List<RenglonNotaCredito> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonNotaCredito.class);
        criteria.add(Restrictions.eq("producto",p));
        Criteria criteria2 = criteria.createCriteria("ivaVentas").add(Restrictions.between("fecha", df, af));
        //criteria2.add(Restrictions.gt("total",0.00));
        //criteria2.addOrder(Order.asc("fecha"));
        renglones=criteria2.list();
        return renglones;
    }
}
