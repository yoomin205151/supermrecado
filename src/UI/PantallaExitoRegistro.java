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

public class PantallaExitoRegistro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaExitoRegistro frame = new PantallaExitoRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Create the frame.
	 */
	public PantallaExitoRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewiniciar = new JButton("Iniciar Sesion");
		btnNewiniciar.setForeground(new Color(239, 239, 239));
		btnNewiniciar.setBackground(new Color(24, 90, 219));
		btnNewiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla1 pantalla = new pantalla1();
				pantalla.run();
			}
		});
		btnNewiniciar.setBounds(177, 216, 202, 37);
		contentPane.add(btnNewiniciar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 87, 571, 51);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Registrado Exitosamente!");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1.setBounds(205, 328, 163, 16);
		contentPane.add(lblNewLabel_1);
	}

}
