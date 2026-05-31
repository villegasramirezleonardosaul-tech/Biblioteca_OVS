package Ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Panel.*;

public class VentanaPrincipal extends JFrame {
    private JPanel panelMenu;
    private JPanel panelContenido;
    private JPanel panelPie;
    private final Color gris = Color.lightGray;
    private int ancho;
    private int largo;
    
    private PanelInicio inicio;
    
    public VentanaPrincipal() {
        configurarVentana();
        paneles();
        label();
        botones();
        eventos();
    }
    
    private void configurarVentana(){
        setTitle("LitConect"); 
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
         ancho = pantalla.width;
         largo = pantalla.height;
        setSize(ancho, largo);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 
        ImageIcon icono;
        icono = new ImageIcon(getClass().getResource("/Imagenes/logolimpio.png"));
        setIconImage(icono.getImage());
    }
    private void paneles(){
        fijos();
        catalogo();
    }
    private void fijos(){
        panelMenu = new JPanel();
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, ancho, 100);
        panelMenu.setBackground(Color.red);
        panelContenido = new JPanel();
        panelContenido.setLayout(null);
        panelContenido.setBounds(0, 100, ancho, 575);
        panelContenido.setBackground(gris);
        panelPie = new JPanel();
        panelPie.setLayout(null);
        panelPie.setBounds(0, 675, ancho, largo);
        panelPie.setBackground(Color.black);
        add(panelMenu);
        add(panelContenido);
        add(panelPie);
    
    }
    private void catalogo(){
        inicio = new PanelInicio();
        inicio.setBackground(gris);
        inicio.setBounds(0, 0, ancho, 575);
        panelContenido.add(inicio);
    }
    private void label(){}
    private void botones(){}
    private void eventos(){}
}
