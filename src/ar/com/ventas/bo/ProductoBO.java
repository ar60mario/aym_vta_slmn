/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.ProductoDAO;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rubro;
import ar.com.ventas.entities.SubRubro;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class ProductoBO {

    private final ProductoDAO dao = new ProductoDAO();

    public List<Producto> getAllProductos() throws Exception {
        ProductoDAO dao = new ProductoDAO();
        List<Producto> losProductos = null;
        try {
            losProductos = dao.getAll(Producto.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return losProductos;
    }
    
    public List<Producto> getProductosByFiltroSin90SinDepo(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosByFiltroSin90SinDepo(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public Producto guardarProducto(Producto producto) throws Exception {
        try {
            producto = (Producto) dao.save(producto);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto getProductoByCodigo(Integer codigo) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getByCodigo(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public Producto getAllProductoByCodigo(Integer codigo) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getAllByCodigo(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }
    
    public Producto updateProducto(Producto producto) throws Exception {
        try {
            producto = (Producto) dao.update(producto);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }

    public void deleteProducto(Producto producto) throws Exception {
        try {
            dao.delete(producto);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public void saveListaProductos(List<Producto> listaProductos) throws Exception {
        if (listaProductos != null && !listaProductos.isEmpty()) {
            for (Producto prod : listaProductos) {
                if (prod.getRubro() == null) {
                    throw new Exception("El RUBRO asociado al Producto " + prod.getRubro().getCodigo() + " no es válido.");
                }
                if (prod.getSubRubro() == null) {
                    throw new Exception("El SUB-RUBRO asociado al Producto " + prod.getSubRubro().getCodigo() + " no es válido.");
                }
                try {
                    dao.save(prod);
                } catch (HibernateException ex) {
                    throw new Exception("Ha ocurrido un problema intentando guardar los PRODUCTOS.\nPor favor intente nuevamente mas tarde.");
                }
            }
        }
    }

    public List<Producto> getProductosByFiltro(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosByFiltro(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosParaWeb() throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosParaWeb();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosParaGondola() throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosParaGondola();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosParaLista() throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosParaLista();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosByFiltroActivos(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosByFiltroActivos(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosByFiltroActivosSinDepo(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosByFiltroActivosSinDepo(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosByFiltroSin90(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosByFiltroSin90(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductoSinCodigoBarras(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosSinCodigoBarras(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<Producto> getAllProductosOrdByCodigo(String filtro) throws Exception {
        ProductoDAO dao = new ProductoDAO();
        List<Producto> losProductos = new ArrayList<Producto>();

        try {
            losProductos = dao.getAllOrdByCodigo(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return losProductos;
    }

    public List<Producto> getAllProductosOrdByNombre(String filtro) throws Exception {
        ProductoDAO dao = new ProductoDAO();
        List<Producto> losProductos = new ArrayList<Producto>();

        try {
            losProductos = dao.getAllProductosOrdenado(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return losProductos;
    }

    public List<Producto> getAllProductosOrdByRubro(String filtro) throws Exception {
        ProductoDAO dao = new ProductoDAO();
        List<Producto> losProductos = new ArrayList<Producto>();

        try {
            losProductos = dao.getAllOrdByRubro(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return losProductos;
    }

    public List<Producto> getAllProductosEnCero(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllProductosEnCero(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<Producto> getProductosInactivos() throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosInactivosByFiltro(String filtro) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosInactivosByFiltro(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public Producto getProductoByCodigoBarras(Long codigoBarras) throws Exception {
        Producto producto = null;
        try {
            producto = dao.getByCodigoBarras(codigoBarras);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }
    
    public List<Producto> getProductoByCodigoBarras2(Long codigoBarras) throws Exception {
        List<Producto> producto = null;
        try {
            producto = dao.getByCodigoBarras2(codigoBarras);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return producto;
    }
    //getProductosActivosByCodigo
    //getProductosActivosByNombre
    
    public List<Producto> getProductosActivosByNombre() throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosActivosByNombre();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    //
    public List<Producto> getAllProductosActivosBySubRubroByNombre(SubRubro s) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllProductosActivosBySubRubroByNombre(s);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getAllProductosActivosBySubRubroByNombreAndFiltro(SubRubro s, String f) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllProductosActivosBySubRubroByNombreAndFiltro(s, f);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getAllProductosActivosByRubroByNombre(Rubro s) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllProductosActivosByRubroByNombre(s);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getActivosByRubroOrderBySubrubroAndNombre(Rubro s) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getActivosByRubroOrderBySubrubroAndNombre(s);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getAllProductosActivosByRubroAndSubByNombre(Rubro r, SubRubro s) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllProductosActivosByRubroAndSubByNombre(r, s);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosActivosByCodigo() throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosActivosByCodigo();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    //
    public List<Producto> getProductosInactivosByCodigo(Integer codigo) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosInactivosByCodigo(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    //
//    public List<Producto> getProductosInactivosByFiltro(String detalle) throws Exception {
//        List<Producto> productos = null;
//        try {
//            productos = dao.getProductosInactivosByFiltro(detalle);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return productos;
//    }
    
    public List<Producto> getAllProductosActivosBySubRubroByCodigo(SubRubro s) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllProductosActivosBySubRubroByCodigo(s);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getAllProductosActivosByRubroByCodigo(Rubro s) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllProductosActivosByRubroByCodigo(s);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getAllProductosActivosByRubroAndSubRubroByCodigo(Rubro r, SubRubro s) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllProductosActivosByRubroAndSubRubroByCodigo(r, s);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }

    public List<Producto> getAllProductosActivosConDescuento() throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllProductosActivosConDescuento();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getAllProductosActivosPrecioCero() throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllProductosActivosPrecioCero();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosActivosByFiltroAndSubRubro(String f, SubRubro s) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosActivosByFiltroAndSubRubro(f,s);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosActivosByFiltroDetalle(String f) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosActivosByFiltroDetalle(f);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosByIvaCeroAndFiltro(String f) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosByIvaCeroAndFiltro(f);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    //getProductosByIvaCeroAndFiltro
    public List<Producto> getProductosActivosByFiltroNumerico(String f) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosActivosByFiltroNumerico(f);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    
    public List<Producto> getProductosActivosBySubRubro(SubRubro s) throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getProductosActivosBySubRubro(s);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
    //
    public List<Producto> getAllOrderByCodigoBarras() throws Exception {
        List<Producto> productos = null;
        try {
            productos = dao.getAllOrderByCodigoBarras();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return productos;
    }
}
