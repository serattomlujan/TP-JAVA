package controlers;

import.java.util.arrayList;

import entity.Reserva;
import entity.Persona;
import entity.Elemento;
import data.DataReserva;
import data.DataPersona;
import data.DataElemento;


public class CtrlABMReserva() {
	
	private DataReserva dataRes;
	private DataPersona dataPer;
	private DataElemento dataEle;
	private ArrayList<Reserva> res;
	
	
public CtrlABMReserva() {
	dataRes = new DataReserva();
	dataEle= new DataElemento();
	dataPer= new DataPersona();}
	
	
public void add(Reserva r) throws Exception{
	dataRes.add(r);}

public void delete(Reserva r) throws Exception{
this.res.remove(r);}

public void update(Reserva r) throws Exception{
this.delete(r);
this.add(r);}

public Reserva getByDetalle(Reserva r) throws Exception{
return this.dataRes.getByDetalle(r);}

public Reserva getByDetalle(VARCHAR detalle)throws Exception{
Reserva r=new Reserva();
r.setDetalle(detalle);
return getByDetalle(r);}

public ArrayList<Reserva> getAll()throws Exception{
return dataRes.getAll();}

public ArrayList<Persona> getAll()throws Exception{
return dataPer.getAll();}

public ArrayList<Elemento> getAll()throws Exception{
return dataEle.getAll();}


}
