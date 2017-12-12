package aplicacion;

public abstract class Maquina extends Jugador implements Inteligencia{
	

	public Maquina(Base n) {
		super(n);
	}

	@Override
	protected Unidad crearSoldadoMelee() {
		return null;
	}

	@Override
	protected Unidad crearSoldadoTanque() {
		return null;
	}

}
