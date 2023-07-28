package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Usuario  {
	private String nombre;
	private String password;
	private String dni;
	private int nivel;
	
	Conexion con = new Conexion();

    Connection conexion = con.conectar();

    PreparedStatement stmt;
	
	public Usuario(String nombre, String password, String dni, int nivel) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.dni = dni;
		this.nivel = nivel;
	}
	
	
	
		
	 public Usuario() {
		
	}

	 public boolean crearPedido(Usuario usuario, Producto productos,int nro_pedido, int cantidad, double precio) {

		    String sql = "INSERT INTO supermercado.pedido(dni,id_producto,nro_pedido,cantidad,precio) VALUES (?,?,?,?,?)"; 
		     
		    
		        try {

		            stmt = conexion.prepareStatement(sql);
		            stmt.setString(1,usuario.getDni());	            
		            stmt.setInt(2,productos.getId_producto());
		            stmt.setInt(3,nro_pedido);
		            stmt.setInt(4,cantidad);
		            stmt.setDouble(5,precio);
		            
		            

		            stmt.executeUpdate();
		            stmt.close();
		            return true;

		        } catch (Exception e) {
		            // TODO: handle exception
		            System.out.println("error");
		            return false;
		        }
		    }


	 public LinkedList<Usuario> LlenarListaUsuario() {

	        String sql ="SELECT * FROM usuario"; 

	        String[] datos = new String[4];

	        LinkedList<Usuario> Usuarios = new LinkedList<Usuario>();
	        try {
	            stmt = conexion.prepareStatement(sql);

	            ResultSet result =  stmt.executeQuery();

	            while(result.next()) {
	                datos[0] = result.getString(1);
	                datos[1] = result.getString(2);
	                datos[2] = result.getString(3);
	                datos[3] = result.getString(4);
	                  // System.out.println("Nombre:" + datos[0] + " tipo: " + datos[1]);
	                   // Orden en constructor:  String nombre, String password, String dni, int nivel
	                   // Orden en base de datos:  dni , nombre , password , nivel
	                   // Mostrar la lista los datos
	                Usuarios.add(new Usuario(datos[1],datos[2],datos[0], Integer.parseInt(datos[3])));
	                
	            }
	            stmt.close();
	            return Usuarios;
	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println("error ");
	            return null;
	        }
	    }
	 
	 public LinkedList<Usuario> LlenarListaUsuarioNivel() {

	        String sql ="SELECT * FROM usuario WHERE nivel>0"; 

	        String[] datos = new String[4];

	        LinkedList<Usuario> Usuarios = new LinkedList<Usuario>();
	        try {
	            stmt = conexion.prepareStatement(sql);

	            ResultSet result =  stmt.executeQuery();

	            while(result.next()) {
	                datos[0] = result.getString(1);
	                datos[1] = result.getString(2);
	                datos[2] = result.getString(3);
	                datos[3] = result.getString(4);
	                  // System.out.println("Nombre:" + datos[0] + " tipo: " + datos[1]);
	                   // Orden en constructor:  String nombre, String password, String dni, int nivel
	                   // Orden en base de datos:  dni , nombre , password , nivel
	                   // Mostrar la lista los datos
	                Usuarios.add(new Usuario(datos[1],datos[2],datos[0], Integer.parseInt(datos[3])));
	                
	            }
	            stmt.close();
	            return Usuarios;
	        } catch (Exception e) {
	            // TODO: handle exception
	            System.out.println("error ");
	            return null;
	        }
	    }
	 
	 public boolean EliminarUsuario(Usuario usuario) {
			

		    try {
		    	String sql = "DELETE FROM usuario WHERE dni =?";
		      stmt = conexion.prepareStatement(sql);
		      stmt.setString(1,usuario.getDni());
		      
		      stmt.executeUpdate();
		      stmt.close();
		      return  true;
		    } catch (Exception e) {
				// TODO: handle exception
				System.out.println("error ");
				return false;
			}
	}
	 
	 public boolean ActualizarUsuario(Usuario usuario)  {
			
			
			try {
				String sql ="UPDATE usuario SET nombre=?,password=?,nivel=? WHERE dni=?";
				stmt = conexion.prepareStatement(sql);
				
				
				stmt.setString(1,usuario.getNombre());
				stmt.setString(2,usuario.getPassword());
				stmt.setInt(3,usuario.getNivel());			
				stmt.setString(4,usuario.getDni());
			    stmt.executeUpdate();
			    stmt.close();
			    return true;
				
			} catch (Exception e) {
				//System.out.println("error ");
				System.out.println("error ");
				return false;
			}
		}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public int getNivel() {
		return nivel;
	}



	public void setNivel(int nivel) {
		this.nivel = nivel;
	}



	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", password=" + password + ", dni=" + dni + ", nivel=" + nivel + "]";
	}



	
}
