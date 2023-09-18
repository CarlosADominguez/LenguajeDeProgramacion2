public class ControladorAutomovil {
	public static void main(String[] args){
		Automovil auto = new Automovil("Ford", "Fiesta");
		auto.encenderMotor();		
		auto.acelerar(50);
		auto.frenar(20);
		auto.acelerar(50);
	
		auto.duplicarVelocidad(auto.velocidad);
			System.out.println("El auto se mueve a " + auto.verVelocidad() + " km/h");
		auto.color = "Rojo";
			System.out.println("Mi auto es de color " + auto.color);
		Automovil.pintar(auto);
			System.out.println("El color de mi auto ahora es " + auto.color);
		Automovil.Estereo radio = new Automovil.Estereo();
			radio.reproducirCancion("Guns n' Roses - Nightrain");
		Automovil.Radiador radiador = auto.new Radiador();
			radiador.enfriar();	
	}
}
