/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.ReciboProveedorDAO;
import ar.com.ventas.entities.Proveedor;
import ar.com.ventas.entities.ReciboProveedor;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class ReciboProveedorBO {
    
    private final ReciboProveedorDAO dao = new ReciboProveedorDAO();
    private static final Logger logger = Logger.getLogger("ReciboProveedorBO");
    
    public ReciboProveedor saveReciboProveedor(ReciboProveedor recibo) throws Exception{
        try{
          dao.save(recibo);            
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public ReciboProveedor updateReciboProveedor(ReciboProveedor recibo) throws Exception{
        try{
          dao.update(recibo);            
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public void deleteReciboProveedor(ReciboProveedor recibo) throws Exception{
        try{
          dao.delete(recibo);            
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
    }
    
    public ReciboProveedor getReciboProveedorById(Long iv) throws Exception {
        ReciboProveedor recibo = null;
        try {
            recibo = (ReciboProveedor) dao.getById(ReciboProveedor.class, iv);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public ReciboProveedor getReciboProveedorByNro(Integer nro, Proveedor p) throws Exception {
        ReciboProveedor recibo = null;
        try {
            recibo = (ReciboProveedor) dao.getReciboProveedorByNro(nro, p);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public List<ReciboProveedor> getRecibosEntreFechas(Date fd, Date fa) throws Exception {
        List<ReciboProveedor> recibos = null;
        try {
            recibos = dao.getRecibosEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibos;
    }
    //
    public List<ReciboProveedor> getRecibosByFechas(Date fd) throws Exception {
        List<ReciboProveedor> recibos = null;
        try {
            recibos = dao.getRecibosByFechas(fd);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosPorProveedorEntreFechas(Proveedor p, Date fd, Date fa) throws Exception {
        List<ReciboProveedor> recibos = null;
        try {
            recibos = dao.getRecibosPorProveedorEntreFechas(p, fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosPorProveedor(Proveedor p) throws Exception {
        List<ReciboProveedor> recibos = null;
        try {
            recibos = dao.getRecibosPorProveedor(p);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosPorProveedorImputados(Proveedor p) throws Exception {
        List<ReciboProveedor> recibos = null;
        try {
            recibos = dao.getRecibosPorProveedorImputados(p);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<ReciboProveedor> getRecibosPorProveedorNoImputados(Proveedor p) throws Exception {
        List<ReciboProveedor> recibos = null;
        try {
            recibos = dao.getRecibosPorProveedorNoImputados(p);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibos;
    }
}
