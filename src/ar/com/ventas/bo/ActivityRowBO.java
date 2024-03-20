/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.ActivityRowDAO;
import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Rubro;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mario
 */
public class ActivityRowBO {

    private final ActivityRowDAO dao = new ActivityRowDAO();

    private static final Logger logger = Logger.getLogger("ActivityRowBO");

    public ActivityRow saveRenglon(ActivityRow activityRow) throws Exception {
        try {
            dao.save(activityRow);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return activityRow;
    }

    public List<ActivityRow> getAllActivityRowFromIvaVentas(Activity iv) throws Exception {
        List<ActivityRow> listActivityRow = null;
        try {
            listActivityRow = dao.getAllActivityRowFromIvaVentas(iv);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivityRow;
    }

    public List<ActivityRow> getRowByFecha(Date df, Date af) throws Exception {
        List<ActivityRow> listActivityRow = null;
        try {
            listActivityRow = dao.getRowByFecha(df, af);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivityRow;
    }
    
    public List<ActivityRow> getRowByFechaAndRubro(Date df, Date af, Rubro rubro) throws Exception {
        List<ActivityRow> listActivityRow = null;
        List<ActivityRow> actiRow2 = new ArrayList<>();
        Long id1 = rubro.getId();
        try {
            listActivityRow = dao.getRowByFechaAndRubro(df, af);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        if(listActivityRow != null && !listActivityRow.isEmpty()){
            for(ActivityRow ar:listActivityRow){
                Integer cod1 = ar.getCodigoProducto();
                Producto pr = null;
                pr = new ProductoBO().getAllProductoByCodigo(cod1);
                if(pr!=null){
                    Long id2 = pr.getRubro().getId();
                    if(id1.equals(id2)){
                        actiRow2.add(ar);
                    }
                }
            }
        }
        return actiRow2;
    }
    
    public List<ActivityRow> getRowByFechaAndProducto(Date df, Date af, Producto p) throws Exception {
        List<ActivityRow> listActivityRow = null;
        try {
            listActivityRow = dao.getRowByFechaAndProducto(df, af, p);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listActivityRow;
    }
}
