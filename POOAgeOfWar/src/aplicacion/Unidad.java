package aplicacion;

import java.io.Serializable;

public abstract class Unidad implements Serializable{
	private int vida;
	private int ataque;
	private int posx;
	private final int posy = 400;
	private int costo;
	private int defensa;
	private int base;
	private int direc;
	private String tipo;
	private int devuelve;
	protected int era=1;
	protected int delta = 65;
	
	/*
	 * Constructor
	 * @param dir: dirección en la cual se movera la unidad. spawn: psición inicial de cada unidad en la arena.
	 */
	public Unidad(int dir,int spawn){
		direc=dir;
		if (dir==1){base=0;posx=0;}
		else{base=1;posx=1200;}
	}
	
	/*
	 * @return  direc: dirección de la unidad.
	 */
	public int getDirec(){return direc;}
	
	/*
	 * @param dir: nueva dirección.
	 */
	public void setDirec(int dir){direc=dir;}
	
	/*
	 * @return vida: cantidad de vida actual.
	 */
	public int getVida() {return vida;}
	
	/*
	 *@param vida: nueva cantidad de vida. 
	 */
	public void setVida(int vida) {this.vida += vida;}
	
	/*
	 * @return ataque: cantidad daño que realiza la unidad.
	 */
	public int getAtaque() {return ataque;}
	
	/*
	 * @param  ataque: nueva cantidad de daño.
	 */
	public void setAtaque(int ataque) {this.ataque =+ ataque;}
	
	/*
	 * Aumenta la posicion en el eje x de la unidad.
	 */
	public void mover(){posx+=(delta*direc);}
	
	/*
	 * @return posx: posición en el eje x.
	 */
	public int getPosx() {return posx;}
	
	/*
	 *@return posy: posición en el eje y. 
	 */
	public int getPosy() {return posy;}
	
	/*
	 * @return costo: oro necesario para crear la unidad.
	 */
	public int getCosto() {return costo;}
	
	/*
	 * @param costo: nuevo valor para la creación de la unidad.
	 */
	public void setCosto(int costo) {this.costo =+ costo;	}
	
	/*
	 * @return defensa: defensa actul de la unidad.
	 */
	public int getDefensa() {return defensa;}
	
	/*
	 * @param def: nuevo valor para la defensa de la unidad.
	 */
	public void setDefensa(int def) {this.defensa = def;}
	
	/*
	 *@return base: base a la cual pertenece la unidad.
	 */
	public int getBase() {return base;}
	
	/*
	 * @param tip nuevo tipo para la unidad.
	 */
	public void setTipo(String tip){tipo=tip;}
	
	/*
	 * @return tipo tipo de unidad.
	 */
	public String getTipo(){ return tipo;}
	
	/*
	 * @param d nueva cantidad de oro que devuelve una unidad tras su muerte.
	 */
	public void setDevuelve(int d){devuelve=d; }
	
	/*
	 * @return devuelve cantidad de oro que devuelve la unidad al morir.
	 */
	public int getDevuelve(){ return devuelve; }
	
	/*
	 * @return r indica si está vivo o no la unidad.
	 */
	public boolean estaMuerto(){
		boolean r=false;
		if(vida<=0){r=true;}
		return r;
	}
	
	/*
	 * @param dano cantidad de daño sufrido.
	 */
	public void recibirDano(int dano) { vida-=dano;	}
	
	/*
	 * @param n nueva era, nivel de desarrollo, en el que se encuetra la unidad.
	 */
	public void setEra(int n) { era = n;}
	
	/*
	 * @return era nivel de desarrollo actual.
	 */
	public int getEra() {return era;}
	
	/*
	 * Ataca a una unidad
	 * @param enemigo Unidad a atacar 
	 */
	public void ataque(Unidad enemigo){enemigo.recibirDano(ataque);}
}

