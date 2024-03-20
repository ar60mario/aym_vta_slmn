/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Customer;
import ar.com.ventas.util.HibernateUtil;
//import org.hibernate.classic.Session;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Order;

/**
 *
 * @author Mar y Mar Informatica
 */
public class CustomerDAO extends GenericDAO {

    public Customer getByCodigo(String codigo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("codigo", codigo));

        Customer customer = (Customer) criteria.uniqueResult();
        return customer;
    }

    public List<Customer> getAllCustomersOrdenado() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        //criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("codigo"));
        return (List<Customer>) criteria.list();
    }

    public List<Customer> getAllCustomersInactivosOrdenado() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("codigo"));
        return (List<Customer>) criteria.list();
    }

    public List<Customer> getAllCustomersInactivosOrdByNombre() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.eq("activo", false));
        criteria.addOrder(Order.asc("codigo"));
        return (List<Customer>) criteria.list();
    }
    
    public List<Customer> getClientesDeudores() {
        List<Customer> clientes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Customer clie ");
        sb.append("where clie.saldo > 0.0");
        Query query = session.createQuery(sb.toString());
        clientes = (List<Customer>) query.list();
        return clientes;
    }

    public List<Customer> getAllClientesConSaldo() {
//        List<Customer> clientes = null;
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Customer.class);
//        criteria.add(Restrictions.ne("saldo", 0.0));
//        criteria.add(Restrictions.eq("activo", true));
//        clientes = (List<Customer>) criteria.list();
//        return clientes;
        List<Customer> clientes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Customer clie ");
        sb.append("where clie.saldo != 0.00 ");
        sb.append("and clie.activo = true ");
        Query query = session.createQuery(sb.toString());
        clientes = (List<Customer>) query.list();
        return clientes;
    }
    
    public List<Customer> getClientesConSaldoInactivos() {
        List<Customer> clientes = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Customer.class);
        criteria.add(Restrictions.ne("saldo", 0.0));
        criteria.add(Restrictions.eq("activo", false));
        clientes = (List<Customer>) criteria.list();
        return clientes;
    }
}
