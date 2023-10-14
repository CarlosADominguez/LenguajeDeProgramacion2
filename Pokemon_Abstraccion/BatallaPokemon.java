import pokemon.PokemonAgua;
import pokemon.PokemonFuego;

public class BatallaPokemon {

    public static void main(String[] args) {
     
    PokemonAgua psyduck = new PokemonAgua("Psyduck",10);
    PokemonFuego moltres = new PokemonFuego("Moltres",10);
    
    psyduck.atacar(1,moltres);
    moltres.atacar(1, psyduck);
    
    
    }
}
