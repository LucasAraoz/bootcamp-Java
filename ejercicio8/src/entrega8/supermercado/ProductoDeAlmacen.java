package entrega8.supermercado;


//SUBCLASE

public class ProductoDeAlmacen extends Product implements Iva {

	// Atributos
	private int stockNum;
	
	//Constructor
	
	public ProductoDeAlmacen() {}

	public ProductoDeAlmacen(int stockNum, int price, String name) {
		super(price, name);
		this.stockNum = stockNum;
		
	}
	
	
	@Override
	public double calculateIva() {
		double ivaCalc = getPrice() * IVA;
		return ivaCalc;
	}
		// GETTERS & SETTERS
	public int getStockNum() {
		return stockNum;
	}

	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	
	
	//TOSTRING
	@Override
	public String toString() {
		return "ProductoDeAlmacen [StockNum= " + stockNum + "\n" + super.toString() + "]";
	}
	
	
	
	
	
	
	

}
