package ec.edu.ups.idao;

import ec.edu.ups.modelo.Telefono;
import java.util.List;

/**
 *
 * @author SUyaguari
 */
public interface ITelefonoDAO {
    
    public List<Telefono> obtenerTelefonos();
    public void create(Telefono telefono);
    public Telefono read(int codigo);
    public void update(Telefono telefono);
    public void delite(Telefono telefono);
    
}
