package pokemon;
public class PokemonFuego extends Pokemon {
    public PokemonFuego(String nombre, int nivel) {
        super(nombre, Tipo.FUEGO, nivel);

        ListaMovimientos listaMovimientos = new ListaMovimientos();

        setMovimientos(0, listaMovimientos.buscarMovimientoPorNombre("Ascuas"));
        setMovimientos(1, listaMovimientos.buscarMovimientoPorNombre("Calcinacion"));
        setMovimientos(2, listaMovimientos.buscarMovimientoPorNombre("Arañazo"));
        setMovimientos(3, listaMovimientos.buscarMovimientoPorNombre("Derribo"));
    }
    @Override
    public double obtenerEfectividad(Pokemon pokemon){
        double efectividad = 1.0;

        if (pokemon.getTipo()==Tipo.AGUA) efectividad = 0.5;
        if (pokemon.getTipo()==Tipo.ACERO) efectividad = 2;

        return efectividad;
       } 
}
