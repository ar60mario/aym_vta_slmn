/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.ActivityRowBO;
import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class ActivityRowService {
    
    
    public void saveRenglon(ActivityRow renglon) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            ActivityRowBO bo = new ActivityRowBO();
            bo.saveRenglon(renglon);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception (ex);
        }
    }
    
    public List<ActivityRow> getAllActivityRowFromIvaVentas(Activity ivaVentas) throws Exception {
        List<ActivityRow> activityRow = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activityRow = new ActivityRowBO().getAllActivityRowFromIvaVentas(ivaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activityRow;
    }

    public List<ActivityRow> getRowByFecha(Date df, Date af) throws Exception {
        List<ActivityRow> activityRow = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activityRow = new ActivityRowBO().getRowByFecha(df, af);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activityRow;
    }
    
    public List<ActivityRow> getRowByFechaAndRubro(Date df, Date af, Rubro rubro) throws Exception {
        List<ActivityRow> activityRow = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activityRow = new ActivityRowBO().getRowByFechaAndRubro(df, af, rubro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activityRow;
    }
    
    public List<ActivityRow> getRowByFechaAndProducto(Date df, Date af, Producto p) throws Exception {
        List<ActivityRow> activityRow = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activityRow = new ActivityRowBO().getRowByFechaAndProducto(df, af, p);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activityRow;
    }
}
