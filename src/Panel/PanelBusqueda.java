package Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelBusqueda extends JPanel{
    private final JLabel titulo;
    public PanelBusqueda(){
        setLayout(null);
        titulo = new JLabel("Inicio");
        titulo.setBounds(50, 200,100, 50);
        add(titulo);
    }
}
