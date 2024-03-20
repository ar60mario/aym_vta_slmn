/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.ComprobanteComprasBO;
import ar.com.ventas.bo.ConfiguracionProveedorBO;
import ar.com.ventas.bo.CuentaCorrienteProveedorBO;
import ar.com.ventas.bo.ProveedorBO;
import ar.com.ventas.bo.RcCoBO;
import ar.com.ventas.bo.ReciboProveedorBO;
import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.ConfiguracionProveedor;
import ar.com.ventas.entities.CuentaCorrienteProveedor;
import ar.com.ventas.entities.Proveedor;
import ar.com.ventas.entities.RcCo;
import ar.com.ventas.entities.ReciboProveedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcela
 */
public class CuentaCorrienteProveedorService {

    public List<CuentaCorrienteProveedor> getAllByProveedor(Proveedor proveedor) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<CuentaCorrienteProveedor> ctaCteP = null;
        try {
            ctaCteP = new CuentaCorrienteProveedorBO().getAllByProveedor(proveedor);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ctaCteP;
    }

    public List<CuentaCorrienteProveedor> getAllByProveedorInverso(Proveedor proveedor) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<CuentaCorrienteProveedor> ctaCteP = null;
        try {
            ctaCteP = new CuentaCorrienteProveedorBO().getAllByProveedorInverso(proveedor);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ctaCteP;
    }

    public void saveCtaCteProveedor(CuentaCorrienteProveedor ccp) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new CuentaCorrienteProveedorBO().saveCtaCteProveedor(ccp);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void saveMovimientoCompletoCtaCteProveedor(CuentaCorrienteProveedor ccp,
            List<CuentaCorrienteProveedor> ccp1, ReciboProveedor rp, Proveedor p1,
            ConfiguracionProveedor cfg) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ProveedorBO().updateProveedor(p1);
            new ConfiguracionProveedorBO().updateConfiguracion(cfg);
            rp = new ReciboProveedorBO().saveReciboProveedor(rp);
            ccp.setReciboProveedor(rp);
            if (ccp1 != null) {
                for (CuentaCorrienteProveedor cu : ccp1) {
//                    saldo2 = saldo2 + cu.getDebe();
//                    saldo2 = saldo2 - cu.getHaber();
//                    cu.setSaldo(saldo2);
                    new CuentaCorrienteProveedorBO().updateCtaCteProveedor(cu);
                }
            }
            new CuentaCorrienteProveedorBO().saveCtaCteProveedor(ccp);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public void saveMovimientoCompletoCtaCteProveedorPorAntiguedad(CuentaCorrienteProveedor ccp,
            List<CuentaCorrienteProveedor> ccp1, ReciboProveedor rp, Proveedor p1,
            ConfiguracionProveedor cfg, List<RcCo> rco, List<ComprobanteCompras> facturas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ProveedorBO().updateProveedor(p1);
            new ConfiguracionProveedorBO().updateConfiguracion(cfg);
            rp = new ReciboProveedorBO().saveReciboProveedor(rp);
            ccp.setReciboProveedor(rp);
            if (ccp1 != null) {
                for (CuentaCorrienteProveedor cu : ccp1) {
//                    saldo2 = saldo2 + cu.getDebe();
//                    saldo2 = saldo2 - cu.getHaber();
//                    cu.setSaldo(saldo2);
                    new CuentaCorrienteProveedorBO().updateCtaCteProveedor(cu);
                }
            }
            for(ComprobanteCompras cc:facturas){
                new ComprobanteComprasBO().updateIvaCompras(cc);
            }
            new CuentaCorrienteProveedorBO().saveCtaCteProveedor(ccp);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void saveMovimientoCompletoCtaCteProveedorPorAntiguedadSL(CuentaCorrienteProveedor ccp,
            ReciboProveedor rp, Proveedor p1,
            ConfiguracionProveedor cfg, List<RcCo> rco, List<ComprobanteCompras> facturas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ProveedorBO().updateProveedor(p1);
            new ConfiguracionProveedorBO().updateConfiguracion(cfg);
            rp = new ReciboProveedorBO().saveReciboProveedor(rp);
            ccp.setReciboProveedor(rp);
            for(RcCo r_c_0 : rco){
                r_c_0.setReciboProveedor(rp);
                new RcCoBO().saveRecibo(r_c_0);
            }
            for(ComprobanteCompras cc:facturas){
                new ComprobanteComprasBO().updateIvaCompras(cc);
            }
            new CuentaCorrienteProveedorBO().saveCtaCteProveedor(ccp);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public void saveMovimientoCompletoCtaCteProveedor2(CuentaCorrienteProveedor ccp,
            List<CuentaCorrienteProveedor> ccp1, ReciboProveedor rp, Proveedor p1,
            ConfiguracionProveedor cfg, ComprobanteCompras factura, RcCo rco) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new ProveedorBO().updateProveedor(p1);
            new ConfiguracionProveedorBO().updateConfiguracion(cfg);
            rp.setProveedor(p1);
            factura = new ComprobanteComprasBO().updateIvaCompras(factura);
            rp = new ReciboProveedorBO().saveReciboProveedor(rp);
            ccp.setReciboProveedor(rp);
//            ccp.setComprobante(factura);
            if (ccp1 != null) {
                for (CuentaCorrienteProveedor cu : ccp1) {
//                    saldo2 = saldo2 + cu.getDebe();
//                    saldo2 = saldo2 - cu.getHaber();
//                    cu.setSaldo(saldo2);
                    new CuentaCorrienteProveedorBO().updateCtaCteProveedor(cu);
                }
            }
            new CuentaCorrienteProveedorBO().saveCtaCteProveedor(ccp);
            rco.setComprobanteCompras(factura);
            rco.setReciboProveedor(rp);
            new RcCoBO().saveRecibo(rco);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public void updateCtaCteProveedor(CuentaCorrienteProveedor proveedor) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new CuentaCorrienteProveedorBO().updateCtaCteProveedor(proveedor);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public void deleteCtaCteProveedor(CuentaCorrienteProveedor ccp) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new CuentaCorrienteProveedorBO().deleteCtaCteProveedor(ccp);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<CuentaCorrienteProveedor> getCtaCteProvByProvMasFechas(Proveedor proveedor, Date fd, Date fa) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<CuentaCorrienteProveedor> ctaCteP = null;
        try {
            ctaCteP = new CuentaCorrienteProveedorBO().getCtaCteProvByProvMasFechas(proveedor, fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ctaCteP;
    }

    public List<CuentaCorrienteProveedor> getCtaCteProvByProvMasFechasInverso(Proveedor proveedor, Date fd, Date fa) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<CuentaCorrienteProveedor> ctaCteP = null;
        try {
            ctaCteP = new CuentaCorrienteProveedorBO().getCtaCteProvByProvMasFechasInverso(proveedor, fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ctaCteP;
    }

    public CuentaCorrienteProveedor getCtaCteByComprobante(ComprobanteCompras cc) throws Exception {
        CuentaCorrienteProveedor cuenta = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            cuenta = new CuentaCorrienteProveedorBO().getCtaCteByComprobante(cc);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cuenta;
    }

    public CuentaCorrienteProveedor getCtaCteByRecibo(ReciboProveedor rp) throws Exception {
        CuentaCorrienteProveedor cuenta = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            cuenta = new CuentaCorrienteProveedorBO().getCtaCteByRecibo(rp);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cuenta;
    }
}
