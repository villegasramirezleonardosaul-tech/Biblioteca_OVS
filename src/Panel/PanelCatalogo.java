package Panel;

import ClasesModelo.Ebook;
import DAO.EbookDAO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCatalogo extends JPanel {

    private ArrayList<Ebook> catalogo;

    public PanelCatalogo() {
        setLayout(null);

        EbookDAO dao = new EbookDAO();
        catalogo = dao.consultarTodos();
        crearBotones(catalogo);
        crearTitulos(catalogo);
    }

    public void crearBotones(ArrayList<Ebook> lista) {
        int tamaño = lista.size();
        for (int i = 0; i < tamaño; i++) {
            JButton boton = new JButton("emos aqui" + i);
            if (i < 8) {

                boton.setBounds(100 + (150 * i), 0, 100, 150);
            } else {
                boton.setBounds(100 + (150 * (i - 8)), 250, 100, 150);
            }

            Imagen(boton, lista.get(i).getUrlImagen());
            manita(boton);
            add(boton);
        }
    }

    public void crearTitulos(ArrayList<Ebook> lista) {
        int tamaño = lista.size();
        int[] gordos = {1,4,11,12,13};
        for (int i = 0; i < tamaño; i++) {
            JLabel titulo = new JLabel(lista.get(i).getTitulo());

            if (i < 8) {

                titulo.setBounds(100 + (150 * i), 100, 160, 160);
                
                for (int j = 0; j < 2; j++) {
                    if (i==gordos[j]) {
                        titulo.setBounds((150*i) + 90, 100, 160, 160);
                    }
                }
            } else {
                titulo.setBounds(100 + (150 * (i - 8)), 350, 160, 160);
                
                for (int j = 0; j < 5; j++) {
                    if (i==gordos[j]) {
                        titulo.setBounds((150*(i-8)) + 80, 350, 160, 160);
                    }
                }
            }
            Font letra = new Font("Segoe UI", Font.BOLD, 9);
            titulo.setFont(letra);
            titulo.setForeground(Color.BLACK);
            

            add(titulo);
        }
    }

    public void Imagen(JButton boton, String txt) {
        ImageIcon iconoOriginal = new ImageIcon(
                getClass().getResource(txt + ".png")
        );
        //Sirve pa escalar imagenes 
        Image imagenEscalada = iconoOriginal.getImage()
                .getScaledInstance(120, 150, Image.SCALE_SMOOTH);

        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        boton.setIcon(iconoEscalado);
        boton.setBorder(null);
    }
    
     private void manita(JButton boton) {
        boton.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR
                )
        );
    }
}
