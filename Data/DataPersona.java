package Data;
 import java.util.ArrayList;
 import javax.swing.JOptionPane;
 import java.sql.*;
 import Entity.*;
 import Util.AppDataException;
 import java.security.KeyStore.ProtectionParameter;


public class DataPersona {
	
	public ArrayList<Persona> getAll() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		try {
		 	stmt = FactoryConexion.getInstancia().getConn().createStatement();
		 	rs = stmt.executeQuery("select * from personas");
		 	if(rs!=null){
		 		while(rs.next()){
		 			Persona p=new Persona();
		 			p.setIdpersona(rs.getInt("idpersona"));
		 			p.setNombre(rs.getString("nombre"));
		 			p.setApellido(rs.getString("apellido"));
		 			p.setDni(rs.getString("dni"));
		 			p.setHabilitado(rs.getBoolean("habilitado"));
		 			pers.add(p);
		 						}
		 				}		
			} catch (SQLException e) {throw e;
			} catch (AppDataException ade){
					throw ade;
				 		}
				try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
		 		}
				
 		return pers;
 		}
		 	
		public Persona getByDni(Persona per) throws Exception{
		 		Persona p=null;
		 		PreparedStatement stmt=null;
		 		ResultSet rs=null;
		 		try {
		 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
		 					"select idpersona, nombre, apellido, dni, habilitado from personas where dni=?");
		 			stmt.setString(1, per.getDni());
		 			rs=stmt.executeQuery();
		 			if(rs!=null && rs.next()){
		 					p=new Persona();
		 					p.setIdpersona(rs.getInt("idpersona"));
		 					p.setNombre(rs.getString("nombre"));
		 					p.setApellido(rs.getString("apellido"));
		 					p.setDni(rs.getString("dni"));
		 					p.setHabilitado(rs.getBoolean("habilitado"));
		 			}
		 			
		} catch (Exception e) {
		throw e;
		}
		finally{
		try {
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
		throw e;
			}
		 }
				
		 return p;
		}
		 	
		public void add(Persona p) throws Exception{
		 		PreparedStatement stmt=null;
		 		ResultSet keyResultSet=null;
		 		try {
		 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
		 					"insert into personas(dni, nombre, apellido, habilitado) values (?,?,?,?)",
		 					PreparedStatement.RETURN_GENERATED_KEYS
		 					);
		 			stmt.setString(1, p.getDni());
		 			stmt.setString(2, p.getNombre());
		 			stmt.setString(3, p.getApellido());
		 			stmt.setBoolean(4, p.getHabilitado());
		 			stmt.executeUpdate();
		 			keyResultSet=stmt.getGeneratedKeys();
		 			if(keyResultSet!=null && keyResultSet.next()){
		 				p.setIdpersona(keyResultSet.getInt(1));
		 			}
		 		} catch (SQLException | AppDataException e) {
		 			throw e;
		 		}
		 		try {
		 			if(keyResultSet!=null)keyResultSet.close();
		 			if(stmt!=null)stmt.close();
		 			FactoryConexion.getInstancia().releaseConn();
		 		} catch (SQLException e) {
		 			e.printStackTrace();
		 		}
		 	}
		 			 		 
		 }
		
	
	
	
	
	
	
	

