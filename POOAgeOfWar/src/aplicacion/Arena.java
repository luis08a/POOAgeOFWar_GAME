package aplicacion;

public class Arena {
	private Unidad[][] arena;
	private Unidad[][] temp;
	private Base b1;
	private Base b2;
	private Unidad v;
	private Unidad[] vac;
	public Arena(){
		 v= new VacioUnidades(0);
		 //adentro = ad, es lo que permite que dos soldados se enfrenten cuando se encuentran, es el espacio en la arena
		 Unidad[] ad={v,v};
		 vac=ad;
		 b1= new Base(1,0);
		 //b1 adentro contiene la base y la segunda posicion funciona como spawn
		 Unidad b1Ad[]={b1,v};
		 b2=new Base(-1,1);
		 Unidad b2Ad[]={v,b2};
		arena=new Unidad[][] {b1Ad,ad,ad,ad,ad,ad,ad,ad,ad,ad,ad,ad,ad,ad,ad,ad,ad,ad,ad,b2Ad};
		//arena=new Unidad[20];
		//arena[0]=new Base(1,0);
		//arena[-1]=new Base(2,0);
		for(int i=0;i<20;i++){
			System.out.print(arena[i][0].getTipo()+",");
			System.out.print(arena[i][1].getTipo()+",");
		}
		System.out.println();
		//vector temporal para guardar la actualizacion
		//System.out.println(b1.getDirb()+"b1.getdirt");
	}
	/*
	 * esta funcion actualiza el tablero y hace que los soldados se muevan
	 * */
	public void actualizar(){
		temp=new Unidad[][] {vac,vac,vac,vac,vac,vac,vac,vac,vac,vac,vac,vac,vac,vac,vac,vac,vac,vac};
		
		//temp[0]=new Base(1,0);
		//temp[19]=new Base(2,0);
		System.out.println(temp.length);
		int cont=0;
		for (int i=1;i<arena.length-1;i++){
			//posC == posicion contraria en el vector
			int pos1=arena[i][0].posLadoContrario();
			if (arena[i][0].getTipo()!= "vacio" && arena[i][1].getTipo()=="vacio"){
				Unidad elemento=arena[i][0];
				int siguiente=arena[i][0].getDirec();
				Unidad elsiguiente=arena[i+siguiente+siguiente][0];
				
				 System.out.println(siguiente);
				 System.out.println(elsiguiente.getTipo()+" tipo siguinte"+";actual "+elemento.getTipo());
				 if (elemento.getTipo()!="vacio"&& elsiguiente.getTipo()=="vacio"){
					 ///if (temp[i-1].getTipo()=="vacio"){
						 System.out.println(temp[i+siguiente][0].getTipo()+" tipo en temp");
						 //System.out.println(elemento.getTipo()+" y cont "+cont);
						 cont+=1;
						 //System.out.println(elemento.getPosx()+"antes");
						 elemento.moverse(1);
						 //System.out.println(elemento.getBase()+"base a la que pert");
						 //System.out.println(elemento.getPosx()+"Despues");
						 int p= elemento.getPosx();
						 temp[p-1][0]=elemento;
					 //}
				 }	 
			 
			}
			if (arena[i][0].getTipo()== "vacio" && arena[i][1].getTipo()!="vacio"){
				Unidad elemento=arena[i][1];
				int siguiente=arena[i][1].getDirec();
				Unidad elsiguiente=arena[i+siguiente+siguiente][1];
				
				 System.out.println(siguiente);
				 System.out.println(elsiguiente.getTipo()+" tipo siguinte"+";actual "+elemento.getTipo());
				 if (elemento.getTipo()!="vacio"&& elsiguiente.getTipo()=="vacio"){
					 ///if (temp[i-1].getTipo()=="vacio"){
						 System.out.println(temp[i+siguiente][1].getTipo()+" tipo en temp");
						 //System.out.println(elemento.getTipo()+" y cont "+cont);
						 cont+=1;
						 //System.out.println(elemento.getPosx()+"antes");
						 elemento.moverse(1);
						 //System.out.println(elemento.getBase()+"base a la que pert");
						 //System.out.println(elemento.getPosx()+"Despues");
						 int p= elemento.getPosx();
						 temp[p][1]=elemento;
					 //}
				 }	 
			}
			/*
			 else if (elemento.getTipo()!="vacio"&& elsiguiente.getTipo()!="vacio"){
				 if (temp[i+siguiente].getTipo()=="vacio"){
					 int p= elemento.getPosx();
					 System.out.println(p+" ppp");
					 temp[p+siguiente]=elemento;
					 //atacar
				 }*/
				 
				} 
		for(int i=0;i<17;i++){
			System.out.print("["+temp[i][0].getTipo()+",");
			System.out.print(temp[i][1].getTipo()+"] ,");
		}
		//arena=temp;
		System.out.println();
		//System.out.println(arena[0]);
		for(int i=1;i<=17;i++){
			arena[i][0]=temp[i][0];
			arena[i][1]=temp[i][1];
			//System.out.print(arena[i].getTipo()+",");
			//System.out.println(temp[i].getTipo() + ",");
		}
		for(int i=0;i<20;i++){
			System.out.print("["+arena[i][0].getTipo()+",");
			System.out.print(arena[i][1].getTipo()+"] ,");
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
		arena[10][0]=uni;
		//if (spawn==1){arena[spawn][0]=uni;}
		//else if (spawn==18){arena[spawn][1]=uni;}
		//arena[spawn]=uni;
		System.out.println("["+arena[10][0].getTipo()+",");
		for(int i=0;i<20;i++){
			System.out.print("["+arena[i][0].getTipo()+",");
			System.out.print(arena[i][1].getTipo()+"] ");
		}
		System.out.println();
		
	}
	
}