package ar.com.ventas.services;

import ar.com.ventas.bo.SeguimientoComprasBO;
import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.SeguimientoCompras;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SeguimientoComprasService {
    
    public SeguimientoCompras getByComprobante(ComprobanteCompras cc) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        SeguimientoCompras sc = null;
        try {
            sc = new SeguimientoComprasBO().getByComprobante(cc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return sc;
    }
//    
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
    public SeguimientoCompras updateSeguimientoCompras(SeguimientoCompras sc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new SeguimientoComprasBO().updateSeguimiento(sc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return sc;
    }
    
    public void deleteSeguimientoCompras(SeguimientoCompras sc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new SeguimientoComprasBO().deleteSeguimiento(sc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return;
    }
    
    public SeguimientoCompras saveSeguimientoCompras(SeguimientoCompras sc) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new SeguimientoComprasBO().saveSeguimiento(sc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return sc;
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
//
//    public void updateCliente(Cliente cliente) throws Exception {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            new ClienteBO().updateCliente(cliente);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//    }
//    
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
//    
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
//    
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
//    
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
//    
//    
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
//    
//    public List<Cliente> getClienteOrdenadoPorNumero() throws Exception{
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            clientes = new ClienteBO().getClientesOrdenadoPorNumero();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public List<Cliente> getClienteDeudores() throws Exception{
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            clientes = new ClienteBO().getClientesDeudores();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public List<Cliente> getAllClienteConSaldo() throws Exception{
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try{
//            clientes = new ClienteBO().getAllClientesConSaldo();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
//    
//    public List<Cliente> getByVendedor(Vendedor vendedor) throws Exception{
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<Cliente> clientes = null;
//        try {
//            clientes = new ClienteBO().getByVendedor(vendedor);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return clientes;
//    }
}
