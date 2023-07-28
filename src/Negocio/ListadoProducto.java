package Negocio;



import java.util.List;

import datos.*;

import UI.*;

public class ListadoProducto {
	

	public static void main(String[] args) {
				
		//Interfaz i2 = new Interfaz();
		//i2.Login();	
		pantalla1 pantalla = new pantalla1();
		pantalla.run();
	}
	

	public boolean add(Producto productos) {
		Producto producto = new Producto();
		char [] data = productos.getNombre().toCharArray();
				
		if(data.length >= 3 && data.length <= 60 ) {
			int cantidad = productos.getCantidad();
			if(cantidad >= 1) {
				int id_stock = productos.getId_producto();				
				if(id_stock > 0) {					
					double precio = productos.getPrecio();
					if (precio > 0) {					
					return	producto.guardarProducto(productos);
					}						
						}
					}
				}								
		return false;
			}
	
	public boolean actualizar(Producto productos) {
		Producto producto = new Producto();
		char [] data = productos.getNombre().toCharArray();
				
		if(data.length >= 3 && data.length <= 60 ) {
			int cantidad = productos.getCantidad();
			if(cantidad >= 1) {
				int id_stock = productos.getId_producto();				
				if(id_stock > 0) {					
					double precio = productos.getPrecio();
					if (precio > 0) {					
					return	producto.ActualizarProducto(productos);
					}						
						}
					}
				}								
		return false;
			}
	
	public boolean remove(Producto producto) {
		return producto.EliminarProducto(producto); 
}
	
	public List<Producto> MostrarProductos(){
		
		Producto producto = new Producto();
		
		
		return producto.MostrarProductos();
	}
}
			

		
		
