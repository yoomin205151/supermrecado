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

public class PantallaGerente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					PantallaGerente frame = new PantallaGerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	/**
	 * Create the frame.
	 */
	public PantallaGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewAgregarProducto = new JButton("Agregar Producto");
		btnNewAgregarProducto.setForeground(new Color(239, 239, 239));
		btnNewAgregarProducto.setBackground(new Color(24, 90, 219));
		btnNewAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaIngresarProductoGerente gerentproduct = new PantallaIngresarProductoGerente();
				gerentproduct.run();
			}
		});
		btnNewAgregarProducto.setBounds(53, 83, 191, 32);
		contentPane.add(btnNewAgregarProducto);
		
		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setForeground(new Color(239, 239, 239));
		btnEliminarProducto.setBackground(new Color(24, 90, 219));
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaEliminarProductoGerente elininarprod = new PantallaEliminarProductoGerente();
				elininarprod.run();
			}
		});
		btnEliminarProducto.setBounds(325, 83, 191, 32);
		contentPane.add(btnEliminarProducto);
		
		JButton btnModificarProducto = new JButton("Modificar Producto");
		btnModificarProducto.setForeground(new Color(239, 239, 239));
		btnModificarProducto.setBackground(new Color(24, 90, 219));
		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaModificarProductoGerente modd = new PantallaModificarProductoGerente();
				modd.run();
			}
		});
		btnModificarProducto.setBounds(53, 126, 191, 32);
		contentPane.add(btnModificarProducto);
		
		JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
		btnEliminarUsuario.setForeground(new Color(239, 239, 239));
		btnEliminarUsuario.setBackground(new Color(24, 90, 219));
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaEliminarUsuario eliminar = new PantallaEliminarUsuario();
				eliminar.run();
			}
		});
		btnEliminarUsuario.setBounds(325, 126, 191, 32);
		contentPane.add(btnEliminarUsuario);
		
		JButton btnModificarPermisos = new JButton("Modificar Permisos");
		btnModificarPermisos.setForeground(new Color(239, 239, 239));
		btnModificarPermisos.setBackground(new Color(24, 90, 219));
		btnModificarPermisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaModificarNivel pantallanivel = new PantallaModificarNivel();
				pantallanivel.run();
			}
		});
		btnModificarPermisos.setBounds(325, 169, 191, 32);
		contentPane.add(btnModificarPermisos);
		
		JButton btnArmarPedido = new JButton("Armar Pedido");
		btnArmarPedido.setForeground(new Color(239, 239, 239));
		btnArmarPedido.setBackground(new Color(24, 90, 219));
		btnArmarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InterfazGerente interfazgerente = new InterfazGerente();
				//interfazgerente.CrearPedido();
				PantallaCrearPedido pantallapedido = new PantallaCrearPedido();
				pantallapedido.run();
			}
		});
		btnArmarPedido.setBounds(53, 169, 191, 32);
		contentPane.add(btnArmarPedido);
		
		JButton btnCancelarPedido = new JButton("Cancelar Pedido");
		btnCancelarPedido.setForeground(new Color(239, 239, 239));
		btnCancelarPedido.setBackground(new Color(24, 90, 219));
		btnCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaCancelarPedidoGerente pangerente = new PantallaCancelarPedidoGerente();
				pangerente.run();
			}
		});
		btnCancelarPedido.setBounds(53, 212, 190, 32);
		contentPane.add(btnCancelarPedido);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(239, 239, 239));
		btnSalir.setBackground(new Color(24, 90, 219));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazGerente interfazgerente = new InterfazGerente();
				interfazgerente.Salir();
			}
		});
		btnSalir.setBounds(370, 271, 191, 32);
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
		btnLogout.setBounds(325, 212, 191, 32);
		contentPane.add(btnLogout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 51);
		contentPane.add(panel);
		
		JLabel lblNewLabelEncabe = new JLabel("Bienvenido Gerente");
		lblNewLabelEncabe.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabelEncabe);
		lblNewLabelEncabe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setBounds(209, 328, 164, 16);
		contentPane.add(lblNewLabel);
	}

}
