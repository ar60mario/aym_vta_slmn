/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.CustomerDAO;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.util.Constantes;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class CustomerBO {

    private final CustomerDAO dao = new CustomerDAO();

    private static final Logger logger = Logger.getLogger("CustomerBO");

    public List<Customer> getAllCustomers() throws Exception {
        List<Customer> listCustomers = null;
        try {
            listCustomers = dao.getAll(Customer.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listCustomers;
    }

    public Customer saveCustomer(Customer customer) throws Exception {
        try {
            dao.save(customer);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return customer;
    }

    public void updateCustomer(Customer customer) throws Exception {
        try {
            customer = (Customer) dao.update(customer);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public List<Customer> getCustomerByPagina(int paginaActual) throws Exception {
        List<Customer> listadoCustomers = null;
        int start = 0;
        if (paginaActual > 1) {
            start = ((paginaActual - 1) * Constantes.MAX_RESULTS) + 1;
        }
        try {
            listadoCustomers = dao.getAll(Customer.class, start);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoCustomers;
    }

    public int getCustomersCount() throws Exception {
        int cantidad = 0;
        try {
            cantidad = dao.getCount(Customer.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cantidad;
    }

    public void deleteCustomer(Customer customer) throws Exception {
        try {
            dao.delete(customer);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }

    public Customer getCustomerByCodigo(String codigo) throws Exception {
        Customer customer = null;
        try {
            customer = dao.getByCodigo(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return customer;
    }

    public List<Customer> getCustomersOrdenado() throws Exception {
        List<Customer> listadoCustomers = null;
        try {
            listadoCustomers = dao.getAllCustomersOrdenado();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoCustomers;
    }

    public void saveListaCustomers(List<Customer> listaCustomers) throws Exception {
        if (listaCustomers != null && !listaCustomers.isEmpty()) {
            for (Customer customer : listaCustomers) {
                try {
                    dao.save(customer);
                } catch (HibernateException ex) {
                    throw new Exception("Ha ocurrido un problema intentando guardar el Customer.\nPor favor intente nuevamente mas tarde.");
                }
            }
        }
    }

    public List<Customer> getAllClientesConSaldo() throws Exception {
        List<Customer> listadoCustomers = null;
        try {
            listadoCustomers = dao.getAllClientesConSaldo();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoCustomers;
    }
    
    public List<Customer> getClientesConSaldoInactivos() throws Exception {
        List<Customer> listadoCustomers = null;
        try {
            listadoCustomers = dao.getClientesConSaldoInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoCustomers;
    }

    public List<Customer> getClientesDeudores() throws Exception {
        List<Customer> listadoCustomers = null;
        try {
            listadoCustomers = dao.getClientesDeudores();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoCustomers;
    }
    
    public List<Customer> getAllCustomersInactivosOrdenado() throws Exception {
        List<Customer> listadoCustomers = null;
        try {
            listadoCustomers = dao.getAllCustomersInactivosOrdenado();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoCustomers;
    }
}
