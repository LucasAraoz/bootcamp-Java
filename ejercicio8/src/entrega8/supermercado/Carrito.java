package entrega8.supermercado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Carrito extends Exception{
	
	//SCANNER Y LIST DE PRODUCTOS
	
	Scanner entrada = new Scanner(System.in);
	List<ProductoDeAlmacen> carro = new ArrayList<>();
	
	
	
	//FUNCIONES
	// AGREGAR PRODUCTO CON EXCEPTIONS
	
	public void agregarProducto() throws MyExceptions{
				
				System.out.println("Que estas comprando?");
				String name = entrada.next();
				if(name.isEmpty()) throw new MyExceptions("No puedes comprar algo sin nombre!");
				
				
				System.out.println("Que numero de stock tiene?");
				int stockn = entrada.nextInt();
				if(stockn <= 0) throw new MyExceptions("El stock no puede ser negativo!");
				
				
				
				System.out.println("Cual es su precio?");
				int precio = entrada.nextInt();
				if(precio <= 0) throw new MyExceptions("El precio no puede ser negativo!");
				
				ProductoDeAlmacen NewProduct = new ProductoDeAlmacen(stockn, precio, name);
				carro.add(NewProduct);
				
				
			
		
	}
	
	//VER CANTIDAD DEVUELE NUMERO DE OBJETOS EN LA LISTA
	public int verCantidad() throws MyExceptions{
		
		if(carro.size() <= 0) throw new MyExceptions("Tu carro aun esta vacio! \n");
		else {
		return carro.size();}
	}

	
	//TOTAL ITERA LA LISTA CONSIGUIENDO Y SUMANDO PRECIO A LA VARIABLE TOTAL PARA DESPUES IMPRIMIRLA
	public void total() {
		int total = 0;
				
		for(ProductoDeAlmacen s : carro) {			
			total += s.getPrice();
		}
		System.out.println("Tu total es de: $" + total +"\n");
	}
	//CONTENIDO DEVUELVE UN PRINT DE LOS NOMBRES DE LOS PRODUCTOS Y SU ORDEN
	public void contenido() throws MyExceptions{
		int numdeprod = 0;
		if(carro.size() <= 0) throw new MyExceptions("Tu carro aun esta vacio! \n");
		else {
		System.out.println("Tu carrito se compone de: \n");
		
		for(ProductoDeAlmacen d : carro) {
			numdeprod ++;
		System.out.println(numdeprod + "-" + d.getName());
		}
		}
	}
	
}
