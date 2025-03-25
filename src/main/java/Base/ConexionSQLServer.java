package Base;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLServer {

    public static Connection con;

    public static Connection getConexion() {
        String conUrl = "jdbc:sqlserver://localhost:7022;"
                + "databaseName=ENCARGUITOS2;"
                + "user=sa;"
                + "password=basededatos#2023;"
                + "loginTimeout=30;";

        try {
            Connection con = DriverManager.getConnection(conUrl);
            System.out.println("Conectado");
            return con;

        } catch (SQLException e) {
            System.err.println("Error al conectar a SQL Server: " + e.getMessage());
            return null;
        }

    }

    public static void main(String[] args) {
        getConexion();
    }
}
