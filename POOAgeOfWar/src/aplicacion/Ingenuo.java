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
	 * Crea una unidad en una arena dada
	 * @param a, la arena en la cual se creará la unidad
	 */
	public  void crearUnidad(Arena a) {
		Base b = a.getBase(2);
		try {
			a.ponerUnidad(b, "@");
		} catch (PAOWException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
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
				crearUnidad(a);
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
	void avanzarEra() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void comportamiento(Arena a) {
		// TODO Auto-generated method stub
		int n = (int) (Math.random()* 2) + 1;
		if ( n % 2 == 0) {}
	}
}
