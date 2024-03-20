/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.PeriodoBO;
import ar.com.ventas.entities.Periodo;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class PeriodoService {
    
    public void savePeriodo(Periodo periodo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new PeriodoBO().savePeriodo(periodo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public void updatePeriodo(Periodo periodo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new PeriodoBO().updatePeriodo(periodo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<Periodo> getAllPeriodos() throws Exception {
        List<Periodo> periodo = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            periodo = new PeriodoBO().getAllPeriodo();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return periodo;
    }

    public Periodo getPeriodoByFecha(Integer mes, Integer anio) throws Exception {
        Periodo per = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            per = new PeriodoBO().getPeriodoByFecha(mes, anio);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return per;
    }
    
    public List<Periodo> getAllPeriodosAbiertos() throws Exception {
        List<Periodo> periodos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            periodos = new PeriodoBO().getAllPeriodosAbiertos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return periodos;
    }
    /*
    public CtaCteCliente getMovimientoById(Long id) throws Exception {
        CtaCteCliente ccc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ccc = new CtaCteClienteBO().getMovimientosById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ccc;
    }
    */
}
