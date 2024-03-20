/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.RcCoDAO;
import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.RcCo;
import ar.com.ventas.entities.ReciboProveedor;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class RcCoBO {
    
    private final RcCoDAO dao = new RcCoDAO();
    private static final Logger logger = Logger.getLogger("RcCoBO");
    
    public RcCo saveRecibo(RcCo recibo) throws Exception{
        try{
          dao.save(recibo);            
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return recibo;
    }
    
    public void deleteRecibo(RcCo recibo) throws Exception{
        try{
          dao.delete(recibo);            
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
    }
    
    public RcCo getReciboById(Long iv) throws Exception {
        RcCo recibo = null;
        try {
            recibo = (RcCo) dao.getById(RcCo.class, iv);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibo;
    }
    //getRcCoByComprobante
    public List<RcCo> getRcCoByComprobante(ComprobanteCompras cc) throws Exception {
        List<RcCo> recibos = null;
        try {
            recibos = dao.getRcCoByComprobante(cc);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<RcCo> getRcCoByRecibo(ReciboProveedor rp) throws Exception {
        List<RcCo> recibos = null;
        try {
            recibos = dao.getRcCoByRecibo(rp);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibos;
    }
    
    public List<RcCo> getRcCoByNotaCredito(ComprobanteCompras cc) throws Exception {
        List<RcCo> recibos = null;
        try {
            recibos = dao.getRcCoByNotaCredito(cc);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibos;
    }
}
