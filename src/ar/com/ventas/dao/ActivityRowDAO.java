/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.util.HibernateUtil;
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
public class ActivityRowDAO extends GenericDAO{
    
    public List<ActivityRow> getAllActivityRowFromIvaVentas(Activity factura) {
        List<ActivityRow> activityRow = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ActivityRow.class);
        criteria.add(Restrictions.eq("activity", factura));
        activityRow = (List<ActivityRow>) criteria.list();
        return activityRow;
    }

    public List<ActivityRow> getRowByFecha(Date df, Date af) {
        List<ActivityRow> activityRow = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ActivityRow.class);
        criteria.add(Restrictions.gt("total",0.00));
        Criteria criteria2 = criteria.createCriteria("activity").add(Restrictions.between("fecha", df, af));
        criteria2.addOrder(Order.asc("fecha"));
        activityRow = (List<ActivityRow>) criteria.list();
        return activityRow;
    }
    
    public List<ActivityRow> getRowByFechaAndRubro(Date df, Date af) {
        List<ActivityRow> activityRow = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ActivityRow.class);
        criteria.add(Restrictions.gt("total",0.00));
        Criteria criteria2 = criteria.createCriteria("activity");
        criteria2.add(Restrictions.between("fecha", df, af));
//        criteria2.addOrder(Order.asc("fecha"));
        activityRow = (List<ActivityRow>) criteria.list();
        return activityRow;
    }
    
    public List<ActivityRow> getRowByFechaAndProducto(Date df, Date af, Producto p) {
        int c = p.getCodigo();
        List<ActivityRow> activityRow = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(ActivityRow.class);
        criteria.add(Restrictions.eq("codigoProducto",c));
        Criteria criteria2 = criteria.createCriteria("activity").add(Restrictions.between("fecha", df, af));
        //criteria2.addOrder(Order.asc("fecha"));
        activityRow = (List<ActivityRow>) criteria.list();
        return activityRow;
    }
}
