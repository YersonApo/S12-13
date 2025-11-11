package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaLogin extends JFrame {
    public JTextField campoCorreo;
    public JPasswordField campoContrasena;
    public JButton botonIngresar;
    public JButton botonRegistrar;

    public VentanaLogin() {
        setTitle("Inicio de Sesión");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Correo:"));
        campoCorreo = new JTextField();
        add(campoCorreo);

        add(new JLabel("Contraseña:"));
        campoContrasena = new JPasswordField();
        add(campoContrasena);

        botonIngresar = new JButton("Ingresar");
        botonRegistrar = new JButton("Registrarse");
        add(botonIngresar);
        add(botonRegistrar);
    }
}
