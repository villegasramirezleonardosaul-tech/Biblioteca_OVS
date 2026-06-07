package Panel;

import ClasesModelo.Ebook;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelBiblioteca extends JPanel {
    
    private JPanel panel;
    
    public PanelBiblioteca (JPanel panel, ArrayList<Ebook> lista){
        System.out.println("aqui");
        this.panel = panel;
        setLayout(null);
                
        
        PanelContenedorCatalogo catalogo = new PanelContenedorCatalogo(panel,lista);
        catalogo.setBounds(0, 50,1366 , 768-50);
        catalogo.setBackground(Color.decode("#F4F4F6"));
        
        PanelBusqueda buscar = new PanelBusqueda(catalogo,panel,lista);
        buscar.setBounds(0, 0,1366 , 50);
        buscar.setBackground(Color.decode("#F4F4F6"));
        
        add(buscar);
        add(catalogo);
    }
}
