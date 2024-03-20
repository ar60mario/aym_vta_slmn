/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.InventoryBO;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class InventoryService {
    
    //
    public Inventory getUltimoMovimientoPorDia(Customer cli, Date f) throws Exception{
        Inventory inventory = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            inventory = new InventoryBO().getUltimoMovimientoPorDia(cli, f);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return inventory;
    }
    
    public Inventory getUltimoMovimiento(Customer cli) throws Exception{
        Inventory inventory = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            inventory = new InventoryBO().getUltimoMovimiento(cli);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return inventory;
    }
    
    public void saveInventory(Inventory inventory) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new InventoryBO().saveInventory(inventory);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public void updateInventory(Inventory inventory) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new InventoryBO().updateInventory(inventory);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<Inventory> getAllInventoryByCodigoYFecha(Customer cli,Date fechaDe,Date fechaA) throws Exception {
        List<Inventory> inventory = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            inventory = new InventoryBO().getAllInventoryByCodigoYFecha(cli, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return inventory;
    }
    
    public List<Inventory> getCtaCtePorFecha(Date fecha) throws Exception {
        List<Inventory> inventory = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            inventory = new InventoryBO().getCtaCtePorFecha(fecha);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return inventory;
    }
    
    public List<Inventory> getAllInventory() throws Exception {
        List<Inventory> inventory = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            inventory = new InventoryBO().getAllInventory();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return inventory;
    }
    
}
