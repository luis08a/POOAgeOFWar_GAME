package aplicacion;


import static org.junit.Assert.*;

import org.junit.Test;

public class testArena {

	
	public  testArena() {
		
	}
	@Test
	public void deberiaIniciarLaArena(){
		Arena r=new Arena();
		Base bas=r.getBases(1);
		System.out.print(bas.getDirb()+"dir base en test");
		System.out.println(bas.getSpawn());
		r.ponerUnidad(bas, "@");
		r.actualizar();
		Base bas2=r.getBases(2);
		System.out.println(bas2.getDirb()+"dir base en test pepe");
		r.ponerUnidad(bas2, "@");
		r.actualizar();
		/*
		r.actualizar();
		r.ponerUnidad(bas, "@");
		System.out.println("bas act");
		r.actualizar();
		r.actualizar();
		*/
		/*
		Base bas2=r.getBases(2);
		System.out.println(bas2.getDirb()+"dir base en test pepe");
		r.ponerUnidad(bas2, "@");
		r.actualizar();
		*/
		
	}
	

}
