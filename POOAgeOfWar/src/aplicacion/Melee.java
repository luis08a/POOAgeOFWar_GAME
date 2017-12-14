package aplicacion;

import java.io.Serializable;

public class Melee extends Soldado implements Serializable{
	 
	/*
	 * Constructor
	 * @param dir: dirección, referente a la arena, en la cual se moverá. spawn: base 
	 */
	public Melee(int dir,int spawn,int era){
		super(dir,spawn);
		this.setDirec(dir);
		this.setTipo("@");
		
		if (era ==1){
			meleeE1();
		}
		else if (era ==2){
			meleeE2();
		}
		else if (era ==3){
			meleeE3();
		}
		else if (era ==4){
			meleeE4();
		}
	}
	
	private void meleeE1(){
		
		this.setVida(10);
		this.setAtaque(1);
		this.setDefensa(0);		
		this.setDevuelve(1);
		this.setCosto(5);
		
	}
	private void meleeE2(){
		
		this.setVida(10);
		this.setAtaque(5);
		this.setDefensa(5);			
		this.setDevuelve(1);
		this.setCosto(15);	
	}
	
	private void meleeE3(){
			
			this.setVida(10);
			this.setAtaque(15);
			this.setDefensa(5);		
			this.setDevuelve(2);
			this.setCosto(20);
			
		}
	private void meleeE4(){
		
		this.setVida(20);
		this.setAtaque(35);
		this.setDefensa(5);		
		this.setDevuelve(3);
		this.setCosto(40);
		
	}
}
