package DAO;

import Conexiones.Conexion;
import ClasesModelo.Ebook;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author XxChris777xX
 */
public class EbookDAO {

    // esta cosa trae todos los ebooks de la basesita de datos
    public ArrayList<Ebook> obtenerTodos() {
        ArrayList<Ebook> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ebook";

        try (Connection con = Conexion.conectar(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Ebook e = new Ebook(
                        rs.getInt("idLibro"),
                        rs.getInt("idTag"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("nPaginas"),
                        rs.getString("editorial"),
                        rs.getString("urlLibro"),
                        rs.getString("urlImagen")
                );
                lista.add(e);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener ebooks: " + ex.getMessage());
        }

        return lista;
    }

    // aqui se buscan todos los ebooks por categoria (los tags)
    public ArrayList<Ebook> obtenerPorTag(int idTag) {
        ArrayList<Ebook> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ebook WHERE idTag = ?";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idTag);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Ebook(
                        rs.getInt("idLibro"),
                        rs.getInt("idTag"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("nPaginas"),
                        rs.getString("editorial"),
                        rs.getString("urlLibro"),
                        rs.getString("urlImagen")
                ));
            }

        } catch (SQLException ex) {
            System.out.println("Error al filtrar por tag: " + ex.getMessage());
        }

        return lista;
    }

    // aqui se inserta un ebbok nuevo en la besesita de datos
    public boolean guardar(Ebook e) {
        String sql = "INSERT INTO Ebook (idTag, titulo, autor, nPaginas, editorial, urlLibro, urlImagen) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getIdTag());
            ps.setString(2, e.getTitulo());
            ps.setString(3, e.getAutor());
            ps.setInt(4, e.getNPaginas());
            ps.setString(5, e.getEditorial());
            ps.setString(6, e.getUrlLibro());
            ps.setString(7, e.getUrlImagen());

            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException ex) {
            System.out.println("Error al guardar ebook: " + ex.getMessage());
            return false;
        }
    }

    // aqui inserta un arraylis completo en la basesita
    public void guardarLista(ArrayList<Ebook> lista) {
        for (Ebook e : lista) {
            boolean ok = guardar(e);
            System.out.println(ok ? "Guardado: " + e.getTitulo() : "Fallo: " + e.getTitulo());
        }
    }

    // esto borra un ebbok por su numero de id
    public boolean eliminar(int idLibro) {
        String sql = "DELETE FROM Ebook WHERE idLibro = ?";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idLibro);
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al eliminar: " + ex.getMessage());
            return false;
        }
    }

    // modifica un ebook que ya eiste
    public boolean actualizar(Ebook e) {
        String sql = "UPDATE Ebook SET idTag=?, titulo=?, autor=?, nPaginas=?, "
                + "editorial=?, urlLibro=?, urlImagen=? WHERE idLibro=?";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getIdTag());
            ps.setString(2, e.getTitulo());
            ps.setString(3, e.getAutor());
            ps.setInt(4, e.getNPaginas());
            ps.setString(5, e.getEditorial());
            ps.setString(6, e.getUrlLibro());
            ps.setString(7, e.getUrlImagen());
            ps.setInt(8, e.getIdLibro());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Error al actualizar: " + ex.getMessage());
            return false;
        }
    }

}
