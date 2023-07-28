package UI;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import Negocio.ListadoPedido;
import Negocio.ListadoProducto;
import Negocio.ListadoUsuario;
import datos.Pedido;
import datos.Producto;
import datos.Usuario;

public class InterfazGerente {

	static ListadoProducto listadoproducto = new ListadoProducto();
	static ListadoUsuario listadousuario = new ListadoUsuario();
	static ListadoPedido listadopedido = new ListadoPedido();
	public static void login() {
		
		//JOptionPane.showMessageDialog(null,"Bienvenido Gerente");
		int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opción correspondiente:\n"
				+ "1-Agregar Producto\n"
				+ "2-Eliminar Producto\n"
				+ "3-Modificar Producto\n"
				+ "4-Eliminar Usuario\n"
				+ "5-Modificar Permiso Uusario\n"
				+ "6-Armar Pedido\n"
				+ "7-Cancelar Pedido\n"
				+ "8-Salir"));
		
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
			EliminarUsuario ();
			break;
		case 5:
			ModificarPermisoUsuario ();
			break;
		case 6:
			CrearPedido();
			break;
		case 7:
			CancelarPedido ();
			break;
		case 8:		
			Salir();	
			break;
		
			default: JOptionPane.showMessageDialog(null,"Se eligio una opción incorrecta volver a intentar");
				break;
			}
 }
	public static void Salir() {
		//JOptionPane.showMessageDialog(null,"¡Hasta luego!");
		System.exit(0);
	}
		public static void AgregarProducto() {
			Producto producto = new Producto();
			producto.setNombre(JOptionPane.showInputDialog("Ingrese nombre del producto"));
			producto.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese Cantidad")));
			producto.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio")));
			if (producto.guardarProducto(producto)) {
				JOptionPane.showMessageDialog(null, "Se agrego el producto");
				//login();
				PantallaGerente pantallagerente = new PantallaGerente();
				pantallagerente.run();
			} else {
				JOptionPane.showMessageDialog(null, "rayos!");
				PantallaGerente pantallagerente = new PantallaGerente();
				pantallagerente.run();
			}
			
		}
		
		public static void CancelarPedido () {	
			LinkedList<Pedido> MostrarPedido = listadopedido.LlenarListaPedido();
			int[] PedidosAmostrar = new int[MostrarPedido.size()];
			for (Pedido pedido : MostrarPedido) {
				PedidosAmostrar[MostrarPedido.indexOf(pedido)] = pedido.getNro_pedido();
			}	
			int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nro de pedido cual desea borrar"));
			for (Pedido pedido : MostrarPedido) {
			if (opcion == pedido.getNro_pedido()) {		
				if (listadopedido.remove(pedido)) {
					JOptionPane.showMessageDialog(null, "Pedido canceclado con exito");
					PantallaGerente pantallagerente = new PantallaGerente();
					pantallagerente.run();
				} else {
					JOptionPane.showMessageDialog(null, "Error al cancelar el pedido");
					PantallaGerente pantallagerente = new PantallaGerente();
					pantallagerente.run();
				}
				
			
			}
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
							//login();
							PantallaGerente pantallagerente = new PantallaGerente();
							pantallagerente.run();
						}else {
							//JOptionPane.showMessageDialog(null, "Error al eliminar producto");
							//login();
							
						}
					} 
				}
			}
	}
		
		public static void CrearPedido() {
			Usuario usuario  = new Usuario();
			Producto producto = new Producto();	
			List<Producto> productos = producto.MostrarProductos();
			String[] mostrarproductos = new String[productos.size()];
			LinkedList<Usuario> usuario1 = listadousuario.LlenarListaUsuarioNivel();
			String[] UsuariosMostrar = new String[usuario1.size()];
			for (Usuario usuarios : usuario1) {
				UsuariosMostrar[usuario1.indexOf(usuarios)] = usuarios.getNombre();
			}
			JOptionPane.showMessageDialog(null, "Seleccione usuario con el que va a crear el pedido");
			String opcion = (String) JOptionPane.showInputDialog(null // para que se muestre centrado
					, "Lista de usuarios" // Mensaje de la ventana
					, "Lista de usuarios" // Titulo de la ventana
					, JOptionPane.DEFAULT_OPTION // Icono
					, null // null para icono defecto de la ventana
					, UsuariosMostrar // el objeto
					, UsuariosMostrar[0] // posicion del que va aparecer seleccionado
			);
			if (opcion != null) {
				JOptionPane.showMessageDialog(null, "La opcion elegida fue: " + opcion);
				for (Usuario usuarios : usuario1) {
					if (usuarios.getNombre().equals(opcion)){
						int nro_pedido=Integer.parseInt(JOptionPane.showInputDialog("Ingrese nro de pedido"));
						int repetir1;
						do {
							for (Producto producto1 : productos) {
								mostrarproductos[productos.indexOf(producto1)] =producto1.getNombre() ;
							}

							String opcion1 = (String) JOptionPane.showInputDialog(null // para que se muestre centrado
									, "Seleccione el producto" // Mensaje de la ventana
									, "Lista de productos" // Titulo de la ventana
									, JOptionPane.DEFAULT_OPTION // Icono
									, null // null para icono defecto de la ventana
									, mostrarproductos // el objeto
									, mostrarproductos[0] // posicion del que va aparecer seleccionado
							);
							if (opcion1!=null) {
								JOptionPane.showMessageDialog(null, opcion1);
								for (Producto producto1 : productos) {			
									if (producto1.getNombre().equals(opcion1)) {
										
										int cantidad=Integer.parseInt(JOptionPane.showInputDialog("Cantidad en Stock: " + producto1.getCantidad()+"\nIngrese cantidad"));
										if (cantidad<=producto1.getCantidad()) {
											double precio=producto1.getPrecio()*cantidad;								
											usuario.crearPedido(usuarios,producto1,nro_pedido,cantidad,precio);
											producto1.setCantidad(producto1.getCantidad()-cantidad);
											listadoproducto.actualizar(producto1);
										} else {
											JOptionPane.showMessageDialog(null, "No hay suficiente en Stock");
										}				
									}
								}
								
							}
							repetir1=Integer.parseInt(JOptionPane.showInputDialog("Desesa agregar mas productos? \n1 para agregar \n2 para salir"));
						} while (repetir1==1);
							JOptionPane.showMessageDialog(null, "Pedido Finalizado");
							//login();
							PantallaGerente pantallagerente = new PantallaGerente();
							pantallagerente.run();
						
					
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
							//login();
							PantallaGerente pantallagerente = new PantallaGerente();
							pantallagerente.run();
						}else {
							JOptionPane.showMessageDialog(null, "Error al editar producto");
							//login();
							PantallaGerente pantallagerente = new PantallaGerente();
							pantallagerente.run();
						}
					} 
				}
			}
		}
		
		public static void EliminarUsuario () {
			LinkedList<Usuario> usuario = listadousuario.LlenarListaUsuario();
			String[] UsuariosMostrar = new String[usuario.size()];
			for (Usuario usuarios : usuario) {
				UsuariosMostrar[usuario.indexOf(usuarios)] = usuarios.getNombre();
			}
			String opcion = (String) JOptionPane.showInputDialog(null // para que se muestre centrado
					, "Lista de usuarios" // Mensaje de la ventana
					, "Lista de usuarios" // Titulo de la ventana
					, JOptionPane.DEFAULT_OPTION // Icono
					, null // null para icono defecto de la ventana
					, UsuariosMostrar // el objeto
					, UsuariosMostrar[0] // posicion del que va aparecer seleccionado
			);
			if (opcion != null) {
				JOptionPane.showMessageDialog(null, "La opcion elegida fue: " + opcion);
				for (Usuario usuarios : usuario) {
					if (usuarios.getNombre().equals(opcion)){
						if(listadousuario.remove(usuarios)) {
							JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
							//login();
							PantallaGerente pantallagerente = new PantallaGerente();
							pantallagerente.run();
						}else {
							JOptionPane.showMessageDialog(null, "Error al eliminar usuario");
							//login();
							PantallaGerente pantallagerente = new PantallaGerente();
							pantallagerente.run();
						}
					} 
				}
			}
	}
		
		public static void ModificarPermisoUsuario () {
			LinkedList<Usuario> usuario = listadousuario.LlenarListaUsuario();
			String[] UsuariosMostrar = new String[usuario.size()];
			for (Usuario usuarios : usuario) {
				UsuariosMostrar[usuario.indexOf(usuarios)] = usuarios.getNombre();
			}
			String opcion = (String) JOptionPane.showInputDialog(null // para que se muestre centrado
					, "Lista de usuarios" // Mensaje de la ventana
					, "Lista de usuarios" // Titulo de la ventana
					, JOptionPane.DEFAULT_OPTION // Icono
					, null // null para icono defecto de la ventana
					, UsuariosMostrar // el objeto
					, UsuariosMostrar[0] // posicion del que va aparecer seleccionado
			);
			if (opcion != null) {
				JOptionPane.showMessageDialog(null, "La opcion elegida fue: " + opcion);
				for (Usuario usuarios : usuario) {
					if (usuarios.getNombre().equals(opcion)){
						
						int nivelNuevo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo nivel de permisos"));
						usuarios.setNivel(nivelNuevo);
						
						if(listadousuario.actualizar(usuarios)) {
							JOptionPane.showMessageDialog(null, "Usuario modificado con exito");
							//login();
							PantallaGerente pantallagerente = new PantallaGerente();
							pantallagerente.run();
						}else {
							JOptionPane.showMessageDialog(null, "Error al modificar usuario");
							//login();
							PantallaGerente pantallagerente = new PantallaGerente();
							pantallagerente.run();
						}
					} 
				}
			}
	}
}
