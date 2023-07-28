package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;


public class Pedido   {
	

	
	private int id_pedido;
	private Timestamp fecha;
	private int nro_pedido;
	private int cantidad;
	private Double precio;
	
	Conexion con = new Conexion();

	Connection conexion = con.conectar();

	PreparedStatement stmt;
	
	public Pedido(int id_pedido,  Timestamp fecha,int nro_pedido, int cantidad,double precio) {
		super();
		this.id_pedido = id_pedido;	
		this.fecha = fecha;	
		this.nro_pedido = nro_pedido;
		this.cantidad = cantidad;	
		this.precio = precio;
	}
	
	

	
	 public Pedido() {
		// TODO Auto-generated constructor stub
	}

	




	public Pedido(int parseInt, String string, int parseInt2, int parseInt3, int parseInt4, String string2) {
		// TODO Auto-generated constructor stub
	}

	public static Timestamp convertStringToTimestamp(String str_date) {
	    try {

	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = formatter.parse(str_date);
	        java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());
	        return timeStampDate;

	    } catch (ParseException e) {
	        System.out.println("Exception :" + e);
	        return null;
	    }
	}


	public LinkedList<Pedido> LlenarListaPedido() {

	        String sql ="SELECT * FROM pedido "; 

	        String[] datos = new String[5];

	        LinkedList<Pedido> Pedidos = new LinkedList<Pedido>();
	        
	       
	        System.out.println(Pedidos);
	        try {
	            stmt = conexion.prepareStatement(sql);

	            ResultSet result =  stmt.executeQuery();

	            while(result.next()) {
	                datos[0] = result.getString(1);
	                datos[1] = result.getString(2);
	                datos[2] = result.getString(3);
	                datos[3] = result.getString(4);
	                datos[4] = result.getString(5);
	                
	                //int id_pedido,  Date fecha,int nro_pedido, int cantidad,double precio
	               // idpedido  -  fecha - nro pedido -  cantidad - precio -  dni - idproducto
	                Pedidos.add( new Pedido(Integer.parseInt(datos[0]),convertStringToTimestamp(datos[1]),Integer.parseInt(datos[2]),Integer.parseInt(datos[3]),Double.parseDouble(datos[4])));
	                
	            }
	            stmt.close();
	            return Pedidos;
	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println("error ");
	            return null;
	        }
	    }
	
	 public boolean CancelarPedido(Pedido pedido) {
			
		 	System.out.println(pedido.getNro_pedido());
		    try {
		    	String sql = "DELETE FROM pedido WHERE nro_pedido =?";
		      stmt = conexion.prepareStatement(sql);
		      stmt.setInt(1,pedido.getNro_pedido());
		      
		      stmt.executeUpdate();
		      stmt.close();
		      return  true;
		    } catch (Exception e) {
				// TODO: handle exception
				System.out.println("error ");
				return false;
			}
	}
	
	public int getId_pedido() {
		return id_pedido;
	}


	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}


	public Timestamp getFecha() {
		return fecha;
	}


	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getNro_pedido() {
		return nro_pedido;
	}

	public void setNro_pedido(int nro_pedido) {
		this.nro_pedido = nro_pedido;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	
	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", fecha=" + fecha + ", nro_pedido=" + nro_pedido + ", cantidad="
				+ cantidad + ", precio=" + precio + "]";
	}


	
}
