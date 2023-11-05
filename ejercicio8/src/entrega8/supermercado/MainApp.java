package entrega8.supermercado;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws MyExceptions {

		// ATRIBUTOS

		// Producto inicial
		ProductoDeAlmacen Coca = new ProductoDeAlmacen(123, 400, "Coca-Cola");

		// Objeto que hace de mediador entre clases
		Carrito chango = new Carrito();

		chango.carro.add(Coca);

		Scanner entrada = new Scanner(System.in);
		int opcionelegida = 0;

		// MENU
		do {
			System.out.println(
					"Bienvenido a tu lista de compras!. \n" + "\nIngresa un numero del 1 al 5 para elegir la opcion.");
			System.out.println("1-Agregar producto al carrito.");
			System.out.println("2-Ver cantidad de productos.");
			System.out.println("3-Importe total.");
			System.out.println("4-Contenido.");
			System.out.println("5-Salir.");

			
			//Evitar valor incorrecto en menu
			try {

				opcionelegida = entrada.nextInt();
				
				if (opcionelegida < 1 || opcionelegida > 5) {
					System.out.println("Ingrese un valor del 1 al 5");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			// EXIT
			if (opcionelegida == 5) {
				System.out.println("Gracias por tu compra!");
				break;
			}

			switch (opcionelegida) {
			// agregar
			case 1:
				chango.agregarProducto();
				break;

			// OPCION 2 ANTICIPANDO ERROR DE CARRO VACIO
			case 2:

				try {
					if (chango.verCantidad() <= 0) {
						System.out.println("Tu carro esta vacio actualmente");
					} else {
						chango.verCantidad();
					}
				} catch (MyExceptions e) {
					System.out.println(e.getMessage());
				}
				break;

			// VER MONTO TOTAL
			case 3:
				chango.total();
				break;

			// VER CONTENIDO, ANTICIPANDO EL CARRO VACIO
			case 4:
				try {
					if (chango.verCantidad() <= 0) {
						System.out.println("Tu carro esta vacio actualmente");
					} else {
						chango.contenido();
					}
				} catch (MyExceptions e) {
					System.out.println(e.getMessage());
				}
				break;
			}

		} while (opcionelegida != 5);

	}
}
