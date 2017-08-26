package Entity;

public class Elemento {
	private int idelemento;
	private String nombre;
	private Tipo_Elemento tipo_elemento;
	
	
	public int getIdelemento() {
		return idelemento;
	}
	public void setIdelemento(int idelemento) {
		this.idelemento = idelemento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tipo_Elemento getTipo_Elem(){
		return tipo_elemento;
	}
	
	public void setTipo_Elem(Tipo_Elemento te){
		this.tipo_elemento=te;
	}
	
	public Elemento (String nombre){
		 this.setNombre(nombre);
		
	}
	public Elemento(){}

}
