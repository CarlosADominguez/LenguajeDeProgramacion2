import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomaticoMain {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Administrador administrador = new Administrador();
        Usuario usuario;

        while (true) {
            try {
                System.out.println("\n==== Cajero Automático ====");
                System.out.println("Ingrese su nombre:");
                String nombre = leer.nextLine();
                System.out.println("Ingrese su NIP de 4 dígitos:");
                int nip = Integer.parseInt(leer.nextLine());

                if (nombre.equals("admin") && nip == 3243) {
                    administrador.mostrarMenuAdmin();
                } else if (String.valueOf(nip).length() == 4) {
                    usuario = new Usuario(nombre, nip);
                    Cajero cajero = new Cajero(usuario);
                    cajero.mostrarMenuCajero();
                } else {
                    System.out.println("El nip no es valido");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("El nombre o NIP son invalidos");
            }
        }
    }
}
