/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.PaymentDAO;
import ar.com.ventas.entities.Payment;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class PaymentBO {
    
    private final PaymentDAO dao = new PaymentDAO();
    private static final Logger logger = Logger.getLogger("PaymentBO");
    
    public Payment savePayment(Payment payment) throws Exception{
        try{
          dao.save(payment);            
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return payment;
    }
    
    public Payment updatePayment(Payment payment) throws Exception{
        try{
          dao.update(payment);            
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return payment;
    }
    
    public Payment getPaymentById(Long iv) throws Exception {
        Payment payment = null;
        try {
            payment = (Payment) dao.getById(Payment.class, iv);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return payment;
    }
    
    public List<Payment> getPaymentByDia(Date fecha) throws Exception {
        List<Payment> recibis = null;
        try {
            recibis = (List<Payment>) dao.getPaymentByDia(fecha);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibis;
    }
}
