package com.Integrador2.bo;

//SUPERCLASE
public class Producto {
	// ATRIBUTOS

	private String nombre;
	private String descripcion;
	private int precio;
	private int stock;

	// METODOS
	// CONSTRUCTOR CON Y SIN SOBRECARGA
	public Producto() {

	}

	public Producto(String nombre, String descripcion, int precio, int stock) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	// SETTERS Y GETTERS

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	// ToString
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock
				+ "]";
	}

}
