/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.RcCo;
import ar.com.ventas.entities.ReciboProveedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author Marcela
 */
public class RcCoDAO extends GenericoDAO{
    
    public List<RcCo> getRcCoByComprobante(ComprobanteCompras cc){
        List<RcCo> rco = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RcCo.class);
        criteria.add(Restrictions.eq("comprobanteCompras", cc));
        rco = (List<RcCo>) criteria.list();
        return rco;
    }
    
    public List<RcCo> getRcCoByRecibo(ReciboProveedor rp){
        List<RcCo> rco = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RcCo.class);
        criteria.add(Restrictions.eq("reciboProveedor", rp));
        rco = (List<RcCo>) criteria.list();
        return rco;
    }
    
    public List<RcCo> getRcCoByNotaCredito(ComprobanteCompras cc){
        List<RcCo> rco = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(RcCo.class);
        criteria.add(Restrictions.eq("notaCredito", cc));
        rco = (List<RcCo>) criteria.list();
        return rco;
    }
}
