package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.ListadoUsuario;
import datos.Operario;
import datos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaRegistroOperario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldPassword;
	private JTextField textFielddni;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaRegistroOperario frame = new PantallaRegistroOperario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

	}

	/**
	 * Create the frame.
	 */
	public PantallaRegistroOperario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldUsuario.setBackground(new Color(239, 239, 239));
		textFieldUsuario.setBounds(102, 102, 376, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldPassword.setBackground(new Color(239, 239, 239));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(102, 158, 376, 20);
		contentPane.add(textFieldPassword);
		
		textFielddni = new JTextField();
		textFielddni.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFielddni.setBackground(new Color(239, 239, 239));
		textFielddni.setColumns(10);
		textFielddni.setBounds(102, 214, 376, 20);
		contentPane.add(textFielddni);
		
		JButton btnNewButtonRegistro = new JButton("Registrarse");
		btnNewButtonRegistro.setForeground(new Color(239, 239, 239));
		btnNewButtonRegistro.setBackground(new Color(24, 90, 219));
		btnNewButtonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadoUsuario Usuarios = new ListadoUsuario();			
				Operario operarios = new Operario();
				operarios.setDni(textFielddni.getText());
				operarios.setNombre(textFieldUsuario.getText());
				operarios.setPassword(textFieldPassword.getText());
				operarios.setNivel(0);
				
				if(Usuarios.add(operarios)) {
					 
					//JOptionPane.showMessageDialog(null, "Se agregó correctamente el Operario.");
					 
					PantallaExitoRegistro exito = new PantallaExitoRegistro();
					exito.run();
				 }else {
					 //JOptionPane.showMessageDialog(null, "No se pudo agregar correctamente el Operario intente nuevamente ingresando correctamente los datos.");
					 PantallaFailRegistro fail = new PantallaFailRegistro();
					 fail.run();
				 }
			}
		});
		btnNewButtonRegistro.setBounds(199, 264, 179, 32);
		contentPane.add(btnNewButtonRegistro);
		
		JLabel lblUsuario = new JLabel("Nombre Usuario:");
		lblUsuario.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblUsuario.setForeground(new Color(239, 239, 239));
		lblUsuario.setBounds(102, 77, 128, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(239, 239, 239));
		lblPassword.setBackground(new Color(239, 239, 239));
		lblPassword.setBounds(102, 133, 128, 14);
		contentPane.add(lblPassword);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setForeground(new Color(239, 239, 239));
		lblDni.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblDni.setBackground(new Color(239, 239, 239));
		lblDni.setBounds(102, 189, 128, 14);
		contentPane.add(lblDni);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 49);
		contentPane.add(panel);
		
		JLabel lblEncabezado = new JLabel("Registro");
		lblEncabezado.setForeground(new Color(239, 239, 239));
		panel.add(lblEncabezado);
		lblEncabezado.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setBounds(217, 328, 159, 16);
		contentPane.add(lblNewLabel);
	}
}
