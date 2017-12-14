package presentacion;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends JDialog{
	private Fondo panelOpciones;
	private Button jugar;
	private Button salir;
	
	public Menu(){
		prepareElementos();
		prepareAcciones();
		setVisible(true);
	}
	
	private void prepareElementos(){
		setTitle("POOAgeOfWar");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setLayout(null);
		
		setResizable(false);
		
		preparePanelInicioOpciones();
		add(panelOpciones);
	}
	
	private void preparePanelInicioOpciones(){
		panelOpciones = new Fondo("/recursos visuales/Logo.png");
			
		panelOpciones.setBounds(0,0,400,400);
		panelOpciones.setLayout(null);
		
		jugar = new Button("JUGAR");
		salir = new Button("SALIR");
		
		jugar.setBounds(0, 50, 100, 50);
		salir.setBounds(0, 200, 100, 50);
		
		panelOpciones.add(jugar);
		panelOpciones.add(salir);
	}
	
	private void prepareAcciones(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		ActionListener oyenteBotonJugar = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				POOAgeOfWarGUI.cargarPJ();
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
