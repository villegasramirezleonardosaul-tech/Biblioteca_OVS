package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Nombre de la base de datos
    private static final String BD = "biblioteca";

    // URL de conexión
    private static final String URL =
            "jdbc:mysql://localhost:3306/" + BD;

    // Usuario y contraseña
    private static final String USER = "root";
    private static final String PASSWORD = "n0m3l0";

    // Método para conectar
    public static Connection conectar() {

        Connection con = null;

        try {

            // Cargar driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conexión
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conexion exitosa");

        } catch (ClassNotFoundException e) {

            System.out.println("Driver no encontrado: " + e);

        } catch (SQLException e) {

            System.out.println("Error de conexion: " + e);

        }

        return con;
    }
}