/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.ActivityBO;
import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcela
 */
public class ActivityService {

    public Activity saveActivity(Activity activity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activity = new ActivityBO().saveActivity(activity);
            tx.commit();
            return activity;
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<Activity> getAllActivity() throws Exception {

        List<Activity> activity = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activity = new ActivityBO().getAllActivity();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activity;

    }

    public List<Activity> getAllActivityByCodigoYFecha(Customer cod, Date fechaDe, Date fechaA) throws Exception {
        List<Activity> activity = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activity = new ActivityBO().getAllActivityByCodigoYFecha(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activity;
    }
    
    public List<Activity> getPresupuestoByVendedor(Long cod, Date fechaDe, Date fechaA) throws Exception {
        List<Activity> activity = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activity = new ActivityBO().getPresupuestoByVendedor(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activity;
    }
    
    public List<Activity> getDevolucionByVendedor(Long cod, Date fechaDe, Date fechaA) throws Exception {
        List<Activity> activity = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activity = new ActivityBO().getDevolucionByVendedor(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activity;
    }
    
    public List<Activity> getAllPresupuestosByCodigoYFecha(Customer cod, Date fechaDe, Date fechaA) throws Exception {
        List<Activity> activity = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activity = new ActivityBO().getAllPresupuestosByCodigoYFecha(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activity;
    }
    
    public List<Activity> getAllDevolucionesByCodigoYFecha(Customer cod, Date fechaDe, Date fechaA) throws Exception {
        List<Activity> activity = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activity = new ActivityBO().getAllDevolucionesByCodigoYFecha(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activity;
    }

    public Activity getActivityById(Long id) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Activity activity = null;
        try {
            activity = new ActivityBO().getIVById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activity;
    }

    public Activity getFacturaByNumero(String letra,Integer sucursal, Integer numero) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Activity activity = null;
        try {
            activity = new ActivityBO().getFacturaByNumero(letra,sucursal,numero);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activity;
    }
    
    public List<Activity> getAllActivityByCodigo(Customer cod) throws Exception {
        List<Activity> activity = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activity = new ActivityBO().getAllActivityByCodigo(cod);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activity;
    }
    
    public List<Activity> getAllActivityByPeriodo(Date fechaDe, Date fechaA) throws Exception {
        List<Activity> activity = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activity = new ActivityBO().getAllActivityByPeriodo(fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activity;
    }
    
    public List<Activity> getFcByFecha(Date fecha) throws Exception {
        List<Activity> activity = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            activity = new ActivityBO().getFcByFecha(fecha);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return activity;
    }
}
