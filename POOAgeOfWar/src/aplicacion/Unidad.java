package aplicacion;

public abstract class Unidad {
	private int vida;	
	private int ataque;
	private int ancho;
	private int posx;
	private int poslado;
	private int posLadoContrario;
	private final int posy = 400;
	private int costo;
	private int defensa;
	private int base;
	private int direc;
	private String tipo;
	private boolean isBase;
	
	/*
	 * Constructor
	 * @param dir: dirección en la cual se movera la unidad. spawn: psición inicial de cada unidad en la arena.
	 */
	public Unidad(int dir,int spawn){
		
		direc=dir;
		
		//this.setPosx(Spawn);
		//posx =Spawn;
		
		if (dir==1){base=0;poslado=1;posLadoContrario=0;posx=0;}
		else{base=1;poslado=0;posLadoContrario=1;posx=1200;}
	}
	
	
	
	/*
	 * 
	 */
	public int getDirec(){
		return direc;
	}
	public void setDirec(int dir){
		direc=dir;
	}
	public boolean getIsBase(boolean isBase) {
		return isBase;
	}
	public void setIsBase(boolean isbase) {
		isBase=isbase;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida += vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque =+ ataque;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public void mover(){
		posx=posx+60*direc;
	}
	public int getPosx() {
		return posx;
	}
	public int getPosLado(){
		return poslado;
	}
	
	//public void setPosx(int dis) {
		//System.out.println(posx+"posxxxx antes "+"direc "+dis);
		//posx =posx + dis;
		//System.out.println("despues"+ (posx+dis));
		//System.out.println(posx+"posxxxx");
	//}
	public int getPosy() {
		return posy;
	}
	/*public void setPosy(int posy) {
		this.posy =+ posy;
	}
	*/
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo =+ costo;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int def) {
		this.defensa = def;
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public void setTipo(String tip){
		tipo=tip;
	}
	public String getTipo(){
		return tipo;
	}
	public boolean estaMuerto(){
		boolean r=false;
		System.out.println(vida+" en esta muerto?");
		if(vida<=0){r=true;}
		return r;
	}
	public void recibirDano(int dano){
		System.out.println(vida+" vida antes");
		vida-=dano;
		System.out.println(vida);
	}
	//public void 
	public int posLadoContrario(){return posLadoContrario;}
	///public void moverse(int distancia){
		//System.out.println(this.getDirec()+"direc antesd de funcion");
		///this.setPosx(direc);
		
		
	//}
	public void ataque(Unidad enemigo){
		enemigo.recibirDano(ataque);
	}
	
}

