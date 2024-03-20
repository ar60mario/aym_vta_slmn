/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.CtaCteClienteBO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.CtaCteCliente;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class CtaCteClienteService {

    public CtaCteCliente getUltimoMovimientoPorDia(Cliente cli, Date f) throws Exception {
        CtaCteCliente ccc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ccc = new CtaCteClienteBO().getUltimoMovimientoPorDia(cli, f);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ccc;
    }
    
    //
//    public CtaCteCliente getUltimoMovimientoPorAntes(Cliente cli, Date f) throws Exception {
//        CtaCteCliente ccc = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            ccc = new CtaCteClienteBO().getUltimoMovimientoPorAntes(cli, f);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return ccc;
//    }
    
    public CtaCteCliente getUltimoMovimiento(Cliente cli) throws Exception {
        CtaCteCliente ccc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ccc = new CtaCteClienteBO().getUltimoMovimiento(cli);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ccc;
    }

    public void saveCtaCteCliente(CtaCteCliente ctaCteCliente) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new CtaCteClienteBO().saveCtaCteCliente(ctaCteCliente);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public CtaCteCliente updateCtaCteCliente(CtaCteCliente ctaCteCliente) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        CtaCteCliente cta;
        try {
            cta = new CtaCteClienteBO().updateCtaCteCliente(ctaCteCliente);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cta;
    }

    public void deleteCtaCteCliente(CtaCteCliente ctaCteCliente) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new CtaCteClienteBO().deleteCtaCteCliente(ctaCteCliente);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    //
    public List<CtaCteCliente> getAllCtaCteClienteByCodigoAndFecha(Cliente cli, Date fechaDe, Date fechaA) throws Exception {
        List<CtaCteCliente> ctaCteCliente = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ctaCteCliente = new CtaCteClienteBO().getAllCtaCteClienteByCodigoAndFecha(cli, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ctaCteCliente;
    }

    public List<CtaCteCliente> getCtaCteClienteByFecha(Date fecha) throws Exception {
        List<CtaCteCliente> ctaCteCliente = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ctaCteCliente = new CtaCteClienteBO().getCtaCteClienteByFecha(fecha);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ctaCteCliente;
    }

    public List<CtaCteCliente> getTodaCtaCteClienteByCliente(Cliente cli) throws Exception {
        List<CtaCteCliente> ctaCteCliente = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ctaCteCliente = new CtaCteClienteBO().getTodaCtaCteClienteByCliente(cli);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ctaCteCliente;
    }

    public CtaCteCliente getMovimientoByIvaVentas(IvaVentas iv) throws Exception {
        CtaCteCliente ccc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ccc = new CtaCteClienteBO().getMovimientosByIvaVentas(iv);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ccc;
    }

    public CtaCteCliente getMovimientoById(Long id) throws Exception {
        CtaCteCliente ccc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ccc = new CtaCteClienteBO().getMovimientosById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ccc;
    }
}
