package Panel;

import java.awt.Color;
import javax.swing.JPanel;

public class PanelBiblioteca extends JPanel {
    
    private JPanel panel;
    
    public PanelBiblioteca (JPanel panel,boolean flag){
        System.out.println("aqui");
        this.panel = panel;
        setLayout(null);
                
        PanelBusqueda buscar = new PanelBusqueda();
        buscar.setBounds(0, 0,1366 , 50);
        buscar.setBackground(Color.decode("#F4F4F6"));
        
        PanelContenedorCatalogo catalogo = new PanelContenedorCatalogo(panel,flag);
        catalogo.setBounds(0, 50,1366 , 768-50);
        catalogo.setBackground(Color.decode("#F4F4F6"));
        
        add(buscar);
        add(catalogo);
    }
}
