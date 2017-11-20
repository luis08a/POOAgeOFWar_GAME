package aplicacion;

public class Arena {
	private Unidad[] arena;
	private Unidad[] temp;
	private Base b1;
	private Base b2;
	private Unidad v;
	public Arena(){
		 v= new VacioUnidades(0);
		 b1= new Base(1,1);
		 b2=new Base(-1,2);
		arena=new Unidad[] {b1,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,b2};
		//arena=new Unidad[20];
		//arena[0]=new Base(1,0);
		//arena[-1]=new Base(2,0);
		for(int i=0;i<20;i++){
			System.out.print(arena[i].getTipo()+",");
		}
		System.out.println();
		//vector temporal para guardar la actualizacion
		//System.out.println(b1.getDirb()+"b1.getdirt");
	}
	/*
	 * esta funcion actualiza el tablero y hace que los soldados se muevan
	 * */
	public void actualizar(){
		temp=new Unidad[]{v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v,v};
		//temp[0]=new Base(1,0);
		//temp[19]=new Base(2,0);
		System.out.println(temp.length);
		int cont=0;
		for (int i=1;i<arena.length-1;i++){
			 Unidad elemento=arena[i];
			 int siguiente=arena[i].getDirec();
			 Unidad elsiguiente=arena[i+siguiente+siguiente];
			 System.out.println(siguiente);
			 System.out.println(elsiguiente.getTipo()+" tipo siguinte"+";actual "+elemento.getTipo());
			 if (elemento.getTipo()!="vacio"&& elsiguiente.getTipo()=="vacio"){
				 ///if (temp[i-1].getTipo()=="vacio"){
					 System.out.println(temp[i+siguiente].getTipo()+" tipo en temp");
					 //System.out.println(elemento.getTipo()+" y cont "+cont);
					 cont+=1;
					 //System.out.println(elemento.getPosx()+"antes");
					 elemento.moverse(1);
					 //System.out.println(elemento.getBase()+"base a la que pert");
					 //System.out.println(elemento.getPosx()+"Despues");
					 int p= elemento.getPosx();
					 temp[p]=elemento;
				 //}
				 //System.out.println(temp[p].getTipo());
				 //System.out.println(p+" ppp");
			 }
			 else if (elemento.getTipo()!="vacio"&& elsiguiente.getTipo()!="vacio"){
				 if (temp[i+siguiente].getTipo()=="vacio"){
					 int p= elemento.getPosx();
					 System.out.println(p+" ppp");
					 temp[p+siguiente]=elemento;
					 //atacar
				 }
				 
				}
			 
		}
		for(int i=0;i<17;i++){
			System.out.print(temp[i].getTipo()+",");
		}
		//arena=temp;
		System.out.println();
		//System.out.println(arena[0]);
		for(int i=0;i<=17;i++){
			arena[i+1]=temp[i];
			//System.out.print(arena[i].getTipo()+",");
			//System.out.println(temp[i].getTipo() + ",");
		}
		for(int i=0;i<20;i++){
			System.out.print(arena[i].getTipo()+",");
		}
		System.out.println(" ");
		System.out.println(" ");
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
		//System.out.println("instancia de unidad en la arena");
		//System.out.println(base.getDirb()+"dir base con get dir");
		Unidad uni=base.crearUnidad(tipo);
		int spawn=base.getSpawn();
		//System.out.println(spawn);
		arena[spawn]=uni;
		for(int i=0;i<20;i++){
			System.out.print(arena[i].getTipo()+",");
		}
		System.out.println();
		
	}
	
}