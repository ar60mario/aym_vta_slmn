/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.ReciboProveedorBO;
import ar.com.ventas.entities.Proveedor;
import ar.com.ventas.entities.ReciboProveedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class ReciboProveedorService {

    public ReciboProveedor saveRecibo(ReciboProveedor recibo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ReciboProveedor rec = null;
        try {
            rec = new ReciboProveedorBO().saveReciboProveedor(recibo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return rec;
    }
    
    public ReciboProveedor updateRecibo(ReciboProveedor recibo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ReciboProveedor rec = null;
        try {
            rec = new ReciboProveedorBO().updateReciboProveedor(recibo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return rec;
    }
    
    public void deleteRecibo(ReciboProveedor recibo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ReciboProveedorBO().deleteReciboProveedor(recibo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public ReciboProveedor getReciboById(Long id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ReciboProveedor recibo = null;
        try {
            recibo = new ReciboProveedorBO().getReciboProveedorById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public ReciboProveedor getReciboByNro(Integer nro, Proveedor p) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ReciboProveedor recibo = null;
        try {
            recibo = new ReciboProveedorBO().getReciboProveedorByNro(nro, p);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public List<ReciboProveedor> getRecibosEntreFechas(Date fd, Date fa) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ReciboProveedor> recibos = null;
        try {
            recibos = new ReciboProveedorBO().getRecibosEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibos;
    }
    //
    public List<ReciboProveedor> getRecibosByFechas(Date fd) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ReciboProveedor> recibos = null;
        try {
            recibos = new ReciboProveedorBO().getRecibosByFechas(fd);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosPorProveedorEntreFechas(Proveedor p, Date fd, Date fa) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ReciboProveedor> recibos = null;
        try {
            recibos = new ReciboProveedorBO().getRecibosPorProveedorEntreFechas(p, fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosPorProveedor(Proveedor p) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ReciboProveedor> recibos = null;
        try {
            recibos = new ReciboProveedorBO().getRecibosPorProveedor(p);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosPorProveedorImputados(Proveedor p) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ReciboProveedor> recibos = null;
        try {
            recibos = new ReciboProveedorBO().getRecibosPorProveedorImputados(p);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosPorProveedorNoImputados(Proveedor p) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ReciboProveedor> recibos = null;
        try {
            recibos = new ReciboProveedorBO().getRecibosPorProveedorNoImputados(p);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibos;
    }
}
