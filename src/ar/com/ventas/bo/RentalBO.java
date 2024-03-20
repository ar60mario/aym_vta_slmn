/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.RentalDAO;
import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rental;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class RentalBO {

    private final RentalDAO dao = new RentalDAO();

    private static final Logger logger = Logger.getLogger("ActivityRowBO");

    public Rental saveRental(Rental rental) throws Exception {
        try {
            dao.save(rental);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return rental;
    }

    public List<Rental> getRentalRowFromIvaVentas(Activity factura) throws Exception {
        List<Rental> rental = null;
        try {
            rental = dao.getRentalFromIvaVentas(factura);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return rental;
    }
    /*
     public void saveFacturaYRenglones(IvaVentas iv, List<ActivityRow> rf) throws Exception {
     dao.save(iv)
     if(listaClientes != null && !listaClientes.isEmpty()){
     for(Cliente cliente : listaClientes){
     Domicilio domicilio = cliente.getDomicilio();
     try{
     domicilio = db.saveDomicilio(domicilio);
     cliente.setDomicilio(domicilio);
     dao.save(cliente);
     }catch(HibernateException ex){
     throw new Exception("Ha ocurrido un problema intentando guardar el Cliente.\nPor favor intente nuevamente mas tarde.");
     }
     }
     }
     }
     */
    public List<Rental> getRenglonesDevolByFechas(Date df, Date af) throws Exception {
        List<Rental> rental = null;
        try {
            rental = dao.getRenglonesDevolByFechas(df, af);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return rental;
    }
    //getRenglonesDevolByFechasAndProducto
    public List<Rental> getRenglonesDevolByFechasAndProducto(Date df, Date af, Producto p) throws Exception {
        List<Rental> rental = null;
        try {
            rental = dao.getRenglonesDevolByFechasAndProducto(df, af, p);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return rental;
    }
}
