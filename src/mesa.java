import java.sql.*;
public class mesa {

    static String todos = "SELECT * FROM mesas ORDER BY numero";
    static String numeros = "SELECT numero FROM mesas ORDER BY numero";

    int numero, capacidad;
    String estadom;

    public mesa() {
    }

    public mesa(int numero, String estadom, int capacidad) {
        this.numero = numero;
        this.estadom = estadom;
        this.capacidad = capacidad;
    }

    public int insertar(Connection con){
        int resultado=0;
        try {
            String sql = "INSERT INTO mesas VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            ps.setString(2, estadom);
            ps.setInt(3, capacidad);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con){
        int resultado =0;
        try {
            String sql = "DELETE FROM mesas WHERE numero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con){
        int resultado =0;
        try {
            String sql = "UPDATE mesas SET estadom = ?, capacidad = ? WHERE numero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, estadom);
            ps.setInt(2, capacidad);
            ps.setInt(3, numero);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return resultado;
        }
    }
}
