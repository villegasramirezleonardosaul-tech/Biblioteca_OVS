package DAO;

import Conexiones.Conexion;
import ClasesModelo.Mensaje;
import Conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensajeDAO {

    public boolean insertarMensaje(Mensaje mensaje) {
        // Nota: omitimos la columna 'fecha' porque en tu SQL tiene "default(current_date)" y se llena sola
        String sql = "INSERT INTO Mensaje (idComunidad, descripcion) VALUES (?, ?)";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, mensaje.getIdComunidad());
            ps.setString(2, mensaje.getDescripcion());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al publicar mensaje en el DAO: " + e.getMessage());
            return false;
        }
    }
}