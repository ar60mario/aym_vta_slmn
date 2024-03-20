/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Vendedor;
import ar.com.ventas.util.HibernateUtils;
//import org.hibernate.classic.Session;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.jdesktop.beansbinding.Validator;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ClienteDAO extends GenericoDAO {

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

    public List<Cliente> getAllClientesOrdenadoByPagina(Integer pagina, Integer limite) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.setFirstResult(pagina);
//        criteria.add(Restrictions.eq("activo", true));
        criteria.setMaxResults(limite);
        criteria.addOrder(Order.asc("razonSocial"));
        return (List<Cliente>) criteria.list();
    }

    public Long getUltimoId() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        //criteria.setFirstResult(pagina);
        criteria.addOrder(Order.desc("id"));
        criteria.setMaxResults(1);
        Cliente cli = (Cliente) criteria.uniqueResult();
        return cli.getId();
    }

    public List<Cliente> getUltimos(Integer orden, Integer limite) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        if (orden.equals(0)) {
            criteria.addOrder(Order.desc("razonSocial"));
        } else {
            criteria.addOrder(Order.desc("codigo"));
        }
        criteria.setFirstResult(0);
        criteria.setMaxResults(limite);
        List<Cliente> clientes = (List<Cliente>) criteria.list();
        return clientes;
    }

    public List<Cliente> getUltimosByFiltro(String filtro, Integer orden, Integer limite) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.like("razonSocial", "%" + filtro + "%"));
        if (orden.equals(0)) {
            criteria.addOrder(Order.desc("razonSocial"));
        } else {
            criteria.addOrder(Order.desc("codigo"));
        }
        criteria.setMaxResults(limite);
        List<Cliente> clientes = (List<Cliente>) criteria.list();
        return clientes;
    }

    public List<Cliente> getAllClientesActivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("activo", true));

        return (List<Cliente>) criteria.list();
    }

    public Integer getCantidad() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Query query = session.createQuery("select count(*) from Cliente cli");
//                + "where dc.consorcio.id = " + consorcio.getId());
        Integer can = query.getFirstResult();
        return can;
        //(List<DatosConsorcio>) query.list();
    }

    public List<Cliente> getClientesInactivosByFiltroOrdenado(String f) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.like("razonSocial", "%" + f + "%"));
        criteria.addOrder(Order.asc("razonSocial"));
        criteria.add(Restrictions.eq("inactivo", true));
        return (List<Cliente>) criteria.list();
    }

    public List<Cliente> getClientesByFiltro(String filtro) {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Cliente clie ");
        sb.append("where clie.razonSocial like :filtro ");
        sb.append("and clie.activo = true ");
        sb.append("order by clie.razonSocial asc");
        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%" + filtro + "%");
        clientes = (List<Cliente>) query.list();
        return clientes;
    }

    public List<Cliente> getClientesByFiltroPaginado(String f, Integer pagina, Integer limite) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.like("razonSocial", "%" + f + "%"));
        criteria.setFirstResult(pagina);
        criteria.setMaxResults(limite);
        criteria.addOrder(Order.asc("razonSocial"));
        return (List<Cliente>) criteria.list();
    }
    
    public List<Cliente> getClientesComienzaByFiltro(String f, Integer pagina, Integer limite) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.like("razonSocial", f + "%"));
        criteria.setFirstResult(pagina);
        criteria.setMaxResults(limite);
        criteria.addOrder(Order.asc("razonSocial"));
        return (List<Cliente>) criteria.list();
    }

    public List<Cliente> getClientesByFiltroNumerico(String filtro) {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Cliente clie ");
        sb.append("where clie.razonSocial like :filtro ");
        //sb.append("and clie.activo = false ");
        sb.append("order by clie.codigo asc");
        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%" + filtro + "%");
        clientes = (List<Cliente>) query.list();
        return clientes;
    }

    public List<Cliente> getAllClientesOrdenadoPorNumero() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.addOrder(Order.asc("codigo"));
        return (List<Cliente>) criteria.list();
    }

    public List<Cliente> getClientesByFiltroNumericoPaginado(String filtro, Integer pagina, Integer limite) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.like("razonSocial", "%" + filtro + "%"));
        criteria.setFirstResult(pagina);
        criteria.setMaxResults(limite);
        criteria.addOrder(Order.asc("codigo"));
        return (List<Cliente>) criteria.list();
    }

    public List<Cliente> getClientesOrdenadoPorNumeroPaginado(Integer pagina, Integer limite) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.setFirstResult(pagina);
        criteria.setMaxResults(limite);
        criteria.addOrder(Order.asc("codigo"));
        return (List<Cliente>) criteria.list();
    }

    public List<Cliente> getClientesDeudores() {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Cliente clie ");
        sb.append("where clie.saldo > 0.0");
        Query query = session.createQuery(sb.toString());
        clientes = (List<Cliente>) query.list();
        return clientes;
    }

    public List<Cliente> getAllClientesConSaldo() {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from Cliente clie ");
        sb.append("where clie.saldo != 0.00 ");
        sb.append("and clie.activo = true");
        Query query = session.createQuery(sb.toString());
        clientes = (List<Cliente>) query.list();
        return clientes;
    }

    public List<Cliente> getClientesConSaldoInactivos() {
        List<Cliente> clientes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.ne("saldo", 0.0));
        criteria.add(Restrictions.eq("activo", false));
        clientes = (List<Cliente>) criteria.list();
        return clientes;
    }

    public List<Cliente> getByVendedor(Vendedor vendedor) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("vendedor", vendedor));
        criteria.addOrder(Order.asc("codigo"));
        List<Cliente> clientes = (List<Cliente>) criteria.list();
        return clientes;
    }
}
