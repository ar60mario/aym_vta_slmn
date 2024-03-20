/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Vendedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marcela
 */
public class IvaVentasDAO extends GenericoDAO {

    public List<IvaVentas> getFacturasByFiltro(Cliente cod, Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("cliente", cod))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public IvaVentas getByLetraNumero(String letra, Integer sucursal, Integer numero) {
        IvaVentas factura = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        StringBuffer sb = new StringBuffer();
        sb.append("from IvaVentas iv ");
        sb.append("where iv.letra = '" + letra + "' and iv.numeroSucursal = '" + sucursal + "' and iv.numeroFactura = '" + numero + "' ");
        Query query = session.createQuery(sb.toString());
        factura = (IvaVentas) query.uniqueResult();
        return factura;
    }

    public List<IvaVentas> getFactByFecha(Date fecha) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.eq("fecha", fecha))
                .addOrder(Order.desc("id"))
                .list();
        return fact;
    }

    public List<IvaVentas> getFacturasEntreFechas(Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.between("fecha", fd, fa))
                //                        .add(Restrictions.or(
                //                                Restrictions.eq("codigoTipoDoc", 1),
                //                                Restrictions.eq("codigoTipoDoc", 6)))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("codigoTipoDoc"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

//    public List<IvaVentas> getNotasDebitoEntreFechas(Date fd, Date fa) {
//        List<IvaVentas> fact = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        fact = (List<IvaVentas>) 
//                session.createCriteria(IvaVentas.class)
//                        .add(Restrictions.between("fecha", fd, fa))
//                        .add(Restrictions.or(
//                                Restrictions.eq("codigoTipoDoc", 2),
//                                Restrictions.eq("codigoTipoDoc", 7)))
//                        .addOrder(Order.asc("fecha"))
//                        .addOrder(Order.asc("codigoTipoDoc"))
//                        .addOrder(Order.asc("letra"))
//                        .addOrder(Order.asc("numeroFactura"))
//                        .list();
//        return fact;
//    }
//    public List<IvaVentas> getNotasCreditoEntreFechas(Date fd, Date fa) {
//        List<IvaVentas> fact = null;
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        fact = (List<IvaVentas>) 
//                session.createCriteria(IvaVentas.class)
//                        .add(Restrictions.between("fecha", fd, fa))
//                        .add(Restrictions.or(
//                                Restrictions.eq("codigoTipoDoc", 3),
//                                Restrictions.eq("codigoTipoDoc", 8)))
//                        .addOrder(Order.asc("fecha"))
//                        .addOrder(Order.asc("codigoTipoDoc"))
//                        .addOrder(Order.asc("letra"))
//                        .addOrder(Order.asc("numeroFactura"))
//                        .list();
//        return fact;
//    }
    public List<IvaVentas> getFacturasPorVendedorEntreFechas(Vendedor ve, Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.eq("vendedor", ve))
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.or(
                        Restrictions.eq("codigoTipoDoc", 1),
                        Restrictions.eq("codigoTipoDoc", 6)))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentas> getNotasDebitoPorVendedorEntreFechas(Vendedor ve, Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.eq("vendedor", ve))
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.or(
                        Restrictions.eq("codigoTipoDoc", 2),
                        Restrictions.eq("codigoTipoDoc", 7)))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentas> getNotasCreditoPorVendedorEntreFechas(Vendedor ve, Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.eq("vendedor", ve))
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.or(
                        Restrictions.eq("codigoTipoDoc", 3),
                        Restrictions.eq("codigoTipoDoc", 8)))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentas> getFcByCliente(Cliente cod, Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.eq("cliente", cod))
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.or(Restrictions.eq("codigoTipoDoc", 1), Restrictions.eq("codigoTipoDoc", 6)))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentas> getNcByCliente(Cliente cod, Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("cliente", cod))
                .add(Restrictions.or(Restrictions.eq("codigoTipoDoc", 3), Restrictions.eq("codigoTipoDoc", 8)))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentas> getNdByCliente(Cliente cod, Date fd, Date fa) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                .add(Restrictions.between("fecha", fd, fa))
                .add(Restrictions.eq("cliente", cod))
                .add(Restrictions.or(Restrictions.eq("codigoTipoDoc", 2), Restrictions.eq("codigoTipoDoc", 7)))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }

    public List<IvaVentas> getFacturasByPeriodo(int mes, int anio) {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        fact = (List<IvaVentas>) session.createCriteria(IvaVentas.class)
                //                        .add(Restrictions.between("fecha", fd, fa))
                //                        .add(Restrictions.eq("cliente", cod))
                .add(Restrictions.lt("total", 0.00))
                .addOrder(Order.asc("fecha"))
                .addOrder(Order.asc("letra"))
                .addOrder(Order.asc("numeroFactura"))
                .list();
        return fact;
    }
}
