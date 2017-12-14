package aplicacion;

import java.io.Serializable;

public class Humano extends Jugador implements Serializable{
	
	/*
	 * Constructor
	 */
	public Humano(Base n){
		super(n);
	}
	
	@Override
	public void desicion(Arena a) {
	}
	
}
