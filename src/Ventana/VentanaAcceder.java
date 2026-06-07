package Ventana;

import DAO.UsuarioDAO;
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

public class VentanaAcceder extends JDialog {


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
        
        JButton btnAcceder = new JButton("Crear cuenta");
        btnAcceder.setBounds(130,250,145,30);
        Imagen(btnAcceder, "Crear");
        manita(btnAcceder);
        Listenermouse(btnAcceder, "Crear");
        btnAcceder.addActionListener(e ->{
            dispose();
            VentanaCrear cambio = new VentanaCrear();
            cambio.setModal(true);
            cambio.setVisible(true);
        });
        

        JButton btnIntentar = new JButton("Acceder");
        btnIntentar.setBounds(170, 300, 60, 30);
        Imagen(btnIntentar, "Acceder");
        manita(btnIntentar);
        Listenermouse(btnIntentar, "Acceder");
        
        btnIntentar.addActionListener(e -> {

            String boleta = txtBoleta.getText();
            String password;
            password = new String(txtContrasena.getPassword());

            UsuarioDAO dao = new UsuarioDAO();
            
            if (!boleta.isEmpty()) {
                if (!password.isEmpty()) {
                    
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
                }
                else{
                    JOptionPane.showMessageDialog(
                        this,
                        "No hay contraseña"
                );
                }
                
                
            }
            else{
                JOptionPane.showMessageDialog(
                        this,
                        "No hay boleta"
                );
            }

        });

        JButton btnSalir = new JButton("Cerrar");
        btnSalir.setBounds(170, 340, 60, 30);
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


        fondo.setLayout(null);
        setBackground(Color.WHITE);

        setContentPane(fondo);

        fondo.add(btnAcceder);
        fondo.add(titulo);
        fondo.add(lblBoleta);
        fondo.add(txtBoleta);
        fondo.add(lblContrasena);
        fondo.add(txtContrasena);
        fondo.add(btnIntentar);
        fondo.add(btnSalir);
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
