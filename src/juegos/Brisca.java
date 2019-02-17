package juegos;

import java.util.ArrayList;
import java.util.Scanner;

import barajas.Baraja;
import barajas.Carta;

public class Brisca extends Juego{

	// ATRIBUTOS
	private static final String nombreJuego = "brisca";
	private Baraja manoJ1;
	private Baraja manoJ2;
	private int cartaElegida;
	private Carta cartaJugador1;
	private Carta cartaJugador2;
	private Carta pinta;
	private int aQuienLeToca = 0;
	private int ganadorRonda;


	// CONSTRUCTORES
	public Brisca(String nombreJugador1, String nombreJugador2) {

		super(nombreJuego, nombreJugador1, nombreJugador2);
		this.baraja = new Baraja(0, true);
	}


	// PROPIEDADES



	// METODOS
	@Override
	public void jugar() {

		Scanner sc = new Scanner(System.in);
		
		// Nombre jugadores
		System.out.print("Nombre jugador1: ");
		this.nombreJugador1 = sc.nextLine();
		System.out.print("Nombre jugador2: ");
		this.nombreJugador2 = sc.nextLine();
		
		// Repartir cartas
		for (int i = 0; i < 3; i++) {

			this.manoJ1.insertarCartaAlFinal(this.baraja.robar());
			this.manoJ2.insertarCartaAlFinal(this.baraja.robar());
		}

		// Carta que pinta
		pinta = this.baraja.robar();
		this.baraja.insertarCartaAlPrincipio(pinta);

		// Bucle de juego mientras los jugadores tengan cartas en la mano
		while (!this.manoJ1.laBarajaEstaVacia()) {

			// Dos pasadas, una por cada jugador
			for (int i = 0; i < 2; i++) {
				
				// Quien juega
				switch (aQuienLeToca) {
				case 0:
					
					// Imprimir pinta
					System.out.println("Pinta: " + pinta.getNombreCarta());
					
					// Mostrar cartas al jugador
					for (int j = 0; j < this.manoJ1.getNumeroCartas(); j++) {
						
						System.out.println(j + ": " + this.manoJ1.getListaCartas().get(j).getNombreCarta());
					}
					
					// Elegir carta a jugar
					System.out.println("Carta: ");
					cartaElegida = sc.nextInt();
					cartaJugador1 = this.manoJ1.getListaCartas().get(cartaElegida);
					this.manoJ1.getListaCartas().remove(cartaElegida);
					
					// Imprimimos la carta jugada
					System.out.println("Carta jugada: " + cartaJugador1.getNombreCarta());
					
					// Turno del otro jugador
					aQuienLeToca = 1;
					
					break;

				case 1:

					// Imprimir pinta
					System.out.println("Pinta: " + pinta.getNombreCarta());
					
					// Mostrar cartas al jugador
					for (int j = 0; j < this.manoJ2.getNumeroCartas(); j++) {
						
						System.out.println(j + ": " + this.manoJ2.getListaCartas().get(j).getNombreCarta());
					}
					
					// Elegir carta a jugar
					System.out.println("Carta: ");
					cartaElegida = sc.nextInt();
					cartaJugador2 = this.manoJ1.getListaCartas().get(cartaElegida);
					this.manoJ2.getListaCartas().remove(cartaElegida);
					
					// Imprimimos la carta jugada
					System.out.println("Carta jugada: " + cartaJugador2.getNombreCarta());
					
					// Turno del otro jugador
					aQuienLeToca = 0;
					
					break;
				}
			}

			// Ganador mano
			ganadorRonda = elegirGanador();
			
			// Sumar Puntos al ganador

		}
	}

private int elegirGanador () {
	
	int ganador;
	
	// El primero en tirar ha sido el J1
	if (this.aQuienLeToca == 0) {
		
		// Si las cartas de los dos jugadores son del mismo palo que la pinta...
		if (this.cartaJugador1.getPalo() == this.pinta.getPalo() && this.cartaJugador2.getPalo() == this.pinta.getPalo()) {
			
			// ...Y la carta del J1 tiene mas valor que la del J2
			if (this.cartaJugador1.valorTute() > this.cartaJugador2.valorTute()) {
				
				ganador = 0;
				
			// ...Ó la carta del J2 tiene mas valor
			} else if (this.cartaJugador2.valorTute() > this.cartaJugador1.valorTute()) {
				
				ganador = 1;
				
			// ...Ó tienen el mismo valor...
			} else {
				
				// ...Y la carta del J1 es más alta
				if (this.cartaJugador1.getNumero() > this.cartaJugador2.getNumero()) {
					
					ganador = 0;
					
				// ...Ó la carta del J2 es más alta
				} else {
					
					ganador = 1;
				}
			}
		
		// Si solo la carta del J1 es del mismo palo que la pinta
		} else if (this.cartaJugador1.getPalo() == this.pinta.getPalo()) {
			
			ganador = 0;
			
		// Si solo la carta del J2 es del mismo palo que la pinta
		} else if (this.cartaJugador2.getPalo() == this.pinta.getPalo()) {
			
			ganador = 1;
			
		// Si ninguna de las dos cartas es del mismo palo que la pinta...
		} else {
			
			// ...Y son del mismo palo...
			if (cartaJugador1.getPalo() == cartaJugador2.getPalo()) {
				
				// ...Y la carta del J1 tiene mas valor que la carta del J2
				if (this.cartaJugador1.valorTute() > this.cartaJugador2.valorTute()) {
					
					ganador = 0;
					
				// ...Ó la carta del J2 tiene mas valor que la carta del J1
				} else if (this.cartaJugador2.valorTute() > this.cartaJugador1.valorTute()) {
					
					ganador = 1;
					
				// ...Ó tienen el mismo valor...
				} else {
					
					// ...Y la carta del J1 es más alta
					if (this.cartaJugador1.getNumero() > this.cartaJugador2.getNumero()) {
						
						ganador = 0;
						
					// ...Ó la carta del J2 es más alta
					} else {
						
						ganador = 1;
					}
				}
			}
		}
		
	// El primero en tirar ha sido el J2
	} else {
		
		
	}
	
	return ganador;
}









	//	@Override
	//	public void jugar() {
	//
	//		Scanner sc = new Scanner(System.in);
	//		
	//		System.out.print("Nombre J1: ");
	//		this.nombreJugador1 = sc.nextLine();
	//		
	//		System.out.print("Nombre J1: ");
	//		this.nombreJugador2 = sc.nextLine();
	//		
	//		Carta cartaRobada;
	//		int cartaJugada;
	//		Carta cartaJ1 = null;
	//		Carta cartaJ2 = null;
	//		int empieza = 0;
	//
	//		ArrayList<Carta> manoJugador1 = new ArrayList<Carta>(3);
	//		ArrayList<Carta> manoJugador2 = new ArrayList<Carta>(3);
	//		ArrayList<Carta> mesa		  = new ArrayList<Carta>(2);
	//
	//		// Repartir cartas
	//		for (int i = 0; i < 3; i++) {
	//
	//			cartaRobada = this.baraja.robar();
	//			manoJugador1.add(cartaRobada);
	//			cartaRobada = this.baraja.robar();
	//			manoJugador2.add(cartaRobada);
	//		}
	//
	//		// Carta de monte
	//		Carta cartaPinta = this.baraja.robar();
	//
	//		// Bucle de juego (turnos)
	//		do {
	//			// Depende de quien haya ganado la anterior mano empieza primero
	//			for (int i = 0; i < 2; i++) {
	//				
	//				switch (empieza) {
	//				// Turno J1
	//				case 0:
	//					
	//					System.out.print("\n    Turno " + this.nombreJugador1 + "\n");
	//					System.out.println("Pinta: " + cartaPinta.getNombreCarta());
	//					// Mostrar mano
	//					for (int j = 0; j < manoJugador1.size(); j++) {
	//
	//						System.out.print(j + " - " + manoJugador1.get(j).getNombreCarta() + "\n");
	//					}
	//					// Elegir carta a jugar
	//					System.out.print("Jugar carta: ");
	//					cartaJugada = sc.nextInt();
	//					// Carta elegida añadida a la mesa y eliminada
	//					cartaJ1 = manoJugador1.get(cartaJugada);
	//					System.out.println(this.nombreJugador1 + " ha jugado el " + cartaJ1.getNombreCarta());
	//					manoJugador1.remove(cartaJugada);
	//					// El siguiente en jugar sera el J2
	//					empieza = 1;
	//					break;
	//				// Turno J2
	//				case 1:
	//					
	//					System.out.println("\n    Turno " + this.nombreJugador2 + "\n");
	//					System.out.println("Pinta: " + cartaPinta.getNombreCarta());
	//					// Mostrar mano
	//					for (int j = 0; j < manoJugador2.size(); j++) {
	//
	//						System.out.print(j + " - " + manoJugador2.get(j).getNombreCarta() + "\n");
	//					}
	//					// Elegir carta a jugar
	//					System.out.print("Jugar carta: ");
	//					cartaJugada = sc.nextInt();
	//					// Carta elegida añadida a la mesa y eliminada
	//					cartaJ2 = manoJugador2.get(cartaJugada);
	//					System.out.println(this.nombreJugador2 + " ha jugado el " + cartaJ2.getNombreCarta());
	//					manoJugador2.remove(cartaJugada);
	//					// El siguiente en jugar sera el J1
	//					empieza = 0;
	//					break;
	//				}
	//				
	//			}
	//			
	//			// Robamos cartas
	//			manoJugador1.add(this.baraja.robar());
	//			manoJugador2.add(this.baraja.robar());
	//			
	////			// Ponemos las dos cartas en la mesa 0:J1, 1:J2
	////			mesa.add(cartaJ1);
	////			mesa.add(cartaJ2);
	//			
	//			// Imprimimos la mesa
	//			System.out.println("Cartas mesa:");
	//			System.out.println(mesa.get(0).getNombreCarta() + " / " + mesa.get(1).getNombreCarta());
	//			
	//			// Comprobamos ganador, sumamos puntos y decimos quien gana
	//			// 
	//			ganadorManoYSumarPuntos(cartaJ1, cartaJ2, cartaPinta);
	//			
	//		} while (this.baraja.getListaCartas().size() > 1);	
	//		
	//		if (this.puntosJugador1 > this.puntosJugador2) {
	//			this.imprimirFinJuego(this.nombreJugador1, "ganado");
	//			this.imprimirFinJuego(this.nombreJugador2, "perdido");
	//		} else {
	//			this.imprimirFinJuego(this.nombreJugador2, "ganado");
	//			this.imprimirFinJuego(this.nombreJugador1, "perdido");
	//		}
	//		
	//	}
	//	
	//	private int ganadorManoYSumarPuntos () {
	//		// Si el J2 ha ganado la anterior mano
	//		
	//		
	//		
	//		
	//		
	//		
	//		
	//		
	//		// CartasJugadores mismo palo CartaPinta
	//		if (mesa.get(0).getPalo() == cartaPinta.getPalo() && mesa.get(1).getPalo() == cartaPinta.getPalo()) {
	//			// Carta J1 > Carta J2
	//			if (mesa.get(0).getNumero() > mesa.get(1).getNumero()) {
	//				// Sumamos puntos de las 2 cartas a J1
	//				this.sumarPuntosJugador(mesa.get(0).valorTute(), mesa.get(1).valorTute(), 1);
	//			// Carta J1 < Carta J2
	//			} else {
	//				// Sumamos puntos de las 2 cartas a J2
	//				this.sumarPuntosJugador(mesa.get(0).valorTute(), mesa.get(1).valorTute(), 2);
	//			}
	//			
	//		// Si CartaJ1 mismo palo CartaPinta
	//		} else if (mesa.get(0).getPalo() == cartaPinta.getPalo()) {
	//			// Sumamos puntos de las 2 cartas a J1
	//			this.sumarPuntosJugador(mesa.get(0).valorTute(), mesa.get(1).valorTute(), 1);
	//			
	//		// Si carta J2 mismo palo CartaPinta
	//		} else if (mesa.get(1).getPalo() == cartaPinta.getPalo()) {
	//			// Sumamos puntos de las 2 cartas a J2
	//			this.sumarPuntosJugador(mesa.get(0).valorTute(), mesa.get(1).valorTute(), 2);
	//		
	//		// Si ningún jugador tiene el mismo palo que CartaPinta
	//		} else {
	//			// Si CartaJ1 > CartaJ2
	//			if (mesa.get(0).getNumero() > mesa.get(1).getNumero()) {
	//				// Sumamos puntos de las 2 cartas a J1
	//				this.sumarPuntosJugador(mesa.get(0).valorTute(), mesa.get(1).valorTute(), 1);
	//			// Si CartaJ1 < CartaJ2
	//			} else {
	//				// Sumamos puntos de las 2 cartas a J2
	//				this.sumarPuntosJugador(mesa.get(0).valorTute(), mesa.get(1).valorTute(), 2);
	//			}
	//			
	//		}
	//	}

















}
