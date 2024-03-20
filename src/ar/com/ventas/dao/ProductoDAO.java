/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.dao;

import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.SubRubro;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mario
 */
public class ProductoDAO extends GenericoDAO {

    public Producto getByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        criteria.add(Restrictions.eq("inactivo", false));
        Producto producto = (Producto) criteria.uniqueResult();
        return producto;
    }

    public Producto getAllByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigo", codigo));
        Producto producto = (Producto) criteria.uniqueResult();
        return producto;
    }

    public List<Producto> getAllProductosOrdenado(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        if (!filtro.equals("*")) {
            sb.append("where prod.detalle like :filtro and ");
        } else {
            sb.append("where ");
        }
        sb.append("prod.inactivo = false ");
        sb.append("order by prod.detalle asc");

        Query query = session.createQuery(sb.toString());
        if (!filtro.equals("*")) {
            query.setParameter("filtro", "%" + filtro + "%");
        }
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getAllOrdByCodigo(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        if (!filtro.equals("*")) {
            sb.append("where prod.detalle like :filtro and ");
        } else {
            sb.append("where ");
        }
        sb.append("prod.inactivo = false ");
        sb.append("order by prod.codigo asc");

        Query query = session.createQuery(sb.toString());
        if (!filtro.equals("*")) {
            query.setParameter("filtro", "%" + filtro + "%");
        }
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getProductosByFiltroSin90SinDepo(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        String dp = "**DEPO**";
        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        sb.append("where prod.detalle like :filtro ");
        sb.append("and prod.detalle not like :dp ");
        sb.append("and prod.subRubro.id != 16 ");
        sb.append("and prod.inactivo = false ");
        sb.append("order by prod.detalle asc");
        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%" + filtro + "%");
        query.setParameter("dp", dp + "%");
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getAllOrdByRubro(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        if (!filtro.equals("*")) {
            sb.append("where prod.detalle like :filtro and ");
        } else {
            sb.append("where ");
        }
        sb.append("prod.inactivo = false ");
        sb.append("order by prod.rubro, prod.subRubro  asc");

        Query query = session.createQuery(sb.toString());
        if (!filtro.equals("*")) {
            query.setParameter("filtro", "%" + filtro + "%");
        }
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getProductosByFiltro(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        sb.append("where prod.detalle like :filtro ");
        sb.append("and prod.inactivo = false ");
        sb.append("order by prod.detalle asc");

        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%" + filtro + "%");
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getProductosByFiltroActivos(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        sb.append("where prod.detalle like :filtro ");
        sb.append(" and prod.inactivo != true ");
        sb.append("order by prod.detalle asc");

        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%" + filtro + "%");
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getProductosByFiltroActivosSinDepo(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        String dp = "**DEPO**";
        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        sb.append("where prod.detalle like :filtro ");
        sb.append("and prod.detalle not like :dp ");
        sb.append(" and prod.inactivo != true ");
        sb.append("order by prod.detalle asc");
        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%" + filtro + "%");
        query.setParameter("dp", dp + "%");
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getProductosByFiltroSin90(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod ");
        sb.append("where prod.detalle like :filtro ");
        sb.append("and prod.subRubro.id != 16 ");
        sb.append("order by prod.detalle asc");

        Query query = session.createQuery(sb.toString());
        query.setParameter("filtro", "%" + filtro + "%");
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getProductosSinCodigoBarras(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod where ");
        if (!filtro.equals("*")) {
            sb.append("prod.detalle like :filtro and ");
        }
        sb.append(" prod.inactivo = false and");
        sb.append(" prod.codigoBarras = '0' ");
        sb.append("order by prod.detalle asc");

        Query query = session.createQuery(sb.toString());
        if (!filtro.equals("*")) {
            query.setParameter("filtro", "%" + filtro + "%");
        }
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getAllProductosEnCero(String filtro) {
        List<Producto> productos = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();

        StringBuffer sb = new StringBuffer();
        sb.append("from Producto prod where ");
        if (!filtro.equals("*")) {
            sb.append("prod.detalle like :filtro and ");
        }
        sb.append("prod.inactivo = false and ");
        sb.append("prod.precio = 0.0 ");
        sb.append("order by prod.detalle asc");

        Query query = session.createQuery(sb.toString());
        if (!filtro.equals("*")) {
            query.setParameter("filtro", "%" + filtro + "%");
        }
        productos = (List<Producto>) query.list();
        return productos;
    }

    public List<Producto> getProductosInactivos() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.TRUE));
        //criteria.add(Restrictions.like("detalle", "%"+filtro+"%"))
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

//    public List<Producto> getProductosInactivosByFiltro(String filtro) {
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Criteria criteria = session.createCriteria(Producto.class);
//        criteria.add(Restrictions.eq("inactivo", Boolean.TRUE));
//        criteria.add(Restrictions.like("detalle", "%"+filtro+"%"));
//        criteria.addOrder(Order.asc("detalle"));
//        return (List<Producto>) criteria.list();
//    }
    /* */
    public Producto getByCodigoBarras(Long codigoBarras) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigoBarras", codigoBarras));
        criteria.add(Restrictions.eq("inactivo", false));
        Producto producto = (Producto) criteria.uniqueResult();
        return producto;
    }

    public List<Producto> getByCodigoBarras2(Long codigoBarras) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("codigoBarras", codigoBarras));
        criteria.add(Restrictions.eq("inactivo", false));
        List<Producto> producto = (List<Producto>) criteria.list();
        return producto;
    }

    public List<Producto> getProductosActivosByNombre() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getAllProductosActivosBySubRubroByNombre(SubRubro s) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.add(Restrictions.eq("subRubro", s));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getAllProductosActivosBySubRubroByNombreAndFiltro(SubRubro s, String f) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.add(Restrictions.eq("subRubro", s));
        criteria.add(Restrictions.like("detalle", "%" + f + "%"));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getAllProductosActivosByRubroByNombre(Rubro r) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.add(Restrictions.eq("rubro", r));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getActivosByRubroOrderBySubrubroAndNombre(Rubro r) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        Criteria criteria1 = criteria.createCriteria("subRubro");
        criteria.add(Restrictions.eq("inactivo", false));
        criteria.add(Restrictions.eq("listaPdf", true));
        criteria.add(Restrictions.eq("rubro", r));
        criteria1.add(Restrictions.eq("lista", true));
        criteria1.addOrder(Order.asc("detalle"));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getAllProductosActivosByRubroAndSubByNombre(Rubro r, SubRubro s) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.add(Restrictions.eq("rubro", r));
        criteria.add(Restrictions.eq("subRubro", s));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getProductosActivosByCodigo() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.addOrder(Order.asc("codigo"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getProductosInactivosByCodigo(Integer codigo) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", true));
        criteria.add(Restrictions.eq("codigo", codigo));
        criteria.addOrder(Order.asc("codigo"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getAllProductosActivosBySubRubroByCodigo(SubRubro s) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.add(Restrictions.eq("subRubro", s));
        criteria.addOrder(Order.asc("codigo"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getAllProductosActivosByRubroByCodigo(Rubro s) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.add(Restrictions.eq("rubro", s));
        criteria.addOrder(Order.asc("codigo"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getAllProductosActivosByRubroAndSubRubroByCodigo(Rubro r, SubRubro s) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.add(Restrictions.eq("rubro", r));
        criteria.add(Restrictions.eq("subRubro", s));
        criteria.addOrder(Order.asc("codigo"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getAllProductosActivosConDescuento() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.add(Restrictions.eq("llevaDto", true));
        //criteria.add(Restrictions.eq("subRubro", s));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getAllProductosActivosPrecioCero() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.add(Restrictions.eq("precio", 0.0));
        //criteria.add(Restrictions.eq("subRubro", s));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getProductosActivosByFiltroAndSubRubro(String f, SubRubro s) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.add(Restrictions.eq("subRubro", s));
        criteria.add(Restrictions.like("detalle", "%" + f + "%"));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getProductosInactivosByFiltro(String detalle) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", true));
        criteria.add(Restrictions.like("detalle", "%" + detalle + "%"));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getProductosActivosByFiltroDetalle(String f) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        //criteria.add(Restrictions.eq("subRubro", s));
        criteria.add(Restrictions.like("detalle", "%" + f + "%"));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getProductosByIvaCeroAndFiltro(String f) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("ivaCero", Boolean.TRUE));
        //criteria.add(Restrictions.eq("subRubro", s));
        if (!f.isEmpty()) {
            criteria.add(Restrictions.like("detalle", "%" + f + "%"));
        }
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getProductosActivosByFiltroNumerico(String f) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        //criteria.add(Restrictions.eq("subRubro", s));
        criteria.add(Restrictions.like("detalle", "%" + f + "%"));
        criteria.addOrder(Order.asc("codigo"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getProductosActivosBySubRubro(SubRubro s) {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("inactivo", Boolean.FALSE));
        criteria.add(Restrictions.eq("subRubro", s));
        //criteria.add(Restrictions.like("detalle", "%" + f + "%"));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getProductosParaWeb() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("actualizarWeb", true));
        criteria.add(Restrictions.eq("inactivo", false));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getProductosParaGondola() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("actualizarGondola", true));
        criteria.add(Restrictions.eq("inactivo", false));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getProductosParaLista() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.add(Restrictions.eq("actualizarListaPrecios", true));
        criteria.add(Restrictions.eq("inactivo", false));
        criteria.addOrder(Order.asc("detalle"));
        return (List<Producto>) criteria.list();
    }

    public List<Producto> getAllOrderByCodigoBarras() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Producto.class);
        criteria.addOrder(Order.asc("codigoBarras"));
        return (List<Producto>) criteria.list();
    }
}
