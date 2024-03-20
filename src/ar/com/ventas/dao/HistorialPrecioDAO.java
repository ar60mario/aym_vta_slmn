/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.HistorialPrecio;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.criterion.Order;

/**
 *
 * @author Mar y Mar Informatica
 */
public class HistorialPrecioDAO extends GenericoDAO {

    public List<HistorialPrecio> getByProducto(Producto p) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(HistorialPrecio.class);
        criteria.add(Restrictions.eq("producto", p));
        criteria.addOrder(Order.desc("id"));
        List<HistorialPrecio> hp = (List<HistorialPrecio>) criteria.list();
        return hp;
    }
}
