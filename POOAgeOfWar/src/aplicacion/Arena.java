package aplicacion;

public class Arena {
	private Unidad[] arena;
	public Arena(){
		arena=new Unidad[20];
		arena[0]=new Base(1,0);
		arena[-1]=new Base(2,0);
	}
	public void mover(){}
	
	public void ponerUnidad(Base base,String tipo){
		
		Unidad uni=Base.crearUnidad(tipo);
		int spawn=Base.getSpawn();
		arena[spawn]=uni;
		
	}
	
}