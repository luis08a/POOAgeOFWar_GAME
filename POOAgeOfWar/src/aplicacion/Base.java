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
	
	private  int spawn;
	private int era;
	private Era e;
	
	
	/*
	 * Constructor
	 * @param dir, dierección en la cual se moveran las unidades asociadas a esta base.
	 */
	public Base(int dir,int base){
		super(dir,0);
		numero =base;
		era=1;
		e = new Era();
		//direccion a la derecha
		//System.out.println("base antes de la condicion "+base);
		//spawn pos grande 0 en 1
		if (base==0){spawn=1;}
		
		//direccion a la izquierda
		//spawn pos grande 19 pos 0
		else if (base==1) {spawn=18;}
		this.setIsBase(true);
		oro=100;
		this.setVida(200);
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
	public void ganaOro(int gana){
		oro+=gana;
	}
	public int getOro(){
		return oro;
	}
	public void compraUnidad(Unidad s){
		oro-=s.getCosto();
	}
	public void aumentarEra(){
		era+=1;
	}
	public  Unidad crearUnidad(String tipo){
		
		int dir = this.getDirec();
		Soldado s=new Melee(dir,spawn);
		
		if (tipo=="@"){
			s= new Melee(dir,spawn);
			e.revisarEra(era, s);
			//oro-=s.getCosto(); 
		}
		if (tipo=="#"){
			
			s= new Tanque(dir,spawn);
			e.revisarEra(era, s);
			//oro-=s.getCosto(); 
			
		}
		
		
		return s;
		
	}
		
}
