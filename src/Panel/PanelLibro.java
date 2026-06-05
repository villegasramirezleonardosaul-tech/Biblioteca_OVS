package Panel;

import ClasesModelo.Ebook;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLibro extends JPanel {
    
    private JLabel imagen;
    private JLabel titulo;
    
    private JButton salir;
    private JButton leer;
    private JButton favorito;
    
    public PanelLibro(JPanel panel,Ebook libro){
        setLayout(null);
        setBounds(0, 0, 1366, 768);
        
        imagen = new JLabel();
        Imagen(imagen, libro.getUrlImagen());
        imagen.setBounds(100, 100, 300, 350);
        
        titulo = new JLabel(libro.getTitulo());
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(700, 25, 500, 50);
        
        salir = new JButton("Salir");
        Imagen(salir, "Salir");
        salir.setBounds(25, 0, 105, 80);
        Listenermouse(salir, "Salir");
        
        salir.addActionListener(e->{
            

            panel.removeAll();

            PanelBiblioteca biblioteca = new PanelBiblioteca(panel);
            biblioteca.setBackground(Color.decode("#F4F4F6"));
            biblioteca.setBounds(0, 0, 1366, 575);

            panel.add(biblioteca);

            panel.revalidate();
            panel.repaint();
        });
        
        leer = new JButton("Salir");
        Imagen(salir, "Salir");
        salir.setBounds(25, 0, 105, 80);
        Listenermouse(salir, "Salir"); 
        
        JLabel autor = new JLabel("Autor: " + libro.getAutor());
        autor.setBounds(500, 100, 300, 25);
        autor.setFont(new Font("Arial", Font.PLAIN, 20));
        autor.setForeground(Color.BLACK);
        add(autor);
        JLabel editorial = new JLabel("Editorial: "+libro.getEditorial());
        editorial.setBounds(500, 200, 300, 25);
        editorial.setFont(new Font("Arial", Font.PLAIN, 20));
        editorial.setForeground(Color.BLACK);
        add(editorial);
        String pag = Integer.toString(libro.getnPaginas());
        JLabel paginas = new JLabel("Numero de paginas; " +pag );
        paginas.setBounds(500, 400, 300, 25);
        paginas.setFont(new Font("Arial", Font.PLAIN, 20));
        paginas.setForeground(Color.BLACK);
        add(paginas);
        JLabel tipo = new JLabel("Etiqueta: " +libro.getTipo());
        tipo.setBounds(500, 300, 300, 25);
        tipo.setFont(new Font("Arial", Font.PLAIN, 20));
        tipo.setForeground(Color.BLACK);
        add(tipo);
        
        
        add(imagen);
        add(titulo);
        add(salir);
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
