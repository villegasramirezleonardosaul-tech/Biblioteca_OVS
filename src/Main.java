
import Conexiones.Conexion;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        Connection con = Conexion.conectar();

        if (con != null) {

            System.out.println("Si hay conexion");

        } else {

            System.out.println("No hay conexion");

        }
    }
}
