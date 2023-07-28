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

public class PantallaCancelarPedido extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldticket;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaCancelarPedido frame = new PantallaCancelarPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Create the frame.
	 */
	public PantallaCancelarPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldticket = new JTextField();
		textFieldticket.setBackground(new Color(239, 239, 239));
		textFieldticket.setBounds(179, 124, 213, 27);
		contentPane.add(textFieldticket);
		textFieldticket.setColumns(10);
		
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
				int opcion = Integer.parseInt(textFieldticket.getText());
				for (Pedido pedido : MostrarPedido) {
				if (opcion == pedido.getNro_pedido()) {		
					if (listadopedido.remove(pedido)) {
						PantallaPedidoCancelado cancel =  new PantallaPedidoCancelado();
						cancel.run();
					} else {
						PantallaErrorCancelarPedido error = new PantallaErrorCancelarPedido();
						error.run();
					}							
				}
				}
			}
		});
		btnNewButtonBorrar.setBounds(179, 202, 213, 37);
		contentPane.add(btnNewButtonBorrar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 48);
		contentPane.add(panel);
		
		JLabel lblNewCancelTicket = new JLabel("Escriba Nro de Ticket");
		lblNewCancelTicket.setForeground(new Color(239, 239, 239));
		panel.add(lblNewCancelTicket);
		lblNewCancelTicket.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setBackground(new Color(10, 25, 49));
		lblNewLabel.setBounds(202, 327, 162, 16);
		contentPane.add(lblNewLabel);
	}
}
