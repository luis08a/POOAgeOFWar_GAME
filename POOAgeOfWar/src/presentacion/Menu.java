package presentacion;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Menu extends JDialog{
	private JPanel panelLogo;
	private JPanel panelOpciones;
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
		
		preparePanelInicioOpciones();
		preparePanelInicioLogo();
		
		add(panelLogo);
		add(panelOpciones);
	}
	
	private void preparePanelInicioLogo(){
		panelLogo = new JPanel();
		panelLogo.setBackground(java.awt.Color.white);
		panelLogo.setBounds(0,0,400,100);
		
	}
	
	private void preparePanelInicioOpciones(){
		panelOpciones = new JPanel();
		panelOpciones.setBounds(100,100,200,200);
		panelOpciones.setLayout(new GridLayout(2,1));
		
		jugar = new Button("JUGAR");
		salir = new Button("SALIR");
		
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
