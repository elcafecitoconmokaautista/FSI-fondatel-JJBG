
import javax.swing.JOptionPane;

public class FCocinero extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FCocinero.class.getName());

    Conexion cnx = new Conexion();
    String codigo;

    public FCocinero() {
        this("");
    }

    public FCocinero(String codigo) {
        this.codigo = codigo;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("FONDATEL - COCINA");
        TConsultas.setDefaultEditor(Object.class, null); // la tabla es solo de consulta

        if (cnx.conectar("localhost", "fondatel", "root", "") == 1) {
            LUsuario.setText("Cocinero: " + cnx.obtenerDato(String.format(Queries.nombre_empleado, codigo)));
            mostrar(Queries.comandas_todas);
        } else {
            JOptionPane.showMessageDialog(this, "Sin conexión. La ventana se cerrará...");
            System.exit(0);
        }
    }

    // Consulta la vista "comandas" y la muestra en la tabla
    private void mostrar(String consulta) {
        if (cnx.entablar(consulta, TConsultas) == 1) {
            Conexion.ajustarColumnas(TConsultas);
            LResumen.setText("Comandas pendientes: " + TConsultas.getRowCount());
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo consultar la vista comandas");
        }
    }

    // Busca una comanda por folio; con el campo vacío muestra todas
    private void buscarFolio() {
        String texto = TFFolio.getText().trim();
        if (texto.isEmpty()) {
            mostrar(Queries.comandas_todas);
            return;
        }
        try {
            int folio = Integer.parseInt(texto);
            mostrar(String.format(Queries.comandas_folio, folio));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El folio debe ser un número entero");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        BComandas = new javax.swing.JButton();
        TFFolio = new javax.swing.JTextField();
        BBuscar = new javax.swing.JButton();
        BRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();
        LUsuario = new javax.swing.JLabel();
        LResumen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(0, 102, 153));
        jToolBar1.setRollover(true);

        BComandas.setBackground(new java.awt.Color(255, 204, 0));
        BComandas.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        BComandas.setText("COMANDAS");
        BComandas.setFocusable(false);
        BComandas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BComandas.setMaximumSize(new java.awt.Dimension(170, 64));
        BComandas.setMinimumSize(new java.awt.Dimension(170, 64));
        BComandas.setPreferredSize(new java.awt.Dimension(170, 64));
        BComandas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BComandas.addActionListener(this::BComandasActionPerformed);
        jToolBar1.add(BComandas);

        TFFolio.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FOLIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 102, 153))); // NOI18N
        TFFolio.setMaximumSize(new java.awt.Dimension(110, 64));
        TFFolio.setMinimumSize(new java.awt.Dimension(110, 64));
        TFFolio.setPreferredSize(new java.awt.Dimension(110, 64));
        TFFolio.addActionListener(this::TFFolioActionPerformed);
        jToolBar1.add(TFFolio);

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
        LUsuario.setText("Cocinero:");

        LResumen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LResumen.setText("Comandas pendientes: 0");

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

    private void BComandasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BComandasActionPerformed
        TFFolio.setText("");
        mostrar(Queries.comandas_todas);
    }//GEN-LAST:event_BComandasActionPerformed

    private void TFFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFFolioActionPerformed
        buscarFolio();
    }//GEN-LAST:event_TFFolioActionPerformed

    private void BBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarActionPerformed
        buscarFolio();
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
        java.awt.EventQueue.invokeLater(() -> new FCocinero().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBuscar;
    private javax.swing.JButton BComandas;
    private javax.swing.JButton BRegresar;
    private javax.swing.JLabel LResumen;
    private javax.swing.JLabel LUsuario;
    private javax.swing.JTable TConsultas;
    private javax.swing.JTextField TFFolio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
