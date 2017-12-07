package aplicacion;

public class Melee extends Soldado {
	 
	/*
	 * Constructor
	 * @param dir: direcci�n, referente a la arena, en la cual se mover�. spawn: base 
	 */
	public Melee(int dir,int spawn){
		
		super(dir,spawn);
		this.setVida(50);
		this.setAtaque(25);
		this.setDefensa(25);
		this.setRangoAtaque(0);
		this.setTipo("@");
		this.setCosto(25);
		this.setDirec(dir);
	}
	
	
}
