package Panel;

import ClasesModelo.Ebook;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelLibro extends JPanel {
    
    private JLabel imagen;
    
    private JButton salir;
    
    public PanelLibro(JPanel panel,Ebook libro){
        setLayout(null);
        setBounds(0, 0, 1366, 768);
        
        imagen = new JLabel();
        imagen.setBounds(100, 50, 300, 350);
        
        salir = new JButton("Salir");
        salir.setBounds(0, 0, 100, 50);
        
        Imagen(imagen, libro.getUrlImagen());
        add(imagen);
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
}
