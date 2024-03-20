/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ar.com.ventas.dao;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ContadorCpbteStockDAO extends GenericoDAO{
    
//    public Configuracion getFacturas() {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Configuracion.class);
//        Configuracion facturas = (Configuracion) criteria;
//        return facturas;
//    }
    
//    public Configuracion getFacturasById(Configuracion config, Integer id){
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Configuracion.class);
//        Configuracion facturas = (Configuracion) criteria;
//        return facturas;
//    }
    /*
    Update
    */

/*
    public Cliente getByCodigo(String codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        
        Cliente cliente = (Cliente) criteria.uniqueResult();
        return cliente;
    }
    
    public List<Cliente> getAllClientesOrdenado() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.addOrder(Order.asc("razonSocial"));
        return (List<Cliente>) criteria.list();
    }
    
    public List<Cliente> getClientesByFiltro(String filtro) {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        
        StringBuffer sb = new StringBuffer();
        sb.append("from Cliente clie ");
        sb.append("where clie.razonSocial like :filtro ");
        sb.append("order by clie.razonSocial asc");
        
        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%"+filtro+"%");
        
        clientes = (List<Cliente>) query.list();
                
        return clientes;
    }
}
    */
}
