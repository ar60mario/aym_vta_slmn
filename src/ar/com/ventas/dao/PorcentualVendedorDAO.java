/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.PorcentualVendedor;
import ar.com.ventas.entities.Vendedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class PorcentualVendedorDAO  extends GenericoDAO{
    public List<PorcentualVendedor> getAllPorcentualByVendedor(Vendedor v){
        List<PorcentualVendedor> pv = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(PorcentualVendedor.class);
        criteria.add(Restrictions.eq("vendedor", v));
        //criteria.addOrder(Order.asc("razonSocial"));
        pv = criteria.list();
        return pv;
    }
}
