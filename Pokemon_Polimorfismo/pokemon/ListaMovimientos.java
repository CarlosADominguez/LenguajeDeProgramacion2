package pokemon;
import java.util.ArrayList;

public class ListaMovimientos {
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos() {

        movimientos.add(new Movimiento("Puño trueno",75,Tipo.ELECTRICO, 15, TiposMovimiento.FISICO));
        movimientos.add(new Movimiento("Chispazo",80,Tipo.ELECTRICO, 15, TiposMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Maquinación",40,Tipo.SINIESTRO,25, TiposMovimiento.ESTADO));
        movimientos.add(new Movimiento("Chispa",60,Tipo.ELECTRICO,15,TiposMovimiento.FISICO));


        movimientos.add(new Movimiento("Velo Sagrado",20,Tipo.NORMAL, 25, TiposMovimiento.ESTADO));
        movimientos.add(new Movimiento("Ataque Ala",60,Tipo.VOLADOR, 35, TiposMovimiento.FISICO));
        movimientos.add(new Movimiento("Ascuas",40,Tipo.FUEGO, 25, TiposMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Calcinacion",60,Tipo.FUEGO, 15,TiposMovimiento.ESPECIAL));
        
    }
    public Movimiento buscarMovimientoPorNombre(String nombre) {
        for(Movimiento movimiento : movimientos){	
            if (movimiento.getNombre().equals(nombre)){
                return movimiento;
            } 
        } 
            return null;
    }   
}
