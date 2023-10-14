package pokemon;

public class PokemonAgua extends Pokemon {
    public PokemonAgua(String nombre, int nivel) {
        super(nombre, Tipo.AGUA, nivel);

        ListaMovimientos listaMovimientos = new ListaMovimientos();

        setMovimientos(0, listaMovimientos.buscarMovimientoPorNombre("Pistola de Agua"));
        setMovimientos(1, listaMovimientos.buscarMovimientoPorNombre("Hidropulso"));
        setMovimientos(2, listaMovimientos.buscarMovimientoPorNombre("Psicorrayo"));
        setMovimientos(3, listaMovimientos.buscarMovimientoPorNombre("Confusion"));
    }
    @Override
    public double obtenerEfectividad(Pokemon pokemon){
        double efectividad = 1.0;

        if (pokemon.getTipo()==Tipo.FUEGO) efectividad = 2;
        if (pokemon.getTipo()==Tipo.DRAGON) efectividad = 0.5;

        return efectividad;
       } 
}
