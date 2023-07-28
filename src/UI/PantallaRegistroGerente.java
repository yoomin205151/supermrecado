package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.ListadoUsuario;
import datos.Gerente;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaRegistroGerente extends JFrame {

	private JPanel contentPane;
	private JTextField textFielddni;
	private JTextField textFieldPassword;
	private JTextField textFieldUsuario;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaRegistroGerente frame = new PantallaRegistroGerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Create the frame.
	 */
	public PantallaRegistroGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButtonRegistro = new JButton("Registrarse");
		btnNewButtonRegistro.setForeground(new Color(239, 239, 239));
		btnNewButtonRegistro.setBackground(new Color(24, 90, 219));
		btnNewButtonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoUsuario Usuarios = new ListadoUsuario();
				Gerente gerentes = new Gerente();
				gerentes.setDni(textFielddni.getText());
				gerentes.setNombre(textFieldUsuario.getText());
				gerentes.setPassword(textFieldPassword.getText());
				gerentes.setNivel(2);
				
				if(Usuarios.add(gerentes)) {
					 //JOptionPane.showMessageDialog(null, "Se agregó correctamente el Gerente.");				
						PantallaExitoRegistro exito = new PantallaExitoRegistro();
						exito.run();
				 }else {
					 //JOptionPane.showMessageDialog(null, "No se pudo agregar correctamente el Gerente.");
					 PantallaFailRegistro fail = new PantallaFailRegistro();
					 fail.run();
				 }
			}
		});
		btnNewButtonRegistro.setBounds(191, 272, 194, 36);
		contentPane.add(btnNewButtonRegistro);
		
		textFielddni = new JTextField();
		textFielddni.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFielddni.setBackground(new Color(239, 239, 239));
		textFielddni.setColumns(10);
		textFielddni.setBounds(103, 222, 352, 20);
		contentPane.add(textFielddni);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDni.setForeground(new Color(239, 239, 239));
		lblDni.setBounds(103, 197, 128, 14);
		contentPane.add(lblDni);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldPassword.setBackground(new Color(239, 239, 239));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(103, 166, 352, 20);
		contentPane.add(textFieldPassword);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPassword.setForeground(new Color(239, 239, 239));
		lblPassword.setBounds(103, 141, 128, 14);
		contentPane.add(lblPassword);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldUsuario.setBackground(new Color(239, 239, 239));
		textFieldUsuario.setColumns(10);
		textFieldUsuario.setBounds(103, 110, 352, 20);
		contentPane.add(textFieldUsuario);
		
		JLabel lblUsuario = new JLabel("Nombre Usuario: ");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblUsuario.setForeground(new Color(239, 239, 239));
		lblUsuario.setBounds(103, 85, 128, 14);
		contentPane.add(lblUsuario);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 51);
		contentPane.add(panel);
		
		JLabel lblEncabezado = new JLabel("Registro");
		lblEncabezado.setForeground(new Color(239, 239, 239));
		panel.add(lblEncabezado);
		lblEncabezado.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setBounds(214, 328, 164, 16);
		contentPane.add(lblNewLabel);
	}

}
