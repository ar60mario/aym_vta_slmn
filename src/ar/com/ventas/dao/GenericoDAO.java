/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.ventas.dao;

import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author Mar y Mar Informatica
 */
public class GenericoDAO {
    
    public Object getById(Class clase, Long id) throws HibernateException{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Object obj = session.createCriteria(clase)
                            .add(Restrictions.eq("id", id))
                                .uniqueResult();
        return obj;
    }
    
    public Object getById2(Class clase, Integer id) throws HibernateException{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Object obj = session.createCriteria(clase)
                            .add(Restrictions.eq("id", id))
                                .uniqueResult();
        return obj;
    }
    
    public Object save(Object anObj) throws HibernateException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.save(anObj);
        return anObj;
    }
    
    public Object update(Object anObj) throws HibernateException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.update(anObj);
        return anObj;
    }
    
    public void delete(Object anObj) throws HibernateException {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        session.delete(anObj);
    }
    
    public <T>List getAll(Class<T> clase, int start) throws HibernateException{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        
    //    Query query = session.createQuery("from "+clase.getSimpleName() + " "
    //    + "order by codigo asc");
        List<T> list = (List<T>)session.createCriteria(clase)
                .setFirstResult(start)
//                .setMaxResults(Constantes.MAX_RESULTS)
                .list();
        return list;
        
    }
    
    public <T>List getAll(Class<T> clase) throws HibernateException{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        
        List<T> list = (List<T>)session.createCriteria(clase).list();
        return list;
    }
    
    public int getCount(Class clase) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        
        int count = ((Number) session.createCriteria(clase).setProjection(Projections.rowCount()).uniqueResult()).intValue();        
        
        return count;
    }
}
