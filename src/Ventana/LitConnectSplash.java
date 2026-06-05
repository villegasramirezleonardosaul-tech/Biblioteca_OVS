package Ventana;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class LitConnectSplash extends JWindow {

    int progreso = 0;
    BufferedImage imagen;

    public LitConnectSplash() throws Exception {
        
        imagen = ImageIO.read(
                    getClass().getResource("/Imagenes/Barra.png"));
        setSize(760, 480);
        setLocationRelativeTo(null);
        setVisible(true);

        // aqui se simula la carga
        for (int i = 0; i <= 100; i++) {
            progreso = i;
            repaint();
            Thread.sleep(30);
        }

        Thread.sleep(800);
        dispose();
    }

    @Override
    public void paint(Graphics g) {
        // pongo la imagen
        g.drawImage(imagen, 0, 0, 760, 480, null);

        // Dibujar barra de progreso encima
        int x = 140, y = 410, ancho = 480, alto = 12;

        // esta es la barra
        g.setColor(new Color(0, 50, 80));
        g.fillRect(x, y, ancho, alto);

        // relleno de la barra según el progreso
        g.setColor(new Color(0, 200, 255));
        g.fillRect(x, y, ancho * progreso / 100, alto);

        // este es el porsentaje de carga
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.PLAIN, 12));
        g.drawString(progreso + "%", x + ancho + 8, y + 10);
    }


}