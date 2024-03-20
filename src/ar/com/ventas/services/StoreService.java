package ar.com.ventas.services;

import ar.com.ventas.bo.StoreBO;
import ar.com.ventas.entities.Stores;
import ar.com.ventas.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StoreService {
    
    public Stores getMovimientoCajaByFecha(Date fecha) throws Exception{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Stores movim = null;
        try {
            movim = new StoreBO().getMovimientoCajaByFecha(fecha);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return movim;
    }
    
    public List<Stores> getCajasEntreFechas(Date f1, Date f2) throws Exception{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Stores> movim = null;
        try {
            movim = new StoreBO().getCajasEntreFechas(f1, f2);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return movim;
    }
    
//    public void deleteCliente(Cliente cliente) throws Exception{
//       Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//       Transaction tx = session.beginTransaction();
//       try{
//          new ClienteBO().deleteCliente(cliente);
//          tx.commit();
//       }
//       catch(Exception ex){
//           tx.rollback();
//           throw new Exception (ex);
//       }
//    }

    public void saveMovimientoCaja(Stores movim) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new StoreBO().saveMovimientoCaja(movim);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

//    public List<Cliente> getAllClientes() throws Exception {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            clientes = new ClienteBO().getAllClientes();
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }

    public void updateMovimientoCaja(Stores movim) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new StoreBO().updateMovimientoCaja(movim);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public void deleteMovimientoCaja(Stores movim) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new StoreBO().deleteMovimientoCaja(movim);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
//    public List<Cliente> getClienteByPagina(int paginaActual) throws Exception{
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            clientes = new ClienteBO().getClienteByPagina(paginaActual);
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
    
//    public int getClientesCount() throws Exception{
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        int count = 0;
//        try{
//            count = new ClienteBO().getClientesCount();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return count;
//    }
    
//    public List<Cliente> getClienteOrdenado() throws Exception{
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            clientes = new ClienteBO().getClientesOrdenado();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
    
//    public List<Cliente> getClientesByFiltro(String filtro) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Cliente> clientes = null;
//        try{
//            clientes = new ClienteBO().getClientesByFiltro(filtro);
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
    
    
//    public void saveListaClientes(List<Cliente> listaClientes) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new ClienteBO().saveListaClientes(listaClientes);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
    
}
