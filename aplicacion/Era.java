package aplicacion;

import java.io.Serializable;

public  class Era implements Serializable{
	public static final int MAX_ERA = 4; 
	private int costo = 180;
	
	private int era;
	
	public Era (){
		era=1;
	}
	public int eraActual(){
		return era;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public void aumentarEra() {
		if (era<MAX_ERA) {
			era+=1;
			costo+=90;
		}
	}
}
