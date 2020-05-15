package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author SUyaguari
 */
public class UsuarioDAO implements IUsuarioDAO{

    private List<Usuario> listaUsuario;

    public UsuarioDAO() {
        listaUsuario = new ArrayList<>();
    }

    public UsuarioDAO(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
    @Override
    public List<Usuario> obtenerClientes() {
        return listaUsuario;
    }

    @Override
    public void create(Usuario usuario) {
        listaUsuario.add(usuario);
    }

    @Override
    public Usuario read(String cedula) {
        for (Usuario usuario : listaUsuario) {
            if(usuario.getCedula().equals(cedula)){
               return usuario;
            }
        }
        return null;
    }

    @Override
    public void update(Usuario usuario) {
           for(int i =0; i< listaUsuario.size(); i++){
            Usuario u = listaUsuario.get(i);
            if(u.getCedula().equals(usuario.getCedula())){
                listaUsuario.set(i, usuario);
                break;
            }
        }
    }

    @Override
    public void delite(Usuario usuario) {
        Iterator<Usuario> it = listaUsuario.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            if (u.getCedula().equals(usuario.getCedula())){
                it.remove();
                break;
            }
        }
    }
    
    @Override
    public boolean inicioSesion(String correo, String contraseña){
        for (Usuario usuario : listaUsuario) {
            if(usuario.getCorreo().equals(correo) && usuario.getContraseña().equals(contraseña)){
                return true; 
            }
        }
        return false;
    }    
    
}
