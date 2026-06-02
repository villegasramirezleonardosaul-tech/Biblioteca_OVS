package ClasesModelo;

public class Usuario {
    private String boleta;
    private int idTipo;
    private String nomUser;
    private String contrasenia;

    public Usuario() {}

    public Usuario(String boleta, int idTipo, String nomUser, String contrasenia) {
        this.boleta = boleta;
        this.idTipo = idTipo;
        this.nomUser = nomUser;
        this.contrasenia = contrasenia;
    }

    public String getBoleta() { 
        return boleta; 
    }
    public void setBoleta(String boleta) { 
        this.boleta = boleta; 
    }

    public int getIdTipo() { 
        return idTipo; 
    }
    public void setIdTipo(int idTipo) { 
        this.idTipo = idTipo;
    }

    public String getNomUser() { 
        return nomUser; 
    }
    public void setNomUser(String nomUser) {
       this.nomUser = nomUser; 
    }

    public String getContrasenia() { 
        return contrasenia; 
    }
    public void setContrasenia(String contrasenia) { 
        this.contrasenia = contrasenia;
    }
}