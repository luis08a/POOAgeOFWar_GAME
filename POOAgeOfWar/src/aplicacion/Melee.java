package aplicacion;

public class Melee extends Soldado {
	 
	/*
	 * Constructor
	 * @param dir: dirección, referente a la arena, en la cual se moverá. spawn: base 
	 */
	public Melee(int dir,int spawn){
		
		super(dir,spawn);
		this.setVida(10);
		this.setAtaque(1);
		this.setDefensa(0);
		this.setRangoAtaque(0);
		this.setTipo("@");
		this.setDevuelve(1);
		this.setCosto(5);
		this.setDirec(dir);
	}
	
	
}
