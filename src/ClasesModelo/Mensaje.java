package ClasesModelo;

import java.sql.Date;
import java.util.ArrayList;

public class Mensaje {
    private int idMensaje;
    private int idComunidad;
    private String descripcion;
    private Date fecha;
    
    private ArrayList<Respuestas> respuestas;

    public Mensaje() {}

    public Mensaje(int idComunidad, String descripcion) {
        this.idComunidad = idComunidad;
        this.descripcion = descripcion;
    }

    public int getIdMensaje() {
        return idMensaje;
    }
    public void setIdMensaje(int idMensaje) { 
        this.idMensaje = idMensaje; 
    }

    public int getIdComunidad() {
        return idComunidad; 
    }
    public void setIdComunidad(int idComunidad) {
        this.idComunidad = idComunidad;
    }

    public String getDescripcion() { 
        return descripcion; 
    }
    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion;
    }

    public Date getFecha() { 
        return fecha;
    }
    public void setFecha(Date fecha) { 
        this.fecha = fecha;
    }
}