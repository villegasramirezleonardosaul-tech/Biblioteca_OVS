package Ventana;

import DAO.UsuarioDAO;
import ClasesModelo.Usuario;
import static Memoria.Cache.usuario;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaCrear extends JDialog {

    public VentanaCrear() {
        int tamaño = 400;
        setBounds(500, 210, tamaño, tamaño);
        setLayout(null);

        JLabel titulo = new JLabel("Crear Cuenta");
        titulo.setBounds(120, 10, 300, 25);
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        titulo.setForeground(Color.BLACK);

        JLabel lblBoleta = new JLabel("Boleta:");
        lblBoleta.setBounds(40, 50, 80, 25);
        lblBoleta.setFont(new Font("Arial", Font.BOLD, 15));
        lblBoleta.setForeground(Color.BLACK);

        JTextField txtBoleta = new JTextField();
        txtBoleta.setBounds(40, 70, 140, 25);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(40, 120, 80, 25);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 15));
        lblNombre.setForeground(Color.BLACK);

        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(40, 140, 140, 25);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(40, 190, 120, 25);
        lblContrasena.setFont(new Font("Arial", Font.BOLD, 15));
        lblContrasena.setForeground(Color.BLACK);

        JPasswordField txtContrasena = new JPasswordField();
        txtContrasena.setBounds(40, 210, 140, 25);

        JButton btnAcceder = new JButton("Ya tienes cuenta");
        btnAcceder.setBounds(130, 250, 150, 30);
        Imagen(btnAcceder, "Tener");
        manita(btnAcceder);
        Listenermouse(btnAcceder, "tener");
        btnAcceder.addActionListener(e -> {
            dispose();
            VentanaAcceder cambio = new VentanaAcceder();
            cambio.setModal(true);
            cambio.setVisible(true);
        });

        JButton btnCrear = new JButton();
        btnCrear.setBounds(170, 300, 60, 30);
        Imagen(btnCrear, "btnCrear");
        manita(btnCrear);
        Listenermouse(btnCrear, "btnCrear");

        btnCrear.addActionListener(e -> {
            String boleta = txtBoleta.getText();
            int idTipo = 2;
            String nombre = txtNombre.getText();
            String contraseña;
            contraseña = new String(txtContrasena.getPassword());

            UsuarioDAO dao = new UsuarioDAO();
            if (!boleta.isEmpty()) {
                if (dao.comprobarUsuario(boleta)) {
                    if (!nombre.isEmpty()) {
                        if (!contraseña.isEmpty()) {
                            usuario = dao.insertarUsuario(new Usuario(boleta, idTipo, nombre, contraseña));

                            if (usuario != null) {
                                JOptionPane.showMessageDialog(
                                        this,
                                        "Bienvenido: "
                                        + usuario.getNomUser()
                                );

                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(
                                        this,
                                        "Algo fallo"
                                );
                            }
                        } else {
                            JOptionPane.showMessageDialog(
                                    this,
                                    "No hay contraseña"
                            );
                        }
                    } else {
                        JOptionPane.showMessageDialog(
                                this,
                                "No hay nombre"
                        );
                    }
                } else {
                    JOptionPane.showMessageDialog(
                            this,
                            "Esa boleta ya existe"
                    );
                }
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "No hay boleta"
                );
            }

        });

        JButton btnSalir = new JButton("Cerrar");
        btnSalir.setBounds(175, 340, 60, 30);
        Imagen(btnSalir, "Cerrar");
        manita(btnSalir);
        Listenermouse(btnSalir, "Cerrar");

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

        
        JLabel fondo = new JLabel();
        setBackground(Color.WHITE);

        fondo.setLayout(null);

        setContentPane(fondo);

        fondo.add(btnSalir);
        fondo.add(btnCrear);
        fondo.add(btnAcceder);
        fondo.add(titulo);
        fondo.add(lblBoleta);
        fondo.add(txtBoleta);
        fondo.add(lblNombre);
        fondo.add(txtNombre);
        fondo.add(lblContrasena);
        fondo.add(txtContrasena);

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

    private void manita(JButton boton) {
        boton.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.HAND_CURSOR
                )
        );
    }

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

                ImageIcon iconoOriginal = new ImageIcon(
                        getClass().getResource("/Botones/" + txt + ".png")
                );
                //Sirve pa escalar imagenes 
                Image imagenEscalada = iconoOriginal.getImage()
                        .getScaledInstance(160, 80, Image.SCALE_SMOOTH);

                ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

                boton.setIcon(iconoEscalado);

            }
        });
    }
}
