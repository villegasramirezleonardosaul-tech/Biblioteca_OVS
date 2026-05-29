package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConexion {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "n0m3l0";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(url, user, password);

            System.out.println("Conexion exitosa");

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("SHOW DATABASES");

            while(rs.next()){

                System.out.println(rs.getString(1));

            }

        } catch (Exception e) {

            System.out.println("Error: " + e);
        }
    }
}
