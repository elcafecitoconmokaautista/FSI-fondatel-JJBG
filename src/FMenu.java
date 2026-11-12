
import javax.swing.JOptionPane;


public class FMenu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FMenu.class.getName());

    Conexion cnx = new Conexion();
    
    String todo = "SELECT * FROM menu";
    String categorias = "SELECT DISTINCT categoria FROM menu ORDER BY categoria";
    String por_categoria = "SELECT * FROM menu WHERE categoria = '%s' ORDER BY nombre";
    
    public FMenu() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("MENU DE FONDATEL");
        TMenu.setRowHeight(200);
        
        if (cnx.conectar("localhost", "fondatel", "root", "") == 1) {
            cnx.entablar(todo, TMenu);
            cnx.seleccionar(categorias, CBCategoria);
        } else {
            JOptionPane.showMessageDialog(this, "Sin conexión. La ventana se cerrará...");
            System.exit(0);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        BCompleto = new javax.swing.JButton();
        CBCategoria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TMenu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(0, 102, 153));
        jToolBar1.setRollover(true);

        BCompleto.setBackground(new java.awt.Color(255, 204, 0));
        BCompleto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        BCompleto.setText("COMPLETO");
        BCompleto.setFocusable(false);
        BCompleto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BCompleto.setMaximumSize(new java.awt.Dimension(200, 64));
        BCompleto.setMinimumSize(new java.awt.Dimension(200, 64));
        BCompleto.setPreferredSize(new java.awt.Dimension(200, 64));
        BCompleto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BCompleto.addActionListener(this::BCompletoActionPerformed);
        jToolBar1.add(BCompleto);

        CBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CBCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CATEGORIA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 204, 51))); // NOI18N
        CBCategoria.setMaximumSize(new java.awt.Dimension(200, 64));
        CBCategoria.setMinimumSize(new java.awt.Dimension(200, 64));
        CBCategoria.setPreferredSize(new java.awt.Dimension(200, 64));
        CBCategoria.addItemListener(this::CBCategoriaItemStateChanged);
        jToolBar1.add(CBCategoria);

        TMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBCategoriaItemStateChanged
        
        String cat = CBCategoria.getSelectedItem().toString();
        if (cat.equals("Todos")) {
            cnx.entablar(todo, TMenu);
            
        } else {
            String sql = String.format(por_categoria, cat);
            cnx.entablar(sql, TMenu);
        }
        
    }//GEN-LAST:event_CBCategoriaItemStateChanged

    private void BCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCompletoActionPerformed
        cnx.entablar(todo, TMenu);
    }//GEN-LAST:event_BCompletoActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new FMenu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCompleto;
    private javax.swing.JComboBox<String> CBCategoria;
    private javax.swing.JTable TMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
