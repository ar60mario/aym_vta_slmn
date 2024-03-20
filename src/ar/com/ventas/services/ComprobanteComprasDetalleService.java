/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.ComprobanteComprasDetalleBO;
import ar.com.ventas.entities.ComprobanteCompras;
import ar.com.ventas.entities.ComprobanteComprasDetalle;
import ar.com.ventas.util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mario
 */
public class ComprobanteComprasDetalleService {
    
    public ComprobanteComprasDetalle saveComprobanteDetalle(ComprobanteComprasDetalle ic) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ComprobanteComprasDetalle cc = null;
        try {
            cc = new ComprobanteComprasDetalleBO().saveComprobanteComprasDetalle(ic);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cc;
    }
    
    public List<ComprobanteComprasDetalle> getDetalleByComprobante(ComprobanteCompras p) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteComprasDetalle> ccd = null;
        try {
            ccd = new ComprobanteComprasDetalleBO().getDetalleByComprobante(p);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ccd;
    }
    /*
    
    
    public ComprobanteCompras getById(Long id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ComprobanteCompras cc = null;
        try {
            cc = new ComprobanteComprasBO().getById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return cc;
    }
    
    public void deleteComprobante(ComprobanteCompras ic) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ComprobanteCompras cc = null;
        try {
            new ComprobanteComprasBO().deleteIvaCompras(ic);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }
    
    public List<ComprobanteCompras> getAllIvaCompras() throws Exception {
        List<ComprobanteCompras> ic = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ic = new ComprobanteComprasBO().getAllIvaCompras();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ic;
    }
    
    public List<ComprobanteCompras> getIvaComprasByFiltroPeriodo(int mes, int anio) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteCompras> ic = null;
        try{
            ic = new ComprobanteComprasBO().getIvaComprasByFiltroPeriodo(mes, anio);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return ic;
    }
    
    public List<ComprobanteCompras> getComprobantesEntreFechasFactura(Date fd, Date fa) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteCompras> cc = null;
        try{
            cc = new ComprobanteComprasBO().getComprobantesEntreFechasFactura(fd, fa);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return cc;
    }
    
    public List<ComprobanteCompras> getComprobantesPendientesEntreFechas(Date fd, Date fa) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteCompras> cc = null;
        try{
            cc = new ComprobanteComprasBO().getComprobantesPendientesEntreFechas(fd, fa);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return cc;
    }
    
    public ComprobanteCompras updateComprobante(ComprobanteCompras ic) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ic = new ComprobanteComprasBO().updateIvaCompras(ic);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ic;
    }
    
//    public List<ComprobanteCompras> getComprobantesImpagos() throws Exception{
//        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
//        Transaction tx = session.beginTransaction();
//        List<ComprobanteCompras> cc = null;
//        try{
//            cc = new ComprobanteComprasBO().getComprobantesImpagos();
//            tx.commit();
//        }catch(Exception ex){
//            tx.rollback();
//            throw new Exception(ex);
//        }
//        return cc;
//    }
    
    public List<ComprobanteCompras> getComprobantesImpagosByProveedor(Proveedor proveedor) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteCompras> cc = null;
        try{
            cc = new ComprobanteComprasBO().getComprobantesImpagosByProveedor(proveedor);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return cc;
    }
    
    public List<ComprobanteCompras> getNotasCreditoImpagosByProveedor(Proveedor proveedor) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteCompras> cc = null;
        try{
            cc = new ComprobanteComprasBO().getNotasCreditoImpagosByProveedor(proveedor);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return cc;
    }
    
    public List<ComprobanteCompras> getComprobantesPagosEntreFechasFactura(Date fd, Date fa) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteCompras> cc = null;
        try{
            cc = new ComprobanteComprasBO().getComprobantesPagosEntreFechasFactura(fd, fa);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return cc;
    }
    //getFcAndNcPorProveedor
    public List<ComprobanteCompras> getFcAndNcPorProveedor(Proveedor proveedor) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteCompras> cc = null;
        try{
            cc = new ComprobanteComprasBO().getFcAndNcPorProveedor(proveedor);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return cc;
    }
    //getComprobantesEntreFechas
    public List<ComprobanteCompras> getComprobantesEntreFechas(Date fd, Date fa) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteCompras> cc = null;
        try{
            cc = new ComprobanteComprasBO().getComprobantesEntreFechas(fd, fa);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return cc;
    }
    
    public List<ComprobanteCompras> getAllNotPorProveedor(Proveedor proveedor) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteCompras> cc = null;
        try{
            cc = new ComprobanteComprasBO().getAllNotPorProveedor(proveedor);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return cc;
    }
    
    public List<ComprobanteCompras> getAllFacPorProveedor(Proveedor proveedor) throws Exception{
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<ComprobanteCompras> cc = null;
        try{
            cc = new ComprobanteComprasBO().getAllFacPorProveedor(proveedor);
            tx.commit();
        }catch(Exception ex){
            tx.rollback();
            throw new Exception(ex);
        }
        return cc;
    }
*/
    public void deleteComprobanteDetalle(ComprobanteComprasDetalle ic) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        ComprobanteComprasDetalle cc = null;
        try {
            new ComprobanteComprasDetalleBO().deleteComprobanteComprasDetalle(ic);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return;
    }
}
