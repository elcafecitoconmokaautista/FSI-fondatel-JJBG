import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Conexion {

    Connection con;

    public int conectar(String servidor, String base, String usuario, String clave) {
        try {
            String url = "jdbc:mysql://" + servidor + ":3306/" + base;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, usuario, clave);
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int desconectar() {
        try {
            con.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int entablar(String consulta, JTable malla) {
        int correcta = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            ResultSetMetaData rsm = rs.getMetaData();
            DefaultTableModel modelo = (DefaultTableModel) malla.getModel();
            
            modelo.setColumnCount(0);
            modelo.setRowCount(0);

            for (int k = 1; k <= rsm.getColumnCount(); k++) {
                modelo.addColumn(rsm.getColumnName(k).toUpperCase());
            }

            int renglon = 0;
            while (rs.next()) {
                modelo.insertRow(renglon, new String[rsm.getColumnCount()]);
                for (int k = 1; k <= rsm.getColumnCount(); k++) {
                    if (rsm.getColumnType(k) == -4 || rsm.getColumnType(k) == 2004) { // Tipo BLOB / LONGVARBINARY
                        int w = malla.getColumnModel().getColumn(k - 1).getWidth();
                        int h = malla.getRowHeight();
                        malla.getColumnModel().getColumn(k - 1).setCellRenderer(new ImageRenderer(w, h));
                        byte[] bytes = rs.getBytes(k);
                        if (bytes != null) {
                            modelo.setValueAt(new ImageIcon(bytes), renglon, k - 1);
                        } else {
                            modelo.setValueAt(null, renglon, k - 1);
                        }
                    } else {
                        modelo.setValueAt(rs.getString(k), renglon, k - 1);
                    }
                }
                renglon++;
            }
            correcta = 1;
        } catch (SQLException ex) {
            correcta = 0;
            System.out.println(ex.getMessage());
        }
        return correcta;
    }

    public int entablar(String consulta, JTable malla, double... porcentajes) {
        int correcta = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            ResultSetMetaData rsm = rs.getMetaData();
            DefaultTableModel modelo = (DefaultTableModel) malla.getModel();
            
            modelo.setColumnCount(0);
            modelo.setRowCount(0);

            for (int k = 1; k <= rsm.getColumnCount(); k++) {
                modelo.addColumn(rsm.getColumnName(k).toUpperCase());
            }

            int renglon = 0;
            while (rs.next()) {
                modelo.insertRow(renglon, new String[rsm.getColumnCount()]);
                for (int k = 1; k <= rsm.getColumnCount(); k++) {
                    if (rsm.getColumnType(k) == -4 || rsm.getColumnType(k) == 2004) {
                        int w = malla.getColumnModel().getColumn(k - 1).getWidth();
                        int h = malla.getRowHeight();
                        malla.getColumnModel().getColumn(k - 1).setCellRenderer(new ImageRenderer(w, h));
                        byte[] bytes = rs.getBytes(k);
                        if (bytes != null) {
                            modelo.setValueAt(new ImageIcon(bytes), renglon, k - 1);
                        } else {
                            modelo.setValueAt(null, renglon, k - 1);
                        }
                    } else {
                        modelo.setValueAt(rs.getString(k), renglon, k - 1);
                    }
                }
                renglon++;
            }
            
            setAnchoColumnas(malla, porcentajes);
            correcta = 1;
        } catch (SQLException ex) {
            correcta = 0;
            System.out.println(ex.getMessage());
        }
        return correcta;
    }

    public static void setAnchoColumnas(JTable tabla, double... porcentajes) {
        double total = 0;
        int anchoTabla = tabla.getWidth();
        
        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
            total += porcentajes[i];
        }

        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
            TableColumn column = tabla.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (anchoTabla * (porcentajes[i] / total)));
        }
    }

    public String obtenerDato(String consulta) {
        String resultado = "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                resultado = rs.getString(1);
            }
            return resultado;
        } catch (Exception e) {
            return resultado;
        }
    }

    public String buscarDato(String tabla, String columnaDeseada, String campoBuscado, String valorBuscado) {
        String consulta = "SELECT " + columnaDeseada + " FROM " + tabla
                + " WHERE " + campoBuscado + " = '" + valorBuscado + "'";
        String resultado = "";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                resultado = rs.getString(columnaDeseada);
            }
            return resultado;
        } catch (Exception e) {
            return resultado;
        }
    }

    public void seleccionar(String consulta, JComboBox box) {
        ArrayList<String> datos = new ArrayList<>();
        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(consulta);
            while (rs.next()) {
                datos.add(rs.getString(1));
            }
            if (datos.size() > 0) {
                DefaultComboBoxModel cbm = new DefaultComboBoxModel(datos.toArray());
                box.setModel(cbm);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<ArrayList<String>> consultar(String consulta) {
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        try {
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(consulta);
            ResultSetMetaData rsm = rs.getMetaData();
            while (rs.next()) {
                ArrayList<String> renglon = new ArrayList<>();
                for (int k = 1; k <= rsm.getColumnCount(); k++) {
                    renglon.add(rs.getString(k));
                }
                datos.add(renglon);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
    }
    
    public String[][] consultar2Array(String consulta) {
        ArrayList<ArrayList<String>> datos = consultar(consulta);
        String[][] resultado = null;
        if(!datos.isEmpty()){
            resultado = new String[datos.size()][];
            for (int r = 0; r < datos.size(); r++) {
                ArrayList<String> ren = datos.get(r);
                resultado[r] = ren.toArray(new String[0]);
            }
        }        
        return resultado;
    }

    public String ObtenerFechaHora(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) + " "
                + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "." + c.get(Calendar.MILLISECOND);
    }
        
    public String ObtenerFecha(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH);
    }    
    
    public String ObtenerHora(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "." + c.get(Calendar.MILLISECOND);
    }

    // --------------------------------------------------------------------------
    // Método corregido: Convierte ImageIcon a Stream en memoria usando PNG
    // --------------------------------------------------------------------------
    public InputStream ImagenBytes(ImageIcon imagen) {
        if (imagen == null) return null;
        try {
            BufferedImage buff = new BufferedImage(
                imagen.getIconWidth(), 
                imagen.getIconHeight(), 
                BufferedImage.TYPE_INT_ARGB
            );

            Graphics2D g2d = buff.createGraphics();
            g2d.drawImage(imagen.getImage(), 0, 0, null);
            g2d.dispose();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(buff, "png", baos); // "png" para preservar la transparencia y evitar excepciones de I/O
            return new ByteArrayInputStream(baos.toByteArray());
        } catch (Exception ex) {
            System.out.println("Error al convertir imagen a bytes: " + ex.getMessage());
            return null;
        }
    }

    public static Image escalarImagen(Image srcImg, int ancho, int alto) {
        if (srcImg == null) return null;
        BufferedImage imagenEscalada = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imagenEscalada.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, ancho, alto, null);
        g2.dispose();
        return imagenEscalada;
    }
}

class ImageRenderer extends DefaultTableCellRenderer {
    JLabel lbl = new JLabel();
    int ancho, alto;

    public ImageRenderer(int ancho, int alto) {
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        if (value instanceof String) {
            lbl.setText((String) value);
            lbl.setIcon(null);
        } else if (value instanceof ImageIcon) {
            ImageIcon orig = (ImageIcon) value;
            if (orig.getImage() != null) {
                ImageIcon nueva = new ImageIcon(Conexion.escalarImagen(orig.getImage(), ancho, alto));
                lbl.setIcon(nueva);
                lbl.setText("");
            }
        } else {
            lbl.setIcon(null);
            lbl.setText("");
        }
        return lbl;
    }
}