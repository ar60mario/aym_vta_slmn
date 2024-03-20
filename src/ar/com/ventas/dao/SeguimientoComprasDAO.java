/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.ventas.dao;

import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.SeguimientoCompras;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mar y Mar Informatica
 */
public class SeguimientoComprasDAO extends GenericoDAO{


    public SeguimientoCompras getByComprobante(ComprobanteCompras cc) {
        SeguimientoCompras sc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(SeguimientoCompras.class);
        criteria.add(Restrictions.eq("comprobante", cc));
        sc = (SeguimientoCompras) criteria.uniqueResult();
        return sc;
    }
//    
//    public List<Cliente> getAllClientesOrdenado() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.addOrder(Order.asc("razonSocial"));
//        return (List<Cliente>) criteria.list();
//    }
//    
//    public List<Cliente> getClientesByFiltro(String filtro) {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
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
//    
//    public List<Cliente> getAllClientesOrdenadoPorNumero() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.addOrder(Order.asc("codigo"));
//        return (List<Cliente>) criteria.list();
//    }
//    
//    public List<Cliente> getClientesDeudores() {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        StringBuffer sb = new StringBuffer();
//        sb.append("from Cliente clie ");
//        sb.append("where clie.saldo > 0.0");
//        Query query = session.createQuery(sb.toString());
//        clientes = (List<Cliente>) query.list();
//        return clientes;
//    }
//    
//    public List<Cliente> getAllClientesConSaldo() {
//        List<Cliente> clientes = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        StringBuffer sb = new StringBuffer();
//        sb.append("from Cliente clie ");
//        sb.append("where clie.saldo != 0.00");
//        Query query = session.createQuery(sb.toString());
//        clientes = (List<Cliente>) query.list();
//        return clientes;
//    }
//    
//    public List<Cliente> getByVendedor(Vendedor vendedor) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Cliente.class);
//        criteria.add(Restrictions.eq("vendedor", vendedor));
//        criteria.addOrder(Order.asc("codigo"));
//        List<Cliente> clientes = (List<Cliente>) criteria.list();
//        return clientes;
//    }
}
