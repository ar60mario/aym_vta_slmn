/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.CtaCteStockDAO;
import ar.com.ventas.entities.CtaCteStock;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Proveedor;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class CtaCteStockBO {

    private final CtaCteStockDAO dao = new CtaCteStockDAO();
//
    private static final Logger logger = Logger.getLogger("CtaCteStockBO");
//
//    public CtaCteCliente getUltimoMovimiento(Cliente cli) throws Exception {
//        CtaCteCliente ccc = null;
//        try {
//            ccc = dao.getUltimoMovimiento(cli);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return ccc;
//    }

    public CtaCteStock saveCtaCteStock(CtaCteStock ctaCteStock) throws Exception {
        try {
            dao.save(ctaCteStock);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ctaCteStock;
    }

    public List<CtaCteStock> getCtaCteStockByFecha(Date fechaDe, Date fechaA) throws Exception {
        List<CtaCteStock> ctaCte = null;
        try {
            ctaCte = dao.getCtaCteStockByFecha(fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ctaCte;
    }

    public List<CtaCteStock> getCtaCteStockByFechaAndProveedor(Proveedor p, Date fechaDe, Date fechaA) throws Exception {
        List<CtaCteStock> ctaCte = null;
        try {
            ctaCte = dao.getCtaCteStockByFechaAndProveedor(p, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ctaCte;
    }
    
    public List<CtaCteStock> getCtaCteStockByFechaAndProducto(Producto p, Date fechaDe, Date fechaA) throws Exception {
        List<CtaCteStock> ctaCte = null;
        try {
            ctaCte = dao.getCtaCteStockByFechaAndProducto(p, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ctaCte;
    }
    
    public List<CtaCteStock> getCtaCteStockByComprobante(Long p) throws Exception {
        List<CtaCteStock> ctaCte = null;
        try {
            ctaCte = dao.getCtaCteStockByComprobante(p);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ctaCte;
    }
//    public CtaCteCliente getMovimientosByIvaVentas(IvaVentas iv) throws Exception {
//        CtaCteCliente ccc = null;
//        try {
//            ccc = dao.getMovimientoByIvaVentas(iv);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return ccc;
//    }
//
//    public CtaCteCliente getMovimientosById(Long id) throws Exception {
//        CtaCteCliente ccc = null;
//        try {
//            ccc = dao.getMovimientoById(id);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
//        return ccc;
//    }
}
