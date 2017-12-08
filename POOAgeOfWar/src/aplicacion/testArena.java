package aplicacion;


import static org.junit.Assert.*;

import org.junit.Test;

public class testArena {

	
	public  testArena() {
		
	}
	
	@Test
	public void deberiaIniciarLaArena(){
		Arena r=Arena.creeArena();
		Base bas=r.getBase(1);
		//System.out.print(bas.getDirb()+"dir base en test");
		//System.out.println(bas.getSpawn());
		try {
			r.ponerUnidad(bas, "@");
		} catch (PAOWException e) {
			
		}
		r.actualizar();
		
		Base bas2=r.getBase(2);
		//System.out.println(bas2.getDirb()+"dir base en test pepe");
		try {
			r.ponerUnidad(bas2, "@");
		} catch (PAOWException e) {
			
		}
		r.actualizar();
		try {
			r.ponerUnidad(bas, "@");
		} catch (PAOWException e) {
			
		}
		
		r.actualizar();		
		try {
			r.ponerUnidad(bas2, "@");
		} catch (PAOWException e) {
			
		}
		r.actualizar();		
		try {
			r.ponerUnidad(bas2, "#");
		} catch (PAOWException e) {
			
		}
		r.actualizar();		
		r.actualizar();		
		r.actualizar();		
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();		
		r.actualizar();		
		r.actualizar();		
		r.actualizar();		
		r.actualizar();		
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		
		/*
		r.actualizar();
		r.ponerUnidad(bas, "@");
		System.out.println("bas act");
		r.actualizar();
		r.actualizar();
		*/
		
		
		
	} 
	/*
	@Test
	public void deberiaPonerEnLaMismaBase(){
		Arena r=new Arena();
		Base bas=r.getBases(1);
		Base bas2=r.getBases(2);	
		
		r.ponerUnidad(bas, "@");
		r.actualizar();
		r.ponerUnidad(bas, "@");
		r.actualizar();
		r.actualizar();
		r.ponerUnidad(bas, "@");
		r.actualizar();
		r.ponerUnidad(bas, "@");
		r.actualizar();
		r.ponerUnidad(bas2, "@");
		
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
		r.actualizar();
	
		
		
	}*/
	

}
