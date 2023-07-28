package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.ListadoUsuario;
import datos.Adminventas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaRegistroVentas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUSuario;
	private JTextField textFieldPassword;
	private JTextField textFielddni;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaRegistroVentas frame = new PantallaRegistroVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Create the frame.
	 */
	public PantallaRegistroVentas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Nombre Usuario:");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblUsuario.setForeground(new Color(239, 239, 239));
		lblUsuario.setBounds(102, 83, 128, 14);
		contentPane.add(lblUsuario);
		
		textFieldUSuario = new JTextField();
		textFieldUSuario.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldUSuario.setBackground(new Color(239, 239, 239));
		textFieldUSuario.setColumns(10);
		textFieldUSuario.setBounds(102, 108, 378, 20);
		contentPane.add(textFieldUSuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPassword.setForeground(new Color(239, 239, 239));
		lblPassword.setBounds(102, 139, 128, 14);
		contentPane.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldPassword.setBackground(new Color(239, 239, 239));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(102, 164, 378, 20);
		contentPane.add(textFieldPassword);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setForeground(new Color(239, 239, 239));
		lblDni.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDni.setBackground(new Color(239, 239, 239));
		lblDni.setBounds(102, 195, 128, 14);
		contentPane.add(lblDni);
		
		textFielddni = new JTextField();
		textFielddni.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFielddni.setBackground(new Color(239, 239, 239));
		textFielddni.setColumns(10);
		textFielddni.setBounds(102, 217, 378, 20);
		contentPane.add(textFielddni);
		
		JButton btnNewButtonRegistro = new JButton("Registrarse");
		btnNewButtonRegistro.setForeground(new Color(239, 239, 239));
		btnNewButtonRegistro.setBackground(new Color(24, 90, 219));
		btnNewButtonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoUsuario Usuarios = new ListadoUsuario();
				Adminventas adminventa = new Adminventas();
				adminventa.setDni(textFielddni.getText());
				adminventa.setNombre(textFieldUSuario.getText());
				adminventa.setPassword(textFieldPassword.getText());
				adminventa.setNivel(1);
				
				if(Usuarios.add(adminventa)) {
					 //JOptionPane.showMessageDialog(null, "Se agregó correctamente el Adminventas.");
					// Login();
					PantallaExitoRegistro exito = new PantallaExitoRegistro();
					exito.run();
				 }else {
					 //JOptionPane.showMessageDialog(null, "No se pudo agregar correctamente el Adminventas.");
					 PantallaFailRegistro fail = new PantallaFailRegistro();
					 fail.run();
				 }
			}
		});
		btnNewButtonRegistro.setBounds(198, 266, 191, 38);
		contentPane.add(btnNewButtonRegistro);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 47);
		contentPane.add(panel);
		
		JLabel lblEncabezado = new JLabel("Registro");
		lblEncabezado.setForeground(new Color(239, 239, 239));
		panel.add(lblEncabezado);
		lblEncabezado.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setBounds(217, 328, 161, 16);
		contentPane.add(lblNewLabel);
	}

}
