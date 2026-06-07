package DAO;

import Conexiones.Conexion;
import ClasesModelo.Ebook;
import ClasesModelo.ListaFavoritos;
import ClasesModelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EbookDAO {

    public Ebook consultar(int id) {
        Ebook libro = new Ebook();
        String sql = "Select * from Ebook where idLibro = ?";
        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            var rs = ps.executeQuery();
            if (rs.next()) {
                libro.setIdLibro(id);
                libro.setIdTag(rs.getInt("idTag"));
                libro.setAutor(rs.getString("autor"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setEditorial(rs.getString("editorial"));
                libro.setnPaginas(rs.getInt("nPaginas"));
                libro.setUrlImagen(rs.getString("urlImagen"));
                libro.setUrlLibro(rs.getString("urlLibro"));

            }
        } catch (SQLException e) {
            System.out.println("Error al consultar libro");
            return null;
        }
        return libro;
    }

    //metodo para traer todos mis libros
    public ArrayList<Ebook> consultarTodos() {
        String sql = "SELECT * FROM Ebook";
        ArrayList<Ebook> lista;

        try (Connection con = Conexion.conectar(); //establece la conexion
                 PreparedStatement ps = con.prepareStatement(sql); //prepara la consulta;
                 ResultSet resultado = ps.executeQuery()) //Regresatodo
        {
            lista = new ArrayList<>();
            //Para buscar mientras haya resultados;
            while (resultado.next()) {
                Ebook libro = new Ebook();
                libro.setIdLibro(resultado.getInt("idLibro"));
                libro.setIdTag(resultado.getInt("idTag"));
                libro.setTitulo(resultado.getString("titulo"));
                libro.setAutor(resultado.getString("autor"));
                libro.setnPaginas(resultado.getInt("nPaginas"));
                libro.setEditorial(resultado.getString("editorial"));
                libro.setUrlLibro(resultado.getString("urlLibro"));
                libro.setUrlImagen(resultado.getString("urlImagen"));

                lista.add(libro);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar todos: " + e.getMessage());
            return null;
        }
        return lista;
    }

    /**
     *
     * @param usuario
     * @return
     */
    public ArrayList<ListaFavoritos> consultarFavoritos(Usuario usuario) {

        String boleta = usuario.getBoleta();

        String sql = "SELECT * FROM ListaFavoritos WHERE boleta = ?";

        ArrayList<ListaFavoritos> lista = new ArrayList<>();

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, boleta);

            ResultSet resultado = ps.executeQuery();

            while (resultado.next()) {

                Ebook libro = consultar(resultado.getInt("idLibro"));

                lista.add(
                        new ListaFavoritos(
                                libro,
                                usuario.getBoleta()
                        )
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error al listar favoritos: "
                    + e.getMessage()
            );

            return null;
        }

        return lista;
    }
    
    public boolean insertar(Ebook libro) {

    String sql = """
                 INSERT INTO Ebook
                 (idTag, autor, titulo, editorial,
                  nPaginas, urlImagen, urlLibro)
                 VALUES (?, ?, ?, ?, ?, ?, ?)
                 """;

    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, libro.getIdTag());
        ps.setString(2, libro.getAutor());
        ps.setString(3, libro.getTitulo());
        ps.setString(4, libro.getEditorial());
        ps.setInt(5, libro.getnPaginas());
        ps.setString(6, libro.getUrlImagen());
        ps.setString(7, libro.getUrlLibro());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println("Error al insertar libro");
        e.printStackTrace();
        return false;
    }
}
}
