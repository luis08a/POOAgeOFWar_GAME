package aplicacion;

public class Arena {
	private Unidad[] arena;
	private Unidad[] temp;
	public Arena(){
		arena=new Unidad[20];
		arena[0]=new Base(1,0);
		arena[-1]=new Base(2,0);
		//vector temporal para guardar la actualizacion
		temp=new Unidad[20];
		temp[0]=new Base(1,0);
		temp[-1]=new Base(2,0);
		while(arena[0].getVida()!=0 && arena[0].getVida()!=0 ){
			for (int i=1;i<arena.length;i++){
				 Unidad elemento=arena[i];
				 elemento.setPosx(1);
				 int p= elemento.getPosx();
				 temp[p]=elemento;
			}
			arena=temp;
			System.out.println(temp);
		}
	}
	public void mover(){}
	
	public void ponerUnidad(Base base,String tipo){
		
		Unidad uni=Base.crearUnidad(tipo);
		int spawn=Base.getSpawn();
		arena[spawn]=uni;
		
	}
	
}