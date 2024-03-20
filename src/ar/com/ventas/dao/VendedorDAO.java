/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.ventas.dao;

import ar.com.ventas.entities.Vendedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrador
 */
public class VendedorDAO extends GenericoDAO{

    public Vendedor getByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Vendedor.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        Vendedor vendedor = (Vendedor) criteria.uniqueResult();
        return vendedor;
    }
    
    public <T> List getAllOrdenado(Class<T> clase) throws HibernateException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(clase);
        criteria.addOrder(Order.asc("codigo"));
        return criteria.list();
    }
}
