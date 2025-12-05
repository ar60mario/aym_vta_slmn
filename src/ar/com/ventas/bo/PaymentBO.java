package ar.com.ventas.bo;

import ar.com.ventas.dao.PaymentDAO;
import ar.com.ventas.entities.Payment;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

public class PaymentBO {
    
    private final PaymentDAO dao = new PaymentDAO();
    private static final Logger logger = Logger.getLogger("PaymentBO");
    
    public Payment savePayment(Payment payment) throws Exception{
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Integer hora = cal.get(Calendar.HOUR_OF_DAY);
        Integer minuto = cal.get(Calendar.MINUTE);
        Integer segundo = cal.get(Calendar.SECOND);
        payment.setHora(hora);
        payment.setMinuto(minuto);
        payment.setSegundo(segundo);
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
