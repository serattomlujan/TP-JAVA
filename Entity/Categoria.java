package Entity;

public class Categoria {

	private int id_categoria;
	private String nombre;
	
	
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Categoria(){};
	
	@Override
	 public String toString(){
	 return this.getNombre();
	 }
	 
	 @Override
	 public boolean equals(Object o){
	 return (o instanceof Categoria && ((Categoria)o).getId_categoria()==this.getId_categoria());
	 }
	 
	 @Override
	 public int hashCode(){
	 return ((Integer)this.getId_categoria()).hashCode();
	 }
	 
}
