package ec.edu.ups.idao;

import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 * @author SUyaguari
 */
public interface IUsuarioDAO {
    
    public List<Usuario> obtenerClientes();
    public void create(Usuario usuario);
    public Usuario read(String cedula);
    public void update(Usuario usuario);
    public void delite(Usuario usuario);
    public boolean inicioSesion(String correo, String contraseña);
}
