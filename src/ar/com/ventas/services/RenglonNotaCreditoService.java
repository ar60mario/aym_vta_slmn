/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.RenglonNotaCreditoBO;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonNotaCredito;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class RenglonNotaCreditoService {
    
    public List<RenglonNotaCredito> getAllRenglonNotaCreditoFromIvaVentas(IvaVentas ivaVentas) throws Exception {
        
        List<RenglonNotaCredito> renglonFactura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglonFactura = new RenglonNotaCreditoBO().getAllRenglonNotaCreditoFromIvaVentas(ivaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglonFactura;
    }

    public void deleteRenglonFacturaByFactura(IvaVentas factura) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //new RenglonFacturaBO().
    }
    
    public List<RenglonNotaCredito> getRenglonesNCByFechas(Date df, Date af) throws Exception {
        List<RenglonNotaCredito> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglones = new RenglonNotaCreditoBO().getRenglonesNCByFechas(df, af);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public List<RenglonNotaCredito> getRenglonesNCByFechasAndRubro(Date df, Date af, Rubro rubro) throws Exception {
        List<RenglonNotaCredito> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglones = new RenglonNotaCreditoBO().getRenglonesNCByFechasAndRubro(df, af, rubro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
    
    public List<RenglonNotaCredito> getRenglonesNCByFechasAndProducto(Date df, Date af, Producto p) throws Exception {
        List<RenglonNotaCredito> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglones = new RenglonNotaCreditoBO().getRenglonesNCByFechasAndProducto(df, af, p);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }
}
