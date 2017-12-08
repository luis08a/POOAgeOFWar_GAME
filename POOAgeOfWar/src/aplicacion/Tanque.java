package aplicacion;

public class Tanque extends Soldado {
	public Tanque(int dir,int spawn){
		super(dir,spawn);
		this.setVida(15);
		this.setAtaque(2);
		this.setDefensa(3);
		this.setRangoAtaque(0);
		this.setTipo("#");
		this.setDevuelve(1);
		this.setCosto(10);
		this.setDirec(dir);
	}
}
