/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.IvaVentasDAO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.IvaVentas;
import ar.com.ventas.entities.Vendedor;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Marcela
 */
public class IvaVentasBO {

    private final IvaVentasDAO dao = new IvaVentasDAO();

    private static final Logger logger = Logger.getLogger("IvaVentasBO");

    public IvaVentas saveIvaVentas(IvaVentas ivaVentas) throws Exception {
        try {
            dao.save(ivaVentas);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public List<IvaVentas> getFacturasPorVendedorEntreFechas(Vendedor ve, Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getFacturasPorVendedorEntreFechas(ve, fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getNotasCreditoPorVendedorEntreFechas(Vendedor ve, Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getNotasCreditoPorVendedorEntreFechas(ve, fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getNotasDebitoPorVendedorEntreFechas(Vendedor ve, Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getNotasDebitoPorVendedorEntreFechas(ve, fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getAllIvaVentas() throws Exception {

        List<IvaVentas> listIvaVentas = null;

        try {
            listIvaVentas = dao.getAll(IvaVentas.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;

    }

    public List<IvaVentas> getAllIvaVentasByCodigoYFecha(Cliente cod, Date fechaDe, Date fechaA) throws Exception {
        List<IvaVentas> listIvaVentas = null;

        try {
            listIvaVentas = dao.getFacturasByFiltro(cod, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;
    }

    public IvaVentas getIVById(Long iv) throws Exception {
        IvaVentas ivaVentas = null;
        try {
            ivaVentas = (IvaVentas) dao.getById(IvaVentas.class, iv);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }

    public IvaVentas getFacturaByNumero(String letra, Integer sucursal, Integer numero) throws Exception {
        IvaVentas ivaVentas = null;
        try {
            ivaVentas = (IvaVentas) dao.getByLetraNumero(letra,sucursal,numero);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ivaVentas;
    }
    
    public List<IvaVentas> getFactByFecha(Date fecha) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getFactByFecha(fecha);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getFacturasEntreFechas(Date fd, Date fa) throws Exception {
        List<IvaVentas> fact = null;
        try {
            fact = (List<IvaVentas>) dao.getFacturasEntreFechas(fd, fa);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return fact;
    }
    
    public List<IvaVentas> getFcByCodigoYFecha(Cliente cod, Date fechaDe, Date fechaA) throws Exception {
        List<IvaVentas> listIvaVentas = null;
        try {
            listIvaVentas = dao.getFcByCliente(cod, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;
    }
    
    public List<IvaVentas> getNcByCodigoYFecha(Cliente cod, Date fechaDe, Date fechaA) throws Exception {
        List<IvaVentas> listIvaVentas = null;
        try {
            listIvaVentas = dao.getNcByCliente(cod, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;
    }
    
    public List<IvaVentas> getNdByCliente(Cliente cod, Date fechaDe, Date fechaA) throws Exception {
        List<IvaVentas> listIvaVentas = null;
        try {
            listIvaVentas = dao.getNdByCliente(cod, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listIvaVentas;
    }
}
