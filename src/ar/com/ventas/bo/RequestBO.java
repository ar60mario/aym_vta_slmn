/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.RequestDAO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Request;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Marcela
 */
public class RequestBO {
    
    private final RequestDAO dao = new RequestDAO();
    
    private static final Logger logger = Logger.getLogger("RequestBO");
    
    
    public Request saveRequest(Request request) throws Exception{
        try{
          dao.save(request);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return request;
    }

    public List<Request> getAllRequests() throws Exception {
        
        List<Request> listRequests = null;
        
        try{
            listRequests = dao.getAll(Request.class);			
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return listRequests;
    }

    public List<Request> getAllRequestsByCodigoYFecha() throws Exception {
        List<Request> listRequests = null;
        try{
            listRequests = dao.getAll(Request.class);			
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return listRequests;
    }

    public List<Request> getAllRequestsByCliente(Customer cliente) throws Exception  {
        List<Request> listRequests = null;
        try{
            listRequests = dao.getAllRequestsByCliente(cliente);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return listRequests;
    }
    
    public void updateRequest(Request request) throws Exception {
        try{
            request = (Request) dao.update(request);        
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        
    }
    
    public List<Request> getAllRequestsDisponiblesByCliente(Customer cliente) throws Exception  {
        List<Request> listRequests = null;
        try{
            listRequests = dao.getAllRequestsDisponiblesByCliente(cliente);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return listRequests;
    }
    
    public List<Request> getRequestsDisponiblesByClienteAndFecha(Customer cliente, Date fDe, Date fAl) throws Exception  {
        List<Request> listRequests = null;
        try{
            listRequests = dao.getRequestDisponiblesByClienteAndFechas(cliente, fDe, fAl);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return listRequests;
    }
    
    public List<Request> getRequestsTodosByClienteAndFecha(Customer cliente, Date fDe, Date fAl) throws Exception  {
        List<Request> listRequests = null;
        try{
            listRequests = dao.getRequestTodosByClienteAndFechas(cliente, fDe, fAl);
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return listRequests;
    }
    
    public List<Request> getAllRequestsDisponibles() throws Exception  {
        List<Request> listRequests = null;
        try{
            listRequests = dao.getAllRequestDisponibles();
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return listRequests;
    }
}
