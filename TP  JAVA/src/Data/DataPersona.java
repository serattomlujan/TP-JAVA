package Data;
 import java.util.ArrayList;
 import javax.swing.JOptionPane;
 import java.sql.*;
 import Entity.*;
 import util.AppDataException;
 import java.security.KeyStore.ProtectionParameter;


public class DataPersona {
	
	Statement stmt=null;
	ResultSet rs=null;
	ArrayList<Persona> pers= new ArrayList<Persona>();
	try {
		stmt = FactoryConexion.getInstancia().getConn().createStatement();
		rs= stmt.executeQuery("select * from persona");
		if (rs!=null){ while(rs.next()){
			Persona p=new Persona();
			p.setIdpersona(rs.getInt("id"));
			p.setDni(rs.getString("dni"));
			p.setNombre(rs.getString("nombre"));
			p.setApellido(rs.getString("apellido"));
			p.setUsuario(rs.getString("usuario"));
			p.setContrasenia(rs.getString("contrasenia"));
			p.setHabilitado(rs.getBoolean("habilitado"));
			pers.add(p);			
		}
	
		}catch (SQLException e){throw e;} catch(AppDataException ade){throw ade;}
	    
	try {if (rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	FactoryConexion.getInstancia().releaseConn();} catch(SQLException e){e.printStackTrace();}
	return pers;	

}






public Persona getByDni(Persona per) throw Exception{
	Persona p=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	ResultSet rs=null;
	try{
		stmt=FactoryConexion.getInstancia().getConn().prepareStatement("select id, dni, nombre, apellido, usuario, contrasenia, habilitado from persona where dni=?");
		stmt.setString(1, per.getDni());
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()){
			p=new Persona();
			p.setIdpersona(rs.getInt("id"));
			p.setDni(rs.getString("dni"));
			p.setNombre(rs.getString("nombre"));
			p.setApellido(rs.getString("apellido"));
			p.setUsuario(rs.getString("usuario"));
			p.setContrasenia(rs.getString("contrasenia"));
			p.setHabilitado(rs.getBoolean("habilitado"));
		}
		
	}catch (exception e){throw e;} finally {try{if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	FactoryConexion.getInstancia().releaseConn();}
	catch(SQLException e){throw e}}
	return p;	
	
}




public void add(Persona p) throws Exception{
	PreparedStatement stmt=null;
	ResultSet keyResultSet=null;
	try{stmt=FactoryConexion.getInstancia().getConn()
			.prepareStatement("insert into persona(dni, id, nombre, apellido, usuario, contrasenia, habilitado) values (?,?,?,?,?,?,?)",
			PreparedStatement.RETURN_GENERATED_KEYS);}
	
	stmt.setString(1, p.getDni());
	stmt.setInt(2, p.getIdpersona());
	stmt.setString(3, p.getNombre());
	stmt.setString(4, p.getApellido());
	stmt.setString(5, p.getUsuario());
	stmt.setString(6, p.getContrasenia());
	stmt.setBoolean(7, p.isHabilitado());
	stmt.executeUpdate();
	keyResultSet=stmt.getGeneratedKeys();
	if(keyResultSet!=null && keyResultSet.next()){
	  p.setIdpersona(keyResultSet.getInt(1));{
		  
	  }	catch(SQLException | AppDataExpection e){throw e} 
	  try{  if(keyResultSet!=null)keyResultSet.close();
	  if(stmt!=null)stmt.close();
	  FactoryConexion.getInstancia().releaseConn();
} catch (SQLException e) {e.printStackTrace();}
		  
	  }
		
	}
	
	
	
	
	
	
	
	
	
	
}
