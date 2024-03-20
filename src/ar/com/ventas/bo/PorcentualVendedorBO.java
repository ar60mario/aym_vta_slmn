/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.PorcentualVendedorDAO;
import ar.com.ventas.entities.PorcentualVendedor;
import ar.com.ventas.entities.Vendedor;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class PorcentualVendedorBO {

    private final PorcentualVendedorDAO dao = new PorcentualVendedorDAO();

    private static final Logger logger = Logger.getLogger("PorcentualVendedorBO");

    public PorcentualVendedor savePorcentualVendedor(PorcentualVendedor porcentual) throws Exception {
        try {
            dao.save(porcentual);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return porcentual;
    }
    
    public void deletePorcentualVendedor(PorcentualVendedor porcentual) throws Exception {
        try {
            dao.delete(porcentual);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    
    public List<PorcentualVendedor> getAllPorcentualVendedor() throws Exception{
        List<PorcentualVendedor> porcentuales = null;
        try{
            porcentuales = dao.getAll(PorcentualVendedor.class);			
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return porcentuales;
    }
    
    public List<PorcentualVendedor> getAllPorcentualByVendedor(Vendedor v) throws Exception{
        List<PorcentualVendedor> pv = null;
        try{
            pv = dao.getAllPorcentualByVendedor(v);			
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return pv;
    }
    
    public PorcentualVendedor getIVById(Long id) throws Exception {
        PorcentualVendedor pV = null;
        try {
            pV = (PorcentualVendedor) dao.getById(PorcentualVendedor.class, id);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return pV;
    }
    
    public PorcentualVendedor updatePorcentualVendedor(PorcentualVendedor porcentual) throws Exception {
        try {
            dao.update(porcentual);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return porcentual;
    }
}
