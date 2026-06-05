package DAO;

import Conexiones.Conexion;
import ClasesModelo.ListaFavoritos;
import Conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ListaFavoritosDAO {

    public boolean insertarFavorito(ListaFavoritos favorito) {
        String sql = "INSERT INTO ListaFavoritos (idLibro, boleta) VALUES (?, ?)";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, favorito.getIdLibro().getIdLibro());
            ps.setString(2, favorito.getBoleta());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al añadir a favoritos en el DAO: " + e.getMessage());
            return false;
        }
    }
}