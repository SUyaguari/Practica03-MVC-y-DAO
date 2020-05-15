package ec.edu.ups.test;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.vista.VistaTelefono;
import ec.edu.ups.vista.VistaUsuario;
import java.util.Scanner;

/**
 * @author SUyaguari
 */
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
                            System.out.println("[7] Listar telefonos");
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
