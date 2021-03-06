package Data;
import java.util.ArrayList;


import java.sql.*;

import Entity.*;
import Util.AppDataException;


public class DataTipoElemento {
	
	public ArrayList<Tipo_Elemento> getAll() throws Exception{

		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Tipo_Elemento> tipos= new ArrayList<Tipo_Elemento>();
		try{
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs = stmt.executeQuery("select * from tipo_elemento");
			if(rs!=null){
				while(rs.next()){
					Tipo_Elemento t=new Tipo_Elemento();
					t.setIdtipo_elemento(rs.getInt("idtipo_elemento"));
					t.setNombre(rs.getString("nombre"));
					t.setCant_max(rs.getInt("cant_max"));
					t.setLim_tiempo(rs.getInt("lim_tiempo"));
					t.setDias_anticip(rs.getInt("dias_anticip"));
					t.setEncargado(rs.getBoolean("encargado"));
					tipos.add(t);
					}
				}
			} catch (Exception e){
				throw e;
			}
			
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return tipos;
		}
	
	public Tipo_Elemento getByNomTipo(Tipo_Elemento te) throws Exception{
 		Tipo_Elemento t=null;
 		PreparedStatement stmt=null;
 		ResultSet rs=null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"select * from tipo_elemento where nombre=?");
 			stmt.setString(1, te.getNombre());
 			rs=stmt.executeQuery();
 			if(rs!=null && rs.next()){
 					t=new Tipo_Elemento();
 					t.setIdtipo_elemento(rs.getInt("idtipo_elemento"));
 					t.setNombre(rs.getString("nombre"));
  					t.setCant_max(rs.getInt("cant_max"));
 					t.setLim_tiempo(rs.getInt("lim_tiempo"));
 					t.setDias_anticip(rs.getInt("dias_anticip"));
 					t.setEncargado(rs.getBoolean("encargado"));
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
		
 return t;
}
	public void add(Tipo_Elemento t) throws Exception{
 		PreparedStatement stmt=null;
 		ResultSet keyResultSet=null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"insert into tipo_elemento(nombre, cant_max, lim_tiempo, dias_anticip, encargado) values (?,?,?,?.?)",
 					PreparedStatement.RETURN_GENERATED_KEYS
 					);
 			stmt.setString(1, t.getNombre());
 			stmt.setInt(2, t.getCant_max());
 			stmt.setInt(3, t.getLim_tiempo());
 			stmt.setInt(4, t.getDias_anticip());
 			stmt.setBoolean(5, t.getEncargado());
 			stmt.executeUpdate();
 			keyResultSet=stmt.getGeneratedKeys();
 			if(keyResultSet!=null && keyResultSet.next()){
 				t.setIdtipo_elemento((keyResultSet.getInt(1)));
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
