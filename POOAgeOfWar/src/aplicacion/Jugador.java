package aplicacion;

public abstract class Jugador implements Inteligencia{
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
	
	public Unidad crearSoldadoMelee() {
		Unidad m=b.crearUnidad("@");
		return m;
	}

	public Unidad crearSoldadoTanque() {
		Unidad m=b.crearUnidad("#");
		return m;
	}

	public void giveUp() throws PAOWException{
		throw new PAOWException("Jugador se rinde");
	}
}
