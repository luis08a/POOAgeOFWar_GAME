package aplicacion;

public class Melee extends Soldado {
	 
	public Melee(int dir,int spawn){
		super(dir,spawn);
		this.setVida(50);
		this.setDefensa(0);
		this.setRangoAtaque(1);
		this.setTipo("@");
		this.setDirec(dir);
	}
	
	
}
