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



public class Interfazventas {
	static Producto producto = new Producto();
	static ListadoUsuario listadousuario = new ListadoUsuario();
	static ListadoPedido listadopedido = new ListadoPedido();
	static ListadoProducto listadoproducto = new ListadoProducto();
	static Pedido pedido = new Pedido();
	
public static void login() {
		
	//JOptionPane.showMessageDialog(null,"Bienvenido Ventas");
	int opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opción correspondiente:\n"
			+ "1-Armar Pedido\n"
			+ "2-Cancelar Pedido\n"
			+ "3-Ver Stock de Productos\n"
			+ "4-Ver Pedidos\n"
			+ "5-Salir"));
	
	switch (opcion) {
	case 1: 
		CrearPedido();	
		break;
	case 2:
		CancelarPedido ();
		break;
	case 3:
		MostrarProductos();	
		break;
	case 4:
		MostrarPedido();	
		break;
	case 5:		
		Salir();	
		break;
	
		default: JOptionPane.showMessageDialog(null,"Se eligio una opción incorrecta volver a intentar");
			break;
		}
	
	
	}
	public static void MostrarPedido() {
		Pedido pedido = new Pedido();
		
		LinkedList<Pedido> pedidos = pedido.LlenarListaPedido();
		for (Pedido pedido2 : pedidos) {
			System.out.println(pedido2);
		}
		
	}
	public static Object MostrarProductos() {
		List<Producto> productos = producto.MostrarProductos();
		String[] mostrarproductos = new String[productos.size()];
		
		for (Producto producto : productos) {
			mostrarproductos[productos.indexOf(producto)] = producto.getNombre() ;
		}

	String opcion = (String) JOptionPane.showInputDialog(null // para que se muestre centrado
			, "Seleccione el producto" // Mensaje de la ventana
			, "Lista de productos" // Titulo de la ventana
			, JOptionPane.DEFAULT_OPTION // Icono
			, null // null para icono defecto de la ventana
			, mostrarproductos // el objeto
			, mostrarproductos[0] // posicion del que va aparecer seleccionado
	);
	if (opcion != null) {
		//JOptionPane.showMessageDialog(null, "La opcion elegida fue: " + opcion);
		for (Producto producto : productos) {
			if (producto.getNombre().equals(opcion)) {			
				JOptionPane.showMessageDialog(null, producto.toString());
			} else {
				
			}
		}
	}
	return null;
		
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
				PantallaVentas pantallaventas = new PantallaVentas();
				pantallaventas.run();
			} else {
				JOptionPane.showMessageDialog(null, "Error al cancelar el pedido");
				PantallaVentas pantallaventas = new PantallaVentas();
				pantallaventas.run();
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
						PantallaVentas pantallaventas = new PantallaVentas();
						pantallaventas.run();
					
				
				} 
			}
		}

				
	}
	
	

	private static void Salir() {
	//JOptionPane.showMessageDialog(null,"¡Hasta luego!");
	System.exit(0);
}
}
