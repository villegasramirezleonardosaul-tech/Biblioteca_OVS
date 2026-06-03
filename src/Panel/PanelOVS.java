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
    private JTextArea wiki;
    private JLabel biblioteca;
    public PanelOVS(){
        setLayout(null);
        
        titulo = new JLabel("Sobre LitConect");
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(100, 50, 100, 50);
        
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/Biblioteca.png"));
        
        Image imagenEscalada = imagen.getImage()
                .getScaledInstance(400, 400, Image.SCALE_SMOOTH);

        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        biblioteca = new JLabel(iconoEscalado);
        biblioteca.setBounds(850, 75, 400, 400); 

        
        add(titulo);  
        add(biblioteca);  
    }
}
