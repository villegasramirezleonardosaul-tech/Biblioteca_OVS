package Memoria;

import ClasesModelo.Comunidad;
import ClasesModelo.Ebook;
import ClasesModelo.Mensaje;
import ClasesModelo.Usuario;
import DAO.EbookDAO;
import java.util.ArrayList;
import java.util.HashMap;

public class Cache {
    
    public static ArrayList<Ebook> libros;
    public static ArrayList<Ebook> favoritos;
    public static Usuario usuario;
    public static ArrayList<Comunidad> comunidades;
    public static HashMap<Integer,ArrayList<Mensaje>> mensajes;
    
    public static void BuscarLibros(){
        EbookDAO dao = new EbookDAO();
        libros = dao.consultarTodos();
    }
}
