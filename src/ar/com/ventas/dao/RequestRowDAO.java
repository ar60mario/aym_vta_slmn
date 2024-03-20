/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Request;
import ar.com.ventas.entities.RequestRow;
import ar.com.ventas.util.HibernateUtil;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class RequestRowDAO extends GenericDAO {
    
    public List<RequestRow> getRequestRowFromRequest(Request request) {
        List<RequestRow> renglonRequest = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RequestRow.class);
        criteria.add(Restrictions.eq("request", request));
//        
//        StringBuffer sb = new StringBuffer();
//        sb.append("from RequestRow rp ");
//        sb.append("where rp.request = :request ");
//        Query query = session.createQuery(sb.toString());
//        query.setParameter("request",  request );
        renglonRequest = (List<RequestRow>) criteria.list();
        return renglonRequest;
    }

}
