/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.RequestRowBO;
import ar.com.ventas.entities.Request;
import ar.com.ventas.entities.RequestRow;
import ar.com.ventas.util.HibernateUtil;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class RequestRowService {
    
    public List<RequestRow> getAllRenglonRequestFromRequest(Request request) throws Exception {
        List<RequestRow> renglonRequest = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            renglonRequest = new RequestRowBO().getAllRequestRowFromRequest(request);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return renglonRequest;
    }
}
