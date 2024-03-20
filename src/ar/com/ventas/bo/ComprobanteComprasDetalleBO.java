/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.ComprobanteComprasDetalleDAO;
import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.ComprobanteComprasDetalle;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class ComprobanteComprasDetalleBO {

    private final ComprobanteComprasDetalleDAO dao = new ComprobanteComprasDetalleDAO();

    private static final Logger logger = Logger.getLogger("ComprobanteComprasDetalleBO");

    /*
    public IvaCompras getIvaComprasById(Long id) throws Exception {
        IvaCompras ic = null;
        try {
            ic = (IvaCompras) dao.getById(IvaCompras.class, id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ic;
    }

    public ComprobanteCompras getComprobanteByProveedorAndNumero(Proveedor p,String l, Integer s, Integer n, Boolean d, String tc) throws Exception {
        ComprobanteCompras ic = null;
        try {
            ic = dao.getComprobanteByProveedorAndNumero(p, l, s, n, d, tc);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ic;
    }
    
    public ComprobanteCompras getById(Long id) throws Exception {
        ComprobanteCompras ic = null;
        try {
            ic = (ComprobanteCompras) dao.getById(ComprobanteCompras.class,id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ic;
    }

    public void deleteIvaCompras(ComprobanteCompras ic) throws Exception {
        try {
            dao.delete(ic);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public List<ComprobanteCompras> getAllIvaCompras() throws Exception {
        List<ComprobanteCompras> listIvaCompras = null;
        try {
            listIvaCompras = dao.getAll(IvaCompras.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaCompras;
    }

    public List<ComprobanteCompras> getComprobantesEntreFechasFactura(Date fd, Date fa) throws Exception{
        List<ComprobanteCompras> comprobantes = null;
        try{
            comprobantes = dao.getFacturasEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getComprobantesPendientesEntreFechas(Date fd, Date fa) throws Exception{
        List<ComprobanteCompras> comprobantes = null;
        try{
            comprobantes = dao.getFacturasPendientesEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getIvaComprasByFiltroPeriodo(int mes, int anio) throws Exception {
        List<ComprobanteCompras> ivaCompras = null;
        try {
            ivaCompras = dao.getIvaComprasByFiltroPeriodo(mes, anio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaCompras;
    }

    public ComprobanteCompras updateIvaCompras(ComprobanteCompras ic) throws Exception {
        try {
            dao.update(ic);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ic;
    }
    
    public List<ComprobanteCompras> getComprobantesImpagosByProveedor(Proveedor proveedor) throws Exception{
        List<ComprobanteCompras> comprobantes = null;
        try{
            comprobantes = dao.getFacturasPorProveedorImpagas(proveedor);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getNotasCreditoImpagosByProveedor(Proveedor proveedor) throws Exception{
        List<ComprobanteCompras> comprobantes = null;
        try{
            comprobantes = dao.getNotasCreditoPorProveedorImpagas(proveedor);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getComprobantesPagosEntreFechasFactura(Date fd, Date fa) throws Exception{
        List<ComprobanteCompras> comprobantes = null;
        try{
            comprobantes = dao.getFacturasPagasEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }
    //getFcAndNcPorProveedor
    public List<ComprobanteCompras> getFcAndNcPorProveedor(Proveedor proveedor) throws Exception{
        List<ComprobanteCompras> comprobantes = null;
        try{
            comprobantes = dao.getFcAndNcPorProveedor(proveedor);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }
    //getComprobantesEntreFechas
    public List<ComprobanteCompras> getComprobantesEntreFechas(Date fd, Date fa) throws Exception{
        List<ComprobanteCompras> comprobantes = null;
        try{
            comprobantes = dao.getComprobantesEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getAllFacPorProveedor(Proveedor proveedor) throws Exception{
        List<ComprobanteCompras> comprobantes = null;
        try{
            comprobantes = dao.getAllFacPorProveedor(proveedor);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }
    
    public List<ComprobanteCompras> getAllNotPorProveedor(Proveedor proveedor) throws Exception{
        List<ComprobanteCompras> comprobantes = null;
        try{
            comprobantes = dao.getAllNotPorProveedor(proveedor);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return comprobantes;
    }
     */
    public ComprobanteComprasDetalle saveComprobanteComprasDetalle(ComprobanteComprasDetalle ic) throws Exception {
        try {
            dao.save(ic);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ic;
    }

    public void saveListaComprobanteComprasDetalle(List<ComprobanteComprasDetalle> lista, ComprobanteCompras cco) throws Exception {
        for (ComprobanteComprasDetalle cd : lista) {
            try {
                cd.setComprobanteCompras(cco);
                saveComprobanteComprasDetalle(cd);
            } catch (HibernateException ex) {
                throw new Exception(ex);
            }
        }
    }

    public List<ComprobanteComprasDetalle> getDetalleByComprobante(ComprobanteCompras ic) throws Exception {
        List<ComprobanteComprasDetalle> ccd = null;
        try {
            ccd = dao.getDetalleByComprobante(ic);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ccd;
    }

    public void deleteComprobanteComprasDetalle(ComprobanteComprasDetalle ic) throws Exception {
        try {
            dao.delete(ic);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return;
    }
}
