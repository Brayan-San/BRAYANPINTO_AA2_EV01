//librerias de my sql
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.SQLException;

//clases
public class Conexion_bd {
    // Conexion con la base de datos en XAMPP
    private static final String URL = "jdbc:mysql://localhost:3306/force_sport_01"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "";  
    
    //Devuelve una conexión a la base de datos.
    public static Connection getConnection() throws SQLException {
        // Método para obtener la conexión
        return DriverManager.getConnection(URL, USER, PASSWORD); // Devuelve una nueva conexión
    }

    //Es el método principal que se ejecuta cuando inicias el programa.
    public static void main(String[] args) {
        // Este es el método principal donde comienza la ejecución
        try {
            Connection conn = getConnection();
            System.out.println("Conexion exitosa a la base de datos");
            // Aquí puedes añadir más lógica para trabajar con la conexión
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
        }
    }
}
