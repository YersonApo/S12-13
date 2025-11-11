package modelo;

public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;

    public Usuario(String id, String nombre, String apellido, String correo, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCorreo() { return correo; }
    public String getContrasena() { return contrasena; }
}
