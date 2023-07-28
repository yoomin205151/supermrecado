package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaOperario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					PantallaOperario frame = new PantallaOperario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}		
	}

	/**
	 * Create the frame.
	 */
	public PantallaOperario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewProducto = new JButton("Agregar Producto");
		btnNewProducto.setForeground(new Color(239, 239, 239));
		btnNewProducto.setBackground(new Color(24, 90, 219));
		btnNewProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaIngresarProducto producto = new PantallaIngresarProducto();
				producto.run();
			}
		});
		btnNewProducto.setBounds(55, 111, 203, 32);
		contentPane.add(btnNewProducto);
		
		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setForeground(new Color(239, 239, 239));
		btnEliminarProducto.setBackground(new Color(24, 90, 219));
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaEliminarProducto eliminar = new PantallaEliminarProducto();
				eliminar.run();
			}
		});
		btnEliminarProducto.setBounds(55, 165, 203, 32);
		contentPane.add(btnEliminarProducto);
		
		JButton btnModificarProducto = new JButton("Modificar Producto");
		btnModificarProducto.setForeground(new Color(239, 239, 239));
		btnModificarProducto.setBackground(new Color(24, 90, 219));
		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaModificarProducto product = new PantallaModificarProducto();
				product.run();
			}
		});
		btnModificarProducto.setBounds(318, 111, 203, 32);
		contentPane.add(btnModificarProducto);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(239, 239, 239));
		btnSalir.setBackground(new Color(24, 90, 219));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz interfaz = new Interfaz();
				interfaz.Salir();
			}
		});
		btnSalir.setBounds(347, 246, 203, 32);
		contentPane.add(btnSalir);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(239, 239, 239));
		btnLogout.setBackground(new Color(24, 90, 219));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla1 Pantalla = new pantalla1();
				Pantalla.run();
			}
		});
		btnLogout.setBounds(318, 165, 203, 32);
		contentPane.add(btnLogout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 55);
		contentPane.add(panel);
		
		JLabel lblNewLabelEncabe = new JLabel("Bienvenido Operario");
		lblNewLabelEncabe.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabelEncabe);
		lblNewLabelEncabe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setBounds(216, 328, 162, 16);
		contentPane.add(lblNewLabel);
	}
}
