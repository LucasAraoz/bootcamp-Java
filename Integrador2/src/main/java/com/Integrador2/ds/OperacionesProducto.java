package com.Integrador2.ds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Integrador2.bo.MyException;
import com.Integrador2.bo.Producto;
import com.Integrador2.dao.IOperacionesDB;

public class OperacionesProducto implements IOperacionesDB {
	// Operaciones con base de datos

	// Variables que se van a usar en la implementacion
	String sql;
	Scanner entrada = new Scanner(System.in);

	public void add() throws MyException {

		PreparedStatement stmt = null;
		Connection conexion = ConectionDB.conectar();

		try {

			System.out.println("Especifique el Nombre del producto: ");
			String nombre = entrada.nextLine();
			if (nombre.isEmpty())
				throw new MyException("No puedes agregar un nombre en blanco!");

			System.out.println("Ingrese una descripcion del mismo: ");
			String des = entrada.nextLine();
			if (des.isEmpty())
				throw new MyException("No puedes dejar la descripcion vacia!");

			System.out.println("Ingrese el precio: ");
			int precio = entrada.nextInt();
			if (precio <= 0)
				throw new MyException("El Precio no puede ser negativo!");

			System.out.println("Ingrese Stock actual: ");
			int stock = entrada.nextInt();
			if (stock <= 0)
				throw new MyException("El Stock no puede ser negativo!");

			Producto nuevoProducto = new Producto(nombre, des, precio, stock);

			// seteamos el sql para insert
			sql = "INSERT INTO productos (nombre, descripcion, precio, stock) values (?,?,?,?);";

			// preparamos el statement
			stmt = conexion.prepareStatement(sql);

			// insertamos datos

			stmt.setString(1, nuevoProducto.getNombre());
			stmt.setString(2, nuevoProducto.getDescripcion());
			stmt.setDouble(3, nuevoProducto.getPrecio());
			stmt.setInt(4, nuevoProducto.getStock());

			// ejecutamos el statement completo
			System.err.println("Se ejecuta query");
			stmt.execute();

			// manejo de excepcion

		} catch (MyException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			System.out.println("Fin proceso \n");
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e) {
				System.out.println("Error cerrando base de datos. " + e.getMessage());
			}
		}

	}

	@Override
	public void remove() {
		PreparedStatement stmt = null;
		Connection conexion = ConectionDB.conectar();
		try {

			System.out.println("Ingrese el id del producto a eliminar:");
			int id = entrada.nextInt();
			// seteamos el sql para insert
			sql = "delete from productos where codigo = ?;";
			// preparamos el statement
			stmt = conexion.prepareStatement(sql);

			// seteamos el id
			stmt.setInt(1, id);

			stmt.execute();

		} catch (Exception e) {
			System.out.println("Error en Delete " + e.getMessage());
		} finally {
			System.out.println("Exito al eliminar producto!");
			try {
				// cerrando conexion
				if (stmt != null) {
					stmt.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e) {
				System.out.println("Error cerrando base de datos. " + e.getMessage());
			}
		}

	}

	@Override
	public void modify() {
		PreparedStatement stmt = null;
		Connection conexion = ConectionDB.conectar();

		try {
			// pedimos id del producto
			System.out.println("Ingrese el codigo del producto a modificar:");
			int codigo = entrada.nextInt();

			System.out.println("1-Modificar Stock. \n 2-Modificar precio");
			int operacion = entrada.nextInt();

			if (operacion == 1) {
				try {
					// Query de nuevo stock
					sql = "UPDATE productos set stock = (?) where codigo = (?);";
					// pedimos nuevo stock
					System.out.println("Ingrese nuevo stock:");

					// PreparedStatement del stock y codigo
					stmt = conexion.prepareStatement(sql);
					stmt.setInt(1, entrada.nextInt());
					stmt.setInt(2, codigo);

					stmt.execute();
					System.out.println("Se modifico stock \n");

				} catch (Exception e) {
					// Exception no esperada
					System.out.println("Error al intentar modificar Stock. " + e.getMessage());
				} finally {
					try {
						// cerrando conexion
						if (stmt != null) {
							stmt.close();
						}
						if (conexion != null) {
							conexion.close();
						}
					} catch (Exception e) {
						System.out.println("Error cerrando base de datos. " + e.getMessage());
					}
				}

			} else if (operacion == 2) {
				// Modificacion precio
				try {
					// Query de modificar precio
					sql = "UPDATE productos set precio = (?) where codigo = (?);";
					stmt = conexion.prepareStatement(sql);
					System.out.println("Ingrese nuevo precio:");
					int nuevoPrecio = entrada.nextInt();
					if (nuevoPrecio < 0)
						throw new MyException("No puedes asignar valor negativo a los productos!");

					// PreparedStatement con sets de precio y codigo

					stmt.setInt(1, nuevoPrecio);
					stmt.setInt(2, codigo);

					stmt.execute();
					System.out.println("Se modifico precio. \n");

				} catch (Exception e) {
					// Exception por si ocurre un error con el query
					System.out.println("Error al intentar modificar precio. " + e.getMessage());
				}
				try {
					// cerrando conexion
					if (stmt != null) {
						stmt.close();
					}
					if (conexion != null) {
						conexion.close();
					}
				} catch (Exception e) {
					System.out.println("Error cerrando base de datos. " + e.getMessage());
				}
				// excepcion por si se ingresa valor incorrecto
			} else {
				throw new MyException("Porfavor ingrese un valor numerico acorde a las opciones. \n");
			}
		} catch (Exception e) {
			System.out.println("Error en modify " + e.getMessage());
		} finally {
			System.out.println("Exito al modificar producto!");
			try {
				// cerrando conexion
				if (stmt != null) {
					stmt.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e) {
				System.out.println("Error cerrando base de datos. " + e.getMessage());
			}
		}
	}

	@Override
	public void list() {
		PreparedStatement stmt = null;
		Connection conexion = ConectionDB.conectar();
		try {
			sql = "select *from productos";
			stmt = conexion.prepareStatement(sql);

			ResultSet datos = stmt.executeQuery(sql);

			while (datos.next()) {
				System.out.println("");
				System.out.println("Codigo: " + datos.getInt("codigo"));
				System.out.println("Nombre: " + datos.getString("nombre"));
				System.out.println("Descripcion: " + datos.getString("descripcion"));
				System.out.println("Precio: " + datos.getInt("precio"));
				System.out.println("Stock: " + datos.getInt("stock") + "\n");
				
			}

		} catch (Exception e) {
			System.out.println("No fue posible listar");
			System.out.println(e.getMessage());
		} finally {
			System.out.println("\n");
			try {
				// cerrando conexion
				if (stmt != null) {
					stmt.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e) {
				System.out.println("Error cerrando base de datos. " + e.getMessage());
			}

		}
	}
}
