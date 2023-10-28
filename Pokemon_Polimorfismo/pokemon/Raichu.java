package pokemon;

public class Raichu extends Pokemon {

    private Tipo tipo1 = Tipo.ELECTRICO;

    public Raichu(String nombre, int nivel){
        super(nombre, nivel, 60, 90, 55, 90, 80, 110,1, 4);
        ListaMovimientos listaMovimientos = new ListaMovimientos();


	setMovimientos(0,listaMovimientos.buscarMovimientoPorNombre("Puño trueno"));
        setMovimientos(1,listaMovimientos.buscarMovimientoPorNombre("Chispazo"));
        setMovimientos(2,listaMovimientos.buscarMovimientoPorNombre("Maquinación"));
        setMovimientos(3,listaMovimientos.buscarMovimientoPorNombre("Chispa"));

    }  

    @Override
    public double obtenerEfectividad(Pokemon pokemon){
        double efectividad = 1.0;

        if (pokemon.getMovimiento().getTipo()==Tipo.AGUA) efectividad = 2;
        if (pokemon.getMovimiento().getTipo()==Tipo.DRAGON) efectividad = 0.5;
	      if (pokemon.getMovimiento().getTipo()==Tipo.ELECTRICO) efectividad = 0.5;
        if (pokemon.getMovimiento().getTipo()==Tipo.PLANTA) efectividad = 0.5;
        if (pokemon.getMovimiento().getTipo()==Tipo.TIERRA) efectividad = 0;
        if (pokemon.getMovimiento().getTipo()==Tipo.VOLADOR) efectividad = 2;

        return efectividad;
       } 
}
