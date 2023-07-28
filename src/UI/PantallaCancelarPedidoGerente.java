package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.ListadoPedido;
import datos.Pedido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaCancelarPedidoGerente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaCancelarPedidoGerente frame = new PantallaCancelarPedidoGerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public PantallaCancelarPedidoGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(new Color(239, 239, 239));
		textField.setColumns(10);
		textField.setBounds(195, 135, 190, 37);
		contentPane.add(textField);
		
		JButton btnNewButtonBorrar = new JButton("Cancelar Pedido");
		btnNewButtonBorrar.setForeground(new Color(239, 239, 239));
		btnNewButtonBorrar.setBackground(new Color(24, 90, 219));
		btnNewButtonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoPedido listadopedido = new ListadoPedido();
				LinkedList<Pedido> MostrarPedido = listadopedido.LlenarListaPedido();
				int[] PedidosAmostrar = new int[MostrarPedido.size()];
				for (Pedido pedido : MostrarPedido) {
					PedidosAmostrar[MostrarPedido.indexOf(pedido)] = pedido.getNro_pedido();
				}	
				int opcion = Integer.parseInt(textField.getText());
				for (Pedido pedido : MostrarPedido) {
				if (opcion == pedido.getNro_pedido()) {		
					if (listadopedido.remove(pedido)) {
						JOptionPane.showMessageDialog(null, "Pedido canceclado con exito");
						PantallaGerente pantallagerente = new PantallaGerente();
						pantallagerente.run();
					} else {
						JOptionPane.showMessageDialog(null, "Error al cancelar el pedido");
						PantallaGerente pantallagerente = new PantallaGerente();
						pantallagerente.run();
					}							
				}
				}
			}
		});
		btnNewButtonBorrar.setBounds(195, 206, 190, 37);
		contentPane.add(btnNewButtonBorrar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 49);
		contentPane.add(panel);
		
		JLabel lblNewCancelTicket = new JLabel("Escriba Nro de Ticket");
		lblNewCancelTicket.setForeground(new Color(239, 239, 239));
		panel.add(lblNewCancelTicket);
		lblNewCancelTicket.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setBackground(new Color(10, 25, 49));
		lblNewLabel.setBounds(220, 328, 165, 16);
		contentPane.add(lblNewLabel);
	}
}
