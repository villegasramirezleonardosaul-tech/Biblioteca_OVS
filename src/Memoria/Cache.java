package Memoria;

import ClasesModelo.Comunidad;
import ClasesModelo.Ebook;
import ClasesModelo.ListaFavoritos;
import ClasesModelo.Mensaje;
import ClasesModelo.Usuario;
import Conexiones.Conexion;
import DAO.EbookDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Cache {

    public static ArrayList<Ebook> libros;
    public static ArrayList<ListaFavoritos> favoritos;
    public static Usuario usuario;
    public static ArrayList<Comunidad> comunidades;
    public static HashMap<Integer, ArrayList<Mensaje>> mensajes;
    public static ArrayList<String> tag;

    public static void BuscarLibros() {
        EbookDAO dao = new EbookDAO();
        libros = dao.consultarTodos();
    }

    public static void ConsultarTag() {
        String sql = "SELECT * FROM TipoTag";
        tag = new ArrayList<>();
        try (Connection con = Conexion.conectar(); //establece la conexion
                 PreparedStatement ps = con.prepareStatement(sql); //prepara la consulta;
                 ResultSet resultado = ps.executeQuery()) //Regresatodo
        {

            //Para buscar mientras haya resultados;
            while (resultado.next()) {
                tag.add(resultado.getString("descrip"));
            }
        } catch (SQLException e) {
            System.out.println("Error al listar libros: " + e.getMessage());

        }

    }

    public static void AñadirFavoritos(Ebook libro) {
        favoritos.add(new ListaFavoritos(libro, usuario.getBoleta()));
    }

    public static void EliminarFavoritos(Ebook libro) {
        int tamaño = favoritos.size();
        System.out.println(favoritos.size());
        for (int i = 0; i < tamaño; i++) {
            if (favoritos.get(i).getIdLibro().getIdLibro() == libro.getIdLibro()) {

                favoritos.remove(i);
                break;
            }
        }

    }

    public static ArrayList<Ebook> CrearLista(ArrayList<ListaFavoritos> fav) {
        int tamaño = fav.size();
        ArrayList<Ebook> lista = new ArrayList();
        for (int i = 0; i < tamaño; i++) {

            lista.add(fav.get(i).getIdLibro());
        }
        return lista;
    }
    public static void AñadirLibro(Ebook libro){
        libros.add(libro);
    }

}
