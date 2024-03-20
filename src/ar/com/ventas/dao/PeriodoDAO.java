/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Periodo;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class PeriodoDAO extends GenericoDAO {

    public Periodo getPeriodoByFecha(Integer mes, Integer anio) {
        Periodo per = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Periodo.class);
        criteria.add(Restrictions.eq("mes", mes));
        criteria.add(Restrictions.eq("anio", anio));
        per = (Periodo) criteria.uniqueResult();
        return per;
    }
    
    public List<Periodo> getAllPeriodosAbiertos(){
        List<Periodo> ps = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Periodo.class);
        criteria.add(Restrictions.eq("cerrado", false));
        ps = (List<Periodo>) criteria.list();
        return ps;
    }
}
