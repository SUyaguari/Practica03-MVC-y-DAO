package ec.edu.ups.idao;

import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 * @author SUyaguari
 */
public interface IUsuarioDAO {
    
    public List<Usuario> obtenerClientes();
    public void create();
    public void read();
    public void update();
    public void delite();
    
}
