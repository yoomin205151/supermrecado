package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import datos.Producto;
import java.awt.Color;

public class PantallaIngresarProductoGerente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldnombre;
	private JTextField textFieldcantidad;
	private JTextField textFieldprecio;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaIngresarProductoGerente frame = new PantallaIngresarProductoGerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public PantallaIngresarProductoGerente() {
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
					PantallaExitoProductoGerente exitoge = new PantallaExitoProductoGerente();
					exitoge.run();
				} else {
					PantallaFallaProducto falla = new PantallaFallaProducto();
					falla.run();
				}
			}
		});
		ButtonProducto.setBounds(206, 262, 179, 35);
		contentPane.add(ButtonProducto);
		
		textFieldnombre = new JTextField();
		textFieldnombre.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldnombre.setBackground(new Color(239, 239, 239));
		textFieldnombre.setBounds(107, 105, 334, 20);
		contentPane.add(textFieldnombre);
		textFieldnombre.setColumns(10);
		
		textFieldcantidad = new JTextField();
		textFieldcantidad.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldcantidad.setBackground(new Color(239, 239, 239));
		textFieldcantidad.setColumns(10);
		textFieldcantidad.setBounds(107, 161, 334, 20);
		contentPane.add(textFieldcantidad);
		
		textFieldprecio = new JTextField();
		textFieldprecio.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldprecio.setBackground(new Color(239, 239, 239));
		textFieldprecio.setColumns(10);
		textFieldprecio.setBounds(107, 217, 334, 20);
		contentPane.add(textFieldprecio);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese nombre: ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1.setBounds(107, 80, 132, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ingrese cantidad:");
		lblNewLabel_1_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(107, 136, 132, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabelPrecio = new JLabel("Ingrese precio:");
		lblNewLabelPrecio.setForeground(new Color(239, 239, 239));
		lblNewLabelPrecio.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabelPrecio.setBounds(107, 192, 132, 14);
		contentPane.add(lblNewLabelPrecio);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 50);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Ingrese Producto");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel_2.setForeground(new Color(239, 239, 239));
		lblNewLabel_2.setBounds(222, 328, 158, 16);
		contentPane.add(lblNewLabel_2);
	}
}
