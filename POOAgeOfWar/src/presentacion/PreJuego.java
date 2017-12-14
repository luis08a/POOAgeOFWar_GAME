package presentacion;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PreJuego extends JDialog {
	public static PreJuego pj;
	private int height = 400;
	private int width = 400;
	private JPanel panelOpciones;
	private JComboBox combo;
	private JButton jcj;
	private JButton ia;
	private JPanel panelNombre;
	
	
	/*
	 * Constructor.
	 */
	public PreJuego() {
		setTitle("POOAgeOfWar");
		setBackground(Color.WHITE);
		setResizable(false);
		setSize(width,height);
		setLocationRelativeTo(null);
		setLayout(null);
		
		prepareElementos();
		prepareAcciones();
		setVisible(true);
	}
	
	/*
	 * Prepara los elemntos visuales de la ventana.
	 */
	private void prepareElementos() {
		panelNombre();
		panelOpciones();
		
	}
	
	/*
	 * 
	 */
	private void panelNombre() {
		panelNombre =  new JPanel();
		panelNombre.setBounds(125, 50, 100, 50);
		panelNombre.setLayout(new GridLayout(2,1));
		
		JLabel n = new JLabel("\t Tú nombre:");
		TextArea ta = new TextArea();
		
		panelNombre.add(n);
		panelNombre.add(ta);
		
		add(panelNombre);
	}
	
	/*
	 * 
	 */
	private void panelOpciones() {
		
		panelOpciones = new JPanel();
		panelOpciones.setLayout(new GridLayout(3,1));
		panelOpciones.setBounds(125, 100, 150, 200);
		
		JLabel s = new JLabel("\t Contra quien desea Jugar");
		combo=new JComboBox();
		combo.addItem("Selecione:");
		combo.addItem("Jugador");
		combo.addItem("Ingenuo");
		combo.addItem("Tacaño");
				
		panelOpciones.add(s);
		panelOpciones.add(combo);
		
		
		add(panelOpciones);
	}
	
	/*
	 * 
	 */
	private void prepareAcciones() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ItemListener oyenteCombo=new ItemListener(){
			private String sel;

			public void itemStateChanged(ItemEvent e){
				if (e.getStateChange() == ItemEvent.SELECTED) {
					sel=(String) combo.getSelectedItem();
				}
				
				else if(e.getStateChange() == ItemEvent.DESELECTED){
					sel=(String) combo.getSelectedItem();
					switch(sel) {
					case "Jugador": POOAgeOfWarGUI.cargarTablero(null);
					break;
					case "Ingenuo": POOAgeOfWarGUI.cargarTablero("Ingenuo");
					break;
					case "Tacaño": POOAgeOfWarGUI.cargarTablero("Tacano");
					break;
					}
				}
		}};
		combo.addItemListener(oyenteCombo);
		
		
	}
	
	/*
	 * @return la única instancia de PreJuego 
	 */
	public static PreJuego getPreJuego() {
		if (pj==null)pj= new PreJuego();
		return pj;
	}
}
