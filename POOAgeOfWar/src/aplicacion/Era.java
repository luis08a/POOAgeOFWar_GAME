package aplicacion;

public  class Era {
	public static final int MAX_ERA = 4; 
	private int era;
	
	public Era (){
		era=1;
	}
	public int eraActual(){
		return era;
	}
	
	public void aumentarEra() {
		if (era<MAX_ERA) {
			era+=1;
		}
	}
}
