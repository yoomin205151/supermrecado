package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.ListadoUsuario;
import datos.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class PantallaModificarNivel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	ListadoUsuario listadousuario = new ListadoUsuario();
	private JTextField textFieldnivel;
			public void run() {
				try {
					PantallaModificarNivel frame = new PantallaModificarNivel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public PantallaModificarNivel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LinkedList<Usuario> usuario = listadousuario.LlenarListaUsuario();
		String[] UsuariosMostrar = new String[usuario.size()];
		for (Usuario usuarios : usuario) {
			UsuariosMostrar[usuario.indexOf(usuarios)] = usuarios.getNombre();}
		JComboBox comboBoxUsuario = new JComboBox(UsuariosMostrar);
		comboBoxUsuario.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboBoxUsuario.setBackground(new Color(239, 239, 239));
		comboBoxUsuario.setBounds(108, 123, 352, 22);
		contentPane.add(comboBoxUsuario);
		
		textFieldnivel = new JTextField();
		textFieldnivel.setBackground(new Color(239, 239, 239));
		textFieldnivel.setFont(new Font("Verdana", Font.PLAIN, 11));
		textFieldnivel.setBounds(108, 199, 352, 20);
		contentPane.add(textFieldnivel);
		textFieldnivel.setColumns(10);
		
		JButton buttonModificar = new JButton("Modificar");
		buttonModificar.setForeground(new Color(239, 239, 239));
		buttonModificar.setBackground(new Color(24, 90, 219));
		buttonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LinkedList<Usuario> usuario = listadousuario.LlenarListaUsuario();
				String[] UsuariosMostrar = new String[usuario.size()];
			
				if (comboBoxUsuario.getSelectedItem() != null) {
					JOptionPane.showMessageDialog(null, "La opcion elegida fue: " + comboBoxUsuario.getSelectedItem());
					for (Usuario usuarios : usuario) {
						if (usuarios.getNombre().equals(comboBoxUsuario.getSelectedItem())){
							
							int nivelNuevo=Integer.parseInt(textFieldnivel.getText());
							usuarios.setNivel(nivelNuevo);
							
							if(listadousuario.actualizar(usuarios)) {
								JOptionPane.showMessageDialog(null, "Usuario modificado con exito");
								//login();
								//PantallaGerente pantallagerente = new PantallaGerente();
								//pantallagerente.run();
								PantallaGerente pantallagerente = new PantallaGerente();
								pantallagerente.run();
							}else {
								JOptionPane.showMessageDialog(null, "Error al modificar usuario");
								//login();
								PantallaGerente pantallagerente = new PantallaGerente();
								pantallagerente.run();
							}
						} 
					}
				}
			}
		});
		buttonModificar.setBounds(205, 253, 179, 36);
		contentPane.add(buttonModificar);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese nuevo nivel: ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1.setBounds(108, 172, 134, 14);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 47);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Modificar Nivel de Permiso");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JLabel lblNewLabel_2 = new JLabel("Seleccione un usuario: ");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(239, 239, 239));
		lblNewLabel_2.setBounds(108, 97, 160, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(239, 239, 239));
		lblNewLabel_3.setBackground(new Color(239, 239, 239));
		lblNewLabel_3.setBounds(224, 328, 160, 16);
		contentPane.add(lblNewLabel_3);
		

	}
}
