package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class Adminventas extends Usuario {
	
	
	Conexion con = new Conexion();

    Connection conexion = con.conectar();

    PreparedStatement stmt;
	
	
	public Adminventas(String nombre, String password, String dni, int nivel) {
		super(nombre, password, dni, nivel);
		
		
	}
	
	
	public Adminventas() {
		super();
	}

	
	public boolean guardarAdminventa(Adminventas adminventas) {

	    String sql = "INSERT INTO supermercado.usuario(dni,nombre,password,nivel ) VALUES (?,?,?,?)"; 

	        try {

	            stmt = conexion.prepareStatement(sql);
	            stmt.setString(1,adminventas.getDni());
	            stmt.setString(2,adminventas.getNombre());
	            stmt.setString(3,adminventas.getPassword());
	            stmt.setInt(4,adminventas.getNivel());

	            stmt.executeUpdate();
	            return true;

	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println("error");
	            return false;
	        }
	    }
	
	


	@Override
	public String toString() {
		return "Adminventas [getNombre()=" + getNombre() + ", getDni()=" + getDni() + ", getNivel()=" + getNivel()
				+ "]";
	}

	

	
	
	
	
	
}
