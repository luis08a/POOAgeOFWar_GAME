package aplicacion;

public class Melee extends Soldado {
	 
	public Melee(int dir){
		super(dir);
		this.setVida(50);
		this.setDefensa(0);
		this.setRangoAtaque(1);
		this.setTipo("@");
	}
}
