package Panel;

import java.awt.Color;
import javax.swing.JPanel;

public class PanelBiblioteca extends JPanel {
    public PanelBiblioteca (){
        setLayout(null);
                
        PanelBusqueda buscar = new PanelBusqueda();
        buscar.setBounds(0, 0,1366 , 50);
        buscar.setBackground(Color.decode("#F4F4F6"));
        
        PanelCatalogo catalogo = new PanelCatalogo();
        catalogo.setBounds(0, 50,1366 , 768-50);
        catalogo.setBackground(Color.decode("#F4F4F6"));
        
        add(buscar);
        add(catalogo);
    }
}
