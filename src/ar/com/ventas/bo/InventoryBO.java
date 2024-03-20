/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.InventoryDAO;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Inventory;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class InventoryBO {
    
    private final InventoryDAO dao = new InventoryDAO();
    
    private static final Logger logger = Logger.getLogger("InventoryBO");
    
    //
    public Inventory getUltimoMovimientoPorDia(Customer cli, Date f) throws Exception{
        Inventory inventory = null;
        try{
            inventory = dao.getUltimoMovimientoPorDia(cli, f);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return inventory;
    }
    
    public Inventory getUltimoMovimiento(Customer cli) throws Exception{
        Inventory inventory = null;
        try{
            inventory = dao.getUltimoMovimiento(cli);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return inventory;
    }
    
    public Inventory saveInventory(Inventory inventory) throws Exception{
        try{
            dao.save(inventory);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return inventory;
    }
    
    public Inventory updateInventory(Inventory inventory) throws Exception{
        try{
            dao.update(inventory);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return inventory;
    }
    
    public List<Inventory> getAllInventoryByCodigoYFecha(Customer cli, Date fechaDe, Date fechaA) throws Exception {
        List<Inventory> listInventory = null;
        try {
            listInventory = dao.getAllCtaCteByCodigoAndFecha(cli, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listInventory;
    }
    
    public List<Inventory> getCtaCtePorFecha(Date fecha) throws Exception {
        List<Inventory> listInventory = null;
        try {
            listInventory = dao.getCtaCtePorFecha(fecha);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listInventory;
    }
    
    public List<Inventory> getAllInventory() throws Exception {
        List<Inventory> listInventory = null;
        try {
            listInventory = dao.getAllCtaCteCliente();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listInventory;
    }
    
}
