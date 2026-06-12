package vallegrande.edu.pe.proyecto1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // DATOS DE LA BASE DE DATOS
    private static final String URL =
            "jdbc:mysql://localhost:3307/granadafresh?useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASSWORD = "Ruby120";

    // MÉTODO DE CONEXIÓN
    public static Connection getConexion() {

        Connection cn = null;

        try {

            // DRIVER MYSQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // CONEXIÓN
            cn = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conexión exitosa");

        } catch (ClassNotFoundException e) {

            System.out.println("Driver no encontrado");
            System.out.println(e.getMessage());

        } catch (SQLException e) {

            System.out.println("Error de conexión");
            System.out.println(e.getMessage());
        }

        return cn;
    }
}