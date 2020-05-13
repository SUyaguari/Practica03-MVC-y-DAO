package ec.edu.ups.dao;

import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author SUyaguari
 */
public class TelefonoDAO implements ITelefonoDAO{

    List<Telefono> listaTelefonos;

    public TelefonoDAO() {
        listaTelefonos = new ArrayList<>();
    }

    public TelefonoDAO(List<Telefono> listaTelefonos) {
        this.listaTelefonos = listaTelefonos;
    }
    
    @Override
    public List<Telefono> obtenerTelefonos() {
        return listaTelefonos;
    }

    @Override
    public void create(Telefono telefono) {
        listaTelefonos.add(telefono);
    }

    @Override
    public Telefono read(int codigo) {
        for (Telefono telefono : listaTelefonos) {
            if(telefono.getCodigo() == codigo){
                return telefono;
            }
        }
        return null;
    }

    @Override
    public void update(Telefono telefono) {
        for (int i = 0; i < listaTelefonos.size(); i++) {
            Telefono t = listaTelefonos.get(i);
            if(t.getCodigo()== telefono.getCodigo()){
                listaTelefonos.set(i, telefono);
            }
        }
    }

    @Override
    public void delite(Telefono telefono) {
        Iterator<Telefono> it = listaTelefonos.iterator();
        while (it.hasNext()) {
            Telefono t = it.next();
            if (t.getCodigo() == telefono.getCodigo()){
                it.remove();
                break;
            }
        }
    }
    
}
