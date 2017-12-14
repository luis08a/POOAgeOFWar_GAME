package aplicacion;

import java.io.Serializable;

public class Arena implements Serializable{
	private static Arena r;
	private static Unidad[][] arena;
	private Base b1;
	private Base b2;
	private Jugador j1;
	private Jugador j2;
	private int time;
	
	/*
	 * Constructor.
	 */
	private Arena(){
		
		b1= new Base(1,0);
		b2=new Base(-1,1);
		
		Unidad b1Ad[]={b1,null};
		Unidad b2Ad[]={null,b2};
		
		arena=new Unidad[100][2];
		for(int i=0; i<100;i++) {
			if (i==1)arena[i]=b1Ad;
			if(i==99)arena[i]=b2Ad;
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
	
	/*
	 * Caso de jugador vs Jgador. Crea dsjugadores.
	 */
	public void jugadorVsJugador(){
		j1 = new Humano(b1);
		j2 = new Humano(b2);
	}
	
	public void jugadorVsIA(String IA){
		j1 = new Humano(b1);
		switch (IA){
		case "Tacano": j2= new Tacano(b2);
		break;
		case "Ingenuo": j2=new Ingenuo(b2);
		break;
		}	
	}
	
	public int obtDinero(int jugador){
		int din = r.getBase(jugador).getOro();
		return din;
	}

	/*
	 * Actualiza el estado de Arena, para ello hace que las unidades se muevan.
	 * */
	public void actualizar() throws PAOWException{
		time+=1;
		switch(time){
		case 15:b1.ganaOro(15);b2.ganaOro(15);time = 0;
		break;
		}
		
		for(int i =arena.length-1;i>0;i--){
			
			if (arena[i][0]==null) continue;
			
			if (i==98 && arena[i][0]!=null){
				
				arena[i][0].ataque(b2);
				
				if (b2.estaMuerto()==true){
					throw new PAOWException("Gana Jugador 1");
				}
			}
			
			else if (i<arena.length-1){
				if(arena[i][1]!=null){
					arena[i][0].ataque(arena[i][1]);
					if (arena[i][1].estaMuerto()==true){
						Base base= this.getBase(1);
						base.ganaOro(arena[i][1].getCosto());
						arena[i][1]=null;
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
			
			if (i==1&&arena[i][1]!=null){
				arena[i][1].ataque(b1);
				 if (b1.estaMuerto()==true){
						throw new PAOWException("Gana Jugador 2");}
			}
			else if (i>1){
				
				if(arena[i][0]!=null){
					arena[i][1].ataque(arena[i][0]);
					if (arena[i][0].estaMuerto()==true){
						Base base= this.getBase(2);
						base.ganaOro(arena[i][0].getCosto());
						arena[i][0]=null;
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
	public void aumentarEdad(Base base) throws PAOWException{
		base.aumentarEra();
	}
	
	/*
	 * Agrega una unidad a la arena;
	 * Más especificamente al arreglo de unidades que contiene la información del estado de la arena.
	 */
	public void ponerUnidad(Base base, Unidad u) {
		int spawn=base.getSpawn();
		base.compraUnidad(u);
		if (spawn==1){arena[spawn][0]=u;}
		else if (spawn==98){arena[spawn][1]=u;}		
	}
	
	/*
	 * @return La instancia actual de Arena.
	 */
	public Unidad[][] getArena( ){
		return arena;
	}
	
	public void reiniciarArena() {
		r = new Arena();
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
