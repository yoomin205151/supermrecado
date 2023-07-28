package datos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Producto {
private String nombre;
private int cantidad;
private int id_producto;
private double precio;

Conexion con = new Conexion();

Connection conexion = con.conectar();

PreparedStatement stmt;

public boolean guardarProducto(Producto productos) {

    String sql = "INSERT INTO supermercado.producto(cantidad,nombre, precio ) VALUES (?,?,?)"; 
     
    
        try {

            stmt = conexion.prepareStatement(sql);
            stmt.setInt(1,productos.getCantidad());
            stmt.setString(2,productos.getNombre());
            stmt.setDouble(3,productos.getPrecio());
            
            

            stmt.executeUpdate();
            stmt.close();
            return true;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error");
            return false;
        }
    }

public boolean EliminarProducto(Producto producto) {

    //String sql = "DELETE FROM producto WHERE id_producto =?";
    System.out.println(producto.getId_producto());

      try {
          String sql = "DELETE FROM producto WHERE id_producto =?";
        stmt = conexion.prepareStatement(sql);
        stmt.setInt(1,producto.getId_producto());

        stmt.executeUpdate();
        stmt.close();
        return  true;
      } catch (Exception e) {
          // TODO: handle exception
          System.out.println("error ");
          return false;
      }
}



public boolean ActualizarProducto(Producto producto)  {
	
	//String sql ="UPDATE producto SET cantidad=?,nombre=?,precio=? WHERE id_producto=?";


	try {
		String sql ="UPDATE producto SET cantidad=?,nombre=?,precio=? WHERE id_producto=?";
		stmt = conexion.prepareStatement(sql);
		
		
		stmt.setInt(1,producto.getCantidad());
		stmt.setString(2,producto.getNombre());
		stmt.setDouble(3,producto.getPrecio());
		stmt.setInt(4,producto.getId_producto());
	    stmt.executeUpdate();
	    stmt.close();
	    return true;
		
	} catch (Exception e) {
		//System.out.println("error ");
		System.out.println("error ");
		return false;
	}
}




public List<Producto> MostrarProductos() {
	
	String sql ="SELECT * FROM `producto`"; 
	
	String[] datos = new String[4];
	
	List<Producto> Stock = new ArrayList<Producto>();
	
	try {
		stmt = conexion.prepareStatement(sql);
		
		ResultSet result =  stmt.executeQuery();
		
		while(result.next()) {		
			datos[0] = result.getString(1);
			datos[1] = result.getString(2);
			datos[2] = result.getString(3);
			datos[3] = result.getString(4);
				System.out.println(datos[0]+datos[1]+datos[2]+datos[3]);
			//String nombre, int cantidad, int id_producto, double precio
			//id_producto	cantidad	nombre	precio   base de datos
			// dentro de sotck.add entra en orden del constructor
			Stock.add(new Producto(datos[2],Integer.parseInt(datos[1]),Integer.parseInt(datos[0]),Double.parseDouble(datos[3])));
			
		}
		stmt.close();
		return Stock;
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("error ");
		return null;
	}
}

public Producto(String nombre, int cantidad, int id_producto, double precio) {
	super();
	this.nombre = nombre;
	this.cantidad = cantidad;
	this.id_producto = id_producto;
	this.precio= precio;
}


public Producto() {
	super();
}




public Producto(String nombre2, String string, String string2, String string3) {
	
}

public String getNombre() {
	return nombre;
}

public void setNombre(String object) {
	this.nombre = object;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public int getId_producto() {
	return id_producto;
}

public int setId_producto(int id_producto) {
	return this.id_producto = id_producto;
}


public double getPrecio() {
	return precio;
}


public void setPrecio(double precio) {
	this.precio = precio;
}


@Override
public String toString() {
	return "Producto [articulo=" + nombre + ", cantidad=" + cantidad + ", id_stock=" + id_producto + ", precio=" + precio
			+ "]";
}

public int size() {
	// TODO Auto-generated method stub
	return 0;
}






}
