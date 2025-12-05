package ar.com.ventas.services;

import ar.com.ventas.bo.ClienteBO;
import ar.com.ventas.bo.ConfiguracionBO;
import ar.com.ventas.bo.CtaCteClienteBO;
import ar.com.ventas.bo.CustomerBO;
import ar.com.ventas.bo.InventoryBO;
import ar.com.ventas.bo.PaymentBO;
import ar.com.ventas.bo.ReciboBO;
import ar.com.ventas.bo.RoutinesBO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.CtaCteCliente;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.Payment;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.util.HibernateUtil;
import ar.com.ventas.util.HibernateUtils;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARIO
 */
public class GrabarCobranzaAzulAndSalmonCompletaService {

    public void grabarCobranzaAzulAndSalmonCompleta(Cliente cliente1,
            Configuracion configuracion1, Recibo recibo1, CtaCteCliente ctaCorriente1, Customer cliente2,
            Routines configuracion2, Payment recibo2, Inventory ctaCorriente2) throws Exception {
        Session session1 = HibernateUtils.getSessionFactory().getCurrentSession();
        Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session1.beginTransaction();
        Transaction tx2 = session2.beginTransaction();
        try {
            cliente1 = new ClienteBO().updateCliente(cliente1);
            new ConfiguracionBO().updateConfiguracion(configuracion1);
            recibo1 = new ReciboBO().saveRecibo(recibo1);
            ctaCorriente1.setCliente(cliente1);
            ctaCorriente1.setRecibo(recibo1);
            new CtaCteClienteBO().saveCtaCteCliente(ctaCorriente1);
            
            cliente2 = new CustomerBO().updateCustomer(cliente2);
            new RoutinesBO().updateRoutines(configuracion2);
            recibo2 = new PaymentBO().savePayment(recibo2);
            ctaCorriente2.setCliente(cliente2);
            ctaCorriente2.setRecibo(recibo2);
            new InventoryBO().saveInventory(ctaCorriente2);
//            tx.commit();
//            JOptionPane.showMessageDialog(null, "si");
            tx1.commit();
            tx2.commit();
        } catch (Exception ex) {
            tx1.rollback();
            tx2.rollback();
            throw new Exception(ex);
        }
    }
}
