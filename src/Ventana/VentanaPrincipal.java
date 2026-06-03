package Ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Panel.*;
import static Ventana.VentanaAcceder.usuario;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    private static int ancho;
    private static int largo;

    public VentanaPrincipal() {
        configurarVentana();
        paneles();
        seleccionarBoton(btnInicio, "Inicio");
    }

    //Esta es para crear la ventana 
    private void configurarVentana() {
        usuario = null;
        setTitle("LitConect");
        //Tamaño del monitor
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        ancho = pantalla.width;
        largo = pantalla.height;
        if (false) {
            ancho = ancho - 500;
            largo = largo - 300;
        }
        System.out.println(ancho);
        System.out.println(largo);
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

    public void Imagen(JButton boton, String txt) {
        ImageIcon iconoOriginal = new ImageIcon(
                getClass().getResource("/Botones/" + txt + ".png")
        );
        //Sirve pa escalar imagenes 
        Image imagenEscalada = iconoOriginal.getImage()
                .getScaledInstance(160, 80, Image.SCALE_SMOOTH);

        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        boton.setIcon(iconoEscalado);
        boton.setBorder(null);
    }

    private void botones() {
        btnLogo = new JButton();
        btnLogo.setBounds(10, 10, 80, 80);

        btnInicio = new JButton();
        btnInicio.setBounds(100, 30, 100, 40);

        btnBiblioteca = new JButton();
        btnBiblioteca.setBounds(210, 30, 100, 40);

        btnFavoritos = new JButton();
        btnFavoritos.setBounds(320, 30, 100, 40);

        btnForo = new JButton();
        btnForo.setBounds(430, 30, 100, 40);

        btnCuenta = new JButton();
        btnCuenta.setBounds(ancho - 120, 25, 100, 50);
        btnCuenta.setVisible(false);

        btnSecion = new JButton();
        btnSecion.setBounds(ancho - 120, 25, 100, 50);
        Imagen(btnSecion, "Login");
        eventos();

        panelMenu.add(btnSecion);
        panelMenu.add(btnCuenta);
        panelMenu.add(btnFavoritos);
        panelMenu.add(btnForo);
        panelMenu.add(btnBiblioteca);
        panelMenu.add(btnInicio);
        panelMenu.add(btnLogo);

    }
//Esta funcion es pa que aparesca rojito el boton

    private void seleccionarBoton(JButton boton, String txt) {
        
        Imagen(btnBiblioteca, "Biblioteca");
        Imagen(btnCuenta, "Cuenta");
        Imagen(btnFavoritos, "Favoritos");
        Imagen(btnForo, "Foros");
        Imagen(btnInicio, "Inicio");
        Imagen(btnLogo, "OVS");
        
        seleccionado = boton;
        
        txt +="_S";

        Imagen(boton, txt);

    }

    private void catalogo() {
        PanelInicio inicio = new PanelInicio();
        inicio.setBackground(Color.decode("#F4F4F6"));
        inicio.setBounds(0, 0, ancho, 575);
        seleccionarBoton(btnInicio, "Inicio");

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
        Listenermouse(btnLogo, "OVS");
        btnLogo.addActionListener(e -> {
            seleccionarBoton(btnLogo, "OVS");

            panelContenido.removeAll();

            PanelOVS ovs = new PanelOVS();
            ovs.setBackground(Color.decode("#F4F4F6"));
            ovs.setBounds(0, 0, ancho, 575);

            panelContenido.add(ovs);

            panelContenido.revalidate();
            panelContenido.repaint();
        });

        manita(btnInicio);
        Listenermouse(btnInicio, "Inicio");
        btnInicio.addActionListener(e -> {

            seleccionarBoton(btnInicio, "Inicio");

            panelContenido.removeAll();

            PanelInicio inicio = new PanelInicio();
            inicio.setBackground(Color.decode("#F4F4F6"));
            inicio.setBounds(0, 0, ancho, 575);

            panelContenido.add(inicio);

            panelContenido.revalidate();
            panelContenido.repaint();

        });

        manita(btnBiblioteca);
        Listenermouse(btnBiblioteca, "Biblioteca");
        btnBiblioteca.addActionListener(e -> {
            seleccionarBoton(btnBiblioteca, "Biblioteca");

            panelContenido.removeAll();

            PanelBiblioteca biblioteca = new PanelBiblioteca();
            biblioteca.setBackground(Color.decode("#F4F4F6"));
            biblioteca.setBounds(0, 0, ancho, 575);

            panelContenido.add(biblioteca);

            panelContenido.revalidate();
            panelContenido.repaint();
        });


        manita(btnFavoritos);
        Listenermouse(btnFavoritos, "Favoritos");

        manita(btnForo);
        Listenermouse(btnForo, "Foros");

        manita(btnCuenta);
        Listenermouse(btnCuenta, "Cuenta");

        manita(btnSecion);
        Listenermouse(btnSecion, "Login");
        btnSecion.addActionListener(e -> {

            VentanaAcceder acceder = new VentanaAcceder();
            acceder.setModal(true);
            acceder.setVisible(true);
            if (usuario != null) {
                btnSecion.setVisible(false);
                btnCuenta.setVisible(true);
            }
        });

    }
//Para seleccionar el color del boton al pasar el mouse 

    private void Listenermouse(JButton boton, String txt) {
        boton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon iconoOriginal = new ImageIcon(
                        getClass().getResource("/Botones/" + txt + "_B.png")
                );
                //Sirve pa escalar imagenes 
                Image imagenEscalada = iconoOriginal.getImage()
                        .getScaledInstance(160, 80, Image.SCALE_SMOOTH);

                ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

                boton.setIcon(iconoEscalado);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (seleccionado != boton) {

                    ImageIcon iconoOriginal = new ImageIcon(
                            getClass().getResource("/Botones/" + txt + ".png")
                    );
                    //Sirve pa escalar imagenes 
                    Image imagenEscalada = iconoOriginal.getImage()
                            .getScaledInstance(160, 80, Image.SCALE_SMOOTH);

                    ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

                    boton.setIcon(iconoEscalado);
                } else {
                    ImageIcon iconoOriginal = new ImageIcon(
                            getClass().getResource("/Botones/" + txt + "_S.png")
                    );
                    //Sirve pa escalar imagenes 
                    Image imagenEscalada = iconoOriginal.getImage()
                            .getScaledInstance(160, 80, Image.SCALE_SMOOTH);

                    ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

                    boton.setIcon(iconoEscalado);
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
