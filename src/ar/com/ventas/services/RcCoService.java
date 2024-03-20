/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.RcCoBO;
import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.RcCo;
import ar.com.ventas.entities.ReciboProveedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class RcCoService {

    public RcCo saveRecibo(RcCo recibo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        RcCo rec = null;
        try {
            rec = new RcCoBO().saveRecibo(recibo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return rec;
    }
    
    public void deleteRecibo(RcCo recibo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RcCoBO().deleteRecibo(recibo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public RcCo getReciboById(Long id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        RcCo recibo = null;
        try {
            recibo = new RcCoBO().getReciboById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public List<RcCo> getRcCoByComprobante(ComprobanteCompras cc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<RcCo> recibos = null;
        try {
            recibos = new RcCoBO().getRcCoByComprobante(cc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<RcCo> getRcCoByRecibo(ReciboProveedor rp) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<RcCo> recibos = null;
        try {
            recibos = new RcCoBO().getRcCoByRecibo(rp);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<RcCo> getRcCoByNotaCredito(ComprobanteCompras cc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<RcCo> recibos = null;
        try {
            recibos = new RcCoBO().getRcCoByNotaCredito(cc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibos;
    }
}
