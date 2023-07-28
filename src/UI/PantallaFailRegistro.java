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

public class PantallaFailRegistro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaFailRegistro frame = new PantallaFailRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Create the frame.
	 */
	public PantallaFailRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOk = new JButton("Volver a ingresar datos");
		btnOk.setForeground(new Color(239, 239, 239));
		btnOk.setBackground(new Color(24, 90, 219));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla1 pantalla = new pantalla1();
				pantalla.run();
			}
		});
		btnOk.setBounds(178, 232, 210, 39);
		contentPane.add(btnOk);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 74, 571, 86);
		contentPane.add(panel);
		
		JLabel lblErrorAlRegistrarse = new JLabel("Error al Registrarse ");
		lblErrorAlRegistrarse.setForeground(new Color(239, 239, 239));
		panel.add(lblErrorAlRegistrarse);
		lblErrorAlRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblIngreseCorrectamenteLos = new JLabel("Ingrese Correctamente los datos");
		lblIngreseCorrectamenteLos.setForeground(new Color(239, 239, 239));
		panel.add(lblIngreseCorrectamenteLos);
		lblIngreseCorrectamenteLos.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setBounds(209, 328, 163, 16);
		contentPane.add(lblNewLabel);
	}

}
