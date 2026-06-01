package Ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Panel.*;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

public class VentanaPrincipal extends JFrame {

    private JPanel panelMenu;
    private JPanel panelContenido;
    private JPanel panelPie;

    private JButton btnLogo;
    private JButton btnInicio;
    private JButton seleccionado;
    private JButton btnBiblioteca;
    private JButton btnForo;
    private JButton btnFavoritos;
    private JButton btnSecion;
    private JButton btnCuenta;

    private JLabel marcaregistrada;

    private int ancho;
    private int largo;

    private PanelInicio inicio;

    public VentanaPrincipal() {
        configurarVentana();
        paneles();

    }

    //Esta es para crear la ventana 
    private void configurarVentana() {
        setTitle("LitConect");
        //Tamaño del monitor
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        ancho = pantalla.width;
        largo = pantalla.height;
        setSize(ancho, largo);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        //Este es la imagen de la ventanita 
        ImageIcon icono;
        icono = new ImageIcon(getClass().getResource("/Imagenes/logolimpio.png"));
        setIconImage(icono.getImage());
    }

    private void paneles() {
        fijos();
        catalogo();
    }

    private void fijos() {
        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, ancho, 100);
        panelMenu.setBackground(Color.BLACK);

        panelContenido = new JPanel();
        panelContenido.setLayout(null);
        panelContenido.setBounds(0, 100, ancho, 575);
        panelContenido.setBackground(Color.decode("#F4F4F6"));

        panelPie = new JPanel();
        panelPie.setLayout(null);
        panelPie.setBounds(0, 675, ancho, largo - 675);
        panelPie.setBackground(Color.black);

        botones();
        label();
        add(panelMenu);
        add(panelContenido);
        add(panelPie);

    }

    private void botones() {
        btnLogo = new JButton();
        btnLogo.setBounds(10, 10, 80, 80);
        ImageIcon iconoOriginal = new ImageIcon(
                getClass().getResource("/Imagenes/logolimpio.png")
        );
        //Sirve pa escalar imagenes 
        Image imagenEscalada = iconoOriginal.getImage()
                .getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        btnLogo.setIcon(iconoEscalado);
        btnLogo.setBorderPainted(false);
        btnLogo.setFocusPainted(false);
        btnLogo.setContentAreaFilled(false);

        btnInicio = new JButton("Inicio");
        btnInicio.setBounds(100, 25, 100, 50);
        btnInicio.setForeground(Color.BLACK);
        
        btnBiblioteca = new JButton("Bilbioteca");
        btnBiblioteca.setBounds(210, 25, 100, 50);
                btnBiblioteca.setForeground(Color.BLACK);

        
        btnFavoritos = new JButton("Favoritos");
        btnFavoritos.setBounds(320, 25, 100, 50);
                btnFavoritos.setForeground(Color.BLACK);

        
        btnForo = new JButton("Foros");
        btnForo.setBounds(430, 25, 100, 50);
                btnForo.setForeground(Color.BLACK);

        
        btnSecion = new JButton("Login");
        btnSecion.setBounds(ancho-120, 25, 100, 50);
        btnSecion.setBackground(Color.GREEN);
                btnSecion.setForeground(Color.BLACK);

        
        eventos();
        
        
        panelMenu.add(btnSecion);
        panelMenu.add(btnFavoritos);
        panelMenu.add(btnForo);
        panelMenu.add(btnBiblioteca);
        panelMenu.add(btnInicio);
        panelMenu.add(btnLogo);

    }
//Esta funcion es pa que aparesca rojito el boton
    private void seleccionarBoton(JButton boton) {
        seleccionado = boton;
        
        btnInicio.setBackground(Color.GRAY);
        btnBiblioteca.setBackground(Color.GRAY);
        btnFavoritos.setBackground(Color.GRAY);
        btnForo.setBackground(Color.GRAY);
        
        
        btnLogo.setBorderPainted(false);

        if (boton == btnLogo) {

            btnLogo.setBorderPainted(true);
            btnLogo.setBorder(
                    BorderFactory.createLineBorder(
                            Color.decode("#A61B1B"),
                            3
                    )
            );

        } else {
            boton.setForeground(Color.decode("#DCA842"));
            boton.setBackground(Color.decode("#A61B1B"));

        }

    }

    private void catalogo() {
        inicio = new PanelInicio();
        inicio.setBackground(Color.decode("#F4F4F6"));
        inicio.setBounds(0, 0, ancho, 575);
        seleccionarBoton(btnInicio);
        panelContenido.add(inicio);
    }

    private void label() {

        marcaregistrada = new JLabel("® 2026 LitConect, OVS.Inc.", JLabel.RIGHT);
        marcaregistrada.setBounds(0, 0, ancho - 50, 50);
        Font marca = new Font("Segoe UI", Font.BOLD, 20);
        marcaregistrada.setFont(marca);
        marcaregistrada.setForeground(Color.WHITE);
        panelPie.add(marcaregistrada);
    }

    private void eventos() {
        manita(btnLogo);
        btnLogo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                if (seleccionado != btnLogo) {
                    btnLogo.setBorderPainted(true);
                    btnLogo.setBorder(
                            BorderFactory.createLineBorder(
                                    Color.LIGHT_GRAY,
                                    2
                            )
                    );
                }

            }

            @Override
            public void mouseExited(MouseEvent e) {

                if (seleccionado != btnLogo) {
                    btnLogo.setBorderPainted(false);
                }

            }

        });
        
        manita(btnInicio);
        btnInicio.addActionListener(e -> {

            seleccionarBoton(btnInicio);

            panelContenido.removeAll();

            inicio = new PanelInicio();
            inicio.setBackground(Color.decode("#F4F4F6"));
            inicio.setBounds(0, 0, ancho, 575);

            panelContenido.add(inicio);

            panelContenido.revalidate();
            panelContenido.repaint();

        });
        Listenermouse(btnInicio);
        
        manita(btnBiblioteca);
        Listenermouse(btnBiblioteca);
        
        manita(btnFavoritos);
        Listenermouse(btnFavoritos);
        
        manita(btnForo);
        Listenermouse(btnForo);
        
        manita(btnSecion);
        btnSecion.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSecion.setBackground(Color.decode("#88E788"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
               btnSecion.setBackground(Color.GREEN);
            }
        });
    }
//Para seleccionar el color del boton al pasar el mouse 
    private void Listenermouse(JButton boton) {
        boton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setForeground(Color.BLACK);
                boton.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (seleccionado != boton) {

                    boton.setBackground(Color.GRAY);
                } else {
                    boton.setForeground(Color.decode("#DCA842"));
                    boton.setBackground(Color.decode("#A61B1B"));
                }
            }
        });
    }
//esta es para que se vea una manita en el mouse 
    private void manita(JButton boton) {
        boton.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR
                )
        );
    }
}
