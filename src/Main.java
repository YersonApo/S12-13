import controlador.ControladorUsuario;
import modelo.UsuarioDAO;
import vista.VentanaLogin;
import vista.VentanaRegistro;

public class Main {
    public static void main(String[] args) {
        VentanaLogin login = new VentanaLogin();
        VentanaRegistro registro = new VentanaRegistro();
        UsuarioDAO dao = new UsuarioDAO();
        ControladorUsuario controlador = new ControladorUsuario(login, registro, dao);
        controlador.iniciar();
    }
}
