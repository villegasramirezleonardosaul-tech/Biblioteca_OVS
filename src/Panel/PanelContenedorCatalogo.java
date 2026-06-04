package Panel;

import javax.swing.JPanel;

public class PanelContenedorCatalogo extends JPanel {
    private JPanel panel;
    
    public PanelContenedorCatalogo(JPanel panel){
        this.panel = panel;
        setLayout(null);
        setBounds(0, 0, 1366, 768);
        
        PanelCatalogo catalogo = new PanelCatalogo(panel);
        catalogo.setBounds(0, 0, 1366, 768);
        add(catalogo);
    }
}
