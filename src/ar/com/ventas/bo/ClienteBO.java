/*
 * Aqui va toda la lógica de validaciones respecto a los Administradores.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.ClienteDAO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Domicilio;
import ar.com.ventas.entities.Vendedor;
import ar.com.ventas.util.Constantes;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author Mar y Mar Informatica
 */
public class ClienteBO {

    private final ClienteDAO dao = new ClienteDAO();

    private static final Logger logger = Logger.getLogger("ClienteBO");

    public List<Cliente> getAllClientes() throws Exception {
        List<Cliente> listClientes = null;
        try {
            listClientes = dao.getAll(Cliente.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listClientes;
    }

    public List<Cliente> getAllClientesActivos() throws Exception {
        List<Cliente> listClientes = null;
        try {
            listClientes = dao.getAllClientesActivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listClientes;
    }

    public Integer getCantidad() throws Exception {
        Integer can = 0;
        try {
            can = dao.getCantidad();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return can;
    }

    public Cliente saveCliente(Cliente cliente) throws Exception {
        DomicilioBO domicilioBO = new DomicilioBO();
        Domicilio domicilioCliente = cliente.getDomicilio();
        domicilioCliente = domicilioBO.saveDomicilio(domicilioCliente);
        cliente.setDomicilio(domicilioCliente);
        try {
            dao.save(cliente);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cliente;
    }

    public void updateCliente(Cliente cliente) throws Exception {

        // Primero guardo la dirección del administrador.
//        DomicilioBO domicilioBO = new DomicilioBO();        
//        Domicilio domicilioCliente = cliente.getDomicilio();
//        domicilioCliente = domicilioBO.updateDomicilio(domicilioCliente);
//        cliente.setDomicilio(domicilioCliente);
        try {
            cliente = (Cliente) dao.update(cliente);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }

    }

    public List<Cliente> getClienteByPagina(int paginaActual) throws Exception {

        List<Cliente> listadoClientes = null;
        int start = 0;
        if (paginaActual > 1) {
            start = ((paginaActual - 1) * Constantes.MAX_RESULTS) + 1;
        }

        try {
            listadoClientes = dao.getAll(Cliente.class, start);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }

        return listadoClientes;

    }

    public int getClientesCount() throws Exception {

        int cantidad = 0;

        try {
            cantidad = dao.getCount(Cliente.class);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }

        return cantidad;

    }

    public void deleteCliente(Cliente cliente) throws Exception {

        try {
            dao.delete(cliente);

        } catch (HibernateException ex) {

            throw new Exception(ex);
        }
    }

    public Cliente getClienteByCodigo(String codigo) throws Exception {
        Cliente cliente = null;
        try {
            cliente = dao.getByCodigo(codigo);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return cliente;
    }

    public List<Cliente> getClientesOrdenado() throws Exception {

        List<Cliente> listadoClientes = null;
        try {
            listadoClientes = dao.getAllClientesOrdenado();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoClientes;

    }

    public List<Cliente> getAllClientesOrdenadoByPagina(Integer pagina, Integer limite) throws Exception {
        List<Cliente> listadoClientes = null;
        try {
            listadoClientes = dao.getAllClientesOrdenadoByPagina(pagina, limite);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoClientes;
    }

    public List<Cliente> getUltimos(Integer orden, Integer limite) throws Exception {
        List<Cliente> listadoClientes = null;
        List<Cliente> listadoInverso = new ArrayList<>();
        try {
            listadoClientes = dao.getUltimos(orden, limite);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        if (listadoClientes != null && !listadoClientes.isEmpty()) {
            for (int a = listadoClientes.size(); a > 0; a--) {
                Cliente cl = listadoClientes.get(a - 1);
                listadoInverso.add(cl);
            }
        }
        return listadoInverso;
    }

    public List<Cliente> getUltimosByFiltro(String filtro, Integer orden, Integer limite) throws Exception {
        List<Cliente> listadoClientes = null;
        List<Cliente> listadoInverso = new ArrayList<>();
        try {
            listadoClientes = dao.getUltimosByFiltro(filtro, orden, limite);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        for (int a = listadoClientes.size(); a > 0; a--) {
            Cliente cl = listadoClientes.get(a - 1);
            listadoInverso.add(cl);
        }
        return listadoInverso;
    }

    public Long getUltimoId() throws Exception {
        Long id;
        try {
            id = dao.getUltimoId();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return id;
    }

    public List<Cliente> getClientesByFiltro(String filtro) throws Exception {
        List<Cliente> clientes = null;
        try {
            clientes = dao.getClientesByFiltro(filtro);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return clientes;
    }

    public List<Cliente> getClientesComienzaByFiltro(String filtro, Integer pagina, Integer limite) throws Exception {
        List<Cliente> clientes = null;
        try {
            clientes = dao.getClientesComienzaByFiltro(filtro, pagina, limite);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return clientes;
    }

    public List<Cliente> getClientesByFiltroPaginado(String filtro, Integer pagina, Integer limite) throws Exception {
        List<Cliente> clientes = null;
        try {
            clientes = dao.getClientesByFiltroPaginado(filtro, pagina, limite);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return clientes;
    }

    public List<Cliente> getClientesInactivosByFiltroOrdenado(String f) throws Exception {
        List<Cliente> clientes = null;
        try {
            clientes = dao.getClientesInactivosByFiltroOrdenado(f);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return clientes;
    }

    public List<Cliente> getClientesByFiltroNumerico(String f) throws Exception {
        List<Cliente> clientes = null;
        try {
            clientes = dao.getClientesByFiltroNumerico(f);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return clientes;
    }

    public List<Cliente> getClientesByFiltroNumericoPaginado(String f, Integer pagina, Integer limite) throws Exception {
        List<Cliente> clientes = null;
        try {
            clientes = dao.getClientesByFiltroNumericoPaginado(f, pagina, limite);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return clientes;
    }

    public void saveListaClientes(List<Cliente> listaClientes) throws Exception {
        DomicilioBO db = new DomicilioBO();

        if (listaClientes != null && !listaClientes.isEmpty()) {
            for (Cliente cliente : listaClientes) {
                Domicilio domicilio = cliente.getDomicilio();
                try {
                    domicilio = db.saveDomicilio(domicilio);
                    cliente.setDomicilio(domicilio);
                    dao.save(cliente);
                } catch (HibernateException ex) {
                    throw new Exception("Ha ocurrido un problema intentando guardar el Cliente.\nPor favor intente nuevamente mas tarde.");
                }
            }
        }
    }

    public List<Cliente> getClientesOrdenadoPorNumero() throws Exception {

        List<Cliente> listadoClientes = null;
        try {
            listadoClientes = dao.getAllClientesOrdenadoPorNumero();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoClientes;

    }

    public List<Cliente> getClientesOrdenadoPorNumeroPaginado(Integer pagina, Integer limite) throws Exception {
        List<Cliente> listadoClientes = null;
        try {
            listadoClientes = dao.getClientesOrdenadoPorNumeroPaginado(pagina, limite);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listadoClientes;
    }

    public List<Cliente> getClientesDeudores() throws Exception {
        List<Cliente> clientes = null;
        try {
            clientes = dao.getClientesDeudores();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return clientes;
    }

    public List<Cliente> getAllClientesConSaldo() throws Exception {
        List<Cliente> clientes = null;
        try {
            clientes = dao.getAllClientesConSaldo();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return clientes;
    }

    public List<Cliente> getClientesConSaldoInactivos() throws Exception {
        List<Cliente> clientes = null;
        try {
            clientes = dao.getClientesConSaldoInactivos();
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return clientes;
    }

    public List<Cliente> getByVendedor(Vendedor vendedor) throws Exception {
        List<Cliente> listClientes = null;
        try {
            listClientes = dao.getByVendedor(vendedor);
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
        return listClientes;
    }
}
