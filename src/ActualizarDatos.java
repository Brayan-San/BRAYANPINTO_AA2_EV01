import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarDatos {
    public static void main(String[] args) throws SQLException {
        Connection connection = Conexion_bd.getConnection();
        if (connection == null) {
            System.out.println("La conexión a la base de datos no se pudo establecer.");
            return;
        }

        System.out.println("Conexión establecida, actualizando proveedor...");

        // Datos a actualizar
        int proveedorId = 4;  
        String nuevoNombre = "prueba";
        String nuevoContacto = "celular";
        String nuevoTelefono = "3216497988";
        String nuevoEmail = "prueba@gmail.com";

        // Sentencia SQL para actualizar la información
        String sql = "UPDATE proveedores SET nombre = ?, contacto = ?, telefono = ?, email = ? WHERE proveedor_id = ?";

        try {
            // Se usa PreparedStatement para evitar inyecciones SQL y manejar datos
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevoContacto);
            pstmt.setString(3, nuevoTelefono);
            pstmt.setString(4, nuevoEmail);
            pstmt.setInt(5, proveedorId);

            // Ejecutar la actualización
            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Proveedor actualizado exitosamente.");
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

