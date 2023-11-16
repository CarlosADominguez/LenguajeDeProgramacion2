import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cajero implements Serializable {
    private static final String BILLETES_FILE = "billetes.dat";
    private static final String LOGS_FILE = "logs.txt";

    public int billetes100;
    public int billetes200;
    public int billetes500;
    public int billetes1000;
    Usuario usuario;

    public Cajero(Usuario usuario) {
        cargarBilletes();
        this.usuario = usuario;
    }

    private void cargarBilletes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BILLETES_FILE))) {
            Cajero cajero = (Cajero) ois.readObject();
            this.billetes100 = cajero.billetes100;
            this.billetes200 = cajero.billetes200;
            this.billetes500 = cajero.billetes500;
            this.billetes1000 = cajero.billetes1000;
        } catch (IOException | ClassNotFoundException e) {          
            this.billetes100 = 100;
            this.billetes200 = 100;
            this.billetes500 = 20;
            this.billetes1000 = 10;
        }
    }

    public void mostrarMenuCajero() {
        Scanner leer = new Scanner(System.in);

        while (true) {

            try {
                System.out.println("\n==== Menú Cajero ====");
                System.out.println("1. Consultar Saldo");
                System.out.println("2. Retirar Efectivo");
                System.out.println("3. Salir");

                int opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        consultarSaldo();
                        break;
                    case 2:
                        retirarEfectivo();
                        break;
                    case 3:
                        guardarBilletes(); // Guarda las cantidades de billetes antes de salir
                        guardarLog("Salir", usuario.getNombre(), 0, "SI");
                        System.out.println("Gracias por usar el cajero automático. ¡Hasta luego!");
                        System.exit(0);
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void consultarSaldo() {
        System.out.println("Saldo actual: $" + usuario.getSaldo());
        guardarLog("Consultar", usuario.getNombre(), usuario.getSaldo(), "SI");
    }

    private void retirarEfectivo() {
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese la cantidad a retirar (monto mínimo: $100, múltiplos de $100):");
        int cantidad = leer.nextInt();

        if (cantidad < 100 || cantidad % 100 != 0 || cantidad > usuario.getSaldo()) {
            System.out.println("Cantidad no válida. Intente de nuevo.");
            guardarLog("Retirar", usuario.getNombre(), 0, "NO");
            return;
        }

        if (!puedeEntregarEfectivo(cantidad)) {
            System.out.println("No se puede realizar el retiro. Intente con otra cantidad.");
            guardarLog("Retirar", usuario.getNombre(), cantidad, "NO");
            return;
        }

        usuario.setSaldo(usuario.getSaldo() - cantidad);
        actualizarBilletes(cantidad, billetes1000, billetes500, billetes200, billetes100);
        guardarBilletes();
        System.out.println("Retiro exitoso. Nuevo saldo: $" + usuario.getSaldo());
        guardarLog("Retirar", usuario.getNombre(), cantidad, "SI");
    }

    private boolean puedeEntregarEfectivo(int cantidad) {

        int restante = cantidad;

        while (restante > 0) {
            if (restante >= 1000 && billetes1000 > 0) {
                restante -= 1000;
                billetes1000--;
            } else if (restante >= 500 && billetes500 > 0) {
                restante -= 500;
                billetes500--;
            } else if (restante >= 200 && billetes200 > 0) {
                restante -= 200;
                billetes200--;
            } else if (restante >= 100 && billetes100 > 0) {
                restante -= 100;
                billetes100--;
            } else {
                System.out.println("No hay suficientes billetes");
                return false;
            }
        }

        return true;
    }

    private void actualizarBilletes(int cantidad, int billetes1000, int billetes500, int billetes200, int billetes100) {
        int restante = cantidad;

        int billetes1000Entregar = Math.min(restante / 1000, billetes1000);
        restante -= billetes1000Entregar * 1000;

        int billetes500Entregar = Math.min(restante / 500, billetes500);
        restante -= billetes500Entregar * 500;

        int billetes200Entregar = Math.min(restante / 200, billetes200);
        restante -= billetes200Entregar * 200;

        int billetes100Entregar = Math.min(restante / 100, billetes100);
        restante -= billetes100Entregar * 100;

        billetes1000 -= billetes1000Entregar;
        billetes500 -= billetes500Entregar;
        billetes200 -= billetes200Entregar;
        billetes100 -= billetes100Entregar;
    }

    private void guardarBilletes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BILLETES_FILE))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarLog(String accion, String usuario, int monto, String seRealizo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOGS_FILE, true))) {
            writer.println(accion + ", " + usuario + ", " + monto + ", " + seRealizo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
