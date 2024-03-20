/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.RenglonFacturaBO;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonFactura;
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
public class RenglonFacturaService {
    
    public List<RenglonFactura> getAllRenglonFacturaFromIvaVentas(IvaVentas ivaVentas) throws Exception {
        
        List<RenglonFactura> renglonFactura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglonFactura = new RenglonFacturaBO().getAllRenglonFacturaFromIvaVentas(ivaVentas);
            //renglonFactura = new RenglonFacturaBO().getAll();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglonFactura;
    }
    
    public List<RenglonFactura> getRenglonesByPeriodo(Integer mes, Integer anio) throws Exception {
        List<RenglonFactura> renglones = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        try {
            renglones = new RenglonFacturaBO().getRenglonesByPeriodo(mes, anio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglones;
    }

    public void deleteRenglonFacturaByFactura(IvaVentas factura) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        //new RenglonFacturaBO().
    }
    
    public List<RenglonFactura> getRenglonesFcByFechas(Date df, Date af) throws Exception {
        List<RenglonFactura> list = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            list = new RenglonFacturaBO().getRenglonesFcByFechas(df, af);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return list;
    }
    
    public List<RenglonFactura> getRenglonesFcByFechasAndRubro(Date df, Date af, Rubro rubro) throws Exception {
        List<RenglonFactura> list = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            list = new RenglonFacturaBO().getRenglonesFcByFechasAndRubro(df, af, rubro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return list;
    }
    
    public List<RenglonFactura> getRenglonesFcByFechasAndProducto(Date df, Date af, Producto p) throws Exception {
        List<RenglonFactura> list = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            list = new RenglonFacturaBO().getRenglonesFcByFechasAndProducto(df, af, p);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return list;
    }
}
