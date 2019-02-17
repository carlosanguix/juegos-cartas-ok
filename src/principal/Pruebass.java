package principal;

import barajas.Baraja;
import barajas.Carta;

public class Pruebass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Probar baraja
		Baraja baraja = new Baraja(0, false);
		System.out.println(baraja);
		
		// Probar carta
		Carta asd = new Carta(10);
		System.out.println(asd);
		System.out.println(asd.getNombreCarta());
		
		// Robar carta
		asd = baraja.robar();
		System.out.println(asd);

	}

}