package aplicacion;

public class Arena {
	private static Arena r;
	private static Unidad[][] arena;
	private Base b1;
	private Base b2;
	private Unidad v;
	private Jugador j1;
	private Jugador j2;
	
	/*
	 * Constructor.
	 */
	private Arena(){
		
		b1= new Base(1,0);
		b2=new Base(-1,1);
		
		Unidad b1Ad[]={b1,null};
		Unidad b2Ad[]={null,b2};
		
		arena=new Unidad[20][2];
		for(int i=0; i<20;i++) {
			if (i==1)arena[i]=b1Ad;
			if(i==19)arena[i]=b2Ad;
			else {
				for (int j=0; j<2; j++) {
					arena[i][j]=null;
				}
			}
		}
	}
	public Jugador getJ1(){
		return j1;
	}
	public Jugador getJ2(){
		return j2;
	}
	public void jugadorVsJugador(){
		j1 = new Humano(b1);
		j2 = new Humano(b2);
	}
	
	public void jugadorVsIA(String IA){
		switch (IA){
		case "Ingenuo": j2=new Ingenuo(b2); 
		case "Tacano": j2= new Tacano(b2);
	}
		
	}
	/*
	 * Actualiza el estado de Arena, para ello hace que las unidades se muevan.
	 * */
	public void actualizar(){
		
		for(int i =arena.length-1;i>0;i--){
			
			if (arena[i][0]==null) continue;
			
			if (i==18 && arena[i][0]!=null){
				
				arena[i][0].ataque(b2);
				
				if (b2.estaMuerto()==true){
						System.out.println("gana jugador"); System.exit(0);
						}
			}
			
			else if (i<arena.length-1){
				if(arena[i][1]!=null){
					arena[i][0].ataque(arena[i][1]);
					if (arena[i][1].estaMuerto()==true){
						Base base= this.getBase(1);
						base.ganaOro(arena[i][1].getCosto());
						
						arena[i][1]=v;System.out.println("boolean True [p-1][1]");
					}
				}
				else if(arena[i+1][0]==null){
					
					Unidad t =null;
					arena[i][0].mover();
					arena[i+1][0] = arena[i][0];
					arena[i][0]=t;
				}				
			}
		}
		
		for(int i =1;i<arena.length-1;i++){
			
			if (arena[i][1]==null) continue;
			
			if (i==1&&arena[i][0]!=null){
				arena[i][1].ataque(b1);
				 if (b1.estaMuerto()==true){
						System.out.println("gana maquina");System.exit(0);}
			}
			else if (i>1){
				
				if(arena[i][0]!=null){
					arena[i][1].ataque(arena[i][0]);
					if (arena[i][0].estaMuerto()==true){
						Base base= this.getBase(2);
						base.ganaOro(arena[i][0].getCosto());
						System.out.println(base.getOro()+" oro base 2");
						arena[i][0]=v;System.out.println("boolean True jugador2");
					}
				}
				else if(arena[i-1][1]==null){
					Unidad t=null;
					arena[i][1].mover();
					arena[i-1][1]=arena[i][1];
					arena[i][1]=t;
				}				
			}
			
		}
		
		for(int i = 0; i<arena.length; i++) {
			System.out.print("[ "+arena[i][0]+", ");
			System.out.print(arena[i][1]+"] ");
		}
		System.out.println("");
	}
	
	/*
	 * @param Número de la base. Sólo hay dos en la arena.
	 * 1: base izquierda. 2: base derecha.
	 * @return Un elemento de tipo Base.	
	 */
	public Base getBase(int num){
		Base p = b1;
		if (num==1){ p=b1;}
		else if (num==2){ p=b2; }
		return p;
	}
	
	/*
	 * Cambia la era de la base.
	 */
	public void aumentarEdad(Base base){
		base.aumentarEra();
	}
	/*
	 * Agrega una unidad a la arena;
	 * Más especificamente al arreglo de unidades que contiene la información del estado de la arena.
	 */
	public void ponerUnidad(Base base,String tipo) throws PAOWException{
			
		Unidad uni = base.crearUnidad(tipo);
		int spawn=base.getSpawn();
		if (base.getOro()>= uni.getCosto()){
			System.out.println(base.getOro()+" >= "+uni.getCosto());
			base.compraUnidad(uni);
			
			if (spawn==1){arena[spawn][0]=uni;}
			else if (spawn==18){arena[spawn][1]=uni;}
		}
		
		else{
			throw new PAOWException("no hay  dinerodsfsdfsfsfsdf?????????????????????");}
		
	}
	
	public void enemyIAIngenuo() {
		Ingenuo i = Ingenuo.getIA(b2);
		//i.start(this);
		i.crearUnidad(this);
	}
	
	/*
	 * @return La instancia actual de Arena.
	 */
	public Unidad[][] getArena( ){
		return arena;
	}
	
	/*
	 * Crea una única instancia de Arena.
	 * @return La única instancia de Arena existente.
	 */
	public static Arena creeArena(){
		if (r==null){
			r=new Arena();
		}
		return r;
	}
}