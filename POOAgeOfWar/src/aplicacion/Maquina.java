package aplicacion;

public abstract class Maquina extends Jugador implements Inteligencia{
	

	public Maquina(Base n) {
		super(n);
	}

	@Override
	public abstract Unidad crearSoldadoMelee() ;

	@Override
	public abstract Unidad crearSoldadoTanque();

}
