package Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelInicio extends JPanel {
    private JTextArea presentacion;
    public PanelInicio(){
        setLayout(null);
        //Area de trabajo de ontiveros
        presentacion =new JTextArea();
        presentacion.setText("""
                             Bienvenido a LitConect
                             
                             Litconect es una plataforma diseñada para facilitar
                             la lectura y el intercambio de ideas entre estudiantes
                             
                             En este sistema podras:
                             
                             - Consultar libros
                             - Participar en Foros
                             - Guardar ejemplares
                             - Y mas 
                             
                             //Metanle ideas porque me quede seco
                             """);
        presentacion.setBounds(50, 50, getWidth(), 100);
        presentacion.setEditable(false);
        
        add(presentacion);
    }
}
