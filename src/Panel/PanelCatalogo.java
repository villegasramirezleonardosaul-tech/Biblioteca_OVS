package Panel;

import ClasesModelo.Ebook;
import Memoria.Cache;
import static Memoria.Cache.favoritos;
import static Memoria.Cache.libros;
import Ventana.DialogoSubirLibro;
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

    private JPanel panel;
    private boolean flag;

    public PanelCatalogo(JPanel panel, ArrayList<Ebook> lista) {
        this.panel = panel;
        setLayout(null);
        setBackground(Color.decode("#F4F4F6"));
        crearBotones(lista);
        crearTitulos(lista);

    }

    public void crearBotones(ArrayList<Ebook> lista) {
        int tamaño = lista.size();
        for (int i = 0; i < tamaño; i++) {
            Ebook libro = lista.get(i);
            JButton boton = new JButton();
            if (i < 8) {

                boton.setBounds(100 + (150 * i), 0, 100, 150);
            } else {
                boton.setBounds(100 + (150 * (i - 8)), 250, 100, 150);
            }
            System.out.println(libro.getUrlLibro());
            Imagen(boton, libro.getUrlImagen());
            manita(boton);

            boton.addActionListener(e -> {
                panel.removeAll();

                PanelLibro biblioteca = new PanelLibro(panel, libro, lista);
                biblioteca.setBackground(Color.decode("#F4F4F6"));
                biblioteca.setBounds(0, 0, 1366, 575);

                panel.add(biblioteca);

                panel.revalidate();
                panel.repaint();
            });
            add(boton);
        }
        
        if (lista.size()==15) {
            
            JButton subir = new JButton("Subir");
            subir.setBounds(1150, 300, 100, 50);

            subir.addActionListener(e -> {

                DialogoSubirLibro dialogo
                        = new DialogoSubirLibro(panel);

                dialogo.setVisible(true);

            });

            add(subir);
        }

    }

    public void crearTitulos(ArrayList<Ebook> lista) {
        int tamaño = lista.size();
        int[] gordos = {1, 4, 11, 12, 13};
        for (int i = 0; i < tamaño; i++) {
            JLabel titulo = new JLabel(lista.get(i).getTitulo());

            if (i < 8) {

                titulo.setBounds(100 + (150 * i), 100, 160, 160);

                for (int j = 0; j < 2; j++) {
                    if (i == gordos[j]) {
                        titulo.setBounds((150 * i) + 90, 100, 160, 160);
                    }
                }
            } else {
                titulo.setBounds(100 + (150 * (i - 8)), 350, 160, 160);

                for (int j = 0; j < 5; j++) {
                    if (i == gordos[j]) {
                        titulo.setBounds((150 * (i - 8)) + 80, 350, 160, 160);
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
        System.out.println(txt);
        System.out.println(getClass().getResource(txt + ".png"));
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
