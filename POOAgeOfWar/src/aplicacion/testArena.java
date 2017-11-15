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
		System.out.println(bas.getSpawn());
		r.ponerUnidad(bas, "@");
		r.actualizar();
	}
	

}
