package aplicacion;

public class Tacano extends Maquina{

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
