
import javax.swing.JOptionPane;

public class FMesero extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FMesero.class.getName());

    Conexion cnx = new Conexion();
    String codigo;
    boolean cargando = false; // evita consultas repetidas al reiniciar los filtros

    public FMesero() {
        this("");
    }

    public FMesero(String codigo) {
        this.codigo = codigo;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FONDATEL - MESERO");
        TConsultas.setDefaultEditor(Object.class, null); // la tabla es solo de consulta

        if (cnx.conectar("localhost", "fondatel", "root", "") == 1) {
            LUsuario.setText("Mesero: " + cnx.obtenerDato(String.format(Queries.nombre_empleado, codigo)));
            mostrar();
        } else {
            JOptionPane.showMessageDialog(this, "Sin conexión. La ventana se cerrará...");
            System.exit(0);
        }
    }

    // Arma la consulta sobre la vista "pedidos" según los filtros elegidos y la muestra
    private void mostrar() {
        java.util.ArrayList<String> filtros = new java.util.ArrayList<>();

        // Si entró un mesero (desde FAcceso) solo ve sus pedidos
        if (!codigo.isEmpty()) {
            filtros.add(String.format(Queries.pedidos_por_mesero, codigo));
        }

        String estado = CBEstado.getSelectedItem().toString();
        if (!estado.equals("Todos")) {
            filtros.add(String.format(Queries.pedidos_por_estado, estado));
        }

        String mesa = TFMesa.getText().trim();
        if (!mesa.isEmpty()) {
            try {
                filtros.add(String.format(Queries.pedidos_por_mesa, Integer.parseInt(mesa)));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La mesa debe ser un número entero");
                return;
            }
        }

        String consulta = Queries.pedidos_vista;
        if (!filtros.isEmpty()) {
            consulta += " WHERE " + String.join(" AND ", filtros);
        }
        consulta += " ORDER BY folio DESC";

        if (cnx.entablar(consulta, TConsultas) == 1) {
            Conexion.ajustarColumnas(TConsultas);
            LResumen.setText("Pedidos mostrados: " + TConsultas.getRowCount());
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo consultar la vista pedidos");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        BMisPedidos = new javax.swing.JButton();
        CBEstado = new javax.swing.JComboBox<>();
        TFMesa = new javax.swing.JTextField();
        BBuscar = new javax.swing.JButton();
        BRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();
        LUsuario = new javax.swing.JLabel();
        LResumen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(0, 102, 153));
        jToolBar1.setRollover(true);

        BMisPedidos.setBackground(new java.awt.Color(255, 204, 0));
        BMisPedidos.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        BMisPedidos.setText("MIS PEDIDOS");
        BMisPedidos.setFocusable(false);
        BMisPedidos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BMisPedidos.setMaximumSize(new java.awt.Dimension(170, 64));
        BMisPedidos.setMinimumSize(new java.awt.Dimension(170, 64));
        BMisPedidos.setPreferredSize(new java.awt.Dimension(170, 64));
        BMisPedidos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BMisPedidos.addActionListener(this::BMisPedidosActionPerformed);
        jToolBar1.add(BMisPedidos);

        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ordenado", "preparando", "entregado", "devuelto", "cancelado", "pagado" }));
        CBEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ESTADO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N
        CBEstado.setMaximumSize(new java.awt.Dimension(170, 64));
        CBEstado.setMinimumSize(new java.awt.Dimension(170, 64));
        CBEstado.setPreferredSize(new java.awt.Dimension(170, 64));
        CBEstado.addItemListener(this::CBEstadoItemStateChanged);
        jToolBar1.add(CBEstado);

        TFMesa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MESA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N
        TFMesa.setMaximumSize(new java.awt.Dimension(110, 64));
        TFMesa.setMinimumSize(new java.awt.Dimension(110, 64));
        TFMesa.setPreferredSize(new java.awt.Dimension(110, 64));
        TFMesa.addActionListener(this::TFMesaActionPerformed);
        jToolBar1.add(TFMesa);

        BBuscar.setBackground(new java.awt.Color(255, 204, 0));
        BBuscar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        BBuscar.setText("BUSCAR");
        BBuscar.setFocusable(false);
        BBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BBuscar.setMaximumSize(new java.awt.Dimension(140, 64));
        BBuscar.setMinimumSize(new java.awt.Dimension(140, 64));
        BBuscar.setPreferredSize(new java.awt.Dimension(140, 64));
        BBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BBuscar.addActionListener(this::BBuscarActionPerformed);
        jToolBar1.add(BBuscar);

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
        LUsuario.setText("Mesero:");

        LResumen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LResumen.setText("Pedidos mostrados: 0");

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

    private void BMisPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMisPedidosActionPerformed
        cargando = true;
        CBEstado.setSelectedIndex(0);
        TFMesa.setText("");
        cargando = false;
        mostrar();
    }//GEN-LAST:event_BMisPedidosActionPerformed

    private void CBEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBEstadoItemStateChanged
        if (cargando || evt.getStateChange() != java.awt.event.ItemEvent.SELECTED) {
            return;
        }
        mostrar();
    }//GEN-LAST:event_CBEstadoItemStateChanged

    private void TFMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFMesaActionPerformed
        mostrar();
    }//GEN-LAST:event_TFMesaActionPerformed

    private void BBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarActionPerformed
        mostrar();
    }//GEN-LAST:event_BBuscarActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FMesero().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBuscar;
    private javax.swing.JButton BMisPedidos;
    private javax.swing.JButton BRegresar;
    private javax.swing.JComboBox<String> CBEstado;
    private javax.swing.JLabel LResumen;
    private javax.swing.JLabel LUsuario;
    private javax.swing.JTable TConsultas;
    private javax.swing.JTextField TFMesa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
