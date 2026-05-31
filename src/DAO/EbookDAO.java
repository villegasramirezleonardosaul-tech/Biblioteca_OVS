package DAO;

import Conexiones.Conexion;
import ClasesModelo.Ebook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EbookDAO {

    public Ebook buscarPorId(int id) {

        //Para buscar libros por id
        String sql = "SELECT * FROM Ebook WHERE idLibro = ?";
        Ebook libro = null;

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {//Para el selecct

            ps.setInt(1, id);

            try (ResultSet resultado = ps.executeQuery()) {
                if (resultado.next()) {
                    libro = new Ebook();
                    libro.setIdLibro(resultado.getInt("idLibro"));
                    libro.setIdTag(resultado.getInt("idTag"));
                    libro.setTitulo(resultado.getString("titulo"));
                    libro.setAutor(resultado.getString("autor"));
                    libro.setnPaginas(resultado.getInt("nPaginas"));
                    libro.setEditorial(resultado.getString("editorial"));
                    libro.setUrlLibro(resultado.getString("urlLibro"));
                    libro.setUrlImagen(resultado.getString("urlImagen"));
                }
            }
        } catch (SQLException e) {
            //El error
            System.out.println("Error al buscar libro por ID: " + e.getMessage());
        }
        return libro; //Devuelve null si no hay na
    }

    //metodo para traer todos mis libros
    public List<Ebook> listarTodos() {
        String sql = "SELECT * FROM Ebook";
        List<Ebook> lista = new ArrayList<>();

        try (Connection con = Conexion.conectar(); 
                PreparedStatement ps = con.prepareStatement(sql); 
                ResultSet resultado = ps.executeQuery()) {
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

                lista.add(libro); // Lo guardamos en nuestra lista de Java
            }
        } catch (SQLException e) {
            System.out.println("Error al listar libros: " + e.getMessage());
        }
        return lista;
    }
}
