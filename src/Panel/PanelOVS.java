package Panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelOVS extends JPanel {
    private JLabel titulo;
    private JLabel biblioteca;
    public PanelOVS(){
        setLayout(null);
        
        titulo = new JLabel("Sobre OVS");
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(800, 25, 400, 50);
        
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/Biblioteca.png"));
        
        Image imagenEscalada = imagen.getImage()
                .getScaledInstance(400, 400, Image.SCALE_SMOOTH);

        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        biblioteca = new JLabel(iconoEscalado);
        biblioteca.setBounds(100, 75, 400, 400); 

        
        JTextArea presentacion = new JTextArea();
        //Disponible a cambios
        presentacion.setText("""
                             OVS nace como la idea de 4 estudiantes 
                             de programacion para realizar 
                             aplicaciones que sean de utilidad 
                             principalmente por y para 
                             estudiantes 
                             
                             De nuestros proyectos:
                             
                             PAE: (Programa de administracion academica)
                             LitConnect: (Biblioteca digital)
                             """);
        presentacion.setBounds(650, 100, 500, 500);
        presentacion.setEditable(false);
        presentacion.setBackground(Color.decode("#F4F4F6"));
        presentacion.setLineWrap(true);
        presentacion.setWrapStyleWord(true);
        Font letra = new Font("Segoe UI", Font.PLAIN, 22);
        presentacion.setFont(letra);
        add(presentacion);
        
        add(titulo);  
        add(biblioteca);  
    }
}
