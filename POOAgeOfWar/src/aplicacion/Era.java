package aplicacion;

public  class Era {
	public Era (){
		
	}
	
	public void revisarEra(int era,Unidad s){
		if (era==2){
			if (s.getTipo()=="@"){era2M(s);}
			else if(s.getTipo()=="#"){era2T(s);}
		}
		
	}
	
	public void era2M(Unidad s){s.setVida(10);
		s.setAtaque(5);
		s.setDefensa(5);			
		s.setDevuelve(1);
		s.setCosto(15);		
	}
	
	
	public void era2T( Unidad s){s.setVida(15);
		s.setAtaque(2);
		s.setDefensa(3);	
		s.setDevuelve(1);
		s.setCosto(10);	
		}

	
}
