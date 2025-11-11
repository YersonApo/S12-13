package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.VentanaLogin;
import vista.VentanaRegistro;

import javax.swing.*;

public class ControladorUsuario {
    private VentanaLogin login;
    private VentanaRegistro registro;
    private UsuarioDAO dao;

    public ControladorUsuario(VentanaLogin login, VentanaRegistro registro, UsuarioDAO dao) {
        this.login = login;
        this.registro = registro;
        this.dao = dao;

        login.botonRegistrar.addActionListener(e -> {
            registro.setVisible(true);
            login.dispose();
        });

        login.botonIngresar.addActionListener(e -> iniciarSesion());
        registro.botonRegistrar.addActionListener(e -> registrarUsuario());
        registro.botonVolver.addActionListener(e -> {
            registro.dispose();
            new ControladorUsuario(new VentanaLogin(), new VentanaRegistro(), new UsuarioDAO()).iniciar();
        });
    }

    public void iniciar() {
        login.setVisible(true);
    }

    private void iniciarSesion() {
        String correo = login.campoCorreo.getText();
        String contrasena = new String(login.campoContrasena.getPassword());
        Usuario u = dao.buscarPorCorreo(correo);

        if (u != null && u.getContrasena().equals(contrasena)) {
            JOptionPane.showMessageDialog(null, "Bienvenido " + u.getNombre() + " " + u.getApellido());
        } else {
            JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos");
        }
    }

    private void registrarUsuario() {
        String id = registro.campoId.getText();
        String nombre = registro.campoNombre.getText();
        String apellido = registro.campoApellido.getText();
        String correo = registro.campoCorreo.getText();
        String contrasena = new String(registro.campoContrasena.getPassword());
        String repetir = new String(registro.campoRepetir.getPassword());

        if (!id.matches("\\d{6,10}")) {
            JOptionPane.showMessageDialog(null, "La identificación debe tener entre 6 y 10 números.");
            return;
        }

        if (!nombre.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {
            JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios.");
            return;
        }

        if (!apellido.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {
            JOptionPane.showMessageDialog(null, "El apellido solo puede contener letras y espacios.");
            return;
        }

        if (!contrasena.equals(repetir)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
            return;
        }

        if (!contrasena.matches("(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>]).{12,}")) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 12 caracteres, una mayúscula, una minúscula, un número y un carácter especial.");
            return;
        }

        Usuario nuevo = new Usuario(id, nombre, apellido, correo, contrasena);
        if (dao.registrar(nuevo)) {
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
            registro.dispose();
            new ControladorUsuario(new VentanaLogin(), new VentanaRegistro(), new UsuarioDAO()).iniciar();
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar");
        }
    }
}
