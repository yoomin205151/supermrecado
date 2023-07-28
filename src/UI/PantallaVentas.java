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

public class PantallaVentas extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					PantallaVentas frame = new PantallaVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	/**
	 * Create the frame.
	 */
	public PantallaVentas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnArmarPedido = new JButton("Armar Pedido");
		btnArmarPedido.setForeground(new Color(239, 239, 239));
		btnArmarPedido.setBackground(new Color(24, 90, 219));
		btnArmarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaCrearPedido pantallapedido = new PantallaCrearPedido();
				pantallapedido.run();
			}
		});
		btnArmarPedido.setBounds(56, 94, 203, 31);
		contentPane.add(btnArmarPedido);
		
		JButton btnCancelarPedido = new JButton("Cancelar Pedido");
		btnCancelarPedido.setForeground(new Color(239, 239, 239));
		btnCancelarPedido.setBackground(new Color(24, 90, 219));
		btnCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaCancelarPedido pantallacancel = new PantallaCancelarPedido();
				pantallacancel.run();
			}
		});
		btnCancelarPedido.setBounds(56, 159, 203, 31);
		contentPane.add(btnCancelarPedido);
		
		JButton btnVerStock = new JButton("Ver Stock");
		btnVerStock.setForeground(new Color(239, 239, 239));
		btnVerStock.setBackground(new Color(24, 90, 219));
		btnVerStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TablaProducto tablaproducto = new TablaProducto();
				tablaproducto.MostrarProducto();
				tablaproducto.setVisible(true);			
			}
		});
		btnVerStock.setBounds(316, 94, 203, 31);
		contentPane.add(btnVerStock);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(239, 239, 239));
		btnSalir.setBackground(new Color(24, 90, 219));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interfaz interfaz = new Interfaz();
				interfaz.Salir();
			}
		});
		btnSalir.setBounds(358, 239, 203, 31);
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
		btnLogout.setBounds(316, 159, 203, 31);
		contentPane.add(btnLogout);
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 49);
		contentPane.add(panel);
		
		JLabel lblNewLabelEncabe = new JLabel("Bienvenido Ventas");
		lblNewLabelEncabe.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabelEncabe);
		lblNewLabelEncabe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setBounds(214, 328, 164, 16);
		contentPane.add(lblNewLabel);
	}

}
