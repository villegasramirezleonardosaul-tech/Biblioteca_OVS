package Ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaCrear extends JDialog{
    public VentanaCrear(){
        int tamaño = 400;
        setBounds(500, 210, tamaño, tamaño);
        setLayout(null);

        JLabel titulo = new JLabel("Acceder");
        titulo.setBounds(145, 10, 100, 25);
        titulo.setFont(new Font("Arial", Font.BOLD, 25));

        JLabel lblBoleta = new JLabel("Boleta:");
        lblBoleta.setBounds(40, 50, 80, 25);
        lblBoleta.setFont(new Font("Arial", Font.BOLD, 15));
        lblBoleta.setForeground(Color.BLACK);

        JTextField txtBoleta = new JTextField();
        txtBoleta.setBounds(40, 70, 140, 25);
        
        setUndecorated(true);
        setShape(
                new RoundRectangle2D.Double(
                        0, 0,
                        tamaño,
                        tamaño,
                        20, 20
                )
        );
        
        ImageIcon iconoOriginal = new ImageIcon(
                getClass().getResource("/Imagenes/Crear.jpg")
        );

        Image imagenEscalada = iconoOriginal.getImage()
                .getScaledInstance(tamaño, tamaño, Image.SCALE_SMOOTH);

        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
        JLabel fondo = new JLabel();

        fondo.setIcon(iconoEscalado);

        fondo.setLayout(null);

        setContentPane(fondo);
        
        fondo.add(titulo);
        fondo.add(lblBoleta);
    }
}
