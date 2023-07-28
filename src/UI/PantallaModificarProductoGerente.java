package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.ListadoProducto;
import datos.Producto;
import java.awt.Color;

public class PantallaModificarProductoGerente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldnombre;
	private JTextField textFieldcantidad;
	private JTextField textFieldprecio;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaModificarProductoGerente frame = new PantallaModificarProductoGerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	

	/**
	 * Create the frame.
	 */
	public PantallaModificarProductoGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListadoProducto listadoproducto = new ListadoProducto();
		List<Producto> MostrarProductos = listadoproducto.MostrarProductos();
		String[] ProductosAmostrar = new String[MostrarProductos.size()];
		for (Producto producto : MostrarProductos) {
			ProductosAmostrar[MostrarProductos.indexOf(producto)] = producto.getNombre();}
		JComboBox comboBoxProducto = new JComboBox(ProductosAmostrar);
		comboBoxProducto.setBackground(new Color(239, 239, 239));
		comboBoxProducto.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboBoxProducto.setBounds(80, 95, 417, 22);
		contentPane.add(comboBoxProducto);
		
		JButton btnNewButtonmodificar = new JButton("Modificar");
		btnNewButtonmodificar.setForeground(new Color(239, 239, 239));
		btnNewButtonmodificar.setBackground(new Color(24, 90, 219));
		btnNewButtonmodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				if (comboBoxProducto.getSelectedItem() != null) {
					//JOptionPane.showMessageDialog(null, "La opcion elegida fue: " + comboBoxProducto.getSelectedItem());
					for (Producto producto : MostrarProductos) {
						if (producto.getNombre().equals(comboBoxProducto.getSelectedItem())){
							
							String nombreNuevo = textFieldnombre.getText();
							int cantidadNuevo = Integer.parseInt(textFieldcantidad.getText());
							double precioNuevo = Double.parseDouble(textFieldprecio.getText());
							producto.setNombre(nombreNuevo);
							producto.setCantidad(cantidadNuevo);
							producto.setPrecio(precioNuevo);
							if(listadoproducto.actualizar(producto)) {
								ExitoModificarProdGerente exito = new ExitoModificarProdGerente();
								exito.run();
							}else {
								PantallaErrorModificarProducto error = new PantallaErrorModificarProducto();
								error.run();
							}
						} 
					}
				}
			}
		});
		btnNewButtonmodificar.setBounds(203, 279, 185, 32);
		contentPane.add(btnNewButtonmodificar);
		

		
		textFieldnombre = new JTextField();
		textFieldnombre.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldnombre.setBackground(new Color(239, 239, 239));
		textFieldnombre.setBounds(80, 147, 417, 20);
		contentPane.add(textFieldnombre);
		textFieldnombre.setColumns(10);
		
		textFieldcantidad = new JTextField();
		textFieldcantidad.setColumns(10);
		textFieldcantidad.setBounds(80, 195, 417, 20);
		contentPane.add(textFieldcantidad);
		
		textFieldprecio = new JTextField();
		textFieldprecio.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldprecio.setBackground(new Color(239, 239, 239));
		textFieldprecio.setColumns(10);
		textFieldprecio.setBounds(80, 244, 417, 20);
		contentPane.add(textFieldprecio);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese nombre:");
		lblNewLabel_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(80, 128, 133, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese cantidad:");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1_1.setBounds(80, 178, 133, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ingrese precio:");
		lblNewLabel_1_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1_1_1.setBackground(new Color(239, 239, 239));
		lblNewLabel_1_1_1.setBounds(80, 226, 133, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 50);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Modifique su producto");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione un producto: ");
		lblNewLabel_2.setForeground(new Color(239, 239, 239));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(80, 73, 171, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel_3.setForeground(new Color(239, 239, 239));
		lblNewLabel_3.setBounds(224, 328, 164, 16);
		contentPane.add(lblNewLabel_3);
		
		
	}
}
