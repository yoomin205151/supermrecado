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

public class PantallaRegistro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaRegistro frame = new PantallaRegistro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Create the frame.
	 */
	public PantallaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButtonOperario = new JButton("Operario");
		btnNewButtonOperario.setForeground(new Color(239, 239, 239));
		btnNewButtonOperario.setBackground(new Color(24, 90, 219));
		btnNewButtonOperario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaRegistroOperario pantallaregistrooperario = new PantallaRegistroOperario();
				pantallaregistrooperario.run();
			}
		});
		btnNewButtonOperario.setBounds(196, 144, 195, 30);
		contentPane.add(btnNewButtonOperario);
		
		JButton btnNewButtonVentas = new JButton("Ventas");
		btnNewButtonVentas.setForeground(new Color(239, 239, 239));
		btnNewButtonVentas.setBackground(new Color(24, 90, 219));
		btnNewButtonVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaRegistroVentas pantallaventas = new PantallaRegistroVentas();
				pantallaventas.run();
			}
		});
		btnNewButtonVentas.setBounds(196, 186, 195, 30);
		contentPane.add(btnNewButtonVentas);
		
		JButton btnNewButtonGerente = new JButton("Gerente");
		btnNewButtonGerente.setForeground(new Color(239, 239, 239));
		btnNewButtonGerente.setBackground(new Color(24, 90, 219));
		btnNewButtonGerente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaRegistroGerente pantallar = new PantallaRegistroGerente();
				pantallar.run();
			}
		});
		btnNewButtonGerente.setBounds(196, 227, 195, 30);
		contentPane.add(btnNewButtonGerente);
		
		JButton btnNewButtonVolver = new JButton("Volver");
		btnNewButtonVolver.setForeground(new Color(239, 239, 239));
		btnNewButtonVolver.setBackground(new Color(24, 90, 219));
		btnNewButtonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pantalla1 pantalla11 = new pantalla1();
				pantalla11.run();
			}
		});
		btnNewButtonVolver.setBounds(397, 287, 184, 30);
		contentPane.add(btnNewButtonVolver);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 591, 43);
		contentPane.add(panel);
		
		JLabel lblNewLabelencabezado = new JLabel("Registro de cuenta");
		lblNewLabelencabezado.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabelencabezado);
		lblNewLabelencabezado.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("- Seleccione su rol en la empresa: ");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setBounds(44, 81, 250, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1.setBounds(220, 341, 171, 16);
		contentPane.add(lblNewLabel_1);
	}
}
