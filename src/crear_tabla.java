//Librerias de my sql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class crear_tabla {
    public static void main(String[] args) throws SQLException {
        System.out.println("Iniciando el proceso de creación de tabla...");

        Connection connection = Conexion_bd.getConnection();
        if (connection == null) {
            System.out.println("La conexión a la base de datos no se pudo establecer.");
            return;
        }
        
        System.out.println("Conexión establecida, creando tabla...");

        String sql = "CREATE TABLE proveedores ("
                   + "proveedor_id INT(11) NOT NULL AUTO_INCREMENT, "
                   + "nombre VARCHAR(255) NOT NULL, "
                   + "contacto VARCHAR(255) NOT NULL, "
                   + "telefono VARCHAR(15) DEFAULT NULL, "
                   + "email VARCHAR(255) DEFAULT NULL, "
                   + "PRIMARY KEY (proveedor_id)) "
                   + "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;";
        
        try {
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Tabla 'proveedores' creada exitosamente.");
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
