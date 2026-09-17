package primeractividad;

public class Customer {
	
	private int id;
	private String name;
	private double balance;
	
	public Customer(int id, String name, double balance) {
		
		if (balance < 0) {
			
			throw new IllegalArgumentException("El saldo no puede ser negativo");
		}
		
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	
	public void añadirSaldo(double cantidad) {
		
		if (cantidad <= 0) {
			
			throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
		}
		
		balance += cantidad;
		
		System.out.println("El saldo se ha añadido correctamente, siendo el saldo actual: " + balance);
	}
	
	
	public void retirarSaldo(double cantidad) {
		
		if (cantidad <= 0) {
			
			throw new IllegalArgumentException("La cantidad a retirar debe ser mayor que cero");
		}
		
		if (balance < cantidad) {
			
			throw new IllegalArgumentException("No hay suficiente saldo para realizarlo");
		}
		
		balance -= cantidad;
		
		System.out.println("Saldo retirado, el saldo actual es: " + balance);
	}
	
	
	public boolean tieneSuficienteSaldo(double cantidad) {
		return balance >= cantidad;
	}
	
	
	@Override
	public String toString() {
		return "Cliente \n" +
		       "ID: " + id + "\n" +
		       "Nombre: " + name + "\n" +
		       "Saldo: " + balance;
	}
}
