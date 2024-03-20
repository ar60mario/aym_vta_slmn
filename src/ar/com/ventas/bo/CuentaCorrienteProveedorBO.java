/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.CuentaCorrienteProveedorDAO;
import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.CuentaCorrienteProveedor;
import ar.com.ventas.entities.Proveedor;
import ar.com.ventas.entities.ReciboProveedor;
import ar.com.ventas.frame.NuevoComprobanteComprasFrame;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Marcela
 */
public class CuentaCorrienteProveedorBO {

    private final CuentaCorrienteProveedorDAO dao = new CuentaCorrienteProveedorDAO();

    private static final Logger logger = Logger.getLogger("CuentaCorrienteProveedorBO");

    public List<CuentaCorrienteProveedor> getAllByProveedor(Proveedor proveedor) throws Exception {
        List<CuentaCorrienteProveedor> ctaCteP = null;
        try {
            ctaCteP = dao.getAllByProveedor(proveedor);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ctaCteP;
    }

    public List<CuentaCorrienteProveedor> getAllByProveedorInverso(Proveedor proveedor) throws Exception {
        List<CuentaCorrienteProveedor> ctaCteP = null;
        try {
            ctaCteP = dao.getAllByProveedorInverso(proveedor);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ctaCteP;
    }

    public List<CuentaCorrienteProveedor> getCtaCteProvByProvMasFechas(Proveedor pro, Date fd, Date fa) throws Exception {
        List<CuentaCorrienteProveedor> ctaCteP = null;
        try {
            ctaCteP = dao.getCtaCteProvByProvMasFechas(pro, fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ctaCteP;
    }

    public List<CuentaCorrienteProveedor> getCtaCteProvByProvMasFechasInverso(Proveedor pro, Date fd, Date fa) throws Exception {
        List<CuentaCorrienteProveedor> ctaCteP = null;
        try {
            ctaCteP = dao.getCtaCteProvByProvMasFechasInverso(pro, fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ctaCteP;
    }
    
    public void saveCtaCteProveedor(CuentaCorrienteProveedor ccp) throws Exception {
        try {
            dao.save(ccp);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public void actualizarCtaCteProveedor(Proveedor pr0, Date f1, Date f2) throws Exception {
        List<CuentaCorrienteProveedor> ctap = null;
        try {
            ctap = getCtaCteProvByProvMasFechas(pr0, f1, f2);
        } catch (Exception ex) {
            Logger.getLogger(NuevoComprobanteComprasFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        Double sa = 0.0;
        int x = 0;
        if (ctap != null && !ctap.isEmpty()) {
            if (ctap.size() == 1) {
                return;
            }
            for (CuentaCorrienteProveedor cc1 : ctap) {
                if (x == 0) {
                    sa = cc1.getSaldo();
                    x = 1;
                } else {
                    sa += (cc1.getDebe() - cc1.getHaber());
                    cc1.setSaldo(sa);
//                            try {
                    updateCtaCteProveedor(cc1);
//                            } catch (Exception ex) {
//                                Logger.getLogger(IngresarPagoFrame.class.getName()).log(Level.SEVERE, null, ex);
//                                return;
//                            }
                }
            }
        }
//        try {
//            dao.save(ccp);
//        } catch (HibernateException ex) {
//            throw new Exception(ex);
//        }
    }

    public void updateCtaCteProveedor(CuentaCorrienteProveedor proveedor) throws Exception {
        try {
            dao.update(proveedor);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public void deleteCtaCteProveedor(CuentaCorrienteProveedor ccp) throws Exception {
        try {
            dao.delete(ccp);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public CuentaCorrienteProveedor getCtaCteByComprobante(ComprobanteCompras cc) throws Exception {
        CuentaCorrienteProveedor cuenta = null;
        try {
            cuenta = dao.getCtaCteByComprobante(cc);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cuenta;
    }

    public CuentaCorrienteProveedor getCtaCteByRecibo(ReciboProveedor rp) throws Exception {
        CuentaCorrienteProveedor cuenta = null;
        try {
            cuenta = dao.getCtaCteByRecibo(rp);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cuenta;
    }
}
