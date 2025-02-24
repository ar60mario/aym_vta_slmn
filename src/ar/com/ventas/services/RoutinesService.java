package ar.com.ventas.services;

import ar.com.ventas.bo.RoutinesBO;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RoutinesService {
    
    public Routines getFacturas(Long id) throws Exception{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Routines facturas = null;
        try {
            facturas = new RoutinesBO().getFacturasById(id);
            tx.commit();
        }catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    return facturas;
    }
    
    public void saveRoutines(Routines conf) throws Exception{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RoutinesBO().saveRoutines(conf);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    

    public void updateRoutines(Routines routin) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RoutinesBO().updateRoutines(routin);
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
