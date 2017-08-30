package data;
import java.util.ArrayList;
import java.sql.*;

import util.AppDataException;
import entity.*;


public class DataElemento {
	public ArrayList<Elemento> getAll() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento> ele= new ArrayList<Elemento>();
		try {
		 	stmt = FactoryConexion.getInstancia().getConn().createStatement();
		 	rs = stmt.executeQuery("select * from elementos e "
		 			+ "inner join tipo_elemento te on e.idtipo_elemento=te.idtipo_elemento");
		 	if(rs!=null){
		 		while(rs.next()){
		 			Elemento el=new Elemento();
		 			el.setTipo_Elem(new Tipo_Elemento());
		 			el.setIdelemento(rs.getInt("idelemento"));
		 			el.setNombre(rs.getString("nombre"));
		 			el.getTipo_Elem().setIdtipo_elemento(rs.getInt("idtipo_elemento"));
		 			el.getTipo_Elem().setNombre_tipo(rs.getString("nombre_tipo"));
		 			ele.add(el);
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
				
 		return ele;
 		}
	
	public Elemento getByNombre(Elemento elem) throws Exception{
 		Elemento el=null;
 		PreparedStatement stmt=null;
 		ResultSet rs=null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"select idelemento, e.nombre, e.idtipo_elemento, nombre_tipo from elementos e "
 					+ "inner join tipo_elemento t on e.idtipo_elemento=t.idtipo_elemento where nombre=?");
 			stmt.setString(1, elem.getNombre());
 			rs=stmt.executeQuery();
 			if(rs!=null && rs.next()){
 					el=new Elemento();
 					el.setTipo_Elem(new Tipo_Elemento());
 					el.setIdelemento(rs.getInt("idelemento"));
 					el.setNombre(rs.getString("nombre"));
 					el.getTipo_Elem().setIdtipo_elemento(rs.getInt("idtipo_elemento"));
 					el.getTipo_Elem().setNombre_tipo(rs.getString("nombre_tipo"));
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
		
 return el;
}
	public void add(Elemento el) throws Exception{
 		PreparedStatement stmt=null;
 		ResultSet keyResultSet=null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"insert into elementos(nombre, idtipo_elemento) values (?,?)",
 					PreparedStatement.RETURN_GENERATED_KEYS
 					);
 			stmt.setString(1, el.getNombre());
 			stmt.setInt(2, el.getTipo_Elem().getIdtipo_elemento());
 			stmt.executeUpdate();
 			keyResultSet=stmt.getGeneratedKeys();
 			if(keyResultSet!=null && keyResultSet.next()){
 				el.setIdelemento(keyResultSet.getInt(1));
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
 	
	public void remove(Elemento el) throws Exception{
 		PreparedStatement stmt=null;
 		ResultSet keyResultSet=null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"delete * from elementos where nombre=?",
 					PreparedStatement.RETURN_GENERATED_KEYS
 					);
 			stmt.executeQuery();
 			
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
