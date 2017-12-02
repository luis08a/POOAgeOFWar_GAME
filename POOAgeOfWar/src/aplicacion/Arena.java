package aplicacion;

public class Arena {
	private static Arena r;
	private static Unidad[][] arena;
	private Unidad[][] temp;
	private Base b1;
	private Base b2;
	private Unidad v;
	
	
	private Arena(){
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
	public static Arena creeArena(){
		if (r==null){
			r=new Arena();
		}
		return r;
	}
	/*
	 * esta funcion actualiza el tablero y hace que los soldados se muevan
	 * */
	public void actualizar(){
		
		for(int i =arena.length-1;i>0;i--){
			
			if (i==18&&arena[i][0].getTipo()!="vacio"){
				
				arena[i][0].ataque(b2);
				 if (b2.estaMuerto()==true){
						System.out.println("gana jugador");//System.exit(0);}
			}
			}
			
			else if (i<arena.length-1){
				if(arena[i][1].getTipo()!="vacio"){
					arena[i][0].ataque(arena[i][1]);
					if (arena[i][1].estaMuerto()==true){
						Base base= this.getBases(1);
						base.ganaOro(arena[i][1].getCosto());
						
						arena[i][1]=v;System.out.println("boolean True [p-1][1]");
						}
				}
				else if(arena[i+1][0].getTipo()=="vacio"){
					Unidad t=arena[i+1][0];
					arena[i+1][0]=arena[i][0];
					arena[i][0]=t;
					arena[i][0].mover();
				}				
			}
			
			}
		for(int i =1;i<arena.length-1;i++){
			if (i==1&&arena[i][0].getTipo()!="vacio"){
				arena[i][1].ataque(b1);
				 if (b1.estaMuerto()==true){
						System.out.println("gana maquina");//System.exit(0);}
				 }
			}
			else if (i>1){
				
				if(arena[i][0].getTipo()!="vacio"){
					arena[i][1].ataque(arena[i][0]);
					if (arena[i][0].estaMuerto()==true){
						Base base= this.getBases(2);
						base.ganaOro(arena[i][0].getCosto());
						System.out.println(base.getOro()+" oro base 2");
						arena[i][0]=v;System.out.println("boolean True jugador2");
				}
				}
				else if(arena[i-1][1].getTipo()=="vacio"){
					final Unidad t=arena[i-1][1];
					arena[i-1][1]=arena[i][1];
					arena[i][1]=t;
					arena[i][1].mover();
				}				
			}
			
			}
		for(int i=0;i<20;i++){
			System.out.print("["+arena[i][0].getTipo()+",");
			System.out.print(arena[i][1].getTipo()+"] ");
			
		}
		System.out.println();
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
	public Unidad[][] getArena( ){
		return arena;
	}
	
}
