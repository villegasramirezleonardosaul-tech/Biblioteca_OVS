package Panel;

import ClasesModelo.Ebook;
import ClasesModelo.ListaFavoritos;
import DAO.ListaFavoritosDAO;
import Memoria.Cache;
import static Memoria.Cache.favoritos;
import static Memoria.Cache.usuario;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelLibro extends JPanel {

    private JLabel imagen;
    private JLabel titulo;
    private JLabel advertencia;

    private JButton salir;
    private JButton leer;
    private JButton favorito;
    private JButton borrar;

    public PanelLibro(JPanel panel, Ebook libro, ArrayList<Ebook> lista) {
        setLayout(null);
        setBounds(0, 0, 1366, 768);

        imagen = new JLabel();
        Imagen(imagen, libro.getUrlImagen());
        imagen.setBounds(100, 100, 300, 350);

        titulo = new JLabel(libro.getTitulo());
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(700, 25, 500, 50);

        advertencia = new JLabel("Hay que iniciar secion para guardar");
        advertencia.setBounds(150, 530, 500, 25);

        salir = new JButton("Salir");
        Imagen(salir, "Salir");
        salir.setBounds(25, 0, 105, 80);
        Listenermouse(salir, "Salir");

        salir.addActionListener(e -> {

            panel.removeAll();

            PanelBiblioteca biblioteca = new PanelBiblioteca(panel,lista);
            biblioteca.setBackground(Color.decode("#F4F4F6"));
            biblioteca.setBounds(0, 0, 1366, 575);

            panel.add(biblioteca);

            panel.revalidate();
            panel.repaint();
        });

        leer = new JButton("Leer");
        Imagen(leer, "Leer");
        leer.setBounds(150, 450, 105, 80);
        Listenermouse(leer, "Leer");

        leer.addActionListener(e -> {

            try {
                File pdf = new File("src/" + libro.getUrlLibro());
                System.out.println(libro.getUrlLibro());
                Desktop.getDesktop().open(pdf);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Error al abrir el PDF"
                );

                ex.printStackTrace();
            }
        });

        favorito = new JButton("Añadir");
        Imagen(favorito, "Añadir");
        favorito.setBounds(260, 450, 105, 80);
        Listenermouse(favorito, "Añadir");

        favorito.addActionListener(e -> {
            ListaFavoritos fav = new ListaFavoritos(libro, usuario.getBoleta());
            ListaFavoritosDAO insert = new ListaFavoritosDAO();
            insert.insertarFavorito(fav);
            Cache.AñadirFavoritos(libro);
            borrar.setVisible(true);
            favorito.setVisible(false);
        });

        borrar = new JButton("Eliminar");
        Imagen(borrar, "Eliminar");
        borrar.setBounds(260, 450, 105, 80);
        Listenermouse(borrar, "Eliminar");

        borrar.addActionListener(e -> {
            ListaFavoritos fav = new ListaFavoritos(libro, usuario.getBoleta());
            ListaFavoritosDAO insert = new ListaFavoritosDAO();
            insert.eliminarFavorito(fav);
            Cache.EliminarFavoritos(libro);
            borrar.setVisible(false);
            favorito.setVisible(true);
        });

        JLabel autor = new JLabel("Autor: " + libro.getAutor());
        autor.setBounds(500, 100, 300, 25);
        autor.setFont(new Font("Arial", Font.PLAIN, 20));
        autor.setForeground(Color.BLACK);
        add(autor);
        JLabel editorial = new JLabel("Editorial: " + libro.getEditorial());
        editorial.setBounds(500, 200, 300, 25);
        editorial.setFont(new Font("Arial", Font.PLAIN, 20));
        editorial.setForeground(Color.BLACK);
        add(editorial);
        String pag = Integer.toString(libro.getnPaginas());
        JLabel paginas = new JLabel("Numero de paginas; " + pag);
        paginas.setBounds(500, 400, 300, 25);
        paginas.setFont(new Font("Arial", Font.PLAIN, 20));
        paginas.setForeground(Color.BLACK);
        add(paginas);
        JLabel tipo = new JLabel("Etiqueta: " + libro.getTipo());
        tipo.setBounds(500, 300, 300, 25);
        tipo.setFont(new Font("Arial", Font.PLAIN, 20));
        tipo.setForeground(Color.BLACK);
        add(tipo);

        add(imagen);
        add(titulo);
        add(leer);
        add(favorito);
        add(advertencia);
        add(salir);
        add(borrar);

        if (usuario == null) {
            favorito.setVisible(false);
            advertencia.setVisible(true);
            borrar.setVisible(false);

        } else {

            int tamaño = favoritos.size();
            for (int i = 0; i < tamaño; i++) {
                if (favoritos.get(i).getIdLibro().getIdLibro() == libro.getIdLibro()) {

                    borrar.setVisible(true);
                    favorito.setVisible(false);
                    break;
                } else {
                    borrar.setVisible(false);
                    favorito.setVisible(true);

                }
            }
            advertencia.setVisible(false);

        }
    }

    public void Imagen(JLabel boton, String txt) {
        ImageIcon iconoOriginal = new ImageIcon(
                getClass().getResource(txt + ".png")
        );
        //Sirve pa escalar imagenes 
        Image imagenEscalada = iconoOriginal.getImage()
                .getScaledInstance(300, 350, Image.SCALE_SMOOTH);

        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        boton.setIcon(iconoEscalado);
        boton.setBorder(null);
    }

    public void Imagen(JButton boton, String txt) {
        ImageIcon iconoOriginal = new ImageIcon(
                getClass().getResource("/Botones/" + txt + ".png")
        );
        //Sirve pa escalar imagenes 
        Image imagenEscalada = iconoOriginal.getImage()
                .getScaledInstance(120, 80, Image.SCALE_SMOOTH);

        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        boton.setIcon(iconoEscalado);
        boton.setBorder(null);
    }

    private void Listenermouse(JButton boton, String txt) {
        manita(boton);
        boton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon iconoOriginal = new ImageIcon(
                        getClass().getResource("/Botones/" + txt + "_B.png")
                );
                //Sirve pa escalar imagenes 
                Image imagenEscalada = iconoOriginal.getImage()
                        .getScaledInstance(120, 80, Image.SCALE_SMOOTH);

                ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

                boton.setIcon(iconoEscalado);
            }

            @Override
            public void mouseExited(MouseEvent e) {

                ImageIcon iconoOriginal = new ImageIcon(
                        getClass().getResource("/Botones/" + txt + ".png")
                );
                //Sirve pa escalar imagenes 
                Image imagenEscalada = iconoOriginal.getImage()
                        .getScaledInstance(120, 80, Image.SCALE_SMOOTH);

                ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

                boton.setIcon(iconoEscalado);

            }
        });
    }

    private void manita(JButton boton) {
        boton.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR
                )
        );
    }

}
