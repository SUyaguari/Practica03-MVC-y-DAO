package ec.edu.ups.vista;

import ec.edu.ups.modelo.Telefono;
import java.util.List;
import java.util.Scanner;

/**
 * @author SUyaguari
 */
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
    
    public int eliminarTelefono(){
        Scanner leer = new Scanner(System.in);
        int codigo;
        System.out.print("Ingrese el codigo del telefono: ");
        codigo = leer.nextInt();
        return codigo;
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
}
