package Panel;

import ClasesModelo.Ebook;
import static Memoria.Cache.libros;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBusqueda extends JPanel {

    public PanelBusqueda(JPanel contenedor, JPanel panel, ArrayList<Ebook> lista) {
        setLayout(null);

        JLabel titulo = new JLabel("Busqueda: ");
        titulo.setBounds(1000, 0, 100, 50);

        JTextField busqueda = new JTextField("");
        busqueda.setBounds(1120, 10, 100, 25);

        busqueda.addActionListener(e -> {

            ArrayList<Ebook> depurada = new ArrayList<>();
            int tamaño = lista.size();

            String texto = busqueda.getText();

            contenedor.removeAll();
            if (!texto.isEmpty()) {

                for (int i = 0; i < tamaño; i++) {
                    if (lista.get(i).getTitulo().toLowerCase()
                            .startsWith(texto.toLowerCase())) {

                        depurada.add(lista.get(i));
                    }
                }

                PanelCatalogo biblioteca = new PanelCatalogo(panel, depurada);
                biblioteca.setBounds(0, 0, 1366, 768 - 50);
                biblioteca.setBackground(Color.decode("#F4F4F6"));
                contenedor.add(biblioteca);
            }else{
                PanelCatalogo biblioteca = new PanelCatalogo(panel, lista);
                biblioteca.setBounds(0, 0, 1366, 768 - 50);
                biblioteca.setBackground(Color.decode("#F4F4F6"));
                contenedor.add(biblioteca);
                
            }

            contenedor.revalidate();
            contenedor.repaint();
        });

        add(titulo);
        add(busqueda);
    }
}
