public class Pokemon {
    private int hp;
    private String nombre,tipo;
    
    public Pokemon (String nombre, String tipo, int HP){
       this.nombre=nombre;
       this.tipo=tipo;
       this.hp=100; 
    }
    public int getHP(){
        return hp;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTipo(){
        return tipo;
    }
    private void calculaDanio(int danio) {
        this.hp -= danio;
        System.out.printf("%s recibe %d puntos de danio\n", this.getNombre(), danio);
        System.out.printf("%s tiene %d puntos de vida\n", this.getNombre(), hp);
    }
    
    public void recibirAtaque(String movimiento) {
        System.out.printf("%s recibe ATK %s\n", this.getNombre(),movimiento);
        calculaDanio((int) (Math.random() * 10) + 1);
    }
    
    public void atacar(String movimiento, Pokemon pokemon) {
        System.out.printf("%s ataca a %s con %s\n", this.getNombre(),
        pokemon.getNombre(), movimiento);
        pokemon.recibirAtaque(movimiento);
    }   
    
}