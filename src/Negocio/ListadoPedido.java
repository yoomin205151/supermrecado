package Negocio;

import java.util.LinkedList;

import UI.Interfaz;
import datos.Pedido;





public class ListadoPedido {
	public static void main(String[] args) {
		
		Interfaz i2 = new Interfaz();
		i2.Login();	
	}

	public LinkedList<Pedido> LlenarListaPedido(){
		
		Pedido pedido = new Pedido();
		
		
		return pedido.LlenarListaPedido();
	}
	
	public boolean remove(Pedido pedido) {
		return pedido.CancelarPedido(pedido); 
}
}
