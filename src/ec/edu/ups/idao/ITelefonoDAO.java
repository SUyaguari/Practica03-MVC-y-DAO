package ec.edu.ups.idao;

import ec.edu.ups.modelo.Telefono;
import java.util.List;

/**
 *
 * @author SUyaguari
 */
public interface ITelefonoDAO {
    
    public List<Telefono> obtenerTelefonos();
    public void create();
    public void read();
    public void update();
    public void delite();
    
}
