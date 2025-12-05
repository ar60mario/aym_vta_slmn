package ar.com.ventas.frame;

import ar.com.ventas.entities.Cliente;
import ar.com.ventas.entities.Payment;
import ar.com.ventas.entities.Recibo;
import ar.com.ventas.entities.Recibo2;
import ar.com.ventas.main.MainFrame;
import ar.com.ventas.services.ClienteService;
import ar.com.ventas.services.PaymentService;
import ar.com.ventas.services.ReciboService;
import ar.com.ventas.util.Constantes;
import ar.com.ventas.util.UtilFrame;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ListarRecibosNuevaVersionFrame extends javax.swing.JFrame {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat df = new DecimalFormat("#0.00");
    private DecimalFormat df_sm = new DecimalFormat("$#,##0.00");
    private DecimalFormat df_hora = new DecimalFormat("00");
    private List<Recibo> recibos;
    private List<Payment> recibis;
    private List<Recibo2> recibosFinal;
    private JPanel contentPanel;
    private Double totalAzul;
    private Double totalSalmon;

    public ListarRecibosNuevaVersionFrame() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(245, 222, 179));
        colocarFecha();
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fechaTxt = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();
        volverBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRecibos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        totalSalmonTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        totalAzulTxt = new javax.swing.JTextField();
        sumaTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VER RECIBOS DIARIOS");

        jLabel1.setText("Fecha:");

        fechaTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechaTxt.setText("FECHA");
        fechaTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fechaTxtKeyPressed(evt);
            }
        });

        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        volverBtn.setText("Volver");
        volverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBtnActionPerformed(evt);
            }
        });

        tablaRecibos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Núm.Rc.", "Hora", "Cliente", "Nombre", "Importe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaRecibos);
        if (tablaRecibos.getColumnModel().getColumnCount() > 0) {
            tablaRecibos.getColumnModel().getColumn(0).setPreferredWidth(40);
            tablaRecibos.getColumnModel().getColumn(1).setPreferredWidth(15);
            tablaRecibos.getColumnModel().getColumn(3).setPreferredWidth(350);
            tablaRecibos.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        jLabel2.setText("Total Salmón:");

        totalSalmonTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalSalmonTxt.setText("TS");

        jLabel3.setText("Total Azul:");

        totalAzulTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalAzulTxt.setText("TA");

        sumaTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        sumaTxt.setText("S");

        jLabel4.setText("Suma:");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(totalSalmonTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalAzulTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sumaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                        .addComponent(volverBtn))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBtn)
                    .addComponent(jLabel2)
                    .addComponent(totalSalmonTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(totalAzulTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sumaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaTxtKeyPressed
        if (evt.getKeyCode() == 10) {
            if (fechaTxt.getText().isEmpty()) {
                fechaTxt.setText(sdf.format(new Date()));
                fechaTxt.requestFocus();
            } else {
                int largo = fechaTxt.getText().length();
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
                    fechaTxt.setText(fechaTxt.getText() + "/" + f);
                    buscarRecibos();
                } else {
                    if (largo == 5) {
                        Calendar cal = Calendar.getInstance();
                        int anio = cal.get(Calendar.YEAR);
                        String an = "/" + String.valueOf(anio);
                        fechaTxt.setText(fechaTxt.getText() + an);
                        buscarRecibos();
                    } else {
                        if (largo != 10) {
                            JOptionPane.showMessageDialog(this, "Error en fecha");
                            fechaTxt.setText("");
//                          request focus mismo campo
                            fechaTxt.requestFocus();
                        } else {
                            String veinte = fechaTxt.getText().substring(6, 8);
                            if (!veinte.equals("20")) {
                                JOptionPane.showMessageDialog(this, "Error en AÑO");
//                              request focus mismo campo
                                fechaTxt.requestFocus();
                            } else {
                                buscarRecibos();
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_fechaTxtKeyPressed

    private void volverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBtnActionPerformed
        volver();
    }//GEN-LAST:event_volverBtnActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
        buscarRecibos();
    }//GEN-LAST:event_buscarBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ListarRecibosNuevaVersionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarRecibosNuevaVersionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarRecibosNuevaVersionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarRecibosNuevaVersionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarRecibosNuevaVersionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarBtn;
    private javax.swing.JTextField fechaTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField sumaTxt;
    private javax.swing.JTable tablaRecibos;
    private javax.swing.JTextField totalAzulTxt;
    private javax.swing.JTextField totalSalmonTxt;
    private javax.swing.JButton volverBtn;
    // End of variables declaration//GEN-END:variables

    private void colocarFecha() {
        fechaTxt.setText(sdf.format(new Date()));
        sumaTxt.setText("");
        totalAzulTxt.setText("");
        totalSalmonTxt.setText("");
        contentPanel = panel;
        contentPanel.setBackground(new java.awt.Color(Constantes.getR(), Constantes.getG(), Constantes.getB()));
        JFrame jFrame = ListarRecibosNuevaVersionFrame.this;
        jFrame.setLocationRelativeTo(null);
        String str0 = "-"; // + " " + str1;
        contentPanel.setBorder(new EmptyBorder(5, 5, 100, 5));
        contentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),
                str0, TitledBorder.LEFT, TitledBorder.BELOW_BOTTOM));
        jFrame.setDefaultCloseOperation(0);
        setContentPane(contentPanel);

    }

    private void llenarTabla() {
        if (recibosFinal != null && !recibosFinal.isEmpty()) {
            DefaultTableModel tbl = (DefaultTableModel) tablaRecibos.getModel();
            Collections.sort(recibosFinal);
            for (Recibo2 r2 : recibosFinal) {
                Object o[] = new Object[5];
                o[0] = r2.getNumero();
                o[1] = r2.getTimer2();
                Cliente cli2 = r2.getCliente();
                String cliente = cli2.getRazonSocial() + " ";
                if (cli2.getAlias() != null) {
                    cliente += cli2.getAlias();
                }
                o[2] = cli2.getCodigo();
                o[3] = cliente;
                o[4] = df_sm.format(r2.getImporte());
                tbl.addRow(o);
            }
            tablaRecibos.setModel(tbl);
            totalAzulTxt.setText(df_sm.format(totalAzul));
            totalSalmonTxt.setText(df_sm.format(totalSalmon));
            sumaTxt.setText(df_sm.format(totalSalmon + totalAzul));
        }
    }

    private void volver() {
        MainFrame mf = new MainFrame();
        mf.setVisible(true);
        this.dispose();
    }

    private void buscarRecibos() {
        recibosFinal = new ArrayList<>();
        limpiarTabla();
        recibos = null;
        recibis = null;
        Date f;
        try {
            f = sdf.parse(fechaTxt.getText());
        } catch (ParseException ex) {
            Logger.getLogger(ListarRecibosNuevaVersionFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro.340 - FECHA");
            return;
        }

        if (f != null) {
            try {
                recibos = new ReciboService().getRecibosByFecha(f);
            } catch (Exception ex) {
                Logger.getLogger(ListarRecibosNuevaVersionFrame.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "ERROR Nro.350 - RECIBOS AZUL");
                return;
            }
        }

        try {
            recibis = new PaymentService().getPaymentByDia(f);
        } catch (Exception ex) {
            Logger.getLogger(ListarRecibosNuevaVersionFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "ERROR Nro.357 - RECIBOS SALMON");
            return;
        }
        totalAzul = 0.0;
        if (recibos != null && !recibos.isEmpty()) {
            for (Recibo r1 : recibos) {
                Recibo2 r2 = new Recibo2();
                r2.setAzul(true);
                r2.setCliente(r1.getCliente());
                r2.setFecha(r1.getFecha());
                r2.setImporte(r1.getImporte());
                totalAzul += r1.getImporte();
                r2.setNumero(r1.getNumero());
                String hh = df_hora.format(r1.getHora());
                String mm = df_hora.format(r1.getMinuto());
                String ss = df_hora.format(r1.getSegundo());
                r2.setTimer2(hh + ":" + mm + ":" + ss);
                recibosFinal.add(r2);
            }
        }
        totalSalmon = 0.0;
        if (recibis != null && !recibis.isEmpty()) {
            for (Payment r3 : recibis) {
                Recibo2 r2 = new Recibo2();
                r2.setAzul(true);
                Cliente cliente;
                String cod = r3.getCliente().getCodigo();
                try {
                    cliente = new ClienteService().getClienteByCodigo(cod);
                } catch (Exception ex) {
                    Logger.getLogger(ListarRecibosNuevaVersionFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "ERROR 390 - CLIENTE");
                    return;
                }
                r2.setCliente(cliente);
                r2.setFecha(r3.getFecha());
                r2.setImporte(r3.getImporte());
                totalSalmon += r3.getImporte();
                r2.setNumero(r3.getNumero());
                String hh = df_hora.format(r3.getHora());
                String mm = df_hora.format(r3.getMinuto());
                String ss = df_hora.format(r3.getSegundo());
                r2.setTimer2(hh + ":" + mm + ":" + ss);
                recibosFinal.add(r2);
            }
        }
        llenarTabla();
    }

    private void limpiarTabla() {
        UtilFrame.limpiarTabla(tablaRecibos);
    }
}
