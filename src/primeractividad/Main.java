package primeractividad;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Store tienda = new Store();
		Scanner scanner = new Scanner(System.in);
		boolean salir = false;

		System.out.println("Tienda de videojuegos: ");
		
		while (!salir) {
			
			String datoIngresado = scanner.nextLine().trim();
			
			String[] dividir = datoIngresado.split(" ");
			String comando = dividir[0].toLowerCase();
			
			
			switch (comando) {
			
			case "games" :
				
				for (Game juego : tienda.getGames()) {
					
					System.out.println(juego);
				}
				
				
			case "salir":
				
				salir = true;
			
				System.out.println("Estas saliendo del programa");
				
			break;

		default:
			
			System.out.println("El comando que has ingresado no se reconoce");
			
			break;
		}
			
			
		}
		

	}

}
