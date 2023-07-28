package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.ListadoUsuario;
import datos.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class PantallaEliminarUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaEliminarUsuario frame = new PantallaEliminarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public PantallaEliminarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListadoUsuario listadousuario = new ListadoUsuario();
		LinkedList<Usuario> usuario = listadousuario.LlenarListaUsuario();
		String[] UsuariosMostrar = new String[usuario.size()];
		for (Usuario usuarios : usuario) {
			UsuariosMostrar[usuario.indexOf(usuarios)] = usuarios.getNombre();}
		JComboBox comboBoxusuario = new JComboBox(UsuariosMostrar);
		comboBoxusuario.setBackground(new Color(239, 239, 239));
		comboBoxusuario.setBounds(123, 151, 304, 22);
		contentPane.add(comboBoxusuario);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.setForeground(new Color(239, 239, 239));
		btnNewButton.setBackground(new Color(24, 90, 219));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (comboBoxusuario.getSelectedItem() != null) {				
					for (Usuario usuarios : usuario) {
						if (usuarios.getNombre().equals(comboBoxusuario.getSelectedItem())){
							if(listadousuario.remove(usuarios)) {
								PantallaEixoEliminarUsuario eliminar = new PantallaEixoEliminarUsuario();
								eliminar.run();
							}else {
								PantallaErrorEliminarUsuario erro = new PantallaErrorEliminarUsuario();
								erro.run();
							}
						} 
					}
				}
			}
		});
		btnNewButton.setBounds(197, 221, 195, 35);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 46);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Eliminar usuario");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JLabel lblNewLabel_1 = new JLabel("- Seleccione el usuario a eliminar: ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1.setBounds(113, 121, 243, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel_2.setForeground(new Color(239, 239, 239));
		lblNewLabel_2.setBounds(215, 328, 158, 16);
		contentPane.add(lblNewLabel_2);
		

	}

}
