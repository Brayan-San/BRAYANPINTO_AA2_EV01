import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarDatos {
    public static void main(String[] args) throws SQLException {
        Connection connection = Conexion_bd.getConnection();
        if (connection == null) {
            System.out.println("La conexión a la base de datos no se pudo establecer.");
            return;
        }

        System.out.println("Conexión establecida, eliminando proveedor...");

        // ID del proveedor que deseas eliminar
        int proveedorId = 1;

        // Sentencia SQL para eliminar el registro
        String sql = "DELETE FROM proveedores WHERE proveedor_id = ?";

        try {
            // Usamos PreparedStatement para manejar el ID dinámico
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, proveedorId);

            // Ejecutar la eliminación
            int filasEliminadas = pstmt.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Proveedor eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ningún proveedor con el ID especificado.");
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
