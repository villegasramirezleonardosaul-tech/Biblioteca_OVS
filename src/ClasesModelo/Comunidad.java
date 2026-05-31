package ClasesModelo;

public class Comunidad {
    private int idComunidad;
    private String nombre;

    public Comunidad() {}

    public Comunidad(String nombre) {
        this.nombre = nombre;
    }

    public int getIdComunidad() { 
        return idComunidad;
    }
    public void setIdComunidad(int idComunidad) { 
        this.idComunidad = idComunidad;
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}