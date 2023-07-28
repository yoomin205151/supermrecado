package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.ListadoProducto;
import datos.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaEliminarProducto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaEliminarProducto frame = new PantallaEliminarProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public PantallaEliminarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ListadoProducto listadoproducto = new ListadoProducto();
		 List<Producto> MostrarProductos = listadoproducto.MostrarProductos();
         String[] ProductosAmostrar = new String[MostrarProductos.size()];
         for (Producto producto : MostrarProductos) {
             ProductosAmostrar[MostrarProductos.indexOf(producto)] = producto.getNombre();}
		JComboBox comboBoxProducto = new JComboBox(ProductosAmostrar);
		comboBoxProducto.setBackground(new Color(239, 239, 239));
		comboBoxProducto.setBounds(93, 129, 342, 22);
		contentPane.add(comboBoxProducto);
		
		JButton btnNewButtonEliminar = new JButton("Eliminar");
		btnNewButtonEliminar.setForeground(new Color(239, 239, 239));
		btnNewButtonEliminar.setBackground(new Color(24, 90, 219));
		btnNewButtonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               
                if (comboBoxProducto.getSelectedItem() != null) {
                    //JOptionPane.showMessageDialog(null, "La opcion elegida fue: " + comboBoxProducto.getSelectedItem());
                    for (Producto producto : MostrarProductos) {
                        if (producto.getNombre().equals(comboBoxProducto.getSelectedItem())){
                            if(listadoproducto.remove(producto)) {
                            	PantallaExitoEliminarProducto eliminar = new PantallaExitoEliminarProducto();
                            	eliminar.run();
                            }else {
                                
                            	PantallaErrorEliminarProducto error = new PantallaErrorEliminarProducto();
                            	error.run();
                            }
                        } 
                    }
                }
			}
		});
		btnNewButtonEliminar.setBounds(187, 204, 205, 37);
		contentPane.add(btnNewButtonEliminar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 47);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Eliminar Producto");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JLabel lblNewLabel_1 = new JLabel("- Seleccione el producto a eliminar:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1.setBounds(93, 101, 245, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel_2.setForeground(new Color(239, 239, 239));
		lblNewLabel_2.setBackground(new Color(10, 25, 49));
		lblNewLabel_2.setBounds(212, 328, 165, 16);
		contentPane.add(lblNewLabel_2);
	}
}
