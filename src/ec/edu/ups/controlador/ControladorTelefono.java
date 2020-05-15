package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.vista.VistaTelefono;
import java.util.List;

/**
 * @author SUyaguari
 */
public class ControladorTelefono {
    private VistaTelefono vistaTelefono;
    
    private Telefono telefono;
    
    private ITelefonoDAO telefonoDAO;

    public ControladorTelefono(VistaTelefono vistaTelefono, TelefonoDAO telefonoDAO) {
        
        this.vistaTelefono = vistaTelefono;
        this.telefonoDAO = telefonoDAO;
    }
    
    public void registrarTelefono(){
        telefono = vistaTelefono.registrar();
        telefonoDAO.create(telefono);
    }
    
    public void buscarTelefono(){
        int codigo = vistaTelefono.buscarTelefono();
        telefono = telefonoDAO.read(codigo);
        vistaTelefono.mostrarTelefono(telefono);
    }
    
    public void actualizarTelefono(){
        telefono = vistaTelefono.modificar();
        telefonoDAO.update(telefono);
    }
    
    public void borrarTelefono(){
        telefono = vistaTelefono.eliminarTelefono();
        telefonoDAO.delite(telefono);
    }
    
    public void verTelefonos() {
        List<Telefono> telefonos;
        telefonos = telefonoDAO.obtenerTelefonos();
        vistaTelefono.mostrarTelefonos(telefonos);
    }
}
