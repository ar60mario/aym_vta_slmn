package ar.com.ventas.services;

import ar.com.ventas.bo.CustomerBO;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerService {
    
    public Customer getCustomerByCodigo(String codigo) throws Exception{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Customer customer = null;
        try {
            customer = new CustomerBO().getCustomerByCodigo(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return customer;
    }
    
    public void deleteCustomer(Customer customer) throws Exception{
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       Transaction tx = session.beginTransaction();
       try{
          new CustomerBO().deleteCustomer(customer);
          tx.commit();
       }
       catch(Exception ex){
           tx.rollback();
           throw new Exception (ex);
       }
    }

    public Customer saveCustomer(Customer customer) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            customer = new CustomerBO().saveCustomer(customer);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return customer;
    }

    public List<Customer> getAllCustomers() throws Exception {
        List<Customer> customers = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            customers = new CustomerBO().getAllCustomers();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return customers;
    }

    public void updateCustomer(Customer customer) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new CustomerBO().updateCustomer(customer);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<Customer> getCustomerByPagina(int paginaActual) throws Exception{
        List<Customer> customers = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            customers = new CustomerBO().getCustomerByPagina(paginaActual);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return customers;
    }
    
    public int getCustomersCount() throws Exception{
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        int count = 0;
        try{
            count = new CustomerBO().getCustomersCount();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return count;
    }
    
    public List<Customer> getCustomerOrdenado() throws Exception{
        List<Customer> customers = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            customers = new CustomerBO().getCustomersOrdenado();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return customers;
    }
    
    public void saveListaCustomers(List<Customer> listaCustomers) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new CustomerBO().saveListaCustomers(listaCustomers);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<Customer> getCustomersDeudores() throws Exception{
        List<Customer> customers = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            customers = new CustomerBO().getClientesDeudores();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return customers;
    }
    
    public List<Customer> getAllCustomersConSaldo() throws Exception{
        List<Customer> customers = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            customers = new CustomerBO().getAllClientesConSaldo();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return customers;
    }
    
    public List<Customer> getClientesConSaldoInactivos() throws Exception{
        List<Customer> customers = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            customers = new CustomerBO().getClientesConSaldoInactivos();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return customers;
    }
    
    public List<Customer> getAllCustomersInactivosOrdenado() throws Exception{
        List<Customer> customers = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try{
            customers = new CustomerBO().getAllCustomersInactivosOrdenado();
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return customers;
    }
}
