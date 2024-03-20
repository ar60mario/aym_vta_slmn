/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.ComprobanteComprasDetalle;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class ComprobanteComprasDetalleDAO extends GenericoDAO{

    /*
    public List<ComprobanteCompras> getIvaComprasByFiltroPeriodo(int mes, int anio) {
        List<ComprobanteCompras> ivaCompras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        
        StringBuffer sb = new StringBuffer();
        sb.append("from IvaCompras ic ");
        sb.append("where month(ic.fechaPeriodo) = :mes ");
        sb.append("and year(ic.fechaPeriodo) = :anio ");
        sb.append("order by ic.proveedor, ic.fechaFactura");
        
        Query query = session.createQuery(sb.toString());
        query.setParameter("mes",  mes );
        query.setParameter("anio", anio);
        
        ivaCompras = (List<ComprobanteCompras>) query.list();
                
        return ivaCompras;
    }
    
    public ComprobanteCompras getComprobanteByProveedorAndNumero(Proveedor p,String l, Integer s, Integer n, Boolean d, String tc){
        ComprobanteCompras c = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        c = (ComprobanteCompras) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        .add(Restrictions.eq("letra", l))
                        .add(Restrictions.eq("numeroSucursal", s))
                        .add(Restrictions.eq("numeroFactura", n))
                        .add(Restrictions.eq("esDebito", d))
                        .add(Restrictions.eq("tipoComprobante", tc))
                        .uniqueResult();
        return c;
    }
    
    public List<ComprobanteCompras> getFacturasPendientesEntreFechas(Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.eq("estaPago", false))
                        .add(Restrictions.eq("esDebito", true))
                        .addOrder(Order.asc("proveedor"))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getFacturasEntreFechas(Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.eq("esDebito", true))
                        .addOrder(Order.asc("proveedor"))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getFacturasPagasEntreFechas(Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.eq("esDebito", true))
                        .add(Restrictions.gt("pagado", 0.0))
                        .addOrder(Order.asc("proveedor"))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getFacturasPorProveedorEntreFechas(Proveedor p, Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.eq("esDebito", true))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getNotasCreditoPorProveedorEntreFechas(Proveedor p, Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.eq("esDebito", false))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getFacturasPorProveedorEntreFechasPagadas(Proveedor p, Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.gt("pagado", 0.0))
                        .add(Restrictions.eq("esDebito", true))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getFacturasPorProveedorEntreFechasImpagas(Proveedor p, Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.eq("estaPago", false))
                        .add(Restrictions.eq("esDebito", true))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getFacturasPorProveedorImpagas(Proveedor p){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        .add(Restrictions.eq("estaPago", false))
                        .add(Restrictions.eq("esDebito", true))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getNotasCreditoPorProveedorImpagas(Proveedor p){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        .add(Restrictions.eq("estaPago", false))
                        .add(Restrictions.eq("esDebito", false))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getFacturasImpagas(){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("estaPagado", false))
                        .add(Restrictions.eq("esDebito", true))
                        .addOrder(Order.asc("proveedor"))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getNotaCreditoPendientesEntreFechas(Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.eq("estaPago", false))
                        .add(Restrictions.eq("esDebito", false))
                        .addOrder(Order.asc("proveedor"))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getNotaCreditoPorProveedorImpagas(Proveedor p){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        .add(Restrictions.eq("estaPagado", false))
                        .add(Restrictions.eq("esDebito", false))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getNotaCreditoEntreFechasFactura(Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.eq("esDebito", false))
                        .addOrder(Order.asc("proveedor"))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getNotaCreditoPagasEntreFechasFactura(Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.eq("esDebito", false))
                        .add(Restrictions.gt("pagado", 0.0))
                        .addOrder(Order.asc("proveedor"))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getNotaCreditoPorProveedorEntreFechas(Proveedor p, Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.eq("esDebito", false))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getNotaCreditoPorProveedorEntreFechasPagadas(Proveedor p, Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.gt("pagado", 0.0))
                        .add(Restrictions.eq("esDebito", false))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getNotaCreditoPorProveedorEntreFechasImpagas(Proveedor p, Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .add(Restrictions.eq("estaPagado", false))
                        .add(Restrictions.eq("esDebito", false))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getNotaCreditoImpagas(){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("estaPagado", false))
                        .add(Restrictions.eq("esDebito", false))
                        .addOrder(Order.asc("proveedor"))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getFcAndNcPorProveedor(Proveedor p){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        //.add(Restrictions.eq("estaPago", false))
                        //.add(Restrictions.eq("esDebito", true))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }

    public List<ComprobanteCompras> getComprobantesEntreFechas(Date fd, Date fa){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.between("fechaFactura", fd, fa))
                        .addOrder(Order.asc("proveedor"))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getAllFacPorProveedor(Proveedor p){
        List<ComprobanteCompras> comprobantes = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobantes = (List<ComprobanteCompras>) 
                session.createCriteria(ComprobanteCompras.class)
                        .add(Restrictions.eq("proveedor", p))
                        //.add(Restrictions.eq("estaPago", false))
                        .add(Restrictions.eq("esDebito", true))
                        .addOrder(Order.asc("fechaFactura"))
                        .addOrder(Order.asc("id"))
                        .list();
        return comprobantes;
    }
    */
    public List<ComprobanteComprasDetalle> getDetalleByComprobante(ComprobanteCompras p){
        List<ComprobanteComprasDetalle> comprobante = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        comprobante = (List<ComprobanteComprasDetalle>) 
                session.createCriteria(ComprobanteComprasDetalle.class)
                        .add(Restrictions.eq("comprobanteCompras", p))
                        .list();
        return comprobante;
    }

}
