/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ventas.frame;

import ar.com.ventas.entities.Activity;
import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.ClienteTraba;
import ar.com.ventas.entities.Customer;
import ar.com.ventas.entities.CustomerTraba;
import ar.com.ventas.services.ActivityService;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.ClienteTrabaService;
import ar.com.ventas.services.CustomerService;
import ar.com.ventas.services.CustomerTrabaService;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario
 */
public class NotaCreditoPedirCliente extends javax.swing.JFrame {

    private Cliente cliente = null;
    private Customer customer = null;
    private List<Cliente> clientes = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date fecha = new Date();
    private Calendar calendar;
    List<Activity> fact = null;

    /**
     * Creates new form NotaCreditoPedirCliente
     */
    public NotaCreditoPedirCliente() {
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        initComponents();
        limpiarCampos();
        limpiarTabla();
        codigoClienteTxt.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        codigoClienteTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buscarPorCodigoBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nombreClienteTxt = new javax.swing.JTextField();
        buscarPorNombreBtn = new javax.swing.JButton();
        comboClientes = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        desdeFechaTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        seleccionarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("CLIENTE DE DEVOLUCION");

        codigoClienteTxt.setText("CODIGO CLIENTE");
        codigoClienteTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoClienteTxtKeyPressed(evt);
            }
        });

        jLabel1.setText("Código Cliente:");

        buscarPorCodigoBtn.setText("Buscar");
        buscarPorCodigoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorCodigoBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Cliente:");

        nombreClienteTxt.setText("NOMBRE CLIENTE");
        nombreClienteTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreClienteTxtKeyPressed(evt);
            }
        });

        buscarPorNombreBtn.setText("Buscar");
        buscarPorNombreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarPorNombreBtnActionPerformed(evt);
            }
        });

        comboClientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClientesActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione:");

        jLabel4.setText("Desde Fecha:");

        desdeFechaTxt.setText("FECHA DESDE");
        desdeFechaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                desdeFechaTxtKeyPressed(evt);
            }
        });

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Número", "Importe"
            }
        ));
        jScrollPane1.setViewportView(tablaFacturas);

        seleccionarBtn.setText("Seleccionar");
        seleccionarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarPorCodigoBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarPorNombreBtn))
                            .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(desdeFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(seleccionarBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volverBtn)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(desdeFechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(buscarPorCodigoBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreClienteTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarPorNombreBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionarBtn)
                    .addComponent(volverBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarBtnActionPerformed
        if (tablaFacturas.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una factura");

        } else {
            seleccionar();
        }
    }//GEN-LAST:event_seleccionarBtnActionPerformed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        NotaCreditoSelectFrame ncsf = new NotaCreditoSelectFrame();
        ncsf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void buscarPorNombreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorNombreBtnActionPerformed
        if (!nombreClienteTxt.getText().isEmpty()) {
            llenarComboClientes();
        }
    }//GEN-LAST:event_buscarPorNombreBtnActionPerformed

    private void buscarPorCodigoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarPorCodigoBtnActionPerformed
        buscarClientePorCodigo();
    }//GEN-LAST:event_buscarPorCodigoBtnActionPerformed

    private void codigoClienteTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoClienteTxtKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!codigoClienteTxt.getText().isEmpty()) {
                buscarClientePorCodigo();
            }
        }
    }//GEN-LAST:event_codigoClienteTxtKeyPressed

    private void nombreClienteTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreClienteTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (!nombreClienteTxt.getText().isEmpty()) {
                llenarComboClientes();
                comboClientes.requestFocus();
                comboClientes.addFocusListener(null);
                comboClientes.showPopup();
            }
        }
    }//GEN-LAST:event_nombreClienteTxtKeyPressed

    private void desdeFechaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desdeFechaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (desdeFechaTxt.getText().isEmpty()) {
                desdeFechaTxt.setText(sdf.format(new Date()));
                desdeFechaTxt.requestFocus();
            } else {
                int largo = desdeFechaTxt.getText().length();
                if (largo == 2) {
                    Calendar cal = Calendar.getInstance();
                    int mes = cal.get(Calendar.MONTH) + 1;
                    int anio = cal.get(Calendar.YEAR);
                    String an = String.valueOf(anio);
                    String f = "0" + String.valueOf(mes);
                    if (f.length() > 2) {
                        f = f.substring(1, 3);
                    }
                    f = f + "/" + an;
                    desdeFechaTxt.setText(desdeFechaTxt.getText() + "/" + f);
                    codigoClienteTxt.requestFocus();
                } else {
                    if (largo == 5) {
                        Calendar cal = Calendar.getInstance();
                        int anio = cal.get(Calendar.YEAR);
                        String an = "/" + String.valueOf(anio);
                        desdeFechaTxt.setText(desdeFechaTxt.getText() + an);
                        codigoClienteTxt.requestFocus();
                    } else {
                        if (largo != 10) {
                            JOptionPane.showMessageDialog(this, "Error en fecha");
                            desdeFechaTxt.setText("");
//                          request focus mismo campo
                            desdeFechaTxt.requestFocus();
                        } else {
                            String veinte = desdeFechaTxt.getText().substring(6, 8);
                            if (!veinte.equals("20")) {
                                JOptionPane.showMessageDialog(this, "Error en AÑO");
//                              request focus mismo campo
                                desdeFechaTxt.requestFocus();
                            } else {
                                codigoClienteTxt.requestFocus();
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_desdeFechaTxtKeyPressed

    private void comboClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClientesActionPerformed
        int row = comboClientes.getSelectedIndex() - 1;
        if (row > -1) {
            cliente = clientes.get(row);
            codigoClienteTxt.setText(cliente.getCodigo());
            buscarClientePorCodigo();
        }
    }//GEN-LAST:event_comboClientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoPedirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoPedirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoPedirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotaCreditoPedirCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotaCreditoPedirCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarPorCodigoBtn;
    private javax.swing.JButton buscarPorNombreBtn;
    private javax.swing.JTextField codigoClienteTxt;
    private javax.swing.JComboBox comboClientes;
    private javax.swing.JTextField desdeFechaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreClienteTxt;
    private javax.swing.JButton seleccionarBtn;
    private javax.swing.JTable tablaFacturas;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        codigoClienteTxt.setText("");
        nombreClienteTxt.setText("");
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -30);
        desdeFechaTxt.setText(sdf.format(calendar.getTime()));
        comboClientes.removeAllItems();
        comboClientes.addItem("");
    }

    private void llenarComboClientes() {
        comboClientes.removeAllItems();
        comboClientes.addItem("");
        String filtro;
        clientes = null;
        if (!nombreClienteTxt.getText().isEmpty()) {
            filtro = nombreClienteTxt.getText();
            try {
                clientes = new ClienteService().getClientesByFiltro(filtro);
            } catch (Exception ex) {
                Logger.getLogger(VerCuentaCorrienteClienteFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (clientes != null && !clientes.isEmpty()) {
                for (Cliente cli : clientes) {
                    comboClientes.addItem(cli.getCodigo() + " " + cli.getRazonSocial());
                }
            }
        }
    }

    private void seleccionar() {
        int i = tablaFacturas.getSelectedRow();
        Activity iv = fact.get(i);
        //bloquearCliente();
        NotaCreditoDeFacturaFrame ncf = new NotaCreditoDeFacturaFrame(cliente, iv);
        ncf.setVisible(true);
        this.dispose();
    }

    private void desbloquearCliente() {
        String codigo = cliente.getCodigo();
        CustomerTraba cuTr = null;
        try {
            cuTr = new CustomerTrabaService().getClienteByCodigo(codigo);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoPedirCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuTr.setTraba2(false);
        try {
            new CustomerTrabaService().updateCliente(cuTr);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al bloquear Cliente");
        }
    }

    private void bloquearCliente() {
        String codigo = cliente.getCodigo();
        CustomerTraba cuTr = null;
        try {
            cuTr = new CustomerTrabaService().getClienteByCodigo(codigo);
        } catch (Exception ex) {
            Logger.getLogger(NotaCreditoPedirCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cuTr.setTraba2(true);
        try {
            new CustomerTrabaService().updateCliente(cuTr);
        } catch (Exception ex) {
            Logger.getLogger(FacturaFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error al bloquear Cliente");
        }
    }

    private void buscarClientePorCodigo() {
        if (!codigoClienteTxt.getText().isEmpty()) {
            cliente = null;
            String codigo = codigoClienteTxt.getText();
            try {
                cliente = new ClienteService().getClienteByCodigo(codigo);
                customer = new CustomerService().getCustomerByCodigo(codigo);
            } catch (Exception ex) {
                Logger.getLogger(NotaCreditoPedirCliente.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }
            if (cliente != null) {
                ClienteTraba ct = null;
                CustomerTraba cuTr = null;
                try {
                    ct = new ClienteTrabaService().getClienteByCodigo(codigo);
                    cuTr = new CustomerTrabaService().getClienteByCodigo(codigo);
                } catch (Exception ex) {
                    Logger.getLogger(NotaCreditoPedirCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (ct.getTraba1() != null) {
                    if (ct.getTraba1()) {
                        JOptionPane.showMessageDialog(this, "Cliente bloqueado para esta Operación");
                        return;
                    }
                }
                if (cuTr.getTraba2() != null) {
                    if (cuTr.getTraba2()) {
                        JOptionPane.showMessageDialog(this, "Cliente bloqueado para esta Operación");
                        return;
                    }
                }
                Date fechaAl = new Date();
                try {
                    fecha = sdf.parse(desdeFechaTxt.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(NotaCreditoPedirCliente.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                nombreClienteTxt.setText(cliente.getRazonSocial());
                List<Activity> facturas = null;
                fact = new ArrayList<Activity>();
                try {
                    facturas = new ActivityService().getAllActivityByCodigoYFecha(customer, fecha, fechaAl);
                } catch (Exception ex) {
                    Logger.getLogger(NotaCreditoPedirCliente.class.getName()).log(Level.SEVERE, null, ex);
                    return;
                }
                limpiarTabla();
                DefaultTableModel model = (DefaultTableModel) tablaFacturas.getModel();
                if (facturas != null) {
                    if (!facturas.isEmpty()) {
                        for (Activity movim : facturas) {
                            Object lin[] = new Object[3];
                            System.out.println(movim.getFecha());
                            if (movim.getTotal() > 0.0) {
                                fact.add(movim);
                                lin[0] = movim.getFecha();
                                lin[1] = movim.getNumeroFactura();
                                lin[2] = movim.getTotal();
                                model.addRow(lin);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No hay movimientos en el periodo");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No hay movimientos en el periodo");
                }
                tablaFacturas.setModel(model);
            } else {
                JOptionPane.showMessageDialog(this, "No existe codigo");
                codigoClienteTxt.setText("");
                codigoClienteTxt.requestFocus();
            }
        }
    }

    private void limpiarTabla() {
        int rows = tablaFacturas.getRowCount();
        if (rows > 0) {
            DefaultTableModel model = (DefaultTableModel) tablaFacturas.getModel();
            for (int i = 0; i < rows; i++) {
                model.removeRow(0);
            }
            tablaFacturas.setModel(model);
        }
    }
}
