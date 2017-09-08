package UI;

import java.util.Scanner;
import java.util.ArrayList;

import Entity.Persona;
import Controlers.CtrlABMPersona;

public class ABMCPersonaConsole {
	private Scanner s;
	private CtrlABMPersona ctrl;
	public ABMCPersonaConsole()
	{
		public void start(){
			String rta="";
			boolean continua=true;
			do{ System.out.println("\n\n#############\n");
		     	System.out.println("¿Que accion desea realizar?(Ingrese la letra indicada)");
		     	System.out.println("A- Alta");
		     	System.out.println("B- Baja");
		     	System.out.println("M- Modifica");
		     	System.out.println("C- Consulta");
		     	System.out.println("S- Salir");
		     	rta=s.nextLine();
		     	switch(rta.toLowerCase()){
		     	case "a":
		     		this.alta();
		     		break;
		     	case "b":
		     		this.baja();
		     		break;
		     	case "m":
		     		this.modifica();
		     		break;
		     	case "c":
		     		this.consulta();
		     		break;
		     	case "s":
		     		continua=false;
																																																											     		break;
		     	} while(continua);
		     	s.close();}
		     	
			
			
			private void alta(){
				System.out.println("\n\nNueva persona");
				System.out.println("#############");
				Persona p=new Persona();
				System.out.println("Ingrese id");
				p.setIdpersona(s.nextLine());
				System.out.println("Ingrese dni");
				p.setDni(s.nextLine());
				System.out.println("Ingrese nombre");
				p.setNombre(s.nextLine());
				System.out.println("Ingrese apellido");
				p.setApellido(s.nextLine());
				System.out.println("Ingrese usuario");
				p.setUsuario(s.nextLine());
				System.out.println("Ingrese contraseña");
				p.setContrasenia(s.nextLine());
				System.out.println("¿Está habilitado?(S/N)");
				String h=s.nextLine();
				     if(h.equalsIgnoreCase("S")){
				    	 p.setHabilitado(true);}
				     else if(h.equalsIgnoreCase("N")){
				    	 p.setHabilitado(false); }
					try{ctrl.add(p)
			}catch (Exception e){e.printStackTrace();}}			    		 
			

		
			
			
			
			
			private void baja(){
				System.out.println("\n\nEliminar persona");
				System.out.println("#############");
				Persona p=new Persona();
				System.out.println("Ingrese dni");
				p.setDni(s.nextLine());
				try{ctrl.delete(p);}catch (Exception e){e.printStackTrace();}}
			
								
			
			
			private void modifica(){
				Persona p=new Persona();
				System.out.println("\n\nModificar persona");
				System.out.println("#############");
				System.out.println("Ingrese dni");
				p.setDni(s.nextLine());
				try{this.mostrar(ctrl.getByDni(p));}catch (Exception e){e.printStackTrace();}
				
				
				System.out.println("Ingrese nuevo id");
				p.setIdpersona(s.nextLine());
				System.out.println("Ingrese nuevo dni");
				p.setDni(s.nextLine());
				System.out.println("Ingrese nuevo nombre");
				p.setNombre(s.nextLine());
				System.out.println("Ingrese nuevo apellido");
				p.setApellido(s.nextLine());
				System.out.println("Ingrese nuevo usuario");
				p.setUsuario(s.nextLine());
				System.out.println("Ingrese nuevo contraseña");
				p.setContrasenia(s.nextLine());
				System.out.println("¿Está habilitado?(S/N)");
				String h=s.nextLine();
				     if(h.equalsIgnoreCase("S")){
				    	 p.setHabilitado(true);}
				     else if(h.equalsIgnoreCase("N")){
				    	 p.setHabilitado(false); }
				     try{ctrl.update(p);} catch  (Exception e){e.printStackTrace();}}
				
			
			
			
			
			
			private void consulta(){
				Persona p=new Persona();
				System.out.println("\n\nConsultar persona");
				System.out.println("#############");
				System.out.println("Ingrese opcion");
				System.out.println("1- Listar");
				System.out.println("2- Buscar por dni");
				System.out.println("3- Buscar por Nombre y Apellido");
			   String rta=s.nextLine();
			   switch (rta){
			   case "1":
			   try{this.mostrar(ctrl.getAll());}catch(Exception e1){ e1.printStackTrace();}
			   break;
			   case "2":
				   System.out.println("Ingrese dni");
					p.setDni(s.nextLine());
				   try{this.mostrar(ctrl.getByDni());}catch(Exception e){ e.printStackTrace();}
				   break;
			   case "3":
				   System.out.println("Ingrese nombre");
					p.setNombre(s.nextLine());
					System.out.println("Ingrese apellido");
					p.setApellido(s.nextLine());
				  
				   this.mostrar(ctrl.getByNombreApellido(p));
				   break;
			   default: break;}}
			   
			   
				
										
			
			
			public void mostrar(ArrayList<Persona>personas){
				for(Persona p: personas){mostrar(p);}}
			
			
			
						
			
			public void mostrar(Entity.Persona p){
			String h="";
			if(p.isHabilitado()){h="habilitado";}
			else{h="deshabilitado";}
			System.out.println(p.getDni()+"-" "+p.getApellido" , "+p.getNombre+" :+n);}
			
			
}	
		
			
			
			
			
			


			
			
			
			
			

