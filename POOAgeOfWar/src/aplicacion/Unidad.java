package aplicacion;

public abstract class Unidad {
	private int vida;	
	private int ataque;
	private int ancho;
	private int posx;
	private int posy;
	private int costo;
	private int defensa;
	private int base;
	private int direc;
	private String tipo;
	private boolean isBase;
	
	
	public Unidad(int dir,int Spawn){
		System.out.println(direc+"direc en unidad antesA");
		direc=dir;
		System.out.println(direc+"direc en unidad");
		posx =Spawn;
		System.out.println(posx+" spawn p x");
	 }
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
	public int getPosx() {
		return posx;
	}
	public void setPosx(int dis) {
		System.out.println(posx+"posxxxx antes"+"direc"+dis);
		this.posx =+ dis;
		System.out.println(posx+"posxxxx");
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy =+ posy;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo =+ costo;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa =+ defensa;
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
	
	public void recibirDano(int dano){
		vida-=dano;
	}
	public void moverse(int distancia){
		System.out.print(this.getDirec()+"direc antesd de funcion");
		this.setPosx(direc);
		
		
	}
	public void isBase(){
		
	}
	
}

