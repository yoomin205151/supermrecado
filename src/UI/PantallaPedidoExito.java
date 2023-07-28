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

public class PantallaPedidoExito extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaPedidoExito frame = new PantallaPedidoExito();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Create the frame.
	 */
	public PantallaPedidoExito() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setForeground(new Color(239, 239, 239));
		btnNewButton.setBackground(new Color(24, 90, 219));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaVentas ventas = new PantallaVentas();
				ventas.run();
			}
		});
		btnNewButton.setBounds(191, 218, 187, 39);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 92, 571, 59);
		contentPane.add(panel);
		
		JLabel lblNewLabelpedido = new JLabel("Pedido Agregado!");
		lblNewLabelpedido.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabelpedido);
		lblNewLabelpedido.setFont(new Font("Trebuchet MS", Font.BOLD, 27));
		
		JLabel lblNewLabel = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setBounds(207, 328, 163, 16);
		contentPane.add(lblNewLabel);
	}
}
