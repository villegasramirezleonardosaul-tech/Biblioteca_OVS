package ClasesModelo;

public class ListaFavoritos {
    private int idLista;
    private Ebook Libro;
    private String boleta;

    public ListaFavoritos() {}

    public ListaFavoritos(Ebook idLibro, String boleta) {
        this.Libro = idLibro;
        this.boleta = boleta;
        
    }

    public int getIdLista() { 
        return idLista; 
    }
    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public Ebook getIdLibro() { 
        return Libro; 
    }
    public void setIdLibro(Ebook idLibro) {
        this.Libro = idLibro;
    }

    public String getBoleta() { 
        return boleta; 
    }
    public void setBoleta(String boleta) { 
        this.boleta = boleta;
    }

}