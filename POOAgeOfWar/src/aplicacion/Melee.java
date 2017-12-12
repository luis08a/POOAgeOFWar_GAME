package aplicacion;

public class Melee extends Soldado {
	 
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
		
		
	}
	
	public void meleeE1(){
		
		this.setVida(10);
		this.setAtaque(1);
		this.setDefensa(0);		
		this.setDevuelve(1);
		this.setCosto(5);
		
	}
	public void meleeE2(){
		
		this.setVida(10);
		this.setAtaque(5);
		this.setDefensa(5);			
		this.setDevuelve(1);
		this.setCosto(15);	
	}
}
