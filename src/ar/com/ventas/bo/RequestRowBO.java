/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.RequestRowDAO;
import ar.com.ventas.entities.Request;
import ar.com.ventas.entities.RequestRow;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class RequestRowBO {
    
    private final RequestRowDAO dao = new RequestRowDAO();

    private static final Logger logger = Logger.getLogger("RequestRowBO");
    
    public RequestRow saveRequestRow(RequestRow renglon) throws Exception {
        try {
            dao.save(renglon);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglon;
    }

    public List<RequestRow> getAllRequestRowFromRequest(Request request) throws Exception {
        List<RequestRow> listRequestRow = null;
        try {
            listRequestRow = dao.getRequestRowFromRequest(request);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listRequestRow;
    }

}
