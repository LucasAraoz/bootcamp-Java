package com.Integrador2.to;

import java.util.Scanner;

import com.Integrador2.bo.MyException;
import com.Integrador2.bo.Producto;
import com.Integrador2.ds.ConectionDB;
import com.Integrador2.ds.OperacionesProducto;

public class MainApp {
	public static void main(String[] args) throws MyException {

		Scanner entrada = new Scanner(System.in);

		Producto p = new Producto("prueba", "descripcion", 13, 10);

		OperacionesProducto op = new OperacionesProducto();

		int opcionElegida = 0;
		
		System.out.println("-------Bienvenido al menu de administracion.------ \n");
		do {
			System.out.println("Ingrese un numero de operacion:");
			System.out.println("1-Añadir nuevo producto.");
			System.out.println("2-Borrar producto ya existente.");
			System.out.println("3-Modificar Precio o Stock.");
			System.out.println("4-Lista.");
			System.out.println("5-Salir.");

			// Evitamos valor incorrecto en menu
			try {
				opcionElegida = entrada.nextInt();
				if (opcionElegida < 1 || opcionElegida > 5) {
					System.err.println("Ingrese un valor del 1 al 5");

				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			// Salir del menu
			if (opcionElegida == 5) {
				System.out.println("Cerrando programa!");
				break;
			}

			// opciones

			switch (opcionElegida) {

			// Agregar
			case 1:

				op.add();

				break;
			// Borrar
			case 2:

				op.remove();

				break;
			// Modificar

			case 3:

				op.modify();

				break;

			// Listado
			case 4:

				op.list();
				break;
			}

		} while (opcionElegida != 5);

	}
}
