package Controlers;
import java.util.ArrayList;

import Data.DataTipoElemento;
import Entity.Tipo_Elemento;

public class CtrlABMTipoElemento {
		private DataTipoElemento dataTiEl;
		private ArrayList<Tipo_Elemento> te;
		
		
		public CtrlABMTipoElemento(){
		dataTiEl= new DataTipoElemento();
		te= new ArrayList<Tipo_Elemento>();
		}
		
	
	public void add(Tipo_Elemento t) throws Exception{
		dataTiEl.add(t);}
	
	
   public void delete(Tipo_Elemento t) throws Exception{
	   this.te.remove(t);}
   
		
	public void update(Tipo_Elemento t) throws Exception{
		this.delete(t);
		this.add(t);}
		
	public Tipo_Elemento getByNomTipo(Tipo_Elemento t) throws Exception{
		return this.dataTiEl.getByNomTipo(t);
		}	
	
	public Tipo_Elemento getByNomTipo(String nom) throws Exception{
	Tipo_Elemento t=new Tipo_Elemento();
	t.setNombre(nom);
	return getByNomTipo(t);
	}
	public ArrayList<Tipo_Elemento>getAll() throws Exception{
		return dataTiEl.getAll();}
	
}
