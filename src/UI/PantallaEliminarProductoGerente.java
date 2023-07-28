package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.ListadoProducto;
import datos.Producto;
import java.awt.Color;

public class PantallaEliminarProductoGerente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					PantallaEliminarProductoGerente frame = new PantallaEliminarProductoGerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public PantallaEliminarProductoGerente() {
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
		comboBoxProducto.setBounds(100, 146, 316, 22);
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
                            	PantallaExitoEliminarProductoGerente eliminar = new PantallaExitoEliminarProductoGerente();
                            	eliminar.run();
                            }else {
                                
                            	PantallaErrorEliminarProductoGerente error = new PantallaErrorEliminarProductoGerente();
                            	error.run();
                            }
                        } 
                    }
                }
			}
		});
		btnNewButtonEliminar.setBounds(196, 222, 190, 38);
		contentPane.add(btnNewButtonEliminar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 47);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Eliminar producto");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JLabel lblNewLabel_1 = new JLabel("- Seleccione el producto a eliminar: ");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1.setBounds(100, 119, 265, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel_2.setForeground(new Color(239, 239, 239));
		lblNewLabel_2.setBounds(220, 327, 162, 16);
		contentPane.add(lblNewLabel_2);
	}
}
