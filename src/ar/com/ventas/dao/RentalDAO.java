/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rental;
import ar.com.ventas.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcela
 */
public class RentalDAO extends GenericDAO{
    
    
    public List<Rental> getRentalFromIvaVentas(Activity factura) {
        List<Rental> rental = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Rental.class);
        criteria.add(Restrictions.eq("activity", factura));
        rental = (List<Rental>) criteria.list();
        return rental;
    }
    
    
//    public List<IvaVentas> getFacturasByFiltro(Cliente cod, Date fd, Date fa) {
//        List<IvaVentas> fact = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        fact = (List<IvaVentas>) 
//                session.createCriteria(IvaVentas.class)
//                        .add(Restrictions.between("fecha", fd, fa))
//                        .add(Restrictions.eq("cliente", cod))
//                        .addOrder(Order.asc("fecha"))
//                        .addOrder(Order.asc("letra"))
//                        .addOrder(Order.asc("numeroFactura"))
//                        .list();
//        return fact;
//    }
//    
//    public IvaVentas getByLetraNumero(String letra,Integer sucursal, Integer numero) {
//        IvaVentas factura = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        StringBuffer sb = new StringBuffer();
//        sb.append("from IvaVentas iv ");
//        sb.append("where iv.letra = '" + letra + "' and iv.numeroSucursal = '" + sucursal + "' and iv.numeroFactura = '" + numero +"' ");
//        Query query = session.createQuery(sb.toString());
//        factura = (IvaVentas) query.uniqueResult();
//        return factura;
//    }
//    
//    public List<IvaVentas> getFactByFecha(Date fecha) {
//        List<IvaVentas> fact = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        fact = (List<IvaVentas>) 
//                session.createCriteria(IvaVentas.class)
//                        .add(Restrictions.eq("fecha", fecha) )
//                        .list();
//        return fact;
//    }
//    
//    public List<IvaVentas> getFacturasEntreFechas(Date fd, Date fa) {
//        List<IvaVentas> fact = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        fact = (List<IvaVentas>) 
//                session.createCriteria(IvaVentas.class)
//                        .add(Restrictions.between("fecha", fd, fa))
//                        .addOrder(Order.asc("fecha"))
//                        .addOrder(Order.asc("letra"))
//                        .addOrder(Order.asc("numeroFactura"))
//                        .list();
//        return fact;
//    }
    
    public List<Rental> getRenglonesDevolByFechas(Date df, Date af) {
        List<Rental> renglones = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Rental.class);
        criteria.add(Restrictions.lt("total",0.00));
        Criteria criteria2 = criteria.createCriteria("activity").add(Restrictions.between("fecha", df, af));
        //criteria2.add(Restrictions.gt("total",0.00));
        criteria2.addOrder(Order.asc("fecha"));
        renglones=criteria.list();
        return renglones;
    }
    
    public List<Rental> getRenglonesDevolByFechasAndProducto(Date df, Date af, Producto p) {
        int c = p.getCodigo();
        List<Rental> renglones = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Rental.class);
        criteria.add(Restrictions.eq("codigoProducto", c));
        Criteria criteria2 = criteria.createCriteria("activity").add(Restrictions.between("fecha", df, af));
        //criteria2.add(Restrictions.gt("total",0.00));
        //criteria2.addOrder(Order.asc("fecha"));
        renglones=criteria2.list();
        return renglones;
    }
}
