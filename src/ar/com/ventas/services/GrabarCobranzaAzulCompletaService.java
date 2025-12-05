package ar.com.ventas.services;

import ar.com.ventas.bo.ClienteBO;
import ar.com.ventas.bo.ConfiguracionBO;
import ar.com.ventas.bo.CtaCteClienteBO;
import ar.com.ventas.bo.ReciboBO;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Configuracion;
import ar.com.ventas.entities.CtaCteCliente;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.util.HibernateUtil;
import ar.com.ventas.util.HibernateUtils;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author MARIO
 */
public class GrabarCobranzaAzulCompletaService {

    public void grabarCobranzaAzulCompleta(Cliente cliente,
            Configuracion configuracion, Recibo recibo, CtaCteCliente ctaCorriente) throws Exception {
        Session session1 = HibernateUtils.getSessionFactory().getCurrentSession();
//        Session session2 = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx1 = session1.beginTransaction();
//        Transaction tx2 = session2.beginTransaction();
        try {
            cliente = new ClienteBO().updateCliente(cliente);
            new ConfiguracionBO().updateConfiguracion(configuracion);
            recibo = new ReciboBO().saveRecibo(recibo);
            ctaCorriente.setCliente(cliente);
            ctaCorriente.setRecibo(recibo);
            new CtaCteClienteBO().saveCtaCteCliente(ctaCorriente);
//            tx.commit();
//            JOptionPane.showMessageDialog(null, "si");
            tx1.commit();
//            tx2.commit();
        } catch (Exception ex) {
            tx1.rollback();
//            tx2.rollback();
            throw new Exception(ex);
        }
    }
}
