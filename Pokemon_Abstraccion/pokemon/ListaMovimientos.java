package pokemon;
import java.util.ArrayList;

public class ListaMovimientos {
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos() {

        movimientos.add(new Movimiento("Pistola de agua",40,Tipo.AGUA,25));
        movimientos.add(new Movimiento("Hidropulso",60,Tipo.AGUA,20));

        movimientos.add(new Movimiento("Ascuas",40,Tipo.FUEGO,25));
        movimientos.add(new Movimiento("Calcinacion",60,Tipo.FUEGO,15));

        movimientos.add(new Movimiento("Psicorrayo",65,Tipo.PSIQUICO,20));
        movimientos.add(new Movimiento("Confusion",50,Tipo.PSIQUICO,25));

        movimientos.add(new Movimiento("Arañazo",40,Tipo.NORMAL,35));
        movimientos.add(new Movimiento("Derribo",90,Tipo.NORMAL,20));
        
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
