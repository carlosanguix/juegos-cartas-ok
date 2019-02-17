package juegos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import barajas.Baraja;

public class SieteYMedio extends Juego {

	// ATRIBUTOS
	static Scanner sc = new Scanner(System.in);
	private static final String nombreJuego     = "7 y medio"; // NombreJuego
	private static final String[] nombreJugador = {"", ""};
	private static final double[] puntosJugador = {0, 0};

	// CONSTRUCTORES
	public SieteYMedio(String nombreJugador1, String nombreJugador2) {

		super(nombreJuego, nombreJugador1, nombreJugador2);
		this.baraja = new Baraja(0, true);
	}

	// PROPIEDADES

	// METODOS
	private static void menu7YMedio () {

		System.out.println("Modos de juego");
		System.out.println(" 1- 1 Jugador");
		System.out.println(" 2- Jugador vs Jugador");
		System.out.println(" 3- Jugador vs COM");
		System.out.println("");
		System.out.print("Opción: ");
	}

	@Override
	public void jugar() {

		menu7YMedio();
		int opcion = sc.nextInt();
		sc.nextLine();
		System.out.println("");

		switch (opcion) {
		case 1:

			this.unJugador();

			break;

		case 2:

			this.dosJugadores();
			
			break;
		case 3:

			this.jugadorVsCpu();
			
			break;

		default:
			break;
		}
	}

	private void unJugador () {

		// Nombre jugador1
		System.out.print("Nombre: ");
		this.nombreJugador1 = sc.nextLine();

		// Robamos carta y asignamos puntos
		this.sumarPuntosJugador(this.baraja.robar().valor7YMedia(), 0, 1);

		// Maxima puntuación?
		while (this.puntosJugador1 < 7.5) {

			this.imprimirPuntuacion();

			// Otra carta?
			System.out.print("Quieres otra carta? (s/n)");
			String otraCarta = sc.nextLine();

			// Si
			if (otraCarta.equals("s")) {

				this.sumarPuntosJugador(this.baraja.robar().valor7YMedia(), 0, 1);
				// No
			} else {

				this.imprimirPuntuacion();
				break;
			}
		}

		this.imprimirPuntuacion();

		// Ganas o pierdes?
		if (this.puntosJugador1 <= 7.5) {

			this.imprimirFinJuego(this.nombreJugador1, "ganado");
		} else {

			this.imprimirFinJuego(this.nombreJugador1, "perdido");
		}
	}

	private void dosJugadores () {
		
		System.out.print("Nombre J1: ");
		this.nombreJugador1 = sc.nextLine();
		System.out.print("Nombre J2: ");
		this.nombreJugador2 = sc.nextLine();
		
		nombreJugador[0] = this.nombreJugador1;		nombreJugador[1] = this.nombreJugador2;
		
		double puntos;
		
		for (int i = 0; i < 2; i++) {
			
			System.out.printf("%n             Turno de %s%n", nombreJugador[i]);
			System.out.printf   ("         **********************%n");
			puntos = this.baraja.robar().valor7YMedia();
			this.sumarPuntosJugador(puntos, 0, i + 1);
			puntosJugador[i] += puntos;
			
			while (true) {

				this.imprimirPuntuacion();

				// Otra carta?
				System.out.printf("%nQuieres otra carta? (s/n)");
				String otraCarta = sc.nextLine();

				// Si
				if (otraCarta.equals("s")) {

					puntos = this.baraja.robar().valor7YMedia();
					this.sumarPuntosJugador(puntos, 0, i + 1);
					puntosJugador[i] += puntos;
					// No
				} else {

					this.imprimirPuntuacion();
					break;
				}
				
				if (puntosJugador[i] > 7.5) {
					break;
				}
			}
		}
		
	}

	private void jugadorVsCpu () {
//		
//		System.out.print("Nombre J1: ");
//		this.nombreJugador1 = sc.nextLine();
//		this.nombreJugador2 = "CPU";
//		
//		int turnoRandom = (int)(Math.random() * 2);
//		
//		if (turnoRandom == 0) {
//			
//			nombreJugador[0] = this.nombreJugador1;		nombreJugador[1] = this.nombreJugador2;
//		} else {
//			
//			nombreJugador[0] = this.nombreJugador2;		nombreJugador[1] = this.nombreJugador1;
//		}
//		
//		double puntos;
//		
//		for (int i = 0; i < 2; i++) {
//			
//			System.out.printf("%n             Turno de %s%n", nombreJugador[i]);
//			System.out.printf   ("         **********************%n");
//			
//			puntos = this.baraja.robar().valor7YMedia();
//			this.sumarPuntosJugador(puntos, 0, i + 1);
//			puntosJugador[i] += puntos;
//			
//			while (true) {
//
//				this.imprimirPuntuacion();
//
//				// Otra carta?
//				System.out.printf("%nQuieres otra carta? (s/n)");
//				String otraCarta = sc.nextLine();
//
//				// Si
//				if (otraCarta.equals("s")) {
//
//					puntos = this.baraja.robar().valor7YMedia();
//					this.sumarPuntosJugador(puntos, 0, i + 1);
//					puntosJugador[i] += puntos;
//					// No
//				} else {
//
//					this.imprimirPuntuacion();
//					break;
//				}
//				
//				if (puntosJugador[i] > 7.5) {
//					break;
//				}
//			}
//		}
	}




}