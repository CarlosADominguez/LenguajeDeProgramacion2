import java.io.*;

public class Administrador implements Serializable {
    private static final String LOGS_FILE = "logs.txt";
    private static final String BILLETES_FILE = "billetes.dat";
    private String nombre;
    private int NIP;

    public void mostrarMenuAdmin() {

        while (true) {
            System.out.println("\n==== Menú Administrador ====");
            System.out.println("1. Mostrar acciones en el log");
            System.out.println("2. Mostrar cantidad de billetes restantes");
            System.out.println("3. Salir");

            int opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    mostrarLog();
                    break;
                case 2:
                    mostrarBilletesRestantes();
                    break;
                case 3:
                    System.out.println("Sesión de administrador cerrada.");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private int leerOpcion() {
        try {
            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(System.in));
            String input = reader.readLine();
            return Integer.parseInt(input);
        } catch (IOException | NumberFormatException e) {
            System.out.println("");
            return -1;
        }
    }

    private void mostrarLog() {
        try (BufferedReader br = new BufferedReader(new FileReader(LOGS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarBilletesRestantes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BILLETES_FILE))) {
            Cajero cajero = (Cajero) ois.readObject();
            System.out.println("Billetes de $100: " + cajero.billetes100);
            System.out.println("Billetes de $200: " + cajero.billetes200);
            System.out.println("Billetes de $500: " + cajero.billetes500);
            System.out.println("Billetes de $1000: " + cajero.billetes1000);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
