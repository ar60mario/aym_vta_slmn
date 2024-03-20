/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.ventas.dao;

import ar.com.ventas.entities.Proveedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrador
 */
public class ProveedorDAO extends GenericoDAO{
    
    public List<Proveedor> getProveedoresByFiltro(String filtro) {
        List<Proveedor> proveedores = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        
        StringBuffer sb = new StringBuffer();
        sb.append("from Proveedor prove ");
        sb.append("where prove.razonSocial like :filtro ");
        sb.append("order by prove.razonSocial asc");

        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%"+filtro+"%");
        proveedores = (List<Proveedor>) query.list();
        return proveedores;
    }
    
    public Proveedor getByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Proveedor.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        
        Proveedor prove = (Proveedor) criteria.uniqueResult();
        return prove;
    }
    
    public Proveedor getById(Long codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Proveedor.class);
        criteria.add(Restrictions.eq("id", codigo));
        Proveedor prove = (Proveedor) criteria.uniqueResult();
        return prove;
    }
    
    public List<Proveedor> getAllProveedoresActivosByCodigo(){
        List<Proveedor> p=null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Proveedor.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("codigo"));
        p = (List<Proveedor>) criteria.list();
        return p;
    }
    
    public List<Proveedor> getAllProveedoresActivosByNombre(){
        List<Proveedor> p=null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Proveedor.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.addOrder(Order.asc("razonSocial"));
        p = (List<Proveedor>) criteria.list();
        return p;
    }
    
    public List<Proveedor> getProveedoresConSaldoAcreedor(){
        List<Proveedor> p=null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Proveedor.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.gt("saldo", 0.0));
        criteria.addOrder(Order.asc("razonSocial"));
        p = (List<Proveedor>) criteria.list();
        return p;
    }
    
    public List<Proveedor> getProveedoresConSaldoAcreedorLimite(Double limite){
        List<Proveedor> p=null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Proveedor.class);
        criteria.add(Restrictions.eq("activo", true));
        criteria.add(Restrictions.gt("saldo", limite));
        criteria.addOrder(Order.asc("razonSocial"));
        p = (List<Proveedor>) criteria.list();
        return p;
    }
}
