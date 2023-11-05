package ej2;
import java.util.Scanner;
public class Calculadora {
	public static void main(String[] arg) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Ingrese 2 valores y una operacion.");
		int vA = entrada.nextInt();
		int vB = entrada.nextInt();
		System.out.println("Eliga la operacion: SUM, REST, MUL, DIV");
		String op = entrada.next().toUpperCase();
		
		
		if(op.equals("SUM")) {
			Operaciones.suma(vA, vB);
		} else if (op.equals("REST")) {
			Operaciones.resta(vA, vB);
		} else if (op.equals("MUL")) {
			Operaciones.multiplicar(vA, vB);
		} else if(op.equals("DIV")) {
			Operaciones.division(vA, vB);
		} else {
			System.out.println("Debes elegir una operacion correcta e ingresar 2 valores.");
		}
		
	}
	
}
