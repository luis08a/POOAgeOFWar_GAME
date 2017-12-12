package aplicacion;

public abstract class Jugador {
	protected final Base b;
	public Jugador(Base n){
		b=n;
	}
	
	/*
	public void crearSoldado(){
		crearSoldadoMelee();
		crearSoldadoTanque();
	}
	*/
	abstract Unidad crearSoldadoMelee();
	abstract Unidad crearSoldadoTanque();
	abstract void avanzarEra();
	public void giveUp() throws PAOWException{
		throw new PAOWException("Jugador se rinde");
	}
}
