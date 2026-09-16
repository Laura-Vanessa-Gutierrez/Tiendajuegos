package primeractividad;

public class Game {
	
	private int id;
	private String tittle;
	private GENRE genre;
	private double price;
	private int stock;
	
	
	public Game(int id, String tittle, GENRE genre, double price, int stock) {
		
		if (price < 0 || stock < 0) {
			
			throw new IllegalArgumentException("El precio y el stock no pueden ser negativos");
		}
		
		this.id = id;
		this.tittle = tittle;
		this.genre = genre;
		this.price = price;
		this.stock = stock;
	}


	public int getStock() {
		return stock;
	}
	
	
	public void setStock(int stock) {
		
		if (stock < 0) {
			
			throw new IllegalArgumentException("El stock no puede ser negativo");
		}
		
		this.stock = stock;
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public String getTittle() {
		return tittle;
	}
	
	
	public GENRE getGenre() {
		return genre;
	}
	
	
	public double getPrice() {
		return price;
	}
	
	
	public void aumentarStock(int cantidad) {
		
		if (cantidad <= 0) {
			
			throw new IllegalArgumentException("La cantidad de aumento debe ser mayor que cero");
		}
		
		stock += cantidad;
		System.out.println("El stock que has aumentado esta actualmente de la siguiente forma: " + stock);
	}
	
	public void reducirStock(int cantidad) {
		
		if (cantidad <= 0) {
			
			throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
		}
		
		if (stock < cantidad) {
			
			throw new IllegalArgumentException("No hay suficiente stock para reducirlo");
		}
		
		stock -= cantidad;
		
		System.out.println("El stock que has reducido esta actualmente de la siguiente forma: " + stock);
	}
	
	
	public boolean unidadesDisponibles() {
		return stock > 0;
	}
	
	
	@Override
	public String toString() {
		return "Videojuego \n" +
		       "ID: " + id + "\n" +
		       "Título: " + tittle + "\n" +
		       "Género: " + genre + "\n" +
		       "Precio: " + price + " \n" +
		       "Stock: " + stock + " unidades";
	}
}
