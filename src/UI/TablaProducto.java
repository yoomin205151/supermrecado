package UI;


import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.ListadoProducto;
import datos.Producto;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class TablaProducto extends JFrame {

	static ListadoProducto listadoproducto = new ListadoProducto();
	private List<Producto> productos = listadoproducto.MostrarProductos();
	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					TablaProducto frame = new TablaProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public TablaProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 394);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 25, 49));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButtonvolver = new JButton("Volver");
		btnNewButtonvolver.setForeground(new Color(239, 239, 239));
		btnNewButtonvolver.setBackground(new Color(24, 90, 219));
		btnNewButtonvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaVentas pantallaventas = new PantallaVentas();
				pantallaventas.run();
			}
		});
		btnNewButtonvolver.setBounds(197, 268, 182, 37);
		contentPane.add(btnNewButtonvolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 81, 492, 165);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBackground(new Color(24, 90, 219));
		panel.setBounds(0, 0, 571, 50);
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("Tabla de productos");
		lblNewLabel.setForeground(new Color(239, 239, 239));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Made by Pollos Hermanos™");
		lblNewLabel_1.setForeground(new Color(239, 239, 239));
		lblNewLabel_1.setBounds(213, 328, 161, 16);
		contentPane.add(lblNewLabel_1);
	}
	
	 public void MostrarProducto(){
	        String[]indices = {"ID","Producto","Cantidad","Precio"};
	        DefaultTableModel model = new DefaultTableModel(null, indices);
	        //model.addRow(indices);
	        String[] registros = new String[4];
	        for (Producto i : productos){
	           registros[0] = String.valueOf(i.getId_producto());
	           registros[1] = i.getNombre();
	           registros[2] = String.valueOf(i.getCantidad());
	           registros[3] = String.valueOf(i.getPrecio());
	           model.addRow(registros);
	        }
	        table.setModel(model);
	    }
}
