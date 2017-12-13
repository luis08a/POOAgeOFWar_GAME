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
	 * Inicia el comportamiento de la IA.
	 * @param a: arena en la cual añade unidades.
	 */
	public void start(Arena a) {
		boolean start = true;
		while(start) {
			try {
				Thread.sleep(5000);
				//crearUnidad(a);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
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
	public void avanzarEra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desicion(Arena a) {
		/*
		 * int n = (int) (Math.random()* 2) + 1;
		 
		
		if ( n % 2 == 0) {Unidad u = crearSoldadoMelee();a.ponerUnidad(b, u);}
		else { Unidad u = crearSoldadoTanque();a.ponerUnidad(b, u);}
		*/
		Unidad u = crearSoldadoMelee();
		a.ponerUnidad(b, u);
	}

	@Override
	public Unidad crearSoldadoMelee() {
		Unidad m=b.crearUnidad("@");
		return m;
	}

	@Override
	public Unidad crearSoldadoTanque() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
