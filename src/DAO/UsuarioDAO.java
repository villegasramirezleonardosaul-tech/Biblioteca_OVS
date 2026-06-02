package DAO;


import Conexiones.Conexion;
import ClasesModelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    
    public UsuarioDAO(){}
    
    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (boleta, idTipo, nomUser, contrasenia) VALUES (?, ?, ?, ?)";
        
        // Usamos try-with-resources para que la conexión se cierre sola automáticamente al terminar
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, usuario.getBoleta());
            ps.setInt(2, usuario.getIdTipo());
            ps.setString(3, usuario.getNomUser());
            ps.setString(4, usuario.getContrasenia());
            
            int filasAfectadas = ps.executeUpdate();
            //Regresa si fue completado con exito;
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario en el DAO: " + e.getMessage());
            return false;
        }
    }
    public Usuario consultarUsuario(String boleta, String contrasenia) {

    String sql = "SELECT * FROM Usuario "
               + "WHERE boleta = ? "
               + "AND contrasenia = ?";

    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, boleta);
        ps.setString(2, contrasenia);

        var rs = ps.executeQuery();

        if (rs.next()) {

            Usuario usuario = new Usuario();

            usuario.setBoleta(rs.getString("boleta"));
            usuario.setIdTipo(rs.getInt("idTipo"));
            usuario.setNomUser(rs.getString("nomUser"));
            usuario.setContrasenia(rs.getString("contrasenia"));

            return usuario;
        }

    } catch (SQLException e) {
        System.out.println("Error al consultar usuario: "
                + e.getMessage());
    }

    return null;
}
}