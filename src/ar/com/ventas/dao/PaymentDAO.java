/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Payment;
import ar.com.ventas.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcela
 */
public class PaymentDAO extends GenericDAO{
    

    public List<Payment> getPaymentByDia(Date fecha){
        List<Payment> recibos = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        recibos = (List<Payment>)
                session.createCriteria(Payment.class)
                .add(Restrictions.eq("fecha", fecha))
                .addOrder(Order.asc("numero"))
                        .list();
        return recibos;
        
    }
    
}
