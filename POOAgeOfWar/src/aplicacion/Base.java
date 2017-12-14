package aplicacion;

import java.io.Serializable;

public class Base extends Unidad implements Serializable{
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
		e = new Era();
		if (base==0){spawn=1;}
		else if (base==1) {spawn=18;}
		oro=160;
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
	public void aumentarEra() throws PAOWException{
		int c= e.getCosto();
		if (oro<c) {
			throw new PAOWException("No hay suiciente oro");
		}
		else {e.aumentarEra();oro-=c;}
	}
	
	public int getEra() {
		return e.eraActual();
	}
	
	public  Unidad crearUnidad(String tipo){
		
		int dir = this.getDirec();
		int eraAc=e.eraActual();
		Soldado s = new Melee(dir,spawn,eraAc);
		
		if (tipo=="@"){
			s= new Melee(dir,spawn,eraAc);
			if (s.getCosto()>oro) {s=null;}
		}
		if (tipo=="#"){
			
			s= new Tanque(dir,spawn, eraAc);
			if (s.getCosto()>oro) {s=null;}
		}
		
		s.setEra(eraAc);
		return s;
	}
		
}
