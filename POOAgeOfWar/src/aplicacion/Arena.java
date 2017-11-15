package aplicacion;

public class Arena {
	private Unidad[] arena;
	private Unidad[] temp;
	private Base b1;
	private Base b2;
	private Unidad v;
	public Arena(){
		 v= new VacioUnidades(0);
		 b1= new Base(1,0);
		 b2=new Base(2,0);
		arena=new Unidad[] {b1,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,b2};
		//arena=new Unidad[20];
		//arena[0]=new Base(1,0);
		//arena[-1]=new Base(2,0);
		for(int i=0;i<20;i++){
			System.out.print(arena[i].getTipo()+",");
		}
		System.out.println();
		//vector temporal para guardar la actualizacion
		
	}
	/*
	 * esta funcion actualiza el tablero y hace que los soldados se muevan
	 * */
	public void actualizar(){
		temp=new Unidad[]{v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v};
		//temp[0]=new Base(1,0);
		//temp[19]=new Base(2,0);
		System.out.println(temp.length);
		int cont=0;
		for (int i=1;i<arena.length-2;i++){
			 Unidad elemento=arena[i];
			 if (elemento.getTipo()!="vacio"){
				 elemento.moverse(1);
				 int p= elemento.getPosx();
				 temp[p]=elemento;
				 
				 System.out.println(temp[p].getTipo());
				 System.out.println(p+" ppp");
			 }
			 
		}
		for(int i=0;i<17;i++){
			System.out.print(temp[i].getTipo()+",");
		}
		//arena=temp;
		System.out.println(arena[0]);
		for(int i=0;i<=17;i++){
			arena[i+1]=temp[i];
			System.out.print(arena[i].getTipo()+",");
			//System.out.println(temp[i].getTipo() + ",");
		}
		for(int i=0;i<20;i++){
			System.out.print(arena[i].getTipo()+",");
		}
		
	}
	public static int getLong(){
		int long1= 20;
		return long1;
	}
	
	public Base getBases(int num){
		Base p=b1;
		if (num==1){
			 p=b1;
		}
		else if (num==2){p=b2;}
		return p;
	}
	
	public void ponerUnidad(Base base,String tipo){
		
		Unidad uni=base.crearUnidad(tipo);
		int spawn=base.getSpawn();
		arena[spawn]=uni;
		for(int i=0;i<20;i++){
			System.out.print(arena[i].getTipo()+",");
		}
		System.out.println();
		
	}
	
}