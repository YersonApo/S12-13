package modelo;

import java.sql.*;

public class UsuarioDAO {

    public boolean registrar(Usuario usuario) {
        String sql = "INSERT INTO users (id, first_name, last_name, email, password_hash, salt) VALUES (?, ?, ?, ?, ?, '')";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getId());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getContrasena());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public Usuario buscarPorCorreo(String correo) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getString("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("password_hash")
                );
            }
        } catch (SQLException e) {
        }
        return null;
    }
}
