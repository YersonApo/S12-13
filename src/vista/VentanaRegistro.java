package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistro extends JFrame {
    public JTextField campoId;
    public JTextField campoNombre;
    public JTextField campoApellido;
    public JTextField campoCorreo;
    public JPasswordField campoContrasena;
    public JPasswordField campoRepetir;
    public JButton botonRegistrar;
    public JButton botonVolver;

    public VentanaRegistro() {
        setTitle("Registro de Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));

        add(new JLabel("Identificación:"));
        campoId = new JTextField();
        add(campoId);

        add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        add(campoNombre);

        add(new JLabel("Apellido:"));
        campoApellido = new JTextField();
        add(campoApellido);

        add(new JLabel("Correo:"));
        campoCorreo = new JTextField();
        add(campoCorreo);

        add(new JLabel("Contraseña:"));
        campoContrasena = new JPasswordField();
        add(campoContrasena);

        add(new JLabel("Repetir Contraseña:"));
        campoRepetir = new JPasswordField();
        add(campoRepetir);

        botonRegistrar = new JButton("Registrar");
        botonVolver = new JButton("Volver");
        add(botonRegistrar);
        add(botonVolver);
    }
}
