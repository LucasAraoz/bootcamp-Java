package ej1;

import java.lang.reflect.Parameter;

 
public class Jsonify {
	
	private String[] valores;
	
	//sobreescribi tostring con una clase llamada stringbuilder 
	//permite anidar cada vez mas strings sin sobreescribirlo
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		String resultado = "";
		build.append("{\"data\":[");
		for(int i = 0; i < valores.length; i++) {
			build.append("\"" + valores[i] + "\"");
			if(i < valores.length -1) {
				build.append(",");
			}
		}
		build.append("]}");
		resultado = build.toString();
		return resultado;
	}
	
	public Jsonify(String[] valores) {
		this.valores = valores;
	}
	
	public static void main(String[] args) {
		
			String[] y = args;
		
			Jsonify jsonify = new Jsonify(y);					
			
			System.out.println( jsonify.toString());
		
		
	}

	

	
	
	
	

}
