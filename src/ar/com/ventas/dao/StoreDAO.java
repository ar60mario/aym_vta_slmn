/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Stores;
import ar.com.ventas.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mar y Mar Informatica
 */
public class StoreDAO extends GenericDAO {

    public Stores getByFecha(Date fecha) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Stores.class);
        criteria.add(Restrictions.eq("fecha", fecha));
        
        Stores movim = (Stores) criteria.uniqueResult();
        return movim;
    }

    public List<Stores> getCajasEntreFechas(Date f1, Date f2) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Stores.class);
        criteria.add(Restrictions.between("fecha", f1, f2));
        criteria.addOrder(Order.asc("fecha"));
        List<Stores> movim = (List<Stores>) criteria.list();
        return movim;
    }

//    public List<Cliente> getAllClientesOrdenado() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.addOrder(Order.asc("razonSocial"));
//        return (List<Cliente>) criteria.list();
//    }
//    public List<Cliente> getClientesByFiltro(String filtro) {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        
//        StringBuffer sb = new StringBuffer();
//        sb.append("from Cliente clie ");
//        sb.append("where clie.razonSocial like :filtro ");
//        sb.append("order by clie.razonSocial asc");
//        
//        Query query = session.createQuery(sb.toString());
//        query.setParameter("filtro", "%"+filtro+"%");
//        
//        clientes = (List<Cliente>) query.list();
//                
//        return clientes;
//    }
}
