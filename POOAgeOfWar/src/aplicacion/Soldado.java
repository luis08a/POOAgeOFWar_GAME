package aplicacion;

public abstract class Soldado extends Unidad {
	private int rangoAtaque;
	
	public Soldado(int dir,int spawn){
		super(dir,spawn);
		
	}
	
	public int getRangoAtaque() {
		return rangoAtaque;
	}

	public void setRangoAtaque(int rangoAtaque) {
		this.rangoAtaque = rangoAtaque;
	}
	
}
	
	

