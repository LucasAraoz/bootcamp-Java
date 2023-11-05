package com.Integrador2.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.Integrador2.bo.Producto;
import com.Integrador2.dao.IOperacionesDB;

public class ConectionDB {

	static Connection c = null;

	// Genera coneccion con almacen en local host y retorna la misma conexion
	public static Connection conectar() {
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost/almacen", "root", "");
			// System.out.println("¡Exito al conectarse con la Base de Datos almacen!");
		} catch (Exception e) {
			System.out.println("Error al conectar con base de datos. " + e.getMessage());
		}
		return c;
	}

}
