package presentacion;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends JDialog implements Runnable{
	private Fondo panelLogo;
	private Fondo panelOpciones;
	private Button jugar;
	private Button salir;
	
	public Menu(){
		prepareElementos();
		prepareAcciones();
	}
	
	private void prepareElementos(){
		setTitle("POOAgeOfWar");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setResizable(false);
		
		preparePanelInicioOpciones();
		preparePanelInicioLogo();
		
		add(panelLogo);
		add(panelOpciones);
	}
	
	private void preparePanelInicioLogo(){
		panelLogo = new Fondo("/recursos visuales/AgeOfWar logo.jpg");
		panelLogo.setBounds(0,0,400,100);
		
	}
	
	public void run() {
		
	}
	private void preparePanelInicioOpciones(){
		panelOpciones = new Fondo("/recursos visuales/background0.png");
			
		panelOpciones.setBounds(0,100,400,300);
		panelOpciones.setLayout(null);
		
		jugar = new Button("JUGAR");
		salir = new Button("SALIR");
		
		jugar.setBounds(150, 50, 100, 50);
		salir.setBounds(150, 100, 100, 50);
		
		panelOpciones.add(jugar);
		panelOpciones.add(salir);
	}
	
	private void prepareAcciones(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		ActionListener oyenteBotonJugar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				POOAgeOfWarGUI.cargarTablero();
			}
		};
		
		ActionListener oyenteBotonSalir = new ActionListener(){
			public void actionPerformed(ActionEvent e) {salir();}
		};
		
		jugar.addActionListener(oyenteBotonJugar);
		salir.addActionListener(oyenteBotonSalir);
	}
	
	private void salir() {
		int choose = JOptionPane.showConfirmDialog(null, "¿ Desea salir ?");
		if(choose == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
}
