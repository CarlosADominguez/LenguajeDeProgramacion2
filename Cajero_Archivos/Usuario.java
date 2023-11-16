import java.util.Random;
import java.io.*;

public class Usuario implements Serializable {
    private String nombre;
    private int nip;
    private int saldo;

    public Usuario(String nombre, int nip) {
        this.nombre = nombre;
        this.nip = nip;
        this.saldo = new Random().nextInt(49001) + 1000; // Saldo aleatorio entre $1,000 y $50,000
    }

    public String getNombre() {
        return nombre;
    }

    public int getNip() {
        return nip;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
