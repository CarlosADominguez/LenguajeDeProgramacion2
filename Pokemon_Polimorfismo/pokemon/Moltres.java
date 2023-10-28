package pokemon;

public class Moltres extends Pokemon {

    private Tipo tipo1= Tipo.FUEGO;
    private Tipo tipo2= Tipo.VOLADOR;

    public Moltres(String nombre, int nivel){
        super(nombre, nivel, 90, 100, 90, 125, 85, 90,1, 4);
	ListaMovimientos listaMovimientos = new ListaMovimientos();

	setMovimientos(0,listaMovimientos.buscarMovimientoPorNombre("Velo Sagrado"));
        setMovimientos(1,listaMovimientos.buscarMovimientoPorNombre("Ataque Ala"));
        setMovimientos(2,listaMovimientos.buscarMovimientoPorNombre("Ascuas"));
        setMovimientos(3,listaMovimientos.buscarMovimientoPorNombre("Calcinación"));


    }
    
    @Override
    public double obtenerEfectividad(Pokemon pokemon){
        double efectividad = 1.0;

        if (pokemon.getMovimiento().getTipo()==Tipo.ACERO) efectividad = 2;
        if (pokemon.getMovimiento().getTipo()==Tipo.AGUA) efectividad = 0.5;
	      if (pokemon.getMovimiento().getTipo()==Tipo.BICHO) efectividad = 2;
        if (pokemon.getMovimiento().getTipo()==Tipo.DRAGON) efectividad = 0.5;
	      if (pokemon.getMovimiento().getTipo()==Tipo.HIELO) efectividad = 2;
        if (pokemon.getMovimiento().getTipo()==Tipo.FUEGO) efectividad = 0.5;
	      if (pokemon.getMovimiento().getTipo()==Tipo.PLANTA) efectividad = 2;
        if (pokemon.getMovimiento().getTipo()==Tipo.ELECTRICO) efectividad = 2;
	      if (pokemon.getMovimiento().getTipo()==Tipo.ROCA) efectividad = 0.25	;
        if (pokemon.getMovimiento().getTipo()==Tipo.HADA) efectividad = 0.5;
	      if (pokemon.getMovimiento().getTipo()==Tipo.TIERRA) efectividad = 2;
        
        return efectividad;
       } 
}
