package ec.edu.ups.vista;

import ec.edu.ups.modelo.Usuario;
import java.util.Scanner;

/**
 * @author SUyaguari
 */
public class VistaUsuario {
    
    private Scanner leer;

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
        return new Usuario(cedula, nombre, apellido, correo, contraseña);
    }
    
    public String ingresoCorreo(){
        Scanner leer = new Scanner(System.in);
        String correo;
        System.out.println("Ingrese el correo");
        correo = leer.next();
        return correo;
    }
    public String ingresoContraseña(){
        Scanner leer = new Scanner(System.in);
        String contraseña;
        System.out.println("Ingrese el correo");
        contraseña = leer.next();
        return contraseña;
    }
    
    public String ingresoCedula(){
        Scanner leer = new Scanner(System.in);
        String cedula;
        System.out.println("Ingrese el correo");
        cedula = leer.next();        
        return cedula;
    }
}
