package com.Integrador2.ds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.Integrador2.bo.MyException;
import com.Integrador2.bo.Producto;
import com.Integrador2.dao.IOperacionesDB;

public class OperacionesProducto implements IOperacionesDB {
	
	String sql;
	Scanner entrada = new Scanner(System.in);

	public void add() throws MyException {

		PreparedStatement stmt = null;
		Connection conexion = ConectionDB.conectar();

		try {

			System.out.println("Especificar producto");
			String nombre = entrada.nextLine();
			if (nombre.isEmpty())
				throw new MyException("Casilla de nombre vacía");

			System.out.println("Ingresar descripción");
			String des = entrada.nextLine();
			if (des.isEmpty())
				throw new MyException("Descripción vacía");

			System.out.println("Ingresar precio: ");
			int precio = entrada.nextInt();
			if (precio <= 0)
				throw new MyException("Precio negativo");

			System.out.println("Ingresar stock");
			int stock = entrada.nextInt();
			if (stock <= 0)
				throw new MyException("Stock negativo");

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
				System.out.println("Error al cerrar" + e.getMessage());
			}
		}

	}

	@Override
	public void remove() {
		PreparedStatement stmt = null;
		Connection conexion = ConectionDB.conectar();
		try {

			System.out.println("Ingresar ID a eliminar:");
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
			System.out.println("Producto eliminado");
			try {
				// cerrando conexion
				if (stmt != null) {
					stmt.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar" + e.getMessage());
			}
		}

	}

	@Override
	public void modify() {
		PreparedStatement stmt = null;
		Connection conexion = ConectionDB.conectar();

		try {
			// pedimos id del producto
			System.out.println("Ingresar código:");
			int codigo = entrada.nextInt();

			System.out.println("1-Modificar Stock. \n 2-Modificar precio");
			int operacion = entrada.nextInt();

			if (operacion == 1) {
				try {
				
					sql = "UPDATE productos set stock = (?) where codigo = (?);";
				
					System.out.println("Ingrese nuevo stock:");

					
					stmt = conexion.prepareStatement(sql);
					stmt.setInt(1, entrada.nextInt());
					stmt.setInt(2, codigo);

					stmt.execute();
					System.out.println("Se modifico stock \n");

				} catch (Exception e) {
					
					System.out.println("Error al intentar modificar Stock. " + e.getMessage());
				} finally {
					try {
					
						if (stmt != null) {
							stmt.close();
						}
						if (conexion != null) {
							conexion.close();
						}
					} catch (Exception e) {
						System.out.println("Error al cerrar" + e.getMessage());
					}
				}

			} else if (operacion == 2) {
				
				try {
					
					sql = "UPDATE productos set precio = (?) where codigo = (?);";
					stmt = conexion.prepareStatement(sql);
					System.out.println("Ingresar precio");
					int nuevoPrecio = entrada.nextInt();
					if (nuevoPrecio < 0)
						throw new MyException("Valor negativo");


					stmt.setInt(1, nuevoPrecio);
					stmt.setInt(2, codigo);

					stmt.execute();
					System.out.println("Precio modificado. \n");

				} catch (Exception e) {
					
					System.out.println("No se pudo modificar " + e.getMessage());
				}
				try {
					
					if (stmt != null) {
						stmt.close();
					}
					if (conexion != null) {
						conexion.close();
					}
				} catch (Exception e) {
					System.out.println("Error al cerrar" + e.getMessage());
				}
				
			} else {
				throw new MyException("Valor incorrecto \n");
			}
		} catch (Exception e) {
			System.out.println("Error al modificar" + e.getMessage());
		} finally {
			System.out.println("Modificado con éxito");
			try {
				// cerrando conexion
				if (stmt != null) {
					stmt.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar" + e.getMessage());
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
			System.out.println("Error de listado");
			System.out.println(e.getMessage());
		} finally {
			System.out.println("\n");
			try {
				
				if (stmt != null) {
					stmt.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar" + e.getMessage());
			}

		}
	}
}
