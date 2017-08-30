

package Entity;

public class Tipo_Elemento {
private int idtipo_elemento;
private String nombre;
private int cant_max;
private int lim_tiempo;
private int dias_anticip;
private boolean encargado;


public int getIdtipo_elemento() {
	return idtipo_elemento;
}
public void setIdtipo_elemento(int idtipo_elemento) {
	this.idtipo_elemento = idtipo_elemento;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getCant_max() {
	return cant_max;
}
public void setCant_max(int cant_max) {
	this.cant_max = cant_max;
}
public int getLim_tiempo() {
	return lim_tiempo;
}
public void setLim_tiempo(int lim_tiempo) {
	this.lim_tiempo = lim_tiempo;
}
public int getDias_anticip() {
	return dias_anticip;
}
public void setDias_anticip(int dias_anticip) {
	this.dias_anticip = dias_anticip;
}
public boolean getEncargado() {
	return encargado;
}
public void setEncargado(boolean encargado) {
	this.encargado = encargado;
}
	
@Override
public String toString(){
return this.getNombre();
}

@Override
public boolean equals(Object o){
return (o instanceof Tipo_Elemento && ((Tipo_Elemento)o).getIdtipo_elemento()==this.getIdtipo_elemento());
}

@Override
public int hashCode(){
return ((Integer)this.getIdtipo_elemento()).hashCode();
}
	
	
}
