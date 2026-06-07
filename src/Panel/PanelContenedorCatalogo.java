package Panel;

import ClasesModelo.Ebook;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelContenedorCatalogo extends JPanel {
    private JPanel panel;
    
    public PanelContenedorCatalogo(JPanel panel,ArrayList<Ebook> lista){
        System.out.println("aqui tambien");
        this.panel = panel;
        setLayout(null);
        setBounds(0, 0, 1500, 1000);
        
        PanelCatalogo catalogo = new PanelCatalogo(panel, lista);
        catalogo.setBounds(0, 0, 1500, 1000);
        add(catalogo);
    }
}
