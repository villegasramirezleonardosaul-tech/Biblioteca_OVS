package Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBusqueda extends JPanel{
    
    public PanelBusqueda(){
        setLayout(null);
        
        JLabel titulo = new JLabel("Busqueda: ");
        titulo.setBounds(1000, 0,100, 50);
        
        JTextField busqueda = new JTextField("");
        busqueda.setBounds(1120, 10, 100, 25);
        
        
        add(titulo);
        add(busqueda);
    }
}
