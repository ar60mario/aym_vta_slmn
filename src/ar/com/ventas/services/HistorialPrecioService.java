package ar.com.ventas.services;

import ar.com.ventas.bo.HistorialPrecioBO;
import ar.com.ventas.entities.HistorialPrecio;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HistorialPrecioService {
    
    public void saveHistorialPrecio(HistorialPrecio hp) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new HistorialPrecioBO().saveHistorialPrecio(hp);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<HistorialPrecio> getByProducto(Producto p) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<HistorialPrecio> hp = null;
        try {
            hp = new HistorialPrecioBO().getHistorialPrecioByProducto(p);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return hp;
    }
    
    public void deleteHistorialPrecio(HistorialPrecio hp) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new HistorialPrecioBO().deleteHistorialPrecio(hp);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
}
