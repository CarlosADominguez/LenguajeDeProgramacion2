import java.util.Random;

public class Motor {
	
	private int revoluciones;		
	private int aire;				
	private int combustible;		
	private boolean bujia;
	private boolean piston;			
	private boolean encendido;		
	private Random r;			
	
	
	public Motor() {
		aire = 0;
		combustible = 0;
		revoluciones = 0;
		encendido = false;
		r = new Random();
	}

	
	
	private void prepararMezcla() {
		while(!(Math.abs(aire - combustible) < 5 && (aire > 50 && combustible > 50))){
			aire += r.nextInt(10);
			combustible += r.nextInt(10);
		}
		piston = false;
	}
	
	
	private void comprimirMezcla(){
		piston = true;
		bujia = false;
	}
	
	
	private void encenderMezcla(){
		bujia = true;
		bujia = false;
		double energia = (aire + combustible) * 34.78 / 2;
		revoluciones += (int)(energia / 100);
		piston = false;
		eliminarDesechos(energia);
	}
	
	
	private void eliminarDesechos(double residuos){
		while(residuos > 0){
			residuos -= r.nextDouble();
		}
	}

    	public boolean getEncendido(){
		return encendido;
	}

    	
    	public int getRevoluciones() {
        	return revoluciones;
    }

    
    	public void setRevoluciones(int cantidad) {
        	this.revoluciones = cantidad;
    }

    	public void setEncendido(boolean encendido) {
        	this.encendido = encendido;
    }
    	public void revolucionar() {
        	if (encendido) {
            		prepararMezcla();
            		comprimirMezcla();
            		encenderMezcla();
        }
    }
}
