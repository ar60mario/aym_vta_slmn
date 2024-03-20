/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.util.HibernateUtil;
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
public class InventoryDAO extends GenericDAO {

    public Inventory getUltimoMovimientoPorDia(Customer c, Date f) {
        Inventory ccc = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Inventory.class);
        criteria.add(Restrictions.eq("cliente", c));
        criteria.add(Restrictions.or(Restrictions.eq("fecha", f),Restrictions.lt("fecha",f)));
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(1);
        if (!criteria.list().isEmpty()) {
            ccc = (Inventory) criteria.list().get(0);
        }
        return ccc;
    }
    
    public Inventory getUltimoMovimiento(Customer cli) {
        Inventory ccc = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Inventory.class);
        criteria.add(Restrictions.eq("cliente", cli));
        criteria.addOrder(Order.desc("id"));
        criteria.setFirstResult(0);
        criteria.setMaxResults(1);
        if (!criteria.list().isEmpty()) {
            ccc = (Inventory) criteria.list().get(0);
        }
        return ccc;
    }

    public List<Inventory> getInventoryByFiltro(Customer cli, Date fechaDe, Date fechaA) {
        List<Inventory> inventory = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Inventory ccc ");
        sb.append("where ccc.cliente = :cli ");
        //sb.append("and ccc.fecha >= :fechaDe ");
        //sb.append("and ccc.fecha <= :fechaA ");
        sb.append("order by ccc.fecha");
        Query query = session.createQuery(sb.toString());
        query.setParameter("cli", cli);
        //query.setParameter("fechaDe", fechaDe);
        //query.setParameter("fechaA", fechaA);

        inventory = (List<Inventory>) query.list();

        return inventory;
    }

    public List<Inventory> getAllCtaCteCliente() {
        List<Inventory> ctaCteCliente = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        ctaCteCliente = (List<Inventory>) session.createCriteria(Inventory.class)
                .addOrder(Order.asc("fecha"))
                .list();
        return ctaCteCliente;
    }

    public List<Inventory> getAllCtaCteByCodigoAndFecha(Customer cli, Date fechaDe, Date fechaA) {
        List<Inventory> ctaCteCliente = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        ctaCteCliente = (List<Inventory>) session.createCriteria(Inventory.class)
                .add(Restrictions.eq("cliente", cli))
                .add(Restrictions.between("fecha", fechaDe, fechaA))
                .list();
        return ctaCteCliente;
    }

    public List<Inventory> getCtaCtePorFecha(Date fecha) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date fInicio = new Date();
//        try {
//            fInicio = sdf.parse("16/09/2022");
//        } catch (ParseException ex) {
//            Logger.getLogger(InventoryDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        List<Inventory> ctaCteCliente = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        ctaCteCliente = (List<Inventory>) session.createCriteria(Inventory.class)
                .add(Restrictions.between("fecha", fecha, fecha))
                .add(Restrictions.eq("tipo", "RC"))
//                .addOrder(Order.asc("cliente"))
//                .addOrder(Order.asc("id"))
                .list();
        return ctaCteCliente;
    }
}
