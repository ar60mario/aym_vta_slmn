/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.PorcentualVendedorBO;
import ar.com.ventas.entities.PorcentualVendedor;
import ar.com.ventas.entities.Vendedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class PorcentualVendedorService {
    
    public void savePorcentualVendedor(PorcentualVendedor porcentual) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new PorcentualVendedorBO().savePorcentualVendedor(porcentual);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public void deletePorcentualVendedor(PorcentualVendedor porcentual) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new PorcentualVendedorBO().deletePorcentualVendedor(porcentual);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<PorcentualVendedor> getAllPorcentualVendedor() throws Exception {
        List<PorcentualVendedor> porcentuales = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            porcentuales = new PorcentualVendedorBO().getAllPorcentualVendedor();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return porcentuales;
    }
    
    public List<PorcentualVendedor> getAllPorcentualByVendedor(Vendedor v) throws Exception {
        List<PorcentualVendedor> pv = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            pv = new PorcentualVendedorBO().getAllPorcentualByVendedor(v);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return pv;
    }
    
    public PorcentualVendedor getPorcentualVendedorById(Long id) throws Exception {
        PorcentualVendedor pV = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            pV = new PorcentualVendedorBO().getIVById(id);
        tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return pV;
    }
    
    public void updatePorcentualVendedor(PorcentualVendedor porcentual) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new PorcentualVendedorBO().updatePorcentualVendedor(porcentual);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
}
