package principal;

import java.util.Scanner;

import barajas.Baraja;
import juegos.Brisca;
import juegos.SieteYMedio;

public class Principal {

	public static void menu () {

		System.out.println("*************************************");
		System.out.println("         JUEGOS DE CARTAS          ");
		System.out.println("*************************************");
		System.out.println(" 1- 7 y medio");
		System.out.println(" 2- Brisca");
		System.out.println(" 3- Tute");
		System.out.println();
		System.out.println(" 8- Cambiar idioma");
		System.out.println(" 9- Salir");
		System.out.println();
		System.out.print("Opción: ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		while (true) {

			menu();

			int opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			// Siete Y medio
			case 1:
				
				SieteYMedio juegoSieteYMedio = new SieteYMedio("", "");
				juegoSieteYMedio.jugar();
				
				break;
			// Brisca	
			case 2:
				
				Brisca juegoBrisca = new Brisca("", "");
				juegoBrisca.jugar();
				
				break;
			// Tute	
			case 3:

				break;
			// Idioma
			case 8:
				//
				break;
			// Salir
			case 9:
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}
}