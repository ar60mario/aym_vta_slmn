package ar.com.ventas.bo;

import ar.com.ventas.dao.ReciboDAO;
import ar.com.ventas.entities.Recibo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

public class ReciboBO {

    private final ReciboDAO dao = new ReciboDAO();
    private static final Logger logger = Logger.getLogger("ReciboBO");

    public Recibo saveRecibo(Recibo recibo) throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Integer hora = cal.get(Calendar.HOUR_OF_DAY);
        Integer minuto = cal.get(Calendar.MINUTE);
        Integer segundo = cal.get(Calendar.SECOND);
        recibo.setHora(hora);
        recibo.setMinuto(minuto);
        recibo.setSegundo(segundo);
        try {
            dao.save(recibo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibo;
    }

    public void deleteRecibo(Recibo recibo) throws Exception {
        try {
            dao.delete(recibo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return;
    }

    public Recibo updateRecibo(Recibo recibo) throws Exception {
        try {
            dao.update(recibo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibo;
    }

    public Recibo getReciboById(Long iv) throws Exception {
        Recibo recibo = null;
        try {
            recibo = (Recibo) dao.getById(Recibo.class, iv);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibo;
    }

    public List<Recibo> getRecibosByDia(Date fecha) throws Exception {
        List<Recibo> recibos = null;
        try {
            recibos = (List<Recibo>) dao.getRecibosByDia(fecha);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return recibos;
    }
}
