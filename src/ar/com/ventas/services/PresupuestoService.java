/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.PresupuestoBO;
import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcela
 */
public class PresupuestoService {

    public void savePresupuestoCompleto(Customer cu, Routines ro, Activity act, Inventory in, List<ActivityRow> rf, Configuracion confi, List<Producto> ps) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new PresupuestoBO().savePresupuestoCompleto(cu, ro, act, in, rf, confi, ps);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return;
    }
    /*
    public void saveIvaVentas(IvaVentas ivaVentas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new IvaVentasBO().saveIvaVentas(ivaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<IvaVentas> getAllIvaVentas() throws Exception {

        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().getAllIvaVentas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;

    }

    public List<IvaVentas> getFacturasPorVendedorEntreFechas(Vendedor ve, Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBO().getFacturasPorVendedorEntreFechas(ve, fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getAllIvaVentasByCodigoYFecha(Cliente cod, Date fechaDe, Date fechaA) throws Exception {

        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().getAllIvaVentasByCodigoYFecha(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public IvaVentas getIvaVentasById(Long id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentas ivaVentas = null;
        try {
            ivaVentas = new IvaVentasBO().getIVById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public IvaVentas getFacturaByNumero(String letra,Integer sucursal, Integer numero) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentas ivaVentas = null;
        try {
            ivaVentas = new IvaVentasBO().getFacturaByNumero(letra,sucursal,numero);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public List<IvaVentas> getFactByFecha(Date fecha) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBO().getFactByFecha(fecha);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getFacturasEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBO().getFacturasEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getFcByCodigoYFecha(Cliente cod, Date fechaDe, Date fechaA) throws Exception {
        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().getFcByCodigoYFecha(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public List<IvaVentas> getNcByCodigoYFecha(Cliente cod, Date fechaDe, Date fechaA) throws Exception {
        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().getNcByCodigoYFecha(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public List<IvaVentas> getFacturasByPeriodo(int mes, int anio) throws Exception {
        List<IvaVentas> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            facturas = new PresupuestoService().getAllIvaVentas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
     */
}
