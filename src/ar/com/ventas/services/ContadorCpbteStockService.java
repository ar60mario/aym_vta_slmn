package ar.com.ventas.services;

import ar.com.ventas.bo.ContadorCpbteStockBO;
import ar.com.ventas.entities.ContadorCpbteStock;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContadorCpbteStockService {
    
    public ContadorCpbteStock getFacturas(Integer id) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ContadorCpbteStock facturas = null;
        try {
            facturas = new ContadorCpbteStockBO().getFacturasById(id);
            tx.commit();
        }catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    return facturas;
    }
    
    public void saveConfiguracion(ContadorCpbteStock conf) throws Exception{
        
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ContadorCpbteStockBO().saveConfiguracion(conf);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    

    public void updateConfiguracion(ContadorCpbteStock config) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ContadorCpbteStockBO().updateConfiguracion(config);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    /*    
    public Cliente getClienteByCodigo(String codigo) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Cliente cliente = null;
        try {
            cliente = new ClienteBO().getClienteByCodigo(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cliente;
    }
    
    public void deleteCliente(Cliente cliente) throws Exception{
       Session session = HibernateUtils.getSessionFactory().getCurrentSession();
       Transaction tx = session.beginTransaction();
       try{
          
          new ClienteBO().deleteCliente(cliente);
          tx.commit();
       }
       catch(Exception ex){
           tx.rollback();
           throw new Exception (ex);
       }
    }

    public void saveCliente(Cliente cliente) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ClienteBO().saveCliente(cliente);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<Cliente> getAllClientes() throws Exception {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            clientes = new ClienteBO().getAllClientes();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }

    public void updateCliente(Cliente cliente) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ClienteBO().updateCliente(cliente);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<Cliente> getClienteByPagina(int paginaActual) throws Exception{
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            clientes = new ClienteBO().getClienteByPagina(paginaActual);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public int getClientesCount() throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        int count = 0;
        try{
            count = new ClienteBO().getClientesCount();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return count;
    }
    
    public List<Cliente> getClienteOrdenado() throws Exception{
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            clientes = new ClienteBO().getClientesOrdenado();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getClientesByFiltro(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Cliente> clientes = null;
        try{
            clientes = new ClienteBO().getClientesByFiltro(filtro);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
*/

}
