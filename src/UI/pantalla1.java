package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class pantalla1 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JTextField textFieldPass;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					pantalla1 frame = new pantalla1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}	
	}

	/**
	 * Create the frame.
	 */
	public pantalla1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 607, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.textInactiveText, null, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setForeground(new Color(239, 239, 239));
		btnIniciarSesion.setBackground(new Color(24, 90, 219));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuario usuario = new Usuario();
			    LinkedList<Usuario> usuarios = usuario.LlenarListaUsuario();
			    String[] UsuariosMostrar = new String[usuarios.size()];
			    
			    for (Usuario cuentas : usuarios) {
			        UsuariosMostrar[usuarios.indexOf(cuentas)] = cuentas.getNombre() + cuentas.getPassword() + cuentas.getNivel(); 
			    }
			    
			    for (Usuario cuentas : usuarios) {       
			    	System.out.println(cuentas.getNombre() + " " + cuentas.getPassword() + " " + cuentas.getNivel() + "\n");  	
			    }
			    
			    if (textFieldUsuario.getText() != null && textFieldPass.getText() != null) {
			        			    	
			    	int flag = 0;
			    	int nivel = 0;
			        for (Usuario cuentas : usuarios) {
			        	
			            if (cuentas.getNombre().equals(textFieldUsuario.getText()) && cuentas.getPassword().equals(textFieldPass.getText())) {
			            	
			            	flag = 1;
			            	nivel = cuentas.getNivel();
			            }
			            }
			        
			        if(flag == 1) {
			        				        	           
			            	switch (nivel) {
			        		case 0: 			        						        			
			        			PantallaOperario pantallaoperario = new PantallaOperario();
			        			pantallaoperario.setVisible(true);			        			
			        			break;
			        		case 1:			        						        			
			        			PantallaVentas pantallaventas = new PantallaVentas();
			        			pantallaventas.setVisible(true);			        			
			        			break;
			        		case 2: 			        					        			
			        			PantallaGerente pantallagerente = new PantallaGerente();
			        			pantallagerente.setVisible(true);			        						        			
			        			break;		        		            	
			                	} 
			            	
			            	} else {		            		
			            		JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
			            		pantalla1 Pantalla = new pantalla1();
			            		Pantalla.run();			           		
			            }
			        }			    								
			}
		});
		btnIniciarSesion.setBounds(94, 240, 184, 32);
		contentPane.add(btnIniciarSesion);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setForeground(new Color(239, 239, 239));
		btnRegistrarse.setBackground(new Color(24, 90, 219));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PantallaRegistro pantallaregistro = new PantallaRegistro();
				pantallaregistro.run();
			}
		});
		btnRegistrarse.setBounds(304, 240, 184, 32);
		contentPane.add(btnRegistrarse);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBackground(new Color(239, 239, 239));
		textFieldUsuario.setBounds(175, 122, 238, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldPass = new JTextField();
		textFieldPass.setBackground(new Color(239, 239, 239));
		textFieldPass.setColumns(10);
		textFieldPass.setBounds(175, 178, 238, 20);
		contentPane.add(textFieldPass);
		
		JLabel lblNewUsuario = new JLabel("Ingrese Usuario");
		lblNewUsuario.setForeground(new Color(239, 239, 239));
		lblNewUsuario.setBackground(new Color(239, 239, 239));
		lblNewUsuario.setBounds(175, 96, 145, 14);
		contentPane.add(lblNewUsuario);
		
		JLabel lblIngresePassword = new JLabel("Ingrese Password");
		lblIngresePassword.setForeground(new Color(239, 239, 239));
		lblIngresePassword.setBounds(175, 153, 145, 14);
		contentPane.add(lblIngresePassword);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 591, 47);
		contentPane.add(panel);
		
		JLabel lblTextoEnca = new JLabel("Bienvenido");
		lblTextoEnca.setForeground(new Color(239, 239, 239));
		panel.add(lblTextoEnca);
		lblTextoEnca.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
		
		JTextArea txtrMadeByPollow = new JTextArea();
		txtrMadeByPollow.setForeground(new Color(239, 239, 239));
		txtrMadeByPollow.setBackground(new Color(10, 25, 49));
		txtrMadeByPollow.setText("Made by Pollos Hermanos™");
		txtrMadeByPollow.setBounds(223, 330, 164, 20);
		contentPane.add(txtrMadeByPollow);
		

	

}	
}
