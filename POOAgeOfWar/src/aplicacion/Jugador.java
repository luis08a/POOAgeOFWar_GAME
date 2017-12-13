package aplicacion;

public abstract class Jugador implements Inteligencia{
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
	public Base getBase() {
		return b;
	}
	
	
	public abstract Unidad crearSoldadoMelee();
	public abstract Unidad crearSoldadoTanque();
	public abstract void avanzarEra();
	public void giveUp() throws PAOWException{
		throw new PAOWException("Jugador se rinde");
	}
}
