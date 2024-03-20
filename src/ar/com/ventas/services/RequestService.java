/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.RequestBO;
import ar.com.ventas.bo.RequestRowBO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Request;
import ar.com.ventas.entities.RequestRow;
import ar.com.ventas.util.HibernateUtil;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcela
 */
public class RequestService {

    public void saveRequest(Request request) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RequestBO().saveRequest(request);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<Request> getAllRequests() throws Exception {

        List<Request> requests = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            requests = new RequestBO().getAllRequests();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return requests;

    }

        public void saveRequestCompleto(Request pe, List<RequestRow> rp) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        RequestBO peBO = new RequestBO();
        Request request = peBO.saveRequest(pe);
        Boolean bolean = true;
        for (RequestRow renglon : rp) {
            renglon.setRequest(request);
            try {
                RequestRowBO bo = new RequestRowBO();
                bo.saveRequestRow(renglon);
            } catch (Exception ex) {
                bolean = false;
                tx.rollback();
                throw new Exception(ex);
            }
        }
        if (bolean) {
            tx.commit();
        }
    }

    public List<Request> getAllRequestsByCliente(Customer cliente) throws Exception {
        List<Request> requests = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            requests = new RequestBO().getAllRequestsByCliente(cliente);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return requests;
    }
    
    public void updateRequest(Request request) throws Exception {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new RequestBO().updateRequest(request);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<Request> getAllRequestsDisponiblesByCliente(Customer cliente) throws Exception {
        List<Request> requests = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            requests = new RequestBO().getAllRequestsDisponiblesByCliente(cliente);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return requests;
    }
    
    public List<Request> getAllRequestsByCodigoYFecha(Customer cus, Date fechaDe, Date FechaA) throws Exception {
        List<Request> request = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            request = new RequestBO().getRequestsTodosByClienteAndFecha(cus, fechaDe, FechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return request;
    }

    public List<Request> getRequestsDisponiblesByCodigoYFecha(Customer cod, Date fechaDe, Date FechaA) throws Exception {
        List<Request> request = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            request = new RequestBO().getRequestsDisponiblesByClienteAndFecha(cod, fechaDe, FechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return request;
    }
    
    public List<Request> getRequestsTodosByCodigoYFecha(Customer cod, Date fechaDe, Date FechaA) throws Exception {
        List<Request> request = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            request = new RequestBO().getRequestsTodosByClienteAndFecha(cod, fechaDe, FechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return request;
    }
    
    public List<Request> getAllRequestsDisponibles() throws Exception {
        List<Request> request = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            request = new RequestBO().getAllRequestsDisponibles();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return request;
    }
}
