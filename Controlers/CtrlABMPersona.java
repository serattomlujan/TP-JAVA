package Controlers;
import java.util.ArrayList;
import Data.DataCategoria;
import Data.DataPersona;
import Entity.Persona;
import Entity.Categoria;

public class CtrlABMPersona {
	private DataPersona dataPer;
	private DataCategoria dataCat;
	private ArrayList<Persona> pers;
	
	
	public CtrlABMPersona(){
	dataPer= new DataPersona();
	pers= new ArrayList<Persona>();
	pers.add(new Persona("343434","Hugo","Lopez",true));
	pers.add(new Persona("353535","Ana","Martinez",true));}
	
	
	public void add(Persona p) throws Exception{
		dataPer.add(p);}
	
	
   public void delete(Persona p) throws Exception{
	   this.pers.remove(p);}
   
		
	public void update(Persona p) throws Exception{
		this.delete(p);
		this.add(p);}
		
		
		
	public Persona getByDni(Persona p) throws Exception{
	return this.dataPer.getByDni(p);
	}	
		
	
	public Persona getByDni(String dni) throws Exception{
	Persona p=new Persona();
	p.setDni(dni);
	return getByDni(p);
	}
	
	
	public Persona getByNombreApellido(Persona p){
		for(int i=0; i<this.pers.size(); i++){
		if(pers.get(i).getNombre().equalsIgnoreCase(p.getNombre())
		 && pers.get(i).getApellido().equalsIgnoreCase(p.getApellido())){return pers.get(i);}}
		return null; 
		}

	
	public ArrayList<Persona>getAll() throws Exception{
		return dataPer.getAll();}
	
	public ArrayList<Categoria> getCategorias() throws Exception{
		 return dataCat.getAll();
		}
		
		
	}