package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Nombre de la base de datos
    private static final String BD = "biblioteca";

    // No tocar a menos que tengan otro puerto
    private static final String URL =
            "jdbc:mysql://localhost:3306/" + BD;

    // Pongan aqui su usuario de mysql y la contraseña
    private static final String USER = "root";
    private static final String PASSWORD = "n0m3l0";

public static Connection conectar() {

        Connection con = null;

        try {

            // No tocar es de librerias
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Conexion exitosa");

        } 
        //Aqui si no deberia fallar pero si falla preguntar al chatgpt
        catch (ClassNotFoundException e) {

            System.out.println("Driver no encontrado: " + e);

        } catch (SQLException e) {

            System.out.println("Error de conexion: " + e);

        }

        return con;
    }
}