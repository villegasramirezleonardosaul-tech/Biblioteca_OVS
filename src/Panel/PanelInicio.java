package Panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelInicio extends JPanel {

    private JTextArea presentacion;
    private JLabel JImagen;
    private JLabel litconect;

    public PanelInicio() {
        setLayout(null);
        //Area de trabajo de ontiveros
        presentacion = new JTextArea();
        //Disponible a cambios
        presentacion.setText("""
                             Bienvenido a LitConect
                             
                             Litconect es una plataforma diseñada para facilitar
                             la lectura y el intercambio de ideas entre estudiantes
                             
                             En este sistema podras:
                             
                             - Consultar libros
                             - Participar en Foros
                             - Guardar ejemplares
                             
                             """);
        presentacion.setBounds(100, 75, 500, 500);
        presentacion.setEditable(false);
        presentacion.setBackground(Color.decode("#F4F4F6"));
        presentacion.setLineWrap(true);
        presentacion.setWrapStyleWord(true);
        Font letra = new Font("Segoe UI", Font.PLAIN, 22);
        presentacion.setFont(letra);
        add(presentacion);

        

        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/LITCONECT.png"));
        
        Image imagenEscalada = imagen.getImage()
                .getScaledInstance(400, 400, Image.SCALE_SMOOTH);

        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        JImagen = new JLabel(iconoEscalado);
        JImagen.setBounds(850, 75, 400, 400); 

        
        add(JImagen);  
    }
}
