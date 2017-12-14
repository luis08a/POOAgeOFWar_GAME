package aplicacion;

import java.io.Serializable;

public class Tacano extends Maquina implements Serializable{
	
	/*
	 * Constructor
	 */
	public Tacano(Base n) {
		super(n);
	}

	@Override
	public void desicion(Arena a) {
		try {
			avanzarEra();
		}catch(PAOWException e){
			Unidad u;
			try {
				u = crearSoldadoMelee();
				a.ponerUnidad(b, u);
			} catch (PAOWException e1) {}
		}
	}
	
	@Override
	public void avanzarEra() throws PAOWException{
		b.aumentarEra();
	}
}
