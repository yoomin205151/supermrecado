package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;




public class Operario extends Usuario  {

	

	
	Conexion con = new Conexion();

    Connection conexion = con.conectar();

    PreparedStatement stmt;
	
	
	
    
    
    public boolean guardarOperario(Operario operarios) {

	    String sql = "INSERT INTO supermercado.usuario(dni,nombre,password,nivel) VALUES (?,?,?,?)"; 
	     
	    
	        try {

	            stmt = conexion.prepareStatement(sql);
	            stmt.setString(1,operarios.getDni());
	            stmt.setString(2,operarios.getNombre());
	            stmt.setString(3,operarios.getPassword());
	            stmt.setInt(4,operarios.getNivel());

	            stmt.executeUpdate();
	            return true;

	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println("error");
	            return false;
	        }
	    }
    
    


public Operario(String nombre, String password, String dni, int nivel) {
	super(nombre, password, dni, nivel);
	
}

public Operario() {
	super();
}




@Override
public String toString() {
	return "Operario [getNombre()=" + getNombre() + ", getDni()=" + getDni() + ", getNivel()=" + getNivel() + "]";
}

}
