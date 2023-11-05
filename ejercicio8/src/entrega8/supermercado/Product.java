package entrega8.supermercado;

//SuperClase Abstracta

public abstract class Product {
	
	// ATRIBUTOS
	
	private int price;
	private String name;
	
	
	//CONSTRUCTORES
	
	public Product() {
		
	}
	
	public Product(int price, String name) {
		this.price = price;
		this.name = name;
	}
	

	// SETTERS & GETTERS

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	// TO STRING 
	
	@Override
	public String toString() {
		return " Product [price= " + price + ", name= " + name + "]";
	}
	
	
	
	
	
	
	
	
}
