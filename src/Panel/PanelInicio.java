package Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInicio extends JPanel {
    private final JLabel titulo;
    public PanelInicio(){
        setLayout(null);
        titulo = new JLabel("Inicio");
        titulo.setBounds(50, 200,100, 50);
        add(titulo);
    }
}
