package entrega8.supermercado;

public class MyExceptions extends Exception{
	private String message;
	
	MyExceptions(String messaje) {
		setMessage(messaje);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
