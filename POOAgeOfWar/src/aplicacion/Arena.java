package aplicacion;

public class Arena {
	private Unidad[][] arena;
	private Unidad[][] temp;
	private Base b1;
	private Base b2;
	private Unidad v;
	
	
	public Arena(){
		 v= new VacioUnidades(0);
		 //adentro = ad, es lo que permite que dos soldados se enfrenten cuando se encuentran, es el espacio en la arena
		 Unidad[] ad={v,v};
		 Unidad[] ad2={v,v};
		 Unidad[] ad3={v,v};
		 Unidad[] ad4={v,v};
		 Unidad[] ad5={v,v};
		 Unidad[] ad6={v,v};
		 Unidad[] ad7={v,v};
		 Unidad[] ad8={v,v};
		 Unidad[] ad9={v,v};
		 Unidad[] ad10={v,v};
		 Unidad[] ad11={v,v};
		 Unidad[] ad12={v,v};
		 Unidad[] ad13={v,v};
		 Unidad[] ad14={v,v};
		 Unidad[] ad15={v,v};
		 Unidad[] ad16={v,v};
		 Unidad[] ad17={v,v};
		 Unidad[] ad18={v,v};
		 
		 b1= new Base(1,0);
		 //b1 adentro contiene la base y la segunda posicion funciona como spawn
		 
		 Unidad b1Ad[]={b1,v};
		 b2=new Base(-1,1);
		 Unidad b2Ad[]={v,b2};
		arena=new Unidad[][] {b1Ad,ad,ad2,ad3,ad4,ad5,ad6,ad7,ad8,ad9,ad10,ad11,ad12,ad13,ad14,ad15,ad16,ad17,ad18,b2Ad};
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
		Unidad[] vac={v,v};
		Unidad[] vac2={v,v};
		Unidad[] vac3={v,v};
		Unidad[] vac4={v,v};
		Unidad[] vac5={v,v};
		Unidad[] vac6={v,v};
		Unidad[] vac7={v,v};
		Unidad[] vac8={v,v};
		Unidad[] vac9={v,v};
		Unidad[] vac10={v,v};
		Unidad[] vac11={v,v};
		Unidad[] vac12={v,v};
		Unidad[] vac13={v,v};
		Unidad[] vac14={v,v};
		Unidad[] vac15={v,v};
		Unidad[] vac16={v,v};
		Unidad[] vac17={v,v};
		Unidad[] vac18={v,v};
		
		temp=new Unidad[][] {vac,vac2,vac3,vac4,vac5,vac6,vac7,vac8,vac9,vac10,vac11,vac12,vac13,vac14,vac15,vac16,vac17,vac18};
		
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
				Unidad elsiguiente=arena[i+siguiente][0];
				Unidad aliado=arena[i+siguiente][0];
				 System.out.println(" entra a leer ");
				 
				 //System.out.println(elsiguiente.getTipo()+" tipo siguinte"+";actual "+elemento.getTipo());
				 System.out.println(elemento.getPosx()+"=="+(arena.length-2) + " ?");
				 if (elemento.getPosx()==arena.length-2){
					 elemento.ataque(b2);
					 int p= elemento.getPosx();
					 temp[p-1][0]=elemento;
					 System.out.println(b2.getVida()+"vida despues del ataque a base");
					 if (b2.estaMuerto()==true){
						System.out.println("gana jugador");System.exit(0);}
				 }
				 else if (elemento.getTipo()!="vacio"&& elsiguiente.getTipo()=="vacio"){
					 ///if (temp[i-1].getTipo()=="vacio"){
						 //yyyyyySystem.out.println(temp[i+siguiente][0].getTipo()+" tipo en temp");
						 //System.out.println(elemento.getTipo()+" y cont "+cont);
						 cont+=1;
						 System.out.println(elemento.getPosx()+"antes");
						 elemento.moverse(1);
						 //System.out.println(elemento.getBase()+"base a la que pert");
						 System.out.println(elemento.getPosx()+"Despues");
						 int p= elemento.getPosx();
						 temp[p-1][0]=elemento;
						 
					 //}
				 }
				 else{
					 
					
					 int p= elemento.getPosx();
					 temp[p-1][0]=elemento;
				 }
			 
			}
			if (arena[i][0].getTipo()== "vacio" && arena[i][1].getTipo()!="vacio"){
				Unidad elemento=arena[i][1];
				int siguiente=arena[i][1].getDirec();
				//elsiguiente se refiere al proximo enemigo que se puede encontrar
				Unidad elsiguiente=temp[i-1][0];
				//
				Unidad aliado=arena[i+siguiente][1];
				
				 //System.out.println(siguiente);
				 //System.out.println(elsiguiente.getTipo()+" tipo siguinte"+";actual "+elemento.getTipo());
				if (elemento.getPosx()==1){
					 elemento.ataque(b1);
					 int p= elemento.getPosx();
					 temp[p-1][0]=elemento;
					 if (b1.estaMuerto()==true){
							System.out.println("gana maquina");System.exit(0);}
				 }
				else if (elemento.getTipo()!="vacio"&& elsiguiente.getTipo()=="vacio"&&aliado.getTipo()=="vacio"){
					 ///if (temp[i-1].getTipo()=="vacio"){
						 System.out.println(temp[i+siguiente][1].getTipo()+" tipo en temp");
						 //System.out.println(elemento.getTipo()+" y cont "+cont);
						 cont+=1;
						 System.out.println(elemento.getPosx()+"antes");
						 elemento.moverse(1);
						 //System.out.println(elemento.getBase()+"base a la que pert");
						 System.out.println(elemento.getPosx()+"Despues");
						 int p= elemento.getPosx();
						 temp[p-1][1]=elemento;
					 //}
				 }
				 else{
						
						
						int p2= elemento.getPosx();
						temp[p2-1][1]=elemento;
					}
			}
			
			else if(arena[i][0].getTipo()!= "vacio" && arena[i][1].getTipo()!="vacio" ){
				Unidad elemento=arena[i][0];
				
				Unidad elemento2=arena[i][1];
				System.out.println("patata");
				elemento.ataque(elemento2);
				int p= elemento.getPosx();
				temp[p-1][0]=elemento;
				
				
				
				elemento2.ataque(elemento);
				int p2= elemento2.getPosx();
				temp[p2-1][1]=elemento2;
				System.out.println(elemento2.getVida()+"vida de elemento 2");
				if (elemento2.estaMuerto()==true){
					Base base= this.getBases(1);
					base.ganaOro(elemento2.getCosto());
					
					temp[p-1][1]=v;System.out.println("boolean True [p-1][1]");
					}
				if (elemento.estaMuerto()==true){temp[p-1][0]=v;
					Base base= this.getBases(1);
					base.ganaOro(elemento.getCosto());
					System.out.println(base.getOro()+" oro base 1");
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
		for(int i=0;i<=17;i++){
			System.out.print("["+temp[i][0].getTipo()+",");
			System.out.print(temp[i][1].getTipo()+"] ,");
		}
		//arena=temp;
		System.out.println();
		//System.out.println(arena[0]);
		for(int i=1;i<=18;i++){
			arena[i][0]=temp[i-1][0];
			arena[i][1]=temp[i-1][1];
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
		if (base.getOro()>= uni.getCosto()){
			System.out.println(base.getOro()+" >= "+uni.getCosto());
			
			//arena[5][0]= new Base(1,0);
			if (spawn==1){arena[spawn][0]=uni;}
			else if (spawn==18){arena[spawn][1]=uni;}
			//arena[spawn]=uni;
			//System.out.println("["+arena[10][0].getTipo()+",");
		}
		else{System.out.println("no hay  dinerodsfsdfsfsfsdf?????????????????????");}
		for(int i=0;i<20;i++){
			System.out.print("["+arena[i][0].getTipo()+",");
			System.out.print(arena[i][1].getTipo()+"] ");
		}
		System.out.println();
		
	}
	
}