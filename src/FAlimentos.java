
import java.awt.Image;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FAlimentos extends javax.swing.JFrame {

    Conexion cnx = new Conexion();
    ImageIcon cartel;
    ImageIcon icono = new ImageIcon(getClass().getResource("/film.png"));
    int idSel = -1;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FAlimentos.class.getName());

    public FAlimentos() {
        initComponents();

        setLocationRelativeTo(this);
//        setIconImages((List<? extends Image>) icono.getImage());
        TConsultas.setRowHeight(130);

        if (cnx.conectar("127.0.0.1", "fondatel", "root", "") == 1) {
            cnx.entablar(alimento.todos, TConsultas, 6, 16, 26, 8, 20, 14, 10);
            TFId.setText(cnx.obtenerDato(Queries.siguiente_idalimento));
        } else {
            JOptionPane.showMessageDialog(this, "EL SERVIDOR AL QUE INTENTA INGRESAR NO SE ENCUENTRA DISPONIBLE");
            System.exit(0);
        }

        // Al cerrar esta ventana solo se cierra la conexión de ella
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                cnx.desconectar();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        BNueva = new javax.swing.JButton();
        BAgregar = new javax.swing.JButton();
        BQuitar = new javax.swing.JButton();
        BModificar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        LCartel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();
        BAbrirC = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TFId = new javax.swing.JTextField();
        TFNombre = new javax.swing.JTextField();
        TFDescripcion = new javax.swing.JTextField();
        TFPrecio = new javax.swing.JTextField();
        CBCategoria = new javax.swing.JComboBox<>();
        CBEstado = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 204, 0));

        jToolBar1.setBackground(new java.awt.Color(204, 255, 204));
        jToolBar1.setRollover(true);

        BNueva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nueva32.png"))); // NOI18N
        BNueva.setText("NUEVA");
        BNueva.setFocusable(false);
        BNueva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BNueva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BNueva.addActionListener(this::BNuevaActionPerformed);
        jToolBar1.add(BNueva);

        BAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agregar32.png"))); // NOI18N
        BAgregar.setText("AGREGAR");
        BAgregar.setFocusable(false);
        BAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BAgregar.addActionListener(this::BAgregarActionPerformed);
        jToolBar1.add(BAgregar);

        BQuitar.setText("QUITAR");
        BQuitar.setFocusable(false);
        BQuitar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BQuitar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BQuitar.addActionListener(this::BQuitarActionPerformed);
        jToolBar1.add(BQuitar);

        BModificar.setText("MODIFICAR");
        BModificar.setFocusable(false);
        BModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BModificar.addActionListener(this::BModificarActionPerformed);
        jToolBar1.add(BModificar);

        jLabel4.setText("                                              ");
        jToolBar1.add(jLabel4);

        LCartel.setBackground(new java.awt.Color(0, 153, 153));

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
        TConsultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TConsultasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TConsultas);

        BAbrirC.setText("ABRIR FOTO");
        BAbrirC.addActionListener(this::BAbrirCActionPerformed);

        jLabel1.setText("FOTO :");

        jLabel2.setText("NOMBRE :");

        jLabel3.setText("ID :");

        jLabel6.setText("DESCRIPCION :");

        jLabel7.setText("PRECIO :");

        jLabel8.setText("CATEGORIA :");

        jLabel9.setText("ESTADO :");

        TFId.setEditable(false);

        CBCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "entrada", "plato principal", "postre", "bebida" }));

        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "disponible", "agotado" }));

        jPanel1.setBackground(new java.awt.Color(51, 204, 0));

        jLabel5.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        jLabel5.setText("REGISTRO DE ALIMENTOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFId, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LCartel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BAbrirC)
                                .addGap(84, 84, 84)))))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TFId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TFDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(CBCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(CBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(LCartel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(BAbrirC)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Regresa el texto de una celda de la tabla (vacío si es null)
    private String valor(int fila, int columna) {
        Object dato = TConsultas.getValueAt(fila, columna);
        return dato == null ? "" : dato.toString();
    }

    // Lee la foto guardada en la base de datos para el alimento indicado
    private byte[] leerFoto(int id) {
        try {
            PreparedStatement ps = cnx.con.prepareStatement(Queries.foto_alimento);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                byte[] b = rs.getBytes(1);
                return b == null ? new byte[0] : b;
            }
        } catch (Exception e) {
            System.out.println("Error al leer la foto: " + e.getMessage());
        }
        return new byte[0];
    }

    // Convierte el cartel (ImageIcon) a bytes para guardarlo; vacío si no hay foto
    private byte[] fotoBytes() {
        if (cartel == null) {
            return new byte[0];
        }
        try {
            return cnx.ImagenBytes(cartel).readAllBytes();
        } catch (Exception e) {
            return new byte[0];
        }
    }

    private void limpiarCampos() {
        idSel = -1;
        cartel = null;
        TFId.setText(cnx.obtenerDato(Queries.siguiente_idalimento));
        TFNombre.setText("");
        TFDescripcion.setText("");
        TFPrecio.setText("");
        CBCategoria.setSelectedIndex(0);
        CBEstado.setSelectedIndex(0);
        LCartel.setIcon(null);
        TConsultas.clearSelection();
    }

    private boolean datosValidos() {
        if (TFNombre.getText().trim().isEmpty() || TFDescripcion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escriba el nombre y la descripción");
            return false;
        }
        try {
            float precio = Float.parseFloat(TFPrecio.getText().trim());
            if (precio <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El precio debe ser un número mayor a 0");
            return false;
        }
        return true;
    }

    private alimento leerAlimento(int id) {
        return new alimento(id, TFNombre.getText().trim(), TFDescripcion.getText().trim(),
                Float.parseFloat(TFPrecio.getText().trim()), fotoBytes(),
                CBCategoria.getSelectedItem().toString(), CBEstado.getSelectedItem().toString());
    }

    private void BAbrirCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAbrirCActionPerformed

        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            cartel = new ImageIcon(archivo.getPath());

            if (cartel.getIconWidth() <= 0 || cartel.getIconHeight() <= 0) {
                JOptionPane.showMessageDialog(this, "El archivo no es una imagen válida");
                cartel = null;
                return;
            }
            // Se reduce a máximo 400 px para que la tabla no se ponga lenta
            if (cartel.getIconWidth() > 400 || cartel.getIconHeight() > 400) {
                double esc = 400.0 / Math.max(cartel.getIconWidth(), cartel.getIconHeight());
                cartel = new ImageIcon(Conexion.escalarImagen(cartel.getImage(),
                        Math.max(1, (int) (cartel.getIconWidth() * esc)),
                        Math.max(1, (int) (cartel.getIconHeight() * esc))));
            }

            LCartel.setIcon(new ImageIcon(Conexion.escalarImagen(cartel.getImage(), 194, 235)));

        }

    }//GEN-LAST:event_BAbrirCActionPerformed

    private void BAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarActionPerformed

        if (!datosValidos()) {
            return;
        }

        int id = Integer.parseInt(cnx.obtenerDato(Queries.siguiente_idalimento));
        alimento aa = leerAlimento(id);

        if (aa.insertar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Alimento agregado con ID " + id);
            cnx.entablar(alimento.todos, TConsultas, 6, 16, 26, 8, 20, 14, 10);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo agregar el alimento");
        }

    }//GEN-LAST:event_BAgregarActionPerformed

    private void BNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevaActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_BNuevaActionPerformed

    private void BQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BQuitarActionPerformed

        if (idSel < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un alimento de la tabla");
            return;
        }
        int resp = JOptionPane.showConfirmDialog(this, "¿Quitar el alimento \"" + TFNombre.getText() + "\"?",
                "Quitar alimento", JOptionPane.YES_NO_OPTION);
        if (resp != JOptionPane.YES_OPTION) {
            return;
        }

        alimento aa = new alimento();
        aa.idalimentos = idSel;

        if (aa.borrar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Alimento quitado");
            cnx.entablar(alimento.todos, TConsultas, 6, 16, 26, 8, 20, 14, 10);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo quitar. Si el alimento ya tiene órdenes, "
                    + "márquelo como \"agotado\" con MODIFICAR.");
        }

    }//GEN-LAST:event_BQuitarActionPerformed

    private void BModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModificarActionPerformed

        if (idSel < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un alimento de la tabla");
            return;
        }
        if (!datosValidos()) {
            return;
        }

        alimento aa = leerAlimento(idSel);

        if (aa.actualizar(cnx.con) == 1) {
            JOptionPane.showMessageDialog(this, "Alimento modificado");
            cnx.entablar(alimento.todos, TConsultas, 6, 16, 26, 8, 20, 14, 10);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo modificar el alimento");
        }

    }//GEN-LAST:event_BModificarActionPerformed

    private void TConsultasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TConsultasMousePressed
        int ren = TConsultas.getSelectedRow();

        if (ren >= 0) {
            // Columnas: 0 id, 1 nombre, 2 descripción, 3 precio, 4 foto, 5 categoría, 6 estado
            idSel = Integer.parseInt(valor(ren, 0));
            TFId.setText(valor(ren, 0));
            TFNombre.setText(valor(ren, 1));
            TFDescripcion.setText(valor(ren, 2));
            TFPrecio.setText(valor(ren, 3));
            CBCategoria.setSelectedItem(valor(ren, 5));
            CBEstado.setSelectedItem(valor(ren, 6));

            // La foto original se lee de la base para no perder calidad al modificar
            byte[] b = leerFoto(idSel);
            if (b.length > 0) {
                cartel = new ImageIcon(b);
                LCartel.setIcon(new ImageIcon(cnx.escalarImagen(cartel.getImage(), 194, 235)));
            } else {
                cartel = null;
                LCartel.setIcon(null);
            }
        }
    }//GEN-LAST:event_TConsultasMousePressed

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
        java.awt.EventQueue.invokeLater(() -> new FAlimentos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAbrirC;
    private javax.swing.JButton BAgregar;
    private javax.swing.JButton BModificar;
    private javax.swing.JButton BNueva;
    private javax.swing.JButton BQuitar;
    private javax.swing.JComboBox<String> CBCategoria;
    private javax.swing.JComboBox<String> CBEstado;
    private javax.swing.JLabel LCartel;
    private javax.swing.JTable TConsultas;
    private javax.swing.JTextField TFDescripcion;
    private javax.swing.JTextField TFId;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTextField TFPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
