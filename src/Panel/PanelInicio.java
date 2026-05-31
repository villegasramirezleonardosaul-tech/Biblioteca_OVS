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
        presentacion.setBounds(100, 75, 500, 400);
        presentacion.setEditable(false);
        presentacion.setBackground(Color.lightGray);
        
        presentacion.setLineWrap(true);
        presentacion.setWrapStyleWord(true);
        Font letra = new Font("Segoe UI", Font.PLAIN, 20);
        presentacion.setFont(letra);
        add(presentacion);
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/Empresa.png"));
        JImagen = new JLabel(imagen);
        JImagen.setBounds(700, 75, 450, 400);
        add(JImagen);
        
    }
}
