package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.ListadoProducto;
import Negocio.ListadoUsuario;
import datos.Producto;
import datos.Usuario;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class PantallaCrearPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCantidad;
	private JTextField textFieldticket;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaCrearPedido frame = new PantallaCrearPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Create the frame.
	 */
	public PantallaCrearPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Producto producto = new Producto();	
		List<Producto> productos = producto.MostrarProductos();
		String[] mostrarproductos = new String[productos.size()];
		for (Producto producto1 : productos) {
			mostrarproductos[productos.indexOf(producto1)] =producto1.getNombre() ;
		}
		JComboBox comboBoxProducto = new JComboBox(mostrarproductos);
		comboBoxProducto.setBackground(new Color(239, 239, 239));
		comboBoxProducto.setBounds(33, 180, 408, 22);
		contentPane.add(comboBoxProducto);
		
		ListadoUsuario listadousuario = new ListadoUsuario();
		Usuario usuario  = new Usuario();
		LinkedList<Usuario> usuario1 = listadousuario.LlenarListaUsuarioNivel();
		String[] UsuariosMostrar = new String[usuario1.size()];
		for (Usuario usuarios : usuario1) {
			UsuariosMostrar[usuario1.indexOf(usuarios)] = usuarios.getNombre();
		}
		JComboBox comboBoxUsuario = new JComboBox(UsuariosMostrar);
		comboBoxUsuario.setBackground(new Color(239, 239, 239));
		comboBoxUsuario.setBounds(33, 133, 408, 22);
		contentPane.add(comboBoxUsuario);
		
		JButton btnNewButtonCrear = new JButton("Crear");
		btnNewButtonCrear.setForeground(new Color(239, 239, 239));
		btnNewButtonCrear.setBackground(new Color(24, 90, 219));
		btnNewButtonCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoProducto listadoproducto = new ListadoProducto();
				if (comboBoxUsuario.getSelectedItem() != null) {
					System.out.println(comboBoxUsuario.getSelectedItem());
					//JOptionPane.showMessageDialog(null, "La opcion elegida fue: " + comboBoxUsuario.getAction());
					for (Usuario usuarios : usuario1) {
						if (usuarios.getNombre().equals(comboBoxUsuario.getSelectedItem())){
							int nro_pedido=Integer.parseInt(textFieldticket.getText());													
								for (Producto producto1 : productos) {
									mostrarproductos[productos.indexOf(producto1)] =producto1.getNombre() ;
								}
								if (comboBoxProducto.getSelectedItem()!=null) {
									System.out.println(comboBoxProducto.getSelectedItem());
									//JOptionPane.showMessageDialog(null, comboBoxProducto.getSelectedItem());
									for (Producto producto1 : productos) {			
										if (producto1.getNombre().equals(comboBoxProducto.getSelectedItem())) {
											
											int cantidad=Integer.parseInt(textFieldCantidad.getText());
											if (cantidad<=producto1.getCantidad()) {
												double precio=producto1.getPrecio()*cantidad;								
												usuario.crearPedido(usuarios,producto1,nro_pedido,cantidad,precio);
												producto1.setCantidad(producto1.getCantidad()-cantidad);
												listadoproducto.actualizar(producto1);
												//JOptionPane.showMessageDialog(null, "Pedido Agregado");
												PantallaPedidoExito pantallaexito = new PantallaPedidoExito();
												pantallaexito.run();
												
											} else {
												JOptionPane.showMessageDialog(null, "No hay suficiente en Stock");
											}				
										}
									}	
								}				
						} 
					}
				}				
				PantallaVentas pantallaventas = new PantallaVentas();
				pantallaventas.run();
			}
		});
		btnNewButtonCrear.setBounds(202, 270, 175, 33);
		contentPane.add(btnNewButtonCrear);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBackground(new Color(239, 239, 239));
		textFieldCantidad.setBounds(33, 228, 408, 20);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		
		JLabel lblNewLabelCantidad = new JLabel("Cantidad");
		lblNewLabelCantidad.setForeground(new Color(239, 239, 239));
		lblNewLabelCantidad.setBounds(33, 213, 209, 14);
		contentPane.add(lblNewLabelCantidad);
		
		textFieldticket = new JTextField();
		textFieldticket.setBackground(new Color(239, 239, 239));
		textFieldticket.setColumns(10);
		textFieldticket.setBounds(33, 89, 408, 20);
		contentPane.add(textFieldticket);
		
		JLabel lblNewLabelticker = new JLabel("Nro Ticket");
		lblNewLabelticker.setForeground(new Color(239, 239, 239));
		lblNewLabelticker.setBounds(33, 74, 209, 14);
		contentPane.add(lblNewLabelticker);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(239, 239, 239));
		lblUsuario.setBounds(33, 120, 209, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setForeground(new Color(239, 239, 239));
		lblProducto.setBounds(33, 166, 209, 14);
		contentPane.add(lblProducto);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 49);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Seleccione el producto");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1.setBackground(new Color(10, 25, 49));
		lblNewLabel_1.setBounds(218, 328, 165, 16);
		contentPane.add(lblNewLabel_1);
	}
}
