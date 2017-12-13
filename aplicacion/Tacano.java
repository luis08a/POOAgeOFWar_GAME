package aplicacion;

import java.io.Serializable;

public class Tacano extends Maquina implements Serializable{

	public Tacano(Base n) {
		super(n);
	}

	@Override
	public void desicion(Arena a) {
		try {
			avanzarEra();
		}catch(PAOWException e){
			Unidad u = crearSoldadoMelee(); a.ponerUnidad(b, u);
		}
	}
	
	@Override
	public void avanzarEra() throws PAOWException{
		b.aumentarEra();
	}
}
