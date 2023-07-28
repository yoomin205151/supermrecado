package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Producto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class PantallaIngresarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldnombre;
	private JTextField textFieldcantidad;
	private JTextField textFieldprecio;

	/**
	 * Launch the application.
	 */


			public void run() {
				try {
					PantallaIngresarProducto frame = new PantallaIngresarProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public PantallaIngresarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ButtonProducto = new JButton("Agregar");
		ButtonProducto.setForeground(new Color(239, 239, 239));
		ButtonProducto.setBackground(new Color(24, 90, 219));
		ButtonProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto producto = new Producto();
				producto.setNombre(textFieldnombre.getText());
				producto.setCantidad(Integer.parseInt(textFieldcantidad.getText()));
				producto.setPrecio(Double.parseDouble(textFieldprecio.getText()));
				if (producto.guardarProducto(producto)) {
					PantallaExitoProducto exito = new PantallaExitoProducto();
					exito.run();
				} else {
					PantallaFallaProducto falla = new PantallaFallaProducto();
					falla.run();
				}
			}
		});
		ButtonProducto.setBounds(199, 263, 184, 33);
		contentPane.add(ButtonProducto);
		
		textFieldnombre = new JTextField();
		textFieldnombre.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldnombre.setBackground(new Color(239, 239, 239));
		textFieldnombre.setBounds(96, 95, 349, 20);
		contentPane.add(textFieldnombre);
		textFieldnombre.setColumns(10);
		
		textFieldcantidad = new JTextField();
		textFieldcantidad.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldcantidad.setBackground(new Color(239, 239, 239));
		textFieldcantidad.setColumns(10);
		textFieldcantidad.setBounds(94, 151, 351, 20);
		contentPane.add(textFieldcantidad);
		
		textFieldprecio = new JTextField();
		textFieldprecio.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldprecio.setBackground(new Color(239, 239, 239));
		textFieldprecio.setColumns(10);
		textFieldprecio.setBounds(96, 207, 349, 23);
		contentPane.add(textFieldprecio);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese nombre: ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1.setBounds(96, 70, 132, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese cantidad: ");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1_1.setBounds(96, 126, 132, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabelPrecio = new JLabel("Ingrese precio: ");
		lblNewLabelPrecio.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabelPrecio.setForeground(new Color(239, 239, 239));
		lblNewLabelPrecio.setBounds(96, 182, 132, 14);
		contentPane.add(lblNewLabelPrecio);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 46);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Ingrese Producto");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel_2.setForeground(new Color(239, 239, 239));
		lblNewLabel_2.setBounds(213, 328, 163, 16);
		contentPane.add(lblNewLabel_2);
	}
}
