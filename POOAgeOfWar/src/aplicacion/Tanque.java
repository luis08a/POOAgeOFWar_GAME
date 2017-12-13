package aplicacion;

public class Tanque extends Soldado {
	public Tanque(int dir,int spawn, int era){
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
		else if (era ==3){
			tankE3();
		}
		else if (era ==4){
			tankE4();
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
	
	public void tankE3(){
		this.setVida(1);
		this.setAtaque(30);
		this.setDefensa(10);	
		this.setDevuelve(3);
		this.setCosto(20);	
	}
	
	public void tankE4(){
		this.setVida(100);
		this.setAtaque(50);
		this.setDefensa(50);	
		this.setDevuelve(4);
		this.setCosto(90);	
	}
		
		
		
		
		
		
	}

