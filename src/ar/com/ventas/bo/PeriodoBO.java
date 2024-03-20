/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.PeriodoDAO;
import ar.com.ventas.entities.Periodo;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class PeriodoBO {

    private final PeriodoDAO dao = new PeriodoDAO();

    private static final Logger logger = Logger.getLogger("PeriodoBO");

    public void savePeriodo(Periodo periodo) throws Exception {
        try {
            dao.save(periodo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public void updatePeriodo(Periodo periodo) throws Exception {
        try {
            dao.update(periodo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public List<Periodo> getAllPeriodo() throws Exception {
        List<Periodo> periodo = null;
        try {
            periodo = dao.getAll(Periodo.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return periodo;
    }

    public Periodo getPeriodoByFecha(Integer mes, Integer anio) throws Exception {
        Periodo per = null;
        try {
            per = dao.getPeriodoByFecha(mes, anio);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return per;
    }
    
    public List<Periodo> getAllPeriodosAbiertos() throws Exception {
        List<Periodo> periodos = null;
        try {
            periodos = dao.getAllPeriodosAbiertos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return periodos;
    }
    /*  
     public CtaCteCliente getMovimientosById(Long id) throws Exception {
     CtaCteCliente ccc = null;
     try {
     ccc = dao.getMovimientoById(id);
     } catch (HibernateException ex) {
     throw new Exception(ex);
     }
     return ccc;
     }
     */
}
