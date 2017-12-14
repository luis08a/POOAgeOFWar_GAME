package aplicacion;

import java.io.Serializable;

public class Base extends Unidad implements Serializable{
	private int oro;
	private int experiecia;
	private String tipo="#";
	private int numero;
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
		else if (base==1) {spawn=98;}
		oro=160;
		this.setVida(100);
		
	}
	
	@Override
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
			throw new PAOWException("Oro insufuciente");
		}
		else if ( e.eraActual()==Era.MAX_ERA) {
			throw new PAOWException("Era máxima alcanzada");
		}
		else {e.aumentarEra();oro-=c;}
	}
	
	public int getEra() {
		return e.eraActual();
	}
	
	public  Unidad crearUnidad(String tipo) throws PAOWException{
		
		int dir = this.getDirec();
		int eraAc=e.eraActual();
		Soldado s = new Melee(dir,spawn,eraAc);
		
		if (tipo=="@"){
			s= new Melee(dir,spawn,eraAc);
			if (s.getCosto()>oro) {s=null;throw new PAOWException("Oro insuficiente");}
		}
		if (tipo=="#"){
			s= new Tanque(dir,spawn, eraAc);
			if (s.getCosto()>oro) {s=null;throw new PAOWException("Oro insuficiente");}
		}
		
		s.setEra(eraAc);
		return s;
	}
		
}
