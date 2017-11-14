package aplicacion;

public class Base extends Unidad {
	private int oro;
	private int experiecia;
	private String tipo="#";
	private int numero;
	//direccion de ataque de unidades = dir
	//si la base es la numero 1 la direccion es
	//hacia la derecha, si no, la direccion es
	//hacia la izquierda(multiplicando -1)
	private static int dir;
	private static int spawn;
	private static Unidad[] unidadesVivas;
	
	public Base(int base,int dir){
		super(dir);
		numero =base;
		//direccion a la derecha
		if (base==1){dir=1;spawn=1;}
		//direccion a la izquierda
		else {dir=-1;spawn=-2;}
		
		oro=100;
		
	}
	public int getBase(){
		return numero;
	}
	public String getTipo(){
		return tipo;
	}
	public int mover(){
		
		return 1;
	}
	public static int getSpawn(){
		return spawn;
	}
	public static Unidad crearUnidad(String tipo){
		Soldado s=new Melee(dir);
		if (tipo=="@"){
			s= new Melee(dir);
			unidadesVivas[-1]=s;
		}
		return s;
		
	}
		
}
