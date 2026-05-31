package ClasesModelo;

public class Ebook {
    private int idLibro;
    private int idTag;
    private String titulo;
    private String autor;
    private int nPaginas;
    private String editorial;
    private String urlLibro;
    private String urlImagen;

    // Constructor vacío (Es obligatorio para que el ResultSet del DAO pueda instanciarlo)
    public Ebook() {}

    // Constructor lleno (Útil por si en algún momento necesitan crear objetos libro rápidamente)
    public Ebook(int idLibro, int idTag, String titulo, String autor, int nPaginas, String editorial, String urlLibro, String urlImagen) {
        this.idLibro = idLibro;
        this.idTag = idTag;
        this.titulo = titulo;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.editorial = editorial;
        this.urlLibro = urlLibro;
        this.urlImagen = urlImagen;
    }

    // ========================================================
    // GETTERS Y SETTERS
    // ========================================================
    
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getIdTag() {
        return idTag;
    }

    public void setIdTag(int idTag) {
        this.idTag = idTag;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getUrlLibro() {
        return urlLibro;
    }

    public void setUrlLibro(String urlLibro) {
        this.urlLibro = urlLibro;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}