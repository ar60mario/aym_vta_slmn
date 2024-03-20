/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.bo;

import ar.com.ventas.dao.PresupuestoDAO;
import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.ActivityRow;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.Producto;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.services.ProductoService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;

/**
 *
 * @author Marcela
 */
public class PresupuestoBO {

    private final PresupuestoDAO dao = new PresupuestoDAO();
    private static final Logger logger = Logger.getLogger("PresupuestoBO");

    public void savePresupuestoCompleto(Customer cu, Routines ro, Activity act, Inventory in, List<ActivityRow> rf, Configuracion confi, List<Producto> ps) throws Exception {
        try {
            // actualizo cliente
            new CustomerBO().updateCustomer(cu);
            System.out.println("CU");
//            JOptionPane.showMessageDialog(null, "CU");
            // actualizo configuracion
            new RoutinesBO().updateFacturas(ro);
            System.out.println("RO");
//            JOptionPane.showMessageDialog(null, "RO");
            // actualizo configuracion
            System.out.println(confi);
            System.out.println(confi.getCajaAnteriorCerrada());
            System.out.println(confi.getId());
            
//            new ConfiguracionBO().updateConfiguracion(confi);
            System.out.println("CONFI");
//            JOptionPane.showMessageDialog(null, "CONFI");
            // grabo presupuesto en libro ventas
            Activity activity = new ActivityBO().saveActivity(act);
            System.out.println("ACT");
//            JOptionPane.showMessageDialog(null, "ACT");
            // grabo movimiento en cta cte
            in.setFactura(activity);
            new InventoryBO().saveInventory(in);
            System.out.println("IN");
//            JOptionPane.showMessageDialog(null, "IN");
            // actualizo y grabo los renglones de presupuesto  y stock
            Float ca;
            Float st;
            for (ActivityRow a : rf) {
                a.setActivity(activity);
                new ActivityRowBO().saveRenglon(a);
                System.out.println("RF");
//                Integer cod = a.getCodigoProducto();
//                Producto p = new ProductoService().getProductoByCodigo(cod);
//                ca = a.getCantidad();
//                if (p.getStock() != null) {
//                    st = p.getStock();
//                    st = st - ca;
//                    p.setStock(st);
//                    new ProductoBO().updateProducto(p);
//                } else {
//                    st = 0F;
//                    st = st - ca;
//                    p.setStock(st);
//                    new ProductoBO().updateProducto(p);
//                }
//                if (st < 0) {
//                    if (p.getUnidad() != null) {
//                        if (p.getUnidad()) {
//                            if (p.getProductoCaja() != null) {
//                                Producto caja = p.getProductoCaja();
//                                int can = p.getCantidadCaja();
//                                float stk1 = caja.getStock();
//                                stk1 -= 1;
//                                caja.setStock(stk1);
//                                try {
//                                    new ProductoBO().updateProducto(caja);
//                                } catch (Exception ex) {
//                                    Logger.getLogger(PresupuestoBO.class.getName()).log(Level.SEVERE, null, ex);
//                                }
//                                st += can;
//                            }
//                        }
//                    }
//                }
            }
            for(Producto pr:ps){
                new ProductoService().updateProducto(pr);
            }
        } catch (HibernateException ex) {
            throw new Exception(ex);
        }
    }
    /*
    public Cliente saveCliente(Cliente cliente) throws Exception{
        // Primero guardo la dirección del cliente.
        DomicilioBO domicilioBO = new DomicilioBO();
        Domicilio domicilioCliente = cliente.getDomicilio();
	domicilioCliente = domicilioBO.saveDomicilio(domicilioCliente);
        cliente.setDomicilio(domicilioCliente);
        
        try{
          dao.save(cliente);            
        }catch(HibernateException ex){
            throw new Exception(ex);
        }
        return cliente;
    }
    
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
     */
}
