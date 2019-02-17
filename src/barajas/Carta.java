package barajas;

public class Carta {

	
// ATRIBUTOS
	private int numero;
	private int palo;

// CONSTRUCTORES
	public Carta (int id) {

		if (id % 10 == 0) {
			
			this.numero = 10;
			this.palo   = (id - 1) / 10;
		} else {
			
			this.numero = id % 10;
			this.palo   = id / 10;
		}
	}
	public Carta (int numero, int palo) {

		this.numero = numero;
		this.palo   = palo;
	}

	
// PROPIEDADES
	public int getNumero() {

		return numero;
	}
	public int getPalo() {

		return palo;
	}
	
	
// METODOS
	public String getNombreNumero() {

		String[] numeros = {"", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo", "rey"};

		String nombreDelNumero = numeros[this.numero];

		return nombreDelNumero;
	}
	public String getNombrePalo () {
		
		String[] palos = {"oros", "copas", "espadas", "bastos"};
		
		String nombreDelPalo = palos[this.palo];
		
		return nombreDelPalo;
	}
	public String getNombreCarta () {
		
		String nombreDeLaCarta = this.getNombreNumero() + " de " + this.getNombrePalo();
		
		return nombreDeLaCarta;
	}
	public int valorTute () {
		// 1==as --- 10==rey
		int[] valoresTute = {0, 11, 0, 10, 0, 0, 0, 0, 2, 3, 4};
		
		int valorCarta = valoresTute[this.numero];
		
		return valorCarta;
	}
	public int valorMus () {
		// 0==rey --- 9==caballo
		int[] valoresMus = {0, 1, 1, 10, 4, 5, 6, 7, 10, 10, 10};
		
		int valorCarta = valoresMus[this.numero];
		
		return valorCarta;
	}
	public double valor7YMedia () {
		// 0==rey --- 9==caballo
		double[] valores7YMedia = {0, 1, 2, 3, 4, 5, 6, 7, 0.5, 0.5, 0.5};
		
		double valorCarta = valores7YMedia[this.numero];
		
		return valorCarta;
	}
	
	
	@Override
	public String toString() {
		return String.format("%nnumero: %d, palo: %d", this.numero, this.palo);
	}
}