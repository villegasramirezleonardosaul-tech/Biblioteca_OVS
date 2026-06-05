package Panel;

import javax.swing.JPanel;

public class PanelContenedorCatalogo extends JPanel {
    private JPanel panel;
    
    public PanelContenedorCatalogo(JPanel panel,boolean flag){
        System.out.println("aqui tambien");
        this.panel = panel;
        setLayout(null);
        setBounds(0, 0, 1500, 1000);
        
        PanelCatalogo catalogo = new PanelCatalogo(panel,flag);
        catalogo.setBounds(0, 0, 1500, 1000);
        add(catalogo);
    }
}
