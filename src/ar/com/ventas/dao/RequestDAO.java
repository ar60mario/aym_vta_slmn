/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Request;
import ar.com.ventas.util.HibernateUtil;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcela
 */
public class RequestDAO extends GenericDAO{

    public List<Request> getAllRequestsByCliente(Customer cliente) {
        List<Request> requests = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Request pe ");
        sb.append("where pe.cliente = :cliente");
//        sb.append("order by iv.fecha asc");
        Query query = session.createQuery(sb.toString());
        query.setParameter("cliente", cliente);
        requests = (List<Request>) query.list();
        return requests;
    }
    
    public List<Request> getAllRequestsDisponiblesByCliente(Customer cliente) {
        List<Request> requests = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Request pe ");
        sb.append("where pe.cliente = :cliente");
        sb.append(" and pe.facturado = false");
//        sb.append("order by iv.fecha asc");
        Query query = session.createQuery(sb.toString());
        query.setParameter("cliente", cliente);
        requests = (List<Request>) query.list();
        return requests;
    }
    
    public List<Request> getRequestDisponiblesByClienteAndFechas(Customer cli, Date fde, Date fal) {
        List<Request> request = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        request = (List<Request>) 
                session.createCriteria(Request.class)
                        .add(Restrictions.eq("cliente", cli))
                        .add(Restrictions.eq("facturado", false))
                        .add(Restrictions.between("fecha", fde, fal))
                        .list();
        return request;
    }
    
    public List<Request> getRequestTodosByClienteAndFechas(Customer cli, Date fde, Date fal) {
        List<Request> request = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        request = (List<Request>) 
                session.createCriteria(Request.class)
                        .add(Restrictions.eq("cliente", cli))
                        .add(Restrictions.between("fecha", fde, fal))
                        .list();
        return request;
    }
    
    public List<Request> getAllRequestDisponibles() {
        List<Request> request = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        request = (List<Request>) 
                session.createCriteria(Request.class)
                        .add(Restrictions.eq("facturado", false))
                        .list();
        return request;
    }
}
