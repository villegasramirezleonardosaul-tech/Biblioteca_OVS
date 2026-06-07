package Ventana;

import ClasesModelo.Ebook;
import DAO.EbookDAO;
import Memoria.Cache;
import static Memoria.Cache.libros;
import static Memoria.Cache.tag;
import Panel.PanelBiblioteca;
import Panel.PanelLibro;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

public class DialogoSubirLibro extends JDialog {
    
    private JPanel panel;

    private File archivoPdf;
    private File archivoImagen;

    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtEditorial;

    private JButton btnPortada;
    private JButton btnPdf;
    private JButton btnGuardar;
    private JButton btnCancelar;

    private JComboBox<String> Tags;

    public DialogoSubirLibro(JPanel panel) {
        this.panel = panel;

        setTitle("Subir Libro");
        setModal(true);
        setSize(500, 500);

        setLayout(null);
        setResizable(false);

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(40, 40, 100, 25);
        add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(140, 40, 250, 25);
        add(txtTitulo);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(40, 90, 100, 25);
        add(lblAutor);

        txtAutor = new JTextField();
        txtAutor.setBounds(140, 90, 250, 25);
        add(txtAutor);

        JLabel lblEditorial = new JLabel("Editorial:");
        lblEditorial.setBounds(40, 140, 100, 25);
        add(lblEditorial);

        txtEditorial = new JTextField();
        txtEditorial.setBounds(140, 140, 250, 25);
        add(txtEditorial);

        JLabel Tag = new JLabel("Tag:");
        Tag.setBounds(40, 190, 100, 25);
        add(Tag);

        Tags = new JComboBox<>();

        for (int i = 0; i < tag.size(); i++) {

            Tags.addItem(tag.get(i));
        }
        Tags.setBounds(140, 190, 250, 25);
        add(Tags);

        btnPortada = new JButton("Seleccionar portada");
        btnPortada.setBounds(140, 240, 180, 30);
        add(btnPortada);

        btnPortada.addActionListener(e -> {

            JFileChooser selector = new JFileChooser();

            FileNameExtensionFilter filtro
                    = new FileNameExtensionFilter(
                            "Imágenes",
                            "jpg",
                            "jpeg",
                            "png"
                    );

            selector.setFileFilter(filtro);

            int opcion = selector.showOpenDialog(this);

            if (opcion == JFileChooser.APPROVE_OPTION) {

                archivoImagen = selector.getSelectedFile();

                btnPortada.setText("Portada seleccionada");
            }
        });

        btnPdf = new JButton("Seleccionar PDF");
        btnPdf.setBounds(140, 290, 180, 30);
        add(btnPdf);

        btnPdf.addActionListener(e -> {

            JFileChooser selector = new JFileChooser();

            FileNameExtensionFilter filtro
                    = new FileNameExtensionFilter(
                            "Archivos PDF",
                            "pdf"
                    );

            selector.setFileFilter(filtro);

            int opcion = selector.showOpenDialog(this);

            if (opcion == JFileChooser.APPROVE_OPTION) {

                archivoPdf = selector.getSelectedFile();

                btnPdf.setText("PDF seleccionado");
            }
        });

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 360, 120, 35);
        add(btnGuardar);

        btnGuardar.addActionListener(e -> {

            int idTag = Tags.getSelectedIndex() + 1;
            String nombrePdf = archivoPdf.getName();
            String nombreImagen = archivoImagen.getName();
            System.out.println(nombrePdf);
            System.out.println(nombreImagen);
            String autor = txtAutor.getText();
            String editorial = txtEditorial.getText();
            String titulo = txtTitulo.getText();
            int paginas = obtenerNumeroPaginas(archivoPdf);
            EbookDAO dao = new EbookDAO();
            
            String pelon = nombreImagen.replace(".png", "");
            
            Ebook libro = new Ebook(0, idTag, titulo, autor, paginas,
                    editorial,"Libros/" + nombrePdf , "/Imagenes/" + pelon );
            
            dao.insertar(libro);
            Cache.AñadirLibro(libro);
            

            Path destinoPdf
                    = Path.of("src/Libros", nombrePdf);

            try {
                Files.copy(
                        archivoPdf.toPath(),
                        destinoPdf,
                        StandardCopyOption.REPLACE_EXISTING
                );
            } catch (IOException ex) {
                System.getLogger(DialogoSubirLibro.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }

            Path destinoImagen
                    = Path.of("src/Imagenes", nombreImagen);

            try {
                Files.copy(
                        archivoImagen.toPath(),
                        destinoImagen,
                        StandardCopyOption.REPLACE_EXISTING
                );
            } catch (IOException ex) {
                System.getLogger(DialogoSubirLibro.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
            
            dispose();
            
            panel.removeAll();

                PanelBiblioteca biblioteca = new PanelBiblioteca(panel, libros);
                biblioteca.setBackground(Color.decode("#F4F4F6"));
                biblioteca.setBounds(0, 0, 1366, 575);

                panel.add(biblioteca);

                panel.revalidate();
                panel.repaint();
        });

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(260, 360, 120, 35);
        add(btnCancelar);

        btnCancelar.addActionListener(e -> dispose());
    }
   
    private int obtenerNumeroPaginas(File archivoPdf) {

    try (PDDocument pdf = Loader.loadPDF(archivoPdf)) {

        return pdf.getNumberOfPages();

    } catch (Exception e) {

        System.out.println("Error al leer PDF");
        e.printStackTrace();

        return 0;
    }
}
}
