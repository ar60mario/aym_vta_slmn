/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.services;

import ar.com.ventas.bo.IvaVentasBO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Vendedor;
import ar.com.ventas.util.HibernateUtils;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Marcela
 */
public class IvaVentasService {

    public void saveIvaVentas(IvaVentas ivaVentas) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            new IvaVentasBO().saveIvaVentas(ivaVentas);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
    }

    public List<IvaVentas> getAllIvaVentas() throws Exception {

        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().getAllIvaVentas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;

    }

    public List<IvaVentas> getFacturasPorVendedorEntreFechas(Vendedor ve, Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBO().getFacturasPorVendedorEntreFechas(ve, fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getNotasCreditoPorVendedorEntreFechas(Vendedor ve, Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBO().getNotasCreditoPorVendedorEntreFechas(ve, fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getNotasDebitoPorVendedorEntreFechas(Vendedor ve, Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBO().getNotasDebitoPorVendedorEntreFechas(ve, fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getAllIvaVentasByCodigoYFecha(Cliente cod, Date fechaDe, Date fechaA) throws Exception {

        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().getAllIvaVentasByCodigoYFecha(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public IvaVentas getIvaVentasById(Long id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentas ivaVentas = null;
        try {
            ivaVentas = new IvaVentasBO().getIVById(id);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public IvaVentas getFacturaByNumero(String letra,Integer sucursal, Integer numero) throws Exception {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        IvaVentas ivaVentas = null;
        try {
            ivaVentas = new IvaVentasBO().getFacturaByNumero(letra,sucursal,numero);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public List<IvaVentas> getFactByFecha(Date fecha) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBO().getFactByFecha(fecha);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getFacturasEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            fact = new IvaVentasBO().getFacturasEntreFechas(fd, fa);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getFcByCodigoYFecha(Cliente cod, Date fechaDe, Date fechaA) throws Exception {
        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().getFcByCodigoYFecha(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public List<IvaVentas> getNcByCodigoYFecha(Cliente cod, Date fechaDe, Date fechaA) throws Exception {
        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().getNcByCodigoYFecha(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    //getNdByCliente
    public List<IvaVentas> getNdByCliente(Cliente cod, Date fechaDe, Date fechaA) throws Exception {
        List<IvaVentas> ivaVentas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            ivaVentas = new IvaVentasBO().getNdByCliente(cod, fechaDe, fechaA);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public List<IvaVentas> getFacturasByPeriodo(int mes, int anio) throws Exception {
        List<IvaVentas> facturas = null;
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            facturas = new IvaVentasService().getAllIvaVentas();
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw new Exception(ex);
        }
        return facturas;
    }
}
