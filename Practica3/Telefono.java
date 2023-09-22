public class Telefono {
    String pais, lada, Numero, NumeroDeTelefono;

    public Telefono(){
        
    this.pais = "+52";
    this.lada = "981";
    this.Numero = "1034859";
    this.NumeroDeTelefono = pais.concat(" "+ lada+ Numero);
    }
    
    public String toString(){
        
        return NumeroDeTelefono;
    }
}
