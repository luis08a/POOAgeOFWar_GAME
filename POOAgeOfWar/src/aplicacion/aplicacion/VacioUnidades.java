package aplicacion;
/*
 * permite saber si en esa posicion no hay unidades, es decir que se define comno
 * una unidad vacia en la que se pueden poner los soldados
 * */
public class VacioUnidades extends Soldado {
	
	public VacioUnidades(int dir){
		super(dir,20);
		this.setTipo("vacio");
		
		}
	public String getVacio(){
		return "vacio";
	}
}
