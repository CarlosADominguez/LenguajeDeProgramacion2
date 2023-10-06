public class BatallaPokemon {

    public static void main(String[] args) {
     
    PokemonAgua psyduck = new PokemonAgua("Psyduck",10);
    PokemonFuego moltres = new PokemonFuego("Moltres",10);
    
    psyduck.atacar("Confusion",moltres);
    moltres.atacar("Giro fuego", psyduck);
    
    
    }
}