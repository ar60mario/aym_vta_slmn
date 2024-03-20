package ar.com.ventas.services;

import ar.com.ventas.bo.ClienteBO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Vendedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteService {
    
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
    
    public List<Cliente> getAllClientesActivos() throws Exception {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            clientes = new ClienteBO().getAllClientesActivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public Integer getCantidad() throws Exception {
        Integer can = 0;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            can = new ClienteBO().getCantidad();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return can;
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
    
    public List<Cliente> getAllClientesOrdenadoByPagina(Integer pagina, Integer limite) throws Exception{
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            clientes = new ClienteBO().getAllClientesOrdenadoByPagina(pagina, limite);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getUltimos(Integer orden, Integer limite) throws Exception{
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            clientes = new ClienteBO().getUltimos(orden, limite);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getUltimosByFiltro(String filtro, Integer orden, Integer limite) throws Exception{
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            clientes = new ClienteBO().getUltimosByFiltro(filtro, orden, limite);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public Long getUltimoId() throws Exception {
        long id = 0L;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            id = new ClienteBO().getUltimoId();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return id;
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
    
    public List<Cliente> getClientesByFiltroPaginado(String filtro, Integer pagina, Integer limite) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Cliente> clientes = null;
        try{
            clientes = new ClienteBO().getClientesByFiltroPaginado(filtro, pagina, limite);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getClientesComienzaByFiltro(String filtro, Integer pagina, Integer limite) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Cliente> clientes = null;
        try{
            clientes = new ClienteBO().getClientesComienzaByFiltro(filtro, pagina, limite);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getClientesByFiltroNumerico(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Cliente> clientes = null;
        try{
            clientes = new ClienteBO().getClientesByFiltroNumerico(filtro);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getClientesByFiltroNumericoPaginado(String filtro, Integer pagina, Integer limite) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Cliente> clientes = null;
        try{
            clientes = new ClienteBO().getClientesByFiltroNumericoPaginado(filtro, pagina, limite);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getClientesInactivosByFiltroOrdenado(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Cliente> clientes = null;
        try{
            clientes = new ClienteBO().getClientesInactivosByFiltroOrdenado(filtro);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public void saveListaClientes(List<Cliente> listaClientes) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ClienteBO().saveListaClientes(listaClientes);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<Cliente> getClienteOrdenadoPorNumero() throws Exception{
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            clientes = new ClienteBO().getClientesOrdenadoPorNumero();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getClientesOrdenadoPorNumeroPaginado(Integer pagina, Integer limite) throws Exception{
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            clientes = new ClienteBO().getClientesOrdenadoPorNumeroPaginado(pagina, limite);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getClienteDeudores() throws Exception{
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            clientes = new ClienteBO().getClientesDeudores();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getAllClienteConSaldo() throws Exception{
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            clientes = new ClienteBO().getAllClientesConSaldo();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getClientesConSaldoInactivos() throws Exception{
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            clientes = new ClienteBO().getClientesConSaldoInactivos();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
    
    public List<Cliente> getByVendedor(Vendedor vendedor) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Cliente> clientes = null;
        try {
            clientes = new ClienteBO().getByVendedor(vendedor);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return clientes;
    }
}
