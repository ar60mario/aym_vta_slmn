package ar.com.ventas.services;

import ar.com.ventas.bo.ReciboBO;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.util.HibernateUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReciboService {

    public Recibo saveRecibo(Recibo recibo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Recibo rec = null;
        try {
            rec = new ReciboBO().saveRecibo(recibo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return rec;
    }
    
    public Recibo updateRecibo(Recibo recibo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Recibo rec = null;
        try {
            rec = new ReciboBO().updateRecibo(recibo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return rec;
    }
    
    public void deleteRecibo(Recibo recibo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Recibo rec = null;
        try {
            new ReciboBO().deleteRecibo(recibo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return;
    }
    
    public Recibo getReciboById(Long id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Recibo recibo = null;
        try {
            recibo = new ReciboBO().getReciboById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public List<Recibo> getRecibosByFecha(Date fecha) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Recibo> recibos = null;
        try {
            recibos = new ReciboBO().getRecibosByDia(fecha);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return recibos;
    }
}
