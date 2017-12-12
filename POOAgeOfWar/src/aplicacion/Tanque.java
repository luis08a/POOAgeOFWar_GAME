package aplicacion;

public class Tanque extends Soldado {
	public Tanque(int dir,int spawn){
		super(dir,spawn);
		this.setRangoAtaque(0);
		this.setDirec(dir);
		
		this.setTipo("#");
		if (era ==1){
			tankE1();
		}
		else if (era ==2){
			tankE2();
		}
		
		
	}
	
	public void tankE1(){
		
		this.setVida(15);
		this.setAtaque(2);
		this.setDefensa(3);				
		this.setDevuelve(1);
		this.setCosto(10);
		
		
	}
	public void tankE2(){
		this.setVida(15);
		this.setAtaque(7);
		this.setDefensa(10);	
		this.setDevuelve(2);
		this.setCosto(25);	
	}
		
		
		
		
		
		
		
	}

