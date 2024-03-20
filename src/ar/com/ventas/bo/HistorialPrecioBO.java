/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.HistorialPrecioDAO;
import ar.com.ventas.entities.HistorialPrecio;
import ar.com.ventas.entities.Producto;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class HistorialPrecioBO {

    private final HistorialPrecioDAO dao = new HistorialPrecioDAO();

    private static final Logger logger = Logger.getLogger("HistorialPrecioBO");

    public List<HistorialPrecio> getHistorialPrecioByProducto(Producto p) throws Exception {
        List<HistorialPrecio> hp = null;
        try {
            hp = dao.getByProducto(p);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return hp;
    }

    public HistorialPrecio saveHistorialPrecio(HistorialPrecio hp) throws Exception {
        try {
            hp = (HistorialPrecio) dao.save(hp);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return hp;
    }
    
    public void deleteHistorialPrecio(HistorialPrecio hp) throws Exception {
        try {
            dao.delete(hp);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
}
