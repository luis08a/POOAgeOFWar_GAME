package aplicacion;

public class Humano extends Jugador{
	
	
	public Humano(Base n){
		super(n);
	}
	
	public Unidad crearSoldadoMelee() {
		Unidad m=b.crearUnidad("@");
		return m;
		
	}

	
	public Unidad crearSoldadoTanque() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void avanzarEra() {
		// TODO Auto-generated method stub
		b.aumentarEra();
	}

	@Override
	public void desicion(Arena a) {
		// TODO Auto-generated method stub
		
	}
	
}
