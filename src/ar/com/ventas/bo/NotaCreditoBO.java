/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.NotaCreditoDAO;
import ar.com.ventas.entities.Rental;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class NotaCreditoBO {
    private final NotaCreditoDAO dao = new NotaCreditoDAO();
    private static final Logger logger = Logger.getLogger("NotaCreditoBO");
    public Rental saveRenglon(Rental renglon) throws Exception{
        try{
            dao.save(renglon);            
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return renglon;
    }

}
