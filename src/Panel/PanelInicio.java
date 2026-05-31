package Panel;

import java.awt.Color;
import java.awt.Font;
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
        presentacion.setText("""
                             Bienvenido a LitConect
                             
                             Litconect es una plataforma diseñada para facilitar
                             la lectura y el intercambio de ideas entre estudiantes
                             
                             En este sistema podras:
                             
                             - Consultar libros
                             - Participar en Foros
                             - Guardar ejemplares
                             - Y mas 
                             
                             //Metanle ideas porque me quede seco
                             """);
        presentacion.setBounds(100, 75, 500, 500);
        presentacion.setEditable(false);
        presentacion.setBackground(Color.decode("#F4F4F6"));
        presentacion.setLineWrap(true);
        presentacion.setWrapStyleWord(true);
        Font letra = new Font("Segoe UI", Font.PLAIN, 22);
        presentacion.setFont(letra);
        add(presentacion);

        litconect = new JLabel("LITCONECT",JLabel.RIGHT);
        litconect.setBounds(750, 85, 500, 50); 
        Font titulo = new Font("Segoe UI", Font.BOLD, 40);
        litconect.setFont(titulo);
        litconect.setForeground(Color.decode("#A61B1B"));

        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/Empresa.png"));
        JImagen = new JLabel(imagen);
        JImagen.setBounds(750, 75, 500, 450); 

        add(litconect); 
        add(JImagen);  
    }
}
