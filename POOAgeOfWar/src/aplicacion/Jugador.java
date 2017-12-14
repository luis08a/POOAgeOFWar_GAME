package aplicacion;

import java.io.Serializable;

public abstract class Jugador implements Inteligencia,Serializable{
	protected final Base b;
	
	public Jugador(Base n){
		b=n;
	}
	
	public Base getBase() {
		return b;
	}
	
	public void avanzarEra() throws PAOWException{
		b.aumentarEra();
	}

	public void desicion(Arena a) {
	}
	
	public Unidad crearSoldadoMelee() throws PAOWException {
		Unidad m=b.crearUnidad("@");
		return m;
	}

	public Unidad crearSoldadoTanque() throws PAOWException {
		Unidad m=b.crearUnidad("#");
		return m;
	}

	public void giveUp() throws PAOWException{
		throw new PAOWException("Jugador se rinde");
	}
}
