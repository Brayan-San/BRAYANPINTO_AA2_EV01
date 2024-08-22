import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConsultarDatos {
    public static void main(String[] args) throws SQLException {
        Connection connection = Conexion_bd.getConnection();
        if (connection == null) {
            System.out.println("La conexión a la base de datos no se pudo establecer.");
            return;
        }

        System.out.println("Conexión establecida, realizando consulta...");

        String sql = "SELECT * FROM proveedores";  // Cambia esta consulta según tus necesidades.

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Procesar los resultados
            while (rs.next()) {
                int id = rs.getInt("proveedor_id");
                String nombre = rs.getString("nombre");
                String contacto = rs.getString("contacto");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");

                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Contacto: " + contacto);
                System.out.println("Teléfono: " + telefono);
                System.out.println("Email: " + email);
                System.out.println("---------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
