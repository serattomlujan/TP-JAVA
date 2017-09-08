package data;
 import java.util.ArrayList;
import java.sql.*;

import util.AppDataException;
import entity.*;
 

public class DataPersona {
	
	public ArrayList<Persona> getAll() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		try {
		 	stmt = FactoryConexion.getInstancia().getConn().createStatement();
		 	rs = stmt.executeQuery("select * from reservas.personas p "
		 			+ "inner join reservas.categorias c on p.id_categoria=c.id_categoria");
		 	if(rs!=null){
		 		while(rs.next()){
		 			Persona p=new Persona();
		 			p.setCategoria(new Categoria());
		 			p.setIdpersona(rs.getInt("idpersona"));
		 			p.setNombre(rs.getString("nombre"));
		 			p.setApellido(rs.getString("apellido"));
		 			p.setDni(rs.getString("dni"));
		 			p.setHabilitado(rs.getBoolean("habilitado"));
		 			p.getCategoria().setId_categoria(rs.getInt("id_categoria"));
		 			p.getCategoria().setDescripcion(rs.getString("descripcion"));
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
		 					"select idpersona, nombre, apellido, dni, habilitado, p.id_categoria, "
		 					+ "c.descripcion from personas p "
		 					+ "inner join categorias c on p.id_categoria=c.id_categoria where dni=?");
		 			stmt.setString(1, per.getDni());
		 			rs=stmt.executeQuery();
		 			if(rs!=null && rs.next()){
		 					p=new Persona();
		 					p.setCategoria(new Categoria());
		 					p.setIdpersona(rs.getInt("idpersona"));
		 					p.setNombre(rs.getString("nombre"));
		 					p.setApellido(rs.getString("apellido"));
		 					p.setDni(rs.getString("dni"));
		 					p.setHabilitado(rs.getBoolean("habilitado"));
		 					p.getCategoria().setId_categoria(rs.getInt("id_categoria"));
		 					p.getCategoria().setDescripcion(rs.getString("descripcion"));
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
		 					"insert into personas(dni, nombre, apellido, habilitado, id_categoria) "
		 					+ "values (?,?,?,?,?)",
		 					PreparedStatement.RETURN_GENERATED_KEYS
		 					);
		 			stmt.setString(1, p.getDni());
		 			stmt.setString(2, p.getNombre());
		 			stmt.setString(3, p.getApellido());
		 			stmt.setBoolean(4, p.getHabilitado());
		 			stmt.setInt(5, p.getCategoria().getId_categoria());
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
		
		public void remove(Persona p) throws Exception{
	 		PreparedStatement stmt=null;
	 		
	 		try {
	 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
	 					"delete from personas where dni=?",
	 					PreparedStatement.RETURN_GENERATED_KEYS
	 					);
	 			stmt.setString(1, p.getDni());
	 			stmt.executeUpdate();
	 			
	 		} catch (SQLException | AppDataException e) {
	 			throw e;
	 		}
	 		try {
	 			
	 			if(stmt!=null)stmt.close();
	 			FactoryConexion.getInstancia().releaseConn();
	 		} catch (SQLException e) {
	 			e.printStackTrace();
	 		}
	 	}
	 		
		
		public void modificar(Persona p) throws Exception{
	 		PreparedStatement stmt=null;
	 		
	 		try {
	 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
	 					"update personas set dni=?, nombre=?, apellido=?, habilitado=?, id_categoria=? where dni=?",
	 					PreparedStatement.RETURN_GENERATED_KEYS
	 					);
	 			stmt.setInt(1, p.getIdpersona());
	 			stmt.setString(2, p.getDni());
	 			stmt.setString(3, p.getNombre());
	 			stmt.setString(4, p.getApellido());
	 			stmt.setBoolean(5, p.getHabilitado());
	 			stmt.setInt(6, p.getCategoria().getId_categoria());
	 			stmt.executeUpdate();
	 				 			 			
	 		}catch (SQLException | AppDataException e) {
	 			throw e;
	 		}
	 		try {
	 			if(stmt!=null)stmt.close();
	 			FactoryConexion.getInstancia().releaseConn();
	 		} catch (SQLException e) {
	 			e.printStackTrace();
	 		}
	 	}
}		 		 
		 
		
	
	
	
	
	
	
	

