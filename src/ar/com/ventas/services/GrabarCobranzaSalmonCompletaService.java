package ar.com.ventas.services;

import ar.com.ventas.bo.CustomerBO;
import ar.com.ventas.bo.InventoryBO;
import ar.com.ventas.bo.PaymentBO;
import ar.com.ventas.bo.RoutinesBO;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.Inventory;
import ar.com.ventas.entities.Payment;
import ar.com.ventas.entities.Routines;
import ar.com.ventas.util.HibernateUtil;
import ar.com.ventas.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARIO
 */
public class GrabarCobranzaSalmonCompletaService {

    public void grabarCobranzaSalmonCompleta(Customer cliente,
            Routines configuracion, Payment recibo, Inventory ctaCorriente) throws Exception {
//        Session session1 = HibernateUtils.getSessionFactory().getCurrentSession();
        Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
//        Transaction tx1 = session1.beginTransaction();
        Transaction tx2 = session2.beginTransaction();
        try {
            cliente = new CustomerBO().updateCustomer(cliente);
            new RoutinesBO().updateRoutines(configuracion);
            recibo = new PaymentBO().savePayment(recibo);
            ctaCorriente.setCliente(cliente);
            ctaCorriente.setRecibo(recibo);
            new InventoryBO().saveInventory(ctaCorriente);
//            tx.commit();
//            JOptionPane.showMessageDialog(null, "si");
//            tx1.commit();
            tx2.commit();
        } catch (Exception ex) {
//            tx1.rollback();
            tx2.rollback();
            throw new Exception(ex);
        }
    }
}
