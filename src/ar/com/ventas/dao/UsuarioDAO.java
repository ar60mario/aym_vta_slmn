/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.ventas.dao;

import ar.com.ventas.entities.Usuario;
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
public class UsuarioDAO extends GenericoDAO{

    public Usuario getByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        Usuario usuario = (Usuario) criteria.uniqueResult();
        return usuario;
    }
    
    public <T> List getAllOrdenado(Class<T> clase) throws HibernateException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(clase);
        criteria.addOrder(Order.asc("codigo"));
        return criteria.list();
    }
}
