/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Recibo;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author Marcela
 */
public class ReciboDAO extends GenericoDAO{
    
    public List<Recibo> getRecibosByDia(Date fecha){
        List<Recibo> recibos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        recibos = (List<Recibo>)
                session.createCriteria(Recibo.class)
                .add(Restrictions.eq("fecha", fecha))
                .addOrder(Order.asc("numero"))
                        .list();
        return recibos;
        
    }
}
