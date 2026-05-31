package ClasesModelo;

import java.sql.Date;

public class Respuestas {
    private int idRespuesta;
    private int idMensaje;
    private String contenido;
    private Date fecha;

    public Respuestas() {}

    public Respuestas(int idMensaje, String contenido) {
        this.idMensaje = idMensaje;
        this.contenido = contenido;
    }

    public int getIdRespuesta() { 
        return idRespuesta; 
    }
    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getIdMensaje() { 
        return idMensaje;
    }
    public void setIdMensaje(int idMensaje) { 
        this.idMensaje = idMensaje;
    }

    public String getContenido() { 
        return contenido; 
    }
    public void setContenido(String contenido) { 
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}