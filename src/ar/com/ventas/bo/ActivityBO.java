/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.ActivityDAO;
import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.Customer;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Marcela
 */
public class ActivityBO {

    private final ActivityDAO dao = new ActivityDAO();

    private static final Logger logger = Logger.getLogger("ActivityBO");

    public Activity saveActivity(Activity activity) throws Exception {
        try {
            dao.save(activity);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return activity;
    }

    public List<Activity> getAllActivity() throws Exception {

        List<Activity> listActivity = null;

        try {
            listActivity = dao.getAll(Activity.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivity;

    }

    public List<Activity> getAllActivityByCodigoYFecha(Customer cod, Date fechaDe, Date fechaA) throws Exception {
        List<Activity> listActivity = null;
        try {
            listActivity = dao.getFacturasByFiltro(cod, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivity;
    }
    
    public List<Activity> getPresupuestoByVendedor(Long cod, Date fechaDe, Date fechaA) throws Exception {
        List<Activity> listActivity = null;
        try {
            listActivity = dao.getPresupuestoByVendedor(cod, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivity;
    }
    
    public List<Activity> getDevolucionByVendedor(Long cod, Date fechaDe, Date fechaA) throws Exception {
        List<Activity> listActivity = null;
        try {
            listActivity = dao.getDevolucionByVendedor(cod, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivity;
    }
    
    public List<Activity> getAllDevolucionesByCodigoYFecha(Customer cod, Date fechaDe, Date fechaA) throws Exception {
        List<Activity> listActivity = null;
        try {
            listActivity = dao.getDevolucionesByFiltro(cod, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivity;
    }
    
    public List<Activity> getAllPresupuestosByCodigoYFecha(Customer cod, Date fechaDe, Date fechaA) throws Exception {
        List<Activity> listActivity = null;
        try {
            listActivity = dao.getPresupuestosByFiltro(cod, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivity;
    }

    public Activity getIVById(Long iv) throws Exception {
        Activity activity = null;
        try {
            activity = (Activity) dao.getById(Activity.class, iv);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return activity;
    }

    public Activity getFacturaByNumero(String letra, Integer sucursal, Integer numero) throws Exception {
        Activity activity = null;
        try {
            activity = (Activity) dao.getByLetraNumero(letra,sucursal,numero);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return activity;
    }
    
    public List<Activity> getAllActivityByCodigo(Customer cod) throws Exception {
        List<Activity> listActivity = null;
        try {
            listActivity = dao.getFacturasByCod(cod);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivity;
    }
    
    public List<Activity> getAllActivityByPeriodo(Date fechaDe, Date fechaA) throws Exception {
        List<Activity> listActivity = null;
        try {
            listActivity = dao.getFacturasByPeriodo(fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivity;
    }
    
    public List<Activity> getFcByFecha(Date fecha) throws Exception {
        List<Activity> listActivity = null;
        try {
            listActivity = dao.getFcByFecha(fecha);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivity;
    }
}
