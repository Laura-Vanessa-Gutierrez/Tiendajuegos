package primeractividad;

import java.util.ArrayList;

public class Store {

	private ArrayList<Game> games;
	private ArrayList<Customer> customer;
	private ArrayList<Purchase> purchases;

	public Store() {

		this.games = new ArrayList<>();
		this.customer = new ArrayList<>();
		this.purchases = new ArrayList<>();

	}

	
	public void anadirVideoJuego(Game nuevoJuego) {

		for (Game juego : games) {

			if (juego.getId() == nuevoJuego.getId()) {

				throw new IllegalArgumentException("Actualmente existe un juego con el mismo identificador");
			}
		}

		games.add(nuevoJuego);

		System.out.println("Se ha añadido correctamente al catalogo");

	}

	
	public Game obtenerVideoJuego(int identificador) {

		for (Game juego : games) {

			if (juego.getId() == identificador) {

				return juego;
			}
		}

		throw new IllegalArgumentException("No se encontro ningún videojuego con el identificador ingresado:" + identificador);

	}
	
	
	public Customer obtenerCliente(int identificador) {
		
		for (Customer cliente : customer) {
			
			if (cliente.getId() == identificador) {
				
				return cliente;
			}
		}
		
		throw new IllegalArgumentException("Lamentablemente no se encontro ningún cliente con el identificador ingresado: " + identificador);
		
	}
	
	
	public ArrayList<Game> buscarVideoJuegos(String titulo){
		
		ArrayList<Game> resultado = new ArrayList<>();
		
		for (Game juego : games) {
			
			if (juego.getTittle().toLowerCase().contains(titulo.toLowerCase())) {
				
				resultado.add(juego);
			}
		}
		
		return resultado;
	}
	
	
	public ArrayList<Game> filtrarPorGenero(GENRE generoIngresado){
		
		ArrayList<Game> filtrados = new ArrayList<>();
		
		for(Game juego : games) {
			
			if (juego.getGenre() == generoIngresado) {
				
				filtrados.add(juego);
			}
		}
		
		return filtrados;
	}
	
	
	public void realizarCompra(int idCliente, int idJuego, int cantidad) {
		
		Customer cliente = obtenerCliente(idCliente);
		
		Game juego = obtenerVideoJuego(idJuego);
		
		if (cantidad <= 0) {
			
			throw new IllegalArgumentException("La cantidad debe ser mayor");
		}
		
		if (!juego.unidadesDisponibles() || juego.getStock() < cantidad) {
			
			throw new IllegalArgumentException("No hay suficiente Stock");
			
		}
		
		double precioTotal = juego.getPrice() * cantidad;
		
		if (!cliente.tieneSuficienteSaldo(precioTotal)) {
			
			throw new IllegalArgumentException("No tienes suficiente saldo");
		}
		
		juego.reducirStock(cantidad);
		
		cliente.retirarSaldo(precioTotal);
		
		Purchase nuevaCompra = new Purchase(cliente, juego, cantidad);
		purchases.add(nuevaCompra);
		
		System.out.println("La compra ha sido realizada con éxito");
	}
	
	
	

}
