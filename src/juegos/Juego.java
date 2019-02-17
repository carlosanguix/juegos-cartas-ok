package juegos;

import barajas.Baraja;
import utilidades.Idioma;

public abstract class Juego {

// ATRIBUTOS
	protected Baraja baraja;
	private String nombreJuego;
	protected String nombreJugador1;
	protected String nombreJugador2;
	protected double puntosJugador1;
	protected double puntosJugador2;
	protected int numeroMano;
	//protected Idioma idioma;
// CONSTRUCTORES
	public Juego (String nombreJuego, String nombreJugador1, String nombreJugador2){
		
		this.nombreJuego    = nombreJuego;
		this.nombreJugador1 = nombreJugador1;
		this.nombreJugador2 = nombreJugador2;
		this.imprimirCabecera();
	}
// PROPIEDADES
	public String getNombreJugador1() {
		return nombreJugador1;
	}
	public void setNombreJugador1(String nombreJugador1) {
		this.nombreJugador1 = nombreJugador1;
	}
// METODOS
	// ABSTRACTOS
	public abstract void jugar ();
	// DE INSTANCIA
	private void imprimirCabecera () {
			
			System.out.printf("%n******************************************");
			System.out.printf("%n    BIENVENIDO AL JUEGO %S%n", this.nombreJuego);
			System.out.println("******************************************");
	}
	
	public void imprimirFinJuego (String jugador, String ganaPierde) {
		
		System.out.printf("%s ha %s%n%n", jugador, ganaPierde);
	}
	
	protected void imprimirPuntuacion () {
		
		if (this.nombreJugador2.equals("")) {
			
			System.out.printf("%n      %10s: %.1f puntos%n", this.nombreJugador1, this.puntosJugador1);
		} else {
			
			System.out.printf("%n      %10s: %.1f puntos", this.nombreJugador1, this.puntosJugador1);
			System.out.printf("%n      %10s: %.1f puntos%n", this.nombreJugador2, this.puntosJugador2);
		}
			
	}
	
	
	
	protected void sumarPuntosJugador (double puntosCarta1, double puntosCarta2, int numJugador) {
		
		double calcularPuntos = puntosCarta1 + puntosCarta2;
		
		if (numJugador == 1) {
			
			this.puntosJugador1 += calcularPuntos;
		} else {
			
			this.puntosJugador2 += calcularPuntos;
		}
	}
}