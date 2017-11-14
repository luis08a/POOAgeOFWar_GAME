package aplicacion;

public abstract class Soldado extends Unidad {
	private int rangoAtaque;
	
	

	public Soldado(int dir){
		super(dir);
	}
	public int getRangoAtaque() {
		return rangoAtaque;
	}

	public void setRangoAtaque(int rangoAtaque) {
		this.rangoAtaque = rangoAtaque;
	}
	
	public void moverse(int distancia){
		this.setPosx(distancia);
		
		
	}
}
