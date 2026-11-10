import java.sql.*;
public class cliente {

    static String todos = "SELECT * FROM clientes ORDER BY nombrec";
    static String codigos = "SELECT codigoc FROM clientes ORDER BY codigoc";

    String codigoc, nombrec, rfc;

    public cliente() {
    }

    public cliente(String codigoc, String nombrec, String rfc) {
        this.codigoc = codigoc;
        this.nombrec = nombrec;
        this.rfc = rfc;
    }

    public int insertar(Connection con){
        int resultado=0;
        try {
            String sql = "INSERT INTO clientes VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigoc);
            ps.setString(2, nombrec);
            ps.setString(3, rfc);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con){
        int resultado =0;
        try {
            String sql = "DELETE FROM clientes WHERE codigoc = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigoc);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con){
        int resultado =0;
        try {
            String sql = "UPDATE clientes SET nombrec = ?, rfc = ? WHERE codigoc = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombrec);
            ps.setString(2, rfc);
            ps.setString(3, codigoc);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }
}
