/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.CtaCteCliente;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.util.HibernateUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class CtaCteClienteDAO extends GenericoDAO {

    public CtaCteCliente getUltimoMovimientoPorDia(Cliente cli, Date f) {
        CtaCteCliente ccc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Query query = session.createQuery("SELECT MAX(id) from CtaCteCliente ccl and ccl.cliente = :cli order by id desc limit 1");
//        query.setParameter("cli", cli);
//        ctaCteCliente = (CtaCteCliente) query.uniqueResult();
        Criteria criteria = session.createCriteria(CtaCteCliente.class);
        criteria.add(Restrictions.eq("cliente", cli));
        criteria.add(Restrictions.or(Restrictions.eq("fecha", f),Restrictions.lt("fecha", f)));
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(1);
        ccc = (CtaCteCliente) criteria.list().get(0);
        return ccc;
    }
    
    public CtaCteCliente getUltimoMovimientoPorAntes(Cliente cli, Date f) {
        CtaCteCliente ccc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Query query = session.createQuery("SELECT MAX(id) from CtaCteCliente ccl and ccl.cliente = :cli order by id desc limit 1");
//        query.setParameter("cli", cli);
//        ctaCteCliente = (CtaCteCliente) query.uniqueResult();
        Criteria criteria = session.createCriteria(CtaCteCliente.class);
        criteria.add(Restrictions.eq("cliente", cli));
        criteria.add(Restrictions.lt("fecha", f));
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(1);
        ccc = (CtaCteCliente) criteria.list().get(0);
        return ccc;
    }
    
    
    public CtaCteCliente getUltimoMovimiento(Cliente cli) {
        CtaCteCliente ccc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Query query = session.createQuery("SELECT MAX(id) from CtaCteCliente ccl and ccl.cliente = :cli order by id desc limit 1");
//        query.setParameter("cli", cli);
//        ctaCteCliente = (CtaCteCliente) query.uniqueResult();
        Criteria criteria = session.createCriteria(CtaCteCliente.class);
        criteria.add(Restrictions.eq("cliente", cli));
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(1);
        ccc = (CtaCteCliente) criteria.list().get(0);
        return ccc;
    }

    public List<CtaCteCliente> getCtaCteClienteByClienteAndFecha(Cliente cli, Date fechaDe, Date fechaA) {
        List<CtaCteCliente> ctaCteCliente = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        ctaCteCliente = (List<CtaCteCliente>) session.createCriteria(CtaCteCliente.class)
                .add(Restrictions.eq("cliente", cli))
                .add(Restrictions.between("fecha", fechaDe, fechaA))
                .list();
        return ctaCteCliente;
    }
    
    public List<CtaCteCliente> getCtaCteClienteByFecha(Date fecha) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date fInicio = new Date();
//        try {
//            fInicio = sdf.parse("16/09/2022");
//        } catch (ParseException ex) {
//            Logger.getLogger(InventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        List<CtaCteCliente> ctaCteCliente = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        ctaCteCliente = (List<CtaCteCliente>) session.createCriteria(CtaCteCliente.class)
                .add(Restrictions.between("fecha", fecha, fecha))
                .add(Restrictions.eq("tipo", "RC"))
//                .addOrder(Order.asc("cliente"))
//                .addOrder(Order.asc("id"))
                .list();
        return ctaCteCliente;
    }

    public CtaCteCliente getMovimientoByIvaVentas(IvaVentas iv) {
        CtaCteCliente ccc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from CtaCteCliente ccl ");
        sb.append("where ccl.factura = :iv ");

        Query query = session.createQuery(sb.toString());
        query.setParameter("iv", iv);

        ccc = (CtaCteCliente) query.uniqueResult();
        return ccc;
    }

    public CtaCteCliente getMovimientoById(Long id) {
        CtaCteCliente ccc = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from CtaCteCliente ccl ");
        sb.append("where ccl.id = :id ");

        Query query = session.createQuery(sb.toString());
        query.setParameter("id", id);

        ccc = (CtaCteCliente) query.uniqueResult();
        return ccc;
    }
    
    public List<CtaCteCliente> getTodaCtaCteClienteByCliente(Cliente cli) {
        List<CtaCteCliente> ctaCteCliente = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        ctaCteCliente = (List<CtaCteCliente>) session.createCriteria(CtaCteCliente.class)
                .add(Restrictions.eq("cliente", cli))
                .addOrder(Order.asc("id"))
                .list();
        return ctaCteCliente;
    }
}
