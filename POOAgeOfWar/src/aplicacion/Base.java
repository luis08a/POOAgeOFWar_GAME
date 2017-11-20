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
	private   int dir;
	private  int spawn;
	private int i;
	private  Unidad[] unidadesVivas=new Unidad[20];
	
	public Base(int dir,int base){
		super(dir,0);
		numero =base;
		//direccion a la derecha
		//System.out.println("base antes de la condicion "+base);
		if (base==1){spawn=1;}
		//direccion a la izquierda
		else if (base==2) {spawn=18;}
		this.setIsBase(true);
		oro=100;
		System.out.println(dir+"dir base instanciada, spawn "+spawn);
		
	}
	public int getBase(){
		return numero;
	}
	public String getTipo(){
		return tipo;
	}
	
	public  int getSpawn(){
		return spawn;
	}
	public int getDirb(){
		return this.getDirec();
	}
	public  Unidad crearUnidad(String tipo){
		int dir = this.getDirec();
		Soldado s=new Melee(dir,spawn);
		if (tipo=="@"){
			s= new Melee(dir,spawn);
			unidadesVivas[unidadesVivas.length -1]=s;
		}
		return s;
		
	}
		
}
