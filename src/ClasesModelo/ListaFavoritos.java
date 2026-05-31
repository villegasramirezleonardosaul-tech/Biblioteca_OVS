package ClasesModelo;

public class ListaFavoritos {
    private int idLista;
    private int idLibro;
    private int boleta;
    private String nomLista;

    public ListaFavoritos() {}

    public ListaFavoritos(int idLibro, int boleta, String nomLista) {
        this.idLibro = idLibro;
        this.boleta = boleta;
        this.nomLista = nomLista;
    }

    public int getIdLista() { 
        return idLista; 
    }
    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public int getIdLibro() { 
        return idLibro; 
    }
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getBoleta() { 
        return boleta; 
    }
    public void setBoleta(int boleta) { 
        this.boleta = boleta;
    }

    public String getNomLista() { 
        return nomLista; 
    }
    public void setNomLista(String nomLista) { 
        this.nomLista = nomLista;
    }
}