/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.ProductoBO;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.SubRubro;
import ar.com.ventas.util.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class ProductoService {

    public List<Producto> getAllProductos() throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }

    public Producto guardarProducto(Producto producto) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            producto = bo.guardarProducto(producto);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto getProductoByCodigo(Integer codigo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Producto producto = null;
        try {
            producto = new ProductoBO().getProductoByCodigo(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }
    
    public Producto getAllProductoByCodigo(Integer codigo) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Producto producto = null;
        try {
            producto = new ProductoBO().getAllProductoByCodigo(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto updateProducto(Producto producto) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            producto = new ProductoBO().updateProducto(producto);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }

    public void deleteProducto(Producto producto) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ProductoBO().deleteProducto(producto);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void saveListaProductos(List<Producto> listaProductos) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ProductoBO().saveListaProductos(listaProductos);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<Producto> getProductosByFiltro(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosByFiltro(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosParaWeb() throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosParaWeb();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosParaGondola() throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosParaGondola();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosParaLista() throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosParaLista();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosByFiltroActivos(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosByFiltroActivos(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosByFiltroActivosSinDepo(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosByFiltroActivosSinDepo(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosByFiltroSin90(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosByFiltroSin90(filtro);
            System.out.println(productos);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosByFiltroSin90SinDepo(String filtro) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosByFiltroSin90SinDepo(filtro);
            System.out.println(productos);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getAllProductosOrdenadoByCodigo(String filtro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosOrdByCodigo(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }

    public List<Producto> getAllProductosOrdenadoByNombre(String filtro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosOrdByNombre(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }

    public List<Producto> getAllProductosOrdenadoByRubro(String filtro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosOrdByRubro(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }

    public List<Producto> getAllProductosOrdenadoByNombreInactivo() throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getProductosInactivos();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }

    public List<Producto> getProductosInactivosByFiltro(String filtro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getProductosInactivosByFiltro(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getAllProductosSinCodigoBarras(String filtro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getProductoSinCodigoBarras(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }

    public List<Producto> getAllProductosEnCero(String filtro) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosEnCero(filtro);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    /* */
    public Producto getProductoByCodigoBarras(Long codigoBarras) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Producto producto = null;
        try {
            producto = new ProductoBO().getProductoByCodigoBarras(codigoBarras);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }
    
    public List<Producto> getProductoByCodigoBarras2(Long codigoBarras) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> producto = null;
        try {
            producto = new ProductoBO().getProductoByCodigoBarras2(codigoBarras);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return producto;
    }
    //getProductosActivosByNombre
    //getProductosActivosByCodigo
    public List<Producto> getProductosActivosByNombre() throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getProductosActivosByNombre();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getAllProductosActivosBySubRubroByNombre(SubRubro s) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosActivosBySubRubroByNombre(s);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getAllProductosActivosBySubRubroByNombreAndFiltro(SubRubro s, String f) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosActivosBySubRubroByNombreAndFiltro(s, f);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getAllProductosActivosByRubroByNombre(Rubro s) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosActivosByRubroByNombre(s);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getActivosByRubroOrderBySubrubroAndNombre(Rubro s) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getActivosByRubroOrderBySubrubroAndNombre(s);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getAllProductosActivosByRubroAndSubByNombre(Rubro r, SubRubro s) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosActivosByRubroAndSubByNombre(r, s);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getProductosActivosByCodigo() throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getProductosActivosByCodigo();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    //
    public List<Producto> getProductosInactivosByCodigo(Integer codigo) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getProductosInactivosByCodigo(codigo);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    //
//    public List<Producto> getProductosInactivosByFiltro(String detalle) throws Exception {
//        List<Producto> productoLista = new ArrayList();
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        try {
//            ProductoBO bo = new ProductoBO();
//            productoLista = bo.getProductosInactivosByFiltro(detalle);
//            tx.commit();
//        } catch (Exception ex) {
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return productoLista;
//    }
    
    public List<Producto> getAllProductosActivosBySubRubroByCodigo(SubRubro s) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosActivosBySubRubroByCodigo(s);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    //
    public List<Producto> getAllProductosActivosByRubroByCodigo(Rubro s) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosActivosByRubroByCodigo(s);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getAllProductosActivosByRubroAndSubRubroByCodigo(Rubro r, SubRubro s) throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosActivosByRubroAndSubRubroByCodigo(r, s);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getAllProductosActivosConDescuento() throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosActivosConDescuento();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getAllProductosActivosPrecioCero() throws Exception {
        List<Producto> productoLista = new ArrayList();
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ProductoBO bo = new ProductoBO();
            productoLista = bo.getAllProductosActivosPrecioCero();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productoLista;
    }
    
    public List<Producto> getProductosActivosByFiltroAndSubRubro(String f, SubRubro s) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosActivosByFiltroAndSubRubro(f,s);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosActivosByFiltroDetalle(String f) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosActivosByFiltroDetalle(f);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosByIvaCeroAndFiltro(String f) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosByIvaCeroAndFiltro(f);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    //getProductosByIvaCeroAndFiltro
    public List<Producto> getProductosActivosByFiltroNumerico(String f) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosActivosByFiltroNumerico(f);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosActivosBySubRubro(SubRubro s) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getProductosActivosBySubRubro(s);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
    //
    public List<Producto> getAllOrderByCodigoBarras() throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Producto> productos = null;
        try {
            productos = new ProductoBO().getAllOrderByCodigoBarras();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return productos;
    }
}
