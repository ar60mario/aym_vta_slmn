/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.RenglonNotaCreditoDAO;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.entities.RenglonNotaCredito;
import ar.com.ventas.entities.Rubro;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class RenglonNotaCreditoBO {

    private final RenglonNotaCreditoDAO dao = new RenglonNotaCreditoDAO();

    private static final Logger logger = Logger.getLogger("RenglonNotaCreditoBO");

    public RenglonNotaCredito saveRenglon(RenglonNotaCredito renglonNotaCredito) throws Exception {
        try {
            dao.save(renglonNotaCredito);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglonNotaCredito;
    }

    public List<RenglonFactura> getAllRenglonFacturaFromIvaVentas() throws Exception {

        List<RenglonFactura> listRenglonFactura = null;

        try {
            listRenglonFactura = dao.getAll(RenglonNotaCredito.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listRenglonFactura;
    }
    
    public List<RenglonNotaCredito> getAllRenglonNotaCreditoFromIvaVentas(IvaVentas factura) throws Exception {
        List<RenglonNotaCredito> listRenglonNC = null;
        try {
            listRenglonNC = dao.getAllRenglonNCFromIvaVentas(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listRenglonNC;
    }
    
    public List<RenglonNotaCredito> getRenglonesNCByFechas(Date df, Date af) throws Exception {
        List<RenglonNotaCredito> listRenglonNC = null;
        try {
            listRenglonNC = dao.getRenglonesNCByFechas(df, af);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listRenglonNC;
    }
    
    public List<RenglonNotaCredito> getRenglonesNCByFechasAndRubro(Date df, Date af, Rubro rubro) throws Exception {
        List<RenglonNotaCredito> listRenglonNC = null;
        try {
            listRenglonNC = dao.getRenglonesNCByFechasAndRubro(df, af, rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listRenglonNC;
    }
    
    public List<RenglonNotaCredito> getRenglonesNCByFechasAndProducto(Date df, Date af, Producto p) throws Exception {
        List<RenglonNotaCredito> listRenglonNC = null;
        try {
            listRenglonNC = dao.getRenglonesNCByFechasAndProducto(df, af, p);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listRenglonNC;
    }
}
