# Practica03-MVC-y-DAO
Desarrollo de una aplicación en Java utilizando los patrones diseño de software MVC y DAO.

TÍTULO PRÁCTICA: Desarrollo de una aplicación en Java utilizando los patrones diseño de software MVC y DAO.

OBJETIVOS 
• Utilizar el patrón MVC para el desarrollo de aplicaciones de software

Github es una herramienta actualmente muy utilizada por desarrolladores, es muy útil para el desarrollo colaborativo contribuyendo para mejorar el software de los demás.

En este caso se utiliza la herramienta github para subir el código de esta práctica.
Primer paso es crear el repositorio en la página web de la herramienta: https://github.com 
![alt text](https://github.com/SUyaguari/Practica03-MVC-y-DAO/blob/master/img/CrearRepositorio.PNG)

Una vez creado el repositorio se puede añadir los archivos utilizando el Netbeans o la consola de comandos de Windows o de una forma más directa pero de forma incorrecta que es arrastrando los archivos.
En mi caso se utilizó la consola de comandos para subir los archivos ya que directamente desde el Netbeans no me permitió.
![alt text](https://github.com/SUyaguari/Practica03-MVC-y-DAO/blob/master/img/CMD.PNG)
![alt text](https://github.com/SUyaguari/Practica03-MVC-y-DAO/blob/master/img/RepositorioFi.PNG)
Imagen adjunta de la aplicación confirmando visualmente el repositorio.
Adjunto el link del repositorio:
https://github.com/SUyaguari/Practica03-MVC-y-DAO


Desarrollar una aplicación en Java para gestionar una agenda telefónica según los requerimientos planteados en las instrucciones de la práctica. 
La aplicación tiene 6 paquetes con 11 clases.
![alt text](https://github.com/SUyaguari/Practica03-MVC-y-DAO/blob/master/img/Paquetes.PNG)
Paquete ec.edu.ups.controlador
Este paquete contiene las clases controlador que sirve para manipular los datos y lograr el resultado deseado.
Estas clases manipulan las clases modelo y también las clases vista.

Controlador Teléfono
Esta clase controla el ingreso de datos además ayuda a guardar en memoria enviando los datos que fueron sobre escribidos del CRUD o DAO, pertenece al diseño MVC.

Código:
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.vista.VistaTelefono;
import java.util.List;

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

Controlador Usuario
Esta clase controla el ingreso de datos además ayuda a guardar en memoria enviando los datos que fueron sobre escribidos del CRUD o DAO, pertenece al diseño MVC.

Código:
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

Paquete ec.edu.ups.dao
Este paquete contiene las clases DAO es decir las clases que sobre escriben a las clases abstractas que se utilizan para guardar los datos en memoria ya por el momento no se maneja ningún lenguaje de programación para administrar datos.

Teléfono DAO
En esta clase se sobre escribe la clase ITelefonoDAO que contiene el CRUD para almacenar los datos de teléfono.

Código: 
package ec.edu.ups.dao;

import ec.edu.ups.idao.ITelefonoDAO;
import ec.edu.ups.modelo.Telefono;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

Usuario DAO
En esta clase se sobre escribe la clase IUsuarioDAO que contiene el CRUD para almacenar los datos del usuario, además esta contiene un método diferente al CRUD que sirve para poder comparar el inicio de sesión.

Codigo:
package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

Paquete ec.edu.ups.idao
Este paquete contiene las clases Interface en los cuales están declarados los métodos CRUD de forma abstracta, la cual es la clase padre de las clases del paquete .dao guardando la información en una Lista.

ITelefono DAO
Esta clase contiene los métodos CRUD para los datos del teléfono.

Código:
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Telefono;
import java.util.List;

public interface ITelefonoDAO {
    
    public List<Telefono> obtenerTelefonos();
    public void create(Telefono telefono);
    public Telefono read(int codigo);
    public void update(Telefono telefono);
    public void delite(Telefono telefono);
    
}

IUsuario DAO
Esta clase contiene los métodos CRUD para los datos del usuario, además contiene un método adicional para controlar el ingreso o el login.

Código:
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Usuario;
import java.util.List;

public interface IUsuarioDAO {
    
    public List<Usuario> obtenerClientes();
    public void create(Usuario usuario);
    public Usuario read(String cedula);
    public void update(Usuario usuario);
    public void delite(Usuario usuario);
    public boolean inicioSesion(String correo, String contraseña);
}

Paquete ec.edu.ups.modelo
Este paquete contiene los getters, setters, atributos que son los datos importantes que necesita almacenar el programa.

Clase Teléfono
Esta clase contiene la información que debe ser recopilada por la aplicación.

Código:
package ec.edu.ups.modelo;
public class Telefono {
    
    private int codigo;
    private String numero;
    private String tipo;
    private String operadora;

    public Telefono() {
    }

    public Telefono(int codigo, String numero, String tipo, String operadora) {
        this.codigo = codigo;
        this.numero = numero;
        this.tipo = tipo;
        this.operadora = operadora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefono other = (Telefono) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefono{" + "codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora + '}';
    }    
}

Clase Usuario
Esta clase contiene la información que debe ser recopilada por la aplicación, contiene un método de agregación para la relación con la clase teléfono.

Código:
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Usuario {
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private List<Telefono> agregarTelefonos;

    public Usuario() {
        agregarTelefonos = new ArrayList<>();
    }

    public Usuario(String cedula, String nombre, String apellido, String correo, String contraseña) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        agregarTelefonos = new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public void agregarTelefonos(Telefono telefono){
        agregarTelefonos.add(telefono);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.correo);
        hash = 47 * hash + Objects.hashCode(this.contraseña);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contraseña, other.contraseña)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contraseña=" + contraseña + ",\nagregarTelefonos= " + agregarTelefonos + '}';
    }    
}

Paquete ec.edu.ups.test
Contiene a la clase principal, contiene el método principal o main,  une todas las clases.

Código:

package ec.edu.ups.test;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;
import java.util.Scanner;

public class Prueba {
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        VistaUsuario vistau = new VistaUsuario();
        VistaTelefono vistat = new VistaTelefono();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        TelefonoDAO telefonoDAO = new TelefonoDAO();
        
        ControladorUsuario controladorUsuario = new ControladorUsuario(vistau, vistat, usuarioDAO, telefonoDAO);
        ControladorTelefono controladorTelefono = new ControladorTelefono(vistat, telefonoDAO);
        
        int opcion;
        do{
            System.out.println("¨¨¨¨¨¨¨¨¨¨MENU¨¨¨¨¨¨¨");
            System.out.println("[1] Registrarse");
            System.out.println("[2] Iniciar Sesion");
            System.out.println("[3] Consulta de usuarios");
            System.out.println("[4] Salir");
            System.out.print("Ingrese una opcion: ");
            opcion=leer.nextInt();
            
            switch(opcion){
                case 1: 
                    System.out.println("¨¨¨¨¨Registro Usuario¨¨¨¨");
                    controladorUsuario.registrarUsuario();
                    System.out.println("Registrado correctamente");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("¨¨¨¨Inicio de Sesion¨¨¨¨");
                    boolean centinela = controladorUsuario.inicioSesion();
                    if(centinela == true){
                        System.out.println("\tIniciado sesion correctamente");
                        System.out.println("");
                        int opcion2;
                        do {                            
                            System.out.println("¨¨¨¨¨¨Menu Telefonos¨¨¨¨¨¨");
                            System.out.println("[1] Registrar numero de telefono");
                            System.out.println("[2] Modificar numero de telefono");
                            System.out.println("[3] Eliminar numero de telefono");
                            System.out.println("[4] Buscar numero de telefono");
                            System.out.println("[5] Consultar numeros de telefonos");
                            System.out.println("[6] Agregar numeros de telefonos");
                            System.out.println("[7] Listar Telefonos");
                            System.out.println("[8] Cerrar Sesion");
                            System.out.print("ingrese una opcion: ");
                            opcion2 = leer.nextInt();
                            switch(opcion2){
                                case 1:
                                    controladorTelefono.registrarTelefono();
                                    break;
                                case 2:
                                    controladorTelefono.actualizarTelefono();
                                    break;
                                case 3:
                                    controladorTelefono.borrarTelefono();
                                    break;
                                case 4:
                                    controladorTelefono.buscarTelefono();
                                    break;
                                case 5:
                                    controladorTelefono.verTelefonos();
                                    break;
                                case 6:
                                    controladorUsuario.agregarTelefonos();
                                    break;
                                case 7:
                                    controladorUsuario.listar();
                                    break;
                                case 8:
                                    System.out.println("Cerrando sesion....");
                                    break;
                                default:
                                    System.out.println("Ingrese una opcon valida");
                                    break;
                            }
                        } while (opcion2!=8);
                        System.out.println("Sesion");
                    }else{
                        System.out.println("\tusuario no registrado");
                    }
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("¨¨¨¨¨Consulta de Usuarios¨¨¨¨");
                    controladorUsuario.verUsuarios();
                    System.out.println("");
                case 4:
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    System.out.println("");
                    break;
            }
        }while(opcion!=4);
        
    }
}
Paquete ec.edu.ups.vista
Este paquete contiene a las clases que muestran e ingresa los datos.

Vista Teléfono
Contiene el ingreso de datos como métodos para ser utilizados por el controlador.

Código: 
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Telefono;
import java.util.List;
import java.util.Scanner;

public class VistaTelefono {
    
    private Scanner leer;

    public VistaTelefono() {
        leer = new Scanner(System.in);
    }
    
    public Telefono registrar(){
        Scanner leer = new Scanner(System.in);
        int codigo;
        String numero;
        String tipo;
        String operadora;
        System.out.print("Ingrese el codigo del telefono: ");
        codigo = leer.nextInt();
        System.out.print("Ingrese el numero del telefono: ");
        numero = leer.next();
        System.out.print("Ingrese el tipo del telefono: ");
        tipo = leer.next();
        System.out.print("Ingrese la operadora del telefono: ");
        operadora = leer.next();
        return new Telefono(codigo, numero, tipo, operadora);
    }
    
    public Telefono modificar(){
        Scanner leer = new Scanner(System.in);
        int codigo;
        String numero;
        String tipo;
        String operadora;
        System.out.print("Ingrese el codigo del telefono: ");
        codigo = leer.nextInt();
        System.out.print("Ingrese el numero del telefono: ");
        numero = leer.next();
        System.out.print("Ingrese el tipo del telefono: ");
        tipo = leer.next();
        System.out.print("Ingrese la operadora del telefono: ");
        operadora = leer.next();
        return new Telefono(codigo, numero, tipo, operadora);
    }
    
    public Telefono eliminarTelefono(){
        Scanner leer = new Scanner(System.in);
        int codigo;
        System.out.print("Ingrese el codigo del telefono: ");
        codigo = leer.nextInt();
        return new Telefono(codigo, null, null, null);
    }
    
    public int buscarTelefono(){
        Scanner leer = new Scanner(System.in);
        int codigo;
        System.out.print("Ingrese el codigo del telefono: ");
        codigo = leer.nextInt();
        return codigo;
    }
    
    public void mostrarTelefonos(List<Telefono> listaTelefono){
        for (Telefono telefono : listaTelefono) {
            System.out.println("Datos: \n"+telefono);
        }
    }
    
    public void mostrarTelefono(Telefono telefono){
        System.out.println("Datos del telefono: "+telefono);
    }
}
Vista Usuario
Contiene el ingreso de datos como métodos para ser utilizados por el controlador.

Código: 
package ec.edu.ups.vista;

import ec.edu.ups.modelo.Usuario;
import java.util.List;
import java.util.Scanner;

public class VistaUsuario {
    
    private Scanner leer;
    HashMap<String, String> u = new HashMap<>();

    public VistaUsuario() {
        leer = new Scanner(System.in);
    }
    
    public Usuario crearUsuario(){
        Scanner leer = new Scanner(System.in);
        String cedula;
        String nombre;
        String apellido;
        String correo;
        String contraseña;
        System.out.print("Ingrese el numero de cedula de la persona: ");
        cedula = leer.next();
        System.out.print("Ingrese el nombre de la persona: ");
        nombre = leer.next();
        System.out.print("Ingrese el apellido de la persona: ");
        apellido = leer.next();
        System.out.print("Ingrese el correo de la persona: ");
        correo = leer.next();
        System.out.print("Ingrese la contraseña de la persona: ");
        contraseña = leer.next();
        if (!u.containsKey(correo)) {
            u.put(correo, contraseña);
            return new Usuario(cedula, nombre, apellido, correo, contraseña);
        }else{
            System.out.println("Correo ocupado");
            return null;
        }
    }
     
    public String ingresoCedula(){
        Scanner leer = new Scanner(System.in);
        String cedula;
        System.out.print("Ingrese el correo");
        cedula = leer.next();        
        return cedula;
    }
    
    public Usuario modificarUsuario(){
        String cedula;
        String nombre;
        String apellido;
        String correo;
        String contraseña;
        System.out.print("Ingrese el numero de cedula de la persona: ");
        cedula = leer.next();
        System.out.print("Ingrese el nombre de la persona: ");
        nombre = leer.next();
        System.out.print("Ingrese el apellido de la persona: ");
        apellido = leer.next();
        System.out.print("Ingrese el correo de la persona: ");
        correo = leer.next();
        System.out.print("Ingrese la contraseña de la persona: ");
        contraseña = leer.next();
        return new Usuario(cedula, nombre, apellido, correo, contraseña);
    }
    
    public Usuario eliminarUsuario(){
        Scanner leer = new Scanner(System.in);
        String cedula;
        System.out.print("Ingrese la cedula del cliente que desea eliminar");
        cedula = leer.next();
        return new Usuario(cedula, null, null, null, null);
    }
    
    public void verUsuario(Usuario usuario){
        System.out.println("Datos del usuario: "+usuario);
    }
    
    public void verUsuarios(List<Usuario> listaUsuario){
        for (Usuario usuario : listaUsuario) {
            System.out.println("Datos del usuario: "+ usuario);
        }
    }
    
    public String inicioSesionCorreo(){
        Scanner leer = new Scanner(System.in);
        String correo;
        System.out.print("Ingrese el correo: ");
        correo= leer.next();
        return correo;
    }
    
    public String inicioSesionContraseña(){
        Scanner leer = new Scanner(System.in);
        String contraseña;
        System.out.print("Ingrese la contraseña: ");
        contraseña= leer.next();
        return contraseña;
    }
    public String listaTelefono(){
        Scanner leer = new Scanner(System.in);
        int opcion;
        String cedula;
        String correo;
        System.out.println("[1] buscar por cedula");
        System.out.println("[2] buscar por correo");
        opcion= leer.nextInt();
        if(opcion==1){
            System.out.print("Ingrese la cedula: ");
            cedula = leer.next();
            if(u.containsKey(cedula)){
                return cedula;
           }
        }
        if(opcion==2){
            System.out.print("Ingrese el correo: ");
            correo = leer.next();
            if(u.containsKey(correo)){
                return u.get(correo);
            }
        }
        return null;
    }
}

Realizar varios commits en la herramienta Github que demuestren el desarrollo de la aplicación desde principio a fin. 
Evidencia del commits:
![alt text](https://github.com/SUyaguari/Practica03-MVC-y-DAO/blob/master/img/commit1.PNG)
![alt text](https://github.com/SUyaguari/Practica03-MVC-y-DAO/blob/master/img/commit2.PNG)

RESULTADO(S) OBTENIDO(S): 
• 	Diseña e implementa aplicaciones usando arquitectura MVC 
CONCLUSIONES:  
• 	Los estudiantes podrán implementar sistemas de Java basado en los patrones MVC, DAO y el uso de colecciones y diccionarios. 
RECOMENDACIONES:  
• 	Aplicar  buenas prácticas de programación

Estudiante : Sebastián Roberto Uyaguari Ramón 
Firma:
![alt text](https://github.com/SUyaguari/Practica03-MVC-y-DAO/blob/master/img/Firma.PNG)
