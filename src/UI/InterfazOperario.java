package UI;



import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;


import datos.*;
import Negocio.*;
public class InterfazOperario {

	static ListadoProducto listadoproducto = new ListadoProducto();
	public static void login() {
			
		
			//JOptionPane.showMessageDialog(null,"Bienvenido Operario");
			int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opción correspondiente:\n"
					+ "1-Agregar Producto\n"
					+ "2-Eliminar Producto\n"
					+ "3-Modificar Producto\n"
					+ "4-Salir"));
			
			switch (opcion) {
			case 1: 
				AgregarProducto();		
				break;
			case 2:
				EliminarProducto();
				break;
			case 3:
				ModificarProducto ();
				break;
			case 4:		
				Salir();	
				break;
			
				default: JOptionPane.showMessageDialog(null,"Se eligio una opción incorrecta volver a intentar");
					break;
				}		
 }
			private static void Salir() {
			JOptionPane.showMessageDialog(null,"¡Hasta luego!");
			System.exit(0);
		}
			public static void AgregarProducto() {
				Producto producto = new Producto();
				producto.setNombre(JOptionPane.showInputDialog("Ingrese nombre del producto"));
				producto.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Cantidad")));
				producto.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio")));
				if (producto.guardarProducto(producto)) {
					JOptionPane.showMessageDialog(null, "Se agrego el producto");
					PantallaOperario pantallaoperario = new PantallaOperario();
					pantallaoperario.run();
				} else {
					JOptionPane.showMessageDialog(null, "rayos!");
					PantallaOperario pantallaoperario = new PantallaOperario();
					pantallaoperario.run();
				}
				
			}
			
			public static void EliminarProducto () {
                List<Producto> MostrarProductos = listadoproducto.MostrarProductos();
                String[] ProductosAmostrar = new String[MostrarProductos.size()];
                for (Producto producto : MostrarProductos) {
                    ProductosAmostrar[MostrarProductos.indexOf(producto)] = producto.getNombre();
                }
                String opcion = (String) JOptionPane.showInputDialog(null // para que se muestre centrado
                        , "Lista de productos" // Mensaje de la ventana
                        , "Lista de productos" // Titulo de la ventana
                        , JOptionPane.DEFAULT_OPTION // Icono
                        , null // null para icono defecto de la ventana
                        , ProductosAmostrar // el objeto
                        , ProductosAmostrar[0] // posicion del que va aparecer seleccionado
                );
                if (opcion != null) {
                    JOptionPane.showMessageDialog(null, "La opcion elegida fue: " + opcion);
                    for (Producto producto : MostrarProductos) {
                        if (producto.getNombre().equals(opcion)){
                            if(listadoproducto.remove(producto)) {
                                JOptionPane.showMessageDialog(null, "Producto eliminado con exito");
            					PantallaOperario pantallaoperario = new PantallaOperario();
            					pantallaoperario.run();
                            }else {
                                //JOptionPane.showMessageDialog(null, "Error al eliminar producto");
                                //login();
								PantallaOperario pantallaoperario = new PantallaOperario();
								pantallaoperario.run();
                            }
                        } 
                    }
                }
        }
			
			public static void ModificarProducto () {
				List<Producto> MostrarProductos = listadoproducto.MostrarProductos();

				String[] ProductosAmostrar = new String[MostrarProductos.size()];

				for (Producto producto : MostrarProductos) {
					ProductosAmostrar[MostrarProductos.indexOf(producto)] = producto.getNombre();
				}

				String opcion = (String) JOptionPane.showInputDialog(null // para que se muestre centrado
						, "Lista de productos" // Mensaje de la ventana
						, "Lista de productos" // Titulo de la ventana
						, JOptionPane.DEFAULT_OPTION // Icono
						, null // null para icono defecto de la ventana
						, ProductosAmostrar // el objeto
						, ProductosAmostrar[0] // posicion del que va aparecer seleccionado
				);
				
				if (opcion != null) {
					JOptionPane.showMessageDialog(null, "La opcion elegida fue: " + opcion);
					for (Producto producto : MostrarProductos) {
						if (producto.getNombre().equals(opcion)){
							
							String nombreNuevo = JOptionPane.showInputDialog("Ingrese el nuevo nombre");
							int cantidadNuevo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva cantidad"));
							double precioNuevo = Double.parseDouble(JOptionPane.showInputDialog("Ingrese nuevo precio"));
							producto.setNombre(nombreNuevo);
							producto.setCantidad(cantidadNuevo);
							producto.setPrecio(precioNuevo);
							if(listadoproducto.actualizar(producto)) {
								JOptionPane.showMessageDialog(null, "Producto editado con exito");
								PantallaOperario pantallaoperario = new PantallaOperario();
								pantallaoperario.run();
							}else {
								JOptionPane.showMessageDialog(null, "Error al editar producto");
								PantallaOperario pantallaoperario = new PantallaOperario();
								pantallaoperario.run();
							}
						} 
					}
				}
			}
}