/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.IvaCompras;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class IvaComprasDAO extends GenericoDAO{

    
    public List<IvaCompras> getIvaComprasByFiltro(int mes, int anio) {
        List<IvaCompras> ivaCompras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        
        StringBuffer sb = new StringBuffer();
        sb.append("from IvaCompras ic ");
        sb.append("where month(ic.fechaPeriodo) = :mes ");
        sb.append("and year(ic.fechaPeriodo) = :anio ");
        sb.append("order by ic.proveedor, ic.fechaFactura asc");
        
        Query query = session.createQuery(sb.toString());
        query.setParameter("mes",  mes );
        query.setParameter("anio", anio);
        
        ivaCompras = (List<IvaCompras>) query.list();
                
        return ivaCompras;
    }
    
    public IvaCompras getIvaComprasByComprobanteCompras(ComprobanteCompras cc) {
        IvaCompras ivaCompras = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(IvaCompras.class);
        criteria.add(Restrictions.eq("comprobante", cc));
        ivaCompras = (IvaCompras) criteria.uniqueResult();
        return ivaCompras;
    }
    
}
