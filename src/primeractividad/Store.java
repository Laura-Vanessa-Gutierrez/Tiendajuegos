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
		
		
		games.add(new Game(1, "Minecraft", GENRE.SIMULATION, 29.99, 5));
		games.add(new Game(2, "Hollow Knight", GENRE.ADVENTURE, 14.99, 3));
		games.add(new Game(3, "Celeste", GENRE.PLATAFORM, 19.99, 0));
		customer.add(new Customer(1, "Laura", 100.0));
		customer.add(new Customer(2, "Ana", 500.0));
		customer.add(new Customer(3, "Luis", 30.0));

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
	
	
	public ArrayList<Game> getGames() {
		
		return games;
		
	}
	
	
	

}
