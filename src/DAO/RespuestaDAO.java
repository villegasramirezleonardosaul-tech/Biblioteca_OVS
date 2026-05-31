package DAO;

import Conexiones.Conexion;
import ClasesModelo.Respuestas;
import Conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RespuestaDAO {

    public boolean insertarRespuesta(Respuestas respuesta) {
        String sql = "INSERT INTO Respuesta (idMensaje, contenido) VALUES (?, ?)";
        
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, respuesta.getIdMensaje());
            ps.setString(2, respuesta.getContenido());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Error al insertar respuesta en el DAO: " + e.getMessage());
            return false;
        }
    }
}