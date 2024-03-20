/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.RentalBO;
import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rental;
import ar.com.ventas.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class RentalService {
    
    public List<Rental> getRentalFromActivity(Activity ivaVentas) throws Exception {
        List<Rental> renglonNc = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglonNc = new RentalBO().getRentalRowFromIvaVentas(ivaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglonNc;
    }

    public void deleteRenglonFacturaByFactura(IvaVentas factura) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //new RenglonFacturaBO().
    }
    
    public void saveRenglon(Rental rental) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RentalBO().saveRental(rental);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<Rental> getRenglonesDevolByFechas(Date df, Date af) throws Exception {
        List<Rental> renglonNc = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglonNc = new RentalBO().getRenglonesDevolByFechas(df, af);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglonNc;
    }
    //getRenglonesDevolByFechasAndProducto
    public List<Rental> getRenglonesDevolByFechasAndProducto(Date df, Date af, Producto p) throws Exception {
        List<Rental> renglonNc = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglonNc = new RentalBO().getRenglonesDevolByFechasAndProducto(df, af, p);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglonNc;
    }
}
