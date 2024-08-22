//Libreria de my sql
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatos {
    public static void main(String[] args) throws SQLException {
        // Llama al método getConnection() para obtener la conexión a la base de datos
        Connection connection = Conexion_bd.getConnection();

        // Define la consulta SQL para insertar datos en la tabla
        String sql = "INSERT INTO proveedores (nombre, contacto, telefono, email) VALUES (?, ?, ?, ?)";

        try {
            // Prepara la declaración SQL
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Establece los valores para cada parámetro de la consulta
            pstmt.setString(1, "brayan");
            pstmt.setString(2, "celular");
            pstmt.setString(3, "00000000000");
            pstmt.setString(4, "brayan@gmail.com");

            // Ejecuta la declaración SQL
            int rowsInserted = pstmt.executeUpdate();

            // Verifica si se insertaron las filas correctamente
            if (rowsInserted > 0) {
                System.out.println("Un nuevo proveedor ha sido insertado exitosamente.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cierra la conexión a la base de datos
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

