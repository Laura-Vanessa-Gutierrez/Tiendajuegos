package primeractividad;

public class Purchase {

	private Customer customer;
	private Game game;
	private int quantity;
	private double totalPrice;

	
	public Purchase(Customer customer, Game game, int quantity) {
		
		if (quantity <= 0) {
			
			throw new IllegalArgumentException("La cantidad de unidades debe ser mayor");
		}
		
		if (customer == null || game == null) {
			
			throw new IllegalArgumentException("El cliente y el juego no pueden estar vacíos, agregalos por favor");
		}

		this.customer = customer;
		this.game = game;
		this.quantity = quantity;
		this.totalPrice = game.getPrice() * quantity;
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public Game getGame() {
		return game;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	@Override
	public String toString() {
		return "Detalle de Compra \n" + "Cliente: " + customer.getName() + "\n" + "Videojuego: "
				+ game.getTittle() + "\n" + "Unidades: " + quantity + "\n" + "Precio Total: " + totalPrice;
	}
}