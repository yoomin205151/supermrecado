package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class Boleta {
	

private int id_boleta;
private int cantidad;
private Date fecha;
private int id_pedido;
private String dni;

Conexion con = new Conexion();

Connection conexion = con.conectar();

PreparedStatement stmt;

public boolean guardarBoleta(Boleta boletas) {

    String sql = "INSERT INTO supermercado.boleta(id_boleta, id_pedido, id_deposito, fecha, cantidad, dni ) VALUES (?,?,1,?,?,?)"; 
     
    
        try {

            stmt = conexion.prepareStatement(sql);
            stmt.setInt(1,boletas.getId_boleta());
            stmt.setInt(2,boletas.getId_pedido());
            stmt.setDate(3,(java.sql.Date) boletas.getFecha());
            stmt.setInt(4,boletas.getCantidad());
            stmt.setString(5,boletas.getDni());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error");
            return false;
        }
    }

public Boleta(int id_boleta,  Date fecha, int cantidad, int id_pedido, String dni) {
	super();
	this.id_boleta = id_boleta;
	this.fecha = fecha;
	this.cantidad=cantidad;
	this.id_pedido=id_pedido;
	this.dni=dni;
	
}



public Boleta() {
	super();
}



public int getId_boleta() {
	return id_boleta;
}

public void setId_boleta(int id_boleta) {
	this.id_boleta = id_boleta;
}
public int getId_pedido() {
	return id_boleta;
}


public void setId_pedido(int id_pedido) {
	this.id_pedido = id_pedido;
}



public Date getFecha() {
	return fecha;
}

public void setFecha(Date fecha) {
	this.fecha = fecha;
}


public int getCantidad() {
	return cantidad;
}



public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}



@Override
public String toString() {
	return "Boleta [id_boleta=" + id_boleta + ", cantidad=" + cantidad + ", fecha=" + fecha + ", id_pedido="
			+ id_pedido + ", dni=" + dni + "]";
}









}
