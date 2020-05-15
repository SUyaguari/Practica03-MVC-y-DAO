package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;
import java.util.List;

/**
 * @author SUyaguari
 */
public class ControladorUsuario {

    private VistaUsuario vistaUsuario;
    private VistaTelefono vistaTelefono;
    
    private Usuario usuario;
    private Telefono telefono;
    
    private IUsuarioDAO usuarioDAO;
    private ITelefonoDAO telefonoDAO;

    public ControladorUsuario(VistaUsuario vistaUsuario, VistaTelefono vistaTelefono, UsuarioDAO usuarioDAO, TelefonoDAO telefonoDAO) {
        this.vistaUsuario = vistaUsuario;
        this.usuarioDAO = usuarioDAO;
        
        this.vistaTelefono = vistaTelefono;
        this.telefonoDAO = telefonoDAO;
    }
    
    public void registrarUsuario(){
        usuario = vistaUsuario.crearUsuario();
        usuarioDAO.create(usuario);
    }
    
    public void modificaUsuario(){
        usuario = vistaUsuario.modificarUsuario();
        usuarioDAO.update(usuario);
    }
    public void buscarUsuarios(){
        String cedula = vistaUsuario.ingresoCedula();
        usuarioDAO.read(cedula);
        vistaUsuario.verUsuario(usuario);
    }
    
    public void eliminarUsuario(){
        usuario = vistaUsuario.eliminarUsuario();
        usuarioDAO.delite(usuario);
    }
    
    public void verUsuarios(){
        List<Usuario> usuarios;
        usuarios = usuarioDAO.obtenerClientes();
        vistaUsuario.verUsuarios(usuarios);
    }
    
    public void agregarTelefonos(){
        int codigo = vistaTelefono.buscarTelefono();
        telefono = telefonoDAO.read(codigo);
        usuario.agregarTelefonos(telefono);
        usuarioDAO.update(usuario);
    }
    
    public boolean inicioSesion(){
        String correo = vistaUsuario.inicioSesionCorreo();
        String contraseña = vistaUsuario.inicioSesionContraseña();
        boolean centinela = usuarioDAO.inicioSesion(correo, contraseña);
        return centinela;
    }
    
    public void listar(){
        String u = vistaUsuario.listaTelefono();
        usuarioDAO.read(u);
        vistaTelefono.mostrarTelefono(telefono);
    }
}
