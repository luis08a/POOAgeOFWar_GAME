package aplicacion;

public class Ingenuo extends Maquina {
	private static Ingenuo i;
	
	/*
	 * Constructor
	 */
	Ingenuo(Base n) {
		super(n);
	}
	

	/*
	 * permite crear una única instancia de la clase Ingenuo
	 * @return La única instancia de Ingenuo
	 */
	public static Ingenuo getIA(Base n) {
		if (i == null) {
			i = new Ingenuo(n);
		}
		return i;
	}

	@Override
	public void desicion(Arena a) {
		
		int n = (int) (Math.random()* 200) + 1;
		if (n % 11 == 0) {Unidad u = crearSoldadoMelee();a.ponerUnidad(b, u);}
		else if ( n % 37 == 0) {Unidad u = crearSoldadoTanque();a.ponerUnidad(b, u);}
		else if(n % 41 == 0) {
			try {
				avanzarEra();
			} catch (PAOWException e) {
			}
		}
	}

}
