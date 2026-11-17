
import javax.swing.JOptionPane;

public class FCajero extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FCajero.class.getName());

    Conexion cnx = new Conexion();
    String codigo;

    public FCajero() {
        this("");
    }

    public FCajero(String codigo) {
        this.codigo = codigo;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FONDATEL - CAJA");
        TConsultas.setDefaultEditor(Object.class, null); // la tabla es solo de consulta

        if (cnx.conectar("localhost", "fondatel", "root", "") == 1) {
            LUsuario.setText("Cajero: " + cnx.obtenerDato(String.format(Queries.nombre_empleado, codigo)));
            mostrarTicket(null);
        } else {
            JOptionPane.showMessageDialog(this, "Sin conexión. La ventana se cerrará...");
            System.exit(0);
        }
    }

    // Consulta la vista "ticket" (órdenes entregadas por cobrar) de todas las mesas o de una sola
    private void mostrarTicket(Integer mesa) {
        String consulta = (mesa == null) ? Queries.ticket_todos : String.format(Queries.ticket_mesa, mesa);
        String suma = (mesa == null) ? Queries.ticket_total : String.format(Queries.ticket_total_mesa, mesa);

        if (cnx.entablar(consulta, TConsultas) == 1) {
            Conexion.ajustarColumnas(TConsultas);
            String dato = cnx.obtenerDato(suma);
            double total = dato.isEmpty() ? 0 : Double.parseDouble(dato);
            LResumen.setText(String.format(java.util.Locale.US, "Consumos: %d   TOTAL A COBRAR: $%.2f",
                    TConsultas.getRowCount(), total));
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo consultar la vista ticket");
        }
    }

    // Ticket de una mesa; con el campo vacío muestra todos los tickets
    private void buscarMesa() {
        String texto = TFMesa.getText().trim();
        if (texto.isEmpty()) {
            mostrarTicket(null);
            return;
        }
        try {
            mostrarTicket(Integer.parseInt(texto));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La mesa debe ser un número entero");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        BTickets = new javax.swing.JButton();
        TFMesa = new javax.swing.JTextField();
        BMesa = new javax.swing.JButton();
        BPedidos = new javax.swing.JButton();
        BRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();
        LUsuario = new javax.swing.JLabel();
        LResumen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(0, 102, 153));
        jToolBar1.setRollover(true);

        BTickets.setBackground(new java.awt.Color(255, 204, 0));
        BTickets.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        BTickets.setText("TICKETS");
        BTickets.setFocusable(false);
        BTickets.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BTickets.setMaximumSize(new java.awt.Dimension(150, 64));
        BTickets.setMinimumSize(new java.awt.Dimension(150, 64));
        BTickets.setPreferredSize(new java.awt.Dimension(150, 64));
        BTickets.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BTickets.addActionListener(this::BTicketsActionPerformed);
        jToolBar1.add(BTickets);

        TFMesa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MESA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N
        TFMesa.setMaximumSize(new java.awt.Dimension(110, 64));
        TFMesa.setMinimumSize(new java.awt.Dimension(110, 64));
        TFMesa.setPreferredSize(new java.awt.Dimension(110, 64));
        TFMesa.addActionListener(this::TFMesaActionPerformed);
        jToolBar1.add(TFMesa);

        BMesa.setBackground(new java.awt.Color(255, 204, 0));
        BMesa.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        BMesa.setText("TICKET MESA");
        BMesa.setFocusable(false);
        BMesa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BMesa.setMaximumSize(new java.awt.Dimension(170, 64));
        BMesa.setMinimumSize(new java.awt.Dimension(170, 64));
        BMesa.setPreferredSize(new java.awt.Dimension(170, 64));
        BMesa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BMesa.addActionListener(this::BMesaActionPerformed);
        jToolBar1.add(BMesa);

        BPedidos.setBackground(new java.awt.Color(255, 204, 0));
        BPedidos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        BPedidos.setText("PEDIDOS");
        BPedidos.setFocusable(false);
        BPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BPedidos.setMaximumSize(new java.awt.Dimension(150, 64));
        BPedidos.setMinimumSize(new java.awt.Dimension(150, 64));
        BPedidos.setPreferredSize(new java.awt.Dimension(150, 64));
        BPedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BPedidos.addActionListener(this::BPedidosActionPerformed);
        jToolBar1.add(BPedidos);

        BRegresar.setText("Regresar");
        BRegresar.setFocusable(false);
        BRegresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BRegresar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BRegresar.addActionListener(this::BRegresarActionPerformed);
        jToolBar1.add(BRegresar);

        TConsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TConsultas);

        LUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LUsuario.setText("Cajero:");

        LResumen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LResumen.setText("Consumos: 0   TOTAL A COBRAR: $0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LUsuario)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LResumen)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LUsuario)
                    .addComponent(LResumen))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTicketsActionPerformed
        TFMesa.setText("");
        mostrarTicket(null);
    }//GEN-LAST:event_BTicketsActionPerformed

    private void TFMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFMesaActionPerformed
        buscarMesa();
    }//GEN-LAST:event_TFMesaActionPerformed

    private void BMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMesaActionPerformed
        buscarMesa();
    }//GEN-LAST:event_BMesaActionPerformed

    private void BPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPedidosActionPerformed
        // Vista "pedidos": todas las órdenes sin importar su estado
        if (cnx.entablar(Queries.pedidos_todos, TConsultas) == 1) {
            Conexion.ajustarColumnas(TConsultas);
            LResumen.setText("Pedidos mostrados: " + TConsultas.getRowCount());
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo consultar la vista pedidos");
        }
    }//GEN-LAST:event_BPedidosActionPerformed

    private void BRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegresarActionPerformed
        cnx.desconectar();              // cierra la conexión de esta ventana
    this.dispose();                 // cierra FCocinero / FMesero / FCajero
    new FAcceso().setVisible(true); // vuelve al login
    }//GEN-LAST:event_BRegresarActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FCajero().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BMesa;
    private javax.swing.JButton BPedidos;
    private javax.swing.JButton BRegresar;
    private javax.swing.JButton BTickets;
    private javax.swing.JLabel LResumen;
    private javax.swing.JLabel LUsuario;
    private javax.swing.JTable TConsultas;
    private javax.swing.JTextField TFMesa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
