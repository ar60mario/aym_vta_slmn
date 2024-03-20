/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.ActivityBO;
import ar.com.ventas.bo.ActivityRowBO;
import ar.com.ventas.bo.FacturaBO;
import ar.com.ventas.bo.IvaVentasBO;
import ar.com.ventas.bo.RenglonFacturaBO;
import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.CtaCteCliente;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class FacturaService {

    public void saveFactura(Activity iv, List<ActivityRow> rf) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ActivityBO ivaBO = new ActivityBO();
        Activity ivaVentas = ivaBO.saveActivity(iv);
        Boolean bolean = true;
        for (ActivityRow renglon : rf) {
            renglon.setActivity(ivaVentas);
            try {
                ActivityRowBO bo = new ActivityRowBO();
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
    }
    
    public void saveFacturaCompleta(Cliente cl, Configuracion co, CtaCteCliente cc, IvaVentas iv, List<RenglonFactura> rf) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new FacturaBO().saveFacturaCompleta(cl, co, cc, iv, rf);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public void saveFacturaWeb(IvaVentas iv, List<RenglonFactura> rf) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentasBO ivaBO = new IvaVentasBO();
        IvaVentas ivaVentas = ivaBO.saveIvaVentas(iv);
        Boolean bolean = true;
        for (RenglonFactura renglon : rf) {
            renglon.setIvaVentas(ivaVentas);
            try {
                RenglonFacturaBO bo = new RenglonFacturaBO();
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
    }
    
    public Activity getFacturaByNumero(String letra,Integer sucursal, Integer numero) throws Exception{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Activity factura = null;
        try {
            factura = new ActivityBO().getFacturaByNumero(letra,sucursal,numero);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return factura;
    }
    
    public void grabarFactura(IvaVentas iv, List<RenglonFactura> rf) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentasBO ivaBO = new IvaVentasBO();
        IvaVentas ivaVentas = ivaBO.saveIvaVentas(iv);
        Boolean bolean = true;
        for (RenglonFactura renglon : rf) {
            renglon.setIvaVentas(ivaVentas);
            try {
                RenglonFacturaBO bo = new RenglonFacturaBO();
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
    }
}
