package pokemon;

public class Movimiento {
    private String nombre;
    private int puntosDeAtaque, pp;
    private Tipo tipo;
    private TiposMovimiento tiposMovimiento;

    public Movimiento (String nombre,int puntosDeAtaque,Tipo tipo, int pp, TiposMovimiento tiposMovimiento){
        this.nombre = nombre;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.pp = pp;
        this.tiposMovimiento = tiposMovimiento;
      }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public int getPp() {
        return pp;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public TiposMovimiento getTiposMovimiento() {
        return tiposMovimiento;
    }  
