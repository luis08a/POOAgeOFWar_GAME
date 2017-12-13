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
		if (base==0){spawn=1;}
		else if (base==1) {spawn=18;}
		oro=100;
		this.setVida(100);
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
		e.aumentarEra();
	}
	
	public int getEra() {
		return e.eraActual();
	}
	
	public  Unidad crearUnidad(String tipo){
		
		int dir = this.getDirec();
		int eraAc=e.eraActual();
		System.out.println(eraAc);
		Soldado s = new Melee(dir,spawn,eraAc);
		
		if (tipo=="@"){
			s= new Melee(dir,spawn,eraAc);
			
		}
		if (tipo=="#"){
			
			s= new Tanque(dir,spawn);
			
		}
		s.setEra(era);
		return s;
		
	}
		
}
