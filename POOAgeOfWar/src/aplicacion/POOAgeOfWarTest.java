package aplicacion;


import static org.junit.Assert.*;

import org.junit.Test;

public class POOAgeOfWarTest {
	private Arena a;
	private String IA1 = "Ingenuo";
	private String IA2 = "Tacano";
	
	public  POOAgeOfWarTest() {
		a = Arena.creeArena();
	}
	
	@Test
	public void deberiaPonerUnidad() {
		Unidad[][] arr = a.getArena();
		Base b1 = a.getBase(1);
		Base b2 = a.getBase(2);
		
		Unidad u = new Melee(1, 1, 1);
		a.ponerUnidad(b1, u);
		assertTrue(arr[1][0]==u);
		a.ponerUnidad(b2, u);
		assertTrue(arr[arr.length-2][1]==u);
		
		Unidad v = new Melee(1, 1, 1);
		a.ponerUnidad(b1, v);
		assertTrue(arr[1][0]==v);
		a.ponerUnidad(b2, v);
		assertTrue(arr[arr.length-2][1]==v);
		
		a.reiniciarArena();
	}
	
	@Test
	public void deberiaAtacarOtraUnidad() {
		Unidad u1,u2;
		
		u1 = new Melee(1,1,1);
		u2 = new Melee(1,1,1);
		int s = u2.getVida() - u1.getAtaque();
		u1.ataque(u2);
		assertTrue(s == u2.getVida());
	}
	
	@Test
	public void deberiaCrearDosJugadores() {
		a.jugadorVsJugador();
		Jugador uno,dos;
		
		uno = a.getJ1();
		dos = a.getJ2();
		assertTrue(uno instanceof Humano);
		assertTrue(dos instanceof Humano);
		a.jugadorVsIA(IA1);
		uno = a.getJ1();
		dos = a.getJ2();
		assertTrue(uno instanceof Humano);
		assertTrue(dos instanceof Ingenuo);
		a.jugadorVsIA(IA2);
		uno = a.getJ1();
		dos = a.getJ2();
		assertTrue(uno instanceof Humano);
		assertTrue(dos instanceof Tacano);
		
		a.reiniciarArena();
	}
	
	@Test
	public void deberiaMeleeAvanzarEra() {
		a.jugadorVsJugador();
		Jugador uno;
		
		uno = a.getJ1();
		
		uno.getBase().ganaOro(6500);
		for (int i=2;i<=4;i++) {
			Melee m = null;
			try {
				uno.avanzarEra();
			} catch (PAOWException e1) {
				e1.printStackTrace();
			}
			try {
				m = (Melee) uno.crearSoldadoMelee();
			} catch (PAOWException e) {
				e.printStackTrace();
			}
			switch (i) {
			case 2:	assertTrue(m.getAtaque()==5);assertTrue(m.getVida()==10);assertTrue(m.getDefensa()==5);assertTrue(m.getCosto()==15);
			break;
			case 3: assertTrue(m.getAtaque()==15);assertTrue(m.getVida()==10);assertTrue(m.getDefensa()==5);assertTrue(m.getCosto()==20);assertTrue(m.getDevuelve()==2);
			break;
			case 4: assertTrue(m.getAtaque()==35);assertTrue(m.getVida()==20);assertTrue(m.getDefensa()==5);assertTrue(m.getCosto()==40);assertTrue(m.getDevuelve()==3);
			break;
			}
		}
		a.reiniciarArena();
	}
	
	@Test
	public void deberiaTanqueAvanzarEra() {
		a.jugadorVsJugador();
		Jugador uno;
		
		uno = a.getJ1();
		
		uno.getBase().ganaOro(6500);
		for (int i=2;i<=4;i++) {
			Tanque m = null;
			try {
				uno.avanzarEra();
			} catch (PAOWException e1) {
				e1.printStackTrace();
			}
			try {
				m = (Tanque) uno.crearSoldadoTanque();
			} catch (PAOWException e) {
				e.printStackTrace();
			}
			switch (i) {
			case 2:	assertTrue(m.getAtaque()==7);assertTrue(m.getVida()==15);assertTrue(m.getDefensa()==10);assertTrue(m.getCosto()==25);
			break;
			case 3: assertTrue(m.getAtaque()==30);assertTrue(m.getVida()==1);assertTrue(m.getDefensa()==10);assertTrue(m.getCosto()==20);
			break;
			case 4: assertTrue(m.getAtaque()==50);assertTrue(m.getVida()==100);assertTrue(m.getDefensa()==50);assertTrue(m.getCosto()==90);
			break;
			}
		}
		a.reiniciarArena();
	}
	
	@Test
	public void deberiaBaseAvanzarEra() {
		a.jugadorVsJugador();
		Jugador uno;
		
		uno = a.getJ1();
		Base b = uno.getBase();
		b.ganaOro(650);
		for (int i=2;i<=4;i++) {
			try {
				uno.avanzarEra();
			} catch (PAOWException e1) {
				e1.printStackTrace();
			}
			switch(i) {
			case 2: assertTrue(b.getEra()==2);
			break;
			case 3: assertTrue(b.getEra()==3);
			break;
			case 4: assertTrue(b.getEra()==4);
			break;
			}
		}
		a.reiniciarArena();
	}
}
