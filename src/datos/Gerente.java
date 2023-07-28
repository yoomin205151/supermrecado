package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Gerente extends Usuario {

	
	
	Conexion con = new Conexion();

    Connection conexion = con.conectar();

    PreparedStatement stmt;

    
	public Gerente(String nombre, String password, String dni, int nivel) {
		super(nombre, password, dni, nivel);
	}
    
    
	 public Gerente() {
	
	}


	public boolean guardarGerente(Gerente gerentes) {

		    String sql = "INSERT INTO supermercado.usuario(dni,nombre,password,nivel) VALUES (?,?,?,?)"; 
		     
		    
		        try {

		            stmt = conexion.prepareStatement(sql);
		            stmt.setString(1,gerentes.getDni());
		            stmt.setString(2,gerentes.getNombre());
		            stmt.setString(3,gerentes.getPassword());
		            stmt.setInt(4,gerentes.getNivel());

		            stmt.executeUpdate();
		            return true;

		        } catch (Exception e) {
		            // TODO: handle exception
		            System.out.println("error");
		            return false;
		        }
		    }
	
	
}
