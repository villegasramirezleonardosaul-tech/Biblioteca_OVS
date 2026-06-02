package Ventana;

import ClasesModelo.Usuario;
import DAO.UsuarioDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaAcceder extends JDialog {

    public static Usuario usuario;

    public VentanaAcceder() {
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

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(40, 120, 120, 25);
        lblContrasena.setFont(new Font("Arial", Font.BOLD, 15));
        lblContrasena.setForeground(Color.BLACK);

        JPasswordField txtContrasena = new JPasswordField();
        txtContrasena.setBounds(40, 140, 140, 25);

        JButton btnIntentar = new JButton("Acceder");
        btnIntentar.setBounds(140, 310, 100, 30);
        btnIntentar.addActionListener(e -> {

            String boleta = txtBoleta.getText();
            String password;
            password = new String(txtContrasena.getPassword());

            UsuarioDAO dao = new UsuarioDAO();

            usuario
                    = dao.consultarUsuario(
                            boleta,
                            password
                    );

            if (usuario != null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Bienvenido "
                        + usuario.getNomUser()
                );

                dispose();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Boleta o contraseña incorrecta"
                );

            }
        });

        JButton btnSalir = new JButton("Cerrar");
        btnSalir.setBounds(140, 350, 100, 30);

        btnSalir.addActionListener(e -> dispose());
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
                getClass().getResource("/Imagenes/Acceder.jpg")
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
        fondo.add(txtBoleta);
        fondo.add(lblContrasena);
        fondo.add(txtContrasena);
        fondo.add(btnIntentar);
        fondo.add(btnSalir);
    }
}
