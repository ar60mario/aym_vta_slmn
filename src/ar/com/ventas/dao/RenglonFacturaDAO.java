/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class RenglonFacturaDAO extends GenericoDAO {

    public List<RenglonFactura> getAllRenglonFacturaFromIvaVentas(IvaVentas factura) {
        List<RenglonFactura> renglonFactura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonFactura.class);
        criteria.add(Restrictions.eq("ivaVentas", factura));
        renglonFactura = (List<RenglonFactura>) criteria.list();
        return renglonFactura;
    }

    public List<RenglonFactura> getRenglonesByPeriodo(Integer mes, Integer anio) {
        List<RenglonFactura> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        String select = "FROM Renglon_Factura r, Iva_Ventas i where r.id_iva_ventas = i.id";
        Query query = session.createQuery(select);
        renglones = query.list();
        return renglones;
    }

    public List<RenglonFactura> getRenglonesFcByFechas(Date df, Date af) {
        List<RenglonFactura> renglones;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonFactura.class);
        criteria.add(Restrictions.gt("total", 0.00));
        Criteria criteria2 = criteria.createCriteria("ivaVentas").add(Restrictions.between("fecha", df, af));
        //criteria2.add(Restrictions.gt("total",0.00));
        criteria2.addOrder(Order.asc("fecha"));
        renglones = criteria.list();
        return renglones;
    }
    
    public List<RenglonFactura> getRenglonesFcByFechasAndRubro(Date df, Date af, Rubro rubro) {
        List<RenglonFactura> renglones;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonFactura.class);
        criteria.add(Restrictions.gt("total", 0.00));
        Criteria criteria3 = criteria.createCriteria("producto");
        criteria3.add(Restrictions.eq("rubro",rubro));
        Criteria criteria2 = criteria.createCriteria("ivaVentas");
        criteria2.add(Restrictions.between("fecha", df, af));
        //criteria2.add(Restrictions.gt("total",0.00));
        //criteria2.addOrder(Order.asc("fecha"));
        renglones = criteria.list();
        return renglones;
    }

    public List<RenglonFactura> getRenglonesFcByFechasAndProducto(Date df, Date af, Producto p) {
        List<RenglonFactura> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RenglonFactura.class);
        criteria.add(Restrictions.eq("producto", p));
        Criteria criteria2 = criteria.createCriteria("ivaVentas").add(Restrictions.between("fecha", df, af));
        //criteria2.add(Restrictions.gt("total",0.00));
        //criteria2.addOrder(Order.asc("fecha"));
        renglones = criteria.list();
        return renglones;
    }
}
