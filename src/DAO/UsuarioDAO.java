package DAO;


import Conexiones.Conexion;
import ClasesModelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    
    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (boleta, idTipo, nomUser, contrasenia) VALUES (?, ?, ?, ?)";
        
        // Usamos try-with-resources para que la conexión se cierre sola automáticamente al terminar
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            // Llenamos los signos de interrogación '?' en orden (1, 2, 3, 4)
            ps.setInt(1, usuario.getBoleta());
            ps.setInt(2, usuario.getIdTipo());
            ps.setString(3, usuario.getNomUser());
            ps.setString(4, usuario.getContrasenia());
            
            // Ejecuta el insert. Si devuelve más de 0, significa que sí se guardó.
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario en el DAO: " + e.getMessage());
            return false;
        }
    }
}