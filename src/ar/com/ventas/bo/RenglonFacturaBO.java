/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.RenglonFacturaDAO;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.RenglonFactura;
import ar.com.ventas.entities.Rubro;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class RenglonFacturaBO {

    private final RenglonFacturaDAO dao = new RenglonFacturaDAO();

    private static final Logger logger = Logger.getLogger("RenglonFacturaBO");

    public RenglonFactura saveRenglon(RenglonFactura renglonFactura) throws Exception {
        try {
            dao.save(renglonFactura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglonFactura;
    }

    public List<RenglonFactura> getRenglonesByPeriodo(Integer mes, Integer anio) throws Exception {
        List<RenglonFactura> renglones = null;
        try {
            renglones = dao.getRenglonesByPeriodo(mes, anio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return renglones;
    }

    public List<RenglonFactura> getAllRenglonFacturaFromIvaVentas(IvaVentas iv) throws Exception {
        List<RenglonFactura> listRenglonFactura = null;
        try {
            listRenglonFactura = dao.getAllRenglonFacturaFromIvaVentas(iv);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listRenglonFactura;
    }

    public List<RenglonFactura> getAll() throws Exception {
        List<RenglonFactura> list = null;
        try {
            list = dao.getAll(RenglonFactura.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return list;
    }

    public List<RenglonFactura> getRenglonesFcByFechas(Date df, Date af) throws Exception {
        List<RenglonFactura> list = null;
        try {
            list = dao.getRenglonesFcByFechas(df, af);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return list;
    }

    public List<RenglonFactura> getRenglonesFcByFechasAndRubro(Date df, Date af, Rubro rubro) throws Exception {
        List<RenglonFactura> list = null;
        try {
            list = dao.getRenglonesFcByFechasAndRubro(df, af, rubro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return list;
    }
    
    public List<RenglonFactura> getRenglonesFcByFechasAndProducto(Date df, Date af, Producto p) throws Exception {
        List<RenglonFactura> list = null;
        try {
            list = dao.getRenglonesFcByFechasAndProducto(df, af, p);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return list;
    }
}
