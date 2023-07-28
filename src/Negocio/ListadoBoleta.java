package Negocio;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import UI.Interfaz;
import datos.Boleta;

public class ListadoBoleta {

	public static void main(String[] args) {
		
		
		Interfaz i3 = new Interfaz();
		i3.Login();

	}

	
	
	LinkedList<Boleta> Boleta = new LinkedList<Boleta>();
	

			public boolean add(Boleta boleta) {
		
				
				if(boleta.getCantidad()==0) {
					return false;
				}else {
					Boleta.add(boleta);
					JOptionPane.showMessageDialog(null, boleta);
					return true;
				}
					
				}
	
}
