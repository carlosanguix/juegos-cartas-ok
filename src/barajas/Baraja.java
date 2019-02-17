package barajas;

import java.util.ArrayList;

public class Baraja {

	
// ATRIBUTOS
	private ArrayList<Carta> listaCartas;


// CONTRUCTORES
	public Baraja () {

		this.listaCartas = new ArrayList<>(0);
	}
	public Baraja (int tipoBaraja) {

		this(tipoBaraja, false);
	}
	public Baraja (int tipoBaraja, boolean barajar) {

		this.crearBaraja(tipoBaraja);
		
		if (barajar) {
			this.listaCartas = this.barajar();
		}
	}

	
// PROPIEDADES
	// Getters
	public ArrayList<Carta> getListaCartas() {
		
		return listaCartas;
	}
	public boolean laBarajaEstaVacia () {
		return ((this.listaCartas.size() == 0)) 
				? true
				: false ;
	}
	
// METODOS
	// Crear baraja
	private void crearBaraja (int tipoBaraja) {
		
		this.listaCartas = new ArrayList<>();
		
		for (int i = 0; i <= tipoBaraja; i++) {
			for (int id = 1; id <= 40; id++) {
				
				Carta nuevaCarta = new Carta(id);
				this.listaCartas.add(nuevaCarta);
			}
		}
	}
	// Barajar CLONAR???????
	public ArrayList<Carta> barajar () {
		
		ArrayList<Carta> barajaBarajada = new ArrayList<Carta>(this.listaCartas.size());
		Carta nuevaCarta;
		
		int cantidadCartas = this.listaCartas.size();
		
		for (int i = 0; i < cantidadCartas; i++) {
			
			int indiceRandom = (int)(Math.random() * this.listaCartas.size());
			
			nuevaCarta = this.listaCartas.get(indiceRandom);
			barajaBarajada.add(nuevaCarta);
			
			this.listaCartas.remove(indiceRandom);
		}
		return barajaBarajada;
	}
	// Cortar
	public ArrayList<Carta> cortar (int posicion) {
		// Iteramos tantas veces como posición
		for (int i = 0; i < posicion; i++) {
			// Siempre operamos con la primera posición, ya que,
			// cuando la añadimos al final, la tenemos que eliminar del principio.
			this.listaCartas.add(this.listaCartas.get(0));
			this.listaCartas.remove(0);
		}
		return this.listaCartas;
	}
	// Robar
	public Carta robar () {
		
		Carta cartaARobar = this.listaCartas.get(this.listaCartas.size() - 1);
		this.listaCartas.remove(this.listaCartas.size() - 1);
		
		return cartaARobar;
	}
	// Insertar cartaID al final
	public void insertarCartaAlFinal (int id) {
		
		Carta cartaInsertada = new Carta(id);
		this.insertarCartaAlFinal(cartaInsertada);
	}
	// Insertar cartaID al principio
	public void insertarCartaAlPrincipio (int id) {
		
		Carta cartaInsertada = new Carta(id);
		this.insertarCartaAlPrincipio(cartaInsertada);
	}
	// Insertar CartaObj al final
	public void insertarCartaAlFinal (Carta cartaInsertada) {
		
		this.listaCartas.add(cartaInsertada);
	}
	// Insertar CartaObj al principio
	public void insertarCartaAlPrincipio (Carta cartaInsertada) {
		
		this.listaCartas.add(0, cartaInsertada);
	}
	
	// Saber cantidad cartas que quedan en la baraja
	public int getNumeroCartas () {
		
		return this.listaCartas.size();
	}
	// UtilidadImprimir
	@Override
	public String toString() {
		
		return "" + listaCartas + "";
	}
}