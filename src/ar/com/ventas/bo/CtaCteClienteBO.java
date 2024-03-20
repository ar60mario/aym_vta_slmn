/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.CtaCteClienteDAO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.CtaCteCliente;
import ar.com.ventas.entities.IvaVentas;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class CtaCteClienteBO {

    private final CtaCteClienteDAO dao = new CtaCteClienteDAO();

    private static final Logger logger = Logger.getLogger("CtaCteClienteBO");

    public CtaCteCliente getUltimoMovimientoPorDia(Cliente cli, Date f) throws Exception {
        CtaCteCliente ccc = null;
        try {
            ccc = dao.getUltimoMovimientoPorDia(cli, f);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ccc;
    }
    //getUltimoMovimientoPorAntes
    public CtaCteCliente getUltimoMovimientoPorAntes(Cliente cli, Date f) throws Exception {
        CtaCteCliente ccc = null;
        try {
            ccc = dao.getUltimoMovimientoPorAntes(cli, f);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ccc;
    }
    
    public CtaCteCliente getUltimoMovimiento(Cliente cli) throws Exception {
        CtaCteCliente ccc = null;
        try {
            ccc = dao.getUltimoMovimiento(cli);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ccc;
    }

    public CtaCteCliente saveCtaCteCliente(CtaCteCliente ctaCteCliente) throws Exception {
        try {
            dao.save(ctaCteCliente);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ctaCteCliente;
    }

    public CtaCteCliente updateCtaCteCliente(CtaCteCliente ctaCteCliente) throws Exception {
        try {
            dao.update(ctaCteCliente);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ctaCteCliente;
    }

    public void deleteCtaCteCliente(CtaCteCliente ctaCteCliente) throws Exception {
        try {
            dao.delete(ctaCteCliente);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return;
    }

    public List<CtaCteCliente> getAllCtaCteClienteByCodigoAndFecha(Cliente cli, Date fechaDe, Date fechaA) throws Exception {
        List<CtaCteCliente> listCtaCteCliente = null;
        try {
            listCtaCteCliente = dao.getCtaCteClienteByClienteAndFecha(cli, fechaDe, fechaA);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listCtaCteCliente;
    }

    public List<CtaCteCliente> getCtaCteClienteByFecha(Date fecha) throws Exception {
        List<CtaCteCliente> listCtaCteCliente = null;
        try {
            listCtaCteCliente = dao.getCtaCteClienteByFecha(fecha);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listCtaCteCliente;
    }

    public List<CtaCteCliente> getTodaCtaCteClienteByCliente(Cliente cli) throws Exception {
        List<CtaCteCliente> listCtaCteCliente = null;
        try {
            listCtaCteCliente = dao.getTodaCtaCteClienteByCliente(cli);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listCtaCteCliente;
    }

    public CtaCteCliente getMovimientosByIvaVentas(IvaVentas iv) throws Exception {
        CtaCteCliente ccc = null;
        try {
            ccc = dao.getMovimientoByIvaVentas(iv);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ccc;
    }

    public CtaCteCliente getMovimientosById(Long id) throws Exception {
        CtaCteCliente ccc = null;
        try {
            ccc = dao.getMovimientoById(id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return ccc;
    }
}
