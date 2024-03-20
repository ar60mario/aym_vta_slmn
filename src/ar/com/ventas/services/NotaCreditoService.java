/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.ActivityBO;
import ar.com.ventas.bo.ActivityRowBO;
import ar.com.ventas.bo.IvaVentasBO;
import ar.com.ventas.bo.NotaCreditoBO;
import ar.com.ventas.bo.RenglonFacturaBO;
import ar.com.ventas.bo.RenglonNotaCreditoBO;
import ar.com.ventas.bo.RentalBO;
import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.entities.RenglonNotaCredito;
import ar.com.ventas.entities.Rental;
import ar.com.ventas.util.HibernateUtil;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class NotaCreditoService {

    public Activity saveDevolucionCompleta(Activity iv, List<Rental> rf) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ActivityBO ivaBO = new ActivityBO();
        Activity ivaVentas = ivaBO.saveActivity(iv);
        Boolean bolean = true;
        for (Rental renglon : rf) {
            renglon.setActivity(ivaVentas);
            try {
                NotaCreditoBO bo = new NotaCreditoBO();
                bo.saveRenglon(renglon);
            } catch (Exception ex) {
                bolean = false;
                tx.rollback();
                throw new Exception(ex);
            }
        }
        if (bolean) {
            tx.commit();
        }
        return ivaVentas;
    }
    
    public void saveRental(Rental re) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RentalBO().saveRental(re);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<Rental> getRentalFromDevolucion(Activity devolucion) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Rental> renglonesDevolucion = null;
        return renglonesDevolucion;
    }
}
